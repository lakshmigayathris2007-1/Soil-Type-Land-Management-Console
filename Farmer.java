// ===== Farmer.java =====

/**
 * Farmer represents a farmer who owns or manages land.
 */
public class Farmer {

    // Private attributes (Encapsulation)
    private String farmerId;
    private String farmerName;
    private int    age;
    private String gender;
    private String phoneNumber;
    private String address;
    private String village;
    private String district;
    private double totalLandOwnedAcres;
    private String educationLevel;
    private String bankAccountNumber;
    private String aadhaarNumber;

    // Default Constructor
    public Farmer() {
        this.farmerId            = "F000";
        this.farmerName          = "Unknown";
        this.age                 = 0;
        this.gender              = "Unknown";
        this.phoneNumber         = "0000000000";
        this.address             = "Unknown";
        this.village             = "Unknown";
        this.district            = "Unknown";
        this.totalLandOwnedAcres = 0.0;
        this.educationLevel      = "Unknown";
        this.bankAccountNumber   = "000000000";
        this.aadhaarNumber       = "000000000000";
    }

    // Parameterized Constructor
    public Farmer(String farmerId, String farmerName, int age,
                  String gender, String phoneNumber, String address,
                  String village, String district,
                  double totalLandOwnedAcres, String educationLevel,
                  String bankAccountNumber, String aadhaarNumber) {
        this.farmerId            = farmerId;
        this.farmerName          = farmerName;
        this.age                 = age;
        this.gender              = gender;
        this.phoneNumber         = phoneNumber;
        this.address             = address;
        this.village             = village;
        this.district            = district;
        this.totalLandOwnedAcres = totalLandOwnedAcres;
        this.educationLevel      = educationLevel;
        this.bankAccountNumber   = bankAccountNumber;
        this.aadhaarNumber       = aadhaarNumber;
    }

    // Getters
    public String getFarmerId()            { return farmerId; }
    public String getFarmerName()          { return farmerName; }
    public int    getAge()                 { return age; }
    public String getGender()              { return gender; }
    public String getPhoneNumber()         { return phoneNumber; }
    public String getAddress()             { return address; }
    public String getVillage()             { return village; }
    public String getDistrict()            { return district; }
    public double getTotalLandOwnedAcres() { return totalLandOwnedAcres; }
    public String getEducationLevel()      { return educationLevel; }
    public String getBankAccountNumber()   { return bankAccountNumber; }
    public String getAadhaarNumber()       { return aadhaarNumber; }

    // Setters
    public void setFarmerId(String farmerId)                         { this.farmerId = farmerId; }
    public void setFarmerName(String farmerName)                     { this.farmerName = farmerName; }
    public void setAge(int age)                                      { this.age = age; }
    public void setGender(String gender)                             { this.gender = gender; }
    public void setPhoneNumber(String phoneNumber)                   { this.phoneNumber = phoneNumber; }
    public void setAddress(String address)                           { this.address = address; }
    public void setVillage(String village)                           { this.village = village; }
    public void setDistrict(String district)                         { this.district = district; }
    public void setTotalLandOwnedAcres(double totalLandOwnedAcres)   { this.totalLandOwnedAcres = totalLandOwnedAcres; }
    public void setEducationLevel(String educationLevel)             { this.educationLevel = educationLevel; }
    public void setBankAccountNumber(String bankAccountNumber)       { this.bankAccountNumber = bankAccountNumber; }
    public void setAadhaarNumber(String aadhaarNumber)               { this.aadhaarNumber = aadhaarNumber; }

    // display()
    public void display() {
        System.out.println("========== FARMER DETAILS ==========");
        System.out.println("  Farmer ID        : " + farmerId);
        System.out.println("  Name             : " + farmerName);
        System.out.println("  Age              : " + age);
        System.out.println("  Gender           : " + gender);
        System.out.println("  Phone Number     : " + phoneNumber);
        System.out.println("  Address          : " + address);
        System.out.println("  Village          : " + village);
        System.out.println("  District         : " + district);
        System.out.println("  Total Land Owned : " + totalLandOwnedAcres + " acres");
        System.out.println("  Education Level  : " + educationLevel);
        System.out.println("  Bank Account No  : " + bankAccountNumber);
        System.out.println("  Aadhaar Number   : " + aadhaarNumber);
        System.out.println("====================================");
    }
}
