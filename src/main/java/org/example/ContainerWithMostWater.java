package org.example;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    /**
     * Runtime complexity : O(n)
     * Space complexity : O(1)
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        if(height.length == 2 ) return Math.min(height[0], height[1]);

        int leftPointer = 0;
        int rightPointer = height.length - 1 ;
        int maxAir = 0;


        while (leftPointer < rightPointer)  {

            int currentMaxAir = (rightPointer  - leftPointer) * Math.min(height[leftPointer], height[rightPointer]);
            if(currentMaxAir > maxAir) {
                maxAir = currentMaxAir;
            }

            if(height[leftPointer] < height[rightPointer]  ) {
                leftPointer++;
            } else {
                rightPointer--;
            }

        }
        return maxAir;
    }

    public static void main( String[] args )
    {

        System.out.println(ContainerWithMostWater.maxArea(new int[] {2,3,4,5,18,17,6}));

    }
}
