package Day11;

public class Warehouse {

    private int countOrder = 0;
    private int balance = 0;

    public void incCountOrders() {
        countOrder++;
    }

    public void increaseBalance() {
        balance += 1000;
    }

    public int getBalance() {
        return balance;
    }

    public int getCountOrder() {
        return countOrder;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "countOrder=" + countOrder +
                ", balance=" + balance +
                '}';
    }
}
