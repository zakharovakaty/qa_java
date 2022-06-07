import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

    @RunWith(Parameterized.class)
    public class AnimalTest {
        Animal animal = new Animal();
        private final String animalKind;
        private final List<String> expected;

        public AnimalTest(String animalKind, List<String> expected){
            this.animalKind = animalKind;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Object[][] getFoodData() {
            return new Object[][] {
                    {"Травоядное", Arrays.asList("Трава", "Различные растения")},
                    {"Хищник", Arrays.asList("Животные", "Птицы", "Рыба")},
            };
        }

    @Test
    public void checkGetFood() throws Exception{
        List<String> actual = animal.getFood(animalKind);
                assertEquals(expected, actual);
    }

    @Test
    public void checkGetFoodException() {
        try {
            animal.getFood("");
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }

    @Test
    public void checkGetFamily(){
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }
}
