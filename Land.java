// ===== Land.java =====

/**
 * Land represents a parcel of agricultural land.
 * Parent class for LandRecord (Inheritance).
 */
public class Land {

    // Private attributes (Encapsulation)
    private String landId;
    private String location;
    private double areaAcres;
    private String landType;
    private String ownerName;
    private String soilIdAssigned;
    private String irrigationStatus;
    private String currentUsage;
    private double marketValueINR;
    private String surveyNumber;

    // Default Constructor
    public Land() {
        this.landId           = "L000";
        this.location         = "Unknown";
        this.areaAcres        = 0.0;
        this.landType         = "Agricultural";
        this.ownerName        = "Unknown";
        this.soilIdAssigned   = "S000";
        this.irrigationStatus = "Rain-fed";
        this.currentUsage     = "Fallow";
        this.marketValueINR   = 0.0;
        this.surveyNumber     = "SN-000";
    }

    // Parameterized Constructor
    public Land(String landId, String location, double areaAcres,
                String landType, String ownerName, String soilIdAssigned,
                String irrigationStatus, String currentUsage,
                double marketValueINR, String surveyNumber) {
        this.landId           = landId;
        this.location         = location;
        this.areaAcres        = areaAcres;
        this.landType         = landType;
        this.ownerName        = ownerName;
        this.soilIdAssigned   = soilIdAssigned;
        this.irrigationStatus = irrigationStatus;
        this.currentUsage     = currentUsage;
        this.marketValueINR   = marketValueINR;
        this.surveyNumber     = surveyNumber;
    }

    // Getters
    public String getLandId()           { return landId; }
    public String getLocation()         { return location; }
    public double getAreaAcres()        { return areaAcres; }
    public String getLandType()         { return landType; }
    public String getOwnerName()        { return ownerName; }
    public String getSoilIdAssigned()   { return soilIdAssigned; }
    public String getIrrigationStatus() { return irrigationStatus; }
    public String getCurrentUsage()     { return currentUsage; }
    public double getMarketValueINR()   { return marketValueINR; }
    public String getSurveyNumber()     { return surveyNumber; }

    // Setters
    public void setLandId(String landId)                     { this.landId = landId; }
    public void setLocation(String location)                 { this.location = location; }
    public void setAreaAcres(double areaAcres)               { this.areaAcres = areaAcres; }
    public void setLandType(String landType)                 { this.landType = landType; }
    public void setOwnerName(String ownerName)               { this.ownerName = ownerName; }
    public void setSoilIdAssigned(String soilIdAssigned)     { this.soilIdAssigned = soilIdAssigned; }
    public void setIrrigationStatus(String irrigationStatus) { this.irrigationStatus = irrigationStatus; }
    public void setCurrentUsage(String currentUsage)         { this.currentUsage = currentUsage; }
    public void setMarketValueINR(double marketValueINR)     { this.marketValueINR = marketValueINR; }
    public void setSurveyNumber(String surveyNumber)         { this.surveyNumber = surveyNumber; }

    // display() — can be overridden by LandRecord
    public void display() {
        System.out.println("========== LAND RECORD ==========");
        displayLandInfo();
        System.out.println("=================================");
    }

    // Protected helper so LandRecord can reuse these lines
    protected void displayLandInfo() {
        System.out.println("  Land ID          : " + landId);
        System.out.println("  Location         : " + location);
        System.out.println("  Area (Acres)     : " + areaAcres);
        System.out.println("  Land Type        : " + landType);
        System.out.println("  Owner Name       : " + ownerName);
        System.out.println("  Soil ID Assigned : " + soilIdAssigned);
        System.out.println("  Irrigation Status: " + irrigationStatus);
        System.out.println("  Current Usage    : " + currentUsage);
        System.out.println("  Market Value     : Rs." + marketValueINR);
        System.out.println("  Survey Number    : " + surveyNumber);
    }
}
