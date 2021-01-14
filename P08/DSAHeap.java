
//reference: Seenrain.B.(2019- semester 2).DSA1/P08/DSAHeap.java[unpublished manuscript].Curtin Mauritius University

import java.io.*;
import java.util.*;

	class Node
	{
 		private int info;
 
 		public Node(int key)
 		{
 			 info = key;
 		}

        public int keyObtain()
        {
                 return info;
        }

        public void putKey(int name)
        {
                info = name;
        }
      }

      class Heap
      {
         private Node[] HeapArr;
         private int finalCapacity;          
         private int contemporaryCapacity;       

         public Heap(int fc) 
         {
            
            finalCapacity = fc;
            contemporaryCapacity = 0;
            HeapArr = new Node[finalCapacity];
         }

     public boolean isEmpty()
     {
        
            return contemporaryCapacity == 0;
     }

    public boolean insert(int key)
    {
  
        if(contemporaryCapacity == finalCapacity)
        {
  
            return false;
 
        }
  
  
        Node newNode = new Node(key);
 
        HeapArr[contemporaryCapacity] = newNode;
  
        trickleUp(contemporaryCapacity++);
  
        return true;
 
    }  
 
 

 
    public boolean changes(int location, int valNew)
    {
 
           if(location < 0 || location >= contemporaryCapacity)
           {
        
               return false;
           }     
  
      int valOld = HeapArr[location].keyObtain();
      HeapArr[location].putKey(valNew);

     if(valOld < valNew)             
     {

             trickleUp(location);               
     }
     else                                
     { 
       
            trickleDown(location);              
     }
     return true;
 
    }
 
    public Node removeNode()           
    {                           
        
         Node root = HeapArr[0];
         HeapArr[0] = HeapArr[--contemporaryCapacity];
         trickleDown(0);
  
         return root;
    }
   // trickle down method
   public void trickleDown(int location)
   {
      int large;
      Node up = HeapArr[location];      
 
     while(location < contemporaryCapacity/2)     
     {                               
  
          int left = 2*location+1;
          int right = left+1;
                                          
     if(right < contemporaryCapacity && HeapArr[left].keyObtain() < HeapArr[right].keyObtain())
     {
   
          large = right;
     } 
    else
    {

         large = left;
    }                                      
    if( up.keyObtain() >= HeapArr[large].keyObtain() )
    { 

        break;
    }                                      
  
       HeapArr[location] = HeapArr[large];
       location = large;           
    }  
     HeapArr[location] = up;            


    }
 // trickleUp   method
 public void trickleUp(int location)
 {
  
     int parent = (location-1) / 2;
     Node down = HeapArr[location];

    while( location > 0 && HeapArr[parent].keyObtain() < down.keyObtain() )
    {
        
        HeapArr[location] = HeapArr[parent];
        location = parent;
         parent = (parent-1) / 2;
    }  
 
     HeapArr[location] = down;
 
}  

// method display the heap 
 public void displayHeap()
 {
  
     System.out.print("HeapArr: ");
  
     for(int m = 0; m < contemporaryCapacity; m++)
     {
   
        if(HeapArr[m] != null)
        { 
    
              System.out.print( HeapArr[m].keyObtain() + " ");
        }
         else
        {
             System.out.print( "-- ");
        } 
     }
     System.out.println();                                      
  
        int valNull = 35;
        int itemRow = 1;
        int column = 0;
        int buffer = 0;                         
        String slash = "---------------------------------";
        System.out.println(slash + slash); 

         while(contemporaryCapacity > 0)
         {
  
              if(column == 0)                  
              {
            
                for(int k = 0; k < valNull; k++)  
                {
        
                        System.out.print(' ');
                }                                  
         } 
  
         System.out.print(HeapArr[buffer].keyObtain());

  
         if(++buffer == contemporaryCapacity) 
         {

            break;
         }
   
        if(++column == itemRow)        
        {
   
            valNull /= 2;                
            itemRow *= 2;             
            column = 0;                   
            System.out.println();       
        }
        else                        
        { 
    
             for(int k = 0; k < valNull*2-2; k++)
             {
     
                 System.out.print(' ');     
             }
     }
     }
        System.out.println("\n"+slash+slash);
    }
}

class DSAHeap
{
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        
        boolean try;
        char choice;
        int a, b;
        int selection, num;
        int heapSize;
   
     System.out.println("Enter the heap size: ");
     heapSize = sc.nextInt();

    Heap theHeap = new Heap(heapSize);
  
  do
  {

     System.out.println("Press 1 to enter values or 2 to stop inputting. ");
    selection = sc.nextInt();
   
     if(selection == 1)
     {
   
         System.out.println("Enter a number.");
         num = sc.nextInt();
         theHeap.insert(num);
     }
  
  }
  while(selection != 2);

  do
  {

        System.out.println("Press D to show the heap. ");
        System.out.println("Press I to insert a new value. ");
        System.out.println("Press X to removeNode the top value. ");
        System.out.println("Press C to change a value. ");
        System.out.println("Press E to Exit. ");
   
         choice = sc.next().charAt(0);
    
        switch(choice)
        {
            case 'd': case 'D':              
            {
     
                theHeap.displayHeap();
            } 
            break;     
            case 'i':  case 'I':                  
            {
     
               System.out.print("Enter a value to add in the heap: ");
               a = sc.nextInt();
               try = theHeap.insert(a);
      
                if(!try)
                {
     
                       System.out.println("The heap is full. Insertion is cancelled.");
                }
   
        }
        break;
        case 'x': case 'X':                
        {
     
               if( !theHeap.isEmpty() )
                {  
            
                    theHeap.removeNode();
                } 
                else
                {
     
                   System.out.println("The heap is empty!. Removal is cancelled.");
                } 
        }
        break;
     
        case 'c': case 'C':               
        {
     
               System.out.print("Enter the current location of the item: ");
               a = sc.nextInt();
               System.out.print("Enter a new key: ");
               b = sc.nextInt();
               try = theHeap.changes(a, b);
      
               if(!try)
               {
            
                   System.out.println("A wrong location");
           
               } 
       
         }
         break;
    
         case 'e': case 'E':               
         {
     
                System.out.println("Exiting the program. ");
                System.exit(0);
          
         }
        break;
      
        default:
        {   
     
            System.out.println("The choice is wrong.\n");
        }
    
    } 
  
  }
    while((choice != 'e') || (choice != 'E'));
 
}

}
