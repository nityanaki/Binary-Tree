//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;
import java.util.LinkedList;

public class BinarySearchTree
{
	private TreeNode root;

	public BinarySearchTree()
	{
		root = null;
	}

	public void add(Comparable val)
	{
		root = add(val, root);
	}

	private TreeNode add(Comparable val, TreeNode tree)
	{
	   /*if(tree == null)
			tree = new TreeNode(val);
		
		Comparable treeValue = tree.getValue();
		int dirTest = val.compareTo(treeValue);
		
		
		if(dirTest <= 0)
			tree.setLeft(add(val, tree.getLeft()));
		else if(dirTest > 0)
			tree.setRight(add(val, tree.getRight()));
		
		return tree;*/
		if (tree == null)
     		tree = new TreeNode(val, null, null);
   		else if (val.compareTo(tree.getValue()) < 0 )
     		tree.setLeft(add(val, tree.getLeft()));
  	    else if (val.compareTo(tree.getValue()) > 0 )
   			tree.setRight(add(val, tree.getRight()));
		return tree;

	}

   public void inOrder()
	{
		inOrder(root);
		System.out.println("\n\n");
	}

	private void inOrder(TreeNode tree)
	{
		if (tree != null){
			inOrder(tree.getLeft());
			System.out.print(tree.getValue() + " ");
			inOrder(tree.getRight());
		}
	}

	//add preOrder, postOrder, and revOrder
	
	
	public void preOrder()
	{
		preOrder(root);
		System.out.println("\n\n");
	}
	
	private void preOrder(TreeNode tree)
	{
		if (tree != null){
			System.out.print(tree.getValue() + " ");
			preOrder(tree.getLeft());
			preOrder(tree.getRight());
		}
	}
	
	public void postOrder()
	{
		postOrder(root);
		System.out.println("\n\n");
	}
	
	private void postOrder(TreeNode tree)
	{
		if (tree != null){
			postOrder(tree.getLeft());
			postOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
		}
	}
	
	public void revOrder()
	{
		revOrder(root);
		System.out.println("\n\n");
	}
	
	private void revOrder(TreeNode tree)
	{
		if (tree != null){
			revOrder(tree.getRight());
			System.out.print(tree.getValue() + " ");
			revOrder(tree.getLeft());
		}
	}
	
	


	public int getNumLevels()
	{
		return getNumLevels(root);
	}

	private int getNumLevels(TreeNode tree)
	{
		if(tree==null)
			return 0;
		else if(getNumLevels(tree.getLeft())>getNumLevels(tree.getRight()))
			return 1+getNumLevels(tree.getLeft());
		else
			return 1+getNumLevels(tree.getRight());
	}



	//add getNumLeaves, getWidth, getHeight, getNumNodes, and isFull

	public int getNumLeaves()
	{
		return getNumLeaves(root);
	}

	private int getNumLeaves(TreeNode tree)
	{
		if (tree!=null&&tree.getRight()==null&&tree.getLeft()==null)
			return 1;
		else if (tree!=null)
			return getNumLeaves(tree.getLeft()) + getNumLeaves(tree.getRight());
		else return 0;
	}
	
	public int getWidth()
	{
		return getWidth(root.getLeft()) + getWidth(root.getRight()) + 1;
	}

	private int getWidth(TreeNode tree)
	{
		if(tree==null)   
			return 0;
		else {
	      int numLeft = getWidth(tree.getLeft());
	      int numRight = getWidth(tree.getRight());
	      if(numLeft > numRight)
	         return 1 + numLeft; 
	      return 1 + numRight;
	  	 }
	}
	
	public int getHeight()
	{
		return getHeight(root)-1;
	}

	private int getHeight(TreeNode tree)
	{
		if(tree==null)   
			return 0;
		else {
	      int numLeft = getHeight(tree.getLeft());
	      int numRight = getHeight(tree.getRight());
	      if(numLeft > numRight)
	         return 1 + numLeft; 
	      return 1 + numRight;
	  	 }
	}	
		
	public int getNumNodes()
	{
		return getNumNodes(root);
	}

	private int getNumNodes(TreeNode tree)
	{
		if(tree==null)   
			return 0;
		else {
	      return 1 + getNumNodes(tree.getLeft()) + getNumNodes(tree.getRight());
	  	 }
	}	

	public boolean isFull()
	{
		return isFull(root);
	}
	
	private boolean isFull(TreeNode tree)
	{
		if (tree==null)
			return true;
		if (tree.getLeft()==null&&tree.getRight()==null)
			return true;
		if (tree.getLeft()!=null&&tree.getRight()!=null)
			return (isFull(tree.getLeft())&&isFull(tree.getRight()));
		return false;
	}

	
	//add extra credit options here - 10 points each
	
	//search
	
	//maxNode
	
	//minNode
	
	//level order
	
	//display like a tree
	
	//remove


	public String toString()
	{
		return toString(root);
	}

	private String toString(TreeNode tree)
	{
		if (tree!=null)
			return toString(tree.getLeft())+ " " + tree.getValue() + " " + toString(tree.getRight());
		return "";
	}
}