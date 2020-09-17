package org.example;

/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class ClimbStair {

    /**
     * Time complexity : O(2n)
     * Space complexity : O(n)
     * This solution use recursive for create all possible step and backtrack when we found the solution
     */
    public static int bruteForceSolution(int n){
        return climb_Stairs(0, n);
    }

    public static int climb_Stairs(int i, int n) {
        //We gone too far there are no solution in this space backtrack
        if (i > n) {
            return 0;
        }

        // We found a solution count it
        if (i == n) {
            return 1;
        }

        // Search for step 1 and step 2
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    /**
     * Time complexity : O(n)
     * Space complexity : O(n)
     * Reduce the tree by using memo(kind of cache).
     * @param n
     * @return
     */
    public static int recursionWithMemoization(int n) {
        int[] memo = new int[n+1];
        return climb_Stairs_Memo(0, n, memo);
    }

    private static int climb_Stairs_Memo(int i, int n, int[] memo) {

        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs_Memo(i + 1, n, memo) + climb_Stairs_Memo(i + 2, n, memo);
        return memo[i];
    }

}
