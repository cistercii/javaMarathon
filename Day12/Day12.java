package Day12;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day12 {
    static public void solution_1() {
        String [] names_auto = {"BMW", "Renaut", "Mersedes", "Ferari", "Audi"};
        List<String> list = new ArrayList<>(Arrays.asList(names_auto));
        printList(list);
        System.out.println("");
        list.add(2, "Opel");
        list.remove(0);
        printList(list);
    }

    static public void solution_2() {
        List<Integer> list = new ArrayList<>();
        int COUNT_ITERATION = 350;
        for (int i = 0; i <= COUNT_ITERATION; i++) {
            if (i % 2 == 0) {
                if (i <= 30 || (i >= 300 && i <= COUNT_ITERATION)) {
                    list.add(Integer.valueOf(i));
                }
            }
        }
        printList(list);
    }

    static private <T> void  printList (@NotNull List<T> list) {
        for (T str : list) {
            System.out.println(str + " ");
        }
    }


}
