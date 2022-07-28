package Day5;

public class Motorbike {

    private final String color;
    private final int year;
    private final String model;

    public Motorbike(String color, int year, String model) {
        this.color = color;
        this.year = year;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public void info() {
        System.out.println("Это мотоцикл");
    }

    public int yearDifference (int year_diff) {
        return year_diff - this.year;
    }
}
