// ===== SoilTest.java =====

/**
 * SoilTest extends Soil — Inheritance.
 * Represents a lab/field test on a soil sample.
 * Polymorphism: @Override display(), plus overloaded display(boolean).
 */
public class SoilTest extends Soil {

    // Private attributes specific to a soil test
    private String testId;
    private String testDate;
    private String labName;
    private String technicianName;
    private String testMethod;
    private double salinityLevel;
    private double cationExchangeCapacity;
    private String fertilitySummary;
    private double bulkDensity;
    private String recommendations;

    // Default Constructor
    public SoilTest() {
        super();
        this.testId                 = "T000";
        this.testDate               = "01-01-2024";
        this.labName                = "Unknown Lab";
        this.technicianName         = "Unknown";
        this.testMethod             = "Standard";
        this.salinityLevel          = 0.0;
        this.cationExchangeCapacity = 0.0;
        this.fertilitySummary       = "Low";
        this.bulkDensity            = 1.0;
        this.recommendations        = "None";
    }

    // Parameterized Constructor
    public SoilTest(String soilId, String soilType, double phLevel,
                    double moistureContent, double organicMatter,
                    String texture, double nitrogenLevel,
                    double phosphorusLevel, double potassiumLevel, String color,
                    String testId, String testDate, String labName,
                    String technicianName, String testMethod,
                    double salinityLevel, double cationExchangeCapacity,
                    String fertilitySummary, double bulkDensity,
                    String recommendations) {
        super(soilId, soilType, phLevel, moistureContent, organicMatter,
              texture, nitrogenLevel, phosphorusLevel, potassiumLevel, color);
        this.testId                 = testId;
        this.testDate               = testDate;
        this.labName                = labName;
        this.technicianName         = technicianName;
        this.testMethod             = testMethod;
        this.salinityLevel          = salinityLevel;
        this.cationExchangeCapacity = cationExchangeCapacity;
        this.fertilitySummary       = fertilitySummary;
        this.bulkDensity            = bulkDensity;
        this.recommendations        = recommendations;
    }

    // Getters
    public String getTestId()                 { return testId; }
    public String getTestDate()               { return testDate; }
    public String getLabName()                { return labName; }
    public String getTechnicianName()         { return technicianName; }
    public String getTestMethod()             { return testMethod; }
    public double getSalinityLevel()          { return salinityLevel; }
    public double getCationExchangeCapacity() { return cationExchangeCapacity; }
    public String getFertilitySummary()       { return fertilitySummary; }
    public double getBulkDensity()            { return bulkDensity; }
    public String getRecommendations()        { return recommendations; }

    // Setters
    public void setTestId(String testId)                               { this.testId = testId; }
    public void setTestDate(String testDate)                           { this.testDate = testDate; }
    public void setLabName(String labName)                             { this.labName = labName; }
    public void setTechnicianName(String technicianName)               { this.technicianName = technicianName; }
    public void setTestMethod(String testMethod)                       { this.testMethod = testMethod; }
    public void setSalinityLevel(double salinityLevel)                 { this.salinityLevel = salinityLevel; }
    public void setCationExchangeCapacity(double cec)                  { this.cationExchangeCapacity = cec; }
    public void setFertilitySummary(String fertilitySummary)           { this.fertilitySummary = fertilitySummary; }
    public void setBulkDensity(double bulkDensity)                     { this.bulkDensity = bulkDensity; }
    public void setRecommendations(String recommendations)             { this.recommendations = recommendations; }

    // @Override display() — Polymorphism
    @Override
    public void display() {
        System.out.println("========== SOIL TEST RECORD ==========");
        displaySoilInfo();   // prints inherited Soil fields
        System.out.println("  Test ID          : " + testId);
        System.out.println("  Test Date        : " + testDate);
        System.out.println("  Lab Name         : " + labName);
        System.out.println("  Technician       : " + technicianName);
        System.out.println("  Test Method      : " + testMethod);
        System.out.println("  Salinity (dS/m)  : " + salinityLevel);
        System.out.println("  CEC (meq/100g)   : " + cationExchangeCapacity);
        System.out.println("  Fertility Summary: " + fertilitySummary);
        System.out.println("  Bulk Density     : " + bulkDensity + " g/cm3");
        System.out.println("  Recommendations  : " + recommendations);
        System.out.println("======================================");
    }

    // Overloaded display(boolean) — Method Overloading
    public void display(boolean compact) {
        if (compact) {
            System.out.println("  [SoilTest] " + getTestId()
                + " | Type: " + getSoilType()
                + " | pH: " + getPhLevel()
                + " | Fertility: " + fertilitySummary);
        } else {
            display();
        }
    }
}
