public class Main {
    public static void main(String[] args) {
        BinarySearchTreeRecursive tree = new BinarySearchTreeRecursive();
        tree.insertNode(8);
        tree.insertNode(12);
        tree.insertNode(4);
        tree.insertNode(10);
        tree.insertNode(9);
        tree.insertNode(11);
        tree.removeNode(10);
    }

    public static int max(int num1, int num2) {
        return num1 < num2 ? num2 : num1;
    }
}
