/**
 * @author Christopher
 */
public class Question1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (String word = "HelloHarry"; !word.isEmpty(); word = word.substring(1)) {
            System.out.println(word.substring(0,1));
        }
    }

}
