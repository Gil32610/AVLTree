public class AVLTree extends BinarySearchTreeRecursive {
    private Node root;

    @Override
     Node insertNode(int number, Node node) {
        node = super.insertNode(number, node);

        updateHeight(node);

        return rebalance(node);
    }

    // private rebalance

    private int balanceFactor(Node node) {
        return (height(node.getRight()) - height(node.getLeft()));
    }

    private int height(Node node) {
        return node == null ? -1 : node.getHeight();
    }

    private void updateHeight(Node node) {
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        node.setHeight(max(leftHeight, rightHeight)+1);
    }

    private int max(int num1, int num2) {
        return num1 < num2 ? num2 : num1;
    }

    private Node rebalance(Node node){
        int balanceFactor = balanceFactor(node);

        if(balanceFactor>1){
            if(balanceFactor(node.getRight()) <0){
                node.setRight(leftRotation(node.getRight()));
            } 
            node = rightRotation(node);
        }
        if(balanceFactor<-1){
            if(balanceFactor(node.getLeft()) >0){
                    node.setLeft(rightRotation(node.getLeft()));
            }
            node = leftRotation(node);
        }
        return node;
    }

    private Node rightRotation(Node node) {
       Node x = node.getRight();
       node.setRight(x.getLeft());
       x.setLeft(node);


        updateHeight(node);
        updateHeight(x);

        return x;
    }

    private Node leftRotation(Node node) {
        Node x = node.getLeft();
        node.setLeft(x.getRight());
        x.setRight(node);
        

        updateHeight(node);
        updateHeight(x);

        return x;
    }
   
    @Override
    Node deleteNode(Node node, int number){
        super.deleteNode(node, number);

        updateHeight(node);

        return rebalance(node);
    }
}
