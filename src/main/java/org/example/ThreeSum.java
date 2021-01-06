package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
    /**
     * Runtime complexity : O(N2)
     * Space complexity : 0(n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        //We will use this first loop to fix -c, so will search for all -c in the array
        for(int i = 0; i < nums.length - 2; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) { //Skip duplicates, as the array is sorted
                continue;
            }
            //We are looking for a+b+c == 0, which is also a+b == -c
            // We will search pair a and b, from i+1 to end of the array
            searchPair(nums, -nums[i], result, i + 1);

        }
        return result;
    }

    public static void searchPair(int[] array, int target, List<List<Integer>> result, int start) {

        int end = array.length - 1;
        int sum = 0;
        while(start < end) {
            sum = array[start] + array[end];

            if(sum == target) {
                result.add(Arrays.asList(-target, array[start], array[end]));
                start++;
                end--;

                while (start < end && array[start] == array[start - 1])
                    start++; // skip same element to avoid duplicate triplets
                while (start < end && array[end] == array[end + 1])
                    end--; // skip same element to avoid duplicate triplets
            }else if(target > sum) {
                //Increase start index because it's the smallest element of the sum. We want to increase the the result of the sum
                start++;
            } else {
                //Reduce end index because it's the bigger element of the sum. We want to decrease the the result of the sum
                end--;
            }
        }
    }

    public static void main( String[] args )
    {

        List<List<Integer>> result = ThreeSum.threeSum(new int[] { -1,0,1,2,-1,-4 });
        System.out.println("Triplet : " + result.toString());
    }
}
