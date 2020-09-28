package org.example;

public class InsertIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {


        if(intervals.length == 0){
            int[][] resultIntervals = new int[1][2];
            resultIntervals[0][0] = newInterval[0];
            resultIntervals[0][1] = newInterval[1];
            return resultIntervals;
        }

        int i = 0;
        int skiped = 0;

        //Skip all the intervals which end before the start of the new interval.
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            i++;
        }
        skiped = i;

        //Merge interval who overlaps with newInterval
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        //Create result array
        int[][] resultIntervals = new int[skiped + 1 + (intervals.length - i)][2];

        int j = 0;
        //Copy skiped interval into new array
        while(j < skiped){
            resultIntervals[j][0] = intervals[j][0];
            resultIntervals[j][1] = intervals[j][1];
            j++;
        }

        //Copy merge interval into new array
        while( j < skiped+1){
            resultIntervals[j][0] = newInterval[0];
            resultIntervals[j][1] = newInterval[1];
            j++;
        }

        //Copy remaining intervals into new array
        while( j < resultIntervals.length && i < intervals.length){
            resultIntervals[j][0] = intervals[i][0];
            resultIntervals[j][1] = intervals[i][1];
            j++;
            i++;
        }
        return resultIntervals;
    }

    public static void main( String[] args )
    {
        //int[][] intervals = {{1,3},{6,9}};
        //int[] newIntervals = {2,5};
        //System.out.println(insert(intervals, newIntervals));

        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newIntervals = {4,8};
        System.out.println(insert(intervals, newIntervals));
    }
}
