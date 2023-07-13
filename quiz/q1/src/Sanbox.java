public class Sanbox {
    public static void main(String[] args) {
//        int result = factorialR(10);
//        System.out.println("fib = " + result);
        int result = sumDigits(100);
        System.out.println("result = " + result);
    }

    private static int factorialR(int n) {
        if(n == 1) return 1;
        else return n * factorialR(n - 1);
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            System.out.println("n=" + n + ", sum="+sum);
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}