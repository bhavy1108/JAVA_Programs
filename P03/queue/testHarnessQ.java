import java.util.*;
public class testHarnessQ
{
    public static void main(String [] args)
    {
	Scanner sc = new Scanner(System.in);
  
         
          int choose;
          int counter;
          int sizeOfNum;
          String ans;
          Object obj;
          
        System.out.println("Enter 1 : To Test Circular Queue.\n");
        System.out.println("Enter 2 : To Test shuffling Queue .\n");
        System.out.println("Enter 3 : To End the program.\n");
        System.out.println("Enter Your Choice:");
        choose= sc.nextInt();
	  do
          {    
              if (choose == 1)
	      {
	         //circular queue implementation	       
	       do
	       {      
		   System.out.println("Enter the sizeOfNum of the Queue: ");
                   sizeOfNum = sc.nextInt();
                   sc.nextLine();
		   System.out.println();
	       }  
	       while(sizeOfNum <= 0);
	       
	      //using an array                            
	       DsaCircularQ q = new DsaCircularQ(sizeOfNum);
	       
                //  for loop - loop to add  value in the queue 
	        for(int i = 0; i < sizeOfNum; i++)
                {
                 
                    System.out.println("Insert element:"); 
                   
                    ans = sc.nextLine();    
                    q.enqueue(ans); // add element in the queue
                   
                } 
                System.out.println(); 
	   // for loop - loop until values in the queue have been displayed using the FIFO strategy
       for(int j = 0; j < sizeOfNum; j++)
       {
          counter= q.getCounter();
          //remove element from the queue  
         
          obj= q.dequeue();                                                     
          System.out.println("The Value that is on the position " + counter+ " in the Queue is: " + obj);
            }
	       
	    System.out.println("\nA queue uses FIFO strategy to display its values.");
	   }
           else if (choose == 2)
           {
        
        
              do
	       {      
		   System.out.println("Enter the sizeOfNum of the Queue: ");
                   sizeOfNum = sc.nextInt(); 
                     sc.nextLine();
		    System.out.println();
	       }  
	       while(sizeOfNum <= 0);
	      
	       
	       //using an array                           
	        DsaShuffQ q = new DsaShuffQ(sizeOfNum);                           
		
	    //  for loop - loop to add  value in the queue 
	      for(int i = 0; i < sizeOfNum; i++)
              {
                  
                  System.out.println("Please input a value in the Queue: \n");
                  ans = sc.nextLine();    
                  q.enqueue(ans); // add element in the queue
               }
  
	      System.out.println(); 
	   //  FOR LOOP -loop until values in the queue have been displayed using the FIFO strategy
	    for(int j = 0; j < sizeOfNum; j++)
            {
                
         
               counter= q.getCounter();
              //remove element from the queue  
               obj=  q.dequeue();                                                     
               System.out.println(" Value that is on the position  " + counter+ " in the Queue is: " + obj);
            }
	       
	    System.out.println("\nA queue uses FIFO strategy to display its value.");
            
	   }
           else if (choose== 3)
          {
        
            System.out.println("End of program.\n Bye!\n GoodDay."); 
        
          }  //end of if statement
        
    }while((choose< 0)||(choose> 4)); //end of while loop 
 }
}
  
