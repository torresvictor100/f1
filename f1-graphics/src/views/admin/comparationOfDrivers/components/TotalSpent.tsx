import { Avatar, Box, Flex, FormLabel, Text, Select, SimpleGrid, useColorModeValue } from '@chakra-ui/react';

import Card from 'components/card/Card';
import LineChart from 'components/charts/LineChart';
import SelectComponent from './SelectComponentDrivers';
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

interface Driver {
	driverId: string;
	permanentNumber: string;
	code: string;
	url: string;
	givenName: string;
	familyName: string;
	dateOfBirth: string;
	nationality: string;
}

interface DriverTable {
	season: string;
	Drivers: Driver[];
}

interface MRData {
	xmlns: string;
	series: string;
	url: string;
	limit: string;
	offset: string;
	total: string;
	DriverTable: DriverTable;
}

interface DriversResponse {
	MRData: MRData;
}
export default function TotalSpent(props: { [x: string]: any }) {
	const { ...rest } = props;

	const textColor = useColorModeValue('secondaryGray.900', 'white');
	const [selectedPilots, setSelectedPilots] = useState<string[]>([]);

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
	const [selectYears, setSelectYears] = useState<string>("2023");
	const [loading, setLoading] = useState("Select the years");

	const [urlSeason, setUrlSeason] = useState("Select the years");
	const [loadingDriver, setLoadingDriver] = useState(`http://localhost:8080/f1-graphics/seasons/season-drivers-ids/${selectYears}?`);
	const [dataLoadedDriver, setDataLoadedDriver] = useState(false);
	const [driverOptions, setDriverOptions] = useState<{ label: string; value: string }[]>([]);
	const [cleanClicked, setCleanClicked] = useState(false);

	const [driverSelect, setDriverSelect] = useState<string[]>([]);

	useEffect(() => {
		const currentYear = new Date().getFullYear();
		const availableYears = Array.from({ length: currentYear - 1949 }, (_, index) => (currentYear - index).toString());
		setYears(availableYears);
		fetchDataDriver(selectYears)
	}, []);

	const handleYearChange = (event: React.ChangeEvent<HTMLSelectElement>) => {

		setSelectYears(event.target.value);
		fetchDataDriver(event.target.value);


	};

	const fetchDataDriver = (selectYears: string) => {
		setLoadingDriver('Loading...');
		console.log("perto do acio"+selectYears)
		axios.get<DriversResponse>(`http://ergast.com/api/f1/${selectYears}/drivers.json?limit=150`)
			.then((response) => {
				const data = response.data;
				const drivers = data.MRData.DriverTable.Drivers;

				const driverOptions = drivers.map((driver) => ({
					label: `${driver.givenName} ${driver.familyName}`,
					value: driver.driverId,
				}));
				
				setDriverOptions(driverOptions);
			})
			.catch((error) => {
				console.error(error);
			})
			.finally(() => setDataLoadedDriver(true));
	};

	const handlePilotsSelected = (pilots: string[]) => {
		setSelectedPilots(pilots);
	};

	const fetchData = (updatedUrlSeason: string) => {
		setLoading('Loading...');

		axios(updatedUrlSeason)
			.then((resp) => {
				setSeason(resp.data);
				SetDriverPointsList(resp.data.driverPoints);
			})
			.finally(() => setDataLoaded(true));

		setLoading('');
	};



	const handleButtonClick = () => {

		const nonEmptyPilots = selectedPilots.filter((pilot) => pilot.trim() !== '');

		if (nonEmptyPilots.length > 0) {
			const pilotsQueryString = nonEmptyPilots.map((pilot) => `listDriversIdRequestDTO=${pilot}`).join('&');

			const updatedUrlSeason = `http://localhost:8080/f1-graphics/seasons/season-drivers-ids/${selectYears}?${pilotsQueryString}`;

			setUrlSeason(updatedUrlSeason)
			fetchData(updatedUrlSeason);
		} else {
			console.log("No pilots selected. Skipping fetchData.");
		}
	};

	const handleCleanClick = () => {
		setCleanClicked(true);

		setDataLoaded(false);
		SetDriverPointsList([
		  {
			name: "",
			data: ["", ""]
		  }
		]);
		setSeason({
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
		  driverPoints: [
			{
			  name: "",
			  data: [""]
			}
		  ]
		});

	
		setLoading("Select the years");

	  };
	  

	return (
		<Card justifyContent='center' alignItems='center' flexDirection='column' w='100%' mb='0px' {...rest}>

			<Text color={textColor} fontSize='54px' textAlign='start' fontWeight='700' lineHeight='100%'>
				Comparation Drivers
			</Text>
			<Flex mt='10px' color={textColor} textAlign='start' fontWeight='700' lineHeight='100%' justifyContent='flex-start'>
				<label htmlFor="yearSelect"></label>
				<select id="yearSelect" onChange={handleYearChange} style={{ fontSize: '18px', padding: '8px' }}>
					{years.map((year) => (
						<option key={year} value={year}>
							{year}
						</option>
					))}
				</select>
			</Flex>

			<SelectComponent options={driverOptions} onPilotsSelected={handlePilotsSelected} />

			<Flex mt="10px">
				<Box color={textColor} fontSize="25px" textAlign="start" fontWeight="700" lineHeight="100%" borderWidth="2px" borderStyle="solid" borderColor={textColor} borderRadius="md" p="4" background="#f4f7fe">
					<button onClick={handleButtonClick}>Search</button>
				</Box>
				<Box ml="10px" color={textColor} fontSize="25px" textAlign="start" fontWeight="700" lineHeight="100%" borderWidth="2px" borderStyle="solid" borderColor={textColor} borderRadius="md" p="4" background="#f4f7fe">
					<button onClick={handleCleanClick}>Clean</button>
				</Box>
			</Flex>


			<Flex w='100%' flexDirection={{ base: 'column', lg: 'row' }}>
				<Box minH='400px' minW='95%' mt='auto'>
					<Text color={textColor} fontSize='30px' textAlign='start' fontWeight='700' lineHeight='100%'>
						{loading && <p>{loading}</p>}
					</Text>
					{dataLoaded && <LineChart chartData={driverPointsList} chartOptions={lineChartOptionsTotalSpent} />}
				</Box>
			</Flex>

		</Card>
	);
}
