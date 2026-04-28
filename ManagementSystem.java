// ===== ManagementSystem.java =====

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ManagementSystem — main entry point.
 *
 * SOIL TYPE & LAND USAGE MANAGEMENT SYSTEM
 * College-level Experiential Learning Project
 *
 * OOP: Encapsulation, Inheritance, Polymorphism, Abstraction
 * Collections: ArrayList, HashMap, List interface, Iterator
 * File I/O: FileWriter + BufferedWriter, FileReader + BufferedReader
 * Exception Handling: try-catch for IOException and NumberFormatException
 *
 * All 10 features implemented:
 *  1. Add Soil Details
 *  2. Add Land Details
 *  3. Add Farmer Details
 *  4. Assign Soil to Land
 *  5. Store Crop Usage
 *  6. Save All Records to File
 *  7. Load Records from File
 *  8. Display All Records (Iterator)
 *  9. Update Land Usage
 * 10. Delete a Record
 */
public class ManagementSystem {

    // ── Collections — declared as List interface (requirement) ──────────────
    private static List<SoilTest>    soilList       = new ArrayList<>();
    private static List<LandRecord>  landList       = new ArrayList<>();
    private static List<Farmer>      farmerList     = new ArrayList<>();
    private static List<Crop>        cropList       = new ArrayList<>();
    private static List<Fertilizer>  fertilizerList = new ArrayList<>();
    private static List<Irrigation>  irrigationList = new ArrayList<>();
    private static List<WeatherData> weatherList    = new ArrayList<>();

    // ── HashMap: Land ID --> Farmer ID ──────────────────────────────────────
    private static HashMap<String, String> landFarmerMap = new HashMap<>();

    // ── Output file name ─────────────────────────────────────────────────────
    private static final String FILE_NAME = "records.txt";

    // ── Single Scanner for all user input ────────────────────────────────────
    private static Scanner sc = new Scanner(System.in);

    // ════════════════════════════════════════════════════════════════════════
    //  MAIN METHOD
    // ════════════════════════════════════════════════════════════════════════
    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("  SOIL TYPE & LAND USAGE MANAGEMENT SYSTEM   ");
        System.out.println("==============================================");

        int choice = -1;

        while (choice != 0) {
            printMenu();
            choice = readInt("Enter choice");

            switch (choice) {
                case 1:  addSoilDetails();    break;
                case 2:  addLandDetails();    break;
                case 3:  addFarmerDetails();  break;
                case 4:  assignSoilToLand();  break;
                case 5:  storeCropUsage();    break;
                case 6:  saveAllRecords();    break;
                case 7:  loadAllRecords();    break;
                case 8:  displayAllRecords(); break;
                case 9:  updateLandUsage();   break;
                case 10: deleteRecord();      break;
                case 11: addFertilizer();     break;
                case 12: addIrrigation();     break;
                case 13: addWeatherData();    break;
                case 14: viewLandFarmerMap(); break;
                case 0:
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("[!] Invalid option. Enter 0-14.");
            }
        }

