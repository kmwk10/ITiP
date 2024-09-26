public class BmxBike extends Bike {
    private String bmxType;
    private String frameMaterial;
    private double wheelSize;

    public BmxBike (String brand, String color, double weight, String bmxType, String frameMaterial, double wheelSize) {
        super (brand, color, weight);
        this.bmxType = bmxType;
        this.frameMaterial = frameMaterial;
        this.wheelSize = wheelSize;
    }
    public BmxBike () {
        this("Unknown", "Unknown", 0, "Unknown", "Unknown", 0);
    }
    public String getBmxType () {
        return bmxType;
    }
    public String getFrameMaterial () {
        return frameMaterial;
    }
    public double getWheelSize () {
        return wheelSize;
    }
    @Override
    public String getDescription () {
        return "BMX bike";
    } 
    public void setBmxType (String val) {
        bmxType = val;
    }
    public void setFrameMaterial (String val) {
        frameMaterial = val;
    }
    public void setWheelSize (double val) {
        wheelSize = val;
    }
}