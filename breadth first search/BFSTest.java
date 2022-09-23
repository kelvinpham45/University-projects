import java.io.*;
import java.util.*;
public class BFSTest 
{
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<LinkedList> adjList = new ArrayList<LinkedList>();
		int v = readFile(adjList);
		printAdjList(adjList);
		System.out.printf("Select a starting node: ");
		bfs(adjList, v);
	}
	
	
	public static int readFile(ArrayList<LinkedList> adjList) throws FileNotFoundException
	{
		int v = 0;					//vertex count
		int e = 0;					//keeps track for when to move on to next node
		int node = 0;				//current node
		
		System.out.printf("Enter file name: ");
		String fileName = input.nextLine();
		File file =  new File(fileName);
		if(file.exists())
		{
			v = numVertices(fileName);
			createGraph(adjList, v);
			printGraph(adjList, fileName, v, e, node);
		}
		return v;
	}
	
	
	public static void bfs(ArrayList<LinkedList> adjList, int v)
	{
		boolean discovered[] = new boolean[v];											//creates an array to keep track of which vertices are discovered
		int s = input.nextInt();														//user input for starting node
		LinkedList queue = new LinkedList();
		queue.addTail(s); 																//add starting node to queue as starting point for the bfs
		discovered[s] = true;															//setting starting node as discovered
		int layer  = 0;
		int x = 0;
		System.out.printf("[BFS Tree] \n\n");
		while(!queue.isEmpty())															//queue is empty when all vertices are discoverd
		{
			s = (int) queue.removeHead();
			System.out.printf("Node %d: ", s);
			int y = adjList.get(s).getSize();											//size of the linked list
			while (x < y)
			{
				int k = (int) adjList.get(s).get(x);									//k is element in node x at index s of arraylist
				if(discovered[k] != true)												//if k was not discovered before
				{
					discovered[k] = true;
					System.out.printf("%d ", k);
					queue.addTail(k); 													//add vertex to queue to check adjacent vertices later
				}
				x++;
			}
			layer++;
			System.out.println();
			x = 0;
		}
	}
	
	
	public static int numVertices(String fileName) throws FileNotFoundException			//checks the number of vertices in the graph
	{
		int v = 0;
		File file = new File(fileName);													
		Scanner fileReader = new Scanner(file);
		while(fileReader.hasNextLine())
		{
			v++;
			fileReader.nextLine();
		}
		fileReader.close();
		return v;
	}
	
	
	public static void createGraph(ArrayList<LinkedList> adjList, int v)			//creates graph by adding linked list for each vertex
	{
		for(int i = 0; i < v; i++)
		{
			adjList.add(i, new LinkedList());
		}
	}
	
	
	public static void addEdge(ArrayList<LinkedList> adjList, int node, int e)		//adds edge between given node and node at position e
	{
		adjList.get(node).addTail(e); 
	}
	
	
	public static void printAdjList(ArrayList<LinkedList> adjList)					//prints the adjacency list
	{
		System.out.printf("[Adjacency List] \n\n");
		for(int i = 0; i < adjList.size(); i ++)									//iterates through the arraylist
		{
			System.out.printf("Node %d: ", i);
			for(int j = 0; j< adjList.get(i).getSize(); j++) 						//iterates through the linked list
			{
				System.out.printf("%d ", adjList.get(i).get(j));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void printGraph(ArrayList<LinkedList> adjList, String fileName, int v, int e, int node) throws FileNotFoundException
	{
		System.out.printf("[Graph] \n\n");
		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);
		while(fileReader.hasNextInt())
		{
			int edge = fileReader.nextInt();
			if(edge == 1)															//if 1, add an edge
			{
				System.out.printf("1 ");
				addEdge(adjList, node, e);
				e++;
			}
			else
			{
				System.out.printf("0 ");											//if 0 don't add edge
				e++;
			}
			if(e == v)																//move to next node when done checking
			{
				e = 0;
				node++;
				System.out.println();
			}
		}
		System.out.println();
		fileReader.close();
	}
}
