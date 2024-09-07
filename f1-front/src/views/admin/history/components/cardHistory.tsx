import React, { forwardRef } from "react";
import { Box, Text, useColorModeValue, useStyleConfig } from "@chakra-ui/react";
import { CustomCardProps } from "theme/theme";

interface CardHistoryProps extends CustomCardProps {
  version: string;
  description: string;
  data: string;
}

const CardHistory = forwardRef<HTMLDivElement, CardHistoryProps>((props, ref) => {
  const { size, variant, version, description,data, ...rest } = props;
  const styles = useStyleConfig("Card", { size, variant });
  const textColor2023 = useColorModeValue("secondaryGray.900", "white");

  return (
    <Box ref={ref} __css={styles} {...rest}>
      <Text
        fontSize="50px"
        mb="50px"
        fontWeight="bold"
        textAlign="left"
        p="-0.5"
        color={textColor2023}
      >
        {version}
      </Text>
      <Text
        fontSize="30px"
        fontWeight="bold"
        textAlign="left"
        p="-0.5"
        color={textColor2023}
      >
        {description}
      </Text>
      <Text
        fontSize="30px"
        fontWeight="bold"
        textAlign="left"
        p="-0.5"
        color={textColor2023}
      >
        {data}
      </Text>
    </Box>
  );
});

export default CardHistory;
