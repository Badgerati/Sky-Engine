package sky.engine.physics.bounding;

import java.util.Random;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.math.AngleHelper;

/**
 * Bounding Polygons are to be created to bound more complicated objects.
 * In general, Bounding Polygons should be convex. If a concave one is
 * to be constructed, you should be wise to triangulate it.
 * 
 * @author Matthew Kelly  (Badgerati).
 *
 */
public class BoundingPoly extends Bounding
{
	
	
	/**
	 * Create a new bounding Oval
	 */
	public BoundingPoly() { }
	

	/**
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2d[] vertices)
	{
		super(Vector2d.getCentre(vertices));
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2d position, Vector2d[] vertices)
	{
		super(position);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a bounding polygon
	 */
	public BoundingPoly(Vector2d position, int noOfVertices, float size)
	{
		super(position);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Create new instance of a bounding polygon, with only a position
	 */
	protected BoundingPoly(Vector2d position)
	{
		super(position);
	}
	

	
	
	
	
	
	/**
	 * Initialises the vertices of this bounding polygon
	 */
	public void initialise(Vector2d[] vertices)
	{
		this.vertices = new Vector2d[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Generates the vertices of this bounding polygon
	 */
	public void generateVertices(int noOfVertices, float minSize, float maxSize)
	{
		vertices = new Vector2d[noOfVertices];
		Random rand = new Random();
		float degrees = 360.0f / noOfVertices;
		float range = maxSize - minSize;
		float x = AngleHelper.sin(0) * ((rand.nextFloat() * range) + minSize);
		float y = AngleHelper.cos(0) * ((rand.nextFloat() * range) - minSize);
		
		vertices[0] = new Vector2d(x, y);
		for (int i = 1; i < noOfVertices; i++)
		{
			x = AngleHelper.sin((int)(degrees * i)) * ((rand.nextFloat() * range) + minSize);
			y = AngleHelper.cos((int)(degrees * i)) * ((rand.nextFloat() * range) - minSize);
			vertices[i] = new Vector2d(x, y);
		}
		
		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	

}
