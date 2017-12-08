package ch.ffhs.dua.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Traverser-Klasse für Breitensuche.
 * EinTraerser besucht zuerst die Wurzel, dann die Kinder der Wurzel, dann die Enkel usw.
 *
 * @param <N>
 */
public abstract class BreadthFirstTraverser<N> 
{
	/**
	 * Methode zum Traversieren eines Baumes.
	 * @param node Wurzelknoten des Baumes.
	 */
	public void traverse(TreeNode<N> node) 
	{
		if(node ==  null) return;
		
		visitNode(node.value());
		Queue<TreeNode<N>> queue = new LinkedList<TreeNode<N>>();
		queue.addAll(node.children());
		
		while(!queue.isEmpty()){
			TreeNode<N> n = queue.poll();
			visitNode(n.value());
 
			for(int i = 0; i < n.children().size(); i++) {
				queue.add(n.children().get(i));
			}
		}
	}
	
	/**
	 * Diese Methode gibt an, was beim travsersieren gemacht werden sollte.
	 * @param value
	 */
	protected abstract void visitNode(N value);   
    
}   