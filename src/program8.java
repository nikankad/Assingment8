import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * The program demonstrates the usage of an AVL tree to store and search SaleRecord objects.
 * It reads data from two CSV files, constructs SaleRecord objects, and inserts them into the AVL tree.
 * Subsequently, it performs searches based on data from another CSV file and prints the corresponding records found.
 * The program structure is as follows:
 * 1. Initialize an AVL tree.
 * 2. Create an ArrayList to store lines from the test.csv file.
 * 3. Read entries from the test.csv file and add them to the searchLines ArrayList.
 * 4. Read entries from the small_sample.csv file, construct SaleRecord objects, and insert them into the AVL tree.
 * 5. Perform searches based on data from the test.csv file, print the results.
 * Note: The CSV file paths and data assumptions are specified in the code comments.
 *
 * @author Nikan Kadkhodazadeh
 * @version 1.0
 */

public class program8 {
    static String line;


    public static void main(String[] args) throws ParseException {

        AVL tree = new AVL();


        //java terminal arguments
        String filePath = args[0];
        String testFile = args[1];


        ArrayList<String> searchLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(testFile))) {
            br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {
                // Assuming the order of columns in the CSV matches the constructor
                searchLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        insert(tree, filePath, testFile);
        search(searchLines, tree);

    }


    public static void insert(AVL tree, String csvFileA, String csvFileB) {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileA))) {
            br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming the order of columns in the CSV matches the constructor
                final SaleRecord saleRecord = new SaleRecord(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]));

                // Insert the SaleRecord into the corresponding AVL tree based on Car Make
                tree.root = tree.insertNode(saleRecord, tree.root);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static void search(ArrayList<String> searchLines, AVL tree) throws ParseException {
        // Perform searches and print results based on data from test.csv
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"))) {
            // Write the header
            writer.write("Date, Car Make, Frequency");
            writer.newLine();

            // Write data lines
            for (String Line : searchLines) {
                String[] data = Line.split(",");

                String carDate = data[0];
                String carMake = data[1];

                String frequency = String.valueOf(tree.searchNode(tree.root, data[1], data[0]));
                // Assuming each line in the list is a CSV line with attributes in order
                writer.write(carDate + ",");
                writer.write(carMake + ",");
                writer.write(frequency);

                writer.newLine();

            }

            System.out.println("Data has been written to the CSV file: " + "output.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}