package sky.engine.util.graphs;

import java.util.Collection;
import java.util.Iterator;

import sky.engine.components.Pair;
import sky.engine.util.ListSet;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Node<N>
{
	/**
	 * 
	 */
	public static final int PARENT = 0;
	
	
	/**
	 * 
	 */
	public static final int CHILD = 1;
	
	
	/**
	 * Set of out-edges for this Node.
	 */
	private ListSet<Edge<N>> outEdges = new ListSet<Edge<N>>();
	
	
	/**
	 * Set of in-edges for this Node.
	 */
	private ListSet<Edge<N>> inEdges = new ListSet<Edge<N>>();
	
	
	/**
	 * Data this Node stores.
	 */
	public N data = null;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public Node(N item)
	{
		this.data = item;
	}
	
	
	/**
	 * 
	 */
	public Node(N item, Node<N> node, float weight, int parentOrChild)
	{
		this.data = item;
		
		switch (parentOrChild)
		{
			case PARENT:
				this.createOutEdge(weight, node); break;
				
			case CHILD:
				this.createInEdge(weight, node); break;
		}
	}
	
	
	/**
	 * 
	 */
	public Node(N item, Collection<Edge<N>> outedges, Collection<Edge<N>> inedges)
	{
		this.data = item;		
		
		if (outedges != null) outEdges.addAll(outedges);
		if (inedges != null) inEdges.addAll(inedges);
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
			Node<N> node = (Node<N>)o;
			
			return (data.equals(node.data));
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
		return (data.hashCode());
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean addOutEdge(Edge<N> edge)
	{
		return outEdges.add(edge);
	}
	
	
	/**
	 * 
	 */
	public void addOutEdge(int index, Edge<N> edge)
	{
		outEdges.add(index, edge);
	}
	
	
	/**
	 * 
	 */
	public boolean addInEdge(Edge<N> edge)
	{
		return inEdges.add(edge);
	}
	
	
	/**
	 * 
	 */
	public void addInEdge(int index, Edge<N> edge)
	{
		inEdges.add(index, edge);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean addOutEdges(Collection<Edge<N>> edges)
	{
		return outEdges.addAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean addOutEdges(int index, Collection<Edge<N>> edges)
	{
		return outEdges.addAll(index, edges);
	}
	
	
	/**
	 * 
	 */
	public boolean addInEdges(Collection<Edge<N>> edges)
	{
		return inEdges.addAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean addInEdges(int index, Collection<Edge<N>> edges)
	{
		return inEdges.addAll(index, edges);
	}
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean createOutEdge(Node<N> child)
	{
		return createOutEdge(0, child);
	}
	
	
	/**
	 * 
	 */
	public boolean createOutEdge(float weight, Node<N> child)
	{
		Edge<N> edge = new Edge<N>(weight, this, child);
		return (outEdges.add(edge) && child.addInEdge(edge));
	}
	
	
	/**
	 * 
	 */
	public boolean createInEdge(Node<N> parent)
	{
		return createInEdge(0, parent);
	}
	
	
	/**
	 * 
	 */
	public boolean createInEdge(float weight, Node<N> parent)
	{
		Edge<N> edge = new Edge<N>(weight, parent, this);
		return (inEdges.add(edge) && parent.addOutEdge(edge));
	}
	
	
	
	
	
	

	
	
	
	
	/**
	 * 
	 */
	public boolean removeOutEdge(Edge<N> edge)
	{
		return outEdges.remove(edge);
	}
	
	
	/**
	 * 
	 */
	public boolean removeOutEdges(Collection<Edge<N>> edges)
	{
		return outEdges.removeAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean removeInEdge(Edge<N> edge)
	{
		return inEdges.remove(edge);
	}
	
	
	/**
	 * 
	 */
	public boolean removeInEdges(Collection<Edge<N>> edges)
	{
		return inEdges.removeAll(edges);
	}
	
	
	
	
	
	

	
	/**
	 * 
	 */
	public void clearEdges()
	{
		outEdges.clear();
		inEdges.clear();
	}
	
	
	/**
	 * 
	 */
	public void clearOutEdges()
	{
		outEdges.clear();
	}
	
	
	/**
	 * 
	 */
	public void clearInEdges()
	{
		inEdges.clear();
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public Node<N> clone()
	{
		return new Node<N>(data, outEdges, inEdges);
	}
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean containsOutEdge(Edge<N> edge)
	{
		return outEdges.contains(edge);
	}
	
	
	/**
	 * 
	 */
	public boolean containsInEdge(Edge<N> edge)
	{
		return inEdges.contains(edge);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean containsAllOutEdges(Collection<Edge<N>> edges)
	{
		return outEdges.containsAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean containsAllInEdges(Collection<Edge<N>> edges)
	{
		return inEdges.containsAll(edges);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Edge<N> getOutEdge(int index)
	{
		return outEdges.get(index);
	}
	
	
	/**
	 * 
	 */
	public Edge<N> getInEdge(int index)
	{
		return inEdges.get(index);
	}
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Edge<N> setOutEdge(int index, Edge<N> edge)
	{
		return outEdges.set(index, edge);
	}
	
	
	/**
	 * 
	 */
	public Edge<N> setInEdge(int index, Edge<N> edge)
	{
		return inEdges.set(index, edge);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public int indexOfOutEdge(Edge<N> edge)
	{
		return outEdges.indexOf(edge);
	}
	
	
	/**
	 * 
	 */
	public int indexOfInEdge(Edge<N> edge)
	{
		return inEdges.indexOf(edge);
	}
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean hasOutEdges()
	{
		return outEdges.isEmpty();
	}
	
	
	/**
	 * 
	 */
	public boolean hasInEdges()
	{
		return inEdges.isEmpty();
	}
	
	
	
	

	
	
	/**
	 * 
	 */
	public int outdegree()
	{
		return outEdges.size();
	}
	
	
	/**
	 * 
	 */
	public int indegree()
	{
		return inEdges.size();
	}
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Iterator<Edge<N>> iteratorOut()
	{
		return outEdges.iterator();
	}
	
	
	/**
	 * 
	 */
	public Iterator<Edge<N>> iteratorIn()
	{
		return inEdges.iterator();
	}
	
	
	/**
	 * 
	 */
	public Pair<Iterator<Edge<N>>, Iterator<Edge<N>>> iterators()
	{
		return new Pair<Iterator<Edge<N>>, Iterator<Edge<N>>>(outEdges.iterator(), inEdges.iterator());
	}
	
	
	
	
}
