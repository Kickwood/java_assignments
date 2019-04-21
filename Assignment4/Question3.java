import java.util.*;

/**
 * @author Christopher
 */
public class Question3 {

    /**
     * The collection of outcomes.
     */
    private List<Integer> results;

    /**
     * Initialize the Question3 class.
     */
    public Question3() {
        results = new ArrayList<>();
    }

    /**
     * Add a new random integer to the array.
     */
    public void throwDice() {
        results.add(random());
    }

    /**
     * Generate a random integer between 1 and 6.
     * 
     * @return random int between 1 and 6
     */
    private int random() {
        return (int) (Math.random() * 6 + 1);
    }

    /**
     * Return a specific result.
     * 
     * @param index an int specifying the index
     * @return the value of the given index
     */
    public int get(int index) {
        return results.get(index);
    }

    /**
     * Return the result before the last result.
     * 
     * @return the second last element in the list
     */
    public int previous() {
        return get(size() - 2);
    }

    /**
     * Return the last result.
     * 
     * @return the last element in the list
     */
    public int last() {
        return get(size() - 1);
    }

    /**
     * Return the array size.
     * 
     * @return the size of the list
     */
    public int size() {
        return results.size();
    }

    /**
     * Get the results.
     * 
     * @return a list containing the results
     */
    public List<Integer> results() {
        return results;
    }

    /**
     * Convert the results array to a string.
     */
    @Override
    public String toString() {
        String result = "";

        for (int number : results) {
            result += number;
        }

        return result;
    }

    class Winner {		

        /**
         * The collection of players.
         */
        private List<Player> players;

        /**
         * The winning player.
         */
        private Player winner;

        /**
         * Initialize the winner class.
         */
        public Winner() {
            players = new ArrayList<>();

            // Create the default players
            players.add(new Player("Jeroen", true, true));
            players.add(new Player("Gerard", false, true));
            players.add(new Player("Rene", true, false));
            players.add(new Player("Yutao", false, false));
        }

        /**
         * Return the object of the winning player.
         * 
         * @return the instance of the player that won
         */
        public Player getWinner() {
            for (Player player : players) {
                if (player.evenRolls == isEvenRolls() && player.evenResult == isEvenResult()) {
                    winner = player;
                }
            }

            return winner;
        }

        /**
         * Check whether the final result has an even number of rolls.
         * 
         * @return <code>true</code> if even; <code>false</code> if uneven
         */
        private boolean isEvenRolls() {
            return Question3.this.size() % 2 == 0;
        }

        /**
         * Check whether the last two results are even numbers.
         * 
         * @return <code>true</code> if even; <code>false</code> if uneven
         */
        private boolean isEvenResult() {
            return Question3.this.last() % 2 == 0;
        }

        private class Player {

            /**
             * The player's name.
             */
            public String name;

            /**
             * Whether the player wins with an even amount of rolls.
             */
            public boolean evenRolls;

            /**
             * Whether the player wins with the last numbers being even.
             */
            public boolean evenResult;

            /**
             * Initialize the player class.
             * 
             * @param name the name of the player
             * @param evenRolls whether the player wins with an even amount of rolls
             * @param evenResult whether the player wins with the last numbers being even
             */
            public Player(String name, boolean evenRolls, boolean evenResult) {
                this.name = name;
                this.evenRolls = evenRolls;
                this.evenResult = evenResult;
            }

        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Integer> outcomes =  new HashMap<>();

        // Run the simulation 10000 times
        for (int i = 1; i <= 10000; i++) {
            Question3 simulation = new Question3();

            simulation.throwDice();
            simulation.throwDice();

            while (simulation.last() != simulation.previous()) {
                simulation.throwDice();
            }

            Question3.Winner winner = simulation.new Winner();

            String name = winner.getWinner().name;

            // If the outcome doesn't exist yet, create it.
            if (!outcomes.containsKey(name)) outcomes.put(name, 0);

            outcomes.put(name, outcomes.get(name) + 1);

            System.out.println(i + " : " + simulation + " " + name + " wins");			
        }

        for (Map.Entry<String, Integer> outcome : outcomes.entrySet()) {
            System.out.println(outcome.getKey() + " wins " + outcome.getValue() + " times");
        }
    }

}
