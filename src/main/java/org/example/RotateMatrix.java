package org.example;

/**
 * https://leetcode.com/problems/rotate-image
 */
public class RotateMatrix {

	/**
	 * O(n2)
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {

		int n = matrix.length;
		for(int i = 0; i < n / 2; i++){

			for(int j = i; j < n - i - 1; j++){
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - i - 1][n - 1 - j];
				matrix[n - i - 1][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - i - 1] = tmp;
			}
		}
	}

	public static void main( String[] args )
	{

		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int m = 0; m < matrix.length; m++) {
			for (int n = 0; n < matrix[0].length; n++) {
				System.out.print(matrix[m][n]+ " ");
			}
			System.out.println("");
		}

		//Expected :[[7,4,1],[8,5,2],[9,6,3]]
	}
}
