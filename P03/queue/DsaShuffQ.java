import java.util.*;
 public class DsaShuffQ extends DsaQ
 {
  
   // Class Fields;
   private String[] q;
   private int counter;
   private int front;
   private int rear;
   private int maxCap;
  
  //constant
  public static final int defaultCap = 100; 
  
   //DEFAULT Constructor
   public DsaShuffQ()
   { 
      q = new String[defaultCap];
      rear = counter = front = 0;
   }
   //ALTERNATE Constructor
   public DsaShuffQ(int maxCap)
   {
       q = new String[maxCap];
       front = 0;
       rear = 0;
       counter = 0;
   }
   //ACCESSOERS OR GETTERS
   //isFull()
   @Override
   public boolean isFull()
   {  
       boolean full;
       if (counter != q.length)
       {
          full = false;
       }
       else
       {
          full = true;
       }
       return full;
    }
    //isEmpty()
    @Override
    public boolean isEmpty()
    {  
        boolean empty;
        if (counter != 0)
        {
           empty = false;
        }
        else
        {
          empty = true;
        }
        return empty;
    }
    //getcounter()
    
    public int getcounter()
    {
       return counter;
    }
  
     //peek()
    // check the  front item but do nothing
    // shuffling occur
    @Override
    public String peek()
    {
        String ans = "";
        if (!isEmpty())
        {
              ans = q[0];
          
            
        }
        else 
        {
          
         System.out.println("The queue is emptty.\n");
         
        } 
        return ans;    
     }
    
     //SETTERS OR MUTATORS
  
     //dequeue()
     //remove element from the shuffling queue
    @Override
    public String dequeue()
    { 
        String answer = "";
        if (isEmpty())
        {


           answer =  "The queue is emptty.";

        }
        else 
         {

          // shuffle to the right by one 
          answer = peek();
          
          for (int i = 0; i < rear - 1; i++) 
          { 
              q[i] = q[i + 1]; //shuffling
          } 

         } 
           return answer;
       }
         
  
        
      //enqueue()
      //add element to the queue
     @Override
     public void enqueue(String val)
     {
       
        //check if queue is full
       if (!isFull())
       
        {
             
           //NOT FULL so increment counter by 1
           counter = counter + 1;
           q[rear] = val;// store element at q[rear]
           rear = (rear + 1) % defaultCap;
          
        }
        else
         {  
            System.out.println("The queue is full.\n"); 
          
         }
       
       

     }
}

