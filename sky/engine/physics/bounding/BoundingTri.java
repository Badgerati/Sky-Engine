package sky.engine.physics.bounding;

import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 * @deprecated
 *
 */
public class BoundingTri extends Bounding
{
	
	
	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2D v1, Vector2D v2, Vector2D v3)
	{
		super();
		this.vertices = new Vector2D[3];
		
		this.vertices[0] = v1.clone();
		this.vertices[1] = v2.clone();
		this.vertices[2] = v3.clone();
		
		Position = Vector2D.getCentre(new Vector2D[] { v1, v2, v3 });
	}
	

	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3)
	{
		super(position);
		this.vertices = new Vector2D[3];
		
		this.vertices[0] = v1.clone();
		this.vertices[1] = v2.clone();
		this.vertices[2] = v3.clone();
	}
	

}
