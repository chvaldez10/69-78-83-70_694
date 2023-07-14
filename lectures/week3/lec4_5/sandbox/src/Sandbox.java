public class Sandbox {
    public static void main(String args[]) {
        int result = isPalPerm("tact coa");

        System.out.println("result="+result);
    }

    private static int isPalPerm(String str){
        int oddCount=0;
        String lower = str.toLowerCase();
        int[] arrC = new int[128];

        for(char c : lower.toCharArray()){
            if (c>='a' && c<='z') {
                arrC[c] += 1;
                System.out.println(c + " " + arrC[c]);
                if(arrC[c] %2 != 0) oddCount+=1;
                else oddCount -= 1;
            }
        }
        return oddCount;

    }
}