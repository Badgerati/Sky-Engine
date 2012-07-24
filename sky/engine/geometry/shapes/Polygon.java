package sky.engine.geometry.shapes;

import java.util.Random;

import android.graphics.Matrix;
import android.graphics.Path;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.math.Angle;

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
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2[] vertices)
	{
		super(Vector2.getCentre(vertices));
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2 position, int noOfVertices, float size)
	{
		super(position);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Creates new instance of a randomised geometric polygon
	 */
	public Polygon(Vector2 position, int noOfVertices, float minSize, float maxSize)
	{
		super(position);
		generateVertices(noOfVertices, minSize, maxSize);
	}
	
	
	/**
	 * Create new instance of a geometric polygon, with only a position
	 */
	protected Polygon(Vector2 position)
	{
		super(position);
	}
	
	
	/**
	 * Create new instance of a geometric polygon, with only a position
	 */
	protected Polygon(Vector2 position, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	protected Polygon(Vector2 position, Vector2[] vertices, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2[] vertices, Vector2 velocity, float mass)
	{
		super(Vector2.getCentre(vertices), velocity, mass);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a geometric polygon
	 */
	public Polygon(Vector2 position, int noOfVertices, float size, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Creates new instance of a randomised geometric polygon
	 */
	public Polygon(Vector2 position, int noOfVertices, float minSize, float maxSize, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
		generateVertices(noOfVertices, minSize, maxSize);
	}
	
	
	/**
	 * Create new Polygon from another geometric polygon
	 */
	public Polygon(Polygon poly)
	{
		super(poly.Position, poly.Velocity, poly.Mass);
		initialise(poly.vertices);
	}
	
	
	
	
	
	
	
	
	/**
	 * Initialises the vertices of this geometric polygon
	 */
	private void initialise(Vector2[] vertices)
	{
		this.vertices = new Vector2[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
	}
	
	
	
	
	
	
	
	/**
	 * Generates the vertices of this geometric polygon
	 */
	private void generateVertices(int noOfVertices, float minSize, float maxSize)
	{
		vertices = new Vector2[noOfVertices];
		Random rand = new Random();
		float degrees = 360.0f / noOfVertices;
		float range = maxSize - minSize;
		float x = (Angle.sin(0) * ((rand.nextFloat() * range) + minSize));
		float y = (Angle.cos(0) * ((rand.nextFloat() * range) - minSize));
		
		vertices[0] = new Vector2(x, y);
		for (int i = 1; i < noOfVertices; i++)
		{
			x = (Angle.sin((int)(degrees * i)) * ((rand.nextFloat() * range) + minSize));
			y = (Angle.cos((int)(degrees * i)) * ((rand.nextFloat() * range) - minSize));
			vertices[i] = new Vector2(x, y);
		}
		
		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	
	
	
	
	/**
	 * Clone this geometric polygon
	 */
	public Polygon clone()
	{
		return new Polygon(this);
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the area of this geometric polygon
	 */
	@Override
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
	public void rotate(int degree, Vector2 origin)
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
			Vector2 scaleVel = Velocity.mulScalar(dt);
			matrix.reset();
			matrix.postTranslate(scaleVel.X, scaleVel.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	
	
	
	
	/**
	 * Integrate this geometric polygon
	 */
	@Override
	public void integrate(Vector2 velocity, float dt)
	{
		super.integrate(velocity, dt);
		
		if (matrix != null)
		{
			Vector2 scaleVel = velocity.mulScalar(dt);
			matrix.reset();
			matrix.postTranslate(scaleVel.X, scaleVel.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	
	
	
	
	
	/**
	 * Set the position of this geometric polygon
	 */
	@Override
	public void setPosition(Vector2 position)
	{
		Vector2 delta = position.sub(Position);
		super.setPosition(position);
		
		if (matrix != null)
		{
			matrix.reset();
			matrix.postTranslate(delta.X, delta.Y);
			
			polygon.transform(matrix);
		}
	}
	
	
	

}
