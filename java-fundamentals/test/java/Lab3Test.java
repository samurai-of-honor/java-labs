import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Lab3Test {
    @Test
    void testEmptyString() {
      String inputStr = "";
      StringBuffer input = new StringBuffer(inputStr);
      String expected = "[]";

      StringBuffer actual = Lab3.sortBySymbolCount(input, ' ');

      assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void testOneWord() {
      String inputStr = "word";
      StringBuffer input = new StringBuffer(inputStr);
      String expected = "[word]";

      StringBuffer actual = Lab3.sortBySymbolCount(input, 'o');

      assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void testTwoWord() {
        String inputStr = "Two wword";
        StringBuffer input = new StringBuffer(inputStr);
        String expected = "[wword, two]";

        StringBuffer actual = Lab3.sortBySymbolCount(input, 'w');

        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void testSortWithNonPresentSymbol() {
        String inputStr = "Hello, world!";
        StringBuffer input = new StringBuffer(inputStr);
        String expected = "[hello, world]";

        StringBuffer actual = Lab3.sortBySymbolCount(input, '1');

        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void testIdenticalWords() {
        String inputStr = "aaa aaa aaa";
        StringBuffer input = new StringBuffer(inputStr);
        String expected = "[aaa, aaa, aaa]";

        StringBuffer actual = Lab3.sortBySymbolCount(input, 'a');

        assertThat(actual.toString()).isEqualTo(expected);
    }

    @Test
    void testSortSomeText() {
        String inputStr = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        StringBuffer input = new StringBuffer(inputStr);
        String expected = "[consectetur, sit, amet, elit, lorem, ipsum, dolor, adipiscing]";

        StringBuffer actual = Lab3.sortBySymbolCount(input, 't');

        assertThat(actual.toString()).isEqualTo(expected);
    }
}