package Day11;

public class Picker implements Worker {

    private int salary = 0;
    private final Warehouse house;

    public Picker(Warehouse house) {
        this.house = house;
    }

    @Override
    public void doWork() {
        salary += 80;
        house.incCountOrders();
    }

    @Override
    public void bonus() {
        salary *= 3;
    }

    @Override
    public String toString() {
        return "Picker{" +
                "salary=" + salary +
                '}';
    }
}
