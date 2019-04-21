import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Christopher
 */
public class Question1 {

    /**
     * The key used for the encryption and decryption.
     */
    public static String key;

    /**
     * The uppercased alphabet used for obfuscation.
     */
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Encrypt using a modified implementation of Caesar's encryption algorithm.
     * 
     * @param originalMessage the message that is to be encrypted
     * @return the encrypted message
     */
    public static String encrypt(String originalMessage) {
        return obfuscate(originalMessage, key);
    }

    /**
     * Decrypt the message encrypted by the {@link #encrypt} method.
     * 
     * @param encryptedMessage the message that has previously been encrypted
     * @return the original unencrypted message
     */
    public static String decrypt(String encryptedMessage) {
        String[] key = Question1.key.split("");

        StringBuilder b = new StringBuilder();

        // Make every shift negative
        for (int i = 0; i < key.length; i++) {
            b.append("-").append(key[i]);
        }

        return obfuscate(encryptedMessage, b.toString());
    }

    /**
     * Obfuscate the given text with the given key using our algorithm.
     * 
     * @param text the message that is to be encrypted
     * @param key the key that is needed with the encryption
     * @return an obfuscated string 
     */
    private static String obfuscate(String text, String key) {
        List<String> shifts = new ArrayList<>();

        Matcher m = Pattern.compile("-?[0-9]").matcher(key);

        while (m.find()) {
            shifts.add(m.group());
        }

        char[] letters = text.toUpperCase().toCharArray();

        for (int i = 0; i < letters.length; i++) {
            int index = alphabet.indexOf(letters[i]);

            int shift = Integer.valueOf(shifts.get(i));

            // Make sure the shifts stay within bound
            if (index + shift < 0)
                shift += alphabet.length();

            if (index + shift >= alphabet.length())
                shift -= alphabet.length();

            letters[i] = alphabet.charAt(index + shift);
        }

        return new String(letters);        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Type a message: ");
        String message = in.nextLine();

        System.out.print("Type a key of the same length of the message: ");
        key = in.nextLine();

        String encrypted = encrypt(message);
        System.out.println("Encrypted Message: " + encrypted);

        String decrypted = decrypt(encrypted);
        System.out.println("Decrypted Message: " + decrypted);

        in.close();
    }

}
