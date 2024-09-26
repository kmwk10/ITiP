public abstract class Bike {
    private String brand;
    private String color;
    private double weight;
    private static int countBikes = 0;

    public Bike (String brand, String color, double weight) {
        this.brand = brand;
        this.color = color;
        this.weight = weight;
        countBikes++;
    }
    public Bike () {
        this("Unknown", "Unknown", 0);
        countBikes++;
    }
    public String getBrand () {
        return brand;
    }
    public String getColor () {
        return color;
    }
    public double getWeight () {
        return weight;
    }
    public abstract String getDescription ();
    public static int getNumberOfBikes () {
        return countBikes;
    }
    public void setBrand (String val) {
        brand = val;
    }
    public void setColor (String val) {
        color = val;
    }
    public void setWeight (double val) {
        weight = val;
    }
}