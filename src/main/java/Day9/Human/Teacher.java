package Day9.Human;

public class Teacher extends Human {
    private final String lesson;

    public Teacher(String name, String lesson) {
        super(name);
        this.lesson = lesson;
    }

    public String getLesson() {
        return lesson;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Это учитель с именем " + getName()
                            + " он ведет предмет под названием " + getLesson());
    }
}
