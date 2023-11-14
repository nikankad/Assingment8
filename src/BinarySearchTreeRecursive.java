import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BinarySearchTreeRecursive extends BaseBinaryTree implements BinarySearchTree {


    @Override
    public int searchNode(String carDate, String carMake) {
        return searchNode(carDate, carMake);
    }

    public int searchNode(Node node, String carDate, String carMake) throws ParseException {
        if (node == null) {
            return 0;
        }

        String check1;
        String check2;
        check1 = node.data.getDate() + "," + node.data.getMake();
        check2 = carDate + "," + carMake;

        if (check1.equals(check2)) {
            return node.count;
        } else if (compare(carDate, node.data.getDate())) {
            return searchNode(node.left, carDate, carMake);
        } else if (!compare(carDate, node.data.getDate())) {
            return searchNode(node.right, carDate, carMake);
        }
        return node.count;
    }


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

    public Node insertNode(SaleRecord key, Node node) throws ParseException {
        // No node at current position --> store new node at current position

        String check1 = null;
        String check2 = null;
        if (node != null) {

            check1 = node.data.getDate() + "," + node.data.getMake();
            check2 = key.getDate() + "," + key.getMake();
        }


        if (node == null) {
            node = new Node(key);
        }

//        String checking = key.getDate() + key.getMake()

        // Otherwise, traverse the tree to the left or right depending on the key
        else if (compare(key.getDate(), node.data.getDate())) {
            node.left = insertNode(key, node.left);
            if (check1.equals(check2)) {
                node.count++;
            }
        } else if (!compare(key.getDate(), node.data.getDate())) {

            node.right = insertNode(key, node.right);
            if (check1.equals(check2)) {
                node.count++;
            }
        } else {
            node.left = insertNode(key, node.left);
            if (check1.equals(check2)) {
                node.count++;
            }
        }

        return node;
    }


}
