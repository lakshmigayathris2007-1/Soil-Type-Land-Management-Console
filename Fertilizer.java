// ===== Fertilizer.java =====

/**
 * Fertilizer records fertilizer application for a land parcel and crop.
 */
public class Fertilizer {

    // Private attributes (Encapsulation)
    private String fertilizerId;
    private String fertilizerName;
    private String fertilizerType;
    private String landId;
    private String cropId;
    private double quantityKg;
    private String applicationDate;
    private String applicationMethod;
    private double costPerKgINR;
    private String manufacturer;
    private String npkRatio;
    private String storageConditions;

    // Default Constructor
    public Fertilizer() {
        this.fertilizerId      = "FT000";
        this.fertilizerName    = "Unknown";
        this.fertilizerType    = "Inorganic";
        this.landId            = "L000";
        this.cropId            = "C000";
        this.quantityKg        = 0.0;
        this.applicationDate   = "01-01-2024";
        this.applicationMethod = "Broadcast";
        this.costPerKgINR      = 0.0;
        this.manufacturer      = "Unknown";
        this.npkRatio          = "0-0-0";
        this.storageConditions = "Dry";
    }

    // Parameterized Constructor
    public Fertilizer(String fertilizerId, String fertilizerName,
                      String fertilizerType, String landId, String cropId,
                      double quantityKg, String applicationDate,
                      String applicationMethod, double costPerKgINR,
                      String manufacturer, String npkRatio,
                      String storageConditions) {
        this.fertilizerId      = fertilizerId;
        this.fertilizerName    = fertilizerName;
        this.fertilizerType    = fertilizerType;
        this.landId            = landId;
        this.cropId            = cropId;
        this.quantityKg        = quantityKg;
        this.applicationDate   = applicationDate;
        this.applicationMethod = applicationMethod;
        this.costPerKgINR      = costPerKgINR;
        this.manufacturer      = manufacturer;
        this.npkRatio          = npkRatio;
        this.storageConditions = storageConditions;
    }

    // Getters
    public String getFertilizerId()      { return fertilizerId; }
    public String getFertilizerName()    { return fertilizerName; }
    public String getFertilizerType()    { return fertilizerType; }
    public String getLandId()            { return landId; }
    public String getCropId()            { return cropId; }
    public double getQuantityKg()        { return quantityKg; }
    public String getApplicationDate()   { return applicationDate; }
    public String getApplicationMethod() { return applicationMethod; }
    public double getCostPerKgINR()      { return costPerKgINR; }
    public String getManufacturer()      { return manufacturer; }
    public String getNpkRatio()          { return npkRatio; }
    public String getStorageConditions() { return storageConditions; }

    // Setters
    public void setFertilizerId(String fertilizerId)             { this.fertilizerId = fertilizerId; }
    public void setFertilizerName(String fertilizerName)         { this.fertilizerName = fertilizerName; }
    public void setFertilizerType(String fertilizerType)         { this.fertilizerType = fertilizerType; }
    public void setLandId(String landId)                         { this.landId = landId; }
    public void setCropId(String cropId)                         { this.cropId = cropId; }
    public void setQuantityKg(double quantityKg)                 { this.quantityKg = quantityKg; }
    public void setApplicationDate(String applicationDate)       { this.applicationDate = applicationDate; }
    public void setApplicationMethod(String applicationMethod)   { this.applicationMethod = applicationMethod; }
    public void setCostPerKgINR(double costPerKgINR)             { this.costPerKgINR = costPerKgINR; }
    public void setManufacturer(String manufacturer)             { this.manufacturer = manufacturer; }
    public void setNpkRatio(String npkRatio)                     { this.npkRatio = npkRatio; }
    public void setStorageConditions(String storageConditions)   { this.storageConditions = storageConditions; }

    // display()
    public void display() {
        System.out.println("========== FERTILIZER DETAILS ==========");
        System.out.println("  Fertilizer ID    : " + fertilizerId);
        System.out.println("  Name             : " + fertilizerName);
        System.out.println("  Type             : " + fertilizerType);
        System.out.println("  Land ID          : " + landId);
        System.out.println("  Crop ID          : " + cropId);
        System.out.println("  Quantity Applied : " + quantityKg + " kg");
        System.out.println("  Application Date : " + applicationDate);
        System.out.println("  Application Mthd : " + applicationMethod);
        System.out.println("  Cost per kg      : Rs." + costPerKgINR);
        System.out.println("  Manufacturer     : " + manufacturer);
        System.out.println("  NPK Ratio        : " + npkRatio);
        System.out.println("  Storage          : " + storageConditions);
        System.out.println("========================================");
    }
}
