package Day10;

public class Day10 {

    public static void solution() {
        BinaryTree tree = new BinaryTree();
        tree.add(3);
        tree.add(14);
        tree.add(11);
        tree.add(23);
        tree.add(2);
        tree.add(27);
        tree.add(12);
        tree.add(15);
        tree.add(18);
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(150);

        int [] values = {1, 19, 50, 36};
        tree.add(values);
        tree.PrintFromLessToMore();
    }
}
