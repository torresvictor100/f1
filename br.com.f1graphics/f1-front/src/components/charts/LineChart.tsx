import React from 'react';
import ReactApexChart from 'react-apexcharts';

import {
	Box,
	Slider,
	SliderTrack,
	SliderFilledTrack,
	SliderThumb
} from "@chakra-ui/react";

type ChartProps = {
	chartData: any[];
	chartOptions: any;
};

type ChartState = {
	chartData: any[];
	chartOptions: any;
	chartWidth: string;
	chartHeight: string;
};

class LineChart extends React.Component<ChartProps, ChartState> {
	constructor(props: ChartProps) {
		super(props);

		this.state = {
			chartData: [],
			chartOptions: {},
			chartWidth: '100%',
			chartHeight: '500px',
		};
	}

	componentDidMount() {
		this.setState({
			chartData: this.props.chartData,
			chartOptions: this.props.chartOptions
		});
	}

	render() {
		const { chartWidth, chartHeight, chartData, chartOptions } = this.state;

		return (
			<Box>

				<Slider
					min={0}
					max={500}
					value={parseInt(chartHeight)}
					onChange={(value) => this.setState({ chartHeight: `${value}px` })}
				>
					<SliderTrack bg="#f4f7fe">
						<SliderFilledTrack bg="#1B2559" />
					</SliderTrack>
					<SliderThumb boxSize={6} borderColor="#1B2559" />
				</Slider>

				<ReactApexChart
					width={chartWidth}
					height={chartHeight}
					options={chartOptions}
					series={chartData}
					type="line"
				/>

				<Slider
					min={0}
					max={100}
					value={parseInt(chartWidth)}
					onChange={(value) => this.setState({ chartWidth: `${value}%` })}
				>
					<SliderTrack bg="#f4f7fe">
						<SliderFilledTrack bg="#1B2559" />
					</SliderTrack>
					<SliderThumb boxSize={6} borderColor="#1B2559" />
				</Slider>
			</Box>
		);
	}
}

export default LineChart;
