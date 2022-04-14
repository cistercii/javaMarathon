package Day10;

public class BinaryTree {

    private final Node root = new Node();
    private int count = 0;

    public void add (int value) {
        root.add(value);
        count++;
    }

    public void add (int [] values) {
        for (int value : values) {
            add(value);
        }
    }

    public void printCount() {
        System.out.println("Количество элементов: " + count);
    }

    public void PrintFromLessToMore() {
        printCount();
        root.printFromLessToMore();
    }

}
