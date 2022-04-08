package Day4;

import java.util.Arrays;
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

    public static void solution_2() {
        final int SIZE_ARRAY = 100;
        int [] mas = new int [SIZE_ARRAY];
        Random rand = new Random();
        for (int i = 0; i < SIZE_ARRAY; ++i) {
            mas[i] = rand.nextInt(10000);
            if (i % 10 == 0) System.out.println("");
            System.out.print(mas[i] + " ");
        }
        System.out.println("");
        int max = 0, min = 10000, end0 = 0, sum = 0;
        for (int i : mas) {
            min = Math.min(i, min);
            max = Math.max(i, max);
            if (i % 10 == 0) {
                end0++;
                sum+= i;
            }
        }
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
        System.out.println("count_end0 = " + end0);
        System.out.println("Sum_end0 = " + sum);
    }

    public static void solution_3() {
        final int nRow = 12;
        final int nColumn = 8;
        Random rand = new Random();
        int [] sum = new int[nRow];

        int [][] matrix = new int [nRow][nColumn];
        for (int i = 0; i < nRow; i++) {
            sum[i] = 0;
            for (int j = 0; j < nColumn; j++) {
                matrix[i][j] = rand.nextInt(50);
                sum[i] += matrix[i][j];
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("Sum = " + sum[i]);
        }
        int max_sum = 0;
        int index_max = 0;
        for (int i = 0; i < sum.length; ++i) {
            if (sum[i] >= max_sum) {
                max_sum = sum[i];
                index_max = i;
            }
        }
        System.out.println("Index Max Sum = " + index_max);

    }

    public static void solution_4() {
        final int SIZE = 10;
        int [] mas = new int[SIZE];
        Random rand = new Random();
        int index_max = 0;
        int max = 0;

        System.out.print("[ ");
        for (int i = 0; i < SIZE; i++) {
            mas[i] = rand.nextInt(10000);
            System.out.print(mas[i] + " ");
        }
        System.out.println("]");

        for (int i = 0; i < SIZE - 2; i++) {
            int sum = mas[i] + mas[i + 1] + mas[i + 2];
            if (sum > max) {
                max = sum;
                index_max = i;
            }
        }
        System.out.println("Max Sum3 = " + max);
        System.out.println("Index = " + index_max);

    }
}
