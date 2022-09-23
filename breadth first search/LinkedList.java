
public class LinkedList <E> 
{
	public node<E> head;
	public node<E> tail;
	public int size;
	
	public void addHead(E data)								//add node to beginning of list
	{
		node<E> n = new node<E>(data);
		n.next = head;
		n.prev = null;
		
		if(head != null)									//if there is a head, put new node before it
		{
			head.prev = n;
		}
		
		head = n;
		
		if(tail == null)									//if there is no tail, set new node as tail
		{
			tail = n;
		}
		
		size++;
	}
	
	
	public void addTail(E data)								//add node at end of list
	{
		node<E> n = new node<E>(data);
		if(tail != null)									//if there is a tail, put new node behind it
		{
			tail.next = n;
		}
		
		tail = n;
		
		if(head == null)									//if there is no head, set new node as head
		{
			head = n;
		}
		
		size++;
	}
	
	
	public void addAfter(E data, node<E> prevNode)			//add a node after the node given
	{
		node<E> n = new node<E>(data);
		
		if(prevNode == null)
		{
			System.out.printf("Empty node");
			return;
		}
		
		if(prevNode.next != null)							//if given node has a next node set new node as the previous node of that next node
		{
			prevNode.next.prev = n;
		}
		
		n.next = prevNode.next;
		n.prev = prevNode;
		prevNode.next = n;
		
		size++;
	}
	
	
	public E removeHead()									//remove the node at the start of the list and return the data
	{
		E temp = head.data;
		
		if (head != null)
		{
			if(head.next == null)							
			{
				head = null;
				tail = null;
			}
			else 
			{
				head.next.prev = null;						//change head node to the next node and set new head node prev pointer to null
				head = head.next;
			}
		}
		
		size--;
		return temp;
	}
	
	
	public E get(int index)									//get the data from node at the index given
	{
		int count = 0;										//count to keep track position in list
		node<E> iterate = head;
		
		while(iterate != null)								//iterate through the list
		{
			if(count == index)								//if the current node matches the index given, return the data stored in the node
			{
				return iterate.data;
			}
			count++;
			iterate = iterate.next;
		}
		
		return null;
	}
	
	
	public int getSize()
	{
		return size;
	}
	
	
	public boolean isEmpty()								//if head is null, return true, else return false
	{
		return head == null;
	}
}