package hw8.Decorator;

public abstract class ToppingDecorator implements FoodItem {
    FoodItem item;

    abstract double getToppingCost();

    abstract String getToppingName();

    ToppingDecorator(FoodItem item) {
        this.item = item;
    }
    
    @Override
    public double getCost() {
        return item.getCost() + getToppingCost();
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " + " + getToppingName();
    }

}
