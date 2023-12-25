// interfaces.ts
export interface Location {
    lat: string;
    locality: string;
    country: string;
}

export interface Circuit {
    circuitId: string;
    url: string;
    circuitName: string;
    Location: Location;
}

export interface Time {
    time: string;
}

export interface AverageSpeed {
    units: string;
    speed: string;
}

export interface FastestLap {
    rank: string;
    lap: string;
    Time: Time;
    AverageSpeed: AverageSpeed;
}

export interface Constructor {
    constructorId: string;
    url: string;
    name: string;
    nationality: string;
}

export interface ResultSeaseon {
    raceName: string;
    pointsSeason: number;
    pointsSeasonRaces: number;
    pointsSeasonSprintRaces: number;
}

export interface ResultRace {
    position: string;
    points: string;
    Time: Time;
    FastestLap: FastestLap;
}

export interface DriversResults {
    driverId: string;
    url: string;
    givenName: string;
    dateOfBirth: string;
    nationality: string;
    Constructor: Constructor;
    ResultSeaseon: ResultSeaseon;
    ResultRace: ResultRace;
}

export interface RaceSeason {
    round: string;
    url: string;
    raceName: string;
    date: string;
    time: string;
    Circuit: Circuit;
    DriversResults: DriversResults[];
}

export interface SeasonInfo {
    season: string;
    totalGPs: string;
    raceSeason: RaceSeason[];
    driverPoints: DataGraphic[];
    listNamesRacesResponseDTO: string[];
}

export interface DataGraphic {
    name: string,
    data: string[]
}

export interface Driver {
    driverId: string;
    permanentNumber: string;
    code: string;
    url: string;
    givenName: string;
    familyName: string;
    dateOfBirth: string;
    nationality: string;
}

export interface DriverTable {
    season: string;
    Drivers: Driver[];
}

export interface MRData {
    xmlns: string;
    series: string;
    url: string;
    limit: string;
    offset: string;
    total: string;
    DriverTable: DriverTable;
}

export interface DriversResponse {
    MRData: MRData;
}

export interface ToolbarOptions {
    show: boolean;
}

export interface DropShadowOptions {
    enabled: boolean;
    top: number;
    left: number;
    blur: number;
    opacity: number;
    color: string;
}

export interface TitleOptions {
    text: string;
    align: string;
    margin: number;
    offsetX: number;
    offsetY: number;
    floating: boolean;
    style: {
        fontSize: string;
        fontWeight: string;
        fontFamily: string | undefined;
        color: string;
    };
}

export interface TooltipOptions {
    theme: string;
    style: {
        color: string;
    };
}

export interface LabelsOptions {
    style: {
        colors: string;
        fontSize: string;
        fontWeight: string;
    };
}

export interface XAxisOptions {
    type: string;
    categories: string[];
    labels: LabelsOptions;
    axisBorder: {
        show: boolean;
    };
    axisTicks: {
        show: boolean;
    };
}

export interface YAxisOptions {
    show: boolean;
}

export interface LegendOptions {
    show: boolean;
}

export interface GridOptions {
    show: boolean;
    column: {
        color: string[];
        opacity: number;
    };
}

export interface StrokeOptions {
    curve: string;
    type: string;
}

export interface DataLabelsOptions {
    enabled: boolean;
}

export interface OptionsLine {
    chart: {
        toolbar: ToolbarOptions;
        dropShadow: DropShadowOptions;
    };
    colors: string[];
    title: TitleOptions;
    tooltip: TooltipOptions;
    dataLabels: DataLabelsOptions;
    stroke: StrokeOptions;
    xaxis: XAxisOptions;
    yaxis: YAxisOptions;
    legend: LegendOptions;
    grid: GridOptions;
}