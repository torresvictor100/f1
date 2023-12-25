
import { forwardRef } from "react";

import { Box, Text, useColorModeValue, useStyleConfig } from "@chakra-ui/react";

import { CustomCardProps } from "theme/theme";
import StatisticsTable from "./../home/components/StatisticsTable";
import CardHistory from "./components/cardHistory"

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

      <CardHistory
        mb="10"
        version="TM,0.1"
        description="Next version | new repository in gitHub | Creation of a Docker Compose 
        | Deploy the backend in a free and scalable hosting environment | Database creation. | Creation of a storage service"
        data="inProgress"
      />

      <CardHistory
        mb="10"
        version="TM,0.0"
        description="This marks our project's inaugural release, arriving a few months after its inception. Our system extracts data from the Ergast API (http://ergast.com), subsequently processing it within our backend built with Spring. The refined data is then dispatched to the React-powered frontend hosted on Vercel. Initially, our backend was deployed on AWS using the RC2 service. However, due to exceeding budget constraints, we made the decision to temporarily take the service offline. The upcoming version will address this and unveil a host of new features."
        data="05/12/2023"
      />


    </>
  );
}
