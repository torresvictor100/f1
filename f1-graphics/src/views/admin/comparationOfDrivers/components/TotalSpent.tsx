import { Box, Flex, Text, useColorModeValue } from '@chakra-ui/react';

import Card from 'components/card/Card';
import SelectComponent from './SelectComponentDrivers';
import LineGraph from './LineGraph'
import axios from "axios";
import React, { useState, useEffect } from "react";

import {
	SeasonInfo,
	DriverPoints,
	Driver,
	DriversResponse,
  } from  './Interfaces';



export default function TotalSpent(props: { [x: string]: any }) {
	const { ...rest } = props;

	const textColor = useColorModeValue('secondaryGray.900', 'white');
	const [selectedPilots, setSelectedPilots] = useState<string[]>([]);

	const [raceSeasonName, setRaceSeasonName] = useState<string[]>([]);
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
			}],
			listNamesRacesResponseDTO: []
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
		axios.get<DriversResponse>(`http://ergast.com/api/f1/${selectYears}/drivers.json?limit=150`)
			.then((response) => {
				const data = response.data;
				const drivers = data.MRData.DriverTable.Drivers;

				const driverOptions = drivers.map((driver: Driver) => ({
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
				console.log(resp.data.listNamesRacesResponseDTO.listNamesRacesDTO)
				setRaceSeasonName(resp.data.listNamesRacesResponseDTO.listNamesRacesDTO)
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
			],
			listNamesRacesResponseDTO: []
		});

		setLoading("Select the years");

	};


	const lineChartOptionsTotalSpent: any = {
		chart: {
			toolbar: {
				show: true
			},
			dropShadow: {
				enabled: true,
				top: 13,
				left: 0,
				blur: 10,
				opacity: 0.1,
				color: '#000'
			}
		},
		colors: ['#a60203', '#ff8000'], //linhda dos piloto		
		title: {
			text: 'Meu Gráfico',
			align: 'center',
			margin: 10,
			offsetX: 0,
			offsetY: 0,
			floating: false,
			style: {
				fontSize: '20px',
				fontWeight: 'bold',
				fontFamily: undefined,
				color: '#fff'
			}
		},
		tooltip: {
			theme: 'dark-dual',
			style: {
				color: '#000', // Cor do texto da dica de ferramenta (preto)
			},
		},
		dataLabels: {
			enabled: false
		},
		stroke: {
			curve: 'smooth',
			type: 'line'
		},
		xaxis: {
			type: 'numeric',
			categories: ["0", "Australian Grand Prix",
				"Malaysian Grand Prix",
				"Bahrain Grand Prix",
				"Spanish Grand Prix",
				"Turkish Grand Prix",
				"Monaco Grand Prix",
				"Canadian Grand Prix",
				"French Grand Prix",
				"British Grand Prix",
				"German Grand Prix",
				"Hungarian Grand Prix",
				"European Grand Prix",
				"Belgian Grand Prix",
				"Italian Grand Prix",
				"Singapore Grand Prix",
				"Japanese Grand Prix",
				"Chinese Grand Prix",
				"Brazilian Grand Prix"],
			labels: {
				style: {
					colors: '#fff', //cor da lebols
					fontSize: '12px',
					fontWeight: '500'
				}
			},
			axisBorder: {
				show: false
			},
			axisTicks: {
				show: false
			}
		},
		yaxis: {
			show: true
		},
		legend: {
			show: false
		},
		grid: {
			show: true,
			column: {
				color: ['#7551FF', '#39B8FF'],
				opacity: 0.5
			}
		}
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
					{dataLoaded && <LineGraph chartData={driverPointsList} chartOptions={lineChartOptionsTotalSpent} />}
				</Box>
			</Flex>

		</Card>
	);
}
