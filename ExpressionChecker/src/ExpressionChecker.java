public class ExpressionChecker {


	private static Character getReverseChar(Character c) {
		switch (c) {
		case '{':
			return '}';
		case '}':
			return('{');
		case '[':
			return(']');
		case ']':
			return('[');
		case '(':
			return(')');
		case ')':
			return('(');
			
		}
		return null;
	}

	public static void main(String[] args) {

		String sample = "[({(})])";

		Stack stack = new Stack();
		for (int i = 0; i < sample.length(); i++) {			
			if (stack.isStackEmpty()) {
				stack.push(getReverseChar(sample.charAt(i)));
			}else if (stack.getLastElement() == sample.charAt(i)) {
				stack.pop();
			} else {
				stack.push(getReverseChar(sample.charAt(i)));
			}
		}

		if (stack.isStackEmpty()) {
			System.out.println("Correct Expression");
		} else {
			System.out.println("Not Correct Expression");
		}

	}
}
