package sky.engine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * An implementation of a Sorted List, which extends ArrayList. It is constructed using a Comparator
 * object that can compare two objects together, thus allowing the SortedList to order its elements
 * into ascending or descending order.
 * 
 * We can also create a SortedList without a Comparator object, if and only if the objects to be
 * used implement the Comparable interface.
 * 
 * @author Matthew Kelly (Badgerati).
 * 
 * @param <T> - Class type for the objects to be sorted.
 *
 */
public class SortedList<T> extends ArrayList<T>
{
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -6558751495198829074L;
	
	
	/**
	 * The Comparator object to use when sorting the SortedList.
	 */
	protected final Comparator<T> comparator;
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * Create new instance of a SortedList. Objects will be sorted in ascending order,
	 * according to the given Comparator.
	 * 
	 * @param comp - Comparator to sort the objects by.
	 */
	public SortedList(Comparator<T> comp)
	{
		comparator = comp;
	}
	
	
	/**
	 * Create new instance of a SortedList. Objects will be sorted in ascending order,
	 * according to the given Comparator. Objects from from given Collection will be added
	 * and then sorted accordingly.
	 * 
	 * @param comp - Comparator to sort the objects by.
	 * @param collection - Collection of objects to initialise with.
	 */
	public SortedList(Comparator<T> comp, Collection<? extends T> collection)
	{
		comparator = comp;
		this.addAll(collection);
	}
	
	
	/**
	 * Create new instance of a SortedList. Objects will be sorted in ascending order, and
	 * MUST implement the Comparable interface.
	 */
	public SortedList()
	{
		comparator = null;
	}
	
	
	/**
	 * Create new instance of a SortedList. Objects will be sorted in ascending order, and
	 * MUST implement the Comparable interface. Objects from from given Collection will be added
	 * and then sorted accordingly.
	 * 
	 * @param collection - Collection of objects to initialise with.
	 */
	public SortedList(Collection<? extends T> collection)
	{
		comparator = null;
		this.addAll(collection);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * This method is unsupported.
	 * 
	 * @throws UnsupportedOperationException.
	 */
	@Override
	public void add(int index, T object)
	{
		throw new UnsupportedOperationException();
	}
	
	
	
	
	
	
		
	
	
	
	/**
	 * Add the given object to the SortedList. The object will be added, and then the SortedList
	 * sorted into ascending order so the object is placed into the correct position.
	 * 
	 * @param object - The object to be added.
	 * @return Whether the operation was successful.
	 */
	@Override
	public boolean add(T object)
	{
		boolean passed = super.add(object);
		sortAscending();
		return passed;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Adds an entire collection to the SortedList. The collection is first added, and the SortedList
	 * then sorted into ascending order so everything is placed correctly.
	 * 
	 * @param collection - The collection of objects to be added.
	 * @return Whether the operation was successful.
	 */
	@Override
	public boolean addAll(Collection<? extends T> collection)
	{
		boolean passed = super.addAll(collection);
		sortAscending();
		return passed;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Adds the given array of objects to the SortedList. The array is first added, and then the
	 * SortedList sorted into ascending order.
	 */
	public boolean addAll(T[] array)
	{
		boolean passed = super.addAll(Arrays.asList(array));
		sortAscending();
		return passed;
	}










	/**
	 * This method is unsupported.
	 * 
	 * @throws UnsupportedOperationException.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends T> collection)
	{
		throw new UnsupportedOperationException();
	}
	
	
	
	
	
	
	
	
	
	
	
	


	/**
	 * Set an object at the given index to the given object. When the object has been set
	 * the SortedList will be re-sorted into ascending order.
	 * 
	 * @param index - Index of the object to set.
	 * @param object - Object to set the other object to.
	 * @return The previous object at the given index.
	 */
	@Override
	public T set(int index, T object)
	{
		T temp = super.set(index, object);
		sortAscending();
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clears all objects from the SortedList, and then adds all of the given objects. These
	 * objects are assumed to be already in ascending or descending order.
	 * 
	 * @param list - List of objects to add after clearing.
	 */
	protected void clear(List<T> list)
	{
		this.clear();
		super.addAll(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the first object of the SortedList.
	 * 
	 * @return The first object.
	 */
	public T getFirst()
	{
		return this.get(0);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the last object of the SortedList.
	 * 
	 * @return The last object.
	 */
	public T getLast()
	{
		return this.get(this.size() - 1);
	}
	








	

	/**
	 * Sort the objects into ascending order.
	 */
	@SuppressWarnings("unchecked")
	public void sortAscending()
	{
		if (size() == 1)
			return;
		
		if (comparator != null)
		{
			ArrayList<T> array = new ArrayList<T>(this);
			Collections.sort(array, comparator);
			this.clear(array);
		}
		else
		{
			T[] array = (T[])this.toArray();
			Arrays.sort(array);
			this.clear(Arrays.asList(array));
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Sort the objects into descending order.
	 */
	@SuppressWarnings("unchecked")
	public void sortDescending()
	{
		if (size() == 1)
			return;
		
		if (comparator != null)
		{
			ArrayList<T> array = new ArrayList<T>(this);
			Collections.sort(this, Collections.reverseOrder(comparator));
			this.clear(array);
		}
		else
		{
			T[] array = (T[])this.toArray();
			Arrays.sort(array, Collections.reverseOrder());
			this.clear(Arrays.asList(array));
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Reverses the objects of the SortedList.
	 */
	public void reverse()
	{
		if (size() == 1)
			return;
		
		ArrayList<T> array = new ArrayList<T>(this);
		Collections.reverse(array);
		this.clear(array);
	}
	
	
	
	
}
