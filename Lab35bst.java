// Lab35bst.java
// The Binary Expression Tree Evaluation Program
// Student Version
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
public class Lab35bst
{
public static void main(String args[]) throws IOException
{
ExpressionNode root = ExpressionTree.createTree();
System.out.println("Original Tree");
System.out.println("=============");
System.out.print("\nIn-Fix Notation: ");
ExpressionTree.inOrderTraverse(root);
System.out.print("\n\nPre-Fix Notation: ");
ExpressionTree.preOrderTraverse(root);
System.out.print("\n\nPost-Fix Notation: ");
ExpressionTree.postOrderTraverse(root);
System.out.println("\n");
System.out.println("This tree has "+
ExpressionTree.operatorCount(root)+" operators and "+
ExpressionTree.numberCount(root)+" numbers, and evaluates to "+
ExpressionTree.evaluate(root)+"\n\n");
ExpressionNode mirrorRoot = ExpressionTree.mirror(root);

System.out.println("\nMirror Tree");
System.out.println("===========");
System.out.print("\nIn-Fix Notation: ");
ExpressionTree.inOrderTraverse(mirrorRoot);
System.out.print("\n\nPre-Fix Notation: ");
ExpressionTree.preOrderTraverse(mirrorRoot);
System.out.print("\n\nPost-Fix Notation: ");
ExpressionTree.postOrderTraverse(mirrorRoot);
System.out.println("\n");
System.out.println("This tree has "+
ExpressionTree.operatorCount(mirrorRoot)+" operators and "+
ExpressionTree.numberCount(mirrorRoot)+" numbers, and evaluates to "+
ExpressionTree.evaluate(mirrorRoot)+"\n");
}
}
class ExpressionNode
{
public ExpressionNode(double initNum, char initOpr, ExpressionNode initLeft, ExpressionNode
initRight)
{
num = initNum;
opr = initOpr;
left = initLeft;
right = initRight;
}
public double getNum() { return num; }
public char getOpr() { return opr; }
public ExpressionNode getLeft() { return left; }
public ExpressionNode getRight() { return right; }
public void setNum(int theNewNum) { num = theNewNum; }
public void setOpr(char theNewOpr) { opr = theNewOpr; }
public void setLeft(ExpressionNode theNewLeft) { left = theNewLeft; }
public void setRight(ExpressionNode theNewRight) { right = theNewRight; }
private double num;
private char opr;
private ExpressionNode left;
private ExpressionNode right;
}
class ExpressionTree
{
public static ExpressionNode createTree()
{
ExpressionNode n12 = new ExpressionNode(12,' ',null,null);
ExpressionNode n6 = new ExpressionNode( 6,' ',null,null);
ExpressionNode ndiv = new ExpressionNode( 0,'/',n12,n6);
ExpressionNode n7 = new ExpressionNode( 7,' ',null,null);
ExpressionNode nadd = new ExpressionNode( 0,'+',n7,ndiv);
ExpressionNode n2 = new ExpressionNode( 2,' ',null,null);
ExpressionNode n4 = new ExpressionNode( 4,' ',null,null);
ExpressionNode ncar = new ExpressionNode( 0,'^',n2,n4);
ExpressionNode n5 = new ExpressionNode( 5,' ',null,null);
ExpressionNode nsub = new ExpressionNode( 0,'-',ncar,n5);
ExpressionNode root = new ExpressionNode( 0,'*',nadd,nsub);
return root;
}
public static void inOrderTraverse (ExpressionNode p)
{
	if (p != null) {
        if (p.getLeft() != null && p.getRight() != null) { 
            System.out.print ("( ");
        }
        inOrderTraverse(p.getLeft());
        if (p.getOpr()==' ')
        		System.out.print(p.getNum() + " ");
        else 
        		System.out.print(p.getOpr() + " ");
        inOrderTraverse(p.getRight());
        if (p.getLeft() != null && p.getRight() != null) { 
            System.out.print (") ");
        }
    }

}
public static void preOrderTraverse (ExpressionNode p)
{
	if (p!=null)
	{
	if (p.getOpr()==' ')
		System.out.print(p.getNum() + " ");
	else
		System.out.print(p.getOpr()+" ");
	preOrderTraverse(p.getLeft());
	preOrderTraverse(p.getRight());
	}
}
public static void postOrderTraverse (ExpressionNode p)
{
	if (p!=null)
	{
	postOrderTraverse(p.getLeft());
	postOrderTraverse(p.getRight());
	if (p.getOpr()==' ')
		System.out.print(p.getNum() + " ");
	else
		System.out.print(p.getOpr()+" ");
	}
}
public static int numberCount (ExpressionNode p)
{
	if (p==null)
		return 0;
	if (p.getOpr()==' ')
		return 1+numberCount(p.getLeft())+numberCount(p.getRight());
	else
		return 0+numberCount(p.getLeft())+numberCount(p.getRight());
}
public static int operatorCount (ExpressionNode p)
{
	if (p==null)
		return 0;
	if (p.getOpr()!=' ')
		return 1+operatorCount(p.getLeft())+operatorCount(p.getRight());
	else
		return 0+operatorCount(p.getLeft())+operatorCount(p.getRight());
}
public static double evaluate (ExpressionNode p)
{
	if (p==null)
		return 0;
	if (p.getLeft()==null&&p.getRight()==null)
		return p.getNum();
	double leftval = evaluate(p.getLeft());
	double rightval = evaluate(p.getRight());
	if (p.getOpr()=='+')
		return leftval+rightval;
	else if (p.getOpr()=='-')
		return leftval-rightval;
	else if (p.getOpr()=='*')
		return leftval*rightval;
	else if (p.getOpr()=='^')
		return Math.pow(leftval,rightval);
	else //if (p.getOpr()=='/')
		return leftval/rightval;
}
public static ExpressionNode mirror(ExpressionNode p)
{
	ExpressionNode temp;
	if (p == null)
		return null;
	else
	{
		temp = new ExpressionNode(p.getNum(), p.getOpr(), null, null);
		temp.setLeft(mirror(p.getRight()));
		temp.setRight(mirror(p.getLeft()));
		return temp;
	}
}
}