/**
 * DSA Final Assessment Question 1 - DSABinarySearchTree.java
 *
 * Name : seenarain bhavyattaa
 * ID   :19871253
 *
 **/

public class DSABinarySearchTree {   
	// Inner class TreeNode
	private class TreeNode {
		public int value;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int inVal)
		{
			value = inVal;
			left = null;
			right = null;
		}
	}
	// Class BinaryTree
	static TreeNode root;
	
	public DSABinarySearchTree()
	{
		root = null;
	}
	
	public void insert(int val)
	{
		if (isEmpty())
		{
			root = new TreeNode(val);
		}
		else
		{
			root = insertRec(val, root);
		}
	}

	public Boolean isEmpty()
	{
		return root == null;
	}

	private TreeNode insertRec(int inVal, TreeNode cur)
	{
		if (cur == null)
		{
			cur = new TreeNode(inVal);
		}
		else
		{
			if (inVal < cur.value)
			{
				cur.left = insertRec(inVal, cur.left);
			}
			else	
			{
				cur.right = insertRec(inVal, cur.right);
			}
		}
		return cur;
	}
	
	// method to diaplay the BST 
	void display (TreeNode  root)
	{
		if ( root != null )
		{

			//traverse left subtree of the BST
			display(root.left);
			System.out.println(root.value + "" );											
			//thus traverse right subtree of the BST
			display(root.right);

		}		

	}

	//method sumEvenValues - it will add all the even node found in the grap and display it
	// wrapper to start off at root
	public int sumEvenValues()
	{
	
		return sumEvenValues(root);
	}
	
	// recursive method of sumEvenValues
	public int  sumEvenValues(TreeNode root)
	{
	
		int addEven = 0;
		if (root != null)
		{
			// check for even node in BST
			if(root.value % 2 == 0)
			
			 	addEven = root.value;
			 	
			 	addEven = 
			 	addEven + sumEvenValues(root.left);
			 	
			 	addEven = 
			 	addEven + sumEvenValues(root.right);
			 	
		}
		      
	        return  addEven;
						

		}
	}	
  		
			 	
			
	
	


