//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class BSTreeRunner
{
   public static void main( String args[] )
   {
 		//add test cases here
 		BinarySearchTree k = new BinarySearchTree();
 		k.add(90);
 		k.add(80);
 		k.add(100);
 		k.add(70);
 		k.add(85);
 		k.add(98);
 		k.add(120);
 		
 		System.out.println("IN ORDER ");
 		k.inOrder();
 		
 		System.out.println("PRE ORDER ");
 		k.preOrder();
 		
 		System.out.println("POST ORDER ");
 		k.postOrder();
 		
 		System.out.println("REV ORDER ");
 		k.revOrder();
 		
 		System.out.println("Tree height is " + k.getHeight());
 		System.out.println("Tree width is " + k.getWidth());
 		System.out.println("Number of leaves is " + k.getNumLeaves());
 		System.out.println("Number of nodes is " + k.getNumNodes());
 		System.out.println("The tree is full: " + k.isFull());
 		System.out.println("Tree as a string is " + k.toString());
 
   }
}