import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    private static final char HUMAN_DOT = 'X';
    private static final char PC_DOT = 'O';
    private static final char EMPTY_DOT = '_';
    public static final Random RANDOM = new Random();

    public static final Scanner SCANNER = new Scanner(System.in);
    public static int fieldSizeX;
    public static int fieldSizeY;
    public static char[][] field;

    public static void initMap() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeY][fieldSizeX];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }
    public static void printMap() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }
    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    public static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты Х: У через Enter");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));
        field[y][x] = HUMAN_DOT;
    }

    public static void pcTurn() {
        int y, x;
        do {
            y = RANDOM.nextInt(fieldSizeY);
            x = RANDOM.nextInt(fieldSizeX);
        }
        while (!isEmptyCell(y, x));
        field[y][x] = PC_DOT;
    }

    public static boolean isFullMap() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char c) {
        return checkDiagonal(c) || checkLanes(c);
    }

    public static boolean checkLanes(char c) {
        boolean cols, rows;
        for (int x = 0; x < fieldSizeX; x++) {
            cols = true;
            rows = true;
            for (int y = 0; y < fieldSizeY; y++) {
                cols &= (field[x][y] == c);
                rows &= (field[y][x] == c);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    public static boolean checkDiagonal(char c) {
        boolean toX, toY;
        toX = true;
        toY = true;
        for (int i = 0; i < fieldSizeX; i++) {
            toX &= (field[i][i] == c);
            toY &= (field[fieldSizeY - i - 1][i] == c);
        }
        return toX || toY;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        System.out.println();
        while (true) {
            humanTurn();
            printMap();
            System.out.println();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Человек выиграл!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья!");
                break;
            }
            pcTurn();
            printMap();
            System.out.println();
            if (checkWin(PC_DOT)) {
                System.out.println("PC выиграл!");
                break;
            }
            if (isFullMap()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
