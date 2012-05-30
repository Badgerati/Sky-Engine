package sky.engine.geometry.shapes;

import java.util.Random;

import android.graphics.Matrix;
import android.graphics.Path;

import sky.engine.geometry.Angle;
import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Polygon extends Shape
{
	/**
	 * Path to hold the main graphical polygon
	 */
	protected Path polygon = null;
	
	
	/**
	 * Matrix to help with rotations
	 */
	protected Matrix matrix = null;
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************************
	 * 			PUBLIC CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2D position, Vector2D[] vertices)
	{
		super(position);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2D[] vertices)
	{
		super(Vector2D.getCentre(vertices));
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2D position, int noOfVertices, float size)
	{
		super(position);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Creates new instance of a randomised geometric polygon
	 */
	public Polygon(Vector2D position, int noOfVertices, float minSize, float maxSize)
	{
		super(position);
		generateVertices(noOfVertices, minSize, maxSize);
	}
	
	
	/**
	 * Create new Polygon from another geometric polygon
	 */
	public Polygon(Polygon poly)
	{
		super(poly.Position);
		initialise(poly.vertices);
	}
	
	
	
	
	

	
	/********************************************
	 * 			PROTECTED CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a geometric polygon, with only a position
	 */
	protected Polygon(Vector2D position)
	{
		super(position);
	}
	
	
	/**
	 * Create new instance of a geometric polygon, with only a position
	 */
	protected Polygon(Vector2D position, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	protected Polygon(Vector2D position, Vector2D[] vertices, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	protected Polygon(Vector2D[] vertices, Vector2D velocity, float mass)
	{
		super(Vector2D.getCentre(vertices), velocity, mass);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	protected Polygon(Vector2D position, int noOfVertices, float size, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Creates new instance of a randomised geometric polygon
	 */
	protected Polygon(Vector2D position, int noOfVertices, float minSize, float maxSize, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		generateVertices(noOfVertices, minSize, maxSize);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the vertices of this geometric polygon
	 */
	private void initialise(Vector2D[] vertices)
	{
		this.vertices = new Vector2D[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Generates the vertices of this geometric polygon
	 */
	private void generateVertices(int noOfVertices, float minSize, float maxSize)
	{
		vertices = new Vector2D[noOfVertices];
		Random rand = new Random();
		float degrees = 360.0f / noOfVertices;
		float range = maxSize - minSize;
		float x = (Angle.sin(0) * ((rand.nextFloat() * range) + minSize));
		float y = (Angle.cos(0) * ((rand.nextFloat() * range) - minSize));
		
		vertices[0] = new Vector2D(x, y);
		for (int i = 1; i < noOfVertices; i++)
		{
			x = (Angle.sin((int)(degrees * i)) * ((rand.nextFloat() * range) + minSize));
			y = (Angle.cos((int)(degrees * i)) * ((rand.nextFloat() * range) - minSize));
			vertices[i] = new Vector2D(x, y);
		}
		
		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this geometric polygon
	 */
	public Polygon clone()
	{
		return new Polygon(this.Position, this.vertices);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the area of this geometric polygon
	 */
	public float area()
	{
		float area = 0;
		int j = vertices.length - 1;
		
		for (int i = 0; i < vertices.length; i++)
		{
			area += ((vertices[j].X + vertices[i].X) * (vertices[j].Y - vertices[i].Y));
			j = i;
		}
		
		return (area * -0.5f);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the perimeter of this geometric polygon
	 */
	public float perimeter()
	{
		float peri = 0;
		int size = vertices.length;
		
		for (int i = 0; i < size; i++)
		{
			peri += vertices[i].magnitude(vertices[i + 1 < size ? i + 1 : 0]);
		}
		
		return peri;
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * Rotate this geometric polygon at the origin
	 */
	@Override
	public void rotate(int degree)
	{
		super.rotate(degree);
		
		if (matrix != null)
		{
			matrix.reset();
			
			matrix.postTranslate(-Position.X, -Position.Y);
			matrix.postRotate(degree);
			matrix.postTranslate(Position.X, Position.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	/**
	 * Rotate this geometric polygon at the given origin
	 */
	@Override
	public void rotate(int degree, Vector2D origin)
	{
		super.rotate(degree, origin);
		
		if (matrix != null)
		{
			matrix.reset();
			
			matrix.postTranslate(-origin.X, -origin.Y);
			matrix.postRotate(degree);
			matrix.postTranslate(origin.X, origin.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * Integrate this geometric polygon
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		
		if (matrix != null)
		{
			Vector2D scaleVel = Velocity.mulScalar(dt);
			matrix.reset();
			matrix.postTranslate(scaleVel.X, scaleVel.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	/**
	 * Integrate this geometric polygon
	 */
	@Override
	public void integrate(Vector2D velocity, float dt)
	{
		super.integrate(velocity, dt);
		
		if (matrix != null)
		{
			Vector2D scaleVel = velocity.mulScalar(dt);
			matrix.reset();
			matrix.postTranslate(scaleVel.X, scaleVel.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set the position of this geometric polygon
	 */
	@Override
	public void setPosition(Vector2D position)
	{
		Vector2D delta = position.sub(Position);
		super.setPosition(position);
		
		if (matrix != null)
		{
			matrix.reset();
			matrix.postTranslate(delta.X, delta.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	
	
	
	
	
	
	

}