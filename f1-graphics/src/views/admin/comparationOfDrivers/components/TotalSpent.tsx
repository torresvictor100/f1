import { Avatar, Box, Flex, FormLabel, Text, Select, SimpleGrid, useColorModeValue } from '@chakra-ui/react';

import Card from 'components/card/Card';
import LineChart from 'components/charts/LineChart';

import { lineChartOptionsTotalSpent } from 'variables/charts';
import Hamiton from 'assets/img/comparationOfDrivers/Hamiton.jpg';
import Massa from 'assets/img/comparationOfDrivers/Massa.jpg';
import Soma from 'assets/img/comparationOfDrivers/Soma.jpg';
import MiniStatisticsTitle from 'components/card/MiniStatisticsTitle'
import MiniStatistics from 'components/card/MiniStatistics'

import axios from "axios";
import React, { useState, useEffect } from "react";

interface Location {
	lat: string;
	locality: string;
	country: string;
}

interface Circuit {
	circuitId: string;
	url: string;
	circuitName: string;
	Location: Location;
}

interface Time {
	time: string;
}

interface AverageSpeed {
	units: string;
	speed: string;
}

interface FastestLap {
	rank: string;
	lap: string;
	Time: Time;
	AverageSpeed: AverageSpeed;
}

interface Constructor {
	constructorId: string;
	url: string;
	name: string;
	nationality: string;
}

interface ResultSeaseon {
	raceName: string;
	pointsSeason: number;
	pointsSeasonRaces: number;
	pointsSeasonSprintRaces: number;
}

interface ResultRace {
	position: string;
	points: string;
	Time: Time;
	FastestLap: FastestLap;
}

interface DriversResults {
	driverId: string;
	url: string;
	givenName: string;
	dateOfBirth: string;
	nationality: string;
	Constructor: Constructor;
	ResultSeaseon: ResultSeaseon;
	ResultRace: ResultRace;
}

interface RaceSeason {
	round: string;
	url: string;
	raceName: string;
	date: string;
	time: string;
	Circuit: Circuit;
	DriversResults: DriversResults[];
}

interface SeasonInfo {
	season: string;
	totalGPs: string;
	raceSeason: RaceSeason[];
	driverPoints: DriverPoints[]
}

interface DriverPoints {
	name: string,
	data: string[]
}

export default function TotalSpent(props: { [x: string]: any }) {
	const { ...rest } = props;

	const textColor = useColorModeValue('secondaryGray.900', 'white');

	
	const [dataLoaded, setDataLoaded] = useState(false);
	const [driverPointsList, SetDriverPointsList] = useState<DriverPoints[]>([
		{
			name: "",
			data: [
				"", ""
			]
		}
	])
	const [season, setSeason] = useState<SeasonInfo>(
		{
			season: "",
			totalGPs: "",
			raceSeason: [
				{
					round: "",
					url: "",
					raceName: "",
					date: "",
					time: "",
					Circuit: {
						circuitId: "",
						url: "",
						circuitName: "",
						Location: {
							lat: "",
							locality: "",
							country: "",
						},
					},
					DriversResults: [
						{
							driverId: "",
							url: "",
							givenName: "",
							dateOfBirth: "",
							nationality: "",
							Constructor: {
								constructorId: "",
								url: "",
								name: "",
								nationality: "",
							},
							ResultSeaseon: {
								raceName: "",
								pointsSeason: 0,
								pointsSeasonRaces: 0,
								pointsSeasonSprintRaces: 0,
							},
							ResultRace: {
								position: "",
								points: "",
								Time: {
									time: "",
								},
								FastestLap: {
									rank: "",
									lap: "",
									Time: {
										time: "",
									},
									AverageSpeed: {
										units: "",
										speed: "",
									},
								},
							},
						},
					],
				},
			],
			driverPoints: [{
				name: "",
				data: [""]
			}]
		}
	);
	const [years, setYears] = useState<string[]>([]);
	const [selectYears, setSelectYears] = useState<string>();
	const baseUrl = `http://localhost:8080/f1-graphics/seasons/season-drivers-ids/${selectYears}?listDriversIdRequestDTO=hamilton`;
	const [carregando, setCarregando] = useState("Click in seach");

	useEffect(() => {
		const currentYear = new Date().getFullYear();
		const availableYears = Array.from({ length: currentYear - 1949 }, (_, index) => (currentYear - index).toString());
		setYears(availableYears);
	}, []);

	const handleYearChange = (event: React.ChangeEvent<HTMLSelectElement>) => {

		setSelectYears(event.target.value);
	};

	const fetchData = () => {
		setCarregando('Carregando...');
		axios(baseUrl)
			.then((resp) => {
				setSeason(resp.data);
				SetDriverPointsList(resp.data.driverPoints);
			})
			.finally(() => setDataLoaded(true));
		setCarregando('');
	};

	const handleButtonClick = () => {
		fetchData();
	};


	return (
		<Card justifyContent='center' alignItems='center' flexDirection='column' w='100%' mb='0px' {...rest}>
			<Text color={textColor} fontSize='54px' textAlign='start' fontWeight='700' lineHeight='100%'>
				Comparation Drivers
			</Text>
			<button onClick={handleButtonClick}>Seach</button>
			<Flex me='-16px' mt='10px'>
				<label htmlFor="yearSelect"></label>
				<select id="yearSelect" onChange={handleYearChange}>
					{years.map((year) => (
						<option key={year} value={year}>
							{year}
						</option>
					))}
				</select>
			</Flex>
			<Flex w='100%' flexDirection={{ base: 'column', lg: 'row' }}>
				<Box minH='400px' minW='95%' mt='auto'>
					{carregando && <p>{carregando}</p>}
					{dataLoaded && <LineChart chartData={driverPointsList} chartOptions={lineChartOptionsTotalSpent} />}
				</Box>
			</Flex>
			<SimpleGrid columns={{ base: 1, md: 2, lg: 3, '2xl': 6 }} gap='20px' mb='20px'>
				<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={Massa} />
							</FormLabel>
							<Select id='balance' variant='mini' mt='5px' me='0px' defaultValue='usd'>
							</Select>
						</Flex>
					}
					title="McLaren"
					name='2º'
					value='Massa'
				/>
				<MiniStatistics
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance' backgroundColor={'###'}>
								<Avatar src={Soma} />
							</FormLabel>
						</Flex>
					}
					name=''
					value=''
				/>
			</SimpleGrid>
		</Card>
	);
}
