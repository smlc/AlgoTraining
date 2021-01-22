package org.example;

public class CountBit {

	public static  int hammingWeight(int n) {

		int bits = 0;
		int mask = 1;

		//Use a mask to get the least significant bit of any number.
		// Logical AND operation between 1 and any number give us the least significant bit
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				bits++;
			}
			mask <<= 1;
		}
		return bits;

	}

	public static void main( String[] args )
	{

		System.out.println(hammingWeight(31));

	}
}
