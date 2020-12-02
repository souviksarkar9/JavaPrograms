public class Stack {

	Character[] element;
	int top;

	Stack() {
		element = new Character[100];
		top = 0;
	}

	public boolean isStackEmpty() {
		return top == 0 ? true : false;
	}

	public void push(Character c) {
		element[top++] = c;
	}

	public Character getLastElement() {
		return element[top-1];
	}

	public void pop() {
		top--;
	}

}
