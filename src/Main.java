public class Main {
    public static void main(String[] args) {
        System.out.println(max(12,20));
        System.out.println(max(10, 5));
        System.out.println(max(1, 1));
        System.out.println(max(-20, 10));
    }

    public static int max(int num1, int num2) {
        return num1 < num2 ? num2 : num1;
    }
}
