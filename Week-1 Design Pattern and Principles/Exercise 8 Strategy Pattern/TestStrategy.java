public class TestStrategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.executePayment(120.0);

        context = new PaymentContext(new PayPalPayment());
        context.executePayment(75.5);
    }
}
