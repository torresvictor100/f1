import React, { useState } from 'react';
import { Flex, FormLabel, Avatar, Select, Box } from '@chakra-ui/react';
import MiniStatisticsTitle from 'components/card/MiniStatisticsTitle';
import PlaceholderImage from 'assets/img/comparationOfDrivers/Mclaren.png';
import MAX from 'assets/img/comparationOfDrivers/max-verstappen.png';

interface DriverStanding {
  position: string;
  positionText: string;
  points: string;
  wins: string;
  Driver: {
    driverId: string;
    url: string;
    code: string;
    permanentNumber: string;
    givenName: string;
    familyName: string;
    dateOfBirth: string;
    nationality: string;
  };
  Constructors: Array<{
    constructorId: string;
    url: string;
    name: string;
    nationality: string;
  }>;
}

interface DriverSelectProps {
  driverStandings: DriverStanding[];
}

const DriverStandingsStatic: React.FC<DriverSelectProps> = ({ driverStandings }) => {
  const [selectedDriver, setSelectedDriver] = useState<DriverStanding>(driverStandings[0]);

  const handleDriverChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedDriverId = event.target.value;
    const selectedDriver = driverStandings.find(driver => driver.Driver.driverId === selectedDriverId);
    setSelectedDriver(selectedDriver || driverStandings[0]);
  };

  return (
    <Box width="calc(100% - -100px)">
      <MiniStatisticsTitle
        endContent={
          <Flex me="-16px" mt="10px">
            <FormLabel htmlFor="balance">
              <Avatar src={MAX} />
            </FormLabel>
            <Select
              id="balance"
              mt="5px"
              me="0px"

              onChange={handleDriverChange}
            >
               <option value="">Driver</option>
              {driverStandings.map(driver => (
                <option key={driver.Driver.driverId} value={driver.Driver.driverId}>
                  {driver.Driver.familyName}
                </option>
              ))}
            </Select>
          </Flex>
        }
        title="Points"
        name={`${selectedDriver.Driver.familyName}`}
        value={selectedDriver.points}
      />
    </Box>
  );
};

export default DriverStandingsStatic;
