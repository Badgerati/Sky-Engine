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
public class Graph<N>
{
	/**
	 * 
	 */
	private ListSet<Node<N>> nodes = new ListSet<Node<N>>();
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Graph()
	{
		
	}
	
	
	/**
	 * 
	 */
	public Graph(Node<N> node)
	{
		nodes.add(node);
	}
	
	
	/**
	 * 
	 */
	public Graph(Collection<Node<N>> nodes)
	{
		this.nodes.addAll(nodes);
	}
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean addNode(Node<N> node)
	{		
		return nodes.add(node);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean addNodes(Collection<Node<N>> nodes)
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
	public Iterator<Node<N>> iterator()
	{
		return nodes.iterator();
	}
	
	
	
	
	
	
	
	
	
	
	
}
