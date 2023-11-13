import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Program8 {
    public static void main(String[] args) {
        AVL tree = new AVL();

        String csvFileA = "src/small_sample.csv"; // Path to your CSV file
        String csvFileB = "src/test.csv"; // Path to your CSV file

        try (BufferedReader brA = new BufferedReader(new FileReader(csvFileA));
             BufferedReader brB = new BufferedReader(new FileReader(csvFileB))) {

            brA.readLine(); // Skip the header row in csvFileA
            brB.readLine(); // Skip the header row in csvFileB

            String lineA, lineB;

            while ((lineA = brA.readLine()) != null) {
                String[] data = lineA.split(",");
                SaleRecord saleRecord = new SaleRecord(data[0], data[1], data[2], data[3], data[4],
                        Integer.parseInt(data[5]), Double.parseDouble(data[6]),
                        Double.parseDouble(data[7]), Double.parseDouble(data[8]));

                // Insert the SaleRecord into the corresponding AVL tree based on Car Make
                tree.root = tree.insertNode(saleRecord, tree.root);
            }

            while ((lineB = brB.readLine()) != null) {
                String[] searchData = lineB.split(",");
                String carMake = searchData[0].trim();
                String date = searchData[1].trim();

                // Search for the SaleRecord directly in the AVL tree
                int numberOfSales = tree.search(carMake, date);

                System.out.println("Car Make: " + carMake + ", Date: " + date + ", Number of Sales: " + numberOfSales);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
