import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;



public class AutocompleteTests {
    @Test
    public void emptyDict() {
        Autocomplete z = new Autocomplete();
        List input = z.finish("");
        List expected = new ArrayList();

        assertEquals(input, expected);
    }

    @Test
    public void oneChar() {
        Autocomplete z = new Autocomplete();
        z.place("hello");
        z.place("high");
        z.place("seattle");
        z.place("seatac");
        z.place("see");
        z.place("hollow");
        z.place("how");
        z.place("hell");


        List input = z.finish("h");
        List expected = new ArrayList();
        expected.add("hell");
        expected.add("hello");
        expected.add("high");
        expected.add("hollow");
        expected.add("how");

        assertEquals(expected, input);
    }

    @Test
    public void twoChar() {
        Autocomplete z = new Autocomplete();
        z.place("hello");
        z.place("high");
        z.place("seattle");
        z.place("seatac");
        z.place("see");
        z.place("hollow");
        z.place("how");
        z.place("hell");

        List input = z.finish("se");
        List expected = new ArrayList();
        expected.add("seattle");
        expected.add("seatac");
        expected.add("see");

        assertEquals(expected, input);
    }

    @Test
    public void threeChar() {
        Autocomplete z = new Autocomplete();
        z.place("hello");
        z.place("high");
        z.place("seattle");
        z.place("seatac");
        z.place("see");
        z.place("hollow");
        z.place("how");
        z.place("hell");


        List input = z.finish("sea");
        List expected = new ArrayList();
        expected.add("seattle");
        expected.add("seatac");


        assertEquals(expected, input);
    }

    @Test
    public void fiveChar() {
        Autocomplete z = new Autocomplete();
        z.place("hello");
        z.place("high");
        z.place("seattle");
        z.place("seatac");
        z.place("see");
        z.place("hollow");
        z.place("how");
        z.place("hell");


        List input = z.finish("seatt");
        List expected = new ArrayList();
        expected.add("seattle");



        assertEquals(expected, input);
    }
}
