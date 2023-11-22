import { Icon } from '@chakra-ui/react';
import { MdBarChart, MdPerson, MdHome, MdLock, MdOutlineShoppingCart } from 'react-icons/md';

// Admin Imports
import MainDashboard from 'views/admin/default';
import NFTMarketplace from 'views/admin/marketplace';
import Profile from 'views/admin/profile';
import DataTables from 'views/admin/dataTables';
import RTL from 'views/admin/rtl';
import Home from 'views/admin/home';
import ComparationOfDrivers from 'views/admin/comparationOfDrivers';

// Auth Imports
import SignInCentered from 'views/auth/signIn';

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
