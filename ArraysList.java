// Import libraries
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.ArrayList;

/** .
* This reads an inputted file and displays the mean, median, and mode.
* This program uses array lists, arrays, and functions to do such.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-03-25
*/

// Creating class
public final class ArraysList {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private ArraysList() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {

        // Initialize output string
        String outputStr = "";

        // Initialize size
        int size = 0;

        // Initialize array list
        ArrayList<String> numList = new ArrayList<String>();

        // Introduce program to user
        System.out.println("This calculates the mean, median, "
                + "and mode of a file");

        // Create scanner and get file name from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        String filename = sc.nextLine();
        File file = new File(filename);

        // try to read the file
        try {
            sc = new Scanner(file);

            // Populate array list
            while (sc.hasNextLine()) {

                // Assign current line to variable
                String line = sc.nextLine();

                // Populate array list
                numList.add(line);
            }

            // Get size of file
            size = numList.size();

            // Creating array based on list size
            Float[] array = new Float[size];

            // Populate array with list contents
            for (int counter = 0; counter < size; counter++) {
                array[counter] = Float.parseFloat(numList.get(counter));
            }

            // Sort array
            Arrays.sort(array);

            // Display sorted array
            for (int displayCounter = 0; displayCounter
                < size; displayCounter++) {
                System.out.println(array[displayCounter]);
            }

            // Convert size to float
            Float sizeFloat = size * 1f;

            // Call function to calculate mean
            float meanResult = calculateMean(array, sizeFloat);

            // Call function to calculate median
            float medianResult = calculateMedian(array, sizeFloat);

            // Iterate through array of strings
            for (Float num : array) {

                // Append numbers for file writing
                outputStr += num + " ";
            }

            // Add new line to output string
            outputStr += "\n";

            // Add mean to output string
            outputStr += "Mean: " + meanResult + "\n";

            // Add median to output string
            outputStr += "Median: " + medianResult + "\n";

            // Print output string
            System.out.print(outputStr);
        } catch (FileNotFoundException error) {
            System.out.println("File not found.");
        }

        // Close scanner
        sc.close();

        // Write output string to output file
        FileWriter myWriter = new FileWriter("output.txt");
        myWriter.write(outputStr);
        myWriter.close();

    }

    /**
    * This is the method for calculating mean.
    *
    * @param array
    * @param size
    * @return mean
    */

    // Declare function to calculate mean
    public static Float calculateMean(final Float[] array, final Float size) {

        // Initialize mean & sum
        float mean = 0;
        float sum = 0;

        // Calculate sum
        for (int sumCounter = 0; sumCounter < size; sumCounter++) {
            sum += array[sumCounter];
        }

        // Calculate mean
        mean = sum / size;

        // Return mean
        return mean;
    }

    /**
    * This is the method for calculating median.
    *
    * @param array
    * @param size
    * @return median
    */

    // Declare function to calculate median
    public static Float calculateMedian(final Float[] array, final Float size) {

        // Initialize variables
        float median = 0f;
        float halfSize = 0f;
        float firstNum;
        float secondNum;

        // Check if list is even or not
        if (size % 2 != 0) {
            // Get middle index number
            halfSize = size / 2;

            // Get two numbers at middle
            firstNum = halfSize - 0.5f;
            secondNum = halfSize + 0.5f;

            median = (firstNum + secondNum) / 2f;

        // Get the number at the middle of the array if even
        } else {
            halfSize = size / 2.0f;
            median = array[(int) halfSize];
        }

        // Return median
        return median;
    }

}
