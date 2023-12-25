import {
  Flex,
  Stat,
  Text,
  useColorModeValue,
} from "@chakra-ui/react";

import Card from "components/card/Card";
import { ReactNode } from "react";

export default function Default(props: {
  startContent?: JSX.Element;
  endContent?: JSX.Element;
  growth?: string | number;
  hasSelect?: boolean;
  selectElement?: ReactNode;
}) {
  const {
    startContent,
    endContent,
    growth,
    hasSelect = false,
    selectElement = <></>,
  } = props;
  const textColor = useColorModeValue("secondaryGray.900", "white");
  const textColorSecondary = "secondaryGray.600";

  return (
    <Card py="15px">
      <Flex
        my="auto"
        h="100%"
        align={{ base: "center", xl: "start" }}
        justify={{ base: "center", xl: "center" }}
      >
        {startContent}

        <Stat my="auto" ms={startContent ? "18px" : "0px"}>
          {growth ? (
            <Flex align="center">
              <Text color="green.500" fontSize="xs" fontWeight="700" me="5px">
                {growth}
              </Text>
              <Text color="secondaryGray.600" fontSize="xs" fontWeight="400">
                since last month
              </Text>
            </Flex>
          ) : null}
        </Stat>
        <Flex ms="auto" w="max-content">
          {endContent}
        </Flex>
      </Flex>
      {hasSelect && <>{selectElement}</>}
    </Card>
  );
}
