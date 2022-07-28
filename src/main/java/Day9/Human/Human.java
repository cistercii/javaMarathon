package Day9.Human;

public class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println("Это человек с именем " + getName());
    }
}
