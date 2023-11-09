import java.text.ParseException;

public class program8 {
    public static void main(String[] args) throws ParseException {

        AVL tree = new AVL();

        SaleRecord saleRecord1 = new SaleRecord("2023-11-01", "John Doe", "Alice Johnson", "Toyota", "Camry", 2022, 25000.0, 0.1, 2500.0);
        SaleRecord saleRecord2 = new SaleRecord("2023-11-02", "Jane Smith", "Bob Brown", "Ford", "Mustang", 2023, 30000.0, 0.08, 2400.0);
        SaleRecord saleRecord3 = new SaleRecord("2023-11-03", "David Clark", "Eva Wilson", "Honda", "Civic", 2021, 20000.0, 0.12, 2400.0);
        SaleRecord saleRecord4 = new SaleRecord("2023-11-04", "Linda Lee", "Michael Turner", "Chevrolet", "Malibu", 2020, 18000.0, 0.15, 2700.0);
        SaleRecord saleRecord5 = new SaleRecord("2023-11-05", "Richard Johnson", "Sarah Adams", "Nissan", "Altima", 2019, 16000.0, 0.14, 2240.0);

        SaleRecord[] arr = {saleRecord1, saleRecord2, saleRecord3, saleRecord4, saleRecord5};


        for (SaleRecord saleRecord : arr) {
            tree.root = tree.insertNode(saleRecord, tree.root);
        }

        tree.preOrder(tree.root);
    }
}