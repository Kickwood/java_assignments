import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question6 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter string: ");
        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                System.out.println(input.substring(i, j));
            }
        }

        in.close();
    }

}
