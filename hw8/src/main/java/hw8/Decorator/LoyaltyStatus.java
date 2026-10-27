package hw8.Decorator;

public enum LoyaltyStatus {
    NONE(0.00),
    SILVER(0.10),
    GOLD(0.25);

    private double discountRate;

    public double applyDiscount(double total) {
        return Math.round(total * (1 - discountRate) * 100) / 100.0;
    }

    LoyaltyStatus(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
