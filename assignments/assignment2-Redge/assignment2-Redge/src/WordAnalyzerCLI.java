
/**WordAnalyzerCLI - the main part of the application - takes user-inputted String array and:
 * (1) Determine if each String is a palindrome
 * (2) Determine if each String has an anagram in the array.
 * Results are displayed to the user.
 * @author Redge Santillan
 *
 */
public class WordAnalyzerCLI {
	
	private InteractiveCLI cli;
	private WordAnalyzerSolver wordAnalyzer;
	
	public WordAnalyzerCLI() {
		cli = new InteractiveCLI();
	}
	public void run() {
		// Part 0 : Initialize variables/objects
		int arrayLength;
		String[] strArray;
		wordAnalyzer = new WordAnalyzerSolver();
		String[] anagramDecisions;
		String[] palindromeDecisions;
		
		// Part 1: User inputs - array size and array elements.
		System.out.println("Enter the number of words: ");
		arrayLength = cli.getKeyboardInteger();
		
		strArray= new String[arrayLength];
		cli.display("Enter input words: ");
		for (int i = 0; i < arrayLength; i++) {
			strArray[i] = cli.getKeyboardString();
		}
		
		cli.display("\nThe input words are:");
		for (int i = 0; i < arrayLength; i++) {
			cli.prompt(strArray[i]+" ");
		}
		cli.display("");
		
		// Part 2: For each word, are there corresponding anagrams in the rest of the array?
		anagramDecisions = wordAnalyzer.anagramList(strArray);
		cli.display("\nThe anagram decisions are:");
		for (int i = 0; i < arrayLength; i++) {
			cli.display(strArray[i]+"-"+anagramDecisions[i]);
		}
		
		// Part 3: For each word, is that word a palindrome?
		palindromeDecisions = wordAnalyzer.palindromeList(strArray);
		cli.display("\nThe palindrome decisions are:");
		for (int i = 0; i < arrayLength; i++) {
			cli.display(strArray[i]+"-"+palindromeDecisions[i]);
		}
	}
	
	public static void main(String[] args) {
		WordAnalyzerCLI app = new WordAnalyzerCLI();
		app.run();
	}
}
