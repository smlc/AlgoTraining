package org.example;

public class LongestCommonPrefix {

	/**
	 * Runtime : O(S) with S the sum of all characters in all the string
	 * Space : O(1)
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		String longestCommonPrefix = "";
		if (strs == null || strs.length == 0) return longestCommonPrefix;

		longestCommonPrefix = strs[0];
		for(int i = 1; i < strs.length; i++) {

			while(strs[i].indexOf(longestCommonPrefix) !=0) { // If return 0 that means the prefix is commons as he begin at index 0
				longestCommonPrefix = longestCommonPrefix.substring(0 , longestCommonPrefix.length() - 1); //We remove the last character to find the commons part
				if(longestCommonPrefix.isEmpty()) return "";
			}
		}

		return longestCommonPrefix;

	}

	public static void main( String[] args ) {
		System.out.println(longestCommonPrefix(new String[] {"flight", "fly", "flow"}));
	}
}
