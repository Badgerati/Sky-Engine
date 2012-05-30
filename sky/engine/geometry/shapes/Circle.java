package sky.engine.geometry.shapes;

import sky.engine.geometry.Vector2D;
import sky.engine.physics.collisions.Projection;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Circle extends Shape
{
	/** 
	 * This circle's radius
	 */
	public float Radius;
	
	
	
	
	
	

	
	

	
	
	/********************************************
	 * 			PUBLIC CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a Geometric Circle
	 */
	public Circle(Vector2D position, float radius)
	{
		super(position);
		Radius = radius;
		vertices = new Vector2D[2];
		isCircle = true;
	}
	
	
	/**
	 * Create new instance of a Geometric Circle from another Circle
	 */
	public Circle(Circle circle)
	{
		super(circle.Position);
		Radius = circle.Radius;
		vertices = new Vector2D[2];
		isCircle = true;
	}

	
	
	
	
	
	

	
	/********************************************
	 * 			PROTECTED CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a Geometric Circle
	 */
	protected Circle(Vector2D position, float radius, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		Radius = radius;
		vertices = new Vector2D[2];
		isCircle = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this circle
	 */
	public Circle clone()
	{
		return new Circle(Position, Radius);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return the circumference of this circle
	 */
	public float circumference()
	{
		return ((float)Math.PI * Radius);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Return the area of this circle
	 */
	public float area()
	{
		return (Radius * Radius) * (float)Math.PI;		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Project this circle onto the given axis
	 */
	@Override
	public Projection project(Vector2D axis)
	{
		float rvx = Radius * axis.X;
		float rvy = Radius * axis.Y;

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
