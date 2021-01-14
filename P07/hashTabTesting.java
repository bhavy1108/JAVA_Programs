/********************************************************
* Refence : Seenarain.B(2020).DSA/P10/practical 10.pdf
*********************************************************/

import java.util.Scanner;
import java.io.*; 
import java.math.*;
 
public class hashTabTesting
{
 public static void main(String[] args)
 {
  Scanner sc = new Scanner(System.in);
  
  char b; 
  int selection;
  
  System.out.println("Insert the size of the Table: ");
  HashTab hash = new HashTab(sc.nextInt() );
  
  do    
  {
   System.out.println("1 | Insert a Value and its Key.");
   System.out.println("2 | To find a key.");                       
   System.out.println("3 | Remove a Value and its Key.");   
   System.out.println("4 | Is Table is empty?");     
   System.out.println("5 | Deleting the Hash Table.");
   System.out.println("6 | Checking the Size of table .");
   System.out.println("7 | Files.");
   System.out.println("Insert your choice: ");
   selection = sc.nextInt();            
   
    
   switch (selection)
   {
    case 1:
    { 
    
    // to insert key and value in hash table 
     System.out.println("Insert a key and its value: ");
     hash.insertion(sc.next(), sc.nextInt() ); 
     
    }
    break;                          
     
    case 2:
    {                
      // to find key
     System.out.println("Insert the key to find:");
     System.out.println("The Value is  = "+ hash.get( sc.next() )); 
    }
    break;                        
     
    case 3:
    { 
    
     // to remove key  
     System.out.println("Insert the key to remove: ");
     hash.removeKey( sc.next() ); 
     
    }
    break;                                   
     
    case 4: 
    {
     // to check if table is full
     System.out.println("Is Empty: " +hash.isEmpty());
    }
    break;     
   
    case 5:
    { 
     // deleteing hash table 
     hash.makeEmpty();
     System.out.println("The Hash Table is empty\n");
    }
    break;
     
    case 6:
    { 
     // to check the size of table 
     System.out.println(" The Size of the table is = "+ hash.getSizes() );
    }
    break;         
    
    case 7:
    {
     //to read csv file 
     hash.readFile();
    }
    break;
    
    default: 
    {
     // invalid choice , error message 
     System.out.println("Invalid selection. \n ");
    }
    break;   
   }
   hash.displayingHashTab();   // display the hash table
 
   System.out.println("\nPress P or p to continue or any  alphabets to exit the program.) \n");
   b = sc.next().charAt(0);                        
  }
  while (b == 'P'|| b == 'p');  
 }
}
