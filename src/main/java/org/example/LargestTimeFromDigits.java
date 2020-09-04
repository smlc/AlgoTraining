package org.example;

import java.sql.SQLOutput;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/solution/
 */
public class LargestTimeFromDigits {
	int max = -1;
	public String largestTimeFromDigits(int[] A) {
		recursiveSearch(A, 0);

		if(max == -1) {
			return "";
		}else {
			return String.format("%02d:%02d",max/60,max%60);
		}

	}

	private void recursiveSearch(int[] A, int startIndex) {

		//Stop case
		if(startIndex == A.length) {
			createTime(A);
			return;
		}

		for (int i = startIndex; i < A.length; i++) {
			swap(A, i, startIndex);

			recursiveSearch(A, startIndex + 1);

			swap(A, i, startIndex);
		}
	}
	private void createTime(int[] A) {
			int hour = A[0] * 10 + A[1];
			int minutes = A[2] * 10 + A[3];

			if(hour < 24 && minutes < 60) {
				max = Math.max(max, hour*60+minutes);
			}
	}
	private void swap(int[] A, int index1, int index2) {
		if(index1 != index2){
			int temp = A[index1];
			A[index1] = A[index2];
			A[index2] = temp;
		}

	}

	public static void main( String[] args )
	{
		LargestTimeFromDigits largestTimeFromDigits = new LargestTimeFromDigits();
		System.out.println(largestTimeFromDigits.largestTimeFromDigits(new int[]{1,2,3,4}));

	}
}
