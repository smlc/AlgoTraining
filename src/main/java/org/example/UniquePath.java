package org.example;

/**
 * https://leetcode.com/problems/unique-paths
 */
public class UniquePath {

    /**
     * Top-down with Memoization
     * Runtime : O(MN)
     * Space : O(MN)
     * @param m
     * @param n
     * @return
     */
    public static int  uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; ++i) { // As 0 could be a valid solution we need another init value
            for (int j = 0; j < n; ++j) {
                memo[i][j] = -1;
            }
        }
        return recUniquePaths(m-1, n - 1, memo);

    }

    private static int recUniquePaths(int currentM, int currentN, int[][] memo){

        if (currentM == 0 || currentN == 0) return 1;

        if(memo[currentM - 1][currentN] == -1) memo[currentM - 1][currentN] = recUniquePaths(currentM - 1, currentN, memo);
        if(memo[currentM][currentN - 1] == -1) memo[currentM][currentN - 1] = recUniquePaths(currentM, currentN - 1, memo);

        return memo[currentM - 1][currentN]  + memo[currentM][currentN - 1];
    }

    public static void main( String[] args ) {

        System.out.println(uniquePaths(3,2));
    }
}
