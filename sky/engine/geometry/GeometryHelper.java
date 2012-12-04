package sky.engine.geometry;

import java.util.Random;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.math.AngleHelper;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class GeometryHelper
{
	
	
	
	/**
	 * Returns an array of vertices centred around the (0,0) origin
	 */
	public static Vector2d[] generateVertices(int noOfVertices, float minSize, float maxSize)
	{
		Vector2d[] vertices = new Vector2d[noOfVertices];
		Random rand = new Random();
		float degrees = 360.0f / noOfVertices;
		float range = maxSize - minSize;
		float x = (AngleHelper.sin(0) * ((rand.nextFloat() * range) + minSize));
		float y = (AngleHelper.cos(0) * ((rand.nextFloat() * range) + minSize));
		
		vertices[0] = new Vector2d(x, y);
		for (int i = 1; i < noOfVertices; i++)
		{
			x = (AngleHelper.sin((int)(degrees * i)) * ((rand.nextFloat() * range) + minSize));
			y = (AngleHelper.cos((int)(degrees * i)) * ((rand.nextFloat() * range) + minSize));
			vertices[i] = new Vector2d(x, y);
		}
		
		return vertices;
	}
	
	
	
	
	
	/**
	 * Integrates an array of given vertices
	 */
	public static void integrate(Vector2d[] vertices, Vector2d integration)
	{
		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(integration);
	}
	
}
