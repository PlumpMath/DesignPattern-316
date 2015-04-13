import java.util.*;
import java.io.*;

class Connection{

	int value=1;

	private static int count = 1;
	private static int size = 10;
	private static int start = 0;
	private static int end = 0;
	private static Connection tmp;
	
	private Connection()
	{
		this.value = count++;
	}

	private static Connection[] array = new Connection[size+1]; 

	public static Connection makeConnection()
	{
		return new Connection();	
	}

	public static Connection[] accessConnectionArray()
	{
		return array;		
	}

	public static boolean isEmpty()
	{
		return start==end;
	}
	
	public static boolean isFull()
	{
		return ( (end+1)%(size+1) ) == start;
	}

	public static void push(Connection conn)
	{
		try{
			if(isFull()){
				System.out.println("Connection isFull");
				return ;
			}else{
				array[end] = conn;
				end = (end + 1)%(size + 1);
				return ;
			}
		}catch(Exception e){}
	}

	public static Connection pop()
	{
		try{
			if(isEmpty()){
				return null;
			}else{
				tmp = array[start];
				start = (start + 1) % (size + 1);
				return  tmp;
			}
		}catch(Exception e){
			return null;
		}
	}
	
	public static int maxsize()
	{
		return size;
	}

	public static int size()
	{
		return end-start;
	}
	
	public static void printArray()
	{
		if(isEmpty()){
			System.out.println("Array isEmpty");
		}else{
			for(int i=start;i!=end;i = (i+1) % (size+1)){
				System.out.print(array[i].value + " ");
			}
			System.out.print("\n");
		}
	}

}

public class ConnectionManager{

	//this is not a singleton pattern 
	//because we use a private static array and we had only one copy in memory
	//the singleton pattern should offer us only one reference of Connection class
	//code should be like this:
	//class Connection{
	//	private static Connection conn = new Connection();
	//	private Connection(){}
	//	public staic Connection access()
	//	{
	//		return conn;
	//	}
	//}
	//here,we forbid others to use constructed function and we will have only one copy of Connection  Class in my memmory
	//this is the Singleton Pattern
	
	private static Connection[] array = Connection.accessConnectionArray();

	public static void main(String[] args)
	{
		for(Connection x : array){		
			Connection.push(Connection.makeConnection());
		}	
		Connection.printArray();
		Connection.pop();
		Connection.printArray();
		Connection.push(Connection.makeConnection());
		Connection.printArray();
	}
}