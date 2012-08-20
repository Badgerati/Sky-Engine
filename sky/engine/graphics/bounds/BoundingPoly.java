package sky.engine.graphics.bounds;

import java.util.Random;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.math.Angle;

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
	public BoundingPoly(Vector2[] vertices)
	{
		super(Vector2.getCentre(vertices));
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2 position, Vector2[] vertices)
	{
		super(position);
		initialise(vertices);
	}
	
	
	/**
	 * Create new instance of a bounding polygon
	 */
	public BoundingPoly(Vector2 position, int noOfVertices, float size)
	{
		super(position);
		generateVertices(noOfVertices, size, size);
	}
	
	
	/**
	 * Create new instance of a bounding polygon, with only a position
	 */
	protected BoundingPoly(Vector2 position)
	{
		super(position);
	}
	

	
	
	
	
	
	/**
	 * Initialises the vertices of this bounding polygon
	 */
	private void initialise(Vector2[] vertices)
	{
		this.vertices = new Vector2[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Generates the vertices of this bounding polygon
	 */
	private void generateVertices(int noOfVertices, float minSize, float maxSize)
	{
		vertices = new Vector2[noOfVertices];
		Random rand = new Random();
		float degrees = 360.0f / noOfVertices;
		float range = maxSize - minSize;
		float x = Angle.sin(0) * ((rand.nextFloat() * range) + minSize);
		float y = Angle.cos(0) * ((rand.nextFloat() * range) - minSize);
		
		vertices[0] = new Vector2(x, y);
		for (int i = 1; i < noOfVertices; i++)
		{
			x = Angle.sin((int)(degrees * i)) * ((rand.nextFloat() * range) + minSize);
			y = Angle.cos((int)(degrees * i)) * ((rand.nextFloat() * range) - minSize);
			vertices[i] = new Vector2(x, y);
		}
		
		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	

}
