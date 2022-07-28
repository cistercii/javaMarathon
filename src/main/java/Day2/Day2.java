package Day2;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Day2 {

    static public void  solution_1() {
        System.out.println("Высота здания:");
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextInt()) {
            System.out.println("Ошибка ввода");
            return;
        }
        int h = scan.nextInt();
        if (h < 1) {
            System.out.println("Ошибка ввода");
        } else {
            if (h < 5) {
                System.out.println("Малоэтажный дом");
            } else {
                if (h < 9) {
                    System.out.println("Среднеэтажный дом");
                } else {
                    System.out.println("Многоэтажный дом");
                }
            }
        }
    }

    static public void solution_2() throws IOException {
        int a = 0, b = 0;
        Scanner scan = new Scanner(System.in);
        boolean flg = false;

        do { // Проверяем поток ввода до получения числа
            System.out.println("Введите правильное начало интервала");
            flg = scan.hasNextInt();
            if (!flg) {
                String tmp = scan.next();
            }
        } while (!flg);
        a = scan.nextInt();

        do {
            System.out.println("Введите правильный конец интервала");
            flg = scan.hasNextInt();
            if (!flg) {
                String tmp = scan.next();
            }
        } while (!flg);
        b = scan.nextInt();

        if (a >= b) {
            System.out.print("Ошибка ввода");
            return;
        }

        for (int i = a + 1; i < b; i++) {
            if(i % 5 == 0 && i % 10 != 0) {
                System.out.print(i);
                System.out.print(" ");
            }
        }
    }

    static public void solution_3() throws IOException {
        int a = 0, b = 0;
        Scanner scan = new Scanner(System.in);
        boolean flg = false;

        do { // Проверяем поток ввода до получения числа
            System.out.println("Введите правильное начало интервала");
            flg = scan.hasNextInt();
            if (!flg) {
                scan.next();
            }
        } while (!flg);
        a = scan.nextInt();

        do {
            System.out.println("Введите правильный конец интервала");
            flg = scan.hasNextInt();
            if (!flg) {
                String tmp = scan.next();
            }
        } while (!flg);
        b = scan.nextInt();

        if (a >= b) {
            System.out.print("Ошибка ввода");
            return;
        }
        int it = a;
        while  (it < b) {
            if (it % 5 == 0 && it % 10 != 0) {
                System.out.print(it + " ");
            }
            it++;
        }
    }

    static public void solution_4() {
        Scanner scan = new Scanner(System.in);
        boolean flg = false;
        do { // Проверяем поток ввода до получения числа
            System.out.println("Введите X:");
            flg = scan.hasNextDouble();
            if (!flg) {
                scan.next();
            }
        } while (!flg);
        double X = scan.nextDouble();
        System.out.println("Введенное значение Х: " + X);
        double Y = 0.0;
        if (X >= 5.0) {
            Y = (Math.pow(X, 2) - 10) / (X + 7);
        } else if (X > -3.0 && X < 5.0) {
            Y = (X + 3) * (Math.pow(X, 2) - 2);
        } else Y = 420.0;
        System.out.println("Полученное значение Y: " + Y);
    }
}
