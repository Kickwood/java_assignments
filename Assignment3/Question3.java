import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question3 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Determine whether the given year is a leap year.");

        System.out.print("Enter year: ");
        int year = in.nextInt();

        // Determine whether the year is a leap year
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("The year " + year + " is a leap year!");
        } else {
            System.out.println("The year " + year + " is NOT a leap year.");
        }

        in.close();
    }

}
