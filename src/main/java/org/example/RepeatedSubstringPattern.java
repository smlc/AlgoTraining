package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedSubstringPattern {
	/**
	 * Input: "abab"
	 * Output: True
	 * Explanation: It's the substring "ab" twice.
	 * @param s
	 * @return
	 */
	public static boolean repeatedSubstringPattern(String s) {


		int length = s.length() ;
		for(int i = 1; i <= length/2; i++){
			if(length % i == 0) {
				int nbRepeats = length / i;
				String subStringToRepeat = s.substring(0, i);
				StringBuilder builder = new StringBuilder();
				for(int j = 0; j < nbRepeats ; j++) {
					builder.append(subStringToRepeat);
				}
				if(builder.toString().equals(s)) return true;
			}
		}
		return false;
	}

	public static void main( String[] args )
	{

		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("aba"));
		System.out.println(repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(repeatedSubstringPattern("ababba"));

	}
}
