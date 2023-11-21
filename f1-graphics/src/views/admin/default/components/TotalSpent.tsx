// Chakra imports
import { Avatar, Box,StatLabel, Flex, FormLabel,Text, Icon, Select, SimpleGrid,useStyleConfig, useColorModeValue } from '@chakra-ui/react';
// Custom components
import Card from 'components/card/Card';
import LineChart from 'components/charts/LineChart';
import { IoCheckmarkCircle } from 'react-icons/io5';
import { MdBarChart, MdOutlineCalendarToday } from 'react-icons/md';
// Assets
import { RiArrowUpSFill } from 'react-icons/ri';
import { lineChartDataTotalSpent, lineChartOptionsTotalSpent } from 'variables/charts';
import Hamiton from 'assets/img/comparationOfDrivers/Hamiton.jpg';
import Massa from 'assets/img/comparationOfDrivers/Massa.jpg';
import Soma from 'assets/img/comparationOfDrivers/Soma.jpg';
import MiniStatisticsTitle from 'components/card/MiniStatisticsTitle'
import MiniStatistics from 'components/card/MiniStatistics'

export default function TotalSpent(props: { [x: string]: any }) {
	const { ...rest } = props;

	// Chakra Color Mode

	const textColor = useColorModeValue('secondaryGray.900', 'white');
	const textColorSecondary = useColorModeValue('secondaryGray.600', 'white');
	const boxBg = useColorModeValue('secondaryGray.300', 'whiteAlpha.100');
	const iconColor = useColorModeValue('brand.500', 'white');
	const bgButton = useColorModeValue('secondaryGray.300', 'whiteAlpha.100');
	const bgHover = useColorModeValue({ bg: 'secondaryGray.400' }, { bg: 'whiteAlpha.50' });
	const bgFocus = useColorModeValue({ bg: 'secondaryGray.300' }, { bg: 'whiteAlpha.100' });
	return (
		<Card justifyContent='center' alignItems='center' flexDirection='column' w='100%' mb='0px' {...rest}>
			<Text color={textColor} fontSize='34px' textAlign='start' fontWeight='700' lineHeight='100%'>
						Comparation Drivers
					</Text>
					<Text color='secondaryGray.600' fontSize='sm' fontWeight='500' mt='4px' me='12px'>
							2008
						</Text>
			<Flex w='100%' flexDirection={{ base: 'column', lg: 'row' }}>
				<Box minH='400px' minW='95%' mt='auto'>
					<LineChart chartData={lineChartDataTotalSpent} chartOptions={lineChartOptionsTotalSpent} />
				</Box>
			</Flex>
			<SimpleGrid columns={{ base: 1, md: 2, lg: 3, '2xl': 6 }} gap='20px' mb='20px'>
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
					title="Ferrari"
					name='Champion'
					value='L.Hamiton'
				/>
			<MiniStatisticsTitle
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'>
								<Avatar src={Massa} />
							</FormLabel>
							<Select id='balance' variant='mini' mt='5px' me='0px' defaultValue='usd'>
							</Select>
						</Flex>
					}
					title="McLaren"
					name='2º'
					value='Massa'
				/>
				<MiniStatistics
					endContent={
						<Flex me='-16px' mt='10px'>
							<FormLabel htmlFor='balance'backgroundColor={''}>
								<Avatar src={Soma} />
							</FormLabel>
						</Flex>
					}
					name=''
					value=''
				/>
			</SimpleGrid>
		</Card>
	);
}
