public class ChildrenTricycle extends ChildrenBike {
    private boolean hasHandle;
    
    public ChildrenTricycle (String brand, String color, double weight, String ageCategory, boolean hasTrainingWheels, double seatHeight, boolean hasHandle) {
        super (brand, color, weight, ageCategory, hasTrainingWheels, seatHeight);
        this.hasHandle = hasHandle;
    }
    public ChildrenTricycle () {
        this("Unknown", "Unknown", 0, "Unknown", false, 0, false);
    }
    public boolean getHasHandle () {
        return hasHandle;
    }
    @Override
    public String getDescription () {
        return "Сhildren's tricycle";
    } 
    public void setHasHandle (boolean val) {
        hasHandle = val;
    }
}
