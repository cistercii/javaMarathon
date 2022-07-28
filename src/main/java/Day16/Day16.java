package Day16;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Day16 {
    public static void solution_1() {
        String filename = "Day14/File.txt";
        File file = new File(filename);
        printResult1(file);
    }

    public static void printResult1(File file) {
        try (Scanner scan = new Scanner(file)) {
            int sum = 0, count_number = 0;
            while (scan.hasNextInt()) {
                sum += scan.nextInt();
                count_number++;
            }
            double mean = (double) sum / count_number;
            System.out.print(mean + " --> ");
            System.out.printf("%.3f\n", mean);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void solution_2() {
        String filename1 = "Day16/file1.txt";
        String filename2 = "Day16/file2.txt";
        try (Writer writer1 = new FileWriter(filename1); Writer writer2 = new FileWriter(filename2)) {
            Random random = new Random();
            final int COUNT_NUMBERS = 100;
            final int MAX_NUMBER = 100;
            final int COUNT_IN_GROUP = 20;
            int sumInGroup = 0;
            for (int i = 0, j = i; i < COUNT_NUMBERS; i++) {
                int intTmp = random.nextInt(MAX_NUMBER);
                sumInGroup += intTmp;
                writer1.write(intTmp + " ");
                if (j == COUNT_IN_GROUP - 1) {
                    double mean = (double)sumInGroup / COUNT_IN_GROUP;
                    writer2.write(mean + " ");
                    sumInGroup = 0;
                    j = 0;
                } else {
                    j++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(filename2);
        printResult2(file);
    }

    public static void printResult2(File file) {
        try (Scanner scanner = new Scanner(file)) {
            double sum = 0.0;
            String [] numbers = new String [0];
            if (scanner.hasNextLine()) {
                numbers = scanner.nextLine().split(" ");
            }
            for(String str : numbers) {
                sum += Double.parseDouble(str);
            }
            System.out.println(sum);
            System.out.println((int)sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
