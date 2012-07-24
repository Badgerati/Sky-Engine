package sky.engine.graphics.bounds;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.physics.collisions.Projection;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class BoundingOval extends Bounding
{
	/**
	 * 
	 */
	public float xRadius = 0;
	
	
	/**
	 * 
	 */
	public float yRadius = 0;
	
	
	
	
	
	
	

	
	
	/**
	 * Create new instance of a bounding Oval
	 */
	public BoundingOval(Vector2 position, float xradius, float yradius)
	{
		super(position);
		xRadius = xradius;
		yRadius = yradius;
		vertices = new Vector2[2];
		isCircle = true;
	}
	
	
	/**
	 * Create new instance of a bounding Oval
	 */
	public BoundingOval(float x, float y, float xradius, float yradius)
	{
		super(x, y);
		xRadius = xradius;
		yRadius = yradius;
		vertices = new Vector2[2];
		isCircle = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Project this bounding oval onto the given axis
	 */
	@Override
	public Projection project(Vector2 axis)
	{
		float rvx = xRadius * axis.X;
		float rvy = yRadius * axis.Y;

		this.vertices[0] = new Vector2(Position.X + rvx, Position.Y + rvy);
		this.vertices[1] = new Vector2(Position.X - rvx, Position.Y - rvy);
		
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
	
	
	
}
