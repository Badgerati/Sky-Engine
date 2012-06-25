package sky.engine.geometry.shapes;

import sky.engine.geometry.Vector2D;
import sky.engine.physics.collisions.Projection;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Oval extends Shape
{
	/**
	 * 
	 */
	protected float xRadius = 0;
	
	
	/**
	 * 
	 */
	protected float yRadius = 0;
	
	
	
	
	
	

	
	

	
	
	/********************************************
	 * 			PUBLIC CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a Geometric Oval
	 */
	public Oval(Vector2D position, float xradius, float yradius)
	{
		super(position);
		xRadius = xradius;
		yRadius = yradius;
		vertices = new Vector2D[2];
		isCircle = true;
	}
	
	
	/**
	 * Create new instance of a Geometric Oval from another Oval
	 */
	public Oval(Oval oval)
	{
		super(oval.Position);
		xRadius = oval.xRadius;
		yRadius = oval.xRadius;
		vertices = new Vector2D[2];
		isCircle = true;
	}

	
	
	
	
	
	

	
	/********************************************
	 * 			PROTECTED CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a Geometric Oval
	 */
	protected Oval(Vector2D position, float xradius, float yradius, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		xRadius = xradius;
		yRadius = yradius;
		vertices = new Vector2D[2];
		isCircle = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this oval
	 */
	public Oval clone()
	{
		return new Oval(Position, xRadius, yRadius);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public void setXRadius(float xradius)
	{
		xRadius = xradius;
	}
	
	
	
	
	
	
	/**
	 * 
	 */
	public void setYRadius(float yradius)
	{
		yRadius = yradius;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public float getXRadius()
	{
		return xRadius;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	public float getYRadius()
	{
		return yRadius;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return the approx circumference of this oval
	 */
	public float circumference()
	{
		return 2 * (float)Math.PI * (float)Math.sqrt( ((xRadius * xRadius) + (yRadius * yRadius)) * 0.5f );
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return the area of this oval
	 */
	@Override
	public float area()
	{
		return (float)Math.PI * xRadius * yRadius;	
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Project this oval onto the given axis
	 */
	@Override
	public Projection project(Vector2D axis)
	{
		float rvx = xRadius * axis.X;
		float rvy = yRadius * axis.Y;

		this.vertices[0] = new Vector2D(Position.X + rvx, Position.Y + rvy);
		this.vertices[1] = new Vector2D(Position.X - rvx, Position.Y - rvy);
		
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
