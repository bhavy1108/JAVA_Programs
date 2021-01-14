import java.util.*;

public class towersofHanoi
{

  public static void main(String[] args)
  {
     Scanner c = new Scanner(System.in);
      int value;
 
       System.out.println("Insert a number of disks to perform Towers of Hanoi: ");
       value = c.nextInt();
       
    
          towersofHanoi(value, 'P', 'Q', 'R');// calling method towersHanoi
          
       
  }
   // method towers of hanoi
    public static void towersofHanoi(int value, char from_a_rod, char to_a_rod, char aux_rod)
    {
       //error condition
      if (value <= 0) 
      {
            throw new IllegalArgumentException("Negative input is not accepted"); 
      }
      // base 1
      if (value == 1) 
      {
           System.out.println("Move disk 1 from a rod " +from_a_rod + " to a rod " + to_a_rod);
           return;
      }
 
           towersofHanoi(value-1, from_a_rod, aux_rod, to_a_rod);
 
           System.out.println("Move disk " + value + " the from rod " + from_a_rod + " to the rod " + to_a_rod);

        towersofHanoi(value-1, aux_rod, to_a_rod, from_a_rod);
     }

  }
