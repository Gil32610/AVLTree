public class BinarySearchTreeRecursive{
    private Node root;

    public void insertNode(int number){
        root = insertNode(number, root);
    }

    Node insertNode(int number, Node node){
        if(node == null){
            return new Node(number);
        }else if(number < node.getData()){
            node.setLeft(insertNode(number, node.getLeft()));
        }else if(number>node.getData()){
            node.setRight(insertNode(number, node.getRight()));
        }else{
            System.out.println("Repeated");
        }
        return node;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.getLeft());
        System.out.println(root);
        inOrder(root.getRight());
    }

    public void deleteNode(int number){
        root = deleteNode(root, number);
    }

    Node deleteNode(Node node, int number){
        


    }
}