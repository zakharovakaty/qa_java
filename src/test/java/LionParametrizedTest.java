import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionParametrizedTest {

    private final String sex;
    private final boolean expected;

    public LionParametrizedTest(String sex, boolean expected){
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] checkLionData() {
        return new Object[][] {
                { "Самец", true},
                { "Самка",false},
        };
    }

    @Test
    public void checkLionHasMane() throws Exception{
        Lion lion = new Lion(sex);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }


    @Test
    public void checkLionException() {
        try {
         new Lion("");
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        }
    }

}
