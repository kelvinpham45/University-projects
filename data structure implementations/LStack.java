import java.util.Scanner;
public class LStack {

	public class Node{
		int data;
		Node link;
	}
	
	Node top;
	private int size;
	
	//Constructors
	LStack(){
		top = null;
		size = 0;
	}
	
	//Display the stack
	public void display() {
		if(top == null) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.print("The stack: ");
			Node temp = top;
			while(temp != null) {
				System.out.print(temp.data+ " ");
				temp = temp.link;
			}
		}
	}
	
	//Push integer onto stack
	public void push(int num) {
		Node temp = new Node();
		temp.data = num;
		temp.link = top;
		top = temp;
		size++;
		display();
	}
	
	//Pop top element and display it
	public void pop() {
		if(top == null) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Popped integer: " + top.data);
			top = top.link;
			size--;
		}
		display();
	}
	
	//Displays size of stack
	public void length() {
		System.out.println("Stack size: " + size);
	}
	
	//Displays the element at the top of the stack
	public void topValue() {
		if(top == null) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Top element of stack: " + top.data);
		}
	}
	
	//Commands for Array Linked List
		public void linkListStackCommands() {
			Scanner commandsInput = new Scanner(System.in);
			int commandsOption;
			
			do {
				System.out.println("\n 6. Display the stack. \n 7. Push element on the stack. \n 8. Pop the stack. "
						+ "\n 9. Print length of stack. \n 10. Print top value of stack. \n 11. Exit menu.");
				System.out.println("Please enter the number of the command you want to perform: ");
				commandsOption = commandsInput.nextInt();
				while(commandsOption < 6 || commandsOption > 11) {
					System.out.println("Please choose a valid option");
					commandsOption = commandsInput.nextInt();
				}
				
				switch(commandsOption) {
				case 6:
					display();
					break;
				case 7:
					System.out.println("Please enter a number you want to push: ");
					push(commandsInput.nextInt());
					break;
				case 8:
					pop();
					break;
				case 9:
					length();
					break;
				case 10:
					topValue();
					break;
				case 11:
					System.out.println("Exited");
					break;
				}
				
			}while(commandsOption != 11);
			
			
		}
}
