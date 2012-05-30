package sky.engine.components;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 * @param <T>
 * @param <U>
 */
public class Pair<T, U>
{
	/**
	 * Item 1 of this pair
	 */
	public T Item1 = null;
	
	
	/**
	 * Item 2 of this pair
	 */
	public U Item2 = null;
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a Pair
	 */
	public Pair(T item1, U item2)
	{
		Item1 = item1;
		Item2 = item2;
	}

	
	/**
	 * Create new instance of a Pair
	 */
	public Pair(Pair<T, U> pair)
	{
		Item1 = pair.Item1;
		Item2 = pair.Item2;
	}
	
	
	/**
	 * Create new instance of a Pair
	 */
	public Pair()
	{
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Pair
	 */
	public Pair<T, U> clone()
	{
		return new Pair<T, U>(Item1, Item2);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Does this Pair equal the given Pair
	 */
	public boolean equals(Pair<T, U> pair)
	{
		return (Item1.equals(pair.Item1) && Item2.equals(pair.Item2));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Does this Pair's items equal the given items
	 */
	public boolean equals(T item1, U item2)
	{
		return (Item1.equals(item1) && Item2.equals(item2));
	}

	
	
	
	
	
	
	
	/**
	 * Does this Pair equal the given object?
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Pair<T, U> pair = (Pair<T, U>)o;
			return (Item1.equals(pair.Item1) && Item2.equals(pair.Item2));
		}
		catch (Exception e)
		{
			return super.equals(o);
		}
	}

	
	
	
	
	
	
	
	
	
	/**
	 * Generate a hash code for this Pair
	 */
	@Override
	public int hashCode()
	{
		return (int)(Item1.hashCode() + Item2.hashCode());
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a string representation of this Pair
	 */
	public String toString()
	{
		return "(Item1 = " + Item1.toString() + ", Item2 = " + Item2.toString() + ")";
	}

}
