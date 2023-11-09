import java.text.ParseException;

public class AVL extends BinarySearchTreeRecursive {

    @Override
    Node insertNode(SaleRecord key, Node node) throws ParseException {
        node = super.insertNode(key, node);

        updateHeight(node);

        return rebalance(node);
    }

//    @Override
//    Node deleteNode(SaleRecord key, Node node) {
//        node = super.deleteNode(key, node);
//
//        // Node is null if the tree doesn't contain the key
//        if (node == null) {
//            return null;
//        }
//
//        updateHeight(node);
//
//        return rebalance(node);
//    }

    private void updateHeight(Node node) {
        int leftChildHeight = height(node.left);
        int rightChildHeight = height(node.right);
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }


    /**
     * Performs preorder traversal of the AVL tree and prints the nodes.
     *
     * @param node the root node of the subtree to be traversed.
     */
    void preOrder(Node node) {
        if (node != null) {

            System.out.println(node.data.getDate() + " ");
            preOrder(node.left);
            preOrder(node.right);
        }

    }

    private Node rebalance(Node node) {
        int balanceFactor = balanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <= 0) {
                // Rotate right
                node = rotateRight(node);
            } else {
                // Rotate left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >= 0) {
                // Rotate left
                node = rotateLeft(node);
            } else {
                // Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private Node rotateRight(Node node) {
        Node leftChild = node.left;

        node.left = leftChild.right;
        leftChild.right = node;

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private Node rotateLeft(Node node) {
        Node rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private int balanceFactor(Node node) {
        return height(node.right) - height(node.left);
    }

    private int height(Node node) {
        return node != null ? node.height : -1;
    }

    @Override
    protected void appendNodeToString(Node node, StringBuilder builder) {
        builder
                .append(node.data)
                .append("[H=")
                .append(height(node))
                .append(", BF=")
                .append(balanceFactor(node))
                .append(']');
    }
}