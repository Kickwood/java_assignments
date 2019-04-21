import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question4 {

    /**
     * Modified implementation of Caesar's encryption algorithm.
     * 
     * @param text the text that is to be encrypted
     * @param key the key that specifies the shifts
     * @return the encrypted version of the given text
     */
    public String encrypt(String text, int key) {
        String shifts = Integer.valueOf(key).toString();

        // Exit if the lengths don't match
        if (text.length() != shifts.length()) {
            throw new RuntimeException("Text and Key must be equal in length.");
        }

        char[] letters = text.toUpperCase().toCharArray();

        for (int i = 0; i < letters.length; i++) {
            int letter = (int) letters[i];

            int shift = Integer.valueOf(shifts.substring(i, i + 1));

            // Start over at A if we shift further than Z
            if (letter + shift > 90) letter -= 26;

            letters[i] = (char) (letter + shift);
        }

        return new String(letters);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = in.nextLine();

        System.out.print("Enter encryption key: ");
        int key = in.nextInt();

        Question4 encrypter = new Question4();

        try {
            String result = encrypter.encrypt(text, key);
            System.out.println(result);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        in.close();
    }

}
