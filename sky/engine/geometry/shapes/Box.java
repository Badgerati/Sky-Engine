package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Box extends Shape
{
	/**
	 * Width of box
	 */
	protected float Width;
	
	
	/**
	 * Height of box
	 */
	protected float Height;
	
	
	
	
	
	
	
	/**
	 * Create new instance of a box
	 */
	public Box(Vector2 position, float width, float height)
	{
		super(position);
		Width = width;
		Height = height;
		build(width, height);
	}

	
	/**
	 * Create new instance of a box
	 */
	public Box(Vector2 position, float width, float height, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
		Width = width;
		Height = height;
		build(width, height);
	}

	
	/**
	 * Create new instance of a box
	 */
	public Box(Box box)
	{
		super(box.Position, box.Velocity, box.Mass);
		build(box.Width, box.Height);
	}
	
	
	
	
	
	
	
	/**
	 * Clone this box
	 */
	@Override
	public Box clone()
	{
		return new Box(this);
	}
	
	
	
	
	
	
	
	/**
	 * build box from width and height
	 */
	private void build(float width, float height)
	{		
		vertices = new Vector2[4];
		
		vertices[0] = new Vector2(width * -0.5f, height * -0.5f);
		vertices[1] = new Vector2(width * 0.5f, height * -0.5f);
		vertices[2] = new Vector2(width * 0.5f, height * 0.5f);
		vertices[3] = new Vector2(width * -0.5f, height * 0.5f);

		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}

	
	
	

	
	
	/**
	 * Set the box's height
	 */
	public void setHeight(float height)
	{
		Height = height;
		build(Width, Height);
	}
	
	

	
	
	/**
	 * Get the box's height
	 */
	public float getHeight()
	{
		return Height;
	}
	
	
	
	
	
	
	/**
	 * Set the box's width
	 */
	public void setWidth(float width)
	{
		Width = width;
		build(Width, Height);
	}
	
	
	
	
	
	
	/**
	 * Get the box's width
	 */
	public float getWidth()
	{
		return Width;
	}
	
	
	
	
	
	
	/**
	 * Returns the perimeter of the box
	 */
	public float perimeter()
	{
		return ((Width * 2) + (Height * 2));
	}
	
	
	
	
	
	
	
	/**
	 * Returns the area of the box
	 */
	@Override
	public float area()
	{
		return (Width * Height);
	}
	
	
	
	
	
	
	/**
	 * Returns this box axes
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
	
	
	
	

}
