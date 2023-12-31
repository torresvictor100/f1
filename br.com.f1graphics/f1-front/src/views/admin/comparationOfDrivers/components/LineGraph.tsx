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
  const fontSizeOptions = Array.from({ length: 50 }, (_, index) => (index + 1).toString());

  //Title
  const [chartTitle, setChartTitle] = useState(layoutsDefault.Title);
  const [chartTitleColor, setChartTitleColor] = useState(layoutsDefault.TitleColor);
  const [titleFontSize, setTitleFontSize] = useState(layoutsDefault.TitleFontSize);
  //Background
  const [backgroundColor, setBackgroundColor] = useState(layoutsDefault.BackgroundColor);
  //Yaxis
  const [chartYaxisShow, setChartYaxisShow] = useState(layoutsDefault.YaxisShow);
  const [chartYaxisTitle, setChartYaxisTitle] = useState(layoutsDefault.YaxisTitle);
  const [chartYaxisTitleFontSize, setChartYaxisTitleFontSize] = useState(layoutsDefault.YaxisTitleFontSize);
  const [chartYaxisColor, setChartYaxisColor] = useState(layoutsDefault.YaxisColor);
  const [chartYaxisLabelFontSize, setChartYaxisLabelFontSize] = useState(layoutsDefault.YaxisLabelFontSize);
  const [chartYaxisLabelColor, setChartYaxisLabelColor] = useState(layoutsDefault.YaxisLabelColor);
  //Lines
  const [chartXaxisLinesShow, setChartXaxisLinesShow] = useState(layoutsDefault.XaxisLinesShow);
  const [chartYaxisLinesShow, setChartYaxisLinesShow] = useState(layoutsDefault.YaxisLinesShow);
  const [chartLinesColor, setChartLinesColor] = useState(layoutsDefault.LinesColor);
  //Label
  const [chartLabelFontSize, setLabelFontSize] = useState(layoutsDefault.LabelFontSize);
  const [chartLabelColor, setChartLabelColor] = useState(layoutsDefault.LabelColor);
  //Legend
  const [showLegend, setShowLegend] = useState(layoutsDefault.ShowLegend);
  const [legendLabelsColor, setLegendLabelsColor] = useState(layoutsDefault.LegendLabelsColor);
  const [legendLabelFontSize, setLegendLabelFontSize] = useState(layoutsDefault.LegendLabelFontSize);
  //Colors
  const [driverLineColors, setDriverLineColors] = useState<string[]>(props.chartData.map(() => ''));
  //Tooltip
  const [chartTooltipShow, setChartTooltipShow] = useState(layoutsDefault.TooltipShow);
  const [chartTooltipShowInTop, setChartTooltipShowInTop] = useState(layoutsDefault.TooltipShowInTop);
  const [chartTooltipTheme, setChartTooltipTheme] = useState(layoutsDefault.TooltipTheme);
  //Settings
  const [showTitleBackGroundSettings, setShowTitleBackGroundSettings] = useState(false);
  const [showYaxisSettings, setShowYaxisSettings] = useState(false);
  const [showLinesLabelSettings, setShowLinesLabelSettings] = useState(false);
  const [showLegendSettings, setShowLegendSettings] = useState(false);
  const [showColorsSettings, setShowColorsSettings] = useState(false);
  const [showTooltipSettings, setShowTooltipSettings] = useState(false);
  const [showLayoutsSettings, setShowLayoutsSettings] = useState(false);

  useEffect(() => {
    const updatedChartData = props.chartData.map((data, index) => ({
      ...data,
      name: props.driverNames[index] || data.name,
    }));
    setChartData(updatedChartData);
    setChartDataFullName(updatedChartData);
  }, [props.chartData, props.driverNames]);

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
      enabled: chartTooltipShow,
      enabledOnSeries: undefined,
      shared: true,
      followCursor: false,
      intersect: false,
      inverseOrder: false,
      custom: undefined,
      fillSeriesColor: false,
      theme: chartTooltipTheme,
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
        enabled: chartTooltipShowInTop,
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

  //StyleSettings
  const backgroundStyleTitleBackGroundSettings = showTitleBackGroundSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  const backgroundStyleshowYaxisSettings = showYaxisSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  const backgroundStyleshowXaxisSettings = showLinesLabelSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  const backgroundStyleshowLegendSettings = showLegendSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  const backgroundStyleshowColorsSettings = showColorsSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  const backgroundStyleshowLayoutsSettings = showLayoutsSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  const backgroundTooltipStyleshowLayoutsSettings = showTooltipSettings
    ? {
      background: `linear-gradient(to right, #fff, #000})`,
      boxShadow: '5px 5px 15px rgba(0, 0, 0, 0.2)',
    }
    : {};

  //BackgroundStyle
  const titleBackgroundStyle = showTitleBackGroundSettings
    ? {
      marginTop: '10px',
      marginBottom: '10px',
      backgroundColor: '#f4f7fe',
      padding: '10px',
      borderRadius: '8px',
      boxShadow: '0px 0px 10px 0px rgba(0, 0, 0, 0.1)',
    }
    : {};

  const showLinesLabelSettingsStyle = showLinesLabelSettings
    ? {
      marginTop: '10px',
      marginBottom: '10px',
      backgroundColor: '#f4f7fe',
      padding: '10px',
      borderRadius: '8px',
      boxShadow: '0px 0px 10px 0px rgba(0, 0, 0, 0.1)',
    }
    : {};

  const showColorsSettingsStyle = showColorsSettings
    ? {
      marginTop: '10px',
      marginBottom: '10px',
      backgroundColor: '#f4f7fe',
      padding: '10px',
      borderRadius: '8px',
      boxShadow: '0px 0px 10px 0px rgba(0, 0, 0, 0.1)',
    }
    : {};

  const showLayoutsSettingsStyle = showLayoutsSettings
    ? {
      marginTop: '10px',
      marginBottom: '10px',
      backgroundColor: '#f4f7fe',
      padding: '10px',
      borderRadius: '8px',
      boxShadow: '0px 0px 10px 0px rgba(0, 0, 0, 0.1)',
    }
    : {};



  const setLayout = (layouts: any) => {
    //Title
    setChartTitle(layouts.Title);
    setChartTitleColor(layouts.TitleColor);
    setTitleFontSize(layouts.TitleFontSize);
    //Background
    setBackgroundColor(layouts.BackgroundColor);
    //Yaxis
    setChartYaxisShow(layouts.YaxisShow);
    setChartYaxisTitle(layouts.YaxisTitle);
    setChartYaxisTitleFontSize(layouts.YaxisTitleFontSize);
    setChartYaxisColor(layouts.YaxisColor);
    setChartYaxisLabelFontSize(layouts.YaxisLabelFontSize);
    setChartYaxisLabelColor(layouts.YaxisLabelColor);
    //Lines
    setChartYaxisLinesShow(layouts.YaxisLinesShow);
    setChartXaxisLinesShow(layouts.XaxisLinesShow);
    setChartLinesColor(layouts.LinesColor);
    //Label
    setLabelFontSize(layouts.LabelFontSize);
    setChartLabelColor(layouts.LabelColor);
    //Legend
    setShowLegend(layouts.ShowLegend);
    setLegendLabelsColor(layouts.LegendLabelsColor);
    setLegendLabelFontSize(layouts.LegendLabelFontSize);
    //Tooltip
    setChartTooltipShow(layouts.TooltipShow)
    setChartTooltipTheme(layouts.TooltipTheme)
    setChartTooltipShowInTop(layouts.TooltipShowInTop)
  }

  const handleClickShowTitleBackGroundConfig = () => {
    setShowTitleBackGroundSettings(!showTitleBackGroundSettings);
  };

  const handleClickShowYaxisConfig = () => {
    setShowYaxisSettings(!showYaxisSettings);
  };

  const handleClickShowLinesLabelConfig = () => {
    setShowLinesLabelSettings(!showLinesLabelSettings);
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

  const handleShowTooltipSettings = () => {
    setShowTooltipSettings(!showTooltipSettings);
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


  return (
    <>
      <Box display="flex" flexWrap="wrap" gap="10px" marginTop={'10px'}>
        <Box style={backgroundStyleTitleBackGroundSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleClickShowTitleBackGroundConfig}>Title and Background Settings</button>
          </Box>
        </Box>

        <Box style={backgroundStyleshowYaxisSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleClickShowYaxisConfig}>Yaxis Settings</button>
          </Box>
        </Box>

        <Box style={backgroundStyleshowXaxisSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleClickShowLinesLabelConfig}>Lines and Label Settings</button>
          </Box>
        </Box>

        <Box style={backgroundStyleshowLegendSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleshowLegendConfig}>Legend Settings</button>
          </Box>
        </Box>

        <Box style={backgroundStyleshowColorsSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleshowColorsConfig}>Colors Settings</button>
          </Box>
        </Box>
      </Box>

      <Box display="flex" flexWrap="wrap" gap="10px" marginTop={'10px'}>
        <Box style={backgroundTooltipStyleshowLayoutsSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleShowTooltipSettings}>Tooltip Settings</button>
          </Box>
        </Box>
        <Box style={backgroundStyleshowLayoutsSettings}>
          <Box width="260px" color={'#1B2559'} textAlign="start" fontWeight="50" lineHeight="1px" borderWidth="2px" borderStyle="solid" borderColor={'#1B2559'} borderRadius="md" p="4" background="#f4f7fe">
            <button style={{ width: '100%' }} onClick={handleshowshowLayoutsSettings}>Layouts Settings</button>
          </Box>
        </Box>
      </Box>


      {showTitleBackGroundSettings && (
        <Box style={titleBackgroundStyle} color={'#1B2559'}>
          <Grid templateColumns="2fr 1fr 1fr 1fr" gap={4} >
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
        </Box>
      )}

      {showYaxisSettings && (
        <Grid templateColumns="1fr 1fr 1fr 1fr 1fr 1fr" gap={4} color={'#1B2559'}>
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

      {showLinesLabelSettings && (
        <Box style={showLinesLabelSettingsStyle} color={'#1B2559'}>
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

        </Box>
      )}

      {showLegendSettings && (
        <Grid templateColumns="1fr 1fr 1fr 1fr 1fr 1fr" gap={4} color={'#1B2559'}>

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
        <Box style={showColorsSettingsStyle} color={'#1B2559'}>

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
        </Box>
      )}

      {showTooltipSettings && (
        <Grid templateColumns="1fr 1fr 1fr 1fr 1fr 1fr" gap={4} color={'#1B2559'}>

          <GridItem>
            <FormControl>
              <FormLabel>Tooltip Show</FormLabel>
              <Checkbox
                isChecked={chartTooltipShow}
                onChange={() => setChartTooltipShow(!chartTooltipShow)}
              >
                Tooltip Show
              </Checkbox>
            </FormControl>
          </GridItem>

          <GridItem>
            <FormControl>
              <FormLabel>Tooltip Theme</FormLabel>
              <Select
                value={chartTooltipTheme}
                onChange={(e) => setChartTooltipTheme(e.target.value)}
              >
                <option value="light">Light</option>
                <option value="dark">Dark</option>
              </Select>
            </FormControl>
          </GridItem>


          <GridItem>
            <FormControl>
              <FormLabel>Tooltip Show Fixed in Top</FormLabel>
              <Checkbox
                isChecked={chartTooltipShowInTop}
                onChange={() => setChartTooltipShowInTop(!chartTooltipShowInTop)}
              >
                Tooltip Show Fixed in Top
              </Checkbox>
            </FormControl>
          </GridItem>

        </Grid>
      )}

      {showLayoutsSettings && (
        <Box style={showLayoutsSettingsStyle}>
          <Box width="260px" color={'#1B2559'} >
            <label htmlFor="layoutSelect"></label>
            <FormLabel>Ready Layouts</FormLabel>
            <Select id="layoutSelect" value={layoutSelect} onChange={handleLayoutChange}>
              <option value="f1GraphicsChartOptions">F1 Graphics</option>
              <option value="splashGoChartOptions">Splash/Go</option>
            </Select>
          </Box>
        </Box>

      )}

      <Box minH='400px' minW='95%' mt='auto' marginTop={'10px'}>
        {props.dataLoaded && <LineChart chartData={chartDataFullName} chartOptions={optionsLine} />}
      </Box>

    </>
  );
}
