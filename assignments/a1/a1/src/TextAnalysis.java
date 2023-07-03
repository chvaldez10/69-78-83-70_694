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
    }
}