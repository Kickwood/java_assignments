import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Christopher
 */
public class Question6 {

    /**
     * The set of all available units.
     */
    private HashMap<String, Double> units;

    /**
     * Initialize the class.
     */
    public Question6() {
        units = new HashMap<>();

        // Define the available units
        units.put("g", 1.0);
        units.put("oz", 0.03527396194958);
        units.put("lb", 0.002204622621849);
        units.put("stone", 0.0001574730444178);
    }

    /**
     * Convert from one unit to another.
     * 
     * @param from the unit that we convert from
     * @param to the unit that we convert to
     * @param value the value that is to be converted
     * @return the value in the new unit
     */
    public double convert(String from, String to, double value) {
        if (!units().contains(from) || !units().contains(to)) {
            throw new IllegalArgumentException("Please enter valid units.");
        }

        return value * units.get(to) / units.get(from);
    }

    /**
     * Return all available units.
     * 
     * @return a set of all the available units
     */
    public Set<String> units() {
        return units.keySet();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Question6 converter = new Question6();

        Scanner in = new Scanner(System.in);

        System.out.println("Convert between units.");
        
        String units = String.join(", ", converter.units());
        System.out.println("Available units: [" + units + "]");

        System.out.print("Convert from? ");
        String from = in.nextLine();

        System.out.print("Convert to? ");
        String to = in.nextLine();

        System.out.print("Value? ");
        double value = in.nextDouble();

        try {
            double result = converter.convert(from, to, value);
            System.out.println("It's " + result + " " + to + ".");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        in.close();
    }

}
