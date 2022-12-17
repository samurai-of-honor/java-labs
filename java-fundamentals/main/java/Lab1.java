public class Lab1 {
    public static double MyMathExpression(int fromA, int toN, int fromB, int toM) {
        if (fromA > toN || fromB > toM) {
            throw new IllegalArgumentException("Lower bounds greater than upper bounds!");
        }

        if ((fromA <= 1 && toN >= 1) || (fromB <= 0 && toM >= 0)) {
            throw new ArithmeticException("Division by 0!");
        }

        double sum = 0;

        for (byte i = (byte) fromA; i <= toN; i++) {
            double denominator = 1 - 1 / (double) i;

            for (byte j = (byte) fromB; j <= toM; j++) {
                sum += 1 / (denominator * j);
            }
        }
        return sum;
    }
}
