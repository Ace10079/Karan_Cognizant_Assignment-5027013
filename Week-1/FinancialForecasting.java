public class FinancialForecasting {

    public static double predictFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        }
        return (1 + growthRate) * predictFutureValue(initialValue, growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10;

        double futureValue = predictFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}
