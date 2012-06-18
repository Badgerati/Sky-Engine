package sky.engine.util.graphs;


/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Edge<N>
{
	/**
	 * Current weight object for the Edge.
	 */
	public float weight = 0;
	
	
	/**
	 * Parent Node this Edge comes from.
	 */
	public Node<N> parentNode = null;
	
	
	/**
	 * Child Node this Edge points to.
	 */
	public Node<N> childNode = null;
	
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Edge(float weight, Node<N> parent, Node<N> child)
	{
		this.weight = weight;
		parentNode = parent;
		childNode = child;
	}
	
	
	/**
	 * 
	 */
	public Edge(Node<N> parent, Node<N> child)
	{
		this.weight = 0;
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
			Edge<N> edge = (Edge<N>)o;
			
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
		return ((int)weight + parentNode.hashCode() + childNode.hashCode());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
