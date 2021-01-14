public class TreeTest
{
	public static void main(String args[])
	{
			// put your code here

			DSABinarySearchTree bst = new DSABinarySearchTree();
			int addEven;

			bst.insert(60);
			bst.insert(20);
			bst.insert(80);
			bst.insert(6);
			bst.insert(38);
			bst.insert(70);


			System.out.println("\nThe nodes in the BST are displayed in recursive inorder traversal way:");
			
			bst.display(DSABinarySearchTree.root);
			
			System.out.println("\nThe sum of even nodes in the BST are displayed recursively.");
			
			addEven = bst.sumEvenValues(DSABinarySearchTree.root);
			
			System.out.println( "\nThe sum of even node are : " + addEven);
			
			
			
        
         }

	
}


