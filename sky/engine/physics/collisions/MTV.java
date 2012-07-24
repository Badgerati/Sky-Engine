package sky.engine.physics.collisions;

import sky.engine.geometry.vectors.Vector2;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class MTV
{
	/**
	 * Axis with smallest overlap to move shapes along
	 */
	private final Vector2 axis;
	
	
	/**
	 * The overlap value
	 */
	private final float overlap;
	
	
	
	
	
	
	
	
	/**
	 * Construct a new MTV object
	 */
	public MTV(Vector2 axis, float overlap)
	{
		this.axis = axis;
		this.overlap = overlap;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the axis
	 */
	public Vector2 getAxis()
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
