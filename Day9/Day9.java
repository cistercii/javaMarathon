package Day9;

import Day9.Figure.Circle;
import Day9.Figure.Figure;
import Day9.Figure.Rectangle;
import Day9.Figure.Triangle;
import Day9.Human.*;

public class Day9 {
    static public void solution_1() {
        Human teacher = new Teacher("Bob", "Phisics");
        Human student = new Student("Harry", 5);

        teacher.printInfo();
        student.printInfo();
    }

    static public void solution_2() {
        Figure [] figures = {
                new Triangle("Red", 10, 10, 10),
                new Triangle("Green", 10, 20, 30),
                new Triangle("Red", 10, 20, 15),
                new Rectangle("Red", 5, 10),
                new Rectangle("Orange", 40, 15),
                new Circle("Red", 4),
                new Circle("Red", 10),
                new Circle("Blue", 5)
        };

        double calculateRedPerimeter = Day9.calculateRedPerimeter(figures);
        double calculateRedArea = Day9.calculateRedArea(figures);

        System.out.println("Суммарная площадь красных фигур: " + calculateRedArea);
        System.out.println("Суммарный периметр красных фигур: " + calculateRedPerimeter);
    }

    public static double calculateRedPerimeter(Figure[] figures) {
        double result = 0.0;
        for (Figure figure : figures) {
            if (figure.getColor().equals("Red")) {
                result += figure.perimeter();
            }
        }
        return result;
    }

    public static double calculateRedArea (Figure[] figures) {
        double result = 0.0;
        for (Figure figure : figures) {
            if (figure.getColor().equals("Red")) {
                result += figure.area();
            }
        }
        return result;
    }
}
