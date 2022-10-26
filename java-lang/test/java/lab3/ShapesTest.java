package lab3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapesTest {
    @Test
    void testRectangle() {
        Rectangle rectangle = new Rectangle("red", 12, 3.5);
        assertThat(rectangle.getColor()).isEqualTo("red");
        assertThat(rectangle.calcArea()).isEqualTo(42);
        assertThat(rectangle.toString()).isEqualTo("Rectangle: area = 42,00, color = red");
    }

    @Test
    void testCircle() {
        Circle circle = new Circle("blue", 5);
        assertThat(circle.getColor()).isEqualTo("blue");
        assertThat(circle.calcArea()).isEqualTo(25 * Math.PI);
        assertThat(circle.toString()).isEqualTo("Circle: area = 78,54, color = blue");
    }

    @Test
    void testTriangle() {
        Triangle triangle = new Triangle("green", 3, 4);
        assertThat(triangle.getColor()).isEqualTo("green");
        assertThat(triangle.calcArea()).isEqualTo(6);
        assertThat(triangle.toString()).isEqualTo("Triangle: area = 6,00, color = green");
    }
}
