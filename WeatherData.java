// ===== WeatherData.java =====

/**
 * WeatherData stores daily weather observations linked to a land parcel.
 */
public class WeatherData {

    // Private attributes (Encapsulation)
    private String weatherId;
    private String landId;
    private String observationDate;
    private double temperatureMaxC;
    private double temperatureMinC;
    private double rainfallMM;
    private double humidityPercent;
    private double windSpeedKmh;
    private String windDirection;
    private double solarRadiation;
    private String weatherCondition;
    private String recordedBy;

    // Default Constructor
    public WeatherData() {
        this.weatherId        = "W000";
        this.landId           = "L000";
        this.observationDate  = "01-01-2024";
        this.temperatureMaxC  = 0.0;
        this.temperatureMinC  = 0.0;
        this.rainfallMM       = 0.0;
        this.humidityPercent  = 0.0;
        this.windSpeedKmh     = 0.0;
        this.windDirection    = "N";
        this.solarRadiation   = 0.0;
        this.weatherCondition = "Sunny";
        this.recordedBy       = "Auto Station";
    }

    // Parameterized Constructor
    public WeatherData(String weatherId, String landId,
                       String observationDate, double temperatureMaxC,
                       double temperatureMinC, double rainfallMM,
                       double humidityPercent, double windSpeedKmh,
                       String windDirection, double solarRadiation,
                       String weatherCondition, String recordedBy) {
        this.weatherId        = weatherId;
        this.landId           = landId;
        this.observationDate  = observationDate;
        this.temperatureMaxC  = temperatureMaxC;
        this.temperatureMinC  = temperatureMinC;
        this.rainfallMM       = rainfallMM;
        this.humidityPercent  = humidityPercent;
        this.windSpeedKmh     = windSpeedKmh;
        this.windDirection    = windDirection;
        this.solarRadiation   = solarRadiation;
        this.weatherCondition = weatherCondition;
        this.recordedBy       = recordedBy;
    }

    // Getters
    public String getWeatherId()         { return weatherId; }
    public String getLandId()            { return landId; }
    public String getObservationDate()   { return observationDate; }
    public double getTemperatureMaxC()   { return temperatureMaxC; }
    public double getTemperatureMinC()   { return temperatureMinC; }
    public double getRainfallMM()        { return rainfallMM; }
    public double getHumidityPercent()   { return humidityPercent; }
    public double getWindSpeedKmh()      { return windSpeedKmh; }
    public String getWindDirection()     { return windDirection; }
    public double getSolarRadiation()    { return solarRadiation; }
    public String getWeatherCondition()  { return weatherCondition; }
    public String getRecordedBy()        { return recordedBy; }

    // Setters
    public void setWeatherId(String weatherId)               { this.weatherId = weatherId; }
    public void setLandId(String landId)                     { this.landId = landId; }
    public void setObservationDate(String observationDate)   { this.observationDate = observationDate; }
    public void setTemperatureMaxC(double temperatureMaxC)   { this.temperatureMaxC = temperatureMaxC; }
    public void setTemperatureMinC(double temperatureMinC)   { this.temperatureMinC = temperatureMinC; }
    public void setRainfallMM(double rainfallMM)             { this.rainfallMM = rainfallMM; }
    public void setHumidityPercent(double humidityPercent)   { this.humidityPercent = humidityPercent; }
    public void setWindSpeedKmh(double windSpeedKmh)         { this.windSpeedKmh = windSpeedKmh; }
    public void setWindDirection(String windDirection)       { this.windDirection = windDirection; }
    public void setSolarRadiation(double solarRadiation)     { this.solarRadiation = solarRadiation; }
    public void setWeatherCondition(String weatherCondition) { this.weatherCondition = weatherCondition; }
    public void setRecordedBy(String recordedBy)             { this.recordedBy = recordedBy; }

    // display()
    public void display() {
        System.out.println("========== WEATHER DATA ==========");
        System.out.println("  Weather ID       : " + weatherId);
        System.out.println("  Land ID          : " + landId);
        System.out.println("  Observation Date : " + observationDate);
        System.out.println("  Max Temperature  : " + temperatureMaxC + " C");
        System.out.println("  Min Temperature  : " + temperatureMinC + " C");
        System.out.println("  Rainfall         : " + rainfallMM + " mm");
        System.out.println("  Humidity         : " + humidityPercent + "%");
        System.out.println("  Wind Speed       : " + windSpeedKmh + " km/h");
        System.out.println("  Wind Direction   : " + windDirection);
        System.out.println("  Solar Radiation  : " + solarRadiation + " MJ/m2");
        System.out.println("  Condition        : " + weatherCondition);
        System.out.println("  Recorded By      : " + recordedBy);
        System.out.println("==================================");
    }
}
