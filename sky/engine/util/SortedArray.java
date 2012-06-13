package sky.engine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import sky.engine.util.primitives.SEArrays;

/**
 * An implementation of a Sorted Array. It is constructed using a Comparator object that can
 * compare two objects together, thus allowing the SortedArray to order its elements into
 * ascending or descending order.
 * 
 * We can also create a SortedArray without a Comparator object, if and only if the objects to be
 * used implement the Comparable interface.
 * 
 * This is similar to the SortedList, but far more efficient. 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 * @param <T> - Class type for the objects to be sorted.
 */
public class SortedArray<T> implements List<T>
{
	/**
	 * Constant value for a ascending sort.
	 */
	protected static final int ASCENDING = 0;
	
	
	/**
	 * Constant value for a descending sort.
	 */
	protected static final int DESCENDING = 1;
	
	
	/**
	 * Array of objects that are sorted.
	 */
	protected T[] sortedarray = null;
	
	
	/**
	 * The Comparator object to use when sorting the SortedArray.
	 */
	protected final Comparator<T> comparator;
	
	
	/**
	 * Current sort-order of the array. 0 = ascending, 1 = descending.
	 */
	protected int currentSort = ASCENDING;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a SortedArray. Objects will be sorted in ascending order,
	 * according to the given Comparator.
	 * 
	 * @param comp - Comparator to sort the objects by.
	 */
	public SortedArray(Comparator<T> comp)
	{
		comparator = comp;
	}
	
	
	/**
	 * Create new instance of a SortedArray. Objects will be sorted in ascending order,
	 * according to the given Comparator. Objects from from given array will be added
	 * and then sorted accordingly.
	 * 
	 * @param comp - Comparator to sort the objects by.
	 * @param array - Array of objects to initialise with.
	 */
	public SortedArray(Comparator<T> comp, T[] array)
	{
		comparator = comp;
		sortedarray = Arrays.copyOf(array, array.length);
		sortAscending();
	}
	
	
	/**
	 * Create new instance of a SortedArray. Objects will be sorted in ascending order, and
	 * MUST implement the Comparable interface.
	 */
	public SortedArray()
	{
		comparator = null;
	}
	
	
	/**
	 * Create new instance of a SortedArray. Objects will be sorted in ascending order, and
	 * MUST implement the Comparable interface. Objects from from given array will be added
	 * and then sorted accordingly.
	 * 
	 * @param array - Array of objects to initialise with.
	 */
	public SortedArray(T[] array)
	{
		comparator = null;
		sortedarray = Arrays.copyOf(array, array.length);
		sortAscending();
	}
	
	
	
	
	
	
	
	
	/**
	 * Clone this SortedArray.
	 * 
	 * @return A cloned version of this SortedArray.
	 */
	public SortedArray<T> clone()
	{
		return new SortedArray<T>(sortedarray);
	}

	
	
	
	
	
	
	
	
	/**
	 * Add the given object to the SortedArray. The object will be added, and then the SortedArray
	 * sorted into ascending order so the object is placed into the correct position.
	 * 
	 * @param object - The object to be added.
	 * @return Whether the operation was successful.
	 */
	public boolean add(T object)
	{
		sortedarray = Arrays.copyOf(sortedarray, sortedarray.length + 1);
		sortedarray[sortedarray.length - 1] = object;
		sortAscending();
		return true;
	}
	
	
	/**
	 * 
	 */
	public void add(int index, T object)
	{
		throw new UnsupportedOperationException();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Adds an entire array to the SortedArray. The array is first added, and the SortedArray
	 * then sorted into ascending order so everything is placed correctly.
	 * 
	 * @param array - The array of objects to be added.
	 * @return Whether the operation was successful.
	 */
	public boolean addAll(T[] objects)
	{
		int originalLength = sortedarray.length;
		sortedarray = Arrays.copyOf(sortedarray, sortedarray.length + objects.length);
		System.arraycopy(objects, 0, sortedarray, originalLength, objects.length);
		sortAscending();
		return true;
	}


	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean addAll(Collection<? extends T> collection)
	{
		T[] array = (T[])collection.toArray();
		return this.addAll(array);
	}


	/**
	 * 
	 */
	public boolean addAll(int index, Collection<? extends T> collection)
	{
		throw new UnsupportedOperationException();
	}

	
	
	
	
	
	
	
	/**
	 * Remove an object from the SortedArray at the given index.
	 * 
	 * @param index - Index of the object.
	 * @return The object.
	 * @throws IndexOutOfBoundsException.
	 */
	public T remove(int index)
	{
		if (index < 0 || index >= sortedarray.length)
			throw new IndexOutOfBoundsException();
		
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		T temp = list.remove(index);
		sortedarray = list.toArray(Arrays.copyOf(sortedarray, 0));
		
		return temp;
	}
	
	
	/**
	 * Remove the given object from the SortedArray.
	 * 
	 * @param object - Object to be removed.
	 * @return Whether the operation was successful.
	 */
	public boolean remove(Object object)
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		boolean b = list.remove(object);
		sortedarray = list.toArray(Arrays.copyOf(sortedarray, 0));
		
		return b;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Removes an array of objects from the SortedArray.
	 * 
	 * @param objects - Objects to be removed.
	 * @return Whether the operation was successful.
	 */
	public boolean removeAll(T[] objects)
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		boolean b = list.removeAll(Arrays.asList(objects));
		sortedarray = list.toArray(Arrays.copyOf(sortedarray, 0));
		return b;
	}


	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeAll(Collection<?> collection)
	{
		T[] array = (T[])collection.toArray();
		return this.removeAll(array);
	}

	
	
	
	
	

	
	
