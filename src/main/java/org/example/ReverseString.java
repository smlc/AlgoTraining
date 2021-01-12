package org.example;

/**
 * https://leetcode.com/problems/reverse-string/submissions/
 * Can be done using recursion
 */
public class ReverseString {


    /**
     * Runtime complexity : O(n)
     * Space complexity : O(1)
     * @param s
     */
    public static char[] reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;
        char tmp;
        while(right > left) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            right--;
            left++;
        }

        return s;
    }

    public static void main( String[] args ) {

        char[] reversed = reverseString(new char[] { 'H', 'E', 'L', 'L', 'O'});

        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i]);
        }
    }

}
