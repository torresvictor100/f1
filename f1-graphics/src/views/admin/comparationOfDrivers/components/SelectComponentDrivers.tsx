import React, { useState, useEffect } from 'react';
import { Select, Flex, FormLabel, Avatar, SimpleGrid, Box } from '@chakra-ui/react';
import MiniStatisticsTitleSelect from './MiniStatisticsTitleSelect';
import Massa from 'assets/img/comparationOfDrivers/Massa.jpg';

interface SelectOption {
  label: string;
  value: string;
}

interface SelectComponentProps {
  options: SelectOption[];
}

const ButaoStylePlus = {
  border: '2px solid #1B2559',
  borderRadius: '50%',
  color: '#1B2559',
  width: '30px',
  height: '30px',
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  cursor: 'pointer',
  marginTop: '45px',
  fontSize: '25px',
  marginRight: '15px',
};

const Butaostyle = {
  border: '2px solid #1B2559',
  borderRadius: '50%',
  color: '#1B2559',
  width: '30px',
  height: '30px',
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  cursor: 'pointer',
  marginTop: '11px',
  fontSize: '25px',
};

interface SelectComponentProps {
  options: SelectOption[];
  onPilotsSelected: (selectedPilots: string[]) => void;
}

const SelectComponent: React.FC<SelectComponentProps> = ({ options ,onPilotsSelected}) => {
  const [selects, setSelects] = useState<string[]>(['']);


  const handleAddSelect = () => {
    setSelects([...selects, '']);
  };

  const handleRemoveSelect = (index: number) => {
    const updatedSelects = [...selects];
    updatedSelects.splice(index, 1);
    setSelects(updatedSelects);
    onPilotsSelected(updatedSelects);
  };
  useEffect(() => {
    onPilotsSelected(selects); // Chamando a função do componente pai quando a lista de pilotos for inicializada
  }, [selects]);

  const handleSelectChange = (index: number, value: string) => {
    const updatedSelects = [...selects];
    updatedSelects[index] = value;
    setSelects(updatedSelects);
    onPilotsSelected(updatedSelects);
  };

  return (
    <Box>
      <SimpleGrid mb="50px" columns={{ base: 1, md: 2, lg: 4 }} gap="20px">
        {selects.map((value, index) => (
          <Box key={index}>
            <MiniStatisticsTitleSelect
              endContent={
                <Flex mt="10px">
                  <FormLabel htmlFor={`balance-${index}`}>
                    <Avatar src={Massa} />
                  </FormLabel>
                  <button style={Butaostyle} onClick={() => handleRemoveSelect(index)}>
                    -
                  </button>
                </Flex>
              }
              hasSelect
              selectElement={
                <Select
                  id={`balance-${index}`}
                  mt="5px"
                  me="0px"
                  value={value}
                  onChange={(e) => handleSelectChange(index, e.target.value)}
                >
                  <option value="">Drivers</option>
                  {options.map((option, optionIndex) => (
                    <option key={optionIndex} value={option.value}>
                      {option.label}
                    </option>
                  ))}
                </Select>
              }
            />
          </Box>
        ))}

        <button style={ButaoStylePlus} onClick={handleAddSelect}>
          +
        </button>
      </SimpleGrid>
    </Box>
  );
};

export default SelectComponent;
