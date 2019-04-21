import java.util.InputMismatchException;
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

        System.out.println("Get min and max from a set of integers.");
        System.out.println("Start entering integers:");

        int min = in.nextInt(), max = min;

        try {
            while (in.hasNextInt()) {
                int input = in.nextInt();

                if (input < min)
                    min = input;

                if (input > max)
                    max = input;
            }
        } catch (InputMismatchException e) {}

        System.out.println("The min value entered is " + min + ".");
        System.out.println("The max value entered is " + max + ".");

        in.close();
    }

}
