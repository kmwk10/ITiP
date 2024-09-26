public class MountainBike extends Bike {
    private String suspensionType;
    private int numberOfGears;
    private String tireType;

    public MountainBike (String brand, String color, double weight, String suspensionType, int numberOfGears, String tireType) {
        super (brand, color, weight);
        this.suspensionType = suspensionType;
        this.numberOfGears = numberOfGears;
        this.tireType = tireType;
    }
    public MountainBike () {
        this("Unknown", "Unknown", 0, "Unknown", 0, "Unknown");
    }
    public String getSuspensionType () {
        return suspensionType;
    }
    public int getNumberOfGears () {
        return numberOfGears;
    }
    public String getTireType () {
        return tireType;
    }
    @Override
    public String getDescription () {
        return "Mountain bike";
    } 
    public void setSuspensionType (String val) {
        suspensionType = val;
    }
    public void setNumberOfGears (int val) {
        numberOfGears = val;
    }
    public void setTireType (String val) {
        tireType = val;
    }
}