package sky.engine.geometry.shapes;

import sky.engine.geometry.ConvexHull;
import sky.engine.geometry.Triangulation;
import sky.engine.geometry.vectors.Vector2D;
import sky.engine.physics.collisions.MTV;
import sky.engine.physics.collisions.Projection;

/**
 * Geometric Shape interface hat is mainly used by shapes and bounding volumes.
 * This interface is used to assist with collision detection using SAT.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public interface GeometricShape
{
	
	/**
	 * Returns the vertices of this shape.
	 */
	public Vector2D[] vertices();
	
	
	/**
	 * Set the vertices of the shape.
	 */
	public void setVertices(Vector2D[] vertices);
	
	
	/**
	 * Is this shapes a circle?
	 */
	public boolean isCircle();
	
	
	/**
	 * Returns the central position of the shape.
	 */
	public Vector2D getPosition();
	
	
	/**
	 * Returns the triangulation of this shape.
	 */
	public Triangulation triangulate();
	
	
	/**
	 * Returns the Convex Hull of this shape.
	 */
	public ConvexHull convexhull();
	
	
	/**
	 * Returns the axes of this shape.
	 */
	public Vector2D[] getAxes();
	
	
	/**
	 * Projects the shape's vertices onto the given axis.
	 */
	public Projection project(Vector2D axis);
	
	
	/**
	 * Does the geometric shape intersect with the other given one?
	 */
	public boolean intersect(GeometricShape shape);
	
	
	/**
	 * Returns the amount of intersection between the geometric shapes.
	 */
	public MTV getIntersection(GeometricShape shape);
	
	
	/**
	 * Does the geometric shape contain the given point?
	 */
	public boolean contains(Vector2D point);
	
	
	
	
	
	
	
}