package hw8.Decorator;

public class Cheese extends ToppingDecorator {
    @Override
    double getToppingCost() {
        return 1.00;
    }

    @Override
    String getToppingName() {
        return "Cheese";
    }

    public Cheese(FoodItem item) {
        super(item);
    }
}
