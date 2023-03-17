public class AVLTree extends BinarySearchTreeRecursive {
    private Node root;
//Utilizando herança para reaproveitar o método de inserção e remoção da BST

//sobreescreve o método de inserção podendo assim navegar por entre os nós
    @Override
     Node insertNode(int number, Node node) {
        node = super.insertNode(number, node);
        //chama o método da super classe 
        //Começando a partir da raiz, todo nó inserido terá a altura inicial =0
        // a chamada recursiva fará a altura de todos os nós envolvidos na subárvore em questão ser atualizada.
        
        updateHeight(node);
        //após atualizada, será feito o rebalanceamento utilizando o fator de balanceamento
        //com a altura de cada nó

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
