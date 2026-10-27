package hw8.Bridge;

public class PushChannel implements NotificationChannel {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("Push to: " + customer.name() + "'s phone app");
        System.out.println("Payment Update");
        System.out.println(customer.name() + ", " + message);
    }
}
