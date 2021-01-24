package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> setOne = new HashSet<>();
		for (int n : nums1) setOne.add(n);
		Set<Integer> setTwo = new HashSet<>();
		for (int n : nums2) setTwo.add(n);


		if(setOne.size() < setTwo.size()) return intersectionSet(setOne, setTwo);
		else  return intersectionSet(setTwo, setOne);
	}

	public static int[] intersectionSet(Set<Integer> set1, Set<Integer> set2) {
		int [] output = new int[set1.size()];
		int idx = 0;
		for (int s : set1)
			if (set2.contains(s)) output[idx++] = s;

		return Arrays.copyOf(output, idx);
	}
	public static void main( String[] args )
	{

		int arr1[] = {1, 2, 3, 3, 4, 5, 5, 6};
		int arr2[] = {3, 3, 5};

		int result[] = intersection(arr1, arr2);

		for (int n : result) System.out.print(n + " ");
	}
}
