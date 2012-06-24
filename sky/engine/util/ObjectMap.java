package sky.engine.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class ObjectMap extends HashMap<Object, Object>
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 777353952836455350L;


	
	
	
	
	
	
	
	/**
	 * 
	 */
	public ObjectMap() { }
	
	
	/**
	 * 
	 */
	public ObjectMap(Map<? extends Object, ? extends Object> map)
	{
		this.putAll(map);
	}
	
	
	/**
	 * 
	 */
	public ObjectMap(Object[] keys, Object[] values)
	{
		if (keys.length != values.length)
		{
			throw new Error("The length of keys must equal the length of values given.");
		}
		
		for (int i = 0; i < keys.length; i++)
		{
			this.put(keys[i], values[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public void put(Object[] keys, Object[] values)
	{
		if (keys.length != values.length)
		{
			throw new Error("The length of keys must equal the length of values given.");
		}
		
		for (int i = 0; i < keys.length; i++)
		{
			this.put(keys[i], values[i]);
		}
	}
	
}
