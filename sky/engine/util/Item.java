package sky.engine.util;

import sky.engine.graphics.textures.Texture;

/**
 * Interface to help create items for storage with an Inventory data structure.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public interface Item
{
	/**
	 * Number of this item currently stacked - such as 'a stack of 4 health potions'.
	 */
	public int numberInStack();
	
	
	/**
	 * Returns the item's image.
	 */
	public Texture image();
	
	
	/**
	 * Returns the name of this item.
	 */
	public String name();
	
	
	/**
	 * Returns the description of this item.
	 */
	public String description();
	
	
	/**
	 * Returns the full information about the item - including name/description
	 * TODO: XML parsing.
	 */
	public String info();
	
	
	/**
	 * Returns the weight of the item.
	 */
	public float weight();
	
	
	/**
	 * Does the item equal the given one?
	 */
	@Override
	public boolean equals(Object item);
	
	
	/**
	 * Returns the hash code of this item.
	 */
	@Override
	public int hashCode();
	
	
	/**
	 * Returns a clone of this item
	 */
	public Item clone();
	
	
}
