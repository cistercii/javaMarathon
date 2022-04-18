package Day11;

public class Courier implements Worker {

    private int salary = 0;
    private Warehouse warehouse;

    Courier (Warehouse house) {
        this.warehouse = house;
    }

    @Override
    public void doWork() {
        salary += 100;
        warehouse.increaseBalance();
    }

    @Override
    public void bonus() {
        salary *= 2;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "salary=" + salary +
                '}';
    }
}
