import java.util.*;


class DSAHeapTest
{
    public static void main(String[] args)
    {
    
        Scanner sc = new Scanner(System.in);
        
        boolean flag;
        char choice;
        int a, b;
        int selection, num;
        int heapSize;
   
     System.out.println("Enter the heap size: ");
     heapSize = sc.nextInt();

    DSAHeapTest theHeap = new DSAHeapTest(heapSize);
  
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
             flag = theHeap.insert(a);
      
                if(!flag)
                {
     
                       System.out.println("The heap is full. Insertion is cancelled.");
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
