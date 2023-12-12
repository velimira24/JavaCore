import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final char DOT_HUMAH = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    // создаем поле

    private static void initField() {
        do {
            System.out.printf("Введите высоту X (от 1) и ширину Y (от 1) через пробел >>> %n");
            fieldSizeX = SCANNER.nextInt();
            fieldSizeY = SCANNER.nextInt();
        } while (fieldSizeX < 0 || fieldSizeY < 0);
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    // выводим поле

    private static void printField() {
        System.out.print(" +");
        for (int i = 0; i < fieldSizeY * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? " – " : i / 2 + 1);
        }
        System.out.println();
        for (int i = 0; i < fieldSizeY * 2 + 2; i++) {
            System.out.print(" –");
        }
        System.out.println();
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(" " + (x + 1) + " | ");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + " | ");

            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeY * 2 + 2; i++) {
            System.out.print(" –");
        }
        System.out.println();
    }

    // ход человека

    private static void humanTurn() {
        int x, y;
        do {
            System.out.printf("Введите координаты X (от 1 до %d) и Y (от 1 до %d) через пробел >>> %n",
                    fieldSizeX,
                    fieldSizeY);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAH;
    }

    // ход машины

    private static void botTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * 
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY;
    }

    /**
     * Поверка строк, колонок и диагоналей
     *
     * @param player
     * @return
     */
    static boolean checkWin(char player) {

        for (int x = 0; x < fieldSizeX; x++) {
            boolean win = true;
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        for (int y = 0; y < fieldSizeY; y++) {
            boolean win = true;
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        // диагонали
        boolean win;
        for (int diagonal = 0; diagonal < Math.max(fieldSizeX, fieldSizeY) - Math.min(fieldSizeX, fieldSizeY)
                + 1; diagonal++) {
            win = true;
            for (int i = 0; i < Math.min(fieldSizeX, fieldSizeY); i++) {
                if (field[i][i + diagonal] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }

        // обратные диагонали
        for (int diagonal = 0; diagonal < Math.max(fieldSizeX, fieldSizeY) - Math.min(fieldSizeX, fieldSizeY)
                + 1; diagonal++) {
            win = true;
            for (int i = 0; i < Math.min(fieldSizeX, fieldSizeY); i++) {
                if (field[i][fieldSizeY - 1 - i - diagonal] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        return false;
    }

    /**
     * проверка
     * 
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y))
                    return true;
            }
        }
        System.out.println("Draw. Maybe another one?");
        return false;
    }

    /**
     * проверка выйгрыша
     * 
     * @param player
     * @param str
     * @return
     */
    static boolean gameCheck(char player, String str) {
        if (checkWin(player)) {
            System.out.println(str);
            return true;
        }
        return false;
    }

    /**
     * создать поле, напечатать поле, запрос на движение до победы человека или бота
     * 
     * @param args
     */
    public static void main(String[] args) {
        initField();
        printField();
        while (checkDraw()) {
            humanTurn();
            printField();
            if (gameCheck(DOT_HUMAH, "Human is WIN !!!")) {
                break;
            }
            botTurn();
            printField();
            if (gameCheck(DOT_AI, "Bot is WIN !!!")) {
                break;
            }
        }
    }
}
