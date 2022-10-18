package lab1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringArrayTest {
    @Test
    void testEmptyArr() {
        String[] emptyArr = new String[]{};

        String[] got = StringArray.lessThanAverage(emptyArr);

        assertThat(got).isNotNull();
        assertThat(got).isEmpty();
    }

    @Test
    void testRandomArr() {
        String[][] inputArrays = new String[][]{
                {"1"},
                {"lab1", "ab1l", "b1la", "1lab"},
                {"java", "some text", "AbCd@", "a", "22"},
                {" 3 ", "  5  ", "   7   "},
        };

        String[][] expectedArrays = new String[][]{
                {},
                {},
                {"java", "a", "22"},
                {" 3 "},
        };

        for (int i = 0; i < inputArrays.length; i++) {
            String[] got = StringArray.lessThanAverage(inputArrays[i]);
            assertThat(got).isEqualTo(expectedArrays[i]);
        }
    }
}
