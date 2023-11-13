import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A recursive binary search tree implementation with <code>int</code> keys.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class BinarySearchTreeRecursive extends BaseBinaryTree implements BinarySearchTree {


//    public int searchSaleRecords(String carMake, String date) {
//        int count = 0;
//
//        for (SaleRecord saleRecord : saleRecords) {
//            if (saleRecord.getMake().equalsIgnoreCase(carMake) && saleRecord.getDate().equalsIgnoreCase(date)) {
//                count++;
//            }
//        }
//
//        return count;
//    }

    public boolean compare(String a, String b) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(a);
        Date d2 = sdf.parse(b);

        return d1.compareTo(d2) <= 0;

    }

    @Override
    public void insertNode(SaleRecord key) throws ParseException {
        root = insertNode(key, root);
    }

    Node insertNode(SaleRecord key, Node node) throws ParseException {
        // No node at current position --> store new node at current position
        if (node == null) {
            node = new Node(key);
        }

        // Otherwise, traverse the tree to the left or right depending on the key
        else if (compare(key.getDate(), node.data.getDate())) {
            node.left = insertNode(key, node.left);
        } else if (!compare(key.getDate(), node.data.getDate())) {
            node.right = insertNode(key, node.right);
        } else {
            node.left = insertNode(key, node.left);
        }

        return node;
    }

    // @Override
    // public void deleteNode(int key) {
    // root = deleteNode(key, root);
    // }
    //
    // Node deleteNode(int key, Node node) {
    // // No node at current position --> go up the recursion
    // if (node == null) {
    // return null;
    // }
    //
    // // Traverse the tree to the left or right depending on the key
    // if (key < node.data) {
    // node.left = deleteNode(key, node.left);
    // } else if (key > node.data) {
    // node.right = deleteNode(key, node.right);
    // }
    //
    // // At this point, "node" is the node to be deleted
    //
    // // Node has no children --> just delete it
    // else if (node.left == null && node.right == null) {
    // node = null;
    // }
    //
    // // Node has only one child --> replace node by its single child
    // else if (node.left == null) {
    // node = node.right;
    // } else if (node.right == null) {
    // node = node.left;
    // }
    //
    // // Node has two children
    // else {
    // deleteNodeWithTwoChildren(node);
    // }
    //
    // return node;
    // }
    //
    // private void deleteNodeWithTwoChildren(Node node) {
    // // Find minimum node of right subtree ("inorder successor" of current node)
    // Node inOrderSuccessor = findMinimum(node.right);
    //
    // // Copy inorder successor's data to current node
    // node.data = inOrderSuccessor.data;
    //
    // // Delete inorder successor recursively
    // node.right = deleteNode(inOrderSuccessor.data, node.right);
    // }
    //
    // /***
    // *
    // * @param node
    // * @return node
    // */
    // private Node findMinimum(Node node) {
    // while (node.left != null) {
    // node = node.left;
    // }
    // return node;
    // }

    public int search(String carMake, String date) {
        return search(root, carMake, date);
    }

    private int search(Node node, String carMake, String date) {
        if (node == null) {
            return 0;
        }

        SaleRecord target = node.data;
        int compareResult = target.compareTo(node.data);

        if (compareResult == 0) {
            return 1 + search(node.left, carMake, date) + search(node.right, carMake, date);
        } else if (compareResult < 0) {
            return search(node.left, carMake, date);
        } else {
            return search(node.right, carMake, date);
        }
    }
}
