package org.example;


import java.util.TreeSet;

public class ContainsDuplicate {
	/**
	 * TreeSet here can get us the minimun and maxium element in an set for O(logn) instead of
	 * O(n2).
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i < nums.length; ++i) {


			// min({ 1 }) >= 2 return null : Return the min element in the set than is greater than or equal to given element
			//This example return null.
			Long s = set.ceiling((long) nums[i]);
			if (s != null && s - nums[i] <= t) {
				return true;
			}

			//This method returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
			//max({ 1 }) <= 2
			Long g = set.floor((long) nums[i]);
			if (g != null && nums[i] - g <= t) {
				return true;
			}

			set.add((long) nums[i]);
			if (set.size() > k) {
				set.remove((long) nums[i - k]);
			}
		}
		return false;
	}

	public static void main( String[] args )
	{

		int arr1[] = {1,5,1,1};
		System.out.println(containsNearbyAlmostDuplicate(arr1, 2, 3));

	}
}
