package org.example;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */
public class ValidPalindromeII {

	/**
	 * Runtime : O(n)
	 * Space : O(1)
	 * @param s
	 * @return
	 */
	public static boolean validPalindrome(String s) {


		int left = 0, right = s.length() - 1;
		while(right > left) {
			if(s.charAt(left) != s.charAt(right)) {
				//We have a choice to made here remove the left character or the right character
				return(isPalindrome(s, left+1, right) || isPalindrome(s, left, right - 1)) ;
			} else {
				left++;
				right--;
			}

		}

		return true;
	}

	public static boolean isPalindrome(String s, int i, int j) {
		while(i < j) {
			if(s.charAt(i++) != s.charAt(j--)) return false;
		}
		return true;
	}

	public static void main( String[] args ) {
		System.out.println(validPalindrome("abccab"));
	}

}
