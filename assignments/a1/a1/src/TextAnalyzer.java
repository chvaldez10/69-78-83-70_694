public class TextAnalyzer implements BasicAnalysis{
    private String userText;
    private String searchKey;
    private int numOfCharacters = 0;
    private int[] intFrequency;
    private int[] frequencyOfParagraph = new int[128];

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
        for (char textC : this.userText.toCharArray()) {
            int i = (int) textC;
            this.frequencyOfParagraph[i]++;
        }
    }

    public int[] getFrequencyOfParagraph() {return this.frequencyOfParagraph;}

    @Override
    public void displayFrequency() {
        for (int i=0; i<this.frequencyOfParagraph.length;i++) {
            if (frequencyOfParagraph[i] != 0 ){
                char textChar = (char) i;
                System.out.println(textChar + "-" + frequencyOfParagraph[i]);
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
    public int[] sortFrequencyArray() {
        return new int[0];
    }

    @Override
    public String findSearchKey() {
        return null;
    }
}
