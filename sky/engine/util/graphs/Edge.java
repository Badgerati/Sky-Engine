package sky.engine.util.graphs;


/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Edge<E, N>
{
	/**
	 * Current weight object for the Edge.
	 */
	public E weight = null;
	
	
	/**
	 * Node this Edge comes from.
	 */
	public Node<N, E> parentNode = null;
	
	
	/**
	 * Node this Edge points to.
	 */
	public Node<N, E> childNode = null;
	
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Edge(E weight, Node<N, E> parent, Node<N, E> child)
	{
		this.weight = weight;
		parentNode = parent;
		childNode = child;
	}
	
	
	/**
	 * 
	 */
	public Edge(Node<N, E> parent, Node<N, E> child)
	{
		this.weight = null;
		parentNode = parent;
		childNode = child;
	}
	










	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Edge<E, N> edge = (Edge<E, N>)o;
			
			return (parentNode.equals(edge.parentNode) && childNode.equals(edge.childNode));
		}
		catch (Exception e)
		{
			return super.equals(o);			
		}
	}










	/**
	 * 
	 */
	@Override
	public int hashCode()
	{
		return (weight.hashCode() + parentNode.hashCode() + childNode.hashCode());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
