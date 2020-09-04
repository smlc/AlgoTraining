package org.example;

import java.util.HashSet;
import java.util.Set;

public class TwoDMatrixSetZeroes {

	/**
	 * Solution with O(m+n) added space complexity
	 * Time Complexity: O(M×N)
	 *
	 * @param matrix
	 */
	public static void setZeroes(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();

		// Essentially, we mark the rows and columns that are to be made zero
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		// Iterate over the array once again and using the rows and cols sets, update the elements.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	/**
	 * Space complity : O(1)
	 * Time Complexity: O(M×N)
	 *
	 * @param matrix
	 */
	public static void setZeroesOptimalSolution(int[][] matrix) {
		int R = matrix.length;
		int C = matrix[0].length;
		boolean isCol = false;

		for (int i = 0; i < R; i++) {
			if (matrix[i][0] == 0) {
				isCol = true;
			}
			for (int j = 1; j < C; j++) {
				if (matrix[i][j] == 0) {
					//Mark first column as zero 0
					matrix[i][0] = 0;
					//Mark first row as zero
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}

		// See if the first column needs to be set to zero as well
		if (isCol) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main( String[] args )
	{

		//int matrix[][] = {{1,1,1},{1,0,1},{1,1,1}};
		//setZeroes(matrix);

		int matrix[][] = {{1,1,1,1},{1,0,1,1},{1,1,0,0},{0,0,0,1}};
		setZeroes(matrix);
		for(int m = 0; m < matrix.length; m++) {
			for (int n = 0; n < matrix[0].length; n++) {
				System.out.print(matrix[m][n]);
			}
			System.out.println("");
		}
	}
}
