package lab3;

import java.io.*;

public class ShapeHandler {
    public static void saveShapes(Shape[] shapes, String filePath) {
        try (ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            ostream.writeObject(shapes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Shape[] loadShapes(String filePath) {
        try (ObjectInputStream istream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Shape[]) istream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Shape[] generateRandomShapes(int n) {
        String[] colors = {"red", "green", "blue", "yellow", "black", "white", "orange", "pink", "gray", "brown"};
        Shape[] shapes = new Shape[n];

        for (int i = 0; i < n; i++) {
            String color = colors[(int) (Math.random() * colors.length)];

            switch ((int) (Math.random() * 3)) {
                case 0 -> shapes[i] = new Circle(color, Math.random() * 10);
                case 1 -> shapes[i] = new Rectangle(color, Math.random() * 10, Math.random() * 10);
                case 2 -> shapes[i] = new Triangle(color, Math.random() * 10, Math.random() * 10);
            }
        }
        return shapes;
    }

    public static void drawShapes(Shape[] shapes) {
        for (Shape sh : shapes) {
            sh.draw();
        }
    }

    public static double totalArea(Shape[] shapes) {
        double total = 0;
        for (Shape sh : shapes) {
            total += sh.calcArea();
        }
        return total;
    }

    public static double figuresArea(Shape[] shapes, Shape figure) {
        double total = 0;
        for (Shape sh : shapes) {
            if (sh.getClass().equals(figure.getClass())) {
                total += sh.calcArea();
            }
        }
        return total;
    }

    public static Shape[] sortByArea(Shape[] shapes) {
        // Cloning so as not to change the original array
        Shape[] sorted = shapes.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted.length - 1; j++) {
                int compare = Double.compare(sorted[j].calcArea(), sorted[j + 1].calcArea());

                if (compare > 0) {
                    Shape s = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = s;
                }
            }
        }
        return sorted;
    }

    public static Shape[] sortByColor(Shape[] shapes) {
        Shape[] sorted = shapes.clone();
        for (int i = 0; i < sorted.length; i++) {
            for (int j = 0; j < sorted.length - 1; j++) {
                int compare = sorted[j].getColor().compareTo(sorted[j + 1].getColor());

                if (compare > 0) {
                    Shape s = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = s;
                }
            }
        }
        return sorted;
    }
}
