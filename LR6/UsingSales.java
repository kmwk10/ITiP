public class UsingSales {
    public static void main(String[] args) {
        Sales tracker = new Sales();

        tracker.addSoldItem(new Product("Apple", 20));
        tracker.addSoldItem(new Product("Banana", 30));
        tracker.addSoldItem(new Product("Apple", 20));
        tracker.addSoldItem(new Product("Orange", 35));
        tracker.addSoldItem(new Product("Banana", 30));
        tracker.addSoldItem(new Product("Apple", 20));

        tracker.printSoldItems();

        System.out.println("Общая сумма продаж: " + tracker.getTotalSales());
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularItem());
    }
}
