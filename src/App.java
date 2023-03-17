
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        AVLTree mYAvlTree = new AVLTree();
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.printf("Type in the %d number%n",i+1);
            mYAvlTree.insertNode(s.nextInt());
        }
        mYAvlTree.inOrder();
    }
}
