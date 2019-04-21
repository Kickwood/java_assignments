import java.util.Arrays;
import java.lang.reflect.Array;

/**
 * @author Christopher
 */
public class Question1 {

    /**
     * Merge all the provided arrays of a generic type into one big array.
     * 
     * @param type the type of the arrays
     * @param arrays the arrays that are to be merged
     * @return an array containing the values of all the provided arrays
     */
    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> T[] merge(Class<T> type, T[]... arrays) {
        int length = 0;

        for (T[] array : arrays) {
            length += array.length;
        }

        // Create a generic new array
        T[] newArray = (T[]) Array.newInstance(type, length);

        for (int i = 0; i < arrays.length; i++) {
            int destPos = 0;

            // Make sure we start at the correct position
            for (int j = 0; j < i; j++) {
                destPos += arrays[j].length;
            }

            System.arraycopy(arrays[i], 0, newArray, destPos, arrays[i].length);
        }

        return newArray;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2, 3, 4, 5 };
        Integer[] arr2 = { 6, 7, 8 };

        Integer[] result = merge(Integer.class, arr1, arr2);

        System.out.println(Arrays.toString(result));
    }

}
