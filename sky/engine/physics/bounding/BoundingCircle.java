package sky.engine.physics.bounding;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.physics.collisions.Projection;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class BoundingCircle extends Bounding
{
	/**
	 * Radius of the circle
	 */
	public float Radius = 0;
	
	
	
	
	
	
	/**
	 * Create a new bounding circle
	 */
	public BoundingCircle() { }
	

	/** 
	 * Create a new bounding circle
	 */	
	public BoundingCircle(Vector2d position, float radius)
	{
		super(position);
		Radius = radius;
		vertices = new Vector2d[2];
		isCircle = true;
	}
	
	
	/** 
	 * Create a new bounding circle
	 */	
	public BoundingCircle(float x, float y, float radius)
	{
		super(x, y);
		Radius = radius;
		vertices = new Vector2d[2];
		isCircle = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Project this bounding circle onto the given axis
	 */
	@Override
	public Projection project(Vector2d axis)
	{
		float rvx = Radius * axis.X;
		float rvy = Radius * axis.Y;

		this.vertices[0] = new Vector2d(Position.X + rvx, Position.Y + rvy);
		this.vertices[1] = new Vector2d(Position.X - rvx, Position.Y - rvy);
		
		float min = axis.dot(vertices[0]);
		float max = min;
		float p;
		
		for (int i = 0; i < vertices.length; i++)
		{
			p = axis.dot(vertices[i]);
			
			if (p < min) min = p;
			else if (p > max) max = p;
		}
		
		return new Projection(min, max);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Does this Bounding Circle intersect another Bounding Circle
	 */
	/*public boolean intersect(BoundingCircle circle)
	{
		float sqrmag = Position.squaredMagnitude(circle.Position);
		float sqrradius = (Radius * Radius) + (circle.Radius * circle.Radius);
		
		if (sqrmag <= sqrradius)
			return true;
		else
			return false;
	}*/
	
	
	
	
	
	
	
	
	
	/**
	 * Has the Bounding Circle been intersected by a point?
	 */
	/*@Override
	public boolean contains(Vector2 point)
	{
		float sqrmag = Position.squaredMagnitude(point);
		float sqrradius = (Radius * Radius);
		
		if (sqrmag <= sqrradius)
			return true;
		else
			return false;
	}*/
	
	
	
	
	

}
