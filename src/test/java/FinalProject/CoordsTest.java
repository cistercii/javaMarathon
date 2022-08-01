package FinalProject;

import FinalProject.Exceptions.BadCoordsException;
import org.junit.Assert;
import org.junit.Test;

public class CoordsTest {
    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipEmptyLine() throws BadCoordsException {
        String example = "";
        Coords coords = new Coords(example);
    }

    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipLinesOfBadFormat1() throws BadCoordsException {
        String example1 = "АА,5";
        Coords coords = new Coords(example1);
    }

    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipLinesOfBadFormat2() throws BadCoordsException {
        String example2 = "а,12";
        Coords coords = new Coords(example2);
    }

    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipLinesOfBadFormat3() throws BadCoordsException {
        String example3 = "А,";
        Coords coords = new Coords(example3);
    }

    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipLinesOfBadFormat4() throws BadCoordsException {
        String example4 = ",5";
        Coords coords = new Coords(example4);
    }

    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipLinesOfBadFormat5() throws BadCoordsException {
        String example5 = "Б;2";
        Coords coords = new Coords(example5);
    }

    @Test(expected = BadCoordsException.class)
    public void constructorShouldSkipLinesOfBadFormat6() throws BadCoordsException {
        String example6 = "е,05";
        Coords coords = new Coords(example6);
    }

    @Test
    public void normalWorkOfConstructor() throws BadCoordsException {
        String example1 = "а,5";
        String example2 = "И,10";
        String example3 = "К,2";
        String example4 = "   з   ,  1    " ;

        Coords coords1 = new Coords(example1);
        Coords coords2 = new Coords(example2);
        Coords coords3 = new Coords(example3);
        Coords coords4 = new Coords(example4);

        Assert.assertEquals(new Coords('А', 5), coords1);
        Assert.assertEquals(new Coords('И', 10), coords2);
        Assert.assertEquals(new Coords('К', 2), coords3);
        Assert.assertEquals(new Coords('З', 1), coords4);
    }
}
