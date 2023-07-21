import java.util.Map;
import java.util.TreeMap;

/** WordAnalyzerSolver contains all the logic pertaining to analyzing String arrays. The analysis is as follows:
 * (1) Determine if each String is a palindrome
 * (2) Determine if each String has an anagram in the array.
 * @author Redge Santillan
 *
 */
public class WordAnalyzerSolver {
	
	Queue queue;
	Stack stack;
	
	/**
	 *
	 * Determines if a word is a palindrome by parsing each character to a stack and a queue
	 * 		and traversing each value.
	 *
	 * @param s - input word (string).
	 * @return true if it is a palindrome. Otherwise, returns false.
	 *
	 */
	private boolean isPalindrome(String s) {
		// convert string to lowercase
		s = s.toLowerCase();
		int size = s.length();

		queue = new Queue(size);
		stack = new Stack(size);

		// push characters into a stack and enqueue characters into a queue
		for(int i = 0; i < size; i++) {
			stack.push(s.charAt(i));
			queue.enQueue(s.charAt(i));
		}
		
		// Compare each character as the stack is popped one by one and the queue is dequeued one by one.
		while (!stack.isEmpty()) {
			if(stack.pop() != queue.deQueue()) {
				// If one of them ends up being false, then return false. Otherwise, return true.
				return false;
			}
		}
		return true;
	}
	
	/** palindromeList() determines if each String in a String array is a palindrome.
	 * @param sArray (String[]) - input String array.
	 * @return String [] - a String array, indexed the same as the input String array - array element is assigned "Yes" if String at that index is a palindrome. Otherwise, array element is assigned "No".
	 */
	public String[] palindromeList(String[] sArray) {
		String[] strArray = sArray;
		int size = strArray.length;
		String[] palindromeDecisions = new String[size];

		for (int i = 0; i < size; i++) {
				if (isPalindrome(strArray[i])) {
					palindromeDecisions[i] = "Yes";
					// Test printout
//					System.out.println("i = "+i+" : "+"j = "+j+" : YES");
				} else {
					palindromeDecisions[i] = "No";
					// Test printout
//					System.out.println("i = "+i+" : "+"j = "+j+" : NO");
			}
		}
		return palindromeDecisions;
	}
	
	/**
	 * Creates a TreeMap based on the passed string.
	 * @param String - string to be analyzed
	 * @return TreeMap - a TreeMap containing character occurrences/frequencies
	 */
	private Map<Character, Integer> createCharMap(String s) {
		//Convert string from file to Char array 
		Map<Character, Integer> charCounterMap = new TreeMap<Character, Integer>();
		char [] charArray = s.toCharArray();
		for (char c : charArray) {
			if (charCounterMap.containsKey(c)) { 	// if char is already in the treemap charCounterMap, increment by 1
				charCounterMap.put(c, charCounterMap.get(c) + 1);
			} else { 									// if char is not in the treemap charCounterMap, add the char as a key, and initialize it's value as 1
				charCounterMap.put(c, 1);
			}
		}
		return charCounterMap;
	}
	
	/**isAnagram() compares 2 input Strings and determines if they are anagrams of each other.
	 * @param String s1 - input String 1
	 * @param String s2 - input String 2
	 * @return true if the 2 input Strings are anagramsn of each other. Otherwise, false.
	 */
	private boolean isAnagram(String s1, String s2) {
		// convert to lowercase, create Maps to receive TreeMaps from createCharMap()
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		Map<Character, Integer> charCounterMap1 = createCharMap(s1);
		Map<Character, Integer> charCounterMap2 = createCharMap(s2);
		
		// compare the 2 TreeMaps if they are equal. If so, return true - otherwise, return false.
		if (charCounterMap1.equals(charCounterMap2)){
			return true;
		} else {
			return false;
		}
	}
	
	/**anagramList() determines if each String element in a String array is an anagram of another String element.
	 * @param sArray (String[]) - input String array.
	 * @return String[] - a String array, indexed the same as the input String array - array element is assigned "Yes" if String at that index is an anagram of another String in the array. Otherwise, array element is assigned "No".
	 */
	public String[] anagramList(String[] sArray) {
		String[] strArray = sArray;
		int size = strArray.length;
		String[] anagramDecisions = new String[size];
		
		// Compare each element. If anagram is found, assign "Yes" to the decision array for both elements.
		// If the decision array element already has a "Yes",
		for (int i = 0; i < size; i++) {
			for (int j = size-1; j > i; j--) {
				if (isAnagram(strArray[i], strArray[j])) {
					anagramDecisions[i] = "Yes";
					anagramDecisions[j] = "Yes";
					// Test printout
//					System.out.println("i = "+i+" ; "+strArray[i]+" : "+"j = "+j+" ; "+strArray[j]+" : YES");
				} else if (anagramDecisions[i] != "Yes" && anagramDecisions[j] != "Yes"){
					anagramDecisions[i] = "No";
					anagramDecisions[j] = "No";
					// Test printout
//					System.out.println("i = "+i+" ; "+strArray[i]+" : "+"j = "+j+" ; "+strArray[j]+" : NO");
				} 
			}
		}
		return anagramDecisions;
	}
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WordAnalyzerSolver testWAS = new WordAnalyzerSolver();
//		System.out.println(testWAS.isPalindrome("racecar"));
//		System.out.println(testWAS.isPalindrome("RotoR"));
//		testWAS.testWASMethod();
//		String[] strArray = new String[]{"apple", "applE"};
//		System.out.println("isAnagram() test : "+testWAS.isAnagram(strArray[0], strArray[1]));
//		
//		String[] strArray2 = new String[]{"racecar", "apple", "kayak", "rotor", "racecar", "kayak", "rotor"};
//		System.out.println(Arrays.toString(testWAS.anagramList(strArray2)));
//	}
}
