import com.example.Feline;
import com.example.Lion;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LionTest {
    Feline feline = new Feline();

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int actual = lion.getKittens();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> actual = lion.getFood();
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expected, actual);
    }
}
