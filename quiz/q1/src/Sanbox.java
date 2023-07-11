public class Sanbox {
    public static void main(String[] args) {
        int result = factorialR(10);
        System.out.println("fib = " + result);
    }

    private static int factorialR(int n) {
        if(n == 1) return 1;
        else return n * factorialR(n - 1);
    }
}