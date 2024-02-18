package Lesson6;

import java.io.*;
import java.util.Scanner;

public class Lesson6 {
    public static void main(String[] args) throws FileNotFoundException {

        String text1 = "Nature is all around us. We see it every day. It’s the sunset, the sunrise, the song of birds, the blooming оf flowers, the wind that blows, etc.";
        String text2 = "On the one hand we cherish these natural blessings, on the other hand – we don’t appreciate fully their importance.";
        String nameText1 = "text1.txt";
        String nameText2 = "text2.txt";
        String nameTextCommon = "text_common.txt";

        outputText(text1, nameText1);
        outputText(text2, nameText2);
        commonText(nameText1, nameText2, nameTextCommon);

        String textCommon = inputText(nameTextCommon);
        System.out.println(textCommon);
        searchWord(nameTextCommon, "Nature");
    }

    public static void outputText(String text, String nameText) {
        try {
            PrintStream ps = new PrintStream(new FileOutputStream(nameText));
            ps.println(text);
            ps.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String inputText(String nameNext) {
        StringBuilder textCommon = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(nameNext);
            int singleCharFile;
            while ((singleCharFile = fis.read()) != -1) {
                textCommon.append((char) singleCharFile);
            }
        } catch (IOException e) {
            System.out.println("Error write file");
        }
        return textCommon.toString();
    }

    public static void commonText(String nameText1, String nameText2, String nameTextCommon) {
        String textCommon = inputText(nameText1) + inputText(nameText2);
        outputText(textCommon, nameTextCommon);
    }

    public static void searchWord(String t, String sear) throws FileNotFoundException {
        File file = new File(t);
        Scanner scannerFile = new Scanner(file);

        while (scannerFile.hasNext()) {
            String search = scannerFile.next();
            System.out.println("SEARCH CONTENT:" + search);

            if (search.equalsIgnoreCase(sear)) {
                System.out.println("Found: " + search);
                return;
            } else {
                System.out.println("No data found:" + sear);
            }
        }
    }

}
