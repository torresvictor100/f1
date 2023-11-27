/*!
  _   _  ___  ____  ___ ________  _   _   _   _ ___   
 | | | |/ _ \|  _ \|_ _|__  / _ \| \ | | | | | |_ _| 
 | |_| | | | | |_) || |  / / | | |  \| | | | | || | 
 |  _  | |_| |  _ < | | / /| |_| | |\  | | |_| || |
 |_| |_|\___/|_| \_\___/____\___/|_| \_|  \___/|___|
                                                                                                                                                                                                                                                                                                                                       
=========================================================
* Horizon UI - v1.1.0
=========================================================

* Product Page: https://www.horizon-ui.com/
* Copyright 2022 Horizon UI (https://www.horizon-ui.com/)

* Designed and Coded by Simmmple

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

*/

import React, { forwardRef } from 'react';

// Chakra imports
import { Box,useStyleConfig, useColorModeValue } from '@chakra-ui/react';
// Custom components
import TotalSpent from './default/TotalSpent';
import { CustomCardProps } from 'theme/theme';
import StatisticsTable from './../home/components/StatisticsTable'

export default function UserReports() {
	// Chakra Color Mode


	const CustomCard = forwardRef<HTMLDivElement, CustomCardProps>((props, ref) => {
		const { size, variant, ...rest } = props;
		const styles = useStyleConfig('Card', { size, variant });
	  
		return <Box ref={ref} __css={styles} {...rest} />;
	  });

	  const textColor2023 = useColorModeValue('secondaryGray.900', 'white');
	
	return (

		<Box>		
			<StatisticsTable/>
			<TotalSpent />
			
		</Box>
	);
}
