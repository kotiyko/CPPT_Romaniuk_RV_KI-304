package KI.Romaniuk.Lab4;

/**
 * Клас для обчислення значення функції y = cot(8x) / x.
 */
 class ExpressionCalculator {

    /**
     * Метод для обчислення виразу y = cot(8x) / x.
     *
     * @param x значення аргументу
     * @return результат обчислення
     * @throws IllegalArgumentException якщо x дорівнює нулю
     */
    public double calculate(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("Значення x не може дорівнювати нулю");
        }

        double cotangent = 1 / Math.tan(8 * x);
        return cotangent / x;
    }
}
