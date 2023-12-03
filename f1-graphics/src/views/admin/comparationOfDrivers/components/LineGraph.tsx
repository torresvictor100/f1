
import {
    Box
} from "@chakra-ui/react";
import LineChart from 'components/charts/LineChart';

import {
	DataGraphic,
    DefaultOptionsLine,
  } from  './Interfaces';

const defautOptionsLine: DefaultOptionsLine = {
	chart: {
		toolbar: {
			show: true
		},
		dropShadow: {
			enabled: true,
			top: 13,
			left: 0,
			blur: 10,
			opacity: 0.1,
			color: '#000'
		}
	},
	colors: [ '#a60203', '#ff8000' ], //linhda dos piloto		
	title: {
		text: 'Meu Gráfico',
		align: 'center',
		margin: 10,
		offsetX: 0,
		offsetY: 0,
		floating: false,
		style: {
		  fontSize: '20px',
		  fontWeight: 'bold',
		  fontFamily: undefined,
		  color: '#fff'
		}
	  },
	tooltip: {
		theme: 'dark-dual',
		style: {
			color: '#000', // Cor do texto da dica de ferramenta (preto)
		  },
	},
	dataLabels: {
		enabled: false
	},
	stroke: {
		curve: 'smooth',
		type: 'line'
	},
	xaxis: {
		type: 'numeric',
		categories: [  "0", "Australian Grand Prix",
		"Malaysian Grand Prix",
		"Bahrain Grand Prix",
		"Spanish Grand Prix",
		"Turkish Grand Prix",
		"Monaco Grand Prix",
		"Canadian Grand Prix",
		"French Grand Prix",
		"British Grand Prix",
		"German Grand Prix",
		"Hungarian Grand Prix",
		"European Grand Prix",
		"Belgian Grand Prix",
		"Italian Grand Prix",
		"Singapore Grand Prix",
		"Japanese Grand Prix",
		"Chinese Grand Prix",
		"Brazilian Grand Prix" ],
		labels: {
			style: {
				colors: '#fff', //cor da lebols
				fontSize: '12px',
				fontWeight: '500'
			}
		},
		axisBorder: {
			show: false
		},
		axisTicks: {
			show: false
		}
	},
	yaxis: {
		show: true
	},
	legend: {
		show: false
	},
	grid: {
		show: true,
		column: {
			color: [ '#7551FF', '#39B8FF' ],
			opacity: 0.5
		}
	}
};

export default function Default(props: {
    chartData: DataGraphic[];
    chartOptions: DefaultOptionsLine;
    chartLabel: string[];
}) {

    console.log(props.chartLabel)

    return (
        <Box minH='400px' minW='95%' mt='auto'>

            <LineChart chartData={props.chartData} chartOptions={props.chartOptions} />
            
        </Box>
    );
}
