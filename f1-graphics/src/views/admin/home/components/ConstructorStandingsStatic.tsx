import React, { useState } from 'react';
import { Flex, FormLabel, Avatar, Select, Box } from '@chakra-ui/react';
import Mclaren from 'assets/img/comparationOfDrivers/Mclaren.png';
import MiniStatisticsTitle from 'components/card/MiniStatisticsTitle';

interface ConstructorStanding {
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
}

interface ConstructorSelectProps {
  constructorStandings: ConstructorStanding[];
}

const ConstructorStandingsStatic: React.FC<ConstructorSelectProps> = ({ constructorStandings }) => {
  const [selectedConstructor, setSelectedConstructor] = useState<string>(constructorStandings[0]?.Constructor.name);

  const handleConstructorChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setSelectedConstructor(event.target.value);
  };

  return (
    <Box width="calc(100% - -100px)">
      <MiniStatisticsTitle
        endContent={
          <Flex me="-16px" mt="10px">
            <FormLabel htmlFor="balance">
              <Avatar src={Mclaren} />
            </FormLabel>
            <Select id="balance" mt="5px" me="0px" defaultValue="usd" onChange={handleConstructorChange}>
              <option value="mclaren">Mclaren</option>
              <option value="ferrari">Ferrari</option>
              <option value="mercedes">Mercedes</option>
            </Select>
          </Flex>
        }
        title="COnstuiction Points"
        name="mclaren"
        value="232"
      />
    </Box>
  );
};

export default ConstructorStandingsStatic;
