import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class program8 {
        public static void main(String[] args) throws ParseException {

                AVL tree = new AVL();

                String csvFile = "small_sample.csv"; // Path to your CSV file
                String line;

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        br.readLine(); // Skip the header row

                        while ((line = br.readLine()) != null) {
                                String[] data = line.split(",");
                                // Assuming the order of columns in the CSV matches the constructor parameters
                                final SaleRecord saleRecord = new SaleRecord(data[0], data[1], data[2], data[3],
                                                data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]),
                                                Double.parseDouble(data[7]),
                                                Double.parseDouble(data[8]));

                                // Insert the SaleRecord into the corresponding AVL tree based on Car Make
                                tree.root = tree.insertNode(saleRecord, tree.root);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }

                SaleRecord saleRecord1 = new SaleRecord("2023-04-06", "John Doe", "Alice Johnson", "Toyota", "Camry",
                                2022, 25000.0, 0.1, 2500.0);

                tree.preOrder(tree.root);
                System.out.println(tree.searchNode(tree.root, saleRecord1.getMake(), saleRecord1.getDate()));
        }
}