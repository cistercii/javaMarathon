package Day6;

public class Airplane {

    private final String producer;
    private int year;
    private double length;
    private double weight;
    private double fuel = 0.0;

    public Airplane(String producer, int year, double length, double weight) {
        this.producer = producer;
        this.year = year;
        this.length = length;
        this.weight = weight;
    }

    public void info() {
        String out = "Изготовитель: " + producer + ", год выпуска: " + year + ", длина: " + length
                + ", вес: " + weight + ", кол-во топлива в баке: " + fuel;
        System.out.println(out);
    }

    public void fillUp(double fuel_up) {
        fuel += fuel_up;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    static public void compareAirplanes (Airplane air1, Airplane air2) {
        Airplane tmp = air1.length > air2.length ? air1 : air2;
        System.out.println("Самолет марки " + tmp.producer + " длиннее");
    }
}
