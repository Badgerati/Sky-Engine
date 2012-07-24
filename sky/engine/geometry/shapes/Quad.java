package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2;

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
	public Quad(Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4)
	{
		super(new Vector2[] { v1, v2, v3, v4 });
	}

	
	/**
	 * Create new instance of a quad
	 */
	public Quad(Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4, Vector2 velocity, float mass)
	{
		super(new Vector2[] { v1, v2, v3, v4 }, velocity, mass);
	}

	
	/**
	 * Create new instance of a quad
	 */
	protected Quad(Vector2 position, Vector2 v1, Vector2 v2, Vector2 v3, Vector2 v4, Vector2 velocity, float mass)
	{
		super(position, new Vector2[] { v1, v2, v3, v4 }, velocity, mass);
	}
	
	
	/**
	 * Create new instance of a quad
	 */
	public Quad(Quad quad)
	{
		super(quad.Position, quad.vertices, quad.Velocity, quad.Mass);
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
