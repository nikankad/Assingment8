import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A recursive binary search tree implementation with <code>int</code> keys.
 *
 * @author <a href="sven@happycoders.eu">Sven Woltmann</a>
 */
public class BinarySearchTreeRecursive extends BaseBinaryTree implements BinarySearchTree {


    @Override
    public Node searchNode(int key) {
        return searchNode(key, root);
    }

    private Node searchNode(int key, Node node) {
        return null;
    }

    public boolean compare(String a, String b) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(a);
        Date d2 = sdf.parse(b);

        return d1.compareTo(d2) <= 0;

    }

//    @Override
//    public Node searchNode(Node node, String carMake, String carDate) {
//        return searchNode(carMake, carDate);
//    }
//
//    private Node searchNode(int key, Node node) {
//        if (node == null) {
//            return null;
//        }
//
//        if (key == node.data) {
//            return node;
//        } else if (key < node.data) {
//            return searchNode(key, node.left);
//        } else {
//            return searchNode(key, node.right);
//        }
//    }

    @Override
    public void insertNode(SaleRecord key) throws ParseException {
        root = insertNode(key, root);
    }

    Node insertNode(SaleRecord key, Node node) throws ParseException {
        // No node at current position --> store new node at current position

        String check1 = null;
        String check2 = null;
        if (node != null) {

            check1 = node.data.getDate() + "," + node.data.getMake();
            check2 = key.getDate() + "," + key.getMake();
        }

        System.out.println(check1);

        if (node == null) {
            node = new Node(key);
            node.count++;
            System.out.println(node.count);
        }

//        String checking = key.getDate() + key.getMake()

        // Otherwise, traverse the tree to the left or right depending on the key
        else if (compare(key.getDate(), node.data.getDate())) {
            node.left = insertNode(key, node.left);
            if (check1.equals(check2)) {
                System.out.println("PLO");
            }
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

    public int search(Node node, String carMake, String date) {
        if (node == null) {
            return 0;
        }

        String checkData = carMake + "," + date;

        String saleRecordData = node.data.getMake() + "," + node.data.getDate();

        System.out.println(checkData + " ___ " + checkData);

        SaleRecord target = node.data;
//        int compareResult = target.compareTo(node.data);

//        boolean compareResults = target.
//
//
//        if (compareResult == 0) {
//            return 1 + search(node.left, carMake, date) + search(node.right, carMake, date);
//        } else if (compareResult < 0) {
//            return search(node.left, carMake, date);
//        } else {
//            return search(node.right, carMake, date);
//        }

        return 0;
    }

    @Override
    public Node searchNode(String carMake, String carDate) {
        return null;
    }
}
