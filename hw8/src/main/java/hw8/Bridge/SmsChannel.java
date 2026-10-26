package hw8.Bridge;

public class SmsChannel implements NotificationChannel {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("To: " + customer.phone());
        System.out.println(customer.name() + ", " + message);
    }
}
