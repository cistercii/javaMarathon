package Day8;

import Day6.Airplane;

public class Day8 {
    public static void solution_1() {
        long start_time = 0, finish_time = 0, result_work_time = 0;
        final int MAX_NUMBER = 20000;
        start_time = System.nanoTime();
        String result = new String();
        for (int it = 0; it <= MAX_NUMBER; ++it) {
            result += it + " ";
        }
        System.out.println(result);
        finish_time = System.nanoTime();
        result_work_time = finish_time - start_time;
        System.out.println("Прошло " + result_work_time / 1000000. + " миллисекунд");

        start_time = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int it = 0; it <= MAX_NUMBER; ++it) {
            builder.append(it + " ");
        }
        System.out.println(builder.toString());
        finish_time = System.nanoTime();
        result_work_time = finish_time - start_time;
        System.out.println("Прошло " + result_work_time / 1000000. + " миллисекунд");
    }

    public static void solution_2() {
        Airplane airplane = new Airplane("Boeing", 2000, 150.0, 10000.0);
        System.out.println(airplane);
    }
}
