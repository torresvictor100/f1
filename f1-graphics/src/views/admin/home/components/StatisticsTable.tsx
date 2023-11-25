import { Avatar, Box, StatLabel, Flex, FormLabel, Text, Icon, Select, SimpleGrid, useStyleConfig, useColorModeValue } from '@chakra-ui/react';

import axios from "axios";
import React, { useState, useEffect } from "react";
import MiniStatisticsGrafic from 'components/card/MiniStatisticsTitle'
import MAX from 'assets/img/comparationOfDrivers/max-verstappen.png';
import RBR from 'assets/img/comparationOfDrivers/Red-Bull-logo.jpg';
import ConstructorStandingsStatic from './ConstructorStandingsStatic';

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


export default function Default(props: {

}) {
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
		  }}
		]
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

  useEffect(() => {
    axios(baseUrl).then((resp) => {
      	const drivers = resp.data[0].DriverStandings[0];
    	setDriverLeader(drivers);
    });

    axios(baseUrlContructios).then((resp) => {
		const listConstructors = resp.data[0].ConstructorStandings;
    	const constructors = resp.data[0].ConstructorStandings[0];
		setConstructorStandingsList(listConstructors)
    	setConstructionLeader(constructors);
		setListConstruction(listConstructors)
    });
  }, []);


  

	return (
		<Box pt={{ base: '130px', md: '80px', xl: '80px' }}>
			<SimpleGrid columns={{ base: 1, md: 2, lg: 3, '2xl': 6 }} gap='20px' mb='0px'>
				<MiniStatisticsGrafic
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={MAX} />
							</FormLabel>
						</Flex>
					}
					title="Driver Leader Points"
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
          title="Constructor Leader Points"
          name={`${constructionLeader.Constructor.name || 'N/A'}`}
          value={`${constructionLeader.points || 'N/A'}`}
        />
		 <div style={{ display: 'flex' }}> 
    <ConstructorStandingsStatic constructorStandings={constructorStandingsList} />
  </div>
  <div style={{ display: 'flex', marginLeft: '75px', width: 'calc(100% + 90px)'  }}> {/* Add margin-right for spacing */}
    <ConstructorStandingsStatic constructorStandings={constructorStandingsList} />
  </div>
    
    
      </SimpleGrid>

      
		</Box>
	);
}