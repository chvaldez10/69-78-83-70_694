/**
 * @author Christian Valdez
 */

public class TextAnalysis {
    public static void main(String[] args) {
        InteractWithUser terminalPrompt = new InteractWithUser();
        String userText = terminalPrompt.getFilenameFromUser();
        String userSearchKey = terminalPrompt.getSearchKeyFromUser();
        System.out.println(userText);
        System.out.println("Search key = " + userSearchKey);
    }
}