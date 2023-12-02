import React from 'react';
import { Box, Text } from '@chakra-ui/react';

interface BoxComponentProps {
  isOpen: boolean;
  onClose: () => void;
}

const BoxComponent: React.FC<BoxComponentProps> = ({ isOpen, onClose }) => {
  if (!isOpen) {
    return null; // Renderiza nada se não estiver aberto
  }

  return (
    <Box
      position="absolute"
      top="50%"
      left="50%"
      transform="translate(-50%, -50%)"
      w="300px"
      h="300px"
      backgroundColor="white"
      p="4"
      borderRadius="md"
      boxShadow="md"
      zIndex="999"
    >
      <Text>Oi</Text>
      <button onClick={onClose}>Fechar</button>
    </Box>
  );
};

export default BoxComponent;
