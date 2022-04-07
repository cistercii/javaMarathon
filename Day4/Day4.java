package Day4;

import java.util.Random;
import java.util.Scanner;

public class Day4 {

    public static void solution_1() {
        Scanner scan = new Scanner(System.in);
        final int SIZE = scan.nextInt();
        int [] mas = new int[SIZE];
        Random rand = new Random();
        int count_over8 = 0, count1 = 0, count_even = 0, count_uneven = 0, sum = 0;
        for (int i = 0; i < SIZE; i++) {
            mas[i] = rand.nextInt(11);
        }
        System.out.print("[");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(mas[i]);
            sum += mas[i];
            if (mas[i] > 8) count_over8++;
            if (mas[i] == 1) count1++;
            if (mas[i] % 2 == 0) count_even++;
            else count_uneven++;
            if (i != SIZE - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        System.out.println("SIZE = " + SIZE);
        System.out.println("Количество чисел больше 8 - " + count_over8);
        System.out.println("Количество чисел равных 1 - " + count1);
        System.out.println("Количество четных чисел - " + count_even);
        System.out.println("Количество нечетных чисел - " + count_uneven);
        System.out.println("Сумма чисел - " + sum);
    }
}
