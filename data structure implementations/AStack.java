import java.util.Arrays;
import java.util.Scanner;
public class AStack {
	
	private int defaultSize = 5;
	private int maxSize;
	private int top;
	private int[] listArray;
	
	//Constructors
	AStack(){
		maxSize = defaultSize;
		top = 0;
		listArray = (int[]) new int[maxSize];
	}
	
	AStack(int size){
		maxSize = size;
		top = 0;
		listArray = (int[]) new int[size];
	}
	
	//Display the stack
	public void display() {
		System.out.print("The stack: ");
		for(int i = top; i>0; i--) {
			System.out.print(listArray[i] + " ");
		}
		
		System.out.println("");
	}
	
	//Push elements onto stack
	public void push(int num) {
		assert top != maxSize : "Stack is full\n";
		listArray[top+1] = num;
		top++;
		display();
	}

	//Pop top element and displays it
	public void pop() {
		assert top != 0 : "Stack is empty\n";
		System.out.println("Popped integer: " + listArray[top]);
		top--;
		display();
	}
	
	//Displays stack size
	public void length(){
		System.out.println("Stack size: " + top);
	}
	
	//Displays the top element of the stack
	public void topValue() {
		assert top != 0 : "Stack is empty\n";
		System.out.println("Top element of stack: " + listArray[top]);
	}
	
	//Commands for Array Stack
	public void arrayStackCommands() {
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
