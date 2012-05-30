package sky.engine.physics.collisions;

import sky.engine.geometry.Vector2D;

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
	private final Vector2D axis;
	
	
	/**
	 * The overlap value
	 */
	private final float overlap;
	
	
	
	
	
	
	
	
	/**
	 * Construct a new MTV object
	 */
	public MTV(Vector2D axis, float overlap)
	{
		this.axis = axis;
		this.overlap = overlap;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the axis
	 */
	public Vector2D getAxis()
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
