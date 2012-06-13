package sky.engine.util;

import java.util.ArrayList;

/**
 * A data structure for storing a set of keys, each with a set of links; keeping in memory whether
 * those links have been visited to by their parent key.
 * 
 * @author Matthew Kelly (Badgerati).
 * @version 1.0.2.
 * @since 24 May 2012. (Last update: 24 May 2012).
 *
 * @param <K> - Class type for the keys.
 * @param <L> - Class type for the links of the keys.
 */
public class VisitorList<K, L> extends Visitor<K, L>
{
	/**
	 * Keys for this VisitorList.
	 */
	protected ArrayList<K> Keys = null;
	
	
	/**
	 * The links this VisitorList's keys points to.
	 */
	protected ArrayList<ArrayList<L>> Links = null;
	
	
	/**
	 * Have those links been visited already?
	 */
	protected ArrayList<ArrayList<Boolean>> Visited = null;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a VisitorList.
	 */
	public VisitorList()
	{
		Keys = new ArrayList<K>();
		Links = new ArrayList<ArrayList<L>>();
		Visited = new ArrayList<ArrayList<Boolean>>();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Add a new key. Returning whether it was successful.
	 * 
	 * @param key - Key to add.
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean add(K key)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			Keys.add(key);
			
			ArrayList<L> templinks = new ArrayList<L>();
			Links.add(templinks);
			
			ArrayList<Boolean> tempvisited = new ArrayList<Boolean>();
			Visited.add(tempvisited);
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Adds a new link to or with a given key. If the key does not exist, this will
	 * create the key with the given link and visited state. Returns whether it was
	 * successful.
	 * 
	 * @param key - Key to add.
	 * @param link - Link to add.
	 * @param visited - Current visited state of the link.
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean add(K key, L link, boolean visited)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			Keys.add(key);
			
			ArrayList<L> templinks = new ArrayList<L>();
			templinks.add(link);
			Links.add(templinks);
			
			ArrayList<Boolean> tempvisited = new ArrayList<Boolean>();
			tempvisited.add(visited);
			Visited.add(tempvisited);
			return true;
		}
		else
		{
			int indexLink = Links.get(indexKey).indexOf(link);
			
			if (indexLink == -1)
			{
				Links.get(indexKey).add(link);
				Visited.get(indexKey).add(visited);
				return true;
			}
			else
			{
				Visited.get(indexKey).set(indexLink, visited);
				return true;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Removes the given link from the given key's links, returning whether it was successful.
	 * 
	 * @param key - Key to find the link in.
	 * @param link - Link to remove.
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean remove(K key, L link)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return false;
		}
		else
		{
			int indexLink = Links.get(indexKey).indexOf(link);
			
			if (indexLink == -1)
			{
				return false;
			}
			else
			{
				Links.get(indexKey).remove(indexLink);
				Visited.get(indexKey).remove(indexLink);
				return true;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Removes the given key from this VisitorList, as well as its associated links. Returning
	 * whether it was successful.
	 * 
	 * @param key - Key to remove.
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean remove(K key)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return false;
		}
		else
		{
			Keys.remove(indexKey);
			Links.remove(indexKey);
			Visited.remove(indexKey);
			return true;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns whether the given key contains the given link in its Links.
	 * 
	 * @param key - Key to find the link in.
	 * @param link - Link to attempt to locate.
	 * @return True if found, false otherwise.
	 */
	@Override
	public boolean contains(K key, L link)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return false;
		}
		else
		{
			return Links.get(indexKey).contains(link);
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns whether this VisitorList contains the given key.
	 * 
	 * @param key - Key to attempt to locate.
	 * @return True if found, false otherwise.
	 */
	@Override
	public boolean contains(K key)
	{
		return Keys.contains(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns whether the given link has been visited by the given key, if this VisitorList does
	 * not contain the given link/key then false is returned.
	 * 
	 * @param key - Key to find the link in.
	 * @param link - Link to find visited state for.
	 * @return True if link visited, false otherwise.
	 */
	@Override
	public boolean isVisited(K key, L link)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return false;
		}
		else
		{
			int indexLink = Links.get(indexKey).indexOf(link);
			
			if (indexLink == -1)
			{
				return false;
			}
			else
			{
				return Visited.get(indexKey).get(indexLink);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set the given link in the given key to the given visited state, returning
	 * whether it was successful.
	 * 
	 * @param key - Key to find the link in.
	 * @param link - Link to set to the given visited state.
	 * @param visited - Visited state to set link to.
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean setVisited(K key, L link, boolean visited)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return false;
		}
		else
		{
			int indexLink = Links.get(indexKey).indexOf(link);
			
			if (indexLink == -1)
			{
				return false;
			}
			else
			{
				Visited.get(indexKey).set(indexLink, visited);
				return true;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of keys this VisitorList has.
	 * 
	 * @return Total number of keys.
	 */
	@Override
	public int size()
	{
		return Keys.size();
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of links the given key has, -1 if the key does not exist.
	 * 
	 * @param key - Key to get links from.
	 * @return Total number of links key contains, -1 otherwise.
	 */
	@Override
	public int size(K key)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
			return -1;
		else
			return Links.get(indexKey).size();
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of links for all the keys this VisitorList contains. Will either
	 * return a single value for total summation, or individual values for each key depending
	 * on the value given to 'stacked'.
	 * 
	 * @param stacked - If true, returns total summation, else individual values.
	 * @return Integer array containing total number of links for all keys.
	 */
	public int[] sizeAll(boolean stacked)
	{
		int[] values = null;
		
		if (stacked)
			values = new int[1];
		else
			values = new int[Keys.size()];
		
		for (int i = 0; i < Keys.size(); i++)
		{
			if (stacked)
			{
				values[0] += Links.get(i).size();
			}
			else
			{
				values[i] = Links.get(i).size();
			}
		}
		
		return values;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clear the keys and links of this VisitorList. Returning whether is was successful.
	 * 
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean clear()
	{
		Keys.clear();
		Links.clear();
		Visited.clear();
		return true;
	}
	
	
	
	
	
	
	
	
	/**
	 * Clear the links of the given key. Returning whether is was successful.
	 * 
	 * @param key - Key to clear links from.
	 * @return True if successful, false otherwise.
	 */
	@Override
	public boolean clear(K key)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey != -1)
		{
			Links.get(indexKey).clear();
			Visited.get(indexKey).clear();
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the next non-visited link of the given key, returns null if there is not one.
	 * 
	 * @param key - Key to get next non-visited link from.
	 * @return First non-visited link, or null otherwise.
	 */
	@Override
	public L getNext(K key)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return null;
		}
		else
		{
			for (int i = 0; i < Links.get(indexKey).size(); i++)
			{
				if (!Visited.get(indexKey).get(i))
					return Links.get(indexKey).get(i);
			}
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the link at the given index of the given key, returns null if out-of-bounds.
	 * 
	 * @param key - Key to get the link from.
	 * @param indexLink - Index to find link at.
	 * @return Link at given index, null otherwise.
	 */
	public L getLink(K key, int indexLink)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return null;
		}
		else
		{
			if (indexLink >= Links.get(indexKey).size() || indexLink < 0)
				return null;
			
			return Links.get(indexKey).get(indexLink);
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the Links of the given key by the key's index.
	 * 
	 * @param indexKey - Index of the key to get links from.
	 * @return List of links, null otherwise.
	 */
	public ArrayList<L> getLinks(int indexKey)
	{		
		if (indexKey <= -1 || indexKey >= Keys.size())
		{
			return null;
		}
		else
		{
			return new ArrayList<L>(Links.get(indexKey));
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the Links of the given key.
	 * 
	 * @param key - Key to get links from.
	 * @return List of links, null otherwise.
	 */
	public ArrayList<L> getLinks(K key)
	{
		int indexKey = Keys.indexOf(key);
		return this.getLinks(indexKey);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the key at the given index, null if out-of-bounds.
	 * 
	 * @param indexKey - Index of key to return.
	 * @return Key at the given index, null otherwise.
	 */
	public K getKey(int indexKey)
	{
		if (indexKey <= -1 || indexKey >= Keys.size())
		{
			return null;
		}
		else
		{
			return Keys.get(indexKey);
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this VisitorList's list of keys.
	 * 
	 * @return List of keys.
	 */
	public ArrayList<K> getKeys()
	{
		return new ArrayList<K>(Keys);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the index of the given link of the given key, returning -1 if it does not exist.
	 * 
	 * @param key - Key to get index of link from.
	 * @param link - Link to get index of.
	 * @return Index of the link, -1 if it does not exist.
	 */
	public int indexOf(K key, L link)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return -1;
		}
		else
		{
			return Links.get(indexKey).indexOf(link);
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the index of the given key, returning -1 if it does not exist.
	 * 
	 * @param key - Key to get index of.
	 * @return Index of the key, -1 if it does not exist.
	 */
	public int indexOf(K key)
	{
		return Keys.indexOf(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns whether all links have been visited by the given key, returning false
	 * if the key does not exist.
	 * 
	 * @param key - Key to test all links of.
	 * @return True if all are visited, false otherwise.
	 */
	@Override
	public boolean allVisited(K key)
	{
		int indexKey = Keys.indexOf(key);
		
		if (indexKey == -1)
		{
			return false;
		}
		else
		{
			for (int i = 0; i < Links.get(indexKey).size(); i++)
			{
				if (!Visited.get(indexKey).get(i))
					return false;
			}
			
			return true;
		}
	}
	
	

}
