package hw8.Decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> items = new ArrayList<>();

    public void printReceipt() {
        for (FoodItem item : items) {
            System.out.println(item.getDescription() + ": " + formatAmount(item.getCost()));
        }
        System.out.println("Total: " + formatAmount(getTotal()));
    }
    
    public double getTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getCost();
        }
        return Math.round(total * 100) / 100.0;
    }
    
    public void addItem(FoodItem item) {
        items.add(item);
    }

    public List<FoodItem> getItems() {
        return items;
    }

    static String formatAmount(double amount) {
        return String.format("$%.2f", amount);
    }
}
