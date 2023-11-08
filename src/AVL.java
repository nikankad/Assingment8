import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AVL {

    Node root;

    int height(Node node) {
        if (node == null) return 0;
        return node.height;
    }

    /**
     * Utility method to get the maximum of two integers.
     *
     * @param a the first integer.
     * @param b the second integer.
     * @return the maximum of the two integers.
     */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        int balance = node.left.height - node.right.height;
        return balance;
    }

    /**
     * Compares two date strings and returns true if the first date is earlier than
     * the second date.
     *
     * @param a the first date string.`
     * @param b the second date string.
     * @return true if the first date is earlier than the second date, false
     * otherwise.
     * @throws ParseException if the input strings are not in the correct date
     *                        format.
     */
    public boolean compare(String a, String b) throws ParseException {

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = dateFormat.parse(a);
            Date date2 = dateFormat.parse(b);

            if (date1.before(date2)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the exception if the input strings are not in the correct format
            return false;
        }
    }

    private void updateHeight(Node node) {
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = max(leftChildHeight, rightChildHeight) + 1;
    }

    Node leftRotate(Node node) {
        Node rightChild = node.right;
        Node T2 = rightChild.left;
        rightChild.left = node;
        node.right = T2;
        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    Node rightRotate(Node node) {
        Node leftChild = node.left;
        Node T2 = leftChild.right;
        leftChild.right = node;
        node.left = T2;
        updateHeight(node);
        updateHeight(leftChild);
        return leftChild;
    }

    protected Node insert(Node node, SaleRecord data) throws ParseException {

        /* 1. Perform the normal BST insertion */
        if (node == null) {
            return (new Node(data));
        }
        // compare method not working right here, list of dates is not sorted (may have
        // something to do with program8 class)

        String nodeData = node.data.getDate();
        String keyData = data.getDate();

        if (compare(nodeData, keyData)) {
            node.left = insert(node.left, data);
        } else if (!compare(nodeData, keyData)) {
            node.right = insert(node.right, data);
        } else { // Duplicate keys not allowed
            return node;
        }
        updateHeight(node);

//        if (getBalance(node)) {

        if (compare(data.getDate(), node.left.data.getDate())) {
            return rightRotate(node);
        } else if (compare(node.left.data.getDate(), data.getDate())) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (compare(data.getDate(), node.right.data.getDate())) {
            return leftRotate(node);
        } else if (compare(node.right.data.getDate(), data.getDate())) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
//        }
        return node;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data.toString() + " ");
            preOrder(node.left);
            preOrder(node);
        }
    }

}
