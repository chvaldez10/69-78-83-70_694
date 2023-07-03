import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer implements BasicAnalysis{
    private String userText;
    private String searchKey;
    private Map<Character, Integer> frequencyOfParagraph;

    public TextAnalyzer() {
        this.userText = null;
        this.searchKey = null;
    }

    public TextAnalyzer(String userText, String userSearchKey) {
        this.userText = userText;
        this.searchKey = userSearchKey;
        setFrequencyOfParagraph();
    }

    private void setFrequencyOfParagraph() {
        this.frequencyOfParagraph = new HashMap<>();
        for (char textC : this.userText.toCharArray()) {
            if(frequencyOfParagraph.containsKey(textC))
                frequencyOfParagraph.put(textC, frequencyOfParagraph.get(textC) + 1);
            else frequencyOfParagraph.put(textC, 1);
        }
    }

    public Map<Character, Integer> getFrequencyOfParagraph() {return this.frequencyOfParagraph;}

    public void displayFrequency() {
        for (Character textC : this.frequencyOfParagraph.keySet()){
            int charFrequency = this.frequencyOfParagraph.get(textC);
            System.out.println(textC + "-" + charFrequency);
        }
    }

    @Override
    public int[] sortFrequencyArray() {
        return new int[0];
    }

    @Override
    public String findSearchKey() {
        return null;
    }
}
