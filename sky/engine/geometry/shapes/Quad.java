package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2d;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Quad extends Polygon
{	
	
	/**
	 * Create new instance of a quad
	 */
	public Quad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4)
	{
		super(new Vector2d[] { v1, v2, v3, v4 });
	}

	
	/**
	 * Create new instance of a quad
	 */
	//public Quad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, Vector2d velocity, float mass)
	//{
	//	super(new Vector2d[] { v1, v2, v3, v4 }, velocity, mass);
	//}

	
	/**
	 * Create new instance of a quad
	 */
	//protected Quad(Vector2d position, Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, Vector2d velocity, float mass)
	//{
	//	super(position, new Vector2d[] { v1, v2, v3, v4 }, velocity, mass);
	//}
	
	
	/**
	 * Create new instance of a quad
	 */
	public Quad(Quad quad)
	{
		super(quad);
	}
	
	
	
	
	
	
	
	/**
	 * Clone this quad
	 */
	@Override
	public Quad clone()
	{
		return new Quad(this);
	}
	
	
	
}
