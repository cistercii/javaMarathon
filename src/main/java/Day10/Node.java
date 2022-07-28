package Day10;

public class Node {
    private int value = 0;
    private Node right = null;
    private Node left = null;

    public void add (int value) {
        if (this.value != 0) {
            if (value <= this.value) {
                if (left == null) left = new Node();
                left.add(value);
            }
            else {
                if (right == null) right = new Node();
                right.add(value);
            }
        } else {
            this.value = value;
        }
    }

    public void printFromLessToMore() {
        if (left != null) {
            left.printFromLessToMore();
        }

        System.out.println(value);

        if (right != null) {
            right.printFromLessToMore();
        }
    }
}
