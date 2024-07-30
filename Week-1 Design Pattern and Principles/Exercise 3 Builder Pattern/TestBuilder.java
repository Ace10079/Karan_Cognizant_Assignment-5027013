public class TestBuilder {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .build();

        Computer computer2 = new Computer.Builder()
                .setCPU("AMD Ryzen 7")
                .setRAM("32GB")
                .setStorage("2TB HDD")
                .build();

        System.out.println(computer1);
        System.out.println(computer2);
    }
}
