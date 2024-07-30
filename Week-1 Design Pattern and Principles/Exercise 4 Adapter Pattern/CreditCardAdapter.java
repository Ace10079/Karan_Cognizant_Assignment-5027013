public class CreditCardAdapter implements PaymentProcessor {
    private CreditCard creditCard;

    public CreditCardAdapter(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public void processPayment(double amount) {
        creditCard.chargeCard(amount);
    }
}
