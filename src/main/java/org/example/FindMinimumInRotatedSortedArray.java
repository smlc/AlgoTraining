package org.example;

public class FindMinimumInRotatedSortedArray {

	public static int findMin(int[] nums) {
		if(nums.length == 1) return nums[0];

		int leftPointer = 0;
		int rightPointer = nums.length - 1;

		//The array is still ordered, the min element is the first one
		if(nums[rightPointer] > nums[0]) {
			return nums[0];
		}

		int midIndex =  0;
		while( rightPointer >= leftPointer ) {
			//Mid element
			midIndex =  leftPointer + (rightPointer - leftPointer) / 2;

			//As the array is sorted there is a inflection point.
			if(nums[midIndex] > nums[midIndex + 1]) {
				return nums[midIndex + 1];
			}

			if (nums[midIndex] < nums[midIndex - 1]) {
				return nums[midIndex];
			}

			if(nums[midIndex] > nums[leftPointer]) {
				leftPointer = midIndex + 1;
			}else {
				rightPointer = midIndex - 1;
			}

		}
		return 0;
	}


	public static void main( String[] args )
	{

		int num[] = {4, 5, 6, 7, 2, 3};

		System.out.println(findMin(num));
	}
}
