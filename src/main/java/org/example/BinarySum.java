package org.example;

public class BinarySum {

	public static int getSum(int p, int q)
	{
		int result = p ^ q; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
		System.out.println(Integer.toBinaryString(result));

		int carry = (p & q) << 1; // 1+1=2
		System.out.println(Integer.toBinaryString(carry));

		if (carry != 0) {
			return getSum(result, carry);
		}
		return result;
	}

	public static void main( String[] args )
	{

		System.out.println(getSum(5, 7));
	}
}
