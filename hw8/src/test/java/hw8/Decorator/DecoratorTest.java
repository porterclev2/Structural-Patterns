package hw8.Decorator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DecoratorTest {

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    double delta = 0.001;

    @Test
    public void testBasePrices() {
        assertEquals(1.00, new Fries().getCost(), delta);
        assertEquals(2.00, new HotDog().getCost(), delta);
        assertEquals(3.00, new Burger().getCost(), delta);
    }

    @Test
    public void testBaseDescriptions() {
        assertEquals("Burger", new Burger().getDescription());
        assertEquals("Fries", new Fries().getDescription());
        assertEquals("Hot Dog", new HotDog().getDescription());
    }

    @Test
    public void testOneTopping() {
        FoodItem item = new Cheese(new Burger());
        assertEquals(4.00, item.getCost(), delta);
        assertEquals("Burger + Cheese", item.getDescription());
    }

    @Test
    public void testFreeTopping() {
        FoodItem item = new Ketchup(new Fries());
        assertEquals(1.00, item.getCost(), delta);
        assertEquals("Fries + Ketchup", item.getDescription());
    }

    @Test
    public void testManyToppings() {
        FoodItem item = new Onions(new Ketchup(new Cheese(new HotDog())));
        assertEquals(3.25, item.getCost(), delta);
        assertEquals("Hot Dog + Cheese + Ketchup + Onions", item.getDescription());
    }

    @Test
    public void testSameToppingTwice() {
        FoodItem item = new Cheese(new Cheese(new Fries()));
        assertEquals(3.00, item.getCost(), delta);
        assertEquals("Fries + Cheese + Cheese", item.getDescription());
    }

    @Test
    public void testEmptyOrder() {
        assertEquals(0.00, new Order().getTotal(), delta);
        assertEquals(0.00, new Order().getTotal(LoyaltyStatus.GOLD), delta);
    }

    @Test
    public void testOrderTotal() {
        Order order = new Order();
        order.addItem(new Cheese(new Onions(new Burger())));
        order.addItem(new Ketchup(new Fries()));
        order.addItem(new HotDog());
        assertEquals(3, order.getItems().size());
        assertEquals(7.25, order.getTotal(), delta);
    }

    @Test
    public void testLoyaltyDiscounts() {
        assertEquals(20.00, LoyaltyStatus.NONE.applyDiscount(20.00), delta);
        assertEquals(18.00, LoyaltyStatus.SILVER.applyDiscount(20.00), delta);
        assertEquals(15.00, LoyaltyStatus.GOLD.applyDiscount(20.00), delta);
    }

    @Test
    public void testDiscountRounding() {
        assertEquals(8.99, LoyaltyStatus.SILVER.applyDiscount(9.99), delta);
        assertEquals(5.44, LoyaltyStatus.GOLD.applyDiscount(7.25), delta);
    }

    @Test
    public void testOrderTotalWithDiscount() {
        Order order = new Order();
        order.addItem(new Cheese(new Cheese(new Burger())));
        order.addItem(new Fries());
        assertEquals(6.00, order.getTotal(), delta);
        assertEquals(5.40, order.getTotal(LoyaltyStatus.SILVER), delta);
        assertEquals(4.50, order.getTotal(LoyaltyStatus.GOLD), delta);
    }

    @Test
    public void testReceiptWithNoDiscount() {
        Order order = new Order();
        order.addItem(new HotDog());
        order.printReceipt(LoyaltyStatus.NONE);
        assertTrue(output.toString().contains("Discount (NONE 0%): -$0.00"));
        assertTrue(output.toString().contains("Total: $2.00"));
    }
    
    @BeforeEach
    public void captureOutput() {
        System.setOut(new PrintStream(output));
    }
    @AfterEach
    public void restoreOutput() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintReceipt() {
        Order order = new Order();
        order.addItem(new Cheese(new Burger()));
        order.addItem(new Fries());
        order.printReceipt(LoyaltyStatus.GOLD);
        String expected = String.join(System.lineSeparator(),
                "Burger + Cheese: $4.00",
                "Fries: $1.00",
                "Subtotal: $5.00",
                "Discount (GOLD 25%): -$1.25",
                "Total: $3.75",
                "");
        assertEquals(expected, output.toString());
    }
}
