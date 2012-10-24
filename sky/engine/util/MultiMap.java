package sky.engine.util;

import java.util.HashMap;

/**
 * 
 * A MultiMap works in much the same way as arrays do in PHP. That is, we can have a key
 * of any type with a corresponding value of any type. So we could insert a key-value pair
 * of types <String, Integer>, and then later another pair of <Float, Boolean>, and the
 * MultiMap will allow this.
 * 
 * Furthermore, the MultiMap is an map of an array, so we could have the following
 * structure:
 * 
 * 		[<String>]	--> [<String>, <Integer>]
 * 						[<Float>, <Boolean>]
 * 
 * 		[<String>]	--> [<String>, <Integer>]
 * 						[<Float>, <Boolean>]
 * 
 * 		[<String>]	--> [<Vector2D>, <Double>]
 * 						[<Long>, <Byte>]
 * 
 * etc. Where it is structured like so:
 * 
 * 		[map-key] --> [key, value]
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class MultiMap<K> extends HashMap<K, ObjectMap>
{

	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 442732809846071759L;





	/**
	 * Create new instance of a MultiMap
	 */
	public MultiMap()
	{
		
	}
	
	
	
	
	
	/**
	 * Add 2 new key-value pairs, creating a new mapping with given indexkey
	 * 
	 * @param indexkey - Main index key for the Map
	 * @param key1 - First key to add
	 * @param value1 - First value to add
	 * @param key2 - Second key to add
	 * @param value2 - Second value to add
	 * @return Any previous mapping
	 */
	public ObjectMap add(K indexkey, Object key1, Object value1, Object key2, Object value2)
	{
		ObjectMap temp = new ObjectMap();
		temp.put(key1, value1);
		temp.put(key2, value2);
		return this.put(indexkey, temp);
	}
	
	
	
	
	/**
	 * Add a new key-value pair to an existing mapping at the given indexkey. creating new
	 * indexkey mapping if it doesn't already exist
	 * 
	 * @param indexkey - Key of mapping to insert given pair
	 * @param key - Key to add
	 * @param value - Value to add
	 * @return Any previous mapping
	 */
	public Object add(K indexkey, Object key, Object value)
	{
		if (this.containsKey(indexkey))
		{
			return this.get(indexkey).put(key, value);
		}
		else
		{
			ObjectMap temp = new ObjectMap();
			temp.put(key, value);
			return this.put(indexkey, temp);
		}
	}
	
	
	
	
	
	/**
	 * Add an array of new key-value pairs to an existing mapping at the given indexkey. creating new
	 * indexkey mapping if it doesn't already exist
	 * 
	 * @param index - Index of array to insert given pairs to
	 * @param keys - Keys to add
	 * @param values - Values to add
	 * @return Any previous mapping
	 */
	public void add(K indexkey, Object[] keys, Object[] values)
	{
		if (this.containsKey(indexkey))
		{
			this.get(indexkey).put(keys, values);
		}
		else
		{
			ObjectMap temp = new ObjectMap(keys, values);
			this.put(indexkey, temp);
		}
	}
}
