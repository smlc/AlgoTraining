package org.example;

public class Anagramme {

	/**
	 *	Find if two string are anagram
	 *  Complexity : O(n+m)
	 * @param a
	 * @param b
	 * @return
	 */
	static int makeAnagram(String a, String b) {
		int[] histogramme = new int[256];
		int result = 0;

		for(char caractere : a.toCharArray()) {
			histogramme[caractere]++;
		}

		for(char caractere : b.toCharArray()) {
			histogramme[caractere]--;
		}

		for (int i = 0; i < histogramme.length; i++) {
			if(histogramme[i] != 0) {
				result += Math.abs(histogramme[i]);
			}
		}
		return result;
	}

	/**
	 * Find how much characters are the same before alternaning in a string.
	 * Example : AAABBB --> AA (2) + BB (2) = 4 alternating characters
	 * Complexity : O(n)
	 * @param s
	 * @return
	 */
	static int alternatingCharacters(String s) {

		int result = 0;
		for(int i = 0; i < s.length() - 1; i++){
			if(s.charAt(i) == s.charAt(i + 1)){
				result++;
			}
		}
		return result;
	}

	static long substrCount(int n, String s) {

		int windowStart = 0;
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

		}
		return 0;

	}

	public static void main( String[] args )
	{
		//System.out.println(makeAnagram("cde", "abc"));
		System.out.println(alternatingCharacters("AAAA"));
	}
}
