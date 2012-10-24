package sky.engine.geometry;

import java.util.HashMap;

import sky.engine.geometry.shapes.Polygon;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.shapes.DrawablePolygon;
import sky.engine.physics.bounding.BoundingPoly;
import sky.engine.util.MultiList;
import sky.engine.util.SortedList;
import sky.engine.util.primitives.SEArrays;

/**
 * Implementation of a QuickHull algorithm for generating the convex hull of a polygon, given
 * the polygon's array of vertices. Runs in O(n log n) time.
 * 
 * With thanks to Jakob Westoff for his PHP implementation of the algorithm, which can be
 * found here: http://westhoffswelt.de/blog/0040_quickhull_introduction_and_php_implementation.html
 * 
 * As well as the research paper "The Quickhull Algorithm for Convex Hulls", by Barbar, Dobkin
 * and Huhdanpaa.
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class ConvexHull
{
	/**
	 * 
	 */
	protected static final String DISTANCE = "distance";
	
	
	/**
	 * 
	 */
	protected static final String VERTEX = "vertex";
	
	
	/**
	 * The convex hull's vertices.
	 */
	protected Vector2d[] hullvertices = null;
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a ConvexHull.
	 */
	public ConvexHull() { }
	
	
	/**
	 * Create new instance of a ConvexHull, given array of vertices. 2 or more vertices
	 * must be given.
	 * 
	 * @param vertices - Array of vertices to construct the convex hull.
	 */
	public ConvexHull(Vector2d[] vertices)
	{
		boolean bool = construct(vertices);
		
		if (!bool) {
			throw new Error("Number of vertices has to be greater than or equal to 2.");
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Constructs the convex hull of the given vertices. 2 or more vertices must be given.
	 * 
	 * @param vertices - Array of vertices to construct the convex hull.
	 * @return Whether the construction was successful.
	 */
	public boolean construct(Vector2d[] vertices)
	{
		if (vertices.length <= 1)
			return false;
		
		//sort the vertices into ascending order
		SortedList<Vector2d> sorted = new SortedList<Vector2d>(vertices);
		
		Vector2d[] temp1 = quickHull(vertices, sorted.getFirst(), sorted.getLast());
		Vector2d[] temp2 = quickHull(vertices, sorted.getLast(), sorted.getFirst());
		
		hullvertices = SEArrays.merge(temp1, temp2);
		SEArrays.reverse(hullvertices); //to make it right-winding
		
		return true;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param points
	 * @param start
	 * @param end
	 * @return
	 */
	protected Vector2d[] quickHull(Vector2d[] points, Vector2d start, Vector2d end)
	{
		MultiList pointsLeftOfLine = getVertexDistanceIndicators(start, end, points);
		Vector2d newMaximalPoint = getVertexWithMaximumDistanceFromLine(pointsLeftOfLine);
		
		if (newMaximalPoint == null)
		{
			return new Vector2d[] { end };
		}
		else
		{
			Vector2d[] newPoints = getVerticesFromVertexDistanceSet(pointsLeftOfLine);
			Vector2d[] temp1 = quickHull(newPoints, start, newMaximalPoint);
			Vector2d[] temp2 = quickHull(newPoints, newMaximalPoint, end);
			
			Vector2d[] array = SEArrays.merge(temp1, temp2);			
			return array;
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param start
	 * @param end
	 * @param point
	 * @return
	 */
	protected float calculateDistanceIndicator(Vector2d start, Vector2d end, Vector2d point)
	{
		Vector2d line = end.sub(start);
		Vector2d topoint = point.sub(start);
		
		return ((topoint.Y * line.X) - (topoint.X * line.Y));
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param start
	 * @param end
	 * @param vertices
	 * @return
	 */
	protected MultiList getVertexDistanceIndicators(Vector2d start, Vector2d end, Vector2d[] vertices)
	{
		MultiList indicators = new MultiList();
		float distance = 0;
		int count = 0;
		
		for (int i = 0; i < vertices.length; i++)
		{
			distance = calculateDistanceIndicator(start, end, vertices[i]);
			if (distance > 0)
			{
				indicators.add(VERTEX, vertices[i]);
				indicators.add(count++, DISTANCE, distance);
			}
			else
			{
				continue;
			}
		} 
		
		return indicators;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param vertexDistanceSet
	 * @return
	 */
	protected Vector2d getVertexWithMaximumDistanceFromLine(MultiList vertexDistanceSet)
	{
		float maxDistance = 0;
		Vector2d maxPoint = null;
		
		for (int i = 0; i < vertexDistanceSet.size(); i++)
		{
			HashMap<Object, Object> temp = vertexDistanceSet.get(i);
			
			if ((Float)temp.get(DISTANCE) > maxDistance)
			{
				maxDistance = (Float)temp.get(DISTANCE);
				maxPoint = (Vector2d)temp.get(VERTEX);
			}
		}
		
		return maxPoint;
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param vertexDistanceSet
	 * @return
	 */
	protected Vector2d[] getVerticesFromVertexDistanceSet(MultiList vertexDistanceSet)
	{
		Vector2d[] points = new Vector2d[vertexDistanceSet.size()];
		
		for (int i = 0; i < vertexDistanceSet.size(); i++)
		{
			points[i] = (Vector2d)vertexDistanceSet.get(i).get(VERTEX);
		}
		
		return points;
	}
	
	
	
	
	
	
	
	/**
	 * Returns the convex hull as an array of vertices.
	 * 
	 * @return Array of vertices.
	 */
	public final Vector2d[] asVertices()
	{
		return hullvertices;
	}
	
	
	
	
	
	
	/**
	 * Returns convex hull as a Geometric Polygon.
	 * 
	 * @return A Geometric Polygon.
	 */
	public Polygon asGeometric()
	{
		if (hullvertices == null)
			return null;
		
		return new Polygon(hullvertices);
	}
	
	
	
	
	
	
	/**
	 * Returns convex hull as a Drawable Polygon.
	 * 
	 * @return A Drawable Polygon.
	 */
	public DrawablePolygon asDrawable()
	{
		if (hullvertices == null)
			return null;
		
		return new DrawablePolygon(hullvertices);
	}
	
	
	
	
	
	
	
	/**
	 * Returns convex hull as a bounding polygon.
	 * 
	 * @return A Bounding Polygon.
	 */
	public BoundingPoly asBounding()
	{
		if (hullvertices == null)
			return null;
		
		return new BoundingPoly(hullvertices);
	}
	
	
	
}
