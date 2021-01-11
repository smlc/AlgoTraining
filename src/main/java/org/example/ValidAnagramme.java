package org.example;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagramme {

    /**
     * Space complexity O(1) : the histogram array size is constant
     * Runtime complexity O(n)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if(t.length() != s.length()) return false;

        char[] histogram = new char[26];
        for(int i = 0; i < t.length(); i++) {
            histogram[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            if(histogram[s.charAt(i) - 'a'] > 0) {
                histogram[s.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        System.out.println(isAnagram("bb", "ba"));
    }
}
