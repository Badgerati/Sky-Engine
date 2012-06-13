package sky.engine.geometry.shapes;

import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Line extends Shape
{

	
	/********************************************
	 * 			PUBLIC CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a line
	 */
	public Line(Vector2D position, Vector2D v1, Vector2D v2)
	{
		super(position);
		initialise(v1, v2);
	}
	
	
	/**
	 * Create new instance of a line
	 */
	public Line(Vector2D v1, Vector2D v2)
	{
		super(v1.midpoint(v2));
		initialise(v1, v2);
	}
	

	
	

	
	/********************************************
	 * 			PROTECTED CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a line
	 */
	protected Line(Vector2D position, Vector2D v1, Vector2D v2, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(v1, v2);
	}
	
	
	/**
	 * Create new instance of a line
	 */
	protected Line(Vector2D v1, Vector2D v2, Vector2D velocity, float mass)
	{
		super(v1.midpoint(v2), velocity, mass);
		initialise(v1, v2);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialise the vertices of this line
	 */
	private void initialise(Vector2D v1, Vector2D v2)
	{
		vertices = new Vector2D[2];
		vertices[0] = v1.clone();
		vertices[1] = v2.clone();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this line
	 */
	public Line clone()
	{
		return new Line(this.Position, vertices[0], vertices[1]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the length of this line
	 */
	public float length()
	{
		return vertices[0].magnitude(vertices[1]);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the true midpoint of this line
	 */
	public Vector2D midpoint()
	{
		return new Vector2D((vertices[0].X + vertices[1].X) * 0.5f, (vertices[0].Y + vertices[1].Y) * 0.5f);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the slope of this line.
	 */
	public float getSlope()
	{
		float xdiff = vertices[1].X - vertices[0].X;
		float ydiff = vertices[1].Y - vertices[0].Y;
		return ydiff / -xdiff;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the y-intercept of this line.
	 */
	public float getYintercept()
	{
		float xdiff = vertices[1].X - vertices[0].X;
		float ydiff = vertices[1].Y - vertices[0].Y;
		return ((vertices[0].Y * xdiff) - (vertices[0].X * ydiff)) / -xdiff;
	}
	
	
	
	
	

}
