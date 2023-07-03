/**
 * @author Christian Valdez
 */

public class TextAnalysis {
    public static void main(String[] args) {
        InteractWithUser terminalPrompt = new InteractWithUser();
        String userText = terminalPrompt.getFilenameFromUser();
        String userSearchKey = terminalPrompt.getSearchKeyFromUser();


        TextAnalyzer analyzer = new TextAnalyzer(userText, userSearchKey);
        analyzer.displayFrequency();

    }
}