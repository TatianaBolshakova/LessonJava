package Level_2_Lesson_5;


import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {

        float[] arr_m1 = new float[SIZE];
        Arrays.fill(arr_m1, 1);
        float[] arr_m2 = new float[SIZE];
        Arrays.fill(arr_m2, 1);
        method_1(arr_m1);
        method_2(arr_m2);
        if (Arrays.equals(arr_m1, arr_m2)) {
            System.out.println("Массивы равны:" + true);
        }

    }

    public static void method_1(float[] arr) {

        long a = System.currentTimeMillis();
        MyThread thread = new MyThread(arr, 0);
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Time method_1: " + (System.currentTimeMillis() - a));
    }

    public static void method_2(float[] arr) {
        long b = System.currentTimeMillis();
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        MyThread thread1 = new MyThread(arr1, 0);
        MyThread thread2 = new MyThread(arr2, HALF);
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);

        System.out.println("Time method_2: " + (System.currentTimeMillis() - b));
    }
}

class MyThread extends Thread {
    private final float[] arr;
    private final float bias;

    public MyThread(float[] arr, float bias) {
        this.arr = arr;
        this.bias = bias;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + bias) / 5) * Math.cos(0.2f + (i + bias) / 5) *
                    Math.cos(0.4f + (i + bias) / 2));
        }
    }
}