package hw8.Decorator;

public class Fries implements FoodItem {
    @Override
    public double getCost() {
        return 1.00;
    }

    @Override
    public String getDescription() {
        return "Fries";
    }
}
