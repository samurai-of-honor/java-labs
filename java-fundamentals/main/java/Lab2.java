import java.util.ArrayList;

public class Lab2 {
    public static void printMatrix(double[][] m) {
        for (double[] row : m) {
            for (double cell : row) {
                System.out.printf("%.2f  ", cell);
            }
            System.out.print("\n");
        }
    }

    public static double[][] fillMatrix(double[][] m) {
        // Find the longest row in matrix
        int maxLength = 0;
        for (double[] row : m) {
            if (row.length > maxLength) {
                maxLength = row.length;
            }
        }

        // Fill matrix to the maximum length with zeros
        ArrayList<double[]> tempM = new ArrayList<>(java.util.Arrays.asList(m));
        for (int i = 0; i < tempM.size(); i++) {
            double[] row = tempM.get(i);
            if (row.length < maxLength) {
                tempM.set(i, java.util.Arrays.copyOf(row, maxLength));
            }
        }

        return tempM.toArray(new double[0][]);
    }

    public static double[][] transpose(double[][] m) {
        if (m.length == 0) {
            return m;
        }

        // Checking the number of elements in each row
        int firstRowLength = m[0].length;
        for (double[] row : m) {
            if (row.length != firstRowLength) {
                m = fillMatrix(m);
                break;
            }
        }

        // Transpose matrix
        double[][] newM = new double[m[0].length][m.length];

        for (int i = 0; i < newM.length; i++) {
            for (int j = 0; j < newM[i].length; j++) {
                newM[i][j] = m[j][i];
            }
        }

        return newM;
    }

    // Sum of the largest elements of paired rows and the smallest elements of unpaired rows
    public static double elementSum(double[][] m) {
        double sum = 0, n;

        for (int i = 0; i < m.length; i++) {
            n = m[i][0];

            for (int j = 1; j < m[i].length; j++) {
                double curr = m[i][j];

                if ((i+1) % 2 == 0 && curr > n) {
                    n = curr;
                }

                if ((i+1) % 2 == 1 && curr < n) {
                    n = curr;
                }
            }

            sum += n;
        }

        return sum;
    }

    public static void main(String[] args) {
        double[][] testM = {
                {1,2,3},
                {4,5},
                {6,7,8,9},
                {10},
        };

        System.out.println("Start matrix:");
        printMatrix(testM);

        System.out.println("\nTransposed matrix:");
        double[][] tM = Lab2.transpose(testM);
        printMatrix(tM);

        System.out.println("\nSum of elements:");
        System.out.println(Lab2.elementSum(tM));
    }
}
