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
public class Node<N, E>
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
	private ListSet<Edge<E, N>> outEdges = new ListSet<Edge<E, N>>();
	
	
	/**
	 * Set of in-edges for this Node.
	 */
	private ListSet<Edge<E, N>> inEdges = new ListSet<Edge<E, N>>();
	
	
	/**
	 * Item this Node stores.
	 */
	public N item = null;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public Node(N item)
	{
		this.item = item;
	}
	
	
	/**
	 * 
	 */
	public Node(N item, Node<N, E> node, E weight, int parentOrChild)
	{
		this.item = item;
		
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
	public Node(N item, Collection<Edge<E, N>> outedges, Collection<Edge<E, N>> inedges)
	{
		this.item = item;		
		
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
			Node<N, E> node = (Node<N, E>)o;
			
			return (item.equals(node.item));
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
		return (item.hashCode());
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean addOutEdge(Edge<E, N> edge)
	{
		return outEdges.add(edge);
	}
	
	
	/**
	 * 
	 */
	public void addOutEdge(int index, Edge<E, N> edge)
	{
		outEdges.add(index, edge);
	}
	
	
	/**
	 * 
	 */
	public boolean addInEdge(Edge<E, N> edge)
	{
		return inEdges.add(edge);
	}
	
	
	/**
	 * 
	 */
	public void addInEdge(int index, Edge<E, N> edge)
	{
		inEdges.add(index, edge);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean addOutEdges(Collection<Edge<E, N>> edges)
	{
		return outEdges.addAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean addOutEdges(int index, Collection<Edge<E, N>> edges)
	{
		return outEdges.addAll(index, edges);
	}
	
	
	/**
	 * 
	 */
	public boolean addInEdges(Collection<Edge<E, N>> edges)
	{
		return inEdges.addAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean addInEdges(int index, Collection<Edge<E, N>> edges)
	{
		return inEdges.addAll(index, edges);
	}
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean createOutEdge(Node<N, E> child)
	{
		return createOutEdge(null, child);
	}
	
	
	/**
	 * 
	 */
	public boolean createOutEdge(E weight, Node<N, E> child)
	{
		Edge<E, N> edge = new Edge<E, N>(weight, this, child);
		return (outEdges.add(edge) && child.addInEdge(edge));
	}
	
	
	/**
	 * 
	 */
	public boolean createInEdge(Node<N, E> parent)
	{
		return createInEdge(null, parent);
	}
	
	
	/**
	 * 
	 */
	public boolean createInEdge(E weight, Node<N, E> parent)
	{
		Edge<E, N> edge = new Edge<E, N>(weight, parent, this);
		return (inEdges.add(edge) && parent.addOutEdge(edge));
	}
	
	
	
	
	
	

	
	
	
	
	/**
	 * 
	 */
	public boolean removeOutEdge(Edge<E, N> edge)
	{
		return outEdges.remove(edge);
	}
	
	
	/**
	 * 
	 */
	public boolean removeOutEdges(Collection<Edge<E, N>> edges)
	{
		return outEdges.removeAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean removeInEdge(Edge<E, N> edge)
	{
		return inEdges.remove(edge);
	}
	
	
	/**
	 * 
	 */
	public boolean removeInEdges(Collection<Edge<E, N>> edges)
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
	public Node<N, E> clone()
	{
		return new Node<N, E>(item, outEdges, inEdges);
	}
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean containsOutEdge(Edge<E, N> edge)
	{
		return outEdges.contains(edge);
	}
	
	
	/**
	 * 
	 */
	public boolean containsInEdge(Edge<E, N> edge)
	{
		return inEdges.contains(edge);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean containsAllOutEdges(Collection<Edge<E, N>> edges)
	{
		return outEdges.containsAll(edges);
	}
	
	
	/**
	 * 
	 */
	public boolean containsAllInEdges(Collection<Edge<E, N>> edges)
	{
		return inEdges.containsAll(edges);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Edge<E, N> getOutEdge(int index)
	{
		return outEdges.get(index);
	}
	
	
	/**
	 * 
	 */
	public Edge<E, N> getInEdge(int index)
	{
		return inEdges.get(index);
	}
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public Edge<E, N> setOutEdge(int index, Edge<E, N> edge)
	{
		return outEdges.set(index, edge);
	}
	
	
	/**
	 * 
	 */
	public Edge<E, N> setInEdge(int index, Edge<E, N> edge)
	{
		return inEdges.set(index, edge);
	}
	
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public int indexOfOutEdge(Edge<E, N> edge)
	{
		return outEdges.indexOf(edge);
	}
	
	
	/**
	 * 
	 */
	public int indexOfInEdge(Edge<E, N> edge)
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
	public Iterator<Edge<E, N>> iteratorOut()
	{
		return outEdges.iterator();
	}
	
	
	/**
	 * 
	 */
	public Iterator<Edge<E, N>> iteratorIn()
	{
		return inEdges.iterator();
	}
	
	
	/**
	 * 
	 */
	public Pair<Iterator<Edge<E, N>>, Iterator<Edge<E, N>>> iterators()
	{
		return new Pair<Iterator<Edge<E, N>>, Iterator<Edge<E, N>>>(outEdges.iterator(), inEdges.iterator());
	}
	
	
	
	
}
