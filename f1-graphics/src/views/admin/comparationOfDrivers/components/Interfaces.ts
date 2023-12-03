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
    driverPoints: DriverPoints[];
    listNamesRacesResponseDTO: string[];
}

export interface DriverPoints {
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
