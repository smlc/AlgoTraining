package org.example;

import java.util.HashMap;

public class TwoSum {

	/**
	 * If the input array is sorted we can have a solution with
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 * This solution use two pointer technique.
	 * @param arr
	 * @param target
	 * @return the index of the two number
	 */
	public static int[] twoSumSortedArray(int[] arr, int target) {
		int firstPointer = 0;
		int secondPointer = arr.length - 1;

		while(firstPointer < secondPointer) {
			int currentSum = arr[firstPointer] + arr[secondPointer];

			if(currentSum == target) {
				return  new int[]{ firstPointer, secondPointer };
			}

			if(currentSum > target) {
				secondPointer--;
			}else {
				firstPointer++;
			}
		}
		return  new int[]{ -1, -1 };
	}

	/**
	 * Using a hash map we can add each number on the map like (number, index).
	 * And test if targer - arr[i] is present into the map.
	 * Time complexity : O(n)
	 * Space complexity : O(n)
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int[] twoSumUnSortedArray(int[] arr, int target) {
		HashMap<Integer, Integer> mapNums = new HashMap<>();

		for(int i = 0; i < arr.length; i++){
			if (mapNums.containsKey(target - arr[i]))
				return new int[] { mapNums.get(target - arr[i]), i };
			else
				mapNums.put(arr[i], i);
		}
		return new int[] { -1, -1 };

	}

	public static void main( String[] args )
	{

		int[] result = TwoSum.twoSumSortedArray(new int[] { 1, 2, 3, 4, 6 }, 6);
		System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");

		int[] resultTwo = TwoSum.twoSumUnSortedArray(new int[] { 6, 2, 4, 3, 1 }, 6);
		System.out.println("Pair with target sum: [" + resultTwo[0] + ", " + resultTwo[1] + "]");

	}
}
