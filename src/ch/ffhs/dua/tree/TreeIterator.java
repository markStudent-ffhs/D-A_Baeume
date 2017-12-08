package ch.ffhs.dua.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Ein Iterator, der in Depth-First Reihenfolge alle Werte der Knoten eines Baumes ausgibt.
 *
 * @param <N>
 */
public class TreeIterator<N> implements Iterator<N>
{
	
	Stack<TreeNode<N>> stack = new Stack<TreeNode<N>>();
	TreeNode<N> n;
	
	public TreeIterator(TreeNode<N> tree)
	{
		if(tree ==  null) return;
	
		stack.push(tree);
		n = stack.pop();
	}

	@Override
	public boolean hasNext() 
	{
		if(stack.isEmpty()) return false;
		
		return true;
	}

	@Override
	public N next() {
	
		TreeNode<N> current = n;
		for(int i = n.children().size(); i > 0; i--) {
			stack.push(n.children().get(i - 1));
		}
		if(hasNext()) {
			n = stack.pop();
		}
		
		return current.value();
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
