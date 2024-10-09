import java.util.HashMap;

public class LR3 {
    public static void main(String[] args) {
        System.out.println("# Working with HashTable class");

        HashTable<String, Integer> hashTable = new HashTable<>();

        System.out.println("Is empty: " + hashTable.isEmpty());

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("All entries:");
        System.out.println("\tone: " + hashTable.get("one"));
        System.out.println("\ttwo: " + hashTable.get("two"));
        System.out.println("\tthree: " + hashTable.get("three"));

        System.out.println("Value after removal:");
        hashTable.remove("two");
        System.out.println("\ttwo: " + hashTable.get("two"));

        System.out.println("Size: " + hashTable.size());
        System.out.println("Is empty: " + hashTable.isEmpty());

        System.out.println("\n# Working with HashMap class");

        HashMap<Integer, Order> hashMap = new HashMap<>();

        hashMap.put(1, new Order(new String[] {"Salad", "Soup", "Сoffee"}, 1300, "16:30"));
        hashMap.put(2, new Order(new String[] {"Сoffee"}, 200, "16:44"));
        hashMap.put(3, new Order(new String[] {"Dessert", "Tea"}, 550, "17:13"));

        System.out.println("Order 1:\n"+hashMap.get(1).getInfo() + "\n");
        System.out.println("Order 2:\n"+hashMap.get(2).getInfo() + "\n");
        System.out.println("Order 3:\n"+hashMap.get(3).getInfo() + "\n");

        hashMap.remove(3);
        System.out.println("Order 3 after removal:\n"+hashMap.get(3));
    }
}
