package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2d;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Line extends Shape
{

	/**
	 * Create new instance of a line
	 */
	public Line(Vector2d v1, Vector2d v2)
	{
		super(v1.midpoint(v2));
		initialise(v1, v2);
	}
	
	
	/**
	 * Create new instance of a line
	 */
	//public Line(Vector2d v1, Vector2d v2, Vector2d velocity, float mass)
	//{
	//	super(v1.midpoint(v2), velocity, mass);
	//	initialise(v1, v2);
	//}
	
	
	/**
	 * Create new instance of a line
	 */
	public Line(Line line)
	{
		super(line.Position, line.Velocity, line.Mass);
		initialise(line.vertices[0], line.vertices[1]);
	}
	
	
	
	
	
	
	/**
	 * Initialise the vertices of this line
	 */
	private void initialise(Vector2d v1, Vector2d v2)
	{
		vertices = new Vector2d[2];
		vertices[0] = v1.clone();
		vertices[1] = v2.clone();
	}
	
	
	
	
	
	
	/**
	 * Clone this line
	 */
	public Line clone()
	{
		return new Line(this);
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
	public Vector2d midpoint()
	{
		return new Vector2d((vertices[0].X + vertices[1].X) * 0.5f, (vertices[0].Y + vertices[1].Y) * 0.5f);
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
