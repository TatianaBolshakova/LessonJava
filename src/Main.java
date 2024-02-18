public class Main {
    public static void main(String[] args) {


        byte numberByte = 1;
        int numberInt = 1243;
        long numberLong = 1231243L;

        double numberDouble = 23.4;
        float numberFloat = 23.4F;

        char nameChar = 'y';
        String nameString = "Hello";

        boolean nameBoolean = true;

        System.out.println(formula(5, 6, 8.6, 2.5));

        System.out.println(test(25, 6));
    }

    public static double formula(int a, int b, double c, double d) {
        return a * (b + (c / d));
    }

    public static Boolean test(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }
}