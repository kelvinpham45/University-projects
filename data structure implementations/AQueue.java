import java.util.Scanner;

public class AQueue {

	private int defaultSize = 5;
	private int maxSize;
	private int front;
	private int rear;
	private int[]listArray;
	
	//Constructors
	AQueue(){
		maxSize = defaultSize;
		rear = front = 0;
		listArray = (int[]) new int[maxSize];
	}
	
	AQueue(int size){
		maxSize = size;
		rear = front = 0;
		listArray = (int[]) new int[maxSize];
	}
	
	//Display the queue
	public void display() {
		System.out.print("The queue: ");
		for (int i = front; i < rear; i++) {
			System.out.print(listArray[i] + " ");
		}
		System.out.println("");
	}
	
	//Enqueue
	public void enqueue(int num) {
		assert maxSize == rear : "Queue is full\n";
		listArray[rear] = num;
		rear++;
		display();
	}
	
	//Dequeue
	public void dequeue() {
		assert front == rear : "Queue is empty\n";
		System.out.println("Dequeued element: " + listArray[front]);
		for(int i = 0; i < rear - 1; i++) {
			listArray[i] = listArray[i + 1];
			
			if (rear < maxSize) {
				listArray[rear] = 0;
			}
			rear--;
		}
		display();
	}
	
	//Print length of queue
	public void length() {
		System.out.println("Queue size: " + rear);
	}
	
	//Prints element at front of queue
	public void frontValue() {
		assert front == rear : "Queue is empty\n";
		System.out.println("Element at front of queue: " + listArray[front]);
	}
	
	//Prints element at the end of queue
	public void endValue() {
		assert front == rear : "Queue is empty\n";
		System.out.println("Element at end of queue: " + listArray[rear]);
	}
	
	//Commands for Array Queue
	public void arrayQueueCommands() {
		Scanner commandsInput = new Scanner(System.in);
		int commandsOption;
		
		do {
			System.out.println("\n 6. Display the queue. \n 7. Enqueue integer. \n 8. Dequeue. "
					+ "\n 9. Print length of queue. \n 10. Print front of queue. \n 11. Print end of queue \n 12. Exit menu.");
			System.out.println("Please enter the number of the command you want to perform: ");
			commandsOption = commandsInput.nextInt();
			
			while(commandsOption < 6 || commandsOption > 12) {
				System.out.println("Please choose a valid option");
				commandsOption = commandsInput.nextInt();
			}
			
			switch(commandsOption) {
			case 6:
				display();
				break;
			case 7:
				System.out.println("Please enter a number you want to enqueue: ");
				enqueue(commandsInput.nextInt());
				break;
			case 8:
				dequeue();
				break;
			case 9:
				length();
				break;
			case 10:
				frontValue();
				break;
			case 11: 
				endValue();
				break;
			case 12:
				System.out.println("Exited");
				break;
			}
			
		}while(commandsOption != 12);
		
		
	}
	
}
