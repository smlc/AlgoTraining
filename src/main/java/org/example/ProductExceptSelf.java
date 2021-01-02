package org.example;

public class ProductExceptSelf {

	public static int[] productExceptSelfWithDiv(int[] nums) {

		int[] output = new int[nums.length];
		int product = 1;
		for(int i = 0; i < nums.length ; i++) {
			product *=  nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			output[i] = product / nums[i];
		}

		return output;

	}
	/**
	 * Time complexity : O(N)
	 * Space complexity : O(N)
	 * @param nums
	 * @return
	 */
	public static int[] productExceptSelf(int[] nums) {

		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		int[] output = new int[nums.length];

		left[0] = 1;
		for(int i = 1; i < nums.length ; i++) {
			left[i] = nums[i - 1] * left[i-1];
		}

		right[nums.length - 1] = 1;
		for(int i = nums.length - 2; i >= 0 ; i--) {
			right[i] = nums[i + 1] * right[i + 1];
		}

		for (int i = 0; i < nums.length; i++) {
			output[i] = left[i] * right[i];
		}

		return output;

	}

	public static void main( String[] args )
	{

		int arr1[] = {1, 2, 3, 4};

		int result[] = productExceptSelfBruteForce(arr1);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print( result[i] + " ");
		}

	}
}
