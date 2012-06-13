package sky.engine.util.graphs;

import java.util.Collection;
import java.util.Iterator;

import sky.engine.util.ListSet;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Graph<N, E>
{
	/**
	 * 
	 */
	private ListSet<Node<N, E>> nodes = new ListSet<Node<N, E>>();
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Graph()
	{
		
	}
	
	
	/**
	 * 
	 */
	public Graph(Node<N, E> node)
	{
		nodes.add(node);
	}
	
	
	/**
	 * 
	 */
	public Graph(Collection<Node<N, E>> nodes)
	{
		this.nodes.addAll(nodes);
	}
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean addNode(Node<N, E> node)
	{		
		return nodes.add(node);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean addNodes(Collection<Node<N, E>> nodes)
	{		
		return nodes.addAll(nodes);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public int size()
	{
		return nodes.size();
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Iterator<Node<N, E>> iterator()
	{
		return nodes.iterator();
	}
	
	
	
	
	
	
	
	
	
	
	
}
