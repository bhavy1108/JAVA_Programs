import java.util.*;

public class DsaCircularQ extends DsaQ
{
  // cannot create object in abstract class
     
  // Class Fields;
 
  private int counter;
  private int maxCap;
  private String[] q;
  private int firstPlace;
  private int lastPlace;

  
  //constant
  public static final int defaultCap = 100; 
    
      // DEFAULT Constructor
      public DsaCircularQ()
      {
      
          q = new String [defaultCap];
     
          counter = 0;
   
      }
      // ALTERNATE Constructor
      public DsaCircularQ(int maxCap) 
      {
      
          q = new String[maxCap];
          counter = 0;
      }
  
      //ACCESSOERS OR GETTERS
  
      //isFull()
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
  
      //getcounter()
      public int getcounter()
      {
     
           return counter;
      }
  
      //isEmpty()
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
  
      //peek()
       // check the  front item but do not take it off
     @Override
     public String peek()
     {
         String val = "";
     
         if(!isEmpty())
         {
         
           val = q[firstPlace];
     
         }
         else
         {
            System.out.println("The queue is empty.\n");
          
         }
   
        return val;
     }
 
      // SETTERS OR MUTATORS
  
       //dequeue(),remove element from the queue
     @Override
     public String dequeue()
     {
      
        String val = "0";
     
        if(!isEmpty())
        {
           val = peek();
           firstPlace++;
           counter--;
        }
       else
        {
               
           System.out.println("Queue is empty");
        }
      return val;
  
     }
 
  
    //enqueue()
    //add element to the queue
    @Override
    public void enqueue(String val)
    {
       if (!isFull())
       {
       
          q[lastPlace] = val;
          lastPlace++;
         
         if((lastPlace == q.length) && (firstPlace != 0))
         {
            lastPlace = 0;
         }
        
         counter = counter + 1;
       }
     
     }

}
