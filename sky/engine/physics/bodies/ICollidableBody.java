package sky.engine.physics.bodies;

import sky.engine.geometry.Circumcircle;
import sky.engine.geometry.ConvexHull;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.physics.collisions.Contact;
import sky.engine.physics.collisions.Projection;

/**
 * Geometric Shape interface hat is mainly used by shapes and bounding volumes.
 * This interface is used to assist with collision detection using SAT.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public interface ICollidableBody
{
	
	/**
	 * Returns the vertices of this shape.
	 */
	public Vector2d[] vertices();
	
	
	/**
	 * Is this shapes a circle?
	 */
	public boolean isCircle();
	
	
	/**
	 * Returns the central position of the shape.
	 */
	public Vector2d getPosition();
	
	
	/**
	 * Returns the triangulation of this shape.
	 */
	public Triangulation triangulate();
	
	
	/**
	 * Returns the Convex Hull of this shape.
	 */
	public ConvexHull convexhull();
	
	
	/**
	 * Returns the Circumcircle of this shape.
	 */
	public Circumcircle circumcircle();
	
	
	/**
	 * Returns the axes of this shape.
	 */
	public Vector2d[] axes();
	
	
	/**
	 * Projects the shape's vertices onto the given axis.
	 */
	public Projection project(Vector2d axis);
	
	
	/**
	 * Does the geometric shape intersect with the other given one?
	 */
	public boolean intersects(ICollidableBody shape);
	
	
	/**
	 * Returns the amount of intersection between the geometric shapes.
	 */
	public Contact intersection(ICollidableBody shape);
	
	
	/**
	 * Does the geometric shape contain the given point?
	 */
	public boolean contains(Vector2d point);
	
	
	/**
	 * Does the geometric shape contain the given point?
	 */
	public boolean contains(float x, float y);
	
	
	
	
	
	
	
}
