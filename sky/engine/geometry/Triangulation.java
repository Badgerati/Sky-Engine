package sky.engine.geometry;

import sky.engine.geometry.shapes.Triangle;
import sky.engine.graphics.bounds.BoundingTri;
import sky.engine.graphics.drawable.shapes.DrawableTriangle;
import sky.engine.util.VisitorMap;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Triangulation
{
	/**
	 * Current triangulation, represented by a 2D array of Vectors.
	 */
	protected Vector2D[][] triangles = null;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Triangulation.
	 */
	public Triangulation()
	{
	}
	
	
	/**
	 * Create new instance of a Triangulation on an array of given right-winding vertices.
	 */
	public Triangulation(Vector2D[] vertices)
	{
		boolean bool = triangulate(vertices);
		
		if (!bool) {
			throw new Error("Number of vertices has to be greater than or equal to 3.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Triangulates an array of given right-winding vertices.
	 * 
	 * @return True if number of vertices is greater than or equal to 3, false otherwise.
	 */
	public boolean triangulate(Vector2D[] vertices)
	{
		if (vertices.length < 3)
			return false;
		
		
		triangles = new Vector2D[vertices.length - 2][3];
		
		VisitorMap<Vector2D, Vector2D> visitormap = new VisitorMap<Vector2D, Vector2D>();
		for (int i = 0; i < vertices.length; i++)
		{
			visitormap.add(vertices[i], vertices[i + 1 == vertices.length ? 0 : i + 1], false);
		}
		
		
		Vector2D current = vertices[0];
		int counter = 0;
		
		
		while (true)
		{
			Vector2D second = visitormap.getNext(current);
			Vector2D third = visitormap.getNext(second);
			
			if (second == null || third == null || current.equals(third))
			{
				break;
			}

			
			Vector2D dir1 = second.sub(current);
			dir1.normalise();
			Vector2D dir2 = third.sub(second);
			dir2.normalise();
			
			float cross = dir1.cross(dir2);
			
			if (cross >= 0)
			{
				triangles[counter][0] = current;
				triangles[counter][1] = second;
				triangles[counter][2] = third;
				counter++;
				
				visitormap.setVisited(current, second, true);
				visitormap.setVisited(second, third, true);
				visitormap.add(current, third, false);
				
				current = third;
			}
			else
			{
				current = second;
			}
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this triangulation as a raw array of vertices.
	 */
	public final Vector2D[][] asVertices()
	{
		return triangles;
	}
	
	
	
	
	
	
	
	/**
	 * Returns this triangulation as an array of geometric triangles.
	 */
	public Triangle[] asGeometric()
	{
		if (triangles == null)
			return null;
		
		int length = triangles.length;
		Triangle[] tri = new Triangle[length];
		
		for (int i = 0; i < length; i++)
		{
			tri[i] = new Triangle(triangles[i][0], triangles[i][1], triangles[i][2]);
		}
		
		return tri;
	}
	
	
	
	
	
	
	
	/**
	 * Returns this triangulation as an array of drawable triangles.
	 */
	public DrawableTriangle[] asDrawable()
	{
		if (triangles == null)
			return null;
		
		int length = triangles.length;
		DrawableTriangle[] tri = new DrawableTriangle[length];
		
		for (int i = 0; i < length; i++)
		{
			tri[i] = new DrawableTriangle(triangles[i][0], triangles[i][1], triangles[i][2]);
		}
		
		return tri;
	}
	
	
	
	
	
	
	
	/**
	 * Returns this triangulation as an array of bounding triangles.
	 */
	public BoundingTri[] asBounding()
	{
		if (triangles == null)
			return null;
		
		int length = triangles.length;
		BoundingTri[] tri = new BoundingTri[length];
		
		for (int i = 0; i < length; i++)
		{
			tri[i] = new BoundingTri(triangles[i][0], triangles[i][1], triangles[i][2]);
		}
		
		return tri;
	}
	
	
	

}
