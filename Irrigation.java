// ===== Irrigation.java =====

/**
 * Irrigation records an irrigation event for a land parcel.
 */
public class Irrigation {

    // Private attributes (Encapsulation)
    private String irrigationId;
    private String landId;
    private String irrigationType;
    private String waterSource;
    private double waterUsedLitres;
    private String irrigationDate;
    private double durationHours;
    private double areaIrrigatedAcres;
    private double costINR;
    private String operatorName;
    private String nextScheduledDate;
    private boolean automatedSystem;

    // Default Constructor
    public Irrigation() {
        this.irrigationId       = "IR000";
        this.landId             = "L000";
        this.irrigationType     = "Drip";
        this.waterSource        = "Borewell";
        this.waterUsedLitres    = 0.0;
        this.irrigationDate     = "01-01-2024";
        this.durationHours      = 0.0;
        this.areaIrrigatedAcres = 0.0;
        this.costINR            = 0.0;
        this.operatorName       = "Unknown";
        this.nextScheduledDate  = "01-01-2024";
        this.automatedSystem    = false;
    }

    // Parameterized Constructor
    public Irrigation(String irrigationId, String landId,
                      String irrigationType, String waterSource,
                      double waterUsedLitres, String irrigationDate,
                      double durationHours, double areaIrrigatedAcres,
                      double costINR, String operatorName,
                      String nextScheduledDate, boolean automatedSystem) {
        this.irrigationId       = irrigationId;
        this.landId             = landId;
        this.irrigationType     = irrigationType;
        this.waterSource        = waterSource;
        this.waterUsedLitres    = waterUsedLitres;
        this.irrigationDate     = irrigationDate;
        this.durationHours      = durationHours;
        this.areaIrrigatedAcres = areaIrrigatedAcres;
        this.costINR            = costINR;
        this.operatorName       = operatorName;
        this.nextScheduledDate  = nextScheduledDate;
        this.automatedSystem    = automatedSystem;
    }

    // Getters
    public String getIrrigationId()       { return irrigationId; }
    public String getLandId()             { return landId; }
    public String getIrrigationType()     { return irrigationType; }
    public String getWaterSource()        { return waterSource; }
    public double getWaterUsedLitres()    { return waterUsedLitres; }
    public String getIrrigationDate()     { return irrigationDate; }
    public double getDurationHours()      { return durationHours; }
    public double getAreaIrrigatedAcres() { return areaIrrigatedAcres; }
    public double getCostINR()            { return costINR; }
    public String getOperatorName()       { return operatorName; }
    public String getNextScheduledDate()  { return nextScheduledDate; }
    public boolean isAutomatedSystem()    { return automatedSystem; }

    // Setters
    public void setIrrigationId(String irrigationId)             { this.irrigationId = irrigationId; }
    public void setLandId(String landId)                         { this.landId = landId; }
    public void setIrrigationType(String irrigationType)         { this.irrigationType = irrigationType; }
    public void setWaterSource(String waterSource)               { this.waterSource = waterSource; }
    public void setWaterUsedLitres(double waterUsedLitres)       { this.waterUsedLitres = waterUsedLitres; }
    public void setIrrigationDate(String irrigationDate)         { this.irrigationDate = irrigationDate; }
    public void setDurationHours(double durationHours)           { this.durationHours = durationHours; }
    public void setAreaIrrigatedAcres(double areaIrrigatedAcres) { this.areaIrrigatedAcres = areaIrrigatedAcres; }
    public void setCostINR(double costINR)                       { this.costINR = costINR; }
    public void setOperatorName(String operatorName)             { this.operatorName = operatorName; }
    public void setNextScheduledDate(String nextScheduledDate)   { this.nextScheduledDate = nextScheduledDate; }
    public void setAutomatedSystem(boolean automatedSystem)      { this.automatedSystem = automatedSystem; }

    // display()
    public void display() {
        System.out.println("========== IRRIGATION DETAILS ==========");
        System.out.println("  Irrigation ID    : " + irrigationId);
        System.out.println("  Land ID          : " + landId);
        System.out.println("  Irrigation Type  : " + irrigationType);
        System.out.println("  Water Source     : " + waterSource);
        System.out.println("  Water Used       : " + waterUsedLitres + " litres");
        System.out.println("  Irrigation Date  : " + irrigationDate);
        System.out.println("  Duration         : " + durationHours + " hours");
        System.out.println("  Area Irrigated   : " + areaIrrigatedAcres + " acres");
        System.out.println("  Cost             : Rs." + costINR);
        System.out.println("  Operator         : " + operatorName);
        System.out.println("  Next Schedule    : " + nextScheduledDate);
        System.out.println("  Automated System : " + (automatedSystem ? "Yes" : "No"));
        System.out.println("========================================");
    }
}
