package sky.engine.graphics.bounds;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class BoundingBox extends Bounding
{
	/**
	 * Width of bounding box
	 */
	protected float Width;
	
	
	/**
	 * Height of bounding box
	 */
	protected float Height;
	
	
	
	
	


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
	 * build bounding box from width and height
	 */
	private void build(float width, float height)
	{
		Width = width;
		Height = height;
		
		vertices = new Vector2[4];
		
		vertices[0] = new Vector2(width * -0.5f, height * -0.5f);
		vertices[1] = new Vector2(width * 0.5f, height * -0.5f);
		vertices[2] = new Vector2(width * 0.5f, height * 0.5f);
		vertices[3] = new Vector2(width * -0.5f, height * 0.5f);
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i].integrate(Position);
	}

	
	
	

	
	
	/**
	 * Set the bounding box's height
	 */
	public void setHeight(float height)
	{
		Height = height;
		build(Width, Height);
	}
	
	

	
	
	/**
	 * Get the bounding box's height
	 */
	public float getHeight()
	{
		return Height;
	}
	
	
	
	
	
	
	/**
	 * Set the bounding box's width
	 */
	public void setWidth(float width)
	{
		Width = width;
		build(Width, Height);
	}
	
	
	
	
	
	
	/**
	 * Get the bounding box's width
	 */
	public float getWidth()
	{
		return Width;
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
	 * 
	 * @deprecated
	 */
	public boolean _contains(Vector2 point)
	{
		Vector2 diff = this.Position.sub(point);
		Vector2 squaredDiff = diff.square();
	
		float width = (Width * 0.5f) * (Width * 0.5f);
		float height = (Height * 0.5f) * (Height * 0.5f);
		
		if (squaredDiff.X <= width && squaredDiff.Y <= height)
			return true;
		else
			return false;
	}
	
	
	
	

}
