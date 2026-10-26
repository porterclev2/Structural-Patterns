package hw8.Bridge;

public class EmailChannel implements NotificationChannel {
    @Override
    public void send(Customer customer, String message) {
        System.out.println("To: " + customer.email());
        System.out.println("Subject: Payment Update");
        System.out.println("Dear " + customer.name() + ", " + message);
    }
}
