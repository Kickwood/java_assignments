import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = in.nextInt();
        }

        List<Integer> evenIndex = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        int[] reversedNumbers = new int[10];

        // Since we have to do everything with a loop...
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                evenIndex.add(numbers[i]);
            }

            if (numbers[i] % 2 == 0) {
                evenNumbers.add(numbers[i]);
            }

            // Reverse the numbers array, so add the first number as the last etc.
            reversedNumbers[numbers.length - 1 - i] = numbers[i];
        }

        System.out.println("Every element at an even index: " + evenIndex.toString());
        System.out.println("Every even element: " + evenNumbers.toString());
        System.out.println("All elements in reversed order: " + Arrays.toString(reversedNumbers));
        System.out.println("Only the first and last element: First = " + numbers[0] + ", Last = " + numbers[numbers.length - 1]);

        in.close();
    }

}
