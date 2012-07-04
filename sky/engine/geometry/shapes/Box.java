package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Box extends Polygon
{
	/**
	 * Width of Rectangle
	 */
	protected float Width;
	
	
	/**
	 * Height of Rectangle
	 */
	protected float Height;
	
	
	
	
	
	

	
	
	


	
	
	/********************************************
	 * 			PUBLIC CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a geometric Rectangle
	 */
	public Box(Vector2D position, float width, float height)
	{
		super(position);
		Width = width;
		Height = height;
		build(width, height);
	}

	
	/**
	 * Create new instance of a geometric Rectangle
	 */
	public Box(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{
		super(position, new Vector2D[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() });
		Width = v1.magnitude(v2);
		Height = v2.magnitude(v3);
	}

	
	/**
	 * Create new instance of a geometric Rectangle
	 */
	public Box(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{
		super(new Vector2D[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() });
		Width = v1.magnitude(v2);
		Height = v2.magnitude(v3);
	}
	
	
	/**
	 * Create new geometric Rectangle from another geometric rectangle
	 */
	public Box(Box rect)
	{
		super(rect.Position, Vector2D.clone(rect.vertices));
		Width = rect.Width;
		Height = rect.Height;
	}

	
	
	
	
	
	

	
	/********************************************
	 * 			PROTECTED CONSTRUCTORS
	 ********************************************/
	
	/**
	 * Create new instance of a geometric Rectangle
	 */
	protected Box(Vector2D position, float width, float height, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		Width = width;
		Height = height;
		build(width, height);
	}

	
	/**
	 * Create new instance of a geometric Rectangle
	 */
	protected Box(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, Vector2D velocity, float mass)
	{
		super(position, new Vector2D[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() }, velocity, mass);
		Width = v1.magnitude(v2);
		Height = v2.magnitude(v3);
	}

	
	/**
	 * Create new instance of a geometric Rectangle
	 */
	protected Box(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, Vector2D velocity, float mass)
	{
		super(new Vector2D[] { v1.clone(), v2.clone(), v3.clone(), v4.clone() }, velocity, mass);
		Width = v1.magnitude(v2);
		Height = v2.magnitude(v3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this rectangle
	 */
	@Override
	public Box clone()
	{
		return new Box(Position, vertices[0], vertices[1], vertices[2], vertices[3]);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * build rectangle from width and height
	 */
	private void build(float width, float height)
	{		
		vertices = new Vector2D[4];
		
		vertices[0] = new Vector2D(width * -0.5f, height * -0.5f);
		vertices[1] = new Vector2D(width * 0.5f, height * -0.5f);
		vertices[2] = new Vector2D(width * 0.5f, height * 0.5f);
		vertices[3] = new Vector2D(width * -0.5f, height * 0.5f);

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
	 * Set the box's width
	 */
	public void setWidth(float width)
	{
		Width = width;
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
	 * Get the box's width
	 */
	public float getWidth()
	{
		return Width;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the perimeter of the rectangle
	 */
	@Override
	public float perimeter()
	{
		return ((Width * 2) + (Height * 2));
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the area of the rectangle
	 */
	@Override
	public float area()
	{
		return (Width * Height);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns this rectangles axes
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
	
	
	
	
	
	
	

}
