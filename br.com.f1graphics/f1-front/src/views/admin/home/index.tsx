
import { forwardRef } from "react";

import { Box, Text, useColorModeValue, useStyleConfig } from "@chakra-ui/react";

import { CustomCardProps } from "theme/theme";
import StatisticsTable from "./components/StatisticsTable";

export default function UserReports() {

  const brandColor = useColorModeValue("brand.500", "white");
  const boxBg = useColorModeValue("secondaryGray.300", "whiteAlpha.100");

  const CustomCard = forwardRef<HTMLDivElement, CustomCardProps>(
    (props, ref) => {
      const { size, variant, ...rest } = props;
      const styles = useStyleConfig("Card", { size, variant });

      return <Box ref={ref} __css={styles} {...rest} />;
    }
  );

  const textColor2023 = useColorModeValue("secondaryGray.900", "white");

  return (
    <>
      <StatisticsTable />

      <CustomCard mb="10">
        <Text
          fontSize="50px"
          mb="50px"
          fontWeight="bold"
          textAlign="left"
          p="-0.5"
          color={textColor2023}
        >
          F1 Graphics
        </Text>
        <Text
          fontSize="30px"
          fontWeight="bold"
          textAlign="left"
          p="-0.5"
          color={textColor2023}
        >
          This project was developed by an enthusiast passionate about Formula 1
          and programming. Its main purpose is to serve as a repository of
          processed F1 data graphics, providing customization options so that
          anyone can incorporate these graphics and data into their
          presentations about this fascinating sport.
        </Text>
      </CustomCard>
    </>
  );
}
