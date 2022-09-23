import java.util.Scanner;

public class LQueue {

	public class Node {
		int data;
		Node link;
	}
	
	Node front;
	Node rear;
	private int size;
	
	//Constructors
	public LQueue() {
		front = rear = null;
	}
	
	//Displays the queue
	public void display() {
		if(front == null) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.print("The queue: ");
			Node temp = front;
			while(temp != null) {
				System.out.print(temp.data+ " ");
				temp = temp.link;
			}
		}
	}
	
	//Enqueue
	public void enqueue(int num) {
		Node temp = new Node();
		temp.data = num;
		
		if(front == null) {
			front = rear = temp;
		}
		else {
			rear.link = temp;
			rear = temp;
		}
		display();
		size++;
	}
	
	//Dequeue
	public void dequeue() {
		if (front == null) {
			System.out.println("The queue is empty");
		}
		else {
			System.out.println("Dequeued element: " + front.data);
			front = front.link;
			display();
			size--;
		}
	}
	
	//Displays length of queue
	public void length() {
		System.out.println("Queue size: " + size);
	}
	
	//Displays element at front of queue
	public void frontValue() {
		if (front == null) {
			System.out.println("The queue is empty");
		}
		else
			System.out.println("Element at front of queue " + front.data);
		}
	
	//Displays element at end of queue
	public void endValue() {
		if (front == null) {
			System.out.println("The queue is empty");
		}
		else
			System.out.println("Element at end of queue " + rear.data);
		}
	
	//Commands for Linked List Queue
		public void linkedListQueueCommands() {
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
