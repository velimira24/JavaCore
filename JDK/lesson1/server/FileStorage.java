package JDK.lesson1.server;

import java.io.FileReader;
import java.io.FileWriter;

public class FileStorage implements Repository<String> {
    private static final String LOG_PATH = "src/main/java/ru/geekbrains/seminar_2/server/history.txt";

    // Метод saveMessage сохраняет переданную строку text в файл, указанный в
    // переменной LOG_PATH.

    @Override
    public void saveMessage(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод readText предназначен для считывания текста из файла и его возврата в
    // виде строки.
    // Создается объект StringBuilder для хранения считанных символов, а также
    // экземпляр класса FileReader для чтения содержимого файла.
    // В цикле while считываетсякаждый символ из файла и добавляется в
    // StringBuilder.
    @Override
    public String readText() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
