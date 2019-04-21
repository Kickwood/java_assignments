import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Christopher
 */
public class Question5 {

    /**
     * Display the matrix (two-dimensional array) in a readable fashion.
     * 
     * @param header the text displayed above the matrix
     * @param arr the matrix that is to be displayed
     */
    public static void display(String header, int[][] arr) {
        System.out.println(System.lineSeparator() + header);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Get all the values surrounding the provided element in the matrix.
     * 
     * @param arr the matrix that is used
     * @param i the row of the element
     * @param j the column of the element
     * @return an ArrayList containing all the neighbours
     */
    public static List<Integer> neighbours(int[][] arr, int i, int j) {
        int rowLimit = arr.length - 1;
        int columnLimit = arr[0].length - 1;

        List<Integer> neighbours = new ArrayList<>();

        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, rowLimit); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, columnLimit); y++) {
                if (x != i || y != j) {
                    neighbours.add(arr[x][y]);
                }
            }
        }

        return neighbours;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Compute the sum of the neighbours of each element in a matrix.");

        String input = null;

        do {
            // Make sure the user enters the dimensions in the right format
            System.out.print("Enter matrix dimensions (e.g.: 3x3): ");
            input = in.nextLine();
        } while (!input.matches("\\d+(x|X)\\d+"));

        String dimensions[] = input.split("(x|X)");

        int rows = Integer.parseInt(dimensions[0]);
        int columns = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][columns];

        Random random = new Random();

        // Populate the matrix with random numbers between 1 and 100
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(100) + 1;
            }
        }

        display("The generated matrix:", matrix);

        int[][] sums = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                List<Integer> neighbours = neighbours(matrix, i, j);
                sums[i][j] = neighbours.stream().mapToInt(Integer::intValue).sum();
            }
        }

        display("The \"sums\" matrix:", sums);

        in.close();
    }

}
