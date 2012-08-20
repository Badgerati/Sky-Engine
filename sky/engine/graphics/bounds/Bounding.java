package sky.engine.graphics.bounds;

import sky.engine.geometry.Circumcircle;
import sky.engine.geometry.ConvexHull;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.math.Angle;
import sky.engine.physics.bodies.CollidableBody;
import sky.engine.physics.collisions.MTV;
import sky.engine.physics.collisions.Projection;
import sky.engine.physics.collisions.SATCollision;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 */
public abstract class Bounding implements CollidableBody
{
	/**
	 * Position of the bound
	 */
	protected Vector2 Position = null;
	
	
	/**
	 * Vertices of this bound
	 */
	protected Vector2[] vertices = null;
	
	
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
	protected Bounding(Vector2 position)
	{
		Position = position.clone();
	}

	
	/**
	 * Create new instance of a Bounding Volume
	 */
	protected Bounding(float x, float y)
	{
		Position = new Vector2(x, y);
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
	public void rotate(int degree, Vector2 origin)
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
	public void integrate(Vector2 velocity, float dt)
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
	public void setPosition(Vector2 position)
	{
		Vector2 diff = position.sub(Position);
		
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
	 * Set X position of bound
	 */
	public void setXPosition(float x)
	{
		Vector2 pos = new Vector2(x, Position.Y);
		setPosition(pos);
	}
	
	
	
	
	
	
	/**
	 * Set Y position of bound
	 */
	public void setYPosition(float y)
	{
		Vector2 pos = new Vector2(Position.X, y);
		setPosition(pos);
	}
	

	
	
	
	
	
	/**
	 * Get the bound's position
	 */
	public Vector2 getPosition()
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
	public Vector2[] vertices()
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
	public boolean intersect(CollidableBody bound)
	{
		return SATCollision.intersect(this, bound);
	}
	
	
	
	
	
	
	
	/**
	 * Get the amount of intersection between the given bound and this bound
	 */
	public MTV getIntersection(CollidableBody bound)
	{
		return SATCollision.getIntersection(this, bound);
	}

	
	
	
	
	
	/**
	 * Is the given point contained within this bound?
	 */
	public boolean contains(Vector2 point)
	{
		return SATCollision.contains(this, point);
	}
	
	
	
	
	
	/**
	 * Is the given point contained within this bound?
	 */
	public boolean contains(float x, float y)
	{
		return SATCollision.contains(this, x, y);
	}
	
	
	
	
	
	
	/**
	 * Returns this bound's axes
	 */
	public Vector2[] getAxes()
	{
		Vector2[] axes = new Vector2[vertices.length];
		Vector2 edge, normal;
		
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
	public Projection project(Vector2 axis)
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
