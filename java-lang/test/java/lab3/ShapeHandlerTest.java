package lab3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ShapeHandlerTest {
        Shape[] shapes = {
                new Rectangle("black", 12, 3.5),
                new Circle("red", 5),
                new Rectangle("green", 2, 4),
                new Triangle("yellow", 3, 4),
                new Circle("black", 9),
                new Triangle("white", 6, 8)
        };

        @Test
        public void testGenerateRandomShapes() {
            Shape[] randomShapes = ShapeHandler.generateRandomShapes(10);
            assertThat(randomShapes).hasSize(10);
        }

        @Test
        public void testDrawShapes() {
            ShapeHandler.drawShapes(shapes);
        }

        @Test
        void testTotalArea() {
                assertThat(Math.round(ShapeHandler.totalArea(shapes))).isEqualTo(413);
        }

        @Test
        void testFiguresArea() {
                Shape desiredFigure = new Rectangle("", 0, 0);
                assertThat(ShapeHandler.figuresArea(shapes, desiredFigure)).isEqualTo(50.0);
        }

        @Test
        void testSortByArea() {
                Shape[] sortedShapes = ShapeHandler.sortByArea(shapes);
                assertThat(sortedShapes[0].calcArea()).isEqualTo(6.0);
                assertThat(Math.round(sortedShapes[sortedShapes.length - 1].calcArea())).isEqualTo(254);
        }

        @Test
        void testSortByColor() {
                Shape[] sortedShapes = ShapeHandler.sortByColor(shapes);
                assertThat(sortedShapes[0].getColor()).isEqualTo("black");
                assertThat(sortedShapes[sortedShapes.length - 1].getColor()).isEqualTo("yellow");
        }
    }
