package sky.engine.physics.bounding;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2d;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class BoundingOBB extends Bounding
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
	 * Create a new Bounding OBB
	 */
	public BoundingOBB() { }
	

	/** 
	 * Create a new bounding OBB
	 */
	public BoundingOBB(Vector2d position, float width, float height)
	{
		super(position);
		build(width, height);
	}
	

	/** 
	 * Create a new bounding OBB
	 */
	public BoundingOBB(Vector2d position, Size size)
	{
		super(position);
		build(size.Width, size.Height);
	}
	
	
	
	
	
	
	
	
	/**
	 * build bounding OBB from width and height
	 */
	private void build(float width, float height)
	{
		Width = width;
		Height = height;
		
		vertices = new Vector2d[4];
		
		vertices[0] = new Vector2d(width * -0.5f, height * -0.5f);
		vertices[1] = new Vector2d(width * 0.5f, height * -0.5f);
		vertices[2] = new Vector2d(width * 0.5f, height * 0.5f);
		vertices[3] = new Vector2d(width * -0.5f, height * 0.5f);
		
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i].integrate(Position);
	}

	
	
	

	
	
	/**
	 * Set the bounding OBB's height
	 */
	public void setHeight(float height)
	{
		Height = height;
		build(Width, height);
	}
	
	

	
	
	/**
	 * Get the bounding OBB's height
	 */
	public float getHeight()
	{
		return Height;
	}
	
	
	
	
	
	
	/**
	 * Set the bounding OBB's width
	 */
	public void setWidth(float width)
	{
		Width = width;
		build(width, Height);
	}
	
	
	
	
	
	
	/**
	 * Get the bounding OBB's width
	 */
	public float getWidth()
	{
		return Width;
	}
	
	
	
	
	
	
	/**
	 * Set the bounding OBB's width and height
	 */
	public void setSize(float width, float height)
	{
		Width = width;
		Height = height;
		build(width, height);
	}
	
	
	
	
	
	
	
	/**
	 * Returns this bounding OBB's axes
	 */
	@Override
	public Vector2d[] axes()
	{
		Vector2d[] axes = new Vector2d[2];
		Vector2d edge, normal;
		
		for (int i = 0; i < 2; i++)
		{
			edge = vertices[i].sub(vertices[i + 1]);
			normal = edge.rightPerp();
			normal.normalise();
			axes[i] = normal;
		}
		
		return axes;
	}
	
	
	
	

}
