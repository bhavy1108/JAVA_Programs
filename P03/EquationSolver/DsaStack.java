public class DsaStack
{
    //class fields 
     private int counter;
     private static final int DEFAULT_CAP = 100;
      String[] s; // array s as double 


     //Default constructor - allocating array s with DEFAULT_CAP element and assigning count to 0 

    public DsaStack()
    {

      s = new String[DEFAULT_CAP];
      counter  = 0;

    }
    
    //Alternate constructor -  import maxcapacity - allocate array s with maxCap elements
    public DsaStack(int maxCap)
    {
 
       s = new String[maxCap];
       counter = 0;

    }

   //Accessors - import none export counter 

   public int getCounter()
   {

     return counter;

   }


   // method isEmpty() - checks if the stack is empty

   public boolean isEmpty()
   {
   
       boolean emp = true; 
      if (counter == 0)
      {

         emp = true;

      }

     else
      {

         emp = false;
      }
      return emp;

   }

  //Accesors isFull - checks if the stack is full.
   public boolean isFull()
   {

       boolean f = false;
      if (counter == s.length)
      {

         f = true;
      }
      else
      {
         f = false;
      }
     return f;
   }

   //ACCESSORS - top() - method that take a look at the first most item of the stack and leave it as it is.
   public String top()
   {
      String firstVal = "";
 
      if(isEmpty())
      {

         firstVal = "STACK IS EMPTY";

      }
      else 
      {

         firstVal = s[counter - 1];
     
      }
      return firstVal;
   }





   //Mutator - pop() method - it takes the top most item from the stack
   
   public String pop()
   {

      String firstVal = "";
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

  public void push(String value)
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
