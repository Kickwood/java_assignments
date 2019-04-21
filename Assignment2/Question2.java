import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question2 {

    /**
     * The price paid per minute of calling.
     */
    public static final double PRICE_MINUTE = 0.15;

    /**
     * The price paid per text sent.
     */
    public static final double PRICE_TEXT = 0.10;

    /**
     * The price per MB used.
     */
    public static final double PRICE_MB = 0.01;

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Calculate invoice amount");

        Scanner in = new Scanner(System.in);

        // Ask user for inputs
        System.out.print("Enter minutes called: ");
        int minutes = in.nextInt();

        System.out.print("Enter texts sent: ");
        int texts = in.nextInt();

        System.out.print("Enter mobile data (in MB) used: ");
        int data = in.nextInt();

        // Calculate invoice
        double invoice = (minutes * PRICE_MINUTE) + (texts * PRICE_TEXT) + (data * PRICE_MB);

        System.out.printf("Amount due: EUR %.2f", invoice);

        in.close();
    }

}
