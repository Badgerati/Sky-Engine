package sky.engine.graphics.bounds;

import sky.engine.geometry.ConvexHull;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.Vector2D;
import sky.engine.math.Angle;
import sky.engine.physics.collisions.MTV;
import sky.engine.physics.collisions.Projection;
import sky.engine.physics.collisions.SATCollision;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
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
	 * Triangulate this bound, fails if vertex count is less than 3. Base of
	 * Bounding always returns null.
	 */
	public BoundingTri[] triangulateAsBound()
	{
		return null;
	}
	
	
	/**
	 * Triangulate this bound, fails if vertex count is less than 3. Base of
	 * Bounding always returns null.
	 */
	public Triangulation triangulate()
	{
		return null;
	}
	
	
	
	
	
	

	
	
	/**
	 * Convex hull this bound, fails if vertex count is less than 2. A Bounding
	 * Polygon is returned.
	 */
	public BoundingPoly convexAsBound()
	{
		return null;
	}
	
	
	/**
	 * Convex hull this bound, fails if vertex count is less than 2. A ConvexHull
	 * object is returned.
	 */
	public ConvexHull convex()
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
	 * Get the amount of intersection between the given bound and this bound
	 */
	public MTV getIntersection(Bounding bound)
	{
		return SATCollision.getIntersection(this, bound);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Is the given point contained within this bound?
	 */
	public boolean contains(Vector2D point)
	{
		return SATCollision.contains(this, point);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this bound's axes
	 */
	public Vector2D[] getAxes()
	{
		Vector2D[] axes = new Vector2D[vertices.length];
		Vector2D edge, normal;
		
		for (int i = 0; i < vertices.length; i++)
		{
			edge = vertices[i].sub(vertices[i + 1 < vertices.length ? i + 1 : 0]);
			normal = edge.rightPerp();
			normal.normalise();
			axes[i] = normal;
		}
		
		return axes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Projects the this bound's vertices onto the given axis
	 */
	public Projection project(Vector2D axis)
	{	
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
		return isCircle;
	}
	
	
	
	
	

}
