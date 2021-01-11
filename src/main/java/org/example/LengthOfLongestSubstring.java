package org.example;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    /**
     * Runtime complexity : O(n)
     * Space complexity : O(k) with k <= 26 (number letter alphabet)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        int startWindows = 0;
        Map<Character, Integer> character = new HashMap<>();
        int max = 0;
        for(int endWindows = 0; endWindows < s.length(); endWindows++) {

            char currentChar = s.charAt(endWindows);

            if(character.containsKey(currentChar)) {
                //We take the biggest position of we find the character.
                //In case like "pwwke" we put startWindow in the second w
                startWindows = Math.max(startWindows, character.get(currentChar)  );
            }

            character.put(currentChar, endWindows);
            // We want to update max after calculating startWindows
            max = Math.max(max, endWindows - startWindows );

        }

        return max;
    }

    public static void main( String[] args )
    {

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
