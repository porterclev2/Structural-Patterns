package hw8.Bridge;

public abstract class PaymentNotification {
    NotificationChannel channel;

    public void notifyCustomer(Customer customer, double amount) {
        channel.send(customer, buildMessage(amount));
    }

    abstract String buildMessage(double amount);

    PaymentNotification(NotificationChannel channel) {
        this.channel = channel;
    }

    static String formatAmount(double amount) {
        return String.format("$%.2f", amount);
    }
}
