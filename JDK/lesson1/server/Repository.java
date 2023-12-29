package JDK.lesson1.server;

// Интерфейс Repository объявляет два абстрактных метода, которые реализуются в классе FileStorage.

public interface Repository<T> {
    void saveMessage(T text);

    T readText();
}