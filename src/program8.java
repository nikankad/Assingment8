import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class program8 {
    public static void main(String[] args) throws ParseException {

        AVL tree = new AVL();


        ArrayList<String> searchLines = new ArrayList<>();


        String csvFileA = "src/small_sample.csv"; // Path to your CSV file
        String csvFileB = "src/test.csv"; // Path to your CSV file

        String line;


        // read the test.csv entries (read it and automatically put it in the new csv file

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileB))) {
            br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {
                // Assuming the order of columns in the CSV matches the constructor
                searchLines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String checkData = null;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileA))) {
            br.readLine(); // Skip the header row

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                checkData = data[3] + "," + data[0];
                // Assuming the order of columns in the CSV matches the constructor
                final SaleRecord saleRecord = new SaleRecord(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]), Double.parseDouble(data[7]), Double.parseDouble(data[8]));

                // Insert the SaleRecord into the corresponding AVL tree based on Car Make
                tree.root = tree.insertNode(saleRecord, tree.root);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        tree.preOrder(tree.root);
//        System.out.println(checkData);


    }
}