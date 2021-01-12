package org.example;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {

		s = s.toLowerCase();
		int left = 0, right = s.length() - 1;

		while (right > left) {
			while( right > left && !Character.isLetterOrDigit(s.charAt(left))) left++;
			while( right > left && !Character.isLetterOrDigit(s.charAt(right))) right--;

			if(s.charAt(right) != s.charAt(left)) {
				return false;
			}
			right--;
			left++;
		}

		return true;
	}

	public static void main( String[] args ) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
