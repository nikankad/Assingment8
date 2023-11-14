import java.text.ParseException;

public interface BinarySearchTree extends BinaryTree {


    int searchNode(String carDate, String carMake);


//    void insertNode(SaleRecord key) throws ParseException;

    void insertNode(SaleRecord key) throws ParseException;

    /**
     * Inserts a node with the given key.
     *
     * @param key the key of the node to be inserted
     */
    Node insertNode(SaleRecord key, Node node) throws ParseException;
}

