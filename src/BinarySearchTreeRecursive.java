public class BinarySearchTreeRecursive {
    private Node root;

    public void insertNode(int number) {
        root = insertNode(number, root);
    }

    Node insertNode(int number, Node node) {
        if (node == null) {
            return new Node(number);
        } else if (number < node.getData()) {
            node.setLeft(insertNode(number, node.getLeft()));
        } else if (number > node.getData()) {
            node.setRight(insertNode(number, node.getRight()));
        } else {
            System.out.println("Repeated");
        }
        return node;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root);
        inOrder(root.getRight());
    }

    public void deleteNode(int number) {
        if (root != null) {
            root = deleteNode(root, number);
        } else
            System.out.println("Empty!");
    }

    Node deleteNode(Node node, int number) {
        if (node != null) {
            if (node.getData() == number) {
                if (node.getLeft() == null && node.getRight() == null)
                    node = null;
                else if (node.getLeft() == null)
                    node = node.getRight();
                else if (node.getRight() == null)
                    node = node.getLeft();
                else{
                    Node parent= node;
                    Node child = node.getLeft();
                    while(child.getRight() != null){
                        parent = child;
                        child = child.getRight();
                    }
                    parent.setRight(child.getLeft());
                    node.setData(child.getData());
                }
            }
        } else if (node.getData() < number) {
            node.setLeft(deleteNode(node.getLeft(), number));
        } else
            node.setRight(deleteNode(node.getRight(), number));
        return node;
    }
}