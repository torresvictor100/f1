import { Avatar, Box, StatLabel, Flex, FormLabel, Text, Icon, Select, SimpleGrid, useStyleConfig, useColorModeValue } from '@chakra-ui/react';

import axios from "axios";
import React, { useState, useEffect } from "react";
import MiniStatisticsGrafic from 'components/card/MiniStatisticsTitle'
import MAX from 'assets/img/DriversImage/max_verstappen.jpg';
import RBR from 'assets/img/comparationOfDrivers/Red-Bull-logo.jpg';
import ConstructorStandingsStatic from './ConstructorStandingsStatic';
import DriverStandingsStatic from './DriverStandingsStatic'; 




type DriverStanding = {
  position: string;
  positionText: string;
  points: string;
  wins: string;
  Driver: {
    url: string;
    code: string;
    permanentNumber: string;
    givenName: string;
    familyName: string;
    dateOfBirth: string;
    nationality: string;
    driverId: string;
  };
  Constructors: Array<{
    constructorId: string;
    url: string;
    name: string;
    nationality: string;
  }>;
};

interface Race {
  season: string;
  raceName: string;
  Results: {
    Constructor: {
      name: string;
      nationality: string;
    };
  }[];
}

type ConstructorStanding = {
  position: string;
  positionText: string;
  points: string;
  wins: string;
  Constructor: {
    constructorId: string;
    url: string;
    name: string;
    nationality: string;
  };
};

interface ConstructorState {
  season: string;
  round: string;
  ConstructorStandings: ConstructorStanding[];
}

interface State {
  season: string;
  list: Race[];
  results: {
    name: string;
    nationality: string;
  };
}

export default function Default(props: {}) {
  const baseUrl = "http://localhost:8080/f1-graphics/driverstandings/";
  const baseUrlContructios = "http://localhost:8080/f1-graphics/constructorstandings/";
  const [constructionLeader, setConstructionLeader] = useState<ConstructorStanding>({
    position: "",
    positionText: "",
    points: "",
    wins: "",
    Constructor: {
      constructorId: "",
      url: "",
      name: "",
      nationality: ""
    }
  });

  const [listConstruction, setListConstruction] = useState<ConstructorState>({
    season: "",
    round: "",
    ConstructorStandings: [{
      position: "",
      positionText: "",
      points: "",
      wins: "",
      Constructor: {
        constructorId: "",
        url: "",
        name: "",
        nationality: ""
      }
    }]
  });

  const [constructorStandingsList, setConstructorStandingsList] = useState<ConstructorStanding[]>([
    {
      position: "",
      positionText: "",
      points: "",
      wins: "",
      Constructor: {
        constructorId: "",
        url: "",
        name: "",
        nationality: ""
      }
    }
  ]);

  const [driverLeader, setDriverLeader] = useState({
    position: "",
    positionText: "",
    points: "",
    wins: "",
    Driver: {
      url: "",
      code: "",
      permanentNumber: "",
      givenName: "",
      familyName: "",
      dateOfBirth: "",
      nationality: "",
      driverId: "",
    },
    Constructors: [],
  });

  const [listDriverStanding, setDriverStanding] = useState<DriverStanding[]>([
	{position: "",
    positionText: "",
    points: "",
    wins: "",
    Driver: {
      url: "",
      code: "",
      permanentNumber: "",
      givenName: "",
      familyName: "",
      dateOfBirth: "",
      nationality: "",
      driverId: "",
    },
    Constructors: [],}
  ]);


  const [dataLoadedDrivers, setDataLoadedDrivers] = useState(false); 
  const [dataLoadedContructios, setDataLoadedContructios] = useState(false); 

  useEffect(() => {
    axios(baseUrl)
      .then((resp) => {
        const driverStandings = resp.data[0].DriverStandings;
        setDriverStanding(driverStandings);
        const drivers = driverStandings[0];
        setDriverLeader(drivers);
      })
      .finally(() => setDataLoadedDrivers(true)); // Define o estado para true após a conclusão da requisição

    axios(baseUrlContructios)
      .then((resp) => {
        const listConstructors = resp.data[0].ConstructorStandings;
        const constructors = resp.data[0].ConstructorStandings[0];
        setConstructorStandingsList(listConstructors);
        setConstructionLeader(constructors);
        setListConstruction(listConstructors);
      })
      .finally(() => setDataLoadedContructios(true)); // Define o estado para true após a conclusão da requisição
  }, []);

  if (!dataLoadedDrivers || !dataLoadedContructios) {
    return <div>Loading...</div>; // Pode exibir um indicador de carregamento enquanto os dados estão sendo carregados
  }

 

  return (
	
    <Box pt={{ base: '130px', md: '80px', xl: '80px' }} >
		<Text fontSize="2xl" fontWeight="bold" textAlign="left" p="-0.5" color={"#1B2559"} >
	Season 2023
</Text>
      <SimpleGrid mb='50px'  columns={{ base: 1, md: 2, lg: 3, '2xl': 6 }} gap='20px' >

        <MiniStatisticsGrafic
          endContent={
            <Flex me='-16px' mt='10px'>
              <FormLabel htmlFor='balance'>
                <Avatar src={MAX} />
              </FormLabel>
            </Flex>
          }
          title="Driver Leader"
          name={driverLeader.Driver.givenName +" " + driverLeader.Driver.familyName}
          value={driverLeader.points}  />
        <MiniStatisticsGrafic
          endContent={
            <Flex me="-16px" mt="10px">
              <FormLabel htmlFor="balance">
                <Avatar src={RBR} />
              </FormLabel>
            </Flex>
          }
          title="Constructor Leader"
          name={`${constructionLeader.Constructor.name || 'N/A'}`}
          value={`${constructionLeader.points || 'N/A'}`}
        />
		<div style={{  }}> 
    <ConstructorStandingsStatic constructorStandings={constructorStandingsList} />
  </div>
  <div style={{  marginLeft: '95px', width: 'calc(100% + 10px)'  }}> {/* Add margin-right for spacing */}
    <DriverStandingsStatic driverStandings={listDriverStanding} />
  </div>
      </SimpleGrid>
    </Box>
  );
}
