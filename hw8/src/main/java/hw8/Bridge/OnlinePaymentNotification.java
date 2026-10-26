package hw8.Bridge;

public class OnlinePaymentNotification extends PaymentNotification {
    private String method;

    @Override
    String buildMessage(double amount) {
        return "we got your payment of " + formatAmount(amount) + " by " + method
                + ". We are getting your order ready.";
    }

    public OnlinePaymentNotification(NotificationChannel channel, String method) {
        super(channel);
        this.method = method;
    }
}
