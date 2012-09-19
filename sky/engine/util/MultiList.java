package sky.engine.util;

import java.util.ArrayList;

/**
 * A MultiList works in much the same way as arrays do in PHP. That is, we can have a key
 * of any type with a corresponding value of any type. So we could insert a key-value pair
 * of types <String, Integer>, and then later another pair of <Float, Boolean>, and the
 * MultiList will allow this.
 * 
 * Furthermore, the MultiList is an array of an array, so we could have the following
 * structure:
 * 
 * 		[0]	--> [<String>, <Integer>]
 * 				[<Float>, <Boolean>]
 * 
 * 		[1]	--> [<String>, <Integer>]
 * 				[<Float>, <Boolean>]
 * 
 * 		[2]	--> [<Vector2D>, <Double>]
 * 				[<Long>, <Byte>]
 * 
 * etc. Where it is structured like so:
 * 
 * 		[array-index] --> [key, value]
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class MultiList extends ArrayList<ObjectMap>
{
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -839815873773099212L;
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a MultiMap.
	 */
	public MultiList()
	{
		
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * Add a new key-value pair to the MultiList.
	 * 
	 * @param key - Key to add.
	 * @param value - Value to add.
	 * @return Whether operation was successful.
	 */
	public boolean add(Object key, Object value)
	{
		ObjectMap temp = new ObjectMap();
		temp.put(key, value);
		return this.add(temp);
	}
	
	
	/**
	 * Add 2 new key-value pairs to the MultiList.
	 * 
	 * @param key1 - First key to add.
	 * @param value1 - First value to add.
	 * @param key2 - Second key to add.
	 * @param value2 - Second value to add.
	 * @return Whether operation was successful.
	 */
	public boolean add(Object key1, Object value1, Object key2, Object value2)
	{
		ObjectMap temp = new ObjectMap();
		temp.put(key1, value1);
		temp.put(key2, value2);
		return this.add(temp);		
	}
	
	
	/**
	 * Add a new key-value pair to an existing array at the given index.
	 * 
	 * @param index - Index of array to insert given pair to.
	 * @param key - Key to add.
	 * @param value - Value to add.
	 * @return Whether operation was successful.
	 * @throws IndexOutOfBoundsExcepton.
	 */
	public boolean add(int index, Object key, Object value)
	{
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		
		this.get(index).put(key, value);
		return true;
	}
	
	
	/**
	 * Add an array of new key-value pairs to the MultiList.
	 * 
	 * @param keys - Keys to add.
	 * @param values - Values to add.
	 * @return Whether operation was successful.
	 * @throws IndexOutOfBoundsExcepton.
	 */
	public boolean add(Object[] keys, Object[] values)
	{
		//if (keys.length != values.length)
		//	throw new Error("The length of keys must equal the length of values given.");
		
		ObjectMap temp = new ObjectMap(keys, values);
		
		//for (int i = 0; i < keys.length; i++)
		//	temp.put(keys[i], values[i]);
		
		return this.add(temp);
	}
	
	
	/**
	 * Add an array of new key-value pairs to an existing array at the given index.
	 * 
	 * @param index - Index of array to insert given pairs to.
	 * @param keys - Keys to add.
	 * @param values - Values to add.
	 * @return Whether operation was successful.
	 * @throws IndexOutOfBoundsExcepton.
	 */
	public boolean add(int index, Object[] keys, Object[] values)
	{
		if (index < 0 || index >= this.size())
			throw new IndexOutOfBoundsException();
		
		this.get(index).put(keys, values);
		
		//if (keys.length != values.length)
		//	throw new Error("The length of keys must equal the length of values given.");
		
		//ObjectMap temp = this.get(index);
		
		//for (int i = 0; i < keys.length; i++)
		//	temp.put(keys[i], values[i]);
		
		return true;
	}
	
	
	
	
	
	
	

}
