package sky.engine.misc;

import sky.engine.components.Pair;
import sky.engine.util.Inventory;
import sky.engine.util.Item;

/**
 * A basic implementation of an inventory that supports a maximum size of items, as well
 * as weights and gold. This is only a theoretic implementation as it has no graphical
 * coding to draw it to the screen. If you wish to display the items, you must extend
 * this class.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class BasicInventory implements Inventory
{
	/**
	 * List of items currently in the inventory.
	 */
	protected Item[] items = null;
	
	
	/**
	 * current size
	 */
	protected int size = 0;
	
	
	/**
	 * The maximum size 
	 */
	protected int maxsize = 0;
	
	
	/**
	 * current amount of gold
	 */
	protected int gold = 0;
	
	
	/**
	 * The maximum amount of gold
	 */
	protected int maxgold = 0;
	
	
	/**
	 * current weight
	 */
	protected float weight = 0;
	
	
	/**
	 * The maximum weight
	 */
	protected float maxweight = 0;
	
	
	
	
	

	
	
	/**
	 * Create instance of a new BasicInventory.
	 */
	public BasicInventory(int maxsize, int maxgold, float maxweight)
	{
		this.maxsize = maxsize;
		this.maxgold = maxgold;
		this.maxweight = maxweight;
		
		items = new Item[maxsize];
		for (int i = 0; i < maxsize; i++)
			items[i] = null;
	}
	
	
	/**
	 * Create instance of a new BasicInventory.
	 */
	public BasicInventory(Item[] items, int maxsize, int maxgold, float maxweight)
	{
		this.maxsize = maxsize;
		this.maxgold = maxgold;
		this.maxweight = maxweight;
		
		this.items = new Item[maxsize];
		this.items = items;
	}
	
	
	
	
	
	
	/**
	 * Returns a clone of this inventory.
	 */
	public Inventory clone()
	{
		return new BasicInventory(items, maxsize, maxgold, maxweight);
	}
	
	
	
	
	
	
	/**
	 * add an item to the inventory.
	 */
	public int add(Item item)
	{
		if (size >= maxsize)
			return ERROR_BAGS_FULL;
		
		if (weight + item.weight() > maxweight)
			return ERROR_OVER_BURDENED;
		
		size++;
		weight += item.weight();
		
		for (int i = 0; i < maxsize; i++)
		{
			if (items[i] == null)
			{
				items[i] = item;
				return ERROR_NONE;
			}
		}
		
		return ERROR_UNKNOWN;
	}
	
	
	
	
	
	
	/**
	 * add an item to the inventory at a given index.
	 */
	public Pair<Integer, Item> add(Item item, int index)
	{
		if (size >= maxsize)
			return new Pair<Integer, Item>(ERROR_BAGS_FULL, null);
		
		if (weight + item.weight() > maxweight)
			return new Pair<Integer, Item>(ERROR_OVER_BURDENED, null);
		
		size++;
		weight += item.weight();
		
		Item previous = null;
		
		if (items[index] == null)
		{
			items[index] = item;
			return new Pair<Integer, Item>(ERROR_NONE, null);
		}
		else
		{
			previous = items[index];
			items[index] = item;
			return new Pair<Integer, Item>(ERROR_NONE, previous);
		}
	}
	
	
	
	
	
	/**
	 * Increment the amount of gold. If ERROR_GOLD_CAPPED is returned, then
	 * gold was added, but capped to the max total.
	 */
	public int deposit(int gold)
	{
		if (this.gold + gold >= maxgold)
		{
			this.gold = maxgold;
			return ERROR_GOLD_CAPPED;
		}
		
		this.gold += gold;
		return ERROR_NONE;
	}
	
	
	
	
	
	
	/**
	 * Remove the given item from the inventory.
	 */
	public boolean remove(Item item)
	{
		for (int i = 0; i < maxsize; i++)
		{
			if (items[i].equals(item))
			{
				size--;
				weight -= items[i].weight();
				items[i] = null;
				return true;
			}
		}
		
		return false;
	}
	
	
	
	
	
	/**
	 * Removes the item at a given index.
	 */
	public Item remove(int index)
	{
		if (items[index] != null)
		{
			Item previous = items[index];
			size--;
			weight -= previous.weight();
			items[index] = null;
			return previous;
		}
		
		return null;
	}
	
	
	
	
	
	/**
	 * Decrement the amount of gold.
	 */
	public int withdraw(int gold)
	{
		if (this.gold - gold < 0)
		{
			return ERROR_INSUFFICIENT_GOLD;
		}
		
		this.gold -= gold;
		return ERROR_NONE;
	}
	
	
	
	
	
	/**
	 * Returns the array of items for this inventory.
	 */
	public Item[] items()
	{
		return items;
	}
	
	
	
	
	/**
	 * Returns the item at a given index.
	 */
	public Item get(int index)
	{
		return items[index];
	}
	
	
	
	
	
	/**
	 * Returns the index of a given item.
	 */
	public int indexOf(Item item)
	{
		for (int i = 0; i < maxsize; i++)
		{
			if (items[i].equals(item))
				return i;
		}
		
		return -1;
	}
	
	
	
	
	/**
	 * Returns the current size of the inventory.
	 */
	public int size()
	{
		return size;
	}
	
	
	
	
	/**
	 * Returns maximum size of the inventory.
	 */
	public int maxSize()
	{
		return maxsize;
	}
	
	
	
	
	/**
	 * Returns the amount of gold contained in the inventory.
	 */
	public int gold()
	{
		return gold;
	}
	
	
	
	
	
	/**
	 * Returns the maximum amount of gold the inventory can support.
	 */
	public int maxGold()
	{
		return maxgold;
	}
	
	
	
	
	/**
	 * Returns the total weight of all items in the inventory..
	 */
	public float weight()
	{
		return weight;
	}
	
	
	
	
	/**
	 * Returns the weight of an item at the given index.
	 */
	public float weight(int index)
	{
		return items[index].weight();
	}
	
	
	
	
	/**
	 * Returns the maximum weight the inventory can support.
	 */
	public float maxWeight()
	{
		return maxweight;
	}
		
	
}
