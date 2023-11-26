import { Avatar, Flex, FormLabel, Select } from "@chakra-ui/react";
import McLaren from "assets/img/comparationOfDrivers/Mclaren.png";
import MiniStatisticsTitle from "components/card/MiniStatisticsTitle";
import React, { useState } from "react";

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

const ConstructorStandingsStatic: React.FC<ConstructorSelectProps> = ({
  constructorStandings,
}) => {
  const [selectedConstructor, setSelectedConstructor] =
    useState<ConstructorStanding>(constructorStandings[0]);

  const handleConstructorChange = (
    event: React.ChangeEvent<HTMLSelectElement>
  ) => {
    const selectedConstructorId = event.target.value;
    const selectedConstructor = constructorStandings.find(
      (constructor) =>
        constructor.Constructor.constructorId === selectedConstructorId
    );
    setSelectedConstructor(selectedConstructor || constructorStandings[0]);
  };

  return (
    // <Box width="calc(100% - -100px)">
    <MiniStatisticsTitle
      endContent={
        <Flex mt="10px">
          <FormLabel htmlFor="balance">
            <Avatar src={McLaren} />
          </FormLabel>
        </Flex>
      }
      hasSelect
      selectElement={
        <Select
          id="balance"
          mt="5px"
          me="0px"
          defaultValue={selectedConstructor.Constructor.constructorId}
          onChange={handleConstructorChange}
        >
          <option value="">Constructor</option>
          {constructorStandings.map((constructor) => (
            <option
              key={constructor.Constructor.constructorId}
              value={constructor.Constructor.constructorId}
            >
              {constructor.Constructor.name}
            </option>
          ))}
        </Select>
      }
      title="Points"
      name={selectedConstructor.Constructor.name}
      value={selectedConstructor.points}
    />
    // </Box>
  );
};

export default ConstructorStandingsStatic;
