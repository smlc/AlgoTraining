package org.example;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthese {

	/**
	 *
	 * Runtime : O(n)
	 * Space : O(n)
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		HashMap<Character, Character> mappings= new HashMap<>();
		mappings.put(')', '(');
		mappings.put('}', '{');
		mappings.put(']', '[');

		for (int i = 0; i <s.length(); i++) {

			char character = s.charAt(i);

			// If it's a closed bracket
			if (mappings.containsKey(character)) {
				char topElement = stack.empty() ? '#' : stack.pop();

				// The open bracket we want should be at the top of the stack if not return false.
				if (topElement != mappings.get(character))  return false;
			}else {
				stack.push(character);
			}

		}
		return stack.isEmpty();
	}

	/**
	 * Use array as stack.
	 * Space
	 * @param s
	 * @return
	 */
	public static boolean isValidWithArray(String s) {
		char[] stack = new char[s.length()];
		int head = 0;
		for(char c : s.toCharArray()) {
			switch(c) {
				case '{':
				case '[':
				case '(':
					stack[head++] = c;
					break;
				case '}':
					if(head == 0 || stack[--head] != '{') return false;
					break;
				case ')':
					if(head == 0 || stack[--head] != '(') return false;
					break;
				case ']':
					if(head == 0 || stack[--head] != '[') return false;
					break;
			}
		}
		return head == 0;

	}
	public static void main( String[] args ) {
		System.out.println(isValid("(){}}{"));
	}
}
