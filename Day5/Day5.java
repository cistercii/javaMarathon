package Day5;

public class Day5 {

    static public void solution_1() {
        Car car = new Car();

        car.setColor("Red");
        car.setYear(2021);
        car.setModel("Renault");

        System.out.println(car.getColor());
        System.out.println(car.getYear());
        System.out.println(car.getModel());
    }

    static public void solution_2() {
        Motorbike motorbike = new Motorbike("Red", 2012, "BMW");

        System.out.println(motorbike.getColor());
        System.out.println(motorbike.getYear());
        System.out.println(motorbike.getModel());
    }
}
