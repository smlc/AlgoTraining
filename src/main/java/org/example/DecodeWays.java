package org.example;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    /**
     * Runtime : O(n)
     * Space : O(n)
     * @param s
     * @return
     */
    public static int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        return dfsNumDecodings(s, s.length(), memo);

    }

    private static int dfsNumDecodings(String letter, int remainingLetter, int[] memo) {
        if(remainingLetter == 0) return 1;

        int beginOfTheStringIndex = letter.length() - remainingLetter;

        if(letter.charAt(beginOfTheStringIndex) == '0') return 0;

        if(memo[remainingLetter] != 0) {
            return memo[remainingLetter];
        }

        int result = dfsNumDecodings(letter, remainingLetter - 1, memo);

        if(remainingLetter >= 2 && Integer.parseInt(letter.substring(beginOfTheStringIndex , beginOfTheStringIndex + 2)) <= 26)     {
            result += dfsNumDecodings(letter, remainingLetter - 2, memo);
        }

        memo[remainingLetter] = result;
        return result;

    }

    public static void main( String[] args ) {
        System.out.println(numDecodings("1542"));
    }
}
