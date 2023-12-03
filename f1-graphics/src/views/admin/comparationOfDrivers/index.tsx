import React, { forwardRef } from 'react';

import { Box, useStyleConfig, useColorModeValue } from '@chakra-ui/react';

import Graph from './components/Graph';
import { CustomCardProps } from 'theme/theme';
import StatisticsTable from './../home/components/StatisticsTable'

export default function UserReports() {

	const CustomCard = forwardRef<HTMLDivElement, CustomCardProps>((props, ref) => {
		const { size, variant, ...rest } = props;
		const styles = useStyleConfig('Card', { size, variant });

		return <Box ref={ref} __css={styles} {...rest} />;
	});

	const textColor2023 = useColorModeValue('secondaryGray.900', 'white');

	return (

		<Box>
			<StatisticsTable />
			<Graph />
		</Box>
	);
}
