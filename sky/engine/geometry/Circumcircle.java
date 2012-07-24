package sky.engine.geometry;

import sky.engine.geometry.shapes.Circle;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.bounds.BoundingCircle;
import sky.engine.graphics.drawable.shapes.DrawableCircle;
import sky.engine.util.SortedList;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Circumcircle
{
	/**
	 * Radius of the circumcircle
	 */
	protected float radius = -1;
	
	
	/**
	 * Maximum distance between to further points
	 */
	protected float maxdist = -1;
	
	
	/**
	 * Central position of the vertices
	 */
	protected Vector2 centre = null;
	
	
	/**
	 * Vertices associated with this circumcircle
	 */
	protected Vector2[] points = null;
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a circumcircle.
	 */
	public Circumcircle() { }
	
	
	/**
	 * Create new instance of a circumcircle from an array of given points. 2 or more
	 * points must be given.
	 */
	public Circumcircle(Vector2[] points)
	{
		boolean bool = construct(points);
		
		if (!bool) {
			throw new Error("Number of vertices has to be greater than or equal to 2.");
		}
	}
	
	
	
	
	
	
	
	/**
	 * Constructs an enclosing circumcirlce around the point set
	 */
	public boolean construct(Vector2[] points)
	{
		//we need 2 or more, else error
		if (points.length <= 1)
			return false;
		
		//store vertices
		this.points = Vector2.clone(points);
		
		//quick centre calculation
		centre = Vector2.getCentre(points);
		
		//algorithm itself
		SortedList<Vector2> sorted = new SortedList<Vector2>(points);
		maxdist = sorted.getFirst().magnitude(sorted.getLast());
		radius = maxdist * 0.5f;
		
		//everything went OK
		return true;
	}
	
	
	
	
	
	
	/**
	 * Returns this circumcircle's original raw set of points.
	 * 
	 * @param Array of original points
	 */
	public final Vector2[] asPoints()
	{
		return points;
	}
	
	
	
	
	
	
	/**
	 * Returns Circumcircle as a Geometric Circle.
	 * 
	 * @return A Geometric Circle.
	 */
	public Circle asGeometric()
	{
		if (radius < 0)
			return null;
		
		return new Circle(centre, radius);
	}
	
	
	
	
	
	
	/**
	 * Returns Circumcircle as a Drawable Circle.
	 * 
	 * @return A Drawable Circle.
	 */
	public DrawableCircle asDrawable()
	{
		if (radius < 0)
			return null;
		
		return new DrawableCircle(centre, radius);
	}
	
	
	
	
	
	
	
	/**
	 * Returns Circumcircle as a bounding Circle.
	 * 
	 * @return A Bounding Polygon.
	 */
	public BoundingCircle asBounding()
	{
		if (radius < 0)
			return null;
		
		return new BoundingCircle(centre, radius);
	}
	
	
	
	
	
}
