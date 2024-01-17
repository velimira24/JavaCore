package JDK.lesson3.three;

public class Main {
    public static void main(String[] args) {
        Pair pair = new Pair("first", 2);

        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
        System.out.println("\n" + pair + "\n");
    }
}