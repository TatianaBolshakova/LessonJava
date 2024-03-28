package Lesson2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;


public class Lesson2 {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        replacement(array1);

        int[] array2 = new int[8];
        completion(array2);

        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplication(array3);

        int[] array4 = {6, 54, 87, 6, 5, 4, 3, -1};
        searchMinValue(array4);
        searchMaxValue(array4);

        int[][] array5 = new int[6][6];
        fillingInTheDiagonals(array5);

        int[] array6 = IntStream.generate(() -> new Random().nextInt(4)).limit(4).toArray();
        System.out.println(Arrays.toString(array6));
        System.out.println(checkBalance(array6));

        int[] array7 = {6, 54, 87, 6, 5, 4, 3, -1};
        offset(array7, -2);
        System.out.println(Arrays.toString(array7));

    }

    // задание 1
    public static void replacement(int[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == 1) {
                args[i] = 0;
            } else {
                args[i] = 1;
            }
        }
        System.out.println(Arrays.toString(args));

    }

    // задание 2
    public static void completion(int[] args) {

        for (int i = 1; i < args.length; i++) {
            args[0] = 1;
            args[i] = args[i - 1] + 3;
        }
        System.out.println(Arrays.toString(args));
    }

    // задание 3
    public static void multiplication(int[] args) {
        for (int i : args) {
            if (args[i] < 6) {
                args[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(args));
    }

    // задание 4
    public static void searchMinValue(int[] args) {
        int min = args[0];
        for (int i : args) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(min);
    }

    public static void searchMaxValue(int[] args) {
        int max = args[0];
        for (int i : args) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }

    // задание 5
    public static void fillingInTheDiagonals(int[][] args) {
        for (int i = 0; i < args.length; i++) {
            for (int j = 0, x = args[i].length; j < args.length; j++, x--) {

                if (i == j || i == x - 1) args[i][j] = 1;
                System.out.print(args[i][j] + " ");
            }
            System.out.println();
        }
    }

    // задание 6
    public static boolean checkBalance(int[] args) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < args.length - 1; i++) {
            start += args[i];
            for (int j = i + 1; j < args.length; j++)
                end += args[j];
            if (start == end) return true;
            end = 0;
        }
        return false;
    }

    // задание 7-8
    public static void offset(int[] args, int n) {
        boolean offset = n < 0;
        if (offset) n = -n;
        n %= args.length;
        for (int i = 0; i < n; i++) {
            int element ;
            if (offset) {
                element = args[0];
                System.arraycopy(args, 1, args, 0, args.length - 1);
                args[args.length - 1] = element;
            } else {
                element = args[args.length - 1];
                System.arraycopy(args, 0, args, 1, args.length - 1);
                args[0] = element;
            }
        }
    }
}
