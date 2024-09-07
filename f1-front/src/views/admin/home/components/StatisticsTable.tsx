import {
  Avatar,
  Box,
  Flex,
  FormLabel,
  SimpleGrid,
  Text,
} from "@chakra-ui/react";

import Icon from 'assets/img/comparationOfDrivers/icon.png';
import axios from "axios";
import MiniStatisticsGrafic from "components/card/MiniStatisticsTitle";
import { useEffect, useState } from "react";
import ConstructorStandingsStatic from "./ConstructorStandingsStatic";
import DriverStandingsStatic from "./DriverStandingsStatic";

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
  const baseUrl = "https://formula1data.com.br/f1-graphics/driverstandings/";
  const baseUrlContructios =
    "https://formula1data.com.br/f1-graphics/constructorstandings/";
  const [constructionLeader, setConstructionLeader] =
    useState<ConstructorStanding>({
      position: "",
      positionText: "",
      points: "",
      wins: "",
      Constructor: {
        constructorId: "",
        url: "",
        name: "",
        nationality: "",
      },
    });

  const [listConstruction, setListConstruction] = useState<ConstructorState>({
    season: "",
    round: "",
    ConstructorStandings: [
      {
        position: "",
        positionText: "",
        points: "",
        wins: "",
        Constructor: {
          constructorId: "",
          url: "",
          name: "",
          nationality: "",
        },
      },
    ],
  });

  const [constructorStandingsList, setConstructorStandingsList] = useState<
    ConstructorStanding[]
  >([
    {
      position: "",
      positionText: "",
      points: "",
      wins: "",
      Constructor: {
        constructorId: "",
        url: "",
        name: "",
        nationality: "",
      },
    },
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
    {
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
    },
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
      .finally(() => setDataLoadedContructios(true));
  }, []);

  if (!dataLoadedDrivers || !dataLoadedContructios) {
    return <div>Loading...</div>;
  }

  return (

    <Box pt={{ base: "80px", md: "80px" }}>
      <Box display={{ sm: 'block', xl: 'none' }}>
        <Text
          color={"#1B2559"}
        >
          We recommend a resolution of at least 1200 pixels.
        </Text>
      </Box>
      <Text
        fontSize="2xl"
        fontWeight="bold"
        textAlign="left"
        p="-0.5"
        color={"#1B2559"}
      >
        Season 2023
      </Text>
      <SimpleGrid mb="50px" columns={{ base: 1, md: 2, lg: 4 }} gap="20px">
        <MiniStatisticsGrafic
          endContent={
            <Flex me="-16px" mt="10px">
              <FormLabel htmlFor="balance">
                <Avatar src={Icon} />
              </FormLabel>
            </Flex>
          }
          title="Driver Leader"
          name={
            driverLeader.Driver.givenName + " " + driverLeader.Driver.familyName
          }
          value={driverLeader.points}
        />
        <MiniStatisticsGrafic
          endContent={
            <Flex me="-16px" mt="10px">
              <FormLabel htmlFor="balance">
                <Avatar src={Icon} />
              </FormLabel>
            </Flex>
          }
          title="Constructor Leader"
          name={`${constructionLeader.Constructor.name || "N/A"}`}
          value={`${constructionLeader.points || "N/A"}`}
        />
        <ConstructorStandingsStatic
          constructorStandings={constructorStandingsList}
        />
        <DriverStandingsStatic driverStandings={listDriverStanding} />
      </SimpleGrid>
    </Box>
  );
}
