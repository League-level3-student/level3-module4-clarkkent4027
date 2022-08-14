package _01_TestMatchingBrackets;

import java.util.Iterator;
import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {
		Stack<String> brack = new Stack<String>();

		
		for (int i = 0; i < b.length(); i++) {
			if ((b.substring(i, i + 1).equals("{"))) {
				brack.push("{");
			} else if(b.substring(i, i + 1).equals("}") && brack.isEmpty()) {
				return false;

			}else if (b.substring(i, i + 1).equals("}")) {
				brack.pop();

			}
		}
		if (brack.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}
}