package hw8.Decorator;

public class Burger implements FoodItem {
    @Override
    public double getCost() {
        return 3.00;
    }

    @Override
    public String getDescription() {
        return "Burger";
    }
}
