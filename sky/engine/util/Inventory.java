package sky.engine.util;

import sky.engine.components.Pair;


/**
 * Interface to help create Inventory data structures. An inventory is a data structure
 * which hold items limited by size and weight, as well as storing gold.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public interface Inventory
{
	/**
	 * Unknown errors should never really occur. If they done, well, who knows...
	 */
	public static final int ERROR_UNKNOWN = -1;
	
	/**
	 * No error has occurred, and everything was successful.
	 */
	public static final int ERROR_NONE = 0;
	
	/**
	 * The inventory is full of items, and you cannot carry anymore.
	 */
	public static final int ERROR_BAGS_FULL = 1;
	
	/**
	 * You are carrying too much weight already, and cannot carry anymore.
	 */
	public static final int ERROR_OVER_BURDENED = 2;
	
	/**
	 * Maximum amount of gold has been reached.
	 */
	public static final int ERROR_GOLD_CAPPED = 3;
	
	/**
	 * There is no gold left in the inventory.
	 */
	public static final int ERROR_INSUFFICIENT_GOLD = 4;
	
	
	/**
	 * Returns a clone of this inventory.
	 */
	public Inventory clone();
	
	
	/**
	 * Add a new item to the inventory.
	 */
	public int add(Item item);
	
	
	/**
	 * Add item to inventory at given index.
	 */
	public Pair<Integer, Item> add(Item item, int index);
	
	
	/**
	 * Deposits (increments) the amount of gold.
	 */
	public int deposit(int gold);
	
	
	/**
	 * Remove an item from the inventory.
	 */
	public boolean remove(Item item);
	
	
	/**
	 * Remove item from inventory at given index.
	 */
	public Item remove(int index);
	
	
	/**
	 * Withdraw (remove) an amount of gold.
	 */
	public int withdraw(int gold);
	
	
	/**
	 * Returns array of all items.
	 */
	public Item[] items();
	
	
	/**
	 * Returns the item at a given index.
	 */
	public Item get(int index);
	
	
	/**
	 * Returns the index of a given item.
	 */
	public int indexOf(Item item);
	
	
	/**
	 * Returns maximum size of the inventory.
	 */
	public int maxSize();
	
	
	/**
	 * Returns the current size of the inventory.
	 */
	public int size();
	
	
	/**
	 * Returns the amount of gold contained in the inventory.
	 */
	public int gold();
	
	
	/**
	 * Returns the maximum amount of gold the inventory can support.
	 */
	public int maxGold();
	
	
	/**
	 * Returns the total weight of all items in the inventory..
	 */
	public float weight();
	
	
	/**
	 * Returns the weight of an item at the given index.
	 */
	public float weight(int index);
	
	
	/**
	 * Returns the maximum weight the inventory can support.
	 */
	public float maxWeight();
	
	
	
	
}
