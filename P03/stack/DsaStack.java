public class DsaStack
{
    //class fields 
     private int counter;
     private static final int DEFAULT_CAP = 100;
     private double[] s; // array s as double 


     //Default constructor - allocating array s with DEFAULT_CAP element and assigning count to 0 

    public DsaStack()
    {

      s = new double[DEFAULT_CAP];
      counter  = 0;

    }
    
    //Alternate constructor -  import maxcapacity - allocate array s with maxCap elements
    public DsaStack(int maxCap)
    {
 
       s = new double[maxCap];
       counter = 0;

    }

   //Accessors - import none export counter 

   public int getCounter()
   {

     return counter;

   }


   // method isEmpty() - checks if the stack is empty

   private boolean isEmpty()
   {
   
       boolean empty = true; 
      if (counter == 0)
      {

         empty = true;

      }

     else
      {

       empty = false;
      }
      return empty;

   }

  //Accesors isFull - checks if the stack is full.
   private boolean isFull()
   {

       boolean full = false;
      if (counter == s.length)
      {

       full = true;
      }
      else
      {
         full = false;
      }
     return full;
   }

   //ACCESSORS - top() - method that take a look at the first most item of the stack and leave it as it is.
   public String top()
   {
      String firstVal;
 
      if(isEmpty())
      {

         firstVal = "STACK IS EMPTY";

      }
      else 
      {

         firstVal = Double.toString(s[counter - 1]);
     
      }
      return firstVal;
   }





   //Mutator - pop() method - it takes the top most item from the stack
   
   public String pop()
   {

      String firstVal;
      if (!isEmpty())
      {
      
       //top() - method look at the top most item and do nothing 
        firstVal = top() ;
        counter--;
      }
     else
     {

       firstVal = "THE STACK IS EMPTY";
     }
     return firstVal;
   }  


  //Mutator - push IMPORT value EXPORT none 
  // push() method - add new item to the top of the stack

  public void push(double value)
  {

     if(isFull())
     {
       System.out.println("THE STACK IS FULL.\n");
      
     }
    else
     {
      
        s[counter] =  value;
        counter++;
       
     }
  }


}
