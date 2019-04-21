import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Christopher
 */
public class Question2 {

    /**
     * An array with random integers.
     */
    private static int[] input;

    /**
     * The size of the array.
     */
    public static final int ARRAY_SIZE = 10;

    /**
     * Shuffle the given array.
     * 
     * @param array the array that needs to be shuffled
     */
    public static void shuffle(int[] array) {
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());

        Collections.shuffle(list);

        input = list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Populate an array with a length of {@value #ARRAY_SIZE} with random integers.
     * 
     * @return an array containing random integers
     */
    public static int[] create() {
        int[] input = new int[Question2.ARRAY_SIZE];

        int currentValue;

        for (int i = 0; i <= Question2.ARRAY_SIZE - 1;) {
            currentValue = (int) (Math.random() * 100 + 1);

            if (!Question2.exist(input, currentValue)) {
                input[i] = currentValue;
                i++;
            }
        }

        return input;
    }

    /**
     * Determine whether a given value already exists in an array.
     * 
     * @param haystack the array of integers
     * @param needle the given integer
     * @return <code>true</code> if it already exists; <code>false</code> otherwise
     */
    public static boolean exist(int[] haystack, int needle) {
        return Arrays.stream(haystack).anyMatch(n -> {
            return n == needle;
        });
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        input = Question2.create();

        // The original array
        System.out.println(Arrays.toString(input));

        // First shuffle
        shuffle(input);
        System.out.println(Arrays.toString(input));

        // Second shuffle
        shuffle(input);
        System.out.println(Arrays.toString(input));
    }

}
