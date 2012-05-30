package sky.engine.physics.bounding;

import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 * @deprecated
 *
 */
public class BoundingCircle extends Bounding
{
	/**
	 * Radius of the circle
	 */
	public float Radius;
	
	
	
	
	
	
	

	
	
	/** 
	 * Create a new bounding circle
	 */	
	public BoundingCircle(Vector2D position, float radius)
	{
		super(position);
		Radius = radius;
		this.vertices = new Vector2D[2];
		this.isCircle = true;
	}
	
	
	/** 
	 * Create a new bounding circle
	 */	
	public BoundingCircle(float x, float y, float radius)
	{
		super(x, y);
		Radius = radius;
		this.vertices = new Vector2D[2];
		this.isCircle = true;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Calculate the radial vertices of this circle
	 */
	public void calcVertices(Vector2D vector)
	{
		//this.vertices = new Vector2D[2];
		
		float rvx = Radius * vector.X;
		float rvy = Radius * vector.Y;

		this.vertices[0] = new Vector2D(Position.X + rvx, Position.Y + rvy);
		this.vertices[1] = new Vector2D(Position.X - rvx, Position.Y - rvy);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/** Does this BoundingCirlce intersect another BoundingCircle */
	public boolean intersect(BoundingCircle circle)
	{
		Vector2D v = this.Position.sub(circle.Position);
		if (v.magnitude() < (this.Radius + circle.Radius))
			return true;
		else
			return false;		
	}
	
	
	
	
	
	
	
	
	
	/** Has the bounding circle been intersected by a point? */
	//public boolean contains(Vector2D point)
	//{
	//	Vector2D v = this.Position.sub(point);
	//	if (v.magnitude() < this.Radius)
	//		return true;
	//	else
	//		return false;
	//}
	
	
	
	
	

}
