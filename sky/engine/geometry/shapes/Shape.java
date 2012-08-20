package sky.engine.geometry.shapes;

import sky.engine.geometry.Circumcircle;
import sky.engine.geometry.ConvexHull;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.math.Angle;
import sky.engine.physics.bodies.CollidableBody;
import sky.engine.physics.bodies.RigidBody;
import sky.engine.physics.collisions.MTV;
import sky.engine.physics.collisions.Projection;
import sky.engine.physics.collisions.SATCollision;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Shape extends RigidBody implements CollidableBody
{
	/**
	 * Current degrees of rotation of this shape
	 */
	protected int degreesOfRotation;
	
	
	/**
	 * Does this shape represent a circle?
	 */
	protected boolean isCircle = false;
	
	
	/**
	 * List of vertices for the shape
	 */
	protected Vector2[] vertices = null;
	
	

	
	
	/**
	 * Create new instance of a shape
	 */
	public Shape(Vector2 position)
	{
		super(position, Vector2.zeros(), 1);
	}
	
	
	/**
	 * Create new instance of a shape that has mass and velocity
	 */
	public Shape(Vector2 position, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
	}
	
	
	
	
	/**
	 * Is this shape a circle?
	 */
	public boolean isCircle()
	{
		return isCircle;
	}
	
	
	
	
	/**
	 * Returns the shape's vertices
	 */
	public Vector2[] vertices()
	{
		return vertices;
	}
	
	
	
	
	/**
	 * Rotate the shape on the origin on given degree (and its vertices, if any)
	 */
	public void rotate(int degree)
	{
		degreesOfRotation = Angle.confineDegree(degreesOfRotation + degree);
		
		for (int i = 0; i < vertices.length; i++)
			if (vertices[i] != null)
				vertices[i].rotate(degree, Position);
	}

	
	
	
	
	/**
	 * Rotate the shape at the given origin on given degree (and its vertices, if any)
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
	 * Get the current degree of rotation of shape
	 */
	public int getDegrees()
	{
		return degreesOfRotation;
	}
	
	
	
	
	/**
	 * Returns the area of this Shape. Should be overridden.
	 */
	public float area()
	{
		return 0;
	}
	
	
	
	
	
	/**
	 * Integrate the position of this shape (and its vertices, if any)
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		
		if (vertices != null)
		{
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					vertices[i].integrate(Velocity.mulScalar(dt));
		}
	}
	
	
	
	
	/**
	 * Integrate the position of this shape (and its vertices, if any)
	 */
	@Override
	public void integrate(Vector2 velocity, float dt)
	{
		super.integrate(velocity, dt);
		
		if (vertices != null)
		{
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					vertices[i].integrate(velocity.mulScalar(dt));
		}
	}
	
	
	
	
	/**
	 * Set X position of shape (and its vertices, if any)
	 */
	@Override
	public void setXPosition(float value)
	{
		this.setPosition(new Vector2(value, Position.Y));
	}
	
	
	
	
	/**
	 * Set Y position of shape (and its vertices, if any)
	 */
	@Override
	public void setYPosition(float value)
	{
		this.setPosition(new Vector2(Position.X, value));
	}
	
	
	
	
	
	/**
	 * Set position of shape (and its vertices, if any)
	 */
	@Override
	public void setPosition(Vector2 position)
	{
		Vector2 delta = position.sub(Position);
		super.setPosition(position);

		if (vertices != null)
		{
			for (int i = 0; i < vertices.length; i++)
				if (vertices[i] != null)
					vertices[i].integrate(delta);
		}
	}
	
	
	
	
	
	/**
	 * Returns a Triangulation of this shape, fails if vertex count is less than 3.
	 */
	public Triangulation triangulate()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new Triangulation(vertices);
	}
	
	
	
	
	
	/**
	 * Returns a ConvexHull of this shape, fails if vertex count is less than 2.
	 */
	public ConvexHull convexhull()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new ConvexHull(vertices);
	}
	
	
	
	
	
	/**
	 * Returns a Circumcircle of this shape, fails if vertex count is less than 2.
	 */
	public Circumcircle circumcircle()
	{
		if (isCircle || vertices == null)
			return null;
		
		return new Circumcircle(vertices);
	}
	
	

	
	/**
	 * Does the given shape intersect this shape?
	 */
	public boolean intersect(CollidableBody shape2)
	{
		return SATCollision.intersect(this, shape2);
	}
	
	
	

	
	/**
	 * Get the amount of intersection between the given shape and this shape
	 */
	public MTV getIntersection(CollidableBody shape2)
	{
		return SATCollision.getIntersection(this, shape2);
	}
	
	
	
	
	/**
	 * Is the given point contained within this shape?
	 */
	public boolean contains(Vector2 point)
	{
		return SATCollision.contains(this, point);
	}
	
	
	
	
	/**
	 * Is the given point contained within this shape?
	 */
	public boolean contains(float x, float y)
	{
		return SATCollision.contains(this, x, y);
	}
	
	
	
	
	/**
	 * Returns this shape's axes
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
	 * Projects the this shape's vertices onto the given axis
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
	 * Returns the string representation of this shape's vertices
	 */
	public String toStringVertices()
	{
		String string = "(";
		
		for (int i = 0; i < vertices.length; i++)
		{
			string += "v" + Integer.toString(i + 1) + " = " + vertices[i].toString();
			
			if (i < vertices.length)
				string += ", ";
		}
		
		string += ")";
		return string;
	}
	
	
}
