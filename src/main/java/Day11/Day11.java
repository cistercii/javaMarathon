package Day11;

public class Day11 {
    static public void solution() {
        Warehouse warehouse = new Warehouse();
        Warehouse second_warehouse = new Warehouse();
        Picker picker = new Picker(warehouse);
        Courier courier = new Courier(warehouse);
        boolean isBonusPicker = false, isBonusCourier = false;
        while (true) {

            picker.doWork();
            courier.doWork();
            if (warehouse.getCountOrder() % 1500 == 0) {
                picker.bonus();
                isBonusPicker = true;
            }
            if (warehouse.getBalance() % 1_000_000 == 0) {
                courier.bonus();
                isBonusCourier = true;
            }
            if (isBonusCourier && isBonusPicker) break;
        }
        System.out.println(warehouse);
        System.out.println(picker);
        System.out.println(courier);

        Picker second_picker = new Picker(second_warehouse);
        Courier second_courier = new Courier(second_warehouse);
        second_courier.doWork();
        second_picker.doWork();
        System.out.println(second_warehouse);
        System.out.println(second_picker);
        System.out.println(second_courier);

    }
}
