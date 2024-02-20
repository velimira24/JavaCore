package JavaJunior.lesson3.ser;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Nikita", 26, 4.8);

        try (FileOutputStream fileOutputStream = new FileOutputStream("studentdata.bin");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("studentdata.bin");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний бал: " + student.getGPA());

    }
}