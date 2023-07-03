public class TextAnalyzer implements BasicAnalysis{
    private String userText;
    private String searchKey;
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

    public void displayFrequency() {
        for (int i=0; i<this.frequencyOfParagraph.length;i++) {
            if (frequencyOfParagraph[i] != 0 ){
                char textChar = (char) i;
                System.out.println(textChar + "-" + frequencyOfParagraph[i]);
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
