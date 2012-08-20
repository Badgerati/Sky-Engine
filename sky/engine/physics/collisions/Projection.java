package sky.engine.physics.collisions;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Projection
{
	/**
	 * Minimum value of projection
	 */
	public final float min;
	
	
	/**
	 * Maximum value of projection
	 */
	public final float max;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new projection object
	 */
	public Projection(float min, float max)
	{
		this.min = min;
		this.max = max;
	}
	
	
	
	
	
	
	
	
	/**
	 * Does the given projection overlap this one?
	 */
	public boolean overlap(Projection p2)
	{
		if (min > p2.max || max < p2.min)
			return false;
		
		return true;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the overlap value
	 */
	public float getOverlap(Projection p2)
	{
		float l_max, l_min;
		
		if (min > p2.min)
			l_min = min;
		else
			l_min = p2.min;
		
		if (max < p2.max)
			l_max = max;
		else
			l_max = p2.max;
		
		return l_max - l_min;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns whether this projection contains the given one
	 */
	public boolean contains(Projection p2)
	{
		if (min <= p2.min && max >= p2.max)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the string representation of this projection
	 */
	public String toString()
	{
		return "(min = " + Float.toString(min) + ", max = " + Float.toString(max) + ")";
	}

}
