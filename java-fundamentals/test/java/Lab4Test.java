import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Lab4Test {
    @Test
    void testShipCompareTo() {
        Ship testShip1 = new Ship("Victory", 2022, "Ukraine", 1000,100);
        Ship testShip2 = new Ship("Titanic", 1912, "United Kingdom", 3327,269);

        int actual = testShip1.compareTo(testShip2);

        assertThat(actual).isEqualTo(0);
    }
}
