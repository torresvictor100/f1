// Chakra imports
import { Avatar, Box,StatLabel, Flex, FormLabel,Text, Select, SimpleGrid,useStyleConfig, useColorModeValue } from '@chakra-ui/react';
// Custom components
import Card from 'components/card/Card';
import LineChart from 'components/charts/LineChart';
import { MdBarChart, MdOutlineCalendarToday } from 'react-icons/md';
// Assets

import { lineChartDataTotalSpent, lineChartOptionsTotalSpent } from 'variables/charts';
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
  }

export default function TotalSpent(props: { [x: string]: any }) {
	const { ...rest } = props;

	// Chakra Color Mode

	const textColor = useColorModeValue('secondaryGray.900', 'white');
	const textColorSecondary = useColorModeValue('secondaryGray.600', 'white');
	const boxBg = useColorModeValue('secondaryGray.300', 'whiteAlpha.100');
	const iconColor = useColorModeValue('brand.500', 'white');
	const bgButton = useColorModeValue('secondaryGray.300', 'whiteAlpha.100');
	const bgHover = useColorModeValue({ bg: 'secondaryGray.400' }, { bg: 'whiteAlpha.50' });
	const bgFocus = useColorModeValue({ bg: 'secondaryGray.300' }, { bg: 'whiteAlpha.100' });

	const baseUrl = "http://localhost:8080/f1-graphics/seasons/season-drivers-ids/2021?listDriversIdRequestDTO=max_verstappen";
	const [dataLoaded, setDataLoaded] = useState(false);
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
		}
	);


	useEffect(() => {
		axios(baseUrl)
		  .then((resp) => {
			const season2 = resp.data;
			setSeason(season2);
		  })
		  .finally(() => setDataLoaded(true)); // Define o estado para true após a conclusão da requisição
	  }, []);

	  console.log(season)
	return (
		<Card justifyContent='center' alignItems='center' flexDirection='column' w='100%' mb='0px' {...rest}>
			<Text color={textColor} fontSize='54px' textAlign='start' fontWeight='700' lineHeight='100%'>
						Comparation Drivers
					</Text>
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Text fontSize='34px' color='secondaryGray.600' mt='12px' me='0px'>2008</Text>
							</FormLabel>
							<Select id='balance' variant='mini' mt='15px' me='0px' defaultValue='usd'>
							</Select>
						</Flex>
			<Flex w='100%' flexDirection={{ base: 'column', lg: 'row' }}>
				<Box minH='400px' minW='95%' mt='auto'>
					<LineChart chartData={lineChartDataTotalSpent} chartOptions={lineChartOptionsTotalSpent} />
				</Box>
			</Flex>
			<SimpleGrid columns={{ base: 1, md: 2, lg: 3, '2xl': 6 }} gap='20px' mb='20px'>
			<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={Hamiton} />
							</FormLabel>
							<Select id='balance' variant='mini' mt='5px' me='0px' defaultValue='usd'>
							</Select>
						</Flex>
					}
					title="Ferrari"
					name='Season'
					value='L.Hamiton'
				/>
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
							<FormLabel htmlFor='balance'backgroundColor={'###'}>
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
