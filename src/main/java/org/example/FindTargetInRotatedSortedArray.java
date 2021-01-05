package org.example;

public class FindTargetInRotatedSortedArray {

	public static int search(int[] nums, int target) {
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        
        int midIndex = 0; 
        
        while(leftPointer < rightPointer) {
            midIndex = leftPointer + (rightPointer - leftPointer) / 2;
            
            if (nums[midIndex] > nums[rightPointer]) { 
                if(target > nums[midIndex] || target <= nums[rightPointer]) {
                    //Target on the right side
                    leftPointer = midIndex + 1;
                } else {
                    //Target on the left side
                    rightPointer = midIndex;
                }
            } else { 
                if(target > nums[midIndex]  && target <= nums[rightPointer]) {
				    leftPointer = midIndex + 1;
			    }else {
				    rightPointer = midIndex;
			    }
            }
        }
        
        if (leftPointer == rightPointer && target != nums[leftPointer]) return -1;
        
        return leftPointer;
    }


	public static void main( String[] args )
	{

		int num[] = {4,5,6,7,0,1,2};

		System.out.println(search(num, 1));
	}
}
