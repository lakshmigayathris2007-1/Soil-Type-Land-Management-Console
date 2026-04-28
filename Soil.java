// ===== Soil.java =====

/**
 * Abstract base class for soil properties.
 * Abstraction: declares abstract display() that subclasses must implement.
 * Inheritance: SoilTest extends this class.
 */
public abstract class Soil {

    // Private attributes (Encapsulation)
    private String soilId;
    private String soilType;
    private double phLevel;
    private double moistureContent;
    private double organicMatter;
    private String texture;
    private double nitrogenLevel;
    private double phosphorusLevel;
    private double potassiumLevel;
    private String color;

    // Default Constructor
    public Soil() {
        this.soilId          = "S000";
        this.soilType        = "Unknown";
        this.phLevel         = 7.0;
        this.moistureContent = 0.0;
        this.organicMatter   = 0.0;
        this.texture         = "Medium";
        this.nitrogenLevel   = 0.0;
        this.phosphorusLevel = 0.0;
        this.potassiumLevel  = 0.0;
        this.color           = "Brown";
    }

    // Parameterized Constructor
    public Soil(String soilId, String soilType, double phLevel,
                double moistureContent, double organicMatter,
                String texture, double nitrogenLevel,
                double phosphorusLevel, double potassiumLevel, String color) {
        this.soilId          = soilId;
        this.soilType        = soilType;
        this.phLevel         = phLevel;
        this.moistureContent = moistureContent;
        this.organicMatter   = organicMatter;
        this.texture         = texture;
        this.nitrogenLevel   = nitrogenLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.potassiumLevel  = potassiumLevel;
        this.color           = color;
    }

    // Getters
    public String getSoilId()          { return soilId; }
    public String getSoilType()        { return soilType; }
    public double getPhLevel()         { return phLevel; }
    public double getMoistureContent() { return moistureContent; }
    public double getOrganicMatter()   { return organicMatter; }
    public String getTexture()         { return texture; }
    public double getNitrogenLevel()   { return nitrogenLevel; }
    public double getPhosphorusLevel() { return phosphorusLevel; }
    public double getPotassiumLevel()  { return potassiumLevel; }
    public String getColor()           { return color; }

    // Setters
    public void setSoilId(String soilId)                   { this.soilId = soilId; }
    public void setSoilType(String soilType)               { this.soilType = soilType; }
    public void setPhLevel(double phLevel)                 { this.phLevel = phLevel; }
    public void setMoistureContent(double moistureContent) { this.moistureContent = moistureContent; }
    public void setOrganicMatter(double organicMatter)     { this.organicMatter = organicMatter; }
    public void setTexture(String texture)                 { this.texture = texture; }
    public void setNitrogenLevel(double nitrogenLevel)     { this.nitrogenLevel = nitrogenLevel; }
    public void setPhosphorusLevel(double phosphorusLevel) { this.phosphorusLevel = phosphorusLevel; }
    public void setPotassiumLevel(double potassiumLevel)   { this.potassiumLevel = potassiumLevel; }
    public void setColor(String color)                     { this.color = color; }

    // Abstract display() — subclasses must override this
    public abstract void display();

    // Protected helper so subclasses can print base soil fields
    protected void displaySoilInfo() {
        System.out.println("  Soil ID          : " + soilId);
        System.out.println("  Soil Type        : " + soilType);
        System.out.println("  pH Level         : " + phLevel);
        System.out.println("  Moisture Content : " + moistureContent + "%");
        System.out.println("  Organic Matter   : " + organicMatter + "%");
        System.out.println("  Texture          : " + texture);
        System.out.println("  Nitrogen  (N)    : " + nitrogenLevel + " mg/kg");
        System.out.println("  Phosphorus (P)   : " + phosphorusLevel + " mg/kg");
        System.out.println("  Potassium  (K)   : " + potassiumLevel + " mg/kg");
        System.out.println("  Color            : " + color);
    }
}
