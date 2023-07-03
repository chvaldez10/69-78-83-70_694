import java.util.Arrays;

/**
 * @author Christian Valdez
 */

public class TextAnalysis {
    public static void main(String[] args) {
        InteractWithUser terminalPrompt = new InteractWithUser();
        String userText = terminalPrompt.getFilenameFromUser();
        int userSearchKey = terminalPrompt.getSearchKeyFromUser();


        TextAnalyzer analyzer = new TextAnalyzer(userText, userSearchKey);
        analyzer.displayFrequency();
        //need to display freq first
        analyzer.setIntFrequency();
        analyzer.sortIntFrequency();
        analyzer.displaySortedIntFrequency();
        int searchResult = analyzer.findSearchKey();
        if (searchResult == -1) {
            System.out.println("Search key " + "'"+ userSearchKey + "'" + " NOT FOUND");
        } else {
            System.out.println("\nSearch key " + "'" + userSearchKey + "'" + " FOUND");
            System.out.println("\nSearch key " + "'" + userSearchKey + "'" + " is at index " + searchResult);
        }

    }
}