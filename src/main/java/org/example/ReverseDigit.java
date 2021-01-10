package org.example;

public class ReverseDigit {

	public static int reverse(int x) {

		int factor = 10;
		int result = 0;

		//!= to handle negatif and positif
		while(x != 0) {

			int lastDigit = x % factor;
			//Reduce X by factor and move digit to the left
			x /= factor;

			//Handling overflow
			if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && lastDigit > 7)) return 0;
			//Handling underflow
			if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && lastDigit < -8)) return 0;
			result = result * 10 +  lastDigit;


		}

		return result;
	}

	public static void main( String[] args )
	{
		System.out.println(reverse(4587));
	}
}
