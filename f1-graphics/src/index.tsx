import React from 'react';
import ReactDOM from 'react-dom';
import './assets/css/App.css';
import { HashRouter, Route, Switch, Redirect } from 'react-router-dom';
import ComparationOfDriversLayout from './layouts/comparationOfDrivers';
import Home from './layouts/home';
import { ChakraProvider } from '@chakra-ui/react';
import theme from './theme/theme';

ReactDOM.render(
	<ChakraProvider theme={theme}>
		<React.StrictMode>
			<HashRouter>
				<Switch>
					<Route path={`/comparationOfDrivers`} component={ComparationOfDriversLayout} />
					<Route path={`/home`} component={Home} />
					<Redirect from='/' to='/home' />
				</Switch>
			</HashRouter>
		</React.StrictMode>
	</ChakraProvider>,
	document.getElementById('root')
);
