package JDK.lesson2.repository;

public interface Repository {
    void saveInLog(String text);

    String readLog();

    String getHistory();

}