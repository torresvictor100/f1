import { Icon } from '@chakra-ui/react';
import { MdBarChart, MdPerson, MdHome, MdLock, MdOutlineShoppingCart } from 'react-icons/md';

// Admin Imports
import MainDashboard from 'views/admin/default';
import NFTMarketplace from 'views/admin/marketplace';
import Profile from 'views/admin/profile';
import DataTables from 'views/admin/dataTables';
import RTL from 'views/admin/rtl';
import ComparationOfDrivers from 'views/admin/comparationOfDrivers';

// Auth Imports
import SignInCentered from 'views/auth/signIn';

const routes = [
	{
		name: 'Comparation of Drivers',
		layout: '/comparationOfDrivers',
		path: '/admin',
		icon: <Icon as={MdBarChart} width='20px' height='20px' color='inherit' />,
		component: ComparationOfDrivers
	}
];

export default routes;
