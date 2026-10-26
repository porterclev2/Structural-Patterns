package hw8.Bridge;

public class CashOnDeliveryPayment extends PaymentNotification {
    @Override
    String buildMessage(double amount) {
        return "your order is on the way. Please pay " + formatAmount(amount)
                + " in cash when it arrives.";
    }

    public CashOnDeliveryPayment(NotificationChannel channel) {
        super(channel);
    }
}
