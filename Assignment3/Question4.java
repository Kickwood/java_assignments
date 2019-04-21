import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question4 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Calculate the bill based on satisfaction rate.");
        System.out.println("[3 = \"totally satisfied\", 2 = \"just satisfied\", 3 = \"unsatisfied\"]");
        System.out.println("(any other number will be considered as \"totally unsatisfied\")");
        System.out.println("The entered rate will determine the tip percentage.");

        System.out.print("Enter bill: ");
        double bill = in.nextDouble();

        System.out.print("Enter satisfaction rate (considering the above-mentioned): ");
        int satisfaction = in.nextInt();

        switch (satisfaction) {
            case 3:
                bill *= 1.2;
                break;
            case 2:
                bill *= 1.15;
                break;
            case 1:
                bill *= 1.1;
                break;
        }

        System.out.printf("Bill: EUR %.2f", bill);

        in.close();
    }

}
