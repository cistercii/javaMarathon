package Day9.Figure;

public class Rectangle extends Figure {

    private final double length;
    private final double height;

    public Rectangle(String color, int length, int height) {
        super(color);
        this.length = length;
        this.height = height;
    }

    @Override
    public double area() {
        return length * height;
    }

    @Override
    public double perimeter() {
        return 2 * length + 2 * height;
    }
}
