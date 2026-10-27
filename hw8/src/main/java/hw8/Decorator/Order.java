package hw8.Decorator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> items = new ArrayList<>();

    public void printReceipt(LoyaltyStatus status) {
        for (FoodItem item : items) {
            System.out.println(item.getDescription() + ": " + formatAmount(item.getCost()));
        }
        int percent = (int) Math.round(status.getDiscountRate() * 100);
        System.out.println("Subtotal: " + formatAmount(getTotal()));
        System.out.println("Discount (" + status + " " + percent + "%): -"
                + formatAmount(getTotal() - getTotal(status)));
        System.out.println("Total: " + formatAmount(getTotal(status)));
    }
    
    public double getTotal() {
        double total = 0;
        for (FoodItem item : items) {
            total += item.getCost();
        }
        return Math.round(total * 100) / 100.0;
    }

    public double getTotal(LoyaltyStatus status) {
        return status.applyDiscount(getTotal());
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
