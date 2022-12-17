import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Lab1Test {
    @Test
    void testExceptions() {
        int count = 0;
        String divByZero = "Division by 0!";

       try {
            Lab1.MyMathExpression(5,5,0,5);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(divByZero);
            count++;
        }

        try {
            Lab1.MyMathExpression(-3, 5, 5, 5);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(divByZero);
            count++;
        }

        try {
            Lab1.MyMathExpression(1, 5, 5, 5);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo(divByZero);
            count++;
        }

        try {
            Lab1.MyMathExpression(5, 2, 5, -2);
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Lower bounds greater than upper bounds!");
            count++;
        }

        assertThat(count).isEqualTo(4);
    }

    @Test
    void testExpression() {
        assertThat(Lab1.MyMathExpression(2,2,1,1)).isEqualTo(2);
        assertThat(Lab1.MyMathExpression(-4, -3, 1,1)).isEqualTo(1.55);
        assertThat(Lab1.MyMathExpression(2, 2, -2,-1)).isEqualTo(-3);
    }
}
