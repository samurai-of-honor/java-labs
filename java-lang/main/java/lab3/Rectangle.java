package lab3;

public class Rectangle extends Shape {
    private final double width, height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double calcArea() {
        return (width * height);
    }
}
