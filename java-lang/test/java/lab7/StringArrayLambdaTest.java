package lab7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringArrayLambdaTest {
    @Test
    void testEmptyArr() {
        String[] emptyArr = new String[]{};

        String[] got = StringArrayLambda.lessThanAverage(emptyArr);

        assertThat(got).isNotNull();
        assertThat(got).isEmpty();
    }

    @Test
    void testArrWithOneWord() {
        String[] inputArr = new String[]{"1"};

        String[] got = StringArrayLambda.lessThanAverage(inputArr);
        assertThat(got).isEqualTo(inputArr);
    }

    @Test
    void testRandomArr() {
        String[][] inputArrays = new String[][]{
                {"lab1", "ab1l", "b1la", "1lab"},
                {"java", "some text", "AbCd@", "a", "22"},
                {" 3 ", "  5  ", "   7   "},};

        String[][] expectedArrays = new String[][]{
                {"lab1", "ab1l", "b1la", "1lab"},
                {"java", "a", "22"},
                {" 3 ", "  5  "},};

        for (int i = 0; i < inputArrays.length; i++) {
            String[] got = StringArrayLambda.lessThanAverage(inputArrays[i]);
            assertThat(got).isEqualTo(expectedArrays[i]);
        }
    }
}
