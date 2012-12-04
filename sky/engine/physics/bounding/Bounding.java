package sky.engine.physics.bounding;

import sky.engine.geometry.Circumcircle;
import sky.engine.geometry.ConvexHull;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.math.AngleHelper;
import sky.engine.physics.bodies.ICollidableBody;
import sky.engine.physics.collisions.Contact;
import sky.engine.physics.collisions.Projection;
import sky.engine.physics.collisions.CollisionDetector;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 */
public abstract class Bounding implements ICollidableBody
{
	/**
	 * Position of the bound
	 */
	protected Vector2d Position = Vector2d.zeros();
	
	
	/**
	 * Vertices of this bound
	 */
	protected Vector2d[] vertices = null;
	
	
	/**
	 * Is this bound a circle?
	 */
	protected boolean isCircle = false;
	
	
	/**
	 * Current degree of rotation of this bound
	 */
	private float degreesOfRotation;
	
	
	
	
	
	
	
	/**
	 * Create a new Bounding Volume
	 */
	protected Bounding() { }
	
	
	/**
	 * Create new instance of a Bounding Volume
	 */
	protected Bounding(Vector2d position)
	{
		Position = position.clone();
	}

	
	/**
	 * Create new instance of a Bounding Volume
	 */
	protected Bounding(float x, float y)
	{
		Position = new Vector2d(x, y);
	}
	
	
	
	
	

	
	/**
	 * Rotate the bound at the origin on given degree
	 */
	public void rotate(float degree)
	{
		degreesOfRotation = AngleHelper.constrainAngle(degreesOfRotation + degree);
		
		for (int i = 0; i < vertices.length; i++)
			if (vertices[i] != null)
				vertices[i].rotate(degree, Position);
	}
	
	
	
	
	
	
	/**
	 * Rotate the bound at the given origin on given degree
	 */
	public void rotate(float degree, Vector2d origin)
	{
		degreesOfRotation = AngleHelper.constrainAngle(degreesOfRotation + degree);
		Position.rotate(degree, origin);
		
		for (int i = 0; i < vertices.length; i++)
			if (vertices[i] != null)
				vertices[i].rotate(degree, origin);
	}
	
	
	
	
	
	
	/**
	 * Integrate the position of this bound (and it's vertices, if any)
	 */
	public void integrate(Vector2d velocity, float dt)
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
	public void setPosition(Vector2d position)
	{
		Vector2d diff = position.sub(Position);
		
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
	 * Set position of bound
	 */
	public void setPosition(float x, float y)
	{
		float dx = x - Position.X;
		float dy = y - Position.Y;
		
		Position.X = x;
		Position.Y = y;
		
		if (vertices != null)
		{
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					vertices[i].integrate(dx, dy);
		}
	}
	
	
	
	
	
	
	/**
	 * Set X position of bound
	 */
	public void setXPosition(float x)
	{
		Vector2d pos = new Vector2d(x, Position.Y);
		setPosition(pos);
	}
	
	
	
	
	
	
	/**
	 * Set Y position of bound
	 */
	public void setYPosition(float y)
	{
		Vector2d pos = new Vector2d(Position.X, y);
		setPosition(pos);
	}
	

	
	
	
	
	
	/**
	 * Get the bound's position
	 */
	public Vector2d getPosition()
	{
		return Position;
	}
	
	
	
	
	
	/**
	 * Get the bound's X position
	 */
	public float getXPosition()
	{
		return Position.X;
	}
	
	
	
	
	
	/**
	 * Get the bound's Y position
	 */
	public float getYPosition()
	{
		return Position.Y;
	}
	
	
	
	
	
	
	
	/**
	 * Returns the vertices of this bound.
	 */
	public Vector2d[] vertices()
	{
		return vertices;
	}
	
	
	
	
	
	
	
	/**
	 * Triangulate this bound, fails if vertex count is less than 3. An array of
	 * Bounding Triangles is returned.
	 */
	public BoundingTri[] triangulateAsBound()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new Triangulation(this.vertices).asBounding();
	}
	
	
	
	
	
	
	
	/**
	 * Triangulate this bound, fails if vertex count is less than 3. A Triangulation
	 * object is returned.
	 */
	public Triangulation triangulate()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new Triangulation(this.vertices);
	}
	
	
	

	
	
	/**
	 * Convex hull this bound, fails if vertex count is less than 2. A Bounding
	 * Polygon is returned.
	 */
	public BoundingPoly convexAsBound()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new ConvexHull(this.vertices).asBounding();
	}
	
	
	
	
	
	
	
	/**
	 * Convex hull this bound, fails if vertex count is less than 2. A ConvexHull
	 * object is returned.
	 */
	public ConvexHull convexhull()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new ConvexHull(this.vertices);
	}
	
	
	

	
	
	/**
	 * Convex hull this bound, fails if vertex count is less than 2. A Bounding
	 * Polygon is returned.
	 */
	public BoundingCircle circumcircleAsBound()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new Circumcircle(this.vertices).asBounding();
	}
	
	
	
	
	
	
	
	/**
	 * Circumcircle this bound, fails if vertex count is less than 2. A Circumcircle
	 * object is returned.
	 */
	public Circumcircle circumcircle()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new Circumcircle(this.vertices);
	}
	
	
	
	

	
	
	/**
	 * Does the given bound intersect this bound?
	 */
	public boolean intersects(ICollidableBody bound)
	{
		return CollisionDetector.intersects(this, bound);
	}
	
	
	
	
	
	
	
	/**
	 * Get the amount of intersection between the given bound and this bound
	 */
	public Contact intersection(ICollidableBody bound)
	{
		return CollisionDetector.intersection(this, bound);
	}

	
	
	
	
	
	/**
	 * Is the given point contained within this bound?
	 */
	public boolean contains(Vector2d point)
	{
		return CollisionDetector.contains(this, point);
	}
	
	
	
	
	
	/**
	 * Is the given point contained within this bound?
	 */
	public boolean contains(float x, float y)
	{
		return CollisionDetector.contains(this, x, y);
	}
	
	
	
	
	
	
	/**
	 * Returns this bound's axes
	 */
	public Vector2d[] axes()
	{
		Vector2d[] axes = new Vector2d[vertices.length];
		Vector2d edge, normal;
		
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
	public Projection project(Vector2d axis)
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
	public float getDegrees()
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
