package Day6;

import Day5.Car;
import Day5.Motorbike;

public class Day6 {

    static public void solution_1() {
        Car car = new Car();
        car.setColor("Green");
        car.setYear(2000);
        car.setModel("Audi");

        car.info();
        System.out.println(car.yearDifference(2015));

        Motorbike bike = new Motorbike("Blue", 2005, "Honda");
        bike.info();
        System.out.println(bike.yearDifference(2015));
    }

    static public void solution_2() {
        Airplane air = new Airplane("Boeing", 2010, 20.0, 4000.0);
        air.info();
        air.setYear(2012);
        air.setLength(25.0);
        air.fillUp(10.0);
        air.fillUp(20.0);
        air.info();
    }

    static public void solution_3() {
        Teacher teacher = new Teacher("Bob", "chemistry");
        Student student = new Student("Garry");
        teacher.evaluate(student);
    }
}
