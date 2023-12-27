import React, { useState } from 'react';
import {
  Box,
  Input,
  FormControl,
  FormLabel,
  Grid,
  GridItem,
  Checkbox,
  Select,
} from "@chakra-ui/react";
import LineChart from 'components/charts/LineChart';

import {
  DataGraphic,
  OptionsLine,
} from './Interfaces';
import { title } from 'process';

export default function Default(props: {
  chartData: DataGraphic[];
  chartOptions: OptionsLine;
  chartLabel: string[];
  dataLoaded: boolean;
  driverNames: string[];
}) {
  const [chartTitle, setChartTitle] = useState('F1 Graphics');
  const [chartYaxisTitle, setChartYaxisTitle] = useState('Drivers');
  const [chartTitleColor, setChartTitleColor] = useState('#ee0000');
  const [chartLabelColor, setChartLabelColor] = useState('#1B2559');
  const [chartYaxisColor, setChartYaxisColor] = useState('#ee0000');
  const [chartLinesColor, setChartLinesColor] = useState('#484D50');
  const [backgroundColor, setBackgroundColor] = useState('#fff');
  const [chartYaxisLabelColor, setChartYaxisLabelColor] = useState('#1B2559');
  const [driverLineColors, setDriverLineColors] = useState<string[]>(props.chartData.map(() => ''));
  const [chartYaxisShow, setChartYaxisShow] = useState(true);
  const [chartYaxisLinesShow, setChartYaxisLinesShow] = useState(true);
  const [chartXaxisLinesShow, setChartXaxisLinesShow] = useState(true);
  const [titleFontSize, setTitleFontSize] = useState('20');
  const [chartLabelFontSize, setLabelFontSize] = useState('13');
  const [chartYaxisTitleFontSize, setChartYaxisTitleFontSize] = useState('16');
  const [chartYaxisLabelFontSize, setChartYaxisLabelFontSize] = useState('16');
  const fontSizeOptions = Array.from({ length: 50 }, (_, index) => (index + 1).toString());

  const updateLineColor = (index: number, color: string) => {
    const newColors = [...driverLineColors];
    newColors[index] = color;
    setDriverLineColors(newColors);

    const newOptionsLine = { ...optionsLine };
    newOptionsLine.colors = newColors.filter(color => color !== '');
    setDriverLineColors(newOptionsLine);
  };

  const optionsLine: any = {
    chart: {
      toolbar: {
        show: props.chartOptions.chart.toolbar.show
      },
      dropShadow: props.chartOptions.chart.dropShadow,
      background: backgroundColor
    },
    title: {
      text: chartTitle,
      align: 'center',
      margin: 10,
      offsetX: 0,
      offsetY: 0,
      floating: false,
      style: {
        fontSize: titleFontSize,
        fontWeight: 'bold',
        fontFamily: undefined,
        color: chartTitleColor
      }
    },
    tooltip: props.chartOptions.tooltip,
    dataLabels: props.chartOptions.dataLabels,
    stroke: {
      curve: 'smooth',
      type: 'line'
    },
    xaxis: {
      type: 'numeric',
      categories: props.chartLabel,
      labels: {
        style: {
          colors: chartLabelColor,
          fontSize: chartLabelFontSize,
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
      show: chartYaxisShow,
      title: {
        text: chartYaxisTitle,
        style: {
          fontSize: chartYaxisTitleFontSize,
          color: chartYaxisColor
        }
      },
      labels: {
        style: {
          fontSize: chartYaxisLabelFontSize,
          colors: chartYaxisLabelColor,
        },
      },
    },
    legend: {
      show: true,
      showForSingleSeries: true, //show
      showForNullSeries: true,
      showForZeroSeries: true,
      position: 'bottom',
      horizontalAlign: 'center',
      floating: false,
      fontSize: '14px', //tamanho
      fontWeight: 400,
      formatter: undefined,
      inverseOrder: false,
      width: undefined,
      height: undefined,
      tooltipHoverFormatter: undefined,
      customLegendItems: [],
      offsetX: 0,
      offsetY: 0,
      labels: {
        colors: '#000', // letras cor entro da caixa
        useSeriesColors: false
      },
      markers: {
        width: 12,
        height: 12,
        strokeWidth: 0,
        strokeColor: '#000',
        fillColors: undefined,
        radius: 12,
        customHTML: undefined,
        onClick: undefined,
        offsetX: 0,
        offsetY: 0
      },
      itemMargin: {
        horizontal: 5,
        vertical: 0
      },
      onItemClick: {
        toggleDataSeries: true
      },
      onItemHover: {
        highlightDataSeries: true
      },
    },
    grid: {
      show: true,
      borderColor: chartLinesColor,
      strokeDashArray: 0,
      position: 'back',
      xaxis: {
        lines: {
          show: chartYaxisLinesShow
        }
      },
      yaxis: {
        lines: {
          show: chartXaxisLinesShow
        }
      },
      row: {
        color: ['#755', '#fff'],
        opacity: 0.5
      },
      column: {
        colors: undefined,
        opacity: 0.5
      },
      padding: {
        top: 0,
        right: 0,
        bottom: 0,
        left: 0
      }
    },
    colors: driverLineColors.filter(color => color !== ''),
  };

  return (
    <>
      <Grid templateColumns="2fr 1fr 1fr 1fr" gap={4}>
        <GridItem>
          <FormControl>
            <FormLabel>Title</FormLabel>
            <Input
              type="text"
              value={chartTitle}
              onChange={(e) => setChartTitle(e.target.value)}
              placeholder="Enter chart title"
            />
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Title Font Size</FormLabel>
            <Select
              value={titleFontSize}
              onChange={(e) => setTitleFontSize(e.target.value)}
            >
              {fontSizeOptions.map((size) => (
                <option key={size} value={size}>
                  {size}
                </option>
              ))}
            </Select>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Title Color</FormLabel>
            <Input
              type="color"
              value={chartTitleColor}
              onChange={(e) => setChartTitleColor(e.target.value)}
              w="30%"
            />
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Background</FormLabel>
            <Input
              type="color"
              value={backgroundColor}
              onChange={(e) => setBackgroundColor(e.target.value)}
              w="30%"
            />
          </FormControl>
        </GridItem>
      </Grid>

      <Grid templateColumns="1fr 1fr 1fr 1fr 1fr 1fr" gap={4}>
        <GridItem>
          <FormControl>
            <FormLabel>Yaxis Show</FormLabel>
            <Checkbox
              isChecked={chartYaxisShow}
              onChange={() => setChartYaxisShow(!chartYaxisShow)}
            >
              Show Yaxis
            </Checkbox>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Yaxis Title</FormLabel>
            <Input
              type="text"
              value={chartYaxisTitle}
              onChange={(e) => setChartYaxisTitle(e.target.value)}
              placeholder="Enter chart Yaxis title"
            />
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Yaxis Title Font Size</FormLabel>
            <Select
              value={chartYaxisTitleFontSize}
              onChange={(e) => setChartYaxisTitleFontSize(e.target.value)}
            >
              {fontSizeOptions.map((size) => (
                <option key={size} value={size}>
                  {size}
                </option>
              ))}
            </Select>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Yaxis Color</FormLabel>
            <Input
              type="color"
              value={chartYaxisColor}
              onChange={(e) => setChartYaxisColor(e.target.value)}
              w="30%"
            />
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Yaxis Value Font Size</FormLabel>
            <Select
              value={chartYaxisLabelFontSize}
              onChange={(e) => setChartYaxisLabelFontSize(e.target.value)}
            >
              {fontSizeOptions.map((size) => (
                <option key={size} value={size}>
                  {size}
                </option>
              ))}
            </Select>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Yaxis Value Color</FormLabel>
            <Input
              type="color"
              value={chartYaxisLabelColor}
              onChange={(e) => setChartYaxisLabelColor(e.target.value)}
              w="30%"
            />
          </FormControl>
        </GridItem>

      </Grid>

      <Grid templateColumns="1fr 1fr 1fr 1fr 1fr 1fr" gap={4}>

        <GridItem>
          <FormControl>
            <FormLabel>Lines Xaxis Show</FormLabel>
            <Checkbox
              isChecked={chartXaxisLinesShow}
              onChange={() => setChartXaxisLinesShow(!chartXaxisLinesShow)}
            >
              Show Lines Xaxis
            </Checkbox>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Lines Yaxis Show</FormLabel>
            <Checkbox
              isChecked={chartYaxisLinesShow}
              onChange={() => setChartYaxisLinesShow(!chartYaxisLinesShow)}
            >
              Show Lines Yaxis
            </Checkbox>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Lines Color</FormLabel>
            <Input
              type="color"
              value={chartLinesColor}
              onChange={(e) => setChartLinesColor(e.target.value)}
              w="30%"
            />
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Label Font Size</FormLabel>
            <Select
              value={chartLabelFontSize}
              onChange={(e) => setLabelFontSize(e.target.value)}
            >
              {fontSizeOptions.map((size) => (
                <option key={size} value={size}>
                  {size}
                </option>
              ))}
            </Select>
          </FormControl>
        </GridItem>

        <GridItem>
          <FormControl>
            <FormLabel>Label Color</FormLabel>
            <Input
              type="color"
              value={chartLabelColor}
              onChange={(e) => setChartLabelColor(e.target.value)}
              w="30%"
            />
          </FormControl>
        </GridItem>

      </Grid>

      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '10px' }}>
        
        {props.chartData.map((data, index) => (
          <FormControl key={index} style={{ flexBasis: '15%' }}>
            <FormLabel>{data.name} Line</FormLabel>
            <Input
              type="color"
              value={driverLineColors[index]}
              onChange={(e) => {
                const newColors = [...driverLineColors];
                newColors[index] = e.target.value;
                setDriverLineColors(newColors);
              }}
              w="100%"
            />
          </FormControl>
        ))}
      </div>


      <Box minH='400px' minW='95%' mt='auto'>
        {props.dataLoaded && <LineChart chartData={props.chartData} chartOptions={optionsLine} />}
      </Box>
    </>
  );
}
