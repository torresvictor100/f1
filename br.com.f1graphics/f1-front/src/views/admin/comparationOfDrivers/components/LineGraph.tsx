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
} from "@chakra-ui/react";
import LineChart from 'components/charts/LineChart';
import { f1GraphicsChartOptions } from './ChartOptions'
import { splashGoChartOptions } from './ChartOptions'

import {
  DataGraphic,
  OptionsLine,
} from './Interfaces';

export default function Default(props: {
  chartData: DataGraphic[];
  chartOptions: OptionsLine;
  chartLabel: string[];
  dataLoaded: boolean;
  driverNames: string[];
}) {
  const [layoutSelect, setLayoutSelect] = useState<string>('F1GraphicsChartOptions');
  const [chartData, setChartData] = useState<DataGraphic[]>(props.chartData);
  const [chartDataFullName, setChartDataFullName] = useState<DataGraphic[]>([]);
  const [layoutsDefault, setLayoutsDefault] = useState<any>(f1GraphicsChartOptions);
  const [chartTitle, setChartTitle] = useState(layoutsDefault.Title);
  const [chartYaxisTitle, setChartYaxisTitle] = useState(layoutsDefault.YaxisTitle);
  const [chartTitleColor, setChartTitleColor] = useState(layoutsDefault.TitleColor);
  const [chartLabelColor, setChartLabelColor] = useState(layoutsDefault.LabelColor);
  const [chartYaxisColor, setChartYaxisColor] = useState(layoutsDefault.YaxisColor);
  const [chartLinesColor, setChartLinesColor] = useState(layoutsDefault.LinesColor);
  const [legendLabelsColor, setLegendLabelsColor] = useState(layoutsDefault.LegendLabelsColor);
  const [backgroundColor, setBackgroundColor] = useState(layoutsDefault.BackgroundColor);
  const [chartYaxisLabelColor, setChartYaxisLabelColor] = useState(layoutsDefault.YaxisLabelColor);
  const [driverLineColors, setDriverLineColors] = useState<string[]>(props.chartData.map(() => ''));
  const [chartYaxisShow, setChartYaxisShow] = useState(layoutsDefault.ChartYaxisShow);
  const [showLegend, setShowLegend] = useState(layoutsDefault.ShowLegend);
  const [chartYaxisLinesShow, setChartYaxisLinesShow] = useState(layoutsDefault.ChartYaxisLinesShow);
  const [chartXaxisLinesShow, setChartXaxisLinesShow] = useState(true);
  const [titleFontSize, setTitleFontSize] = useState(layoutsDefault.TitleFontSize);
  const [chartLabelFontSize, setLabelFontSize] = useState(layoutsDefault.LabelFontSize);
  const [legendLabelFontSize, setLegendLabelFontSize] = useState(layoutsDefault.LegendLabelFontSize);
  const [chartYaxisTitleFontSize, setChartYaxisTitleFontSize] = useState(layoutsDefault.YaxisTitleFontSize);
  const [chartYaxisLabelFontSize, setChartYaxisLabelFontSize] = useState(layoutsDefault.YaxisLabelFontSize);
  const fontSizeOptions = Array.from({ length: 50 }, (_, index) => (index + 1).toString());
  const [showTitleBackGroundSettings, setShowTitleBackGroundSettings] = useState(layoutsDefault.ShowTitleBackGroundSettings);
  const [showYaxisSettings, setShowYaxisSettings] = useState(false);
  const [showXaxisSettings, setShowXaxisSettings] = useState(false);
  const [showLegendSettings, setShowLegendSettings] = useState(false);
  const [showColorsSettings, setShowColorsSettings] = useState(false);
  const [showLayoutsSettings, setShowLayoutsSettings] = useState(false);

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
      offsetY: 5,
      floating: false,
      style: {
        fontSize: titleFontSize,
        fontWeight: 'bold',
        fontFamily: undefined,
        color: chartTitleColor
      }
    },
    fill: {
      colors: undefined,
      opacity: 100,
      type: 'solid',
      gradient: {
          shade: 'dark',
          type: "horizontal",
          shadeIntensity: 60,
          gradientToColors: undefined,
          inverseColors: true,
          opacityFrom: 1,
          opacityTo: 1,
          stops: [6, 50, 100],
          colorStops: []
      },
      image: {
          src: [],
          width: undefined,
          height: undefined
      },
      pattern: {
          style: 'verticalLines',
          width: 6,
          height: 6,
          strokeWidth: 2,
      },
    },    
    tooltip: {
      enabled: true, //show ou nao
      enabledOnSeries: undefined,
      shared: true,
      followCursor: false,
      intersect: false,
      inverseOrder: false,
      custom: undefined,
      fillSeriesColor: false,
      theme: 'dark', //ou 'light'
      style: {
        fontSize: '15px',
        fontFamily: undefined,
      },
      onDatasetHover: {
        highlightDataSeries: false,
      },
      marker: {
        show: true,
      },
      fixed: {
        enabled: false, // auternativa
        position: 'topRight',
        offsetX: 0,
        offsetY: 0,
      },
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
    dataLabels: {
      enabled: true,
      textAnchor: 'middle',
      style: {
        fontSize: '14px',
        fontFamily: 'Helvetica, Arial, sans-serif',
        fontWeight: 'bold',
        colors: undefined
      },
      background: {
        enabled: true,
        foreColor: '#fff',
        padding: 4,
        borderRadius: 2,
        borderWidth: 1,
        borderColor: '#fff',
        opacity: 0.9,
        dropShadow: {
          enabled: false,
          top: 1,
          left: 1,
          blur: 1,
          color: '#000',
          opacity: 0.45
        }
      },
      dropShadow: {
        enabled: true,
        top: 1,
        left: 1,
        blur: 1,
        color: '#000',
        opacity: 0.45
      },
      offsetY: -10, // Ajuste para posicionar acima do ponto (ajuste conforme necessário)
      formatter: function (val: any) {
        return val; // Pode precisar ajustar isso com base na sua estrutura de dados
      }
    },
    markers: {
      size: 6,
      colors: undefined,
      strokeColors: '#fff',
      strokeWidth: 2,
      strokeOpacity: 0.9,
      strokeDashArray: 0,
      fillOpacity: 1,
      discrete: [],
      shape: "circle",
      radius: 2,
      offsetX: 0,
      offsetY: 0,
      onClick: undefined,
      onDblClick: undefined,
      showNullDataPoints: true,
      hover: {
        size: undefined,
        sizeOffset: 3
      }
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


    if (selectedLayout === 'f1GraphicsChartOptions') {
      setLayout(f1GraphicsChartOptions)
    } else if (selectedLayout === 'splashGoChartOptions') {
      setLayout(splashGoChartOptions)
    }
  };

  const setLayout = (layouts: any) => {
    setChartTitle(layouts.Title);
    setChartYaxisTitle(layouts.YaxisTitle);
    setChartTitleColor(layouts.TitleColor);
    setChartLabelColor(layouts.LabelColor);
    setBackgroundColor(layouts.BackgroundColor);
    setChartYaxisColor(layouts.YaxisColor);
    setChartLinesColor(layouts.LinesColor);
    setLegendLabelsColor(layouts.LegendLabelsColor);
    setChartYaxisLabelColor(layouts.YaxisLabelColor);
    setTitleFontSize(layouts.TitleFontSize);
    setLabelFontSize(layouts.LabelFontSize);
    setLegendLabelFontSize(layouts.LegendLabelFontSize);
    setChartYaxisTitleFontSize(layouts.YaxisTitleFontSize);
    setChartYaxisLabelFontSize(layouts.YaxisLabelFontSize);
    setChartYaxisShow(layouts.ChartYaxisShow);
    setShowLegend(layouts.ShowLegend);
    setChartYaxisLinesShow(layouts.ChartYaxisLinesShow);
    setShowTitleBackGroundSettings(layouts.ShowTitleBackGroundSettings)
  }

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

  const handleshowshowLayoutsSettings = () => {
    setShowLayoutsSettings(!showLayoutsSettings);
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

      <Box display="flex" flexWrap="wrap" gap="10px" marginTop={'10px'}>
        <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
          <button style={{ width: '100%' }} onClick={handleshowshowLayoutsSettings}>Layouts Settings</button>
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

      {showLayoutsSettings && (
        <Box width="260px">
          <label htmlFor="layoutSelect">Ready Layouts</label>
          <Select id="layoutSelect" value={layoutSelect} onChange={handleLayoutChange}>
            <option value="f1GraphicsChartOptions">F1 Graphics</option>
            <option value="splashGoChartOptions">Splash/Go</option>
          </Select>
        </Box>
      )}

      <Box minH='400px' minW='95%' mt='auto'>
        {props.dataLoaded && <LineChart chartData={chartDataFullName} chartOptions={optionsLine} />}
      </Box>
    </>
  );
}
