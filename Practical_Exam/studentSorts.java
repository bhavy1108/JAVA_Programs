import java.util.*;
import java.io.*;

public class studentSorts
{
     public static void main(String[] args)
     {

        Scanner c = new Scanner(System.in);
        int s;
        s = recordNum();
        classStud[] student = new classStud[s];

        try  
         {
                String lines;
                int counter = 0;

                FileInputStream fileStream = new FileInputStream("RandomNames7000(2).csv");

                InputStreamReader rdr  = new InputStreamReader(fileStream);
          
                BufferedReader bufRdr = new BufferedReader(rdr);
          
                lines = bufRdr.readLine();
      
               while (lines != null)
               {
                    student[counter] = studentProcess(lines);

                  // reading next line from file
                    lines = bufRdr.readLine();

                   counter++;
                }

       }
       catch (Exception ex){}
   
     
       System.out.println("Choose the type of sorting algorithm: B = Bubblesort, I = Insertionsort, S = Selectionsort");
       Scanner sc =  new Scanner(System.in);       
       char Select = sc.next().charAt(0);

            
   switch(Select)
   {
     case'B': case 'b':
     bubbleSortFile(student);
     break;
    
     case'S': case 's':
     selectionSortFile(student);
     break;
     
     
     case'I': case 'i':
     insertionSortFile(student);
     break;
   
   
     default:
     System.out.println("Invalid Input");
     System.exit(0);
     break;
   } // end of switch statement 

  }


//this function will add all the sorting result in the SortingList.csv
 public static void addingFile(classStud[] studArray)
  {
     FileOutputStream ff = null;
     PrintWriter pt;

     try{
    
            ff = new FileOutputStream("SortingList.csv");
            pt = new PrintWriter(ff);
    
            for( int s = 0; s <  studArray.length; s++)
            {
               pt.println(studArray[s].toString());
            }
            pt.close();

        }catch(Exception ex){}

  }

 // bubbleSort function to read from csv and enable the sorting
  public static void bubbleSortFile(classStud[] studArray)
  {
         int i = studArray.length;
         boolean swaps;
      do
      {
         swaps = false;
         classStud temp = new classStud();
       
          for(int j = 0; j < i - 1; j++)
          {
             
		    if (studArray[j].getStudentId() > studArray[j + 1].getStudentId())
                     {
                         temp = studArray[j];
                         studArray[j] = studArray[j + 1];
                         studArray[j + 1] = temp;
                         swaps = true;
                      }
          }
  
     }while(swaps == true);

       for(int y = 0; y < i; y++)
       {

            System.out.println(studArray[y].toString());
       }  

         // calling functiom addingFile to add the result obtain the sorting is over the csv file.
          addingFile(studArray);
 }//eof bubblesort


 

    // Function insertionSort- it sorts accordindg to the values of the csv file and output the new answer in another csv file 
   public static void insertionSortFile(classStud[] studArray)
   {
   
       classStud sw = new classStud();
        int x = 0;
        for(x = 1; x < studArray.length; x++)
        {
             int y = x - 1;
             int num  = studArray[x].getStudentId();
             boolean swaps;
             swaps = true;
            while((y >= 0)&& (num < studArray[y].getStudentId() ))
            {

                studArray[y + 1] = studArray [y];

                studArray[y] = sw;
                 y = y - 1;

            }

        }
      for(int s = 0 ; s < x; s++)
      {
        System.out.println(studArray[s].toString());
       
      }

      System.out.println(studArray[studArray.length - 1]);

      addingFile(studArray);
	
  }//eof insertionSort()


  //function selectionSortFile 
  
   public static void selectionSortFile(classStud[] studArray)
   {

       classStud temp;
       int min;
       int min_pos;

       int t = 0;
       for(t = 0; t < studArray.length - 1; t++)
       {
          temp = new classStud();
          min = studArray[t].getStudentId();
          min_pos = t;

          int u = t;

           while( u < studArray.length - 1)
           {

              if(studArray[u + 1].getStudentId() < min)
              {

                    min_pos = u +1;
                    min = studArray[min_pos].getStudentId();
              }
              u++;
      
           }

          if (min_pos != t)  
          {
              temp = studArray[t];
              studArray[t] = studArray[min_pos];
            
              studArray[min_pos] = temp;

          }  
    }
   for (int s = 0; s < t; s++)
   {

       System.out.println(studArray[s].toString());
  
    }
    addingFile(studArray);

 }// eof selectionSortFile()




  public static int recordNum()
  {
      //numbers of recors in file to create array
       int counter = 0;

       try
       {
             String lines;
            // open file
            FileInputStream fileStream = new FileInputStream("RandomNames7000(2).csv");
              
            //enable reader to read from file
             InputStreamReader rdr = new InputStreamReader(fileStream);
        
            //reading one line at a time
           BufferedReader bufRdr = new BufferedReader(rdr);
     
           // reading first line
           lines = bufRdr.readLine();

           //while not eof
           while(lines != null) 
           {
               //increment counter
               counter++;

               //reading next line
               lines = bufRdr.readLine();
           }
           fileStream.close();
    
        }
        catch (Exception ex){}

        return counter;
  }


   public static classStud studentProcess(String lines)
   {
        String[] token = lines.split(",");
        int studentId = Integer.parseInt(token[0]);
        String studentName = token[1];
        classStud studObj = new classStud(studentId, studentName);

        return studObj;
   }
}
