public class TextAnalyzer implements BasicAnalysis{
    private String userText;
    private String searchKey;

    public TextAnalyzer() {
        this.userText = null;
        this.searchKey = null;
    }

    public TextAnalyzer(String userText, String userSearchKey) {
        this.userText = userText;
        this.searchKey = userSearchKey;
    }

    @Override
    public int[] getFrequency() {
        return new int[0];
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
