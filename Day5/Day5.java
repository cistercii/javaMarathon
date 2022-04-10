package Day5;

public class Day5 {

    static public void solution_1() {
        Car car = new Car();

        car.setColor("Red");
        car.setYear("2021");
        car.setModel("Renault");

        System.out.println(car.getColor());
        System.out.println(car.getYear());
        System.out.println(car.getModel());
    }

    static public void solution_2() {
        Motorbike motrbike = new Motorbike("Red", "2012", "BMW");

        System.out.println(motrbike.getColor());
        System.out.println(motrbike.getYear());
        System.out.println(motrbike.getModel());
    }
}
