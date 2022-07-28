package Day18;

import org.jetbrains.annotations.NotNull;

public class Day18 {

    public static void solution_1() {
        int [] test = {1, 2, 3, 5};
        int result = recursionSum(test);
        System.out.println(result);
    }

    public static void solution_2() {
        long number = 12974387723L;
        System.out.println(count7(number));
    }

    public static int recursionSum(int @NotNull [] mas, int point_number) {
        if (point_number == mas.length) return 0;
        return mas[point_number] + recursionSum(mas, ++point_number);
    }

    public static int recursionSum(int [] mas) {
        return recursionSum(mas, 0);
    }

    static final int DESIRED_NUMBER = 7;

    public static int count7(long number) {
        if (number == 0) return 0;
        return (number % 10 == DESIRED_NUMBER) ? 1 + count7(number / 10) : count7(number / 10);
    }
}
