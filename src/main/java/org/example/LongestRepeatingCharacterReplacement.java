package org.example;


import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class LongestRepeatingCharacterReplacement {

	/**
	 * Runtime : O(n)
	 * Space : O(1)
	 * @param s
	 * @param k
	 * @return
	 */
	public static int characterReplacement(String s, int k) {
		int windowStart = 0, max = 0, maxRepeatLetterCount = 0;

		Map<Character, Integer> letterFrequencyMap = new HashMap<>();

		for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {

			char rightChar = s.charAt(windowEnd);
			letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

			//This is the number of letter we have to replace in the current windows.
			// For "ABA" the window size (windowEnd - windowStart + 1 ) is equal to 3
			// here for having the best case we want to replace B with A. For that
			// maxRepeatLetterCount here is the two A. Once we remove the A as we want to keep them
			// B remain. remainingLetterToReplace is equal to 1.
			int remainingLetterToReplace = ( windowEnd - windowStart + 1 ) - maxRepeatLetterCount;

			// If the number of letter who remain is equal superior to K that means in this windows
			// we don't have enough operation to replace the minimun number to replace to have the maximun length string.
			// We can shrink  the window
			if(remainingLetterToReplace > k) {
				char leftChar = s.charAt(windowStart);
				letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
				windowStart++;
			}

			max = Math.max(max ,  windowEnd - windowStart + 1 );
		}

		return max;
	}

	public static void main( String[] args ) {
		System.out.println(characterReplacement("AABABBA", 1));
	}
}
