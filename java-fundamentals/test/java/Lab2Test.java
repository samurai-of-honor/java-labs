import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Lab2Test {
    @Test
    void testEmptyMatrix() {
        double[][] m = {};

        assertThat(Lab2.transpose(m)).isNullOrEmpty();
        assertThat(Lab2.transpose(new double[0][1])).isEqualTo(new double[0][1]);

        assertThat(Lab2.elementSum(Lab2.transpose(m))).isEqualTo(0);
    }

    @Test
    void testStandardMatrix() {
        double[][][] someMatrix = {
                {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                {{-1.5, 2.5}, {9.25, 0.25}, {-6.0, 4.75}},

                {{37.04, 60.16, -30.93, 69.80, -35.82},
                        {-26.73, 1.70, 68.72, -32.09, 42.99},
                        {-6.73, 47.27, 23.28, 35.84, -27.29},
                        {-19.91, 60.88, 86.43, 19.05, -7.93},
                        {24.09, 26.06, 81.93, 54.73, 92.98},}
        };

        double[][][] transposedMatrix = {
                {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}},
                {{-1.5, 9.25, -6.0}, {2.5, 0.25, 4.75}},

                {{37.04, -26.73, -6.73, -19.91, 24.09},
                        {60.16, 1.70, 47.27, 60.88, 26.06},
                        {-30.93, 68.72, 23.28, 86.43, 81.93},
                        {69.80, -32.09, 35.84, 19.05, 54.73},
                        {-35.82, 42.99, -27.29, -7.93, 92.98},}
        };

        double[] sum = {12, -1.25, 37.2};

        for (int i = 0; i < someMatrix.length; i++) {
            assertThat(Lab2.transpose(someMatrix[i])).isEqualTo(transposedMatrix[i]);
            assertThat((double) Math.round(Lab2.elementSum(transposedMatrix[i]) * 100) / 100).isEqualTo(sum[i]);
        }
    }

    @Test
    void testDiffLengthMatrix() {
        double[][][] someMatrix = {
                {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}, {10}},
                {{0, 0, 0, 0},
                        {-5.5, -7.1, 67},
                        {-1.5, 2.5},
                        {9.25, 0.25, 0, 4.75}},
        };

        double[][][] transposedMatrix = {
                {{1, 4, 6, 10}, {2, 5, 7, 0}, {3, 0, 8, 0}, {0, 0, 9, 0}},
                {{0, -5.5, -1.5, 9.25},
                        {0, -7.1, 2.5, 0.25},
                        {0, 67, 0, 0},
                        {0, 0, 0, 4.75}},
        };

        double[] sum = {17, 1.75};

        for (int i = 0; i < someMatrix.length; i++) {
            assertThat(Lab2.transpose(someMatrix[i])).isEqualTo(transposedMatrix[i]);
            assertThat(Lab2.elementSum(transposedMatrix[i])).isEqualTo(sum[i]);
        }
    }
}