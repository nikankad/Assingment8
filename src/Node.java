/**
 * A node in a binary tree, containing an <code>int</code> data.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class Node {

    // also called "value" in a binary tree
    // also called "key" in a binary search tree
    SaleRecord data;

    Node left;
    Node right;

    int count;
    int height; // used in AVL tree

    /**
     * Constructs a new node with the given data.
     *
     * @param data the data to store in the node
     */
    public Node(SaleRecord data) {
        this.data = data;
        this.count = 1;
    }

    public SaleRecord getData() {
        return data;
    }
}
