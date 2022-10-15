public class Lab1 {
    public static double MyMathExpression(int fromA, int toN, int fromB, int toM) {
        double sum = 0;

        if (fromA > toN || fromB > toM) {
            throw new IllegalArgumentException("Lower bounds greater than upper bounds!");
        }

        for(byte i = (byte) fromA; i <= toN; i++){
            for(byte j = (byte) fromB; j<= toM; j++){
                if (j == 0) {
                    throw new ArithmeticException("Division by 0!");
                }

                double numerator = i * 1.0 / j;
                int denominator = i - 1;

                if (denominator == 0) {
                    throw new ArithmeticException("Division by 0!");
                }

                sum += numerator / denominator;
            }
        }
        return sum;
    }
}
