package Level_2_Lesson_2;

import java.io.IOException;

public class Main {

    public static int LENGTH = 4;
    public static int HEIGHT = 4;

    public static void main(String[] args) {
        String str_data = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            String[][] array = create_new_array(str_data);
            System.out.println(parseIntMethod(array));
        } catch (IOException e) {
            throw new MyNumberFormatException(e.getMessage());
        }
    }

    public static String[][] create_new_array(String data) throws IOException {
        String[] array = data.split("\n");
        if (array.length != LENGTH) {
            throw new LengthArrayException();
        }
        String[][] new_array = new String[LENGTH][];
        for (int i = 0; i < new_array.length; i++) {
            new_array[i] = array[i].split(" ");
            if (array.length != HEIGHT) {
                throw new HeightArrayException();
            }
        }
        return new_array;
    }

    static int parseIntMethod(String[][] new_array) throws IOException {
        int intRes = 0;
        for (String[] strings : new_array) {
            for (String string : strings) {
                try {
                    intRes += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new MyNumberFormatException(string);
                }
            }
        }
        return intRes / 2;
    }
}

class LengthArrayException extends IOException {
    LengthArrayException() {
    }
}

class HeightArrayException extends IOException {
    HeightArrayException() {
    }
}

class MyNumberFormatException extends NumberFormatException {
    MyNumberFormatException(String strExc) {

    }
}