	/**
	 * 
	 */
	public boolean retainAll(Collection<?> collection)
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		
		if (list.retainAll(collection))
		{
			sortedarray = list.toArray(Arrays.copyOf(sortedarray, 0));
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * 
	 */
	public boolean retainAll(T[] objects)
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		
		if (list.retainAll(Arrays.asList(objects)))
		{
			sortedarray = list.toArray(Arrays.copyOf(sortedarray, 0));
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Set an object at the given index to the given object. When the object has been set
	 * the SortedArray will be re-sorted into ascending order.
	 * 
	 * @param index - Index of the object to set.
	 * @param object - Object to set the other object to.
	 * @return The previous object at the given index.
	 * @throws IndexOutOfBoundsException.
	 */
	public T set(int index, T object)
	{
		if (index < 0 || index >= sortedarray.length)
			throw new IndexOutOfBoundsException();
		
		T temp = sortedarray[index];
		sortedarray[index] = object;
		sortAscending();
		return temp;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns whether the SortedArray contains the given object.
	 * 
	 * @param object - Object to check for.
	 * @return Whether the SortedArray contains the object.
	 */
	@SuppressWarnings("unchecked")
	public boolean contains(Object object)
	{
		boolean wasDescending = false;
		
		if (currentSort == DESCENDING) {
			sortAscending();
			wasDescending = true;
		}
		
		int index = 0;
		
		if (comparator != null)
			index = Arrays.binarySearch(sortedarray, object);
		else
			index = Arrays.binarySearch(sortedarray, (T)object, comparator);
		
		if (wasDescending)
			sortDescending();
		
		if (index >= 0)
			return true;
		
		return false;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns whether the SortedArray contains the given array of objects.
	 * 
	 * @param objects - Objects to check for.
	 * @return Whether the SortedArray contains the objects.
	 */
	public boolean containsAll(T[] objects)
	{
		boolean wasDescending = false;
		
		if (currentSort == DESCENDING) {
			sortAscending();
			wasDescending = true;
		}
		
		boolean containsAll = true;
		
		for (int i = 0; i < objects.length; i++)
		{
			if (!contains(objects[i]))
				containsAll = false;
		}
		
		if (wasDescending)
			sortDescending();
		
		return containsAll;
	}


	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean containsAll(Collection<?> collection)
	{
		T[] array = (T[])collection.toArray();
		return this.containsAll(array);
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the index of the given object.
	 * 
	 * @param object - Object to get index of.
	 * @return Index of the object.
	 */
	public int indexOf(Object object)
	{
		for (int i = 0; i < sortedarray.length; i++)
		{
			if (sortedarray[i].equals(object))
				return i;
		}
		
		return -1;
	}

	
	/**
	 * 
	 */
	public int lastIndexOf(Object object)
	{
		int index = -1;
		
		for (int i = 0; i < sortedarray.length; i++)
		{
			if (sortedarray[i].equals(object))
				index = i;
		}
		
		return index;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clears all objects from the SortedArray.
	 */
	public void clear()
	{
		sortedarray = Arrays.copyOf(sortedarray, 0);
	}

	
	
	
	
	
	
	
	
	
	/**
	 * Returns the object at the given index.
	 * 
	 * @param index - Index of object to return.
	 * @return The object at the given index.
	 * @throws IndexOutOfBoundsException.
	 */
	public T get(int index)
	{
		if (index < 0 || index >= sortedarray.length)
			throw new IndexOutOfBoundsException();
		
		return sortedarray[index];
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the first object.
	 * 
	 * @return The first object.
	 */
	public T getFirst()
	{
		return sortedarray[0];
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the last object.
	 * 
	 * @return the last object.
	 */
	public T getLast()
	{
		return sortedarray[sortedarray.length - 1];
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of objects contained within the SortedArray.
	 * 
	 * @return Number of objects.
	 */
	public int size()
	{
		return sortedarray.length;
	}

	
	
	
	
	

	
	/**
	 * 
	 */
	public boolean isEmpty()
	{
		if (sortedarray == null || sortedarray.length == 0)
			return true;
		
		return false;
	}
	

	
	
	
	
	
	
	
	
	/**
	 * Sort the objects into ascending order.
	 */
	public void sortAscending()
	{
		if (sortedarray.length == 1)
			return;
		
		if (comparator != null)
			Arrays.sort(sortedarray, comparator);
		else
			Arrays.sort(sortedarray);
		
		currentSort = ASCENDING;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Sort the objects into descending order.
	 */
	public void sortDescending()
	{
		if (sortedarray.length == 1)
			return;
		
		if (comparator != null)
			Arrays.sort(sortedarray, Collections.reverseOrder(comparator));
		else
			Arrays.sort(sortedarray, Collections.reverseOrder());
		
		currentSort = DESCENDING;
	}
	
	
	
	
	
	
	
	
	/**
	 * Reverses the objects of the SortedArray.
	 */
	public void reverse()
	{
		if (sortedarray.length == 1)
			return;
		
		SEArrays.reverse(sortedarray);
	}

	
	
	
	
	
	
	

	/**
	 * 
	 */
	public Iterator<T> iterator()
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		return list.iterator();
	}


	/**
	 * 
	 */
	public ListIterator<T> listIterator()
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		return list.listIterator();
	}


	/**
	 * 
	 */
	public ListIterator<T> listIterator(int index)
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		return list.listIterator(index);
	}

	
	
	
	
	
	
	
	/**
	 * 
	 */
	public List<T> subList(int start, int end)
	{
		List<T> list = new ArrayList<T>(Arrays.asList(sortedarray));
		return list.subList(start, end);
	}

	
	
	
	
	
	
	

	/**
	 * 
	 */
	public T[] toArray()
	{
		return sortedarray;
	}


	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T> T[] toArray(T[] array)
	{
		return (T[])sortedarray;
	}
	
	
	
	
	
	
	
}
