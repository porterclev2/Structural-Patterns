package hw8.Decorator;

public class Ketchup extends ToppingDecorator {
    @Override
    double getToppingCost() {
        return 0.00;
    }

    @Override
    String getToppingName() {
        return "Ketchup";
    }

    public Ketchup(FoodItem item) {
        super(item);
    }
}
