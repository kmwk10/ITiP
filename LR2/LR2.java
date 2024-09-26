public class LR2 {
    public static void main(String[] args) {
        MountainBike bike1 = new MountainBike("Stern", "red", 15.8, "Hard tail", 21, "A");
        System.out.println("#1 "+bike1.getDescription());
        System.out.println("\tBrand: "+bike1.getBrand());
        System.out.println("\tSuspension type: "+bike1.getSuspensionType());
        
        ChildrenBike bike2 = new ChildrenBike();
        bike2.setBrand("ALTAIR");
        bike2.setWeight(9.4);
        System.out.println("#2 "+bike2.getDescription());
        System.out.println("\tBrand: "+bike2.getBrand());
        System.out.println("\tWeight: "+bike2.getWeight()+" kg");
        System.out.println("\tAge category: "+bike2.getAgeCategory());
        
        BmxBike bike3 = new BmxBike("Haro", "black", 13.24, "Mid", "steel", 20);
        bike3.setColor("green");
        System.out.println("#3 "+bike3.getDescription());
        System.out.println("\tColor: "+bike3.getColor());
        System.out.println("\tFrame material: "+bike3.getFrameMaterial());
        
        System.out.println("Number of bikes: "+Bike.getNumberOfBikes());
    }
}