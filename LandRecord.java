// ===== LandRecord.java =====

/**
 * LandRecord extends Land — Inheritance.
 * Official land registration record.
 * Polymorphism: @Override display().
 */
public class LandRecord extends Land {

    // Private attributes specific to land records
    private String recordId;
    private String registrationDate;
    private String registeredBy;
    private String farmerId;
    private String landUseCategory;
    private double taxAmountINR;
    private boolean taxPaid;
    private String lastInspectionDate;
    private String zoneClassification;
    private String remarks;

    // Default Constructor
    public LandRecord() {
        super();
        this.recordId            = "R000";
        this.registrationDate    = "01-01-2024";
        this.registeredBy        = "Unknown";
        this.farmerId            = "F000";
        this.landUseCategory     = "Agricultural";
        this.taxAmountINR        = 0.0;
        this.taxPaid             = false;
        this.lastInspectionDate  = "01-01-2024";
        this.zoneClassification  = "Rural";
        this.remarks             = "None";
    }

    // Parameterized Constructor
    public LandRecord(String landId, String location, double areaAcres,
                      String landType, String ownerName, String soilIdAssigned,
                      String irrigationStatus, String currentUsage,
                      double marketValueINR, String surveyNumber,
                      String recordId, String registrationDate,
                      String registeredBy, String farmerId,
                      String landUseCategory, double taxAmountINR,
                      boolean taxPaid, String lastInspectionDate,
                      String zoneClassification, String remarks) {
        super(landId, location, areaAcres, landType, ownerName,
              soilIdAssigned, irrigationStatus, currentUsage,
              marketValueINR, surveyNumber);
        this.recordId           = recordId;
        this.registrationDate   = registrationDate;
        this.registeredBy       = registeredBy;
        this.farmerId           = farmerId;
        this.landUseCategory    = landUseCategory;
        this.taxAmountINR       = taxAmountINR;
        this.taxPaid            = taxPaid;
        this.lastInspectionDate = lastInspectionDate;
        this.zoneClassification = zoneClassification;
        this.remarks            = remarks;
    }

    // Getters
    public String getRecordId()             { return recordId; }
    public String getRegistrationDate()     { return registrationDate; }
    public String getRegisteredBy()         { return registeredBy; }
    public String getFarmerId()             { return farmerId; }
    public String getLandUseCategory()      { return landUseCategory; }
    public double getTaxAmountINR()         { return taxAmountINR; }
    public boolean isTaxPaid()              { return taxPaid; }
    public String getLastInspectionDate()   { return lastInspectionDate; }
    public String getZoneClassification()   { return zoneClassification; }
    public String getRemarks()              { return remarks; }

    // Setters
    public void setRecordId(String recordId)                         { this.recordId = recordId; }
    public void setRegistrationDate(String registrationDate)         { this.registrationDate = registrationDate; }
    public void setRegisteredBy(String registeredBy)                 { this.registeredBy = registeredBy; }
    public void setFarmerId(String farmerId)                         { this.farmerId = farmerId; }
    public void setLandUseCategory(String landUseCategory)           { this.landUseCategory = landUseCategory; }
    public void setTaxAmountINR(double taxAmountINR)                 { this.taxAmountINR = taxAmountINR; }
    public void setTaxPaid(boolean taxPaid)                          { this.taxPaid = taxPaid; }
    public void setLastInspectionDate(String lastInspectionDate)     { this.lastInspectionDate = lastInspectionDate; }
    public void setZoneClassification(String zoneClassification)     { this.zoneClassification = zoneClassification; }
    public void setRemarks(String remarks)                           { this.remarks = remarks; }

    // @Override display() — Polymorphism
    @Override
    public void display() {
        System.out.println("========== LAND REGISTRATION RECORD ==========");
        displayLandInfo();   // prints inherited Land fields
        System.out.println("  Record ID        : " + recordId);
        System.out.println("  Registration Date: " + registrationDate);
        System.out.println("  Registered By    : " + registeredBy);
        System.out.println("  Farmer ID        : " + farmerId);
        System.out.println("  Land Use Category: " + landUseCategory);
        System.out.println("  Tax Amount       : Rs." + taxAmountINR);
        System.out.println("  Tax Paid         : " + (taxPaid ? "Yes" : "No"));
        System.out.println("  Last Inspection  : " + lastInspectionDate);
        System.out.println("  Zone             : " + zoneClassification);
        System.out.println("  Remarks          : " + remarks);
        System.out.println("==============================================");
    }
}
