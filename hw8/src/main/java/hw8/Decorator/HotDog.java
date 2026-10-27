package hw8.Decorator;

public class HotDog implements FoodItem {
    @Override
    public double getCost() {
        return 2.00;
    }

    @Override
    public String getDescription() {
        return "Hot Dog";
    }
}
