import React, { useState, useEffect } from 'react';
import {
  Box,
  Input,
  FormControl,
  FormLabel,
  Grid,
  GridItem,
  Checkbox,
  Select,
  Button,
} from "@chakra-ui/react";
import LineChart from 'components/charts/LineChart';
import { F1GraphicsChartOptions } from './chartOptions'

import { F2GraphicsChartOptions } from './chartOptions'

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
  const [defaultChartOptions, setDefaultChartOptions] = useState<any>(F1GraphicsChartOptions);
  const [layoutSelect, setLayoutSelect] = useState<string>('F1GraphicsChartOptions');
  const [chartData, setChartData] = useState<DataGraphic[]>(props.chartData);
  const [chartDataFullName, setChartDataFullName] = useState<DataGraphic[]>([]);
  const [chartTitle, setChartTitle] = useState('F1 Graphics');
  const [chartYaxisTitle, setChartYaxisTitle] = useState('Drivers');
  const [chartTitleColor, setChartTitleColor] = useState('#ee0000');
  const [chartLabelColor, setChartLabelColor] = useState('#1B2559');
  const [chartYaxisColor, setChartYaxisColor] = useState('#ee0000');
  const [chartLinesColor, setChartLinesColor] = useState('#484D50');
  const [legendLabelsColor, setLegendLabelsColor] = useState('#1B2559');
  const [backgroundColor, setBackgroundColor] = useState('#fff');
  const [chartYaxisLabelColor, setChartYaxisLabelColor] = useState('#1B2559');
  const [driverLineColors, setDriverLineColors] = useState<string[]>(props.chartData.map(() => ''));
  const [chartYaxisShow, setChartYaxisShow] = useState(true);
  const [showLegend, setShowLegend] = useState(true);
  const [chartYaxisLinesShow, setChartYaxisLinesShow] = useState(true);
  const [chartXaxisLinesShow, setChartXaxisLinesShow] = useState(true);
  const [titleFontSize, setTitleFontSize] = useState('20');
  const [chartLabelFontSize, setLabelFontSize] = useState('13');
  const [legendLabelFontSize, setLegendLabelFontSize] = useState('14');
  const [chartYaxisTitleFontSize, setChartYaxisTitleFontSize] = useState('16');
  const [chartYaxisLabelFontSize, setChartYaxisLabelFontSize] = useState('16');
  const fontSizeOptions = Array.from({ length: 50 }, (_, index) => (index + 1).toString());
  const [showTitleBackGroundSettings, setShowTitleBackGroundSettings] = useState(false);
  const [showYaxisSettings, setShowYaxisSettings] = useState(false);
  const [showXaxisSettings, setShowXaxisSettings] = useState(false);
  const [showLegendSettings, setShowLegendSettings] = useState(false);
  const [showColorsSettings, setShowColorsSettings] = useState(false);

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
        show: true
      },
      dropShadow: {
        enabled: true,
        top: 13,
        left: 0,
        blur: 10,
        opacity: 0.1,
        color: '#000'
      },
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
    tooltip: {
      theme: 'dark-dual',
      style: {
        color: '#000',
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
      showForSingleSeries: showLegend,
      showForNullSeries: true,
      showForZeroSeries: true,
      position: 'bottom',
      horizontalAlign: 'center',
      floating: false,
      fontSize: legendLabelFontSize,
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
        colors: legendLabelsColor,
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
        top: 20,
        right: 20,
        bottom: 20,
        left: 20
      }
    },
    colors: driverLineColors.filter(color => color !== ''),
  };

  useEffect(() => {
    const updatedChartData = props.chartData.map((data, index) => ({
      ...data,
      name: props.driverNames[index] || data.name,
    }));
    setChartData(updatedChartData);
    setChartDataFullName(updatedChartData);
  }, [props.chartData, props.driverNames]);

  const handleClickShowTitleBackGroundConfig = () => {
    setShowTitleBackGroundSettings(!showTitleBackGroundSettings);
  };

  const handleLayoutChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    const selectedLayout = event.target.value;
    setLayoutSelect(selectedLayout);

    // Adicione lógica aqui para definir o título do gráfico com base na opção selecionada
    // Pode ser algo como:
    // if (selectedLayout === 'F1GraphicsChartOptions') {
    //   setChartTitle('Título para F1 Graphics Chart Options');
    // } else if (selectedLayout === 'F2GraphicsChartOptions') {
    //   setChartTitle('Título para F2 Graphics Chart Options');
    // }
  };

  console.log(layoutSelect);

  const handleClickShowYaxisConfig = () => {
    setShowYaxisSettings(!showYaxisSettings);
  };

  const handleClickShowXaxisConfig = () => {
    setShowXaxisSettings(!showXaxisSettings);
  };

  const handleshowLegendConfig = () => {
    setShowLegendSettings(!showLegendSettings);
  };

  const handleshowColorsConfig = () => {
    setShowColorsSettings(!showColorsSettings);
  };

  return (
    <>

      <Box display="flex" flexWrap="wrap" gap="10px" marginTop={'10px'}>
        <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
          <button style={{ width: '100%' }} onClick={handleClickShowTitleBackGroundConfig}>Title and Background Settings</button>
        </Box>

        <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
          <button style={{ width: '100%' }} onClick={handleClickShowYaxisConfig}>Yaxis Settings</button>
        </Box>

        <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
          <button style={{ width: '100%' }} onClick={handleClickShowXaxisConfig}>Xaxis Settings</button>
        </Box>

        <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
          <button style={{ width: '100%' }} onClick={handleshowLegendConfig}>Legend Settings</button>
        </Box>

        <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
          <button style={{ width: '100%' }} onClick={handleshowColorsConfig}>Colors Settings</button>
        </Box>
      </Box>


      {showTitleBackGroundSettings && (
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
      )}

      {showYaxisSettings && (
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
      )}

      {showXaxisSettings && (
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
      )}

      {showLegendSettings && (
        <Grid templateColumns="1fr 1fr 1fr 1fr 1fr 1fr" gap={4}>

          <GridItem>
            <FormControl>
              <FormLabel>Show Legend</FormLabel>
              <Checkbox
                isChecked={showLegend}
                onChange={() => setShowLegend(!showLegend)}
              >
                Show Legend
              </Checkbox>
            </FormControl>
          </GridItem>

          <GridItem>
            <FormControl>
              <FormLabel>Legend Labels Color</FormLabel>
              <Input
                type="color"
                value={legendLabelsColor}
                onChange={(e) => setLegendLabelsColor(e.target.value)}
                w="30%"
              />
            </FormControl>
          </GridItem>

          <GridItem>
            <FormControl>
              <FormLabel>Legend Label Font Size</FormLabel>
              <Select
                value={legendLabelFontSize}
                onChange={(e) => setLegendLabelFontSize(e.target.value)}
              >
                {fontSizeOptions.map((size) => (
                  <option key={size} value={size}>
                    {size}
                  </option>
                ))}
              </Select>
            </FormControl>
          </GridItem>

        </Grid>
      )}

      {showColorsSettings && (
        <Box style={{ display: 'flex', flexWrap: 'wrap', gap: '10px' }}>
          {props.driverNames.map((driverName, index) => (
            <FormControl key={index} style={{ flexBasis: '15%' }}>
              <FormLabel>{driverName} Line</FormLabel>
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
        </Box>
      )}

      <Box width="260px">
        <label htmlFor="layoutSelect">Ready Layouts</label>
        <Select id="layoutSelect" value={layoutSelect} onChange={handleLayoutChange}>
          <option value="F1GraphicsChartOptions">F1 Graphics Chart Options</option>
          <option value="F2GraphicsChartOptions">F2 Graphics Chart Options</option>
        </Select>
      </Box>

      <Box minH='400px' minW='95%' mt='auto'>
        {props.dataLoaded && <LineChart chartData={chartDataFullName} chartOptions={optionsLine} />}
      </Box>
    </>
  );
}
