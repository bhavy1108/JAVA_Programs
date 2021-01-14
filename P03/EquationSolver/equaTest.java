import java.util.*;

public class equaTest
{
   public static void main (String[] args)
   {
    
     String equa;
     equaSolver calcEqua = new equaSolver();
    
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter an equation to get its solution: \n");
     equa = sc.nextLine();
     
     System.out.println(calcEqua.solving(equa));
   }
}   
  
