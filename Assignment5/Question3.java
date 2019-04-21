import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Christopher
 */
public class Question3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        // Since we MAY have duplicates, i.e. we're not required to
        List<Integer> list = Arrays.asList(numbers);

        Collections.shuffle(list);

        list.forEach(System.out::println);
    }

}
