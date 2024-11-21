import java.util.concurrent.CopyOnWriteArrayList;

public class Sales {
    private CopyOnWriteArrayList<Product> soldItems;

    public Sales() {
        soldItems = new CopyOnWriteArrayList<>();
    }

    public void addSoldItem(Product item) {
        soldItems.add(item);
    }

    public void printSoldItems() {
        System.out.println("Список проданных товаров:");
        for (Product item : soldItems) {
            System.out.println(item.toString());
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Product item : soldItems) {
            total += item.getPrice();
        }
        return total;
    }

    public String getMostPopularItem() {
        CopyOnWriteArrayList<Product> uniqueItems = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<Integer> itemCounts = new CopyOnWriteArrayList<>();

        for (Product item : soldItems) {
            int index = uniqueItems.indexOf(item);
            if (index == -1) {
                uniqueItems.add(item);
                itemCounts.add(1);
            } else {
                itemCounts.set(index, itemCounts.get(index) + 1);
            }
        }

        int maxCount = 0;
        String mostPopularItem = "";
        for (int i = 0; i < itemCounts.size(); i++) {
            if (itemCounts.get(i) > maxCount) {
                maxCount = itemCounts.get(i);
                mostPopularItem = uniqueItems.get(i).getName();
            }
        }
        return mostPopularItem;
    }
}
