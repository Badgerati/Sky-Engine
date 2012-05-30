package sky.engine.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * A data structure for storing a set of Keys, each with a set of Links; keeping in memory whether
 * those Links have been visited to from their parent Key.
 * 
 * @author Matthew Kelly (Badgerati).
 * @version 1.0.0.
 * @since 24 May 2012. (Last update: 24 May 2012).
 *
 * @param <K> - Class type for the Keys.
 * @param <L> - Class type for the Links of the Keys.
 */
public class VisitorMap<K, L>
{
	/**
	 * The VisitorMap itself, which consists of a HashMap of Keys, with associated
	 * HashMap of Links and boolean values indicating the visitation state of that Link.
	 */
	private HashMap<K, HashMap<L, Boolean>> visitormap = null;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a VisitorMap.
	 */
	public VisitorMap()
	{
		visitormap = new HashMap<K, HashMap<L, Boolean>>();
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Add a new Key to this VisitorMap, returning whether it was successful.
	 * 
	 * @param key - Key to add.
	 * @return True if successful, false otherwise.
	 */
	public boolean add(K key)
	{
		if (!visitormap.containsKey(key))
		{
			visitormap.put(key, new HashMap<L, Boolean>());
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Adds a new Link to or with a given Key. If the Key does not exist, this will
	 * create the Key with the given Link and visited state. Returns whether it was
	 * successful.
	 * 
	 * @param key - Key to add.
	 * @param link - Link to add.
	 * @param visited - Current visited state of the Link.
	 * @return True if successful, false otherwise.
	 */
	public boolean add(K key, L link, boolean visited)
	{
		if (!visitormap.containsKey(key))
		{
			HashMap<L, Boolean> temp = new HashMap<L, Boolean>();
			temp.put(link, visited);
			visitormap.put(key, temp);
			return true;
		}
		else
		{
			visitormap.get(key).put(link, visited);
			return true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Removes the given Link from the given Key's Links, returning whether it was successful.
	 * 
	 * @param key - Key to find the Link in.
	 * @param link - Link to remove.
	 * @return True if successful, false otherwise.
	 */
	public boolean remove(K key, L link)
	{
		if (visitormap.containsKey(key))
		{
			visitormap.get(key).remove(link);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Removes the given Key from this VisitorMap, as well as its associated Links. Returning
	 * whether it was successful.
	 * 
	 * @param key - Key to remove.
	 * @return True if successful, false otherwise.
	 */
	public boolean remove(K key)
	{
		if (visitormap.containsKey(key))
		{
			visitormap.remove(key);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a Nullean value of whether the given Key contains the given Link in its Links.
	 * If the Key does not exist, null is returned.
	 * 
	 * @param key - Key to find the Link in.
	 * @param link - Link to attempt to locate.
	 * @return True if found, false otherwise. Null if Key does not exist.
	 */
	public Nullean contains(K key, L link)
	{
		if (visitormap.containsKey(key))
		{
			if (visitormap.get(key).containsKey(link))
			{
				return new Nullean(true);
			}
		}
		else
		{
			return null;
		}
		
		return new Nullean(false);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns whether this VisitorMap contains the given Key.
	 * 
	 * @param key - Key to attempt to locate.
	 * @return True if found, false otherwise.
	 */
	public boolean contains(K key)
	{
		if (visitormap.containsKey(key))
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a Nullean value of whether the given Link has been visited from the given Key.
	 * If the given Key or Link does not exist then null is returned.
	 * 
	 * @param key - Key to find the Link in.
	 * @param link - Link to find visited state for.
	 * @return True if Link visited, false otherwise. Null if Key or Link do not exist.
	 */
	public Nullean isVisited(K key, L link)
	{
		if (visitormap.containsKey(key))
		{
			if (visitormap.get(key).containsKey(link))
			{
				return new Nullean(visitormap.get(key).get(link));
			}
		}
		
		return null;
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
		if (visitormap.containsKey(key))
		{
			if (visitormap.get(key).containsKey(link))
			{
				visitormap.get(key).put(link, visited);
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of Keys this VisitorMap has.
	 * 
	 * @return Total number of Keys.
	 */
	public int size()
	{
		return visitormap.size();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of Links the given Key has, -1 if the Key does not exist.
	 * 
	 * @param key - Key to get Links from.
	 * @return Total number of Links Key contains, -1 otherwise.
	 */
	public int size(K key)
	{
		if (visitormap.containsKey(key))
		{
			return visitormap.get(key).size();
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of Links for all the Keys this VisitorMap contains. Will return a
	 * Map of individual values for each Key.
	 * 
	 * @return Map containing total number of Links for all Keys.
	 */
	public HashMap<K, Integer> sizeAll()
	{
		HashMap<K, Integer> sizes = new HashMap<K, Integer>();
		Set<K> keys = visitormap.keySet();
		
		for (K key : keys)
		{
			sizes.put(key, visitormap.get(key).size());
		}
		
		return sizes;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the total number of all Links across all Keys within this VisitorMap.
	 * 
	 * @return Total number of all Links.
	 */
	public int sizeAllStacked()
	{
		int size = 0;
		Set<K> keys = visitormap.keySet();
		
		for (K key : keys)
		{
			size += visitormap.get(key).size();
		}
		
		return size;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clear the Keys and Links of this VisitorMap. Returning whether is was successful.
	 * 
	 * @return True if successful, false otherwise.
	 */
	public boolean clear()
	{
		visitormap.clear();
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clear the Links of the given Key. Returning whether is was successful.
	 * 
	 * @param key - Key to clear Links from.
	 * @return True if successful, false otherwise.
	 */
	public boolean clear(K key)
	{
		if (visitormap.containsKey(key))
		{
			visitormap.get(key).clear();
			return true;
		}
		
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
		if (visitormap.containsKey(key))
		{
			Set<L> linkKeys = visitormap.get(key).keySet();
			HashMap<L, Boolean> links = visitormap.get(key);
			
			for (L link : linkKeys)
			{
				if (!links.get(link))
					return link;
			}
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the Set of Links of the given Key.
	 * 
	 * @param key - Key to get Links from.
	 * @return Set of Links, null otherwise.
	 */
	public Set<L> getLinks(K key)
	{
		if (visitormap.containsKey(key))
		{
			return visitormap.get(key).keySet();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this VisitorMap's Set of Keys.
	 * 
	 * @return Set of Keys.
	 */
	public Set<K> getKeys()
	{
		return visitormap.keySet();
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a Nullean value of whether all Links have been visited from the given Key,
	 * returning null if the Key does not exist.
	 * 
	 * @param key - Key to test all Links of.
	 * @return True if all are visited, false otherwise. Null if Key does not exist.
	 */
	public Nullean allVisited(K key)
	{
		if (visitormap.containsKey(key))
		{
			Collection<Boolean> visits = visitormap.get(key).values();
			
			for (boolean visit : visits)
			{
				if (!visit) {
					return new Nullean(false);
				}
			}
			
			return new Nullean(true);
		}
		
		return null;
	}
	
	
	
	
	
	

}
