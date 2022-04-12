package Day6;

import java.util.Random;

public class Teacher {

    private final String name;
    private final String lesson;

    public Teacher(String name, String lesson) {
        this.name = name;
        this.lesson = lesson;
    }

    public void evaluate (Student student) {
        Random rand = new Random();
        Evalution ev = Evalution.values()[rand.nextInt(4)];
        System.out.println("Преподаватель " + getName() + " оценил студента с именем " + student.getName()
                            + " по предмету " + getLesson() + " на оценку " + ev);
    }

    public String getName() {
        return name;
    }

    public String getLesson() {
        return lesson;
    }

    private enum Evalution {
        Unsatisfactory,
        Satisfactory,
        Nicely,
        Excellent;

        private String [] evalution = {"Неудовлетворительно", "Удовлетворительно", "Хорошо", "Отлично"};

        @Override
        public String toString() {
            return evalution[ordinal()];
        }
    };
}
