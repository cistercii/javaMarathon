package Day15;

public class Shoe {

    private final String name;
    private final int size;
    private final int count;

    public Shoe(String name, int size, int count) {
        this.name = name;
        this.size = size;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }
}
