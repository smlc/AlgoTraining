package org.example;

/**
 * https://leetcode.com/problems/maximum-product-subarray+
 * **/
public class MaximumProductSubarray {

	/**
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 * @param nums
	 * @return
	 */
	public static int maxProduct(int[] nums) {
		//Why initialize with first element in this case
		int currentMax = nums[0];
		int currentMin = nums[0];
		int previousMax = nums[0];
		int previousMin = nums[0];
		int result = nums[0];

		//Why start at 1 in this problem ?
		// This handle edge case where we have 1 element in the array
		for(int i = 1; i < nums.length; i++) {
			//Case when current element is positive
			currentMax = Math.max(Math.max(nums[i] * previousMin,  nums[i] * previousMax), nums[i]);
			currentMin = Math.min(Math.min(nums[i] * previousMin,  nums[i] * previousMax), nums[i]);

			result = Math.max(currentMax, result);
			previousMax = currentMax;
			previousMin = currentMin;

		}

		return result;
	}

	public static void main( String[] args )
	{
		int num[] = {-1, 6, 2, 0, 7, 9};
		System.out.println(maxProduct(num));
	}
}
