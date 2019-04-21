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
        Question4 encrypter = new Question4();

        // Prints BCDEF
        String result = encrypter.encrypt("AAAAA", 12345);

        System.out.println(result);
    }

}
