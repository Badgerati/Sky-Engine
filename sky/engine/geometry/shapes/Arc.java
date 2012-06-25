package sky.engine.geometry.shapes;

import sky.engine.geometry.Vector2D;
import sky.engine.math.Angle;

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
	
	
	
	
	
	

	
	

	
	
	/********************************************
	 * 			PUBLIC CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a Geometric Arc
	 */
	public Arc(Vector2D position, float radius, float startangle, float sweepangle)
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
		super(arc.Position, arc.Radius);
		StartAngle = arc.StartAngle;
		SweepAngle = arc.SweepAngle;
	}

	
	
	
	
	
	

	
	/********************************************
	 * 			PROTECTED CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a Geometric Arc
	 */
	protected Arc(Vector2D position, float radius, float startangle, float sweepangle, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		StartAngle = startangle;
		SweepAngle = sweepangle;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this arc
	 */
	public Arc clone()
	{
		return new Arc(Position, Radius, StartAngle, SweepAngle);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return the circumference of this arc
	 */
	@Override
	public float circumference()
	{
		return (SweepAngle * Angle.TO_RADIANS) * Radius;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return the area of this arc
	 */
	@Override
	public float area()
	{
		return ((SweepAngle * Angle.TO_RADIANS) * 0.5f) * (Radius * Radius);
	}
	
	
	
	
}