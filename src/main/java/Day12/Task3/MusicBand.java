package Day12.Task3;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {

    private final String name;
    private final int year;
    private List<MusicArtist> members = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public List<MusicArtist> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void addMember(MusicArtist new_member) {
        members.add(new_member);
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

    public void printMembers() {
        System.out.println("");
        for (MusicArtist member : members) {
            System.out.println(member.getName() + " " + member.getAge() + " age");
        }
        System.out.println("");
    }

    public static List<MusicBand> groupAfter2000(List<MusicBand> bands) {
        final int LIMIT_YEAR = 2000;
        List<MusicBand> result = new ArrayList<>();
        for (MusicBand band : bands) {
            if (band.getYear() > LIMIT_YEAR) {
                result.add(band);
            }
        }
        return result;
    }

    public static void transferMembers(MusicBand from, MusicBand to) {
        for (MusicArtist name : from.getMembers()) {
            to.addMember(name);
        }
    }
}
