package Lesson1;

public class Lesson1 {
    // задание 1
    public static void main(String[] args) {

// задание 2
        byte numberByte = 1;
        int numberInt = 1243;
        long numberLong = 1231243L;

        double numberDouble = 23.4;
        float numberFloat = 23.4F;

        char nameChar = 'y';
        String nameString = "Hello";

        boolean nameBoolean = true;
// проверка заданий 3, 4, 5, 6
        System.out.println(formula(5, 6, 8.6, 2.5));
        System.out.println(test(25, 6));
        test2(12345);
        System.out.println(test3(1900));
    }

    //задание 3
    public static double formula(int a, int b, double c, double d) {
        return a * (b + (c / d));
    }

    // задание 4
    public static Boolean test(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    // задание 5
    public static void test2(int a) {

        int reverse = 0;
        while (a != 0) {
            reverse = reverse * 10;
            reverse = reverse + a % 10;
            a = a / 10;
        }
        System.out.println(reverse);
    }

    // задание 6
    public static boolean test3(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }
}
