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
import { Avatar, Box, StatLabel, Flex, FormLabel, Text, Icon, Select, SimpleGrid, useStyleConfig, useColorModeValue } from '@chakra-ui/react';
// Assets
import Mclaren from 'assets/img/comparationOfDrivers/Mclaren.png';
import RBR from 'assets/img/comparationOfDrivers/Red-Bull-logo.jpg';
import MaxVerstappen from 'assets/img/comparationOfDrivers/max-verstappen.png';
import Hamiton from 'assets/img/comparationOfDrivers/Hamiton.jpg';
// Custom components
import MiniCalendar from 'components/calendar/MiniCalendar';
import MiniStatisticsTitle from 'components/card/MiniStatisticsTitle'
import CheckTable from 'views/admin/rtl/components/CheckTable';
import ComplexTable from 'views/admin/default/components/ComplexTable';
import DailyTraffic from 'views/admin/default/components/DailyTraffic';
import PieCard from 'views/admin/default/components/PieCard';
import Tasks from 'views/admin/default/components/Tasks';
import TotalSpent from 'views/admin/default/components/TotalSpent';
import WeeklyRevenue from 'views/admin/default/components/WeeklyRevenue';
import tableDataCheck from 'views/admin/default/variables/tableDataCheck';
import tableDataComplex from 'views/admin/default/variables/tableDataComplex';
import { CustomCardProps } from 'theme/theme';

export default function UserReports() {
	// Chakra Color Mode
	const brandColor = useColorModeValue('brand.500', 'white');
	const boxBg = useColorModeValue('secondaryGray.300', 'whiteAlpha.100');

	const CustomCard = forwardRef<HTMLDivElement, CustomCardProps>((props, ref) => {
		const { size, variant, ...rest } = props;
		const styles = useStyleConfig('Card', { size, variant });

		return <Box ref={ref} __css={styles} {...rest} />;
	});

	const textColor2023 = useColorModeValue('secondaryGray.900', 'white');

	return (

		<Box pt={{ base: '130px', md: '80px', xl: '80px' }}>


			<CustomCard py='35px' mb='10'>

				<Text fontSize="2xl" fontWeight="bold" textAlign="left" p="-0.5" color={textColor2023} >
					Championship 2023
				</Text>
			</CustomCard>
			<SimpleGrid columns={{ base: 1, md: 2, lg: 3, '2xl': 6 }} gap='20px' mb='20px'>
				<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={RBR} />
							</FormLabel>
						</Flex>
					}
					title="Championship Leader Construction"
					name='Red Bull'
					value='822'
				/>
				<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={MaxVerstappen} />
							</FormLabel>
						</Flex>
					}
					title="Championship Leader Driver"
					name='M. Verstappen'
					value='549'
				/>
				<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={Mclaren} />
							</FormLabel>
							<Select id='balance' variant='mini' mt='5px' me='0px' defaultValue='usd'>
								<option value='mclaren'>Mclaren</option>
								<option value='ferrari'>Ferrari</option>
								<option value='mercedes'>Mercedes</option>
							</Select>
						</Flex>
					}
					title="Constructor Points"
					name='McLaren'
					value='284'
				/>
				<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={Hamiton} />
							</FormLabel>
							<Select id='balance' variant='mini' mt='5px' me='0px' defaultValue='usd'>
							</Select>
						</Flex>
					}
					title="Driver Points"
					name='L. Hamiton'
					value='232'
				/>
			</SimpleGrid>
			<CustomCard py='35px' mb='10'>
				<Text fontSize="50px" mb="50px" fontWeight="bold" textAlign="left" p="-0.5" color={textColor2023} >
					F1 Graphics
				</Text>
				<Text fontSize="30px" fontWeight="bold" textAlign="left" p="-0.5" color={textColor2023} >
				This project was developed by an enthusiast passionate about Formula 1 and programming. Its main purpose is to serve as a repository of processed F1 data graphics, providing customization options so that anyone can incorporate these graphics and data into their presentations about this fascinating sport.
				</Text>
			</CustomCard>
		</Box>

	);
}
