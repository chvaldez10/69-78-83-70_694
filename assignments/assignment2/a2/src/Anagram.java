import java.util.*;

public class Anagram {
    private Map <String, ArrayList<String>> anagramMap = new HashMap<>();
    private String[] userArr;

    public Anagram (String[] arr) {
        this.userArr = arr;
    }

    public void setAnagramMap(){
        for (String word : userArr) {
            String sortedWord = sortString(word);

            // key : value pair in the following format "sorted word" : [list of words]
            ArrayList <String> anagramList = anagramMap.getOrDefault(sortedWord, new ArrayList<>());
            anagramList.add(word);
            anagramMap.put(sortedWord, anagramList);
        }
    }

    private String sortString(String word) {
        char[] wordArr = word.toLowerCase().toCharArray();
        Arrays.sort(wordArr);
        String wordSorted = new String(wordArr);
        return wordSorted;
    }

    public void displayResults() {
        System.out.println("The anagram decisions are:");
        for(String word : userArr) {
            String sortedWord = sortString(word);
            int listLen = anagramMap.get(sortedWord).size();

            // display to terminal
            if (listLen == 1) System.out.println(word + "-No");
            else System.out.println(word + "-Yes");
        }
        System.out.println("\n");
    }
}
