import React from 'react';
import {
    Box
  } from "@chakra-ui/react";
import LineChart from 'components/charts/LineChart';

export default function Default(props: {
    chartData: any[];
    chartOptions: any;
  }){
    return (
        <Box minH='400px' minW='95%' mt='auto'>

			&& <LineChart chartData={props.chartData} chartOptions={props.chartOptions} />
		</Box>
    );
}
