import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int first = in.nextInt();

        System.out.print("Enter second integer: ");
        int second = in.nextInt();

        System.out.print("Enter third integer: ");
        int third = in.nextInt();

        System.out.print("Enter fourth integer: ");
        int fourth = in.nextInt();

        System.out.println("The maximum value is:");

        // Get the maximum value from the given inputs
        int max = Math.max(first, Math.max(second, Math.max(third, fourth)));

        System.out.println(max);

        in.close();
    }

}
