import java.util.*;
import java.io.*;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;


public class file
{

	private static final String fileDirection = "output.txt";
	static DSAlinkedL list = new DSAlinkedL();

 	public static void main(String[] args)
	{
   
		Scanner sc = new Scanner(System.in);
		int select = 0;
		
		do
		{

 			System.out.println("Select a choice.\n1 : Add item in the linkedlist.\n2 : Find item in the linkedlist.\n3 : Remove item from linkedlist.\n4 : check which item is in the linkedlist.\n5 : Insert linkedlist to file.\n6 : Importing linkedlist to program.\n7 : Exit program.\nInput your choice : ");

		select = sc.nextInt();
		
		//use case statement 
		
		switch (select)
		{
			
			case 1: 
				addingToLinkedlist();
				select = 0;
				break;
			
			case 2: 
				findItemLinkedlist();
				select = 0;
				break;

			case 3 :
				removeItemLinkedlist();
				select = 0;
				break;

			case 4 :
				displayItem();
				select = 0;	
				break;
	
			case 5 : 
				readSerialisedFile();
				select = 0;
				break;
			case 6 : 
				writeSerialisedFile();
				select = 0;
				break;
			case 7 :
		                System.out.println(" exit from program");
			  	select = 7;
			        break;
			default : 
				System.out.println(" Invalid selection ");
				break;
			}
		}while(select != 7);

	}

		
		/*case 1 -  method to add item in the linked list */
		public static void addingToLinkedlist()
		{
			Scanner sc = new Scanner(System.in);
			String value;
			int choose;
			System.out.println(" Insert a value : ");
			value = sc.nextLine();
			System.out.println( " Select number 5  : to insert in front of the linkedlist.\n select number 10  : to insert at the end of the linkedlist.\n Enter choice : ");
	                choose = sc.nextInt();
			if(choose == 5)
			{
                 		/*Insert value in front of the list*/
	                    	list.insertFirst(value);
			}
		        else if (choose == 10)
			{	/*Insert value in the end of linkedlist*/
			    	list.insertLast(value);
			}
			else
			{
			   	System.out.println("Invalid selection.\n");			   }
		}
		
		/* case 2 - method to find item in the linkedlist*/
		public static void findItemLinkedlist()
		{

			Scanner sc = new Scanner(System.in);
			String value;
			System.out.println(" Insert value to search in the linkedlist : ");
			value = sc.nextLine();
			list.find(value);
		}
		
		/* case 3 - method to remove item form linked list*/
		public static void removeItemLinkedlist()
		{
			Scanner sc  = new Scanner(System.in);
			int  select;
			System.out.println(" Insert 5 to delete from front.\n Insert 10 to delete at the end.\n Insert your choice : \n");
			select = sc.nextInt();
			if ( select == 5)
			{
				list.removeFirst();
			}
			else if (select == 10)
			{
				list.removeLast();
			}
			else
			{
				System.out.println("Invalid selection.\n");			   }
		}

		/* case 4 - method display the list in the linkedlist */
		public  static void displayItem()
		{
         		list.displayList();
		}
		/* case 5 - method to read a serialised file */
		public static void readSerialisedFile()
		{
			try 
			{
				FileInputStream f = new FileInputStream(fileDirection);
				ObjectInputStream object = new ObjectInputStream(f);
				list = (DSAlinkedL)object.readObject();
				System.out.println("read from file.\n");
				object.close();
			}
			catch ( Exception ex)
			{
			
				System.out.println(ex.getMessage());
			}
		 }	
		
		/* case 6 - method to write serialised file */
                public static void writeSerialisedFile()
		{
			try
			{
				FileOutputStream f = new FileOutputStream(fileDirection, false);
				ObjectOutputStream object = new ObjectOutputStream(f);	
				object.writeObject(list);
				
				object.close();
			}
			catch (Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
  }		
		
	        
