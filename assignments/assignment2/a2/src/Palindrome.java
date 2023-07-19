
import java.util.Arrays;

public class Palindrome {
    private String[] usrArr;

    public Palindrome(String[] arr) {
        this.usrArr = arr;
    }

    public boolean isPalindrome(String word) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        QueueUsingLinkedList q  = new QueueUsingLinkedList();

        for (char c : word.toLowerCase().toCharArray()) {
            stack.push(c);
            q.enqueue(c);
        }

        while(stack.top != null) {
            char cStack = stack.pop();
            char cQ = q.dequeue();

            if(cStack != cQ) return false;
        }

        return true;
    }

    public void displayPalindrome() {
        System.out.println("The palindrome decisions are:");
        for (String word : usrArr) {
            boolean isWordPalindrome = isPalindrome(word);

            if (isWordPalindrome) System.out.println(word + "-Yes");
            else System.out.println(word + "-No");
        }
        System.out.println("\n");
    }
}
