package JDK.lesson3.two;

public class Main {
    public static void main(String[] args) {

        String[] arr1 = new String[] { "Hello world" };
        String[] arr2 = new String[] { "hi!" };

        Integer[] arr3 = new Integer[] { 1, 2, 3 };
        Integer[] arr4 = new Integer[] { 1, 2, 3 };

        String[] arr5 = new String[] { "5", "6", "8" };
        Integer[] arr6 = new Integer[] { 5, 6, 7, 8 };

        Integer[] arr7 = new Integer[] { 5, 6, 7, 8 };
        String[] arr8 = new String[] { "Winter", "Spring", "Autumn" };

        Arrays arraysCheck = new Arrays();

        System.out.println(arraysCheck.compareArrays(arr1, arr2));
        System.out.println(arraysCheck.compareArrays(arr3, arr4));
        System.out.println(arraysCheck.compareArrays(arr5, arr6));
        System.out.println(arraysCheck.compareArrays(arr7, arr8));
    }
}