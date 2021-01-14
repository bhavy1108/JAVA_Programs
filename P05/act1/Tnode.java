
//reference: Seenrain.B.(2020- semester 1).DSA1/P05/Tnode.java[unpublished manuscript].Curtin Mauritius University


import java.util.*;
//class for TreeNODE

class Tnode
 {    
     //Declaring fields
     private String t_key;
     private int t_val;
     private Tnode t_leftChild;
     private Tnode t_rightChild;
  
 
     // Constructor 
    
  public Tnode(String inKey, int inValue)
  {
        if (inKey == null)
        throw new IllegalArgumentException("Key can't be null");
     
            t_key = inKey;
            t_val = inValue;
            t_leftChild   = null;
            t_rightChild = null;
     
  }
     // Constructor 
     public Tnode(int t)
     {
           t_leftChild = null;
           t_rightChild = null;
           t_val = t;
      }
     
     // setters
  
     public void setRight(Tnode t)
     {
        t_rightChild  = t;
     }
     
      public void setLeft(Tnode t)
     {
         t_leftChild  = t;
     }
    
     //getters
      
     public Tnode getRight()
     {
         return  t_rightChild;
     }
     
     public Tnode getLeft()
     {
         return  t_leftChild;
     }
     
     
     //get val to node
        public int getT_val()
     {
         return t_val;
     } 
     
         
    //set val to node
     public void setT_val(int s)
     {
         t_val = s;
     }
     
  
 }
 
