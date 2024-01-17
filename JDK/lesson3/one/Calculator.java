package JDK.lesson3.one;

public class Calculator {

    /**
     *
     * @param first
     * @param second
     * @return результат сложения
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double sum(F first, S second) {
        return first.doubleValue() + second.doubleValue();
    }

    /**
     *
     * @param first
     * @param second
     * @return произведение
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double multiply(F first, S second) {
        return first.doubleValue() * second.doubleValue();
    }

    /**
     *
     * @param first  делимое
     * @param second делитель
     * @return частное
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double divide(F first, S second) {
        return first.doubleValue() / second.doubleValue();
    }

    /**
     *
     * @param first  Уменьшаемое
     * @param second Вычитаемое
     * @return
     * @param <F>
     * @param <S>
     */
    public static <F extends Number, S extends Number> double subtract(F first, S second) {
        return first.doubleValue() - second.doubleValue();
    }
}
