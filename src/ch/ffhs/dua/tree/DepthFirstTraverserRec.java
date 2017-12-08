package ch.ffhs.dua.tree;

/**
 * Klasse zum Traversieren eines Baumes mit Tiefensuche.
 *
 * @param <N>
 */
public abstract class DepthFirstTraverserRec<N> 
{

	
	public void traverse(TreeNode<N> node) 
	{
		
		if(node == null) return;
		
		preOperation(node.value());
		
		for(int i = 0; i < node.children().size(); i++) {
			traverse(node.children().get(i));
		}
		
		postOperation(node.value());
	}
	
	/**
	 * Operation auf einem Knoten, bevor die NAchkommen besuchr wurden.
	 * @param value
	 */
	abstract protected void preOperation(N value);
    
	/**
	 * Operation auf einem Knoten, nachdem die Nachkommen besuchr wurden.
	 * @param value
	 */
	abstract protected void postOperation(N value);

}   