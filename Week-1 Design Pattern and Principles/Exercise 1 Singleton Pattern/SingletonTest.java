public class SingletonTest {
    public static void main(String[] args) {
        MyLogger logger1 = MyLogger.getInstance();
        MyLogger logger2 = MyLogger.getInstance();

        if (logger1 == logger2) {
            System.out.println("Singleton pattern implemented correctly.");
        } else {
            System.out.println("Singleton pattern implementation failed.");
        }
    }
}
