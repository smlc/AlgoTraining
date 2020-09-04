package org.example;


import java.util.ArrayList;
import java.util.List;

/**
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 */
public class PartionLabels {

	/**
	 * Time complexity : O(n) , n = number of char in S
	 * Space complexity = O(1)
	 * @param S
	 * @return
	 */
	public static List<Integer> partitionLabels(String S) {

		List<Integer> result = new ArrayList<>();
		int[] lastOcc = new int[26];

		for(int i = 0; i < S.length() ; i++){
			//char of a = 97, as is out of index we need to do char - 97 so it
			// will bring them to the correct index
			lastOcc[S.charAt(i) - 'a'] = i;
		}

		int index = 0;
		int max = 0;
		int lastFind = 0;
		while(index < S.length()){
			int end = lastOcc[S.charAt(index) -'a'];
			max = Math.max(max, end);
			if(index == max) {
				result.add((max + 1) - lastFind);
				lastFind += (max + 1) - lastFind;
			}
			index++;
		}

		return result;
	}

	public static void main( String[] args )
	{
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(partitionLabels("abaccbdeffed"));
		System.out.println(partitionLabels("dccccbaabe"));
	}
}
