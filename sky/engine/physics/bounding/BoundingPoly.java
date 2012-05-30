package sky.engine.physics.bounding;

import sky.engine.geometry.Vector2D;

/**
 * Bounding Polygons are to be created to bound more complicated objects.
 * In general, Bounding Polygons should be convex. If a concave one is
 * to be constructed, you should be wise to triangulate it.
 * 
 * @author Matthew Kelly  (Badgerati).
 * @deprecated
 *
 */
public class BoundingPoly extends Bounding
{
	
	
	/**
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2D[] vertices)
	{
		super();
		this.vertices = new Vector2D[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
		
		Position = Vector2D.getCentre(vertices);
	}
	
	
	/**
	 * Create new instance of a Bounding Polygon
	 */
	public BoundingPoly(Vector2D position, Vector2D[] vertices)
	{
		super(position);
		this.vertices = new Vector2D[vertices.length];
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = vertices[i].clone();
	}
	
	
	
	

}
