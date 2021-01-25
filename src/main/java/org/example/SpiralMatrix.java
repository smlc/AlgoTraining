package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    /**
     * Runtime O(N) : N is number of element
     * Space O(1) : if we don't consider the result list
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        if (matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        int size = matrix.length * matrix[0].length;
        while(result.size() < size) {

            //Left to right on top of the Matrix
            for( int i = left; i <= right && result.size() < size; i++){
                result.add(matrix[top][i]);
            }

            top++; //Avoid duplicate

            //Top to bottom on right side of the Matrix
            for( int i = top; i <= bottom && result.size() < size; i++){
                result.add(matrix[i][right]);
            }

            right--; //Avoid duplicate
            //Right to left on bottom of the Matrix
            for( int i = right; i >= left && result.size() < size; i--){
                result.add(matrix[bottom][i]);
            }

            bottom--;
            // to left on bottom of the Matrix
            for( int i = bottom; i >= top && result.size() < size; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }

        return result;
    }

    public static void main( String[] args )
    {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));

    }
}
