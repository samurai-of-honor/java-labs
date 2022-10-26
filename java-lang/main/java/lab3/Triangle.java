package lab3;

public class Triangle extends Shape {
    private final double side, height;

    public Triangle(String color, double side, double height) {
        super(color);
        this.side = side;
        this.height = height;
    }

    public double calcArea() {
        return (side * height) / 2.0;
    }
}
