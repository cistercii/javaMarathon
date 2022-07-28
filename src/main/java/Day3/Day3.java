package Day3;

import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

    static public void solution_1() {
        String [] rus = {"Москва", "Владивосток", "Ростов"};
        String [] ita = {"Рим", "Милан", "Турин"};
        String [] eng = {"Ливерпуль", "Манчестер", "Лондон"};
        String [] ger = {"Берлин", "Мюнхен", "Кёльн"};

        String [] countries = {"Россия", "Италия", "Англия", "Германия"};

        final int COUNT_CITY = rus.length;
        String stop = "Stop";

        String [][] citys = {rus, ita, eng, ger};

        Scanner scan = new Scanner(System.in);
        boolean isContinue = true;
        while (true) {
            boolean isFind = false;
            String tmp = scan.next();
            for (int i = 0; i < citys.length; i++) {
                 for (int j = 0; j < COUNT_CITY; j++) {
                     if (tmp.equals(citys[i][j])) {
                         System.out.println(countries[i]);
                         isFind = true;
                         break;
                     } else if (tmp.equals("Stop") || tmp.equals("stop")) {
                         isContinue = false;
                     }
                 }
            }
            if (isFind) continue;
            if (!isContinue) break;
            System.out.println("Неизвестная страна");
        }
    }

    static public void solution_2() {
        Scanner scan = new Scanner(System.in);
        final double eps = 1e-9;
        while (true) {
            double a = scan.nextDouble();
            double b = scan.nextDouble();
            if (Math.abs(b) < eps) break;
            System.out.println(a / b);
        }
    }

    static public void solution_3() {
        final int COUNT_ITERATION = 5;
        Scanner scan = new Scanner(System.in);
        final double eps = 1e-9;

        for (int i = 0; i < COUNT_ITERATION; i++) {
            double first = scan.nextDouble();
            double second = scan.nextDouble();
            if (Math.abs(second) < eps) {
                System.out.println("Деление на 0");
                continue;
            }
            System.out.println(first / second);
        }
    }
}
