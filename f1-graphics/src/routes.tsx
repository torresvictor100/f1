import { Icon } from '@chakra-ui/react';
import { MdBarChart, MdHome } from 'react-icons/md';

// Admin Imports
import Home from 'views/admin/home';
import ComparationOfDrivers from 'views/admin/comparationOfDrivers';


const routes = [
	{
		name: 'Home',
		layout: '/home',
		path: '/default',
		icon: <Icon as={MdHome} width='20px' height='20px' color='#ee0000' />,
		component: Home
	},
	{
		name: 'Comparation of Drivers',
		layout: '/comparationOfDrivers',
		path: '/default',
		icon: <Icon as={MdBarChart} width='20px' height='20px' color='#ee0000' />,
		component: ComparationOfDrivers
	}
	
];

export default routes;
