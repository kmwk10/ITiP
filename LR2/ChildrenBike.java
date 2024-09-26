public class ChildrenBike extends Bike {
    private String ageCategory;
    private boolean hasTrainingWheels;
    private double seatHeight;

    public ChildrenBike (String brand, String color, double weight, String ageCategory, boolean hasTrainingWheels, double seatHeight) {
        super (brand, color, weight);
        this.ageCategory = ageCategory;
        this.hasTrainingWheels = hasTrainingWheels;
        this.seatHeight = seatHeight;
    }
    public ChildrenBike () {
        this("Unknown", "Unknown", 0, "Unknown", false, 0);
    }
    public String getAgeCategory () {
        return ageCategory;
    }
    public boolean getHasTrainingWheels () {
        return hasTrainingWheels;
    }
    public double getSeatHeight () {
        return seatHeight;
    }
    @Override
    public String getDescription () {
        return "Сhildren's bike";
    } 
    public void setAgeCategory (String val) {
        ageCategory = val;
    }
    public void setHasTrainingWheels (boolean val) {
        hasTrainingWheels = val;
    }
    public void setSeatHeight (double val) {
        seatHeight = val;
    }
}