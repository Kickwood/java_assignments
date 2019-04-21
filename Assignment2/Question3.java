import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question3 {

    /**
     * A constant approaching zero.
     */
    public static final double DELTA = 0.0001;

    /**
     * Approximate the derivative using the first formula.
     * 
     * @param number where we need to approximate the derivative
     * @return the approximated derivative
     */
    public static double first(double number) {
        return (Math.log(number + DELTA) - Math.log(number - DELTA)) / (2 * DELTA);
    }

    /**
     * Approximate the derivative using the second formula.
     * 
     * @param number where we need to approximate the derivative
     * @return the approximated derivative
     */
    public static double second(double number) {
        return (Math.log(number + DELTA) - Math.log(number)) / DELTA;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Ask user for number
        System.out.print("Enter number: ");
        double input = in.nextDouble();

        // Display the different answers
        System.out.println("Approximation using formula 1: " + first(input));
        System.out.println("Approximation using formula 2: " + second(input));
        System.out.println("Answer using derivative: " + (1 / input));

        in.close();
    }

}
