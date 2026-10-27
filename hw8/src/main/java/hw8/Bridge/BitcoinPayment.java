package hw8.Bridge;

public class BitcoinPayment extends PaymentNotification {
    @Override
    String buildMessage(double amount) {}

    public BitcoinPayment(NotificationChannel channel) {
        super(channel);
    }
}
