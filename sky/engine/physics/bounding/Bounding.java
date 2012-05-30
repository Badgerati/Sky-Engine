package sky.engine.physics.bounding;

import sky.engine.geometry.Angle;
import sky.engine.geometry.Vector2D;
import sky.engine.physics.collisions.SATCollision;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 * @deprecated
 */
public abstract class Bounding
{
	/**
	 * Position of the bound
	 */
	protected Vector2D Position = null;
	
	
	/**
	 * Vertices of this bound
	 */
	public Vector2D[] vertices = null;
	
	
	/**
	 * Is this bound a circle?
	 */
	protected boolean isCircle = false;
	
	
	/**
	 * Current degree of rotation of this bound
	 */
	private int degreesOfRotation;
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Bounding Volume
	 */
	protected Bounding()
	{
		Position = new Vector2D(0, 0);
	}

	
	/**
	 * Create new instance of a Bounding Volume
	 */
	protected Bounding(Vector2D position)
	{
		Position = position.clone();
	}

	
	/**
	 * Create new instance of a Bounding Volume
	 */
	protected Bounding(float x, float y)
	{
		Position = new Vector2D(x, y);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Integrate the position of this bound (and it's vertices, if any)
	 */
	public void integrate(Vector2D velocity, float dt)
	{
		Position.integrate(velocity.mulScalar(dt));
		
		if (vertices != null)
		{
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					vertices[i].integrate(velocity.mulScalar(dt));
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Set position of bound
	 */
	public void setPosition(Vector2D position)
	{
		Vector2D diff = position.sub(Position);
		
		Position.X = position.X;
		Position.Y = position.Y;

		if (vertices != null)
		{
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					vertices[i].integrate(diff);
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Get the bound's position
	 */
	public Vector2D getPosition()
	{
		return Position;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Triangulate this bound, fails if vertex count is less than 3
	 */
	public BoundingTri[] triangulate()
	{
		return null;
	}
	
	
	
	
	
	

	
	
	/**
	 * Does the given bound intersect this bound?
	 */
	public boolean intersect(Bounding bound)
	{
		return SATCollision.intersect(this, bound);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Is the given point contained within this bound?
	 */
	public boolean contains(Vector2D point)
	{
		return SATCollision.contains(this, point);
	}
	
	
	
	
	

	
	
	

	
	/**
	 * Rotate the bound at the origin on given degree
	 */
	public void rotate(int degree)
	{
		degreesOfRotation = Angle.confineDegree(degreesOfRotation + degree);
		
		for (int i = 0; i < vertices.length; i++)
			if (vertices[i] != null)
				vertices[i].rotate(degree, Position);
	}
	
	
	/**
	 * Rotate the bound at the given origin on given degree
	 */
	public void rotate(int degree, Vector2D origin)
	{
		degreesOfRotation = Angle.confineDegree(degreesOfRotation + degree);
		
		Position.rotate(degree, origin);
		
		for (int i = 0; i < vertices.length; i++)
			if (vertices[i] != null)
				vertices[i].rotate(degree, origin);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Get the current degree of rotation
	 */
	public int getDegrees()
	{
		return degreesOfRotation;
	}
	
	
	

	
	
	
	
	
	
	/**
	 * Is this bound a circle?
	 */
	public boolean isCircle()
	{
		return this.isCircle;
	}
	
	
	
	
	

}
