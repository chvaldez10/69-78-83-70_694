import java.util.*;

public class WordAnalysis {
    public static void main(String[] args) {
        analyzeWord();
    }

    private static void analyzeWord() {
        InteractWithUser userInput = new InteractWithUser();
        String[] userList;

        int listSize = userInput.getOneIntFromUser("Enter number of words:\n");
        userList = new String[listSize];
        userInput.fillArr(userList, "Enter input words:\n");

        // analysis
        Anagram anagram = new Anagram(userList);
        anagram.setAnagramMap();
        Palindrome palindrome = new Palindrome(userList);

        // print to terminal
        userInput.printArrNoSpaces(userList, "The input words are:");
        anagram.displayResults();
        palindrome.displayPalindrome();
    }
}