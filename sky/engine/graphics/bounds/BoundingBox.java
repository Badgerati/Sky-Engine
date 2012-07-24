package sky.engine.graphics.bounds;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2;

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
	public BoundingBox(Vector2 position, float width, float height)
	{
		super(position);
		build(width, height);
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2 position, Size size)
	{
		super(position);
		build(size.Width, size.Height);
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4)
	{		
		super(new Vector2[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() });
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2 position, Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4)
	{
		super(position, new Vector2[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() });
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2[] vertices)
	{
		super(vertices);
		
		if (vertices.length != 4)
			throw new Error("You must supply exactly 4 vertices for a BoundingBox.");
	}
	

	/** 
	 * Create a new bounding box
	 */
	public BoundingBox(Vector2 position, Vector2[] vertices)
	{
		super(position, vertices);
		
		if (vertices.length != 4)
			throw new Error("You must supply exactly 4 vertices for a BoundingBox.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * build bounding box from width and height
	 */
	private void build(float width, float height)
	{
		this.vertices = new Vector2[4];
		
		this.vertices[0] = new Vector2(width * -0.5f, height * -0.5f);
		this.vertices[1] = new Vector2(width * 0.5f, height * -0.5f);
		this.vertices[2] = new Vector2(width * 0.5f, height * 0.5f);
		this.vertices[3] = new Vector2(width * -0.5f, height * 0.5f);
		
		for (int i = 0; i < this.vertices.length; i++)
			this.vertices[i].integrate(Position);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this bounding box's axes
	 */
	@Override
	public Vector2[] getAxes()
	{
		Vector2[] axes = new Vector2[2];
		Vector2 edge, normal;
		
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
