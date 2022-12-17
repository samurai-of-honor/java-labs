package lab3;

public class Circle extends Shape {
    private final double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double calcArea() {
        return (radius * radius * Math.PI);
    }
}
