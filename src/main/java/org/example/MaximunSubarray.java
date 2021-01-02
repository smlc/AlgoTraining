package org.example;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaximunSubarray {

	public static int maxSubArray(int[] nums) {

		int max = Integer.MIN_VALUE;
		int tmpMax = 0;


		for(int i = 0; i < nums.length; i++) {

			//If after adding the new element we are still better than before keep going and dont init tmpMax
			if(nums[i] > tmpMax + nums[i]) {
				tmpMax = 0;
			}

			tmpMax+= nums[i];

			if(tmpMax > max) {
				max = tmpMax;
			}
		}

		return max;
	}

	public static void main( String[] args )
	{

		int num[] = {-2,1,-3};

		System.out.println(maxSubArray(num));
	}
}
