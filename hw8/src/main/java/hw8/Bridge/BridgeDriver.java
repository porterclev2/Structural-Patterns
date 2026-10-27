package hw8.Bridge;

public class BridgeDriver {
    public static void main(String[] args) {
        Customer kyle = new Customer("Kyle", "kyle@gmail.com", "741-555-0001");
        Customer connor = new Customer("Connor", "connor@gmail.com", "714-555-0002");
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();

        System.out.println("1: Credit Card + Email");
        new OnlinePaymentNotification(email, "Credit Card").notifyCustomer(kyle, 10.00);

        System.out.println("\n2: PayPal + SMS");
        new OnlinePaymentNotification(sms, "PayPal").notifyCustomer(connor, 100.00);

        System.out.println("\n3: Cash on Delivery + Email");
        new CashOnDeliveryPayment(email).notifyCustomer(connor, 30.00);

        System.out.println("\n4: Cash on Delivery + SMS");
        new CashOnDeliveryPayment(sms).notifyCustomer(kyle, 15.00);

        System.out.println("\n5: Bitcoin + Email");
        new BitcoinPayment(email).notifyCustomer(kyle, 250.00);

        System.out.println("\n6: Bitcoin + SMS");
        new BitcoinPayment(sms).notifyCustomer(connor, 75.25);
    }
}
