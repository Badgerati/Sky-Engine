package sky.engine.graphics.bounds;

import sky.engine.components.Size;
import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class BoundingBox extends BoundingPoly
{


	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2D position, float width, float height)
	{
		super(position);
		build(width, height);
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2D position, Size size)
	{
		super(position);
		build(size.Width, size.Height);
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{		
		super(new Vector2D[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() });
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{
		super(position, new Vector2D[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() });
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * build bounding box from width and height
	 */
	private void build(float width, float height)
	{
		this.vertices = new Vector2D[4];
		
		this.vertices[0] = new Vector2D(width * -0.5f, height * -0.5f);
		this.vertices[1] = new Vector2D(width * 0.5f, height * -0.5f);
		this.vertices[2] = new Vector2D(width * 0.5f, height * 0.5f);
		this.vertices[3] = new Vector2D(width * -0.5f, height * 0.5f);
		
		for (int i = 0; i < this.vertices.length; i++)
			this.vertices[i].integrate(Position);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this bounding box's axes
	 */
	@Override
	public Vector2D[] getAxes()
	{
		Vector2D[] axes = new Vector2D[2];
		Vector2D edge, normal;
		
		for (int i = 0; i < 2; i++)
		{
			edge = vertices[i].sub(vertices[i + 1]);
			normal = edge.rightPerp();
			normal.normalise();
			axes[i] = normal;
		}
		
		return axes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Has the bounding box been intersected by a point?
	 */
	/*public boolean _contains(Vector2D point)
	{
		Vector2D diff = this.Position.sub(point);
		Vector2D squaredDiff = diff.square();
	
		float width = (Width * 0.5f) * (Width * 0.5f);
		float height = (Height * 0.5f) * (Height * 0.5f);
		
		if (squaredDiff.X <= width && squaredDiff.Y <= height)
			return true;
		else
			return false;
	}*/
	
	
	
	

}
