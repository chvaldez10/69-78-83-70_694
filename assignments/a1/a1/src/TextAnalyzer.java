import java.lang.reflect.Array;
import java.util.Arrays;

public class TextAnalyzer implements BasicAnalysis{
    private String userText;
    private int searchKey;
    private int numOfCharacters = 0;
    private int[] intFrequency;
    private int[] frequencyOfParagraph = new int[128];

    public TextAnalyzer() {
        this.userText = null;
        this.searchKey = -1;
    }

    public TextAnalyzer(String userText, int userSearchKey) {
        this.userText = userText;
        this.searchKey = userSearchKey;
        setFrequencyOfParagraph();
    }

    private void setFrequencyOfParagraph() {
        for (char textC : this.userText.toCharArray()) {
            int i = (int) textC;
            this.frequencyOfParagraph[i]++;
        }
    }

    public int[] getFrequencyOfParagraph() {return this.frequencyOfParagraph;}

    @Override
    public void displayFrequency() {
        System.out.println("List of all characters in the text:");
        for (int i=0; i<this.frequencyOfParagraph.length;i++) {
            if (frequencyOfParagraph[i] != 0 ){
                char textChar = (char) i;
                if (textChar == ' ') {
                    System.out.println("space - " + frequencyOfParagraph[i]);
                } else {
                    System.out.println(textChar + "-" + frequencyOfParagraph[i]);
                }
                this.numOfCharacters++;
            }
        }
    }

    public void setIntFrequency() {
        this.intFrequency = new int[this.numOfCharacters];
        int freqCount = 0;
        for (int i=0; i<this.frequencyOfParagraph.length;i++) {
            if (frequencyOfParagraph[i] != 0 ){
                this.intFrequency[freqCount] = this.frequencyOfParagraph[i];
                freqCount++;
            }
        }
    }

    @Override
    public void sortIntFrequency() {
        // temporary patch for not learning sort yet
        Arrays.sort(this.intFrequency);
    }

    public void displaySortedIntFrequency(){
        System.out.println("\nSorted frequency array\n" + Arrays.toString(this.intFrequency));
    }

    @Override
    public int findSearchKey() {
        int mid;
        int left = 0;
        int right = this.numOfCharacters-1;

        while (left <= right) {
            mid = (right+left)/2;
            if (this.searchKey < this.intFrequency[mid]) {
                right = mid-1;
            } else if (this.searchKey > this.intFrequency[mid]) {
                left = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
