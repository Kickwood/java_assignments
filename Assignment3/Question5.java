import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question5 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Where is the train going? ");
        int direction = in.nextInt();

        if (direction == 1) {
            System.out.println("Switching to Amsterdam");
        } else if (direction == 2) {
            System.out.println("Switching to Rotterdam");
        } else if (direction == 3) {
            System.out.println("Switching to Roosendaal");
        } else {
            System.out.println("Keep going");
        }

        in.close();
    }

}
