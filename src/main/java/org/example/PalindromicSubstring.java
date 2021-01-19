package org.example;

/**
 * https://leetcode.com/problems/palindromic-substrings
 */
public class PalindromicSubstring {

    /**
     * Runtime O(N2)
     * Space O(1)
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            count += extendPalindrome(s, i, i); // odd length;
            count += extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private static int extendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main( String[] args ) {

        System.out.println(countSubstrings("abc"));
    }
}