        sc.close();
    }

    // ────────────────────────────────────────────────────────────────────────
    //  MENU
    // ────────────────────────────────────────────────────────────────────────
    private static void printMenu() {
        System.out.println("\n============= MENU =============");
        System.out.println(" 1.  Add Soil Details");
        System.out.println(" 2.  Add Land Details");
        System.out.println(" 3.  Add Farmer Details");
        System.out.println(" 4.  Assign Soil to Land");
        System.out.println(" 5.  Store Crop Usage");
        System.out.println(" 6.  Save All Records to File");
        System.out.println(" 7.  Load Records from File");
        System.out.println(" 8.  Display All Records");
        System.out.println(" 9.  Update Land Usage");
        System.out.println(" 10. Delete a Record");
        System.out.println(" 11. Add Fertilizer");
        System.out.println(" 12. Add Irrigation");
        System.out.println(" 13. Add Weather Data");
        System.out.println(" 14. View Land-Farmer Map");
        System.out.println(" 0.  Exit");
        System.out.println("================================");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 1 — Add Soil Details
    // ════════════════════════════════════════════════════════════════════════
    private static void addSoilDetails() {
        System.out.println("\n--- Add Soil Details ---");

        String soilId    = readStr("Soil ID (e.g. S001)");
        String soilType  = readStr("Soil Type (Clay/Loam/Sandy)");
        double ph        = readDouble("pH Level (0-14)");
        double moisture  = readDouble("Moisture Content (%)");
        double organic   = readDouble("Organic Matter (%)");
        String texture   = readStr("Texture (Fine/Medium/Coarse)");
        double nitrogen  = readDouble("Nitrogen Level (mg/kg)");
        double phosph    = readDouble("Phosphorus Level (mg/kg)");
        double potassium = readDouble("Potassium Level (mg/kg)");
        String color     = readStr("Soil Color");

        String testId    = readStr("Test ID (e.g. T001)");
        String testDate  = readStr("Test Date (DD-MM-YYYY)");
        String labName   = readStr("Lab Name");
        String tech      = readStr("Technician Name");
        String method    = readStr("Test Method");
        double salinity  = readDouble("Salinity (dS/m)");
        double cec       = readDouble("CEC (meq/100g)");
        String fertility = readStr("Fertility (Low/Medium/High)");
        double bulk      = readDouble("Bulk Density (g/cm3)");
        String recs      = readStr("Recommendations");

        SoilTest st = new SoilTest(
            soilId, soilType, ph, moisture, organic,
            texture, nitrogen, phosph, potassium, color,
            testId, testDate, labName, tech, method,
            salinity, cec, fertility, bulk, recs
        );
        soilList.add(st);
        System.out.println("[OK] Soil record added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 2 — Add Land Details
    // ════════════════════════════════════════════════════════════════════════
    private static void addLandDetails() {
        System.out.println("\n--- Add Land Details ---");

        String landId    = readStr("Land ID (e.g. L001)");
        String location  = readStr("Location");
        double area      = readDouble("Area (Acres)");
        String landType  = readStr("Land Type (Agricultural/Forest/Barren)");
        String owner     = readStr("Owner Name");
        String soilId    = readStr("Soil ID Assigned");
        String irrSts    = readStr("Irrigation Status (Irrigated/Rain-fed)");
        String usage     = readStr("Current Usage (Crop or Fallow)");
        double mktVal    = readDouble("Market Value (INR)");
        String survey    = readStr("Survey Number");

        String recordId  = readStr("Record ID (e.g. R001)");
        String regDate   = readStr("Registration Date (DD-MM-YYYY)");
        String regBy     = readStr("Registered By");
        String farmerId  = readStr("Farmer ID (e.g. F001)");
        String useCat    = readStr("Land Use Category");
        double tax       = readDouble("Tax Amount (INR)");
        boolean taxPaid  = readStr("Tax Paid? (yes/no)").equalsIgnoreCase("yes");
        String lastInsp  = readStr("Last Inspection Date (DD-MM-YYYY)");
        String zone      = readStr("Zone (Urban/Rural/Semi-Urban)");
        String remarks   = readStr("Remarks");

        LandRecord lr = new LandRecord(
            landId, location, area, landType, owner,
            soilId, irrSts, usage, mktVal, survey,
            recordId, regDate, regBy, farmerId, useCat,
            tax, taxPaid, lastInsp, zone, remarks
        );
        landList.add(lr);
        landFarmerMap.put(landId, farmerId);   // store in HashMap
        System.out.println("[OK] Land record added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 3 — Add Farmer Details
    // ════════════════════════════════════════════════════════════════════════
    private static void addFarmerDetails() {
        System.out.println("\n--- Add Farmer Details ---");

        String fId      = readStr("Farmer ID (e.g. F001)");
        String name     = readStr("Farmer Name");
        int    age      = readInt("Age");
        String gender   = readStr("Gender");
        String phone    = readStr("Phone Number");
        String address  = readStr("Address");
        String village  = readStr("Village");
        String district = readStr("District");
        double landAcr  = readDouble("Total Land Owned (acres)");
        String edu      = readStr("Education Level");
        String bank     = readStr("Bank Account Number");
        String aadhaar  = readStr("Aadhaar Number");

        Farmer f = new Farmer(fId, name, age, gender, phone,
            address, village, district, landAcr, edu, bank, aadhaar);
        farmerList.add(f);
        System.out.println("[OK] Farmer record added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 4 — Assign Soil to Land
    // ════════════════════════════════════════════════════════════════════════
    private static void assignSoilToLand() {
        System.out.println("\n--- Assign Soil to Land ---");

        if (landList.isEmpty()) {
            System.out.println("[!] No land records. Add land first (Option 2).");
            return;
        }

        String landId = readStr("Enter Land ID");
        String soilId = readStr("Enter Soil ID to assign");
        boolean found = false;

        for (LandRecord lr : landList) {
            if (lr.getLandId().equalsIgnoreCase(landId)) {
                lr.setSoilIdAssigned(soilId);   // setter — Encapsulation
                found = true;
                System.out.println("[OK] Soil " + soilId + " assigned to Land " + landId);
                break;
            }
        }

        if (!found) {
            System.out.println("[!] Land ID '" + landId + "' not found.");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 5 — Store Crop Usage
    // ════════════════════════════════════════════════════════════════════════
    private static void storeCropUsage() {
        System.out.println("\n--- Store Crop Usage ---");

        String cropId   = readStr("Crop ID (e.g. C001)");
        String cropName = readStr("Crop Name");
        String cropType = readStr("Crop Type (Cereal/Pulse/Vegetable/Fruit)");
        String landId   = readStr("Land ID");
        String sowDate  = readStr("Sowing Date (DD-MM-YYYY)");
        String harvDate = readStr("Harvest Date (DD-MM-YYYY)");
        double expYield = readDouble("Expected Yield (tons)");
        double actYield = readDouble("Actual Yield (tons)");
        String season   = readStr("Season (Kharif/Rabi/Zaid)");
        double water    = readDouble("Water Requirement (mm)");
        String pest     = readStr("Pesticide Used");
        String stage    = readStr("Growth Stage");

        Crop crop = new Crop(cropId, cropName, cropType, landId,
            sowDate, harvDate, expYield, actYield,
            season, water, pest, stage);
        cropList.add(crop);

        // Update land record's current usage field
        for (LandRecord lr : landList) {
            if (lr.getLandId().equalsIgnoreCase(landId)) {
                lr.setCurrentUsage(cropName);
                break;
            }
        }

        System.out.println("[OK] Crop record added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 6 — Save All Records to File
    //  FileWriter + BufferedWriter; IOException caught with try-catch
    // ════════════════════════════════════════════════════════════════════════
    private static void saveAllRecords() {
        System.out.println("\n--- Saving to " + FILE_NAME + " ---");

        try (FileWriter fw = new FileWriter(FILE_NAME);
             BufferedWriter bw = new BufferedWriter(fw)) {

            // Save soil records
            bw.write("===SOIL==="); bw.newLine();
            for (SoilTest s : soilList) {
                bw.write("SOIL|" + s.getSoilId() + "|" + s.getSoilType()
                    + "|" + s.getPhLevel() + "|" + s.getMoistureContent()
                    + "|" + s.getOrganicMatter() + "|" + s.getTexture()
                    + "|" + s.getNitrogenLevel() + "|" + s.getPhosphorusLevel()
                    + "|" + s.getPotassiumLevel() + "|" + s.getColor()
                    + "|" + s.getTestId() + "|" + s.getTestDate()
                    + "|" + s.getLabName() + "|" + s.getTechnicianName()
                    + "|" + s.getTestMethod() + "|" + s.getSalinityLevel()
                    + "|" + s.getCationExchangeCapacity()
                    + "|" + s.getFertilitySummary()
                    + "|" + s.getBulkDensity() + "|" + s.getRecommendations());
                bw.newLine();
            }

            // Save land records
            bw.write("===LAND==="); bw.newLine();
            for (LandRecord l : landList) {
                bw.write("LAND|" + l.getLandId() + "|" + l.getLocation()
                    + "|" + l.getAreaAcres() + "|" + l.getLandType()
                    + "|" + l.getOwnerName() + "|" + l.getSoilIdAssigned()
                    + "|" + l.getIrrigationStatus() + "|" + l.getCurrentUsage()
                    + "|" + l.getMarketValueINR() + "|" + l.getSurveyNumber()
                    + "|" + l.getRecordId() + "|" + l.getRegistrationDate()
                    + "|" + l.getRegisteredBy() + "|" + l.getFarmerId()
                    + "|" + l.getLandUseCategory() + "|" + l.getTaxAmountINR()
                    + "|" + l.isTaxPaid() + "|" + l.getLastInspectionDate()
                    + "|" + l.getZoneClassification() + "|" + l.getRemarks());
                bw.newLine();
            }

            // Save farmer records
            bw.write("===FARMER==="); bw.newLine();
            for (Farmer f : farmerList) {
                bw.write("FARMER|" + f.getFarmerId() + "|" + f.getFarmerName()
                    + "|" + f.getAge() + "|" + f.getGender()
                    + "|" + f.getPhoneNumber() + "|" + f.getAddress()
                    + "|" + f.getVillage() + "|" + f.getDistrict()
                    + "|" + f.getTotalLandOwnedAcres() + "|" + f.getEducationLevel()
                    + "|" + f.getBankAccountNumber() + "|" + f.getAadhaarNumber());
                bw.newLine();
            }

            // Save crop records
            bw.write("===CROP==="); bw.newLine();
            for (Crop c : cropList) {
                bw.write("CROP|" + c.getCropId() + "|" + c.getCropName()
                    + "|" + c.getCropType() + "|" + c.getLandId()
                    + "|" + c.getSowingDate() + "|" + c.getHarvestDate()
                    + "|" + c.getExpectedYieldTons() + "|" + c.getActualYieldTons()
                    + "|" + c.getSeason() + "|" + c.getWaterRequirementMM()
                    + "|" + c.getPesticideUsed() + "|" + c.getGrowthStage());
                bw.newLine();
            }

            // Save fertilizer records
            bw.write("===FERTILIZER==="); bw.newLine();
            for (Fertilizer ft : fertilizerList) {
                bw.write("FERTILIZER|" + ft.getFertilizerId()
                    + "|" + ft.getFertilizerName() + "|" + ft.getFertilizerType()
                    + "|" + ft.getLandId() + "|" + ft.getCropId()
                    + "|" + ft.getQuantityKg() + "|" + ft.getApplicationDate()
                    + "|" + ft.getApplicationMethod() + "|" + ft.getCostPerKgINR()
                    + "|" + ft.getManufacturer() + "|" + ft.getNpkRatio()
                    + "|" + ft.getStorageConditions());
                bw.newLine();
            }

            // Save irrigation records
            bw.write("===IRRIGATION==="); bw.newLine();
            for (Irrigation ir : irrigationList) {
                bw.write("IRRIGATION|" + ir.getIrrigationId()
                    + "|" + ir.getLandId() + "|" + ir.getIrrigationType()
                    + "|" + ir.getWaterSource() + "|" + ir.getWaterUsedLitres()
                    + "|" + ir.getIrrigationDate() + "|" + ir.getDurationHours()
                    + "|" + ir.getAreaIrrigatedAcres() + "|" + ir.getCostINR()
                    + "|" + ir.getOperatorName() + "|" + ir.getNextScheduledDate()
                    + "|" + ir.isAutomatedSystem());
                bw.newLine();
            }

            // Save weather records
            bw.write("===WEATHER==="); bw.newLine();
            for (WeatherData w : weatherList) {
                bw.write("WEATHER|" + w.getWeatherId() + "|" + w.getLandId()
                    + "|" + w.getObservationDate() + "|" + w.getTemperatureMaxC()
                    + "|" + w.getTemperatureMinC() + "|" + w.getRainfallMM()
                    + "|" + w.getHumidityPercent() + "|" + w.getWindSpeedKmh()
                    + "|" + w.getWindDirection() + "|" + w.getSolarRadiation()
                    + "|" + w.getWeatherCondition() + "|" + w.getRecordedBy());
                bw.newLine();
            }

            // Save HashMap entries
            bw.write("===MAP==="); bw.newLine();
            for (HashMap.Entry<String, String> e : landFarmerMap.entrySet()) {
                bw.write("MAP|" + e.getKey() + "|" + e.getValue());
                bw.newLine();
            }

            System.out.println("[OK] All records saved to '" + FILE_NAME + "'.");

        } catch (IOException e) {
            System.out.println("[ERROR] Could not save file: " + e.getMessage());
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 7 — Load Records from File
    //  FileReader + BufferedReader; IOException caught with try-catch
    // ════════════════════════════════════════════════════════════════════════
    private static void loadAllRecords() {
        System.out.println("\n--- Loading from " + FILE_NAME + " ---");

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("[!] File not found. Save first (Option 6).");
            return;
        }

        // Clear current data before loading
        soilList.clear(); landList.clear(); farmerList.clear();
        cropList.clear(); fertilizerList.clear();
        irrigationList.clear(); weatherList.clear();
        landFarmerMap.clear();

        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("===")) continue;

                // Split line by | into tokens
                String[] p = line.split("\\|", -1);

                switch (p[0]) {
                    case "SOIL":
                        if (p.length >= 21) {
                            soilList.add(new SoilTest(
                                p[1],  p[2],  toDbl(p[3]),  toDbl(p[4]),  toDbl(p[5]),
                                p[6],  toDbl(p[7]),  toDbl(p[8]),  toDbl(p[9]),  p[10],
                                p[11], p[12], p[13], p[14], p[15],
                                toDbl(p[16]), toDbl(p[17]), p[18], toDbl(p[19]), p[20]
                            ));
                        }
                        break;

                    case "LAND":
                        if (p.length >= 21) {
                            landList.add(new LandRecord(
                                p[1], p[2], toDbl(p[3]), p[4], p[5],
                                p[6], p[7], p[8], toDbl(p[9]), p[10],
                                p[11], p[12], p[13], p[14], p[15],
                                toDbl(p[16]), Boolean.parseBoolean(p[17]),
                                p[18], p[19], p[20]
                            ));
                        }
                        break;

                    case "FARMER":
                        if (p.length >= 13) {
                            farmerList.add(new Farmer(
                                p[1], p[2], toInt(p[3]), p[4], p[5],
                                p[6], p[7], p[8], toDbl(p[9]), p[10], p[11], p[12]
                            ));
                        }
                        break;

                    case "CROP":
                        if (p.length >= 13) {
                            cropList.add(new Crop(
                                p[1], p[2], p[3], p[4], p[5], p[6],
                                toDbl(p[7]), toDbl(p[8]),
                                p[9], toDbl(p[10]), p[11], p[12]
                            ));
                        }
                        break;

                    case "FERTILIZER":
                        if (p.length >= 13) {
                            fertilizerList.add(new Fertilizer(
                                p[1], p[2], p[3], p[4], p[5],
                                toDbl(p[6]), p[7], p[8],
                                toDbl(p[9]), p[10], p[11], p[12]
                            ));
                        }
                        break;

                    case "IRRIGATION":
                        if (p.length >= 13) {
                            irrigationList.add(new Irrigation(
                                p[1], p[2], p[3], p[4],
                                toDbl(p[5]), p[6], toDbl(p[7]),
                                toDbl(p[8]), toDbl(p[9]),
                                p[10], p[11], Boolean.parseBoolean(p[12])
                            ));
                        }
                        break;

                    case "WEATHER":
                        if (p.length >= 13) {
                            weatherList.add(new WeatherData(
                                p[1], p[2], p[3],
                                toDbl(p[4]), toDbl(p[5]), toDbl(p[6]),
                                toDbl(p[7]), toDbl(p[8]),
                                p[9], toDbl(p[10]), p[11], p[12]
                            ));
                        }
                        break;

                    case "MAP":
                        if (p.length >= 3) {
                            landFarmerMap.put(p[1], p[2]);
                        }
                        break;

                    default:
                        break;
                }
            }

            System.out.println("[OK] Records loaded from '" + FILE_NAME + "'.");

        } catch (IOException e) {
            System.out.println("[ERROR] Could not read file: " + e.getMessage());
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 8 — Display All Records using Iterator<T>
    // ════════════════════════════════════════════════════════════════════════
    private static void displayAllRecords() {
        System.out.println("\n========= ALL RECORDS =========");

        // Iterator<SoilTest>
        System.out.println("\n>> SOIL TEST RECORDS (" + soilList.size() + ")");
        Iterator<SoilTest> si = soilList.iterator();
        if (!si.hasNext()) System.out.println("  (none)");
        while (si.hasNext()) {
            si.next().display();   // polymorphic — SoilTest @Override display()
        }

        // Iterator<LandRecord>
        System.out.println("\n>> LAND RECORDS (" + landList.size() + ")");
        Iterator<LandRecord> li = landList.iterator();
        if (!li.hasNext()) System.out.println("  (none)");
        while (li.hasNext()) {
            li.next().display();   // polymorphic — LandRecord @Override display()
        }

        // Iterator<Farmer>
        System.out.println("\n>> FARMER RECORDS (" + farmerList.size() + ")");
        Iterator<Farmer> fi = farmerList.iterator();
        if (!fi.hasNext()) System.out.println("  (none)");
        while (fi.hasNext()) {
            fi.next().display();
        }

        // Iterator<Crop>
        System.out.println("\n>> CROP RECORDS (" + cropList.size() + ")");
        Iterator<Crop> ci = cropList.iterator();
        if (!ci.hasNext()) System.out.println("  (none)");
        while (ci.hasNext()) {
            ci.next().display();
        }

        // Iterator<Fertilizer>
        System.out.println("\n>> FERTILIZER RECORDS (" + fertilizerList.size() + ")");
        Iterator<Fertilizer> fti = fertilizerList.iterator();
        if (!fti.hasNext()) System.out.println("  (none)");
        while (fti.hasNext()) {
            fti.next().display();
        }

        // Iterator<Irrigation>
        System.out.println("\n>> IRRIGATION RECORDS (" + irrigationList.size() + ")");
        Iterator<Irrigation> iri = irrigationList.iterator();
        if (!iri.hasNext()) System.out.println("  (none)");
        while (iri.hasNext()) {
            iri.next().display();
        }

        // Iterator<WeatherData>
        System.out.println("\n>> WEATHER RECORDS (" + weatherList.size() + ")");
        Iterator<WeatherData> wi = weatherList.iterator();
        if (!wi.hasNext()) System.out.println("  (none)");
        while (wi.hasNext()) {
            wi.next().display();
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 9 — Update Land Usage
    // ════════════════════════════════════════════════════════════════════════
    private static void updateLandUsage() {
        System.out.println("\n--- Update Land Usage ---");

        if (landList.isEmpty()) {
            System.out.println("[!] No land records. Add land first.");
            return;
        }

        String landId = readStr("Enter Land ID to update");
        boolean found = false;

        for (LandRecord lr : landList) {
            if (lr.getLandId().equalsIgnoreCase(landId)) {
                String newUsage = readStr("New Current Usage");
                String newIrr   = readStr("New Irrigation Status");
                double newVal   = readDouble("New Market Value (INR)");

                // Use setters — Encapsulation
                lr.setCurrentUsage(newUsage);
                lr.setIrrigationStatus(newIrr);
                lr.setMarketValueINR(newVal);

                System.out.println("[OK] Land '" + landId + "' updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("[!] Land ID '" + landId + "' not found.");
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 10 — Delete a Record
    //  Uses Iterator.remove() — safe deletion during iteration
    // ════════════════════════════════════════════════════════════════════════
    private static void deleteRecord() {
        System.out.println("\n--- Delete a Record ---");
        System.out.println("  1. Soil  2. Land  3. Farmer  4. Crop");
        int type    = readInt("Type");
        String delId = readStr("ID to delete");
        boolean deleted = false;

        switch (type) {
            case 1:
                Iterator<SoilTest> s = soilList.iterator();
                while (s.hasNext()) {
                    if (s.next().getSoilId().equalsIgnoreCase(delId)) {
                        s.remove();   // Iterator.remove() — safe deletion
                        deleted = true; break;
                    }
                }
                break;
            case 2:
                Iterator<LandRecord> l = landList.iterator();
                while (l.hasNext()) {
                    if (l.next().getLandId().equalsIgnoreCase(delId)) {
                        l.remove();
                        landFarmerMap.remove(delId);  // clean HashMap too
                        deleted = true; break;
                    }
                }
                break;
            case 3:
                Iterator<Farmer> f = farmerList.iterator();
                while (f.hasNext()) {
                    if (f.next().getFarmerId().equalsIgnoreCase(delId)) {
                        f.remove();
                        deleted = true; break;
                    }
                }
                break;
            case 4:
                Iterator<Crop> c = cropList.iterator();
                while (c.hasNext()) {
                    if (c.next().getCropId().equalsIgnoreCase(delId)) {
                        c.remove();
                        deleted = true; break;
                    }
                }
                break;
            default:
                System.out.println("[!] Invalid type."); return;
        }

        System.out.println(deleted
            ? "[OK] Record '" + delId + "' deleted."
            : "[!] ID '" + delId + "' not found.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 11 — Add Fertilizer
    // ════════════════════════════════════════════════════════════════════════
    private static void addFertilizer() {
        System.out.println("\n--- Add Fertilizer ---");
        String fId     = readStr("Fertilizer ID");
        String fName   = readStr("Fertilizer Name");
        String fType   = readStr("Type (Organic/Inorganic/Bio)");
        String landId  = readStr("Land ID");
        String cropId  = readStr("Crop ID");
        double qty     = readDouble("Quantity (kg)");
        String appDate = readStr("Application Date (DD-MM-YYYY)");
        String method  = readStr("Application Method");
        double cost    = readDouble("Cost per kg (INR)");
        String mfg     = readStr("Manufacturer");
        String npk     = readStr("NPK Ratio (e.g. 10-26-26)");
        String storage = readStr("Storage Conditions");

        fertilizerList.add(new Fertilizer(fId, fName, fType, landId, cropId,
            qty, appDate, method, cost, mfg, npk, storage));
        System.out.println("[OK] Fertilizer record added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 12 — Add Irrigation
    // ════════════════════════════════════════════════════════════════════════
    private static void addIrrigation() {
        System.out.println("\n--- Add Irrigation ---");
        String iId     = readStr("Irrigation ID");
        String landId  = readStr("Land ID");
        String iType   = readStr("Irrigation Type (Drip/Sprinkler/Flood)");
        String wSrc    = readStr("Water Source (Canal/Borewell/River)");
        double water   = readDouble("Water Used (litres)");
        String iDate   = readStr("Irrigation Date (DD-MM-YYYY)");
        double dur     = readDouble("Duration (hours)");
        double area    = readDouble("Area Irrigated (acres)");
        double cost    = readDouble("Cost (INR)");
        String oper    = readStr("Operator Name");
        String nextDt  = readStr("Next Scheduled Date (DD-MM-YYYY)");
        boolean auto   = readStr("Automated System? (yes/no)").equalsIgnoreCase("yes");

        irrigationList.add(new Irrigation(iId, landId, iType, wSrc, water,
            iDate, dur, area, cost, oper, nextDt, auto));
        System.out.println("[OK] Irrigation record added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 13 — Add Weather Data
    // ════════════════════════════════════════════════════════════════════════
    private static void addWeatherData() {
        System.out.println("\n--- Add Weather Data ---");
        String wId    = readStr("Weather ID");
        String landId = readStr("Land ID");
        String date   = readStr("Observation Date (DD-MM-YYYY)");
        double tMax   = readDouble("Max Temperature (C)");
        double tMin   = readDouble("Min Temperature (C)");
        double rain   = readDouble("Rainfall (mm)");
        double hum    = readDouble("Humidity (%)");
        double wind   = readDouble("Wind Speed (km/h)");
        String wDir   = readStr("Wind Direction (N/S/E/W)");
        double solar  = readDouble("Solar Radiation (MJ/m2)");
        String cond   = readStr("Weather Condition (Sunny/Cloudy/Rainy)");
        String recBy  = readStr("Recorded By");

        weatherList.add(new WeatherData(wId, landId, date, tMax, tMin,
            rain, hum, wind, wDir, solar, cond, recBy));
        System.out.println("[OK] Weather data added.");
    }

    // ════════════════════════════════════════════════════════════════════════
    //  FEATURE 14 — View Land-Farmer HashMap
    // ════════════════════════════════════════════════════════════════════════
    private static void viewLandFarmerMap() {
        System.out.println("\n--- Land-Farmer Mapping ---");
        if (landFarmerMap.isEmpty()) {
            System.out.println("  (No entries yet)");
            return;
        }
        System.out.printf("  %-12s %-12s%n", "Land ID", "Farmer ID");
        System.out.println("  " + "-".repeat(26));
        for (HashMap.Entry<String, String> e : landFarmerMap.entrySet()) {
            System.out.printf("  %-12s %-12s%n", e.getKey(), e.getValue());
        }
    }

    // ════════════════════════════════════════════════════════════════════════
    //  INPUT HELPER METHODS — all with try-catch exception handling
    // ════════════════════════════════════════════════════════════════════════

    /** Reads a String input from the user */
    private static String readStr(String prompt) {
        System.out.print("  " + prompt + ": ");
        String val = sc.nextLine();
        return (val == null) ? "" : val.trim();
    }

    /**
     * Reads an integer — retries on invalid input.
     * Exception Handling: NumberFormatException caught here.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print("  " + prompt + ": ");
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a whole number.");
            }
        }
    }

    /**
     * Reads a decimal number — retries on invalid input.
     * Exception Handling: NumberFormatException caught here.
     */
    private static double readDouble(String prompt) {
        while (true) {
            System.out.print("  " + prompt + ": ");
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  [!] Please enter a number (e.g. 6.5).");
            }
        }
    }

    /** Safely converts String to double during file loading; returns 0.0 on error */
    private static double toDbl(String s) {
        try { return Double.parseDouble(s.trim()); }
        catch (NumberFormatException e) { return 0.0; }
    }

    /** Safely converts String to int during file loading; returns 0 on error */
    private static int toInt(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (NumberFormatException e) { return 0; }
    }
}
