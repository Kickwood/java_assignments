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

        System.out.print("Enter string: ");
        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            for (int j = 0; i + j <= input.length(); j++) {
                String output = input.substring(j, i + j);

                // If the string is empty, skip.
                if ("".equals(output)) continue;

                System.out.println(output);
            }
        }

        System.out.println(input);

        in.close();
    }

}
