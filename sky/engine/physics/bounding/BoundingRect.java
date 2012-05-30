package sky.engine.physics.bounding;

import sky.engine.components.Size;
import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 * @deprecated
 *
 */
public class BoundingRect extends Bounding
{


	/** 
	 * Create a new bounding rectangle
	 */
	public BoundingRect(Vector2D position, float width, float height)
	{
		super(position);
		build(width, height);
	}
	

	/** 
	 * Create a new bounding rectangle
	 */
	public BoundingRect(Vector2D position, Size size)
	{
		super(position);
		build(size.Width, size.Height);
	}
	

	/** 
	 * Create a new bounding rectangle
	 */
	public BoundingRect(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{		
		super();
		this.vertices = new Vector2D[4];
		
		this.vertices[0] = v1.clone();
		this.vertices[1] = v2.clone();
		this.vertices[2] = v3.clone();
		this.vertices[3] = v4.clone();

		Position = Vector2D.getCentre(new Vector2D[] { v1, v2, v3, v4 });
	}
	

	/** 
	 * Create a new bounding rectangle
	 */
	public BoundingRect(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{
		super(position);
		this.vertices = new Vector2D[4];
		
		this.vertices[0] = v1.clone();
		this.vertices[1] = v2.clone();
		this.vertices[2] = v3.clone();
		this.vertices[3] = v4.clone();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * build rectangle from width and height
	 */
	private void build(float width, float height)
	{
		this.vertices = new Vector2D[4];
		
		this.vertices[0] = new Vector2D(width * -0.5f, height * -0.5f);
		this.vertices[1] = new Vector2D(width * 0.5f, height * -0.5f);
		this.vertices[2] = new Vector2D(width * 0.5f, height * 0.5f);
		this.vertices[3] = new Vector2D(width * -0.5f, height * 0.5f);
		
		for (int i = 0; i < this.vertices.length; i++)
			this.vertices[i].integrate(Position.X, Position.Y);
	}
	
	
	
	
	
	
	
	
	
	
	/** Does this BoundingRect intersect another BoundingRect */
	//public boolean intersect(BoundingRect rect)
	//{
	//	return SATCollision.booleanCheck(this.vertices, rect.vertices);
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	/** Has the bounding rectangle been intersected by a point? */
	//public boolean contains(Vector2D point)
	//{
	//	Vector2D diff = this.Position.sub(point);
	//	Vector2D squaredDiff = diff.square();
	//
	//	float width = (Width * 0.5f) * (Width * 0.5f);
	//	float height = (Height * 0.5f) * (Height * 0.5f);
	//	
	//	if (squaredDiff.X <= width && squaredDiff.Y <= height)
	//		return true;
	//	else
	//		return false;
	//}
	
	
	
	

}
