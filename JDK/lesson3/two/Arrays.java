package JDK.lesson3.two;

public class Arrays {

    public static <T> boolean compareArrays(T[] arr, T[] arr2) {
        boolean isTheLengthsEquals = arr.length == arr2.length;
        boolean isTheClaasEquals = arr.getClass().getName().equals(arr2.getClass().getName());
        return isTheLengthsEquals && isTheClaasEquals;
    }
}