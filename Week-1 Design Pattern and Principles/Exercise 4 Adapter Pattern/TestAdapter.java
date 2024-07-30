public class TestAdapter {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment(100.0);

        PaymentProcessor creditCardProcessor = new CreditCardAdapter(new CreditCard());
        creditCardProcessor.processPayment(250.0);
    }
}
