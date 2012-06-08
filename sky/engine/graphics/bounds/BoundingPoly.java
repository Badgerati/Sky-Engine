package sky.engine.graphics.bounds;

import java.util.Random;

import sky.engine.geometry.Angle;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.Vector2D;

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
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2D[] vertices)
	{
		super(Vector2D.getCentre(vertices));
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2D position, Vector2D[] vertices)
	{
		super(position);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a bounding polygon
	 */
	public BoundingPoly(Vector2D position, int noOfVertices, float size)
	{
		super(position);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Create new instance of a bounding polygon, with only a position
	 */
	protected BoundingPoly(Vector2D position)
	{
		super(position);
	}
	

	
	
	
	
	
	
	
	
	/**
	 * Initialises the vertices of this bounding polygon
	 */
	private void initialise(Vector2D[] vertices)
	{
		this.vertices = new Vector2D[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Generates the vertices of this bounding polygon
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
	 * Triangulate this bound, fails if vertex count is less than 3.
	 */
	@Override
	public BoundingTri[] triangulateAsBound()
	{
		return new Triangulation(this.vertices).asBounding();
	}
	
	
	/**
	 * Triangulate this bound, fails if vertex count is less than 3.
	 */
	public Triangulation triangulate()
	{
		return new Triangulation(this.vertices);
	}
	
	
	
	
	
	
	
	
	

}
