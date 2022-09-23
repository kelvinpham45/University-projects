import java.util.Scanner;
public class ArrayLinkedListStackQueueTest {
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		
		AStack arrayStack = new AStack();
		AQueue arrayQueue = new AQueue();
		LStack linkedStack = new LStack();
		LQueue linkedQueue = new LQueue();
		
		int userOption;
		do {
			System.out.println("1. Implementing Stack Using Array.\n2. Implementing Stack Using Link List\n"
				+ "3. Implementing Queue Using Array\n4. Implementing Queue Using Linked List\n5. Exit the Testing");
			userOption = input.nextInt();
			while(userOption < 1 || userOption > 5) {
				System.out.println("Please choose a valid option");
				userOption = input.nextInt();
			}
			
			switch(userOption) {
				case 1: 
					arrayStack.arrayStackCommands();
					break;
				case 2:
					linkedStack.linkListStackCommands();
					break;
				case 3:
					arrayQueue.arrayQueueCommands();
					break;
				case 4: 
					linkedQueue.linkedListQueueCommands();
					break;
				case 5:
					System.out.println("Exited");
					break;
			}
			
		} while(userOption != 5);
		
		input.close();
	}
}
