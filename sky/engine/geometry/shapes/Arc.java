package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.math.AngleHelper;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Arc extends Circle
{
	/**
	 * 
	 */
	public float StartAngle = 0;
	
	
	/**
	 * 
	 */
	public float SweepAngle = 0;
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Geometric Arc
	 */
	public Arc(Vector2d position, float radius, float startangle, float sweepangle)
	{
		super(position, radius);
		StartAngle = startangle;
		SweepAngle = sweepangle;
	}
	
	
	/**
	 * Create new instance of a Geometric Arc from another Arc
	 */
	public Arc(Arc arc)
	{
		super(arc);
		StartAngle = arc.StartAngle;
		SweepAngle = arc.SweepAngle;
	}

	
	/**
	 * Create new instance of a Geometric Arc
	 */
	//public Arc(Vector2d position, float radius, float startangle, float sweepangle, Vector2d velocity, float mass)
	//{
	//	super(position, radius, velocity, mass);
	//	StartAngle = startangle;
	//	SweepAngle = sweepangle;
	//}
	
	
	
	
	
	
	
	/**
	 * Clone this arc
	 */
	public Arc clone()
	{
		return new Arc(this);
	}
	
	
	
	
	
	
	
	/**
	 * Return the circumference of this arc
	 */
	@Override
	public float circumference()
	{
		return (SweepAngle * AngleHelper.TO_RADIANS) * Radius;
	}
	
	
	
	
	
	
	/**
	 * Return the area of this arc
	 */
	@Override
	public float area()
	{
		return ((SweepAngle * AngleHelper.TO_RADIANS) * 0.5f) * (Radius * Radius);
	}
	
	
	
}
