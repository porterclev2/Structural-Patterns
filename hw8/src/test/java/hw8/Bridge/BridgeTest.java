package hw8.Bridge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BridgeTest {

    Customer kyle = new Customer("Kyle", "kyle@gmail.com", "741-555-0001");
    Customer connor = new Customer("Connor", "connor@gmail.com", "714-555-0002");
    NotificationChannel email = new EmailChannel();
    NotificationChannel sms = new SmsChannel();
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    @Test
    public void testOnlineWithEmail() {
        new OnlinePaymentNotification(email, "Credit Card").notifyCustomer(kyle, 10.00);
        assertTrue(output.toString().contains("To: kyle@gmail.com"));
        assertTrue(output.toString().contains("Dear Kyle, we got your payment of $10.00 by Credit Card."));
    }
    @Test
    public void testOnlineWithSms() {
        new OnlinePaymentNotification(sms, "PayPal").notifyCustomer(connor, 100.00);
        assertTrue(output.toString().contains("To: 714-555-0002"));
        assertTrue(output.toString().contains("Connor, we got your payment of $100.00 by PayPal."));
    }
    @Test
    public void testCashWithEmail() {
        new CashOnDeliveryPayment(email).notifyCustomer(connor, 30.00);
        assertTrue(output.toString().contains("To: connor@gmail.com"));
        assertTrue(output.toString().contains("Dear Connor, your order is on the way. Please pay $30.00 in cash"));
    }
    @Test
    public void testCashWithSms() {
        new CashOnDeliveryPayment(sms).notifyCustomer(kyle, 15.00);
        assertTrue(output.toString().contains("To: 741-555-0001"));
        assertTrue(output.toString().contains("Kyle, your order is on the way. Please pay $15.00 in cash"));
    }
    @Test
    public void testBitcoinWithEmail() {
        new BitcoinPayment(email).notifyCustomer(kyle, 250.00);
        assertTrue(output.toString().contains("To: kyle@gmail.com"));
        assertTrue(output.toString().contains("Dear Kyle, we got your Bitcoin payment of $250.00."));
    }
    @Test
    public void testBitcoinWithSms() {
        new BitcoinPayment(sms).notifyCustomer(connor, 75.25);
        assertTrue(output.toString().contains("To: 714-555-0002"));
        assertTrue(output.toString().contains("Connor, we got your Bitcoin payment of $75.25."));
    }
    @Test
    public void testOnlineMessage() {
        String expected = "we got your payment of $10.00 by PayPal. We are getting your order ready.";
        assertEquals(expected, new OnlinePaymentNotification(email, "PayPal").buildMessage(10));
    }
    @Test
    public void testCashMessage() {
        String expected = "your order is on the way. Please pay $5.50 in cash when it arrives.";
        assertEquals(expected, new CashOnDeliveryPayment(sms).buildMessage(5.5));
    }
    @Test
    public void testBitcoinMessage() {
        String expected = "we got your Bitcoin payment of $1.50. We will ship your order once the payment is confirmed.";
        assertEquals(expected, new BitcoinPayment(email).buildMessage(1.5));
    }
    @Test
    public void testFormatAmount() {
        assertEquals("$0.00", PaymentNotification.formatAmount(0));
        assertEquals("$3.10", PaymentNotification.formatAmount(3.1));
        assertEquals("$99.99", PaymentNotification.formatAmount(99.99));
    }

    @BeforeEach
    public void captureOutput() {
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    public void restoreOutput() {
        System.setOut(originalOut);
    }
}
