
//reference: Seenrain.B.(2020- semester 1).DSA1/P05/BSTreeTestHarness.java[unpublished manuscript].Curtin Mauritius University


import java.util.*;

public class BSTreeTestHarness
 {
     public static void main(String[] args)
     {   
       Scanner sc = new Scanner(System.in);
        
        //Creating object of BSTree 
        
        BSTree bst = new BSTree(); 
        
       
        char w;  
              
        do    
        {
            System.out.println("\nThis program will perform Binary Search Tree. \n Please make a choice: \n1: To insert in the tree.\n2: To check if tree is empty.\n3: To count  the number of nodes.\n4: To find the element in the tree. \n5: To end the program.\n\n Enter your choice: ");
            
            int a = sc.nextInt();            
            switch (a)
            {
            
            case 1 : 
            
                System.out.println("PLease enter an int value you want to insert the tree which will also traverse the tree:  ");
                
                bst.insertion( sc.nextInt() );  
                                   
                break; 
                                         
            case 2 : 
            
               
                System.out.println(" true: means that the tree is empty.\n false :means that the tree is empty.\n Answer is :  "+ bst.isEmpty());
                
                break; 
                                             
            case 3 : 
            
                System.out.println("Number of nodes in the tree are:   "+ bst.counterNode());
                
                break;   
                  
            case 4 : 
            
               
                System.out.println("PLease enter the int value you want to search in in the tree:  ");
                
                System.out.println("Find item is : " + bst.find(sc.nextInt()));
                
                break; 
            
            
                           
            default : 
            
                System.out.println("End of program.\nGoodBye.\n ");
                
                break;   
            }
            
           // we will display the tree
           
            System.out.println();
            
            System.out.println("Displaying the tree and traversing it in post order, in order and pre order.\n");
            
            System.out.println("\nPost order implementation:  ");
            
            bst.postorderTraverse();
            
            System.out.println("\nIn order implementation:  ");
            
            bst.inorderTraverse();
            
            System.out.println("\nPre order implementation:  ");
            
            bst.preorderTraverse();
 
            System.out.println("\n\n If you want to continue : \nPress (Type y or Y ) else  (S or s) to stop.\n");
            
            w = sc.next().charAt(0); 
                                   
        } while (w == 'Y'|| w == 'y');               
    }
 }
