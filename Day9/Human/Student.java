package Day9.Human;

public class Student extends Human {
    private final int group;

    public Student(String name, int group) {
        super(name);
        this.group = group;
    }

    public int getGroup() {
        return group;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Это студент с именем " + getName()
                            + " он учится в группе под номером " + getGroup());
    }
}
