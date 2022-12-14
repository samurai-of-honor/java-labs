package lab3;

import java.io.Serializable;

public abstract class Shape implements Drawable, Serializable {
    private final String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract double calcArea();

    @Override
    public void draw() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%s: area = %.2f, color = %s", this.getClass().getSimpleName(), calcArea(), getColor());
    }
}
