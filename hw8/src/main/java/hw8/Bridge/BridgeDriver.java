package hw8.Bridge;

public class BridgeDriver {
    public static void main(String[] args) {
        Customer kyle = new Customer("Kyle", "kyle@gmail.com", "741-555-0001");
        Customer connor = new Customer("Connor", "connor@gmail.com", "714-555-0002");
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();
        NotificationChannel push = new PushChannel();

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

        System.out.println("\n7: PayPal + Push");
        new OnlinePaymentNotification(push, "PayPal").notifyCustomer(kyle, 42.00);

        System.out.println("\n8: Cash on Delivery + Push");
        new CashOnDeliveryPayment(push).notifyCustomer(connor, 20.00);
    }
}
