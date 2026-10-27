package hw8.Decorator;

public class Onions extends ToppingDecorator {
    @Override
    double getToppingCost() {
        return 0.25;
    }

    @Override
    String getToppingName() {
        return "Onions";
    }

    public Onions(FoodItem item) {
        super(item);
    }
}
