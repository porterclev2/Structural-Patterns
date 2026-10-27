package hw8.Bridge;

public class BitcoinPayment extends PaymentNotification {
    @Override
    String buildMessage(double amount) {
        return "we got your Bitcoin payment of " + formatAmount(amount)
                + ". We will ship your order once the payment is confirmed.";
    }

    public BitcoinPayment(NotificationChannel channel) {
        super(channel);
    }
}
