import java.text.ParseException;

/**
 * Interface for various BST implementations.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public interface BinarySearchTree extends BinaryTree {


    /**
     * Inserts a node with the given key.
     *
     * @param key the key of the node to be inserted
     */
    void insertNode(SaleRecord key) throws ParseException;

    /**
     * Deletes the node with the given key.
     *
     * @param key the key of the node to be deleted
     */
    // void deleteNode(int key);
}
