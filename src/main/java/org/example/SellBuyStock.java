package org.example;

/**
 * https://leetcode.com/problems/best-time-to-buy-nd-sell-stock/
 */
public class SellBuyStock {

	/**
	 * Brute force solution
	 * Time complexity : O(n2)
	 * Space complexity : O(1)
	 */
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;

		for(int i = 0; i < prices.length; i++) {
			for(int j = i+1; j < prices.length; j++) {
				int profit = prices[j] - prices[i];
				if (profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}

		return maxProfit;
	}

	/**
	 * One pass solution
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public static int maxProfitOptimal(int prices[]) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
			else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}

		}
		return maxProfit;
	}
	public static void main( String[] args )
	{

		int prices[] = {7,1,5,3,6,4};
		//System.out.println(maxProfit(prices));
		System.out.println(maxProfitOptimal(prices));
	}
}
