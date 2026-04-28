// ===== Crop.java =====

/**
 * Crop represents a crop grown on a land parcel.
 * Method Overloading: display() and display(boolean compact).
 */
public class Crop {

    // Private attributes (Encapsulation)
    private String cropId;
    private String cropName;
    private String cropType;
    private String landId;
    private String sowingDate;
    private String harvestDate;
    private double expectedYieldTons;
    private double actualYieldTons;
    private String season;
    private double waterRequirementMM;
    private String pesticideUsed;
    private String growthStage;

    // Default Constructor
    public Crop() {
        this.cropId             = "C000";
        this.cropName           = "Unknown";
        this.cropType           = "Unknown";
        this.landId             = "L000";
        this.sowingDate         = "01-01-2024";
        this.harvestDate        = "01-06-2024";
        this.expectedYieldTons  = 0.0;
        this.actualYieldTons    = 0.0;
        this.season             = "Kharif";
        this.waterRequirementMM = 0.0;
        this.pesticideUsed      = "None";
        this.growthStage        = "Seedling";
    }

    // Parameterized Constructor
    public Crop(String cropId, String cropName, String cropType,
                String landId, String sowingDate, String harvestDate,
                double expectedYieldTons, double actualYieldTons,
                String season, double waterRequirementMM,
                String pesticideUsed, String growthStage) {
        this.cropId             = cropId;
        this.cropName           = cropName;
        this.cropType           = cropType;
        this.landId             = landId;
        this.sowingDate         = sowingDate;
        this.harvestDate        = harvestDate;
        this.expectedYieldTons  = expectedYieldTons;
        this.actualYieldTons    = actualYieldTons;
        this.season             = season;
        this.waterRequirementMM = waterRequirementMM;
        this.pesticideUsed      = pesticideUsed;
        this.growthStage        = growthStage;
    }

    // Getters
    public String getCropId()              { return cropId; }
    public String getCropName()            { return cropName; }
    public String getCropType()            { return cropType; }
    public String getLandId()              { return landId; }
    public String getSowingDate()          { return sowingDate; }
    public String getHarvestDate()         { return harvestDate; }
    public double getExpectedYieldTons()   { return expectedYieldTons; }
    public double getActualYieldTons()     { return actualYieldTons; }
    public String getSeason()              { return season; }
    public double getWaterRequirementMM()  { return waterRequirementMM; }
    public String getPesticideUsed()       { return pesticideUsed; }
    public String getGrowthStage()         { return growthStage; }

    // Setters
    public void setCropId(String cropId)                           { this.cropId = cropId; }
    public void setCropName(String cropName)                       { this.cropName = cropName; }
    public void setCropType(String cropType)                       { this.cropType = cropType; }
    public void setLandId(String landId)                           { this.landId = landId; }
    public void setSowingDate(String sowingDate)                   { this.sowingDate = sowingDate; }
    public void setHarvestDate(String harvestDate)                 { this.harvestDate = harvestDate; }
    public void setExpectedYieldTons(double expectedYieldTons)     { this.expectedYieldTons = expectedYieldTons; }
    public void setActualYieldTons(double actualYieldTons)         { this.actualYieldTons = actualYieldTons; }
    public void setSeason(String season)                           { this.season = season; }
    public void setWaterRequirementMM(double waterRequirementMM)   { this.waterRequirementMM = waterRequirementMM; }
    public void setPesticideUsed(String pesticideUsed)             { this.pesticideUsed = pesticideUsed; }
    public void setGrowthStage(String growthStage)                 { this.growthStage = growthStage; }

    // display() — full details
    public void display() {
        System.out.println("========== CROP DETAILS ==========");
        System.out.println("  Crop ID          : " + cropId);
        System.out.println("  Crop Name        : " + cropName);
        System.out.println("  Crop Type        : " + cropType);
        System.out.println("  Land ID          : " + landId);
        System.out.println("  Sowing Date      : " + sowingDate);
        System.out.println("  Harvest Date     : " + harvestDate);
        System.out.println("  Expected Yield   : " + expectedYieldTons + " tons");
        System.out.println("  Actual Yield     : " + actualYieldTons + " tons");
        System.out.println("  Season           : " + season);
        System.out.println("  Water Requirement: " + waterRequirementMM + " mm");
        System.out.println("  Pesticide Used   : " + pesticideUsed);
        System.out.println("  Growth Stage     : " + growthStage);
        System.out.println("==================================");
    }

    // Overloaded display(boolean) — compact mode (Method Overloading)
    public void display(boolean compact) {
        if (compact) {
            System.out.println("  [Crop] " + cropId + " | " + cropName
                + " | " + season + " | Stage: " + growthStage);
        } else {
            display();
        }
    }
}
