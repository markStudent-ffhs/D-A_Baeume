package ch.ffhs.dua.tree;

import java.util.Stack;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 * Diese Implementierung verwendet keine Rekursion, sondern einen Stack.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserStack<N> 
{

	public void traverse(TreeNode<N> node) 
	{
		if(node ==  null) return;
		Stack<TreeNode<N>> stack = new Stack<TreeNode<N>>();
		stack.push(node);
		
		while(!stack.empty()){
			TreeNode<N> n = stack.pop();
			visitNode(n.value());
 
			for(int i = n.children().size(); i > 0; i--) {
				stack.push(n.children().get(i - 1));
			}
		}
	}
	
	/**
	 * Operation auf einem Knoten bei der Traversierung; die Operation wird durchgeführt,
	 * bevor die Nachkommen besucht werden.
	 * @param value
	 */
	abstract protected void visitNode(N value);   

}   