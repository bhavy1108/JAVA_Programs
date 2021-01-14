
//reference: Seenrain.B.(2020- semester 1).DSA1/P05/BSTree.java[unpublished manuscript].Curtin Mauritius University


import java.util.Scanner;
 
 // Class BSTreeNode 
 
 class BSTreeNode
 {    
     BSTreeNode  t_left;
     BSTreeNode t_right;
     int t_data;
     
 
     // Constructor 
     
     public BSTreeNode()
     {
        t_left = null;
        t_right = null;
        t_data = 0;
     }
     
     public BSTreeNode(int s)
     {
        t_left = null;
        t_right = null;
        t_data= s;
     }
     
     //SETTERS
     
      // set right node  
     public void setRight(BSTreeNode s)
     {
        t_right = s;
     }
     
     // set left node 
     
     public void setLeft(BSTreeNode s)
     {
         t_left = s;
     }
     
    
     
     //GETTERS
     
      // get right node 
     public BSTreeNode getRight()
     {
         return t_right;
     }
     
     // get left node 
     public BSTreeNode getLeft()
     {
         return t_left;
     }
     
     //getter
     //get data from node
     public int getData()
     {
         return t_data;
     }     
     
      //setter
     // set data to node
     public void setData(int b)
     {
         t_data = b;
     }
     
     
 }
 
 // Class Binary Search Tree 
 class BSTree
 {
     private BSTreeNode t_root;
 
     //CONSTRUCTOR
     public BSTree()
     {
         t_root = null;
     }
     
     
     // method to validate if tree is empty
     public boolean isEmpty()
     {
         return t_root == null;
     }
     
     
     // Insert data in a tree
     public void insertion(int t_data)
     {
         t_root = insertion(t_root, t_data);
     }
     
     
    // Inserting t_data recursively
     private BSTreeNode insertion(BSTreeNode t_node, int t_data)
     {
         if (t_node == null)
         
             t_node = new BSTreeNode(t_data);
             
         else
         {
             if (t_node.getRight() == null)
             
                 t_node.t_right = insertion(t_node.t_right, t_data);
                 
             else
                 t_node.t_left = insertion(t_node.t_left, t_data);             
         }
         return t_node;
     }   
       
        
     //Method to find for an element in BSTree
     
     public boolean find(int t_value)
     {
     
         return find(t_root,t_value);
     
     }
     
     
     //Method to find for an element recursively
     
     private boolean find(BSTreeNode s, int value)
     {
           
            
            
         if (s.getData() == value)
         
              return true;
              
             
         if (s.getLeft() != null)
         
             if (find(s.getLeft(), value))
             
                 return true;
                 
                 
         if (s.getRight() != null)
         
             if (find(s.getRight(), value))
             
                return true;
                
      return false;      
         
     }
       
       
        
     //Counting number of nodes 
     public int counterNode()
     {
     
         return counterNode(t_root);
         
     }
     
     
     //Counting number of nodes recursively 
     private int counterNode(BSTreeNode w)
     {
         if (w == null)
         {
         
             return 0;
         }
         else
         {
             int p = 1;
             
             p = p + counterNode(w.getLeft());
             
             p = p + counterNode(w.getRight());
             
             return p;
         }
     }
     
    // activity 3 - To implement inorder traversal 
    
     // inorder traversal method
     
     public void inorderTraverse()
     {
         inorderTraverse(t_root);
       
     }
     
     //method to perform in order traversal
     private void inorderTraverse(BSTreeNode l)
     {
         if (l != null)
         {
            inorderTraverse(l.getLeft());
            
             System.out.print(l.getData() +" ");
             
            inorderTraverse(l.getRight());
         }
     }
     
    
     
     
     // preorder traversal method
     public void preorderTraverse()
     {
       
        preorderTraverse(t_root);
        
     }
     
     //method to perform preorder traversal
     private void preorderTraverse(BSTreeNode l)
     {
         if (l != null)
         {
             System.out.print(l.getData() +" ");
             
             preorderTraverse(l.getLeft());   
                      
             preorderTraverse(l.getRight());
         }
     }
     
      
      //postorder traversal method
     public void postorderTraverse()
     {
     
        postorderTraverse(t_root);
        
     }
     
     //method to perform post order traversal
     private void postorderTraverse(BSTreeNode l)
     {
         if (l != null)
         {
            postorderTraverse(l.getLeft());  
                        
            postorderTraverse(l.getRight());
             
             System.out.print(l.getData() +" ");
         }
     
    
    
     }     
 }
 
