package sky.engine.physics.collisions;

import sky.engine.geometry.vectors.Vector2d;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Contact
{
	/**
	 * Axis with smallest overlap to move shapes along
	 */
	private final Vector2d axis;
	
	
	/**
	 * The overlap value
	 */
	private final float overlap;
	
	
	
	
	
	
	
	
	/**
	 * Construct a new Contact object
	 */
	public Contact(Vector2d axis, float overlap)
	{
		this.axis = axis;
		this.overlap = overlap;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the axis
	 */
	public Vector2d getAxis()
	{
		return axis;
	}
	
	
	
	
	
	
	/**
	 * Returns the overlap
	 */
	public float getOverlap()
	{
		return overlap;
	}
	

}
