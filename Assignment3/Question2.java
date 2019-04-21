import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question2 {

    /**
     * The numbers are considered equal if they are within this bound.
     */
    public static final double EPSILON = 0.001;

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Test whether two floating-point numbers are the same within a bound.");

        System.out.print("Enter first floating-point number: ");
        double number1 = in.nextDouble();

        System.out.print("Enter second floating-point number: ");
        double number2 = in.nextDouble();

        // If the absolute difference is smaller than a given small number both numbers are considered equal
        if (Math.abs(number1 - number2) < EPSILON) {
            System.out.println("YES! These numbers are considered the same.");
        } else {
            System.out.println("These numbers are NOT considered the same.");
        }

        in.close();
    }

}
