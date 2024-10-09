import java.util.Arrays;

public class Order {
    private String[] dishes;
    private double price;
    private String time;

    public Order (String[] dishes, double price, String time) {
        this.dishes = dishes;
        this.price = price;
        this.time = time;
    }
    public String[] getDishes () {
        return dishes;
    }
    public double getPrice () {
        return price;
    }
    public String getTime () {
        return time;
    }
    public void setDishes (String[] val) {
        dishes = val;
    }
    public void setPrice (double val) {
        price = val;
    }
    public void setTime (String val) {
        time = val;
    }
    public String getInfo () {
        return "Dishes: " + Arrays.toString(dishes) + "\n" +
                "Price: " + price + "\n" +
                "Time: " + time;
    }
}
