package sky.engine.util;





/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Visitor<K, L>
{
	
	/**
	 * Add a new Key.
	 * 
	 * @param key - Key to add.
	 */
	public boolean add(K key)
	{		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Adds a new Link to or with a given Key. If the Key does not exist, this will
	 * create the Key with the given Link and visited state.
	 * 
	 * @param key - Key to add.
	 * @param link - Link to add.
	 * @param visited - Current visited state of the Link.
	 */
	public boolean add(K key, L link, boolean visited)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Removes the given link from the given key's links.
	 * 
	 * @param key - Key to find the link in.
	 * @param link - Link to remove.
	 */
	public boolean remove(K key, L link)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Removes the given key.
	 * 
	 * @param key - Key to remove.
	 */
	public boolean remove(K key)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a boolean value of whether the given Key contains the given Link in its Links.
	 * If the Key does not exist, null is returned.
	 * 
	 * @param key - Key to find the Link in.
	 * @param link - Link to attempt to locate.
	 * @return True if found, false otherwise. Null if Key does not exist.
	 */
	public boolean contains(K key, L link)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns whether we contain the given Key.
	 * 
	 * @param key - Key to attempt to locate.
	 * @return True if found, false otherwise.
	 */
	public boolean contains(K key)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a boolean value of whether the given Link has been visited from the given Key.
	 * If the given Key or Link does not exist then false is returned.
	 * 
	 * @param key - Key to find the Link in.
	 * @param link - Link to find visited state for.
	 * @return True if Link visited, false otherwise. False if Key or Link do not exist.
	 */
	public boolean isVisited(K key, L link)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set the given Link in the given Key to the given visited state, returning
	 * whether it was successful. If the given Key or Link does not exist, false is returned.
	 * 
	 * @param key - Key to find the Link in.
	 * @param link - Link to set to the given visited state.
	 * @param visited - Visited state to set Link to.
	 * @return True if successful, false otherwise.
	 */
	public boolean setVisited(K key, L link, boolean visited)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of Keys.
	 * 
	 * @return Total number of Keys.
	 */
	public int size()
	{
		return 0;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of Links the given Key has, -1 if the Key does not exist.
	 * 
	 * @param key - Key to get Links from.
	 * @return Total number of Links Key contains, -1 otherwise.
	 */
	public int size(K key)
	{
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clear the Keys and Links.
	 */
	public boolean clear()
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clear the Links of the given Key.
	 * 
	 * @param key - Key to clear Links from.
	 */
	public boolean clear(K key)
	{
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the next non-visited Link of the given Key, returns null if there is not one.
	 * 
	 * @param key - Key to get next non-visited Link from.
	 * @return First non-visited Link, or null otherwise.
	 */
	public L getNext(K key)
	{
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a boolean value of whether all Links have been visited from the given Key,
	 * returning false if the Key does not exist.
	 * 
	 * @param key - Key to test all Links of.
	 * @return True if all are visited, false otherwise. False if Key does not exist.
	 */
	public boolean allVisited(K key)
	{
		return false;
	}

}
