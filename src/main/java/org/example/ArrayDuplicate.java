package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDuplicate {

	/**
	 * Find the duplicates element in a sorted array.
	 * Complexity : O(n)
	 * @param arr
	 * @return
	 */
	static List<Integer> sortedArrayDuplicate(int[] arr) {

		if(arr.length == 0 || arr.length == 1){
			return Collections.emptyList();
		}
		List<Integer> result = new ArrayList<>();
		int i = 0 , j = 1;

		while(i < arr.length & j < arr.length){
			if(arr[i] == arr[j]){
				result.add(arr[i]);
			}
			i++;
			j++;
		}

		return result;
	}

	/**
	 * Find all duplicate element in unsorted array, we could sorted the array and apply
	 * the sortedArrayDuplicate methode but this will be n log n.
	 * If we use a Set it will be O(n) in time complexity and O(n) in space complexity.
	 * Note we return only the duplicate element from the input array.
	 * @param arr
	 * @return
	 */
	static List<Integer> unsortedArrayDuplicate(int[] arr) {

		if(arr.length == 0 || arr.length == 1){
			return Collections.emptyList();
		}

		Set<Integer> set = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(set.contains(arr[i])) {
				result.add(arr[i]);
			} else {
				set.add(arr[i]);
			}

		}

		return result;
	}

	static List<Integer> unsortedArrayDuplicateWithEncoding(int[] arr) {

		if(arr.length == 0 || arr.length == 1){
			return Collections.emptyList();
		}

		Set<Integer> set = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(set.contains(arr[i])) {
				result.add(arr[i]);
			} else {
				set.add(arr[i]);
			}

		}

		return result;
	}

	public static void main( String[] args )
	{

		int arr1[] = {1, 2, 3, 3, 4, 5, 5, 6};
		System.out.println(sortedArrayDuplicate(arr1));
		int arr2[] = {1, 2, 3, 4};
		System.out.println(sortedArrayDuplicate(arr2));

		int arr3[] = {3, 2, 4, 9, 5 ,3, 7, 2, 5, 6};
		System.out.println(unsortedArrayDuplicate(arr3));
	}
}
