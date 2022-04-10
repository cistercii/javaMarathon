package Day5;

public class Motorbike {

    private final String color;
    private final String year;
    private final String model;

    public Motorbike(String color, String year, String model) {
        this.color = color;
        this.year = year;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public String getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
}
