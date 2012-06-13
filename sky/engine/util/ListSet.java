package sky.engine.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class ListSet<T> implements List<T>, Set<T>
{
	/**
	 * 
	 */
	private List<T> list = new ArrayList<T>();
	
	
	/**
	 * 
	 */
	private Set<T> set = new HashSet<T>();
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public ListSet()
	{
		
	}
	
	
	/**
	 * 
	 */
	public ListSet(T object)
	{
		this.add(object);
	}
	
	
	/**
	 * 
	 */
	public ListSet(Collection<? extends T> collection)
	{
		this.addAll(collection);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean add(T object)
	{
		if (set.add(object))
		{
			return list.add(object);
		}
		
		return false;
	}
	
	
	/**
	 * 
	 */
	public void add(int index, T object)
	{
		if (set.add(object))
		{
			list.add(index, object);
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean addAll(Collection<? extends T> collection)
	{
		boolean changed = false;
		Iterator<? extends T> iterator = collection.iterator();
		
		while (iterator.hasNext())
		{
			if (add(iterator.next()))
				changed = true;
		}
		
		return changed;
	}
	
	
	/**
	 * 
	 */
	public boolean addAll(int index, Collection<? extends T> collection)
	{
		boolean changed = false;
		int indexToInsertAt = index;
		Iterator<? extends T> iterator = collection.iterator();
		
		while (iterator.hasNext())
		{
			T object = iterator.next();
			if (set.add(object))
			{
				list.add(indexToInsertAt++, object);
				changed = true;
			}
		}
		
		return changed;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public final List<T> asList()
	{
		return list;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public void clear()
	{
		set.clear();
		list.clear();
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public ListSet<T> clone()
	{
		return new ListSet<T>(list);
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean contains(Object object)
	{
		return set.contains(object);
	}
	
	
	/**
	 * 
	 */
	public boolean containsAll(Collection<?> collection)
	{
		return set.containsAll(collection);
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public T get(int index)
	{
		return list.get(index);
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public int indexOf(Object object)
	{
		return list.indexOf(object);
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public Iterator<T> iterator()
	{
		return list.iterator();
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public int lastIndexOf(Object object)
	{
		return list.lastIndexOf(object);
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public ListIterator<T> listIterator()
	{
	  return list.listIterator();
	}
	
	
	/**
	 * 
	 */
	public ListIterator<T> listIterator(int index)
	{
	   return list.listIterator(index);
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public T remove(int index)
	{
		T object = list.remove(index);
		
		if (object != null)
			set.remove(object);
		
		return object;
	}
	
	
	/**
	 * 
	 */
	public boolean remove(Object object)
	{
		if (set.remove(object))
		{
			list.remove(object);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean removeAll(Collection<?> collection)
	{
		if (set.removeAll(collection))
		{
			list.removeAll(collection);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public boolean retainAll(Collection<?> collection)
	{
		if (set.retainAll(collection))
		{
			list.retainAll(collection);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public T set(int index, T object)
	{
		T obj = list.set(index, object);
		set.remove(object);
		set.add(object);
		return obj;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public int size()
	{
		return list.size();
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public List<T> subList(int start, int end)
	{
		return list.subList(start, end);
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray()
	{
		return (T[])list.toArray();
	}

	
	/**
	 * 
	 */
	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] array)
	{
		return list.toArray(array);
	}
	
	
	
	
	
	
}
