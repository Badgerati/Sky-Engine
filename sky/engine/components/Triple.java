package sky.engine.components;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 * @param <T>
 * @param <U>
 * @param <V>
 */
public class Triple<T, U, V>
{
	/**
	 * Item 1 of this Triple
	 */
	public T Item1 = null;
	
	
	/**
	 * Item 2 of this Triple
	 */
	public U Item2 = null;
	
	
	/**
	 * Item 3 of this Triple
	 */
	public V Item3 = null;
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a Triple
	 */
	public Triple(T item1, U item2, V item3)
	{
		Item1 = item1;
		Item2 = item2;
		Item3 = item3;
	}

	
	/**
	 * Create new instance of a Triple
	 */
	public Triple(Triple<T, U, V> triple)
	{
		Item1 = triple.Item1;
		Item2 = triple.Item2;
		Item3 = triple.Item3;
	}
	
	
	/**
	 * Create new instance of a Triple
	 */
	public Triple()
	{
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Triple
	 */
	public Triple<T, U, V> clone()
	{
		return new Triple<T, U, V>(Item1, Item2, Item3);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Does this Triple equal the given Triple
	 */
	public boolean equals(Triple<T, U, V> triple)
	{
		return (Item1.equals(triple.Item1) && Item2.equals(triple.Item2) && Item3.equals(triple.Item3));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Does this Triple's items equal the given items
	 */
	public boolean equals(T item1, U item2, V item3)
	{
		return (Item1.equals(item1) && Item2.equals(item2) && Item3.equals(item3));
	}

	
	
	
	
	
	
	
	/**
	 * Does this Triple equal the given object (assumed to be a Triple)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Triple<T, U, V> triple = (Triple<T, U, V>)o;
			return (Item1.equals(triple.Item1) && Item2.equals(triple.Item2) && Item3.equals(triple.Item3));
		}
		catch (Exception e)
		{
			return super.equals(o);
		}
	}

	
	
	
	
	
	
	
	
	
	/**
	 * Generate a hash code for this Triple
	 */
	@Override
	public int hashCode()
	{
		return (int)(Item1.hashCode() + Item2.hashCode() + Item3.hashCode());
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a string representation of this Triple
	 */
	public String toString()
	{
		return "(Item1 = " + Item1.toString() + ", Item2 = " + Item2.toString() + ", Item3 = " + Item3.toString() + ")";
	}
	

}
