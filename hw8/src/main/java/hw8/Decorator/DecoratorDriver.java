package hw8.Decorator;

public class DecoratorDriver {
    public static void main(String[] args) {
        System.out.println("Plain items + no loyalty status");
        Order first = new Order();
        first.addItem(new Burger());
        first.addItem(new Fries());
        first.printReceipt(LoyaltyStatus.NONE);

        System.out.println("\nItems with toppings + SILVER customer");
        Order second = new Order();
        second.addItem(new Cheese(new Onions(new Burger())));
        second.addItem(new Ketchup(new Fries()));
        second.printReceipt(LoyaltyStatus.SILVER);

        System.out.println("\nDouble cheese and bacon + GOLD customer");
        Order third = new Order();
        third.addItem(new Cheese(new Cheese(new Burger())));
        third.addItem(new Onions(new Ketchup(new HotDog())));
        third.addItem(new Fries());
        third.printReceipt(LoyaltyStatus.GOLD);
    }
}
