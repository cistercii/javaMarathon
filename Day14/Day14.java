package Day14;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day14 {
    private final static String filename = "Day14/People.txt";

    public static void solution_1() {
        String filename_1 = "Day14/File.txt";
        File file = new File(filename);
        printSumDigits(file);
    }

    public static void printSumDigits(final File file) {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            if (list.size() != 10) {
                throw new InvalidFileException(list.size());
            }
        }
        catch (IOException e) {
            System.out.println("Файл не найден.");
            return;
        }
        catch (InvalidFileException e) {
            list.clear();
            System.out.println("Некорректный входной файл нужно 10 чисел, а в нем " + e.getCount_numbers());
            return;
        }
        int sum = 0;
        for (Integer i : list) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("Sum digits in list: " + sum);
    }

    public static void solution_2() {
        File file = new File(filename);
        List<String> list =  parseFileToStringList(file);
        if (list.size() > 0) System.out.println(Arrays.toString(list.toArray()));
    }

    public static @NotNull List<String> parseFileToStringList(final File file) {
        List<String> result = new ArrayList<>();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                result.add(scan.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден");
        }
        return result;
    }

    public static void solution_3() {
        final File file = new File(filename);
        List<Person> persons = parseFileToObjList(file);
        persons.forEach(System.out::println);
    }

    public static @NotNull List<Person> parseFileToObjList(final File file) {
        List<Person> result = new ArrayList<>();
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String name = scan.next();
                int age = scan.nextInt();
                scan.nextLine();
                if (age < 0) throw new InvalidFileException();
                result.add(new Person(name, age));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл не найден");
        }
        catch (InvalidFileException e) {
            e.printStackTrace();
            System.out.println("Некорректный входной файл");
        }
        return result;
    }


}
