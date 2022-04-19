package Day12;

import Day12.Task3.MusicArtist;
import Day12.Task3.MusicBand;
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

    static public void solution_3() {
        List<MusicBand> list = new ArrayList<>();
        list.add(new MusicBand("Йорш", 2006));
        list.add(new MusicBand("Limp Bizkit", 1994));
        list.add(new MusicBand("Порнофильмы", 2008));
        list.add(new MusicBand("System of a down", 1992));
        list.add(new MusicBand("njdch", 1995));
        list.add(new MusicBand("sbhcbhcw", 2010));
        list.add(new MusicBand("quwncnw", 2001));
        list.add(new MusicBand("jcsnajcnjnw", 2000));
        printList(list);
        System.out.println("");
        List<MusicBand> new_list = MusicBand.groupAfter2000(list);
        printList(new_list);
    }

    static public void solution_4_5() {
        MusicBand musicBand = new MusicBand("asjncsacn", 2001);
        musicBand.addMember(new MusicArtist("Harry", 20));
        musicBand.addMember(new MusicArtist("Bob", 19));
        musicBand.addMember(new MusicArtist("Bill", 29));
        musicBand.printMembers();

        MusicBand musicBand_second = new MusicBand("cnjajcn", 1996);
        musicBand_second.addMember(new MusicArtist("Timmy", 23));
        musicBand_second.addMember(new MusicArtist("Ken", 30));

        MusicBand.transferMembers(musicBand_second, musicBand);
        musicBand.printMembers();
    }

    static private <T> void  printList (@NotNull List<T> list) {
        for (T str : list) {
            System.out.println(str + " ");
        }
    }


}
