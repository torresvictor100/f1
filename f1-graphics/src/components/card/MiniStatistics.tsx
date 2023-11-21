// Chakra imports
import { Flex, Stat, StatLabel, StatNumber, useColorModeValue, Text } from '@chakra-ui/react';
// Custom components
import Card from 'components/card/Card';

export default function Default(props: {
	startContent?: JSX.Element;
	endContent?: JSX.Element;
	name: string;
	growth?: string | number;
	value: string | number;
}) {
	const { startContent, endContent, name, growth, value } = props;
	const textColor = useColorModeValue('secondaryGray.900', 'white');
	const textColorSecondary = 'secondaryGray.600';

	return (
		<Card py='15px'>

				<Flex ms='-10px' w='max-content'>
					{endContent}
				</Flex>
		</Card>
	);
}
