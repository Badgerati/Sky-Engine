package sky.engine.components;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.physics.bounding.BoundingCircle;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class Pointer
{
	
	/**
	 * Bounding volume for the Pointer
	 */
	public BoundingCircle pointerbound = null;
	
	

	
	/**
	 * Create a new Pointer
	 */
	public Pointer(Vector2d position, float radius)
	{
		pointerbound = new BoundingCircle(position, radius);
	}
	
	
	/**
	 * Create a new Pointer
	 */
	public Pointer(float x, float y, float radius)
	{
		pointerbound = new BoundingCircle(x, y, radius);
	}
	

	
	
	
	/**
	 * Sets the position and radius of the Pointer
	 */
	public void set(Vector2d position, float radius)
	{
		pointerbound.setPosition(position);
		pointerbound.Radius = radius;
	}
	
	
	/**
	 * Sets the position and radius of the Pointer
	 */
	public void set(float x, float y, float radius)
	{
		pointerbound.setPosition(x, y);
		pointerbound.Radius = radius;
	}
	
}
