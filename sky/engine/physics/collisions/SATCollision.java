package sky.engine.physics.collisions;

import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Shape;
import sky.engine.graphics.bounds.Bounding;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class SATCollision
{	
	
	/**
	 * Check for a collision/intersection between two bounding volumes
	 */
	public static boolean intersect(Bounding bound1, Bounding bound2)
	{
		//initialise the set of axes for both bounds
		Vector2D[] axes1 = null, axes2 = null;
		
		
		//Are both bounds circles?
		if (bound1.isCircle() && bound2.isCircle())
		{
			//generate axes
			axes1 = new Vector2D[1];
			axes1[0] = bound1.getPosition().sub(bound2.getPosition());
			axes1[0].normalise();
		}
		
		
		//else, one is circle, one isn't
		else if (bound1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(bound1, bound2);
			
			//get axes from circle and closest vertex
			axes1 = new Vector2D[1];
			axes1[0] = bound1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (bound2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(bound2, bound1);
			
			//get axes from circle and closest vertex
			axes2 = new Vector2D[1];
			axes2[0] = bound2.getPosition().sub(closest);
			axes2[0].normalise();
		}
		
		
		
		//continue as normal for collision			
		if (axes1 == null)
			axes1 = bound1.getAxes();
		
		if (axes2 == null && !bound2.isCircle())
			axes2 = bound2.getAxes();
		else if (axes2 == null)
			axes2 = new Vector2D[0];

		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes1.length; i++)
		{
			axis = axes1[i];
			p1 = bound1.project(axis);
			p2 = bound2.project(axis);
			
			if (!p1.overlap(p2))
				return false;
		}
		
		
		for (int i = 0; i < axes2.length; i++)
		{
			axis = axes2[i];
			p1 = bound1.project(axis);
			p2 = bound2.project(axis);
			
			if (!p1.overlap(p2)) 
				return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Check for a collision/intersection between two shapes
	 */
	public static boolean intersect(Shape shape1, Shape shape2)
	{
		//initialise the set of axes for both shapes
		Vector2D[] axes1 = null, axes2 = null;
		
		
		//Are both shapes circles?
		if (shape1.isCircle() && shape2.isCircle())
		{
			//generate axes
			axes1 = new Vector2D[1];
			axes1[0] = shape1.getPosition().sub(shape2.getPosition());
			axes1[0].normalise();
		}
		
		
		//else, one is circle, one isn't
		else if (shape1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(shape1, shape2);
			
			//get axes from circle and closest vertex
			axes1 = new Vector2D[1];
			axes1[0] = shape1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (shape2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(shape2, shape1);
			
			//get axes from circle and closest vertex
			axes2 = new Vector2D[1];
			axes2[0] = shape2.getPosition().sub(closest);
			axes2[0].normalise();
		}
		
		
		
		//continue as normal for collision		
		if (axes1 == null)
			axes1 = shape1.getAxes();
		
		if (axes2 == null && !shape2.isCircle())
			axes2 = shape2.getAxes();
		else if (axes2 == null)
			axes2 = new Vector2D[0];

		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		

		for (int i = 0; i < axes1.length; i++)
		{
			axis = axes1[i];
			p1 = shape1.project(axis);
			p2 = shape2.project(axis);
			
			if (!p1.overlap(p2))
				return false;
		}
		
		
		for (int i = 0; i < axes2.length; i++)
		{
			axis = axes2[i];
			p1 = shape1.project(axis);
			p2 = shape2.project(axis);
			
			if (!p1.overlap(p2)) 
				return false;
		}
		
		
		return true;
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the amount the bounds are intersecting by. Values returned are the
	 * distance and direction to move bounds to stop intersection
	 */
	public static MTV getIntersection(Bounding bound1, Bounding bound2)
	{
		//initialise the set of axes for both bounds
		Vector2D[] axes1 = null, axes2 = null;
		
		
		//Are both shapes circles?
		if (bound1.isCircle() && bound2.isCircle())
		{
			//generate axes
			axes1 = new Vector2D[1];
			axes1[0] = bound1.getPosition().sub(bound2.getPosition());
			axes1[0].normalise();
		}
		
		
		//else, one is circle, one isn't
		else if (bound1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(bound1, bound2);
			
			//get axes from circle and closest vertex
			axes1 = new Vector2D[1];
			axes1[0] = bound1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (bound2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(bound2, bound1);
			
			//get axes from circle and closest vertex
			axes2 = new Vector2D[1];
			axes2[0] = bound2.getPosition().sub(closest);
			axes2[0].normalise();
		}
		
		
		
		//continue as normal for collision		
		if (axes1 == null)
			axes1 = bound1.getAxes();
		
		if (axes2 == null && !bound2.isCircle())
			axes2 = bound2.getAxes();
		else
			axes2 = new Vector2D[0];
		
		//MTV values
		float overlap = 0xFFFFFF;
		Vector2D smallest = null;
		float o;
		
		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes1.length; i++)
		{
			axis = axes1[i];
			p1 = bound1.project(axis);
			p2 = bound2.project(axis);
			
			if (!p1.overlap(p2))
			{
				return null;
			}
			else
			{
				o = p1.getOverlap(p2);
				
				if (p1.contains(p2) || p2.contains(p1))
				{
					float mins = Math.abs(p1.min - p2.min);
					float maxs = Math.abs(p1.max - p2.max);
					
					if (mins < maxs)
						o += mins;
					else
						o += maxs;
				}
				
				if (o < overlap)
				{
					overlap = o;
					smallest = axis;
				}
			}
		}
		
		
		for (int i = 0; i < axes2.length; i++)
		{
			axis = axes2[i];
			p1 = bound1.project(axis);
			p2 = bound2.project(axis);
			
			if (!p1.overlap(p2))
			{
				return null;
			}
			else
			{
				o = p1.getOverlap(p2);
				
				if (p1.contains(p2) || p2.contains(p1))
				{
					float mins = Math.abs(p1.min - p2.min);
					float maxs = Math.abs(p1.max - p2.max);
					
					if (mins < maxs)
						o += mins;
					else
						o += maxs;
				}
				
				if (o < overlap)
				{
					overlap = o;
					smallest = axis;
				}
			}
		}
		
		
		MTV mtv = new MTV(smallest, overlap);
		return mtv;
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the amount the shapes are intersecting by. Values returned are the
	 * distance and direction to move shapes to stop intersection
	 */
	public static MTV getIntersection(Shape shape1, Shape shape2)
	{
		//initialise the set of axes for both bounds
		Vector2D[] axes1 = null, axes2 = null;
		
		
		//Are both shapes circles?
		if (shape1.isCircle() && shape2.isCircle())
		{
			//generate axes
			axes1 = new Vector2D[1];
			axes1[0] = shape1.getPosition().sub(shape2.getPosition());
			axes1[0].normalise();
		}
		
		
		//else, one is circle, one isn't
		else if (shape1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(shape1, shape2);
			
			//get axes from circle and closest vertex
			axes1 = new Vector2D[1];
			axes1[0] = shape1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (shape2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D closest = getClosest(shape2, shape1);
			
			//get axes from circle and closest vertex
			axes2 = new Vector2D[1];
			axes2[0] = shape2.getPosition().sub(closest);
			axes2[0].normalise();
		}
		
		
		
		//continue as normal for collision		
		if (axes1 == null)
			axes1 = shape1.getAxes();
		
		if (axes2 == null && !shape2.isCircle())
			axes2 = shape2.getAxes();
		else
			axes2 = new Vector2D[0];
		
		//MTV values
		float overlap = 0xFFFFFF;
		Vector2D smallest = null;
		float o;
		
		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes1.length; i++)
		{
			axis = axes1[i];
			p1 = shape1.project(axis);
			p2 = shape2.project(axis);
			
			if (!p1.overlap(p2))
			{
				return null;
			}
			else
			{
				o = p1.getOverlap(p2);
				
				if (p1.contains(p2) || p2.contains(p1))
				{
					float mins = Math.abs(p1.min - p2.min);
					float maxs = Math.abs(p1.max - p2.max);
					
					if (mins < maxs)
						o += mins;
					else
						o += maxs;
				}
				
				if (o < overlap)
				{
					overlap = o;
					smallest = axis;
				}
			}
		}
		
		
		for (int i = 0; i < axes2.length; i++)
		{
			axis = axes2[i];
			p1 = shape1.project(axis);
			p2 = shape2.project(axis);
			
			if (!p1.overlap(p2))
			{
				return null;
			}
			else
			{
				o = p1.getOverlap(p2);
				
				if (p1.contains(p2) || p2.contains(p1))
				{
					float mins = Math.abs(p1.min - p2.min);
					float maxs = Math.abs(p1.max - p2.max);
					
					if (mins < maxs)
						o += mins;
					else
						o += maxs;
				}
				
				if (o < overlap)
				{
					overlap = o;
					smallest = axis;
				}
			}
		}
		
		
		MTV mtv = new MTV(smallest, overlap);
		return mtv;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Check to see if the bounding volume contains the point.
	 */
	public static boolean contains(Bounding bound, Vector2D point)
	{
		//initialise the set of axes for the bound
		Vector2D[] axes = null;
		
		
		//Is the bound a circle?
		if (bound.isCircle())
		{
			//generate axes
			axes = new Vector2D[1];
			axes[0] = bound.getPosition().sub(point);
			axes[0].normalise();
		}
		
		
		
		//continue as normal for collision			
		if (axes != null)
			axes = bound.getAxes();

		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes.length; i++)
		{
			axis = axes[i];
			p1 = bound.project(axis);
			float min = axis.dot(point);
			p2 = new Projection(min, min);
			
			if (!p1.contains(p2))
				return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Check to see if the shape contains the point
	 */
	public static boolean contains(Shape shape, Vector2D point)
	{
		//initialise the set of axes for the bound
		Vector2D[] axes = null;
		
		
		//Is the bound a circle?
		if (shape.isCircle())
		{
			//generate axes
			axes = new Vector2D[1];
			axes[0] = shape.getPosition().sub(point);
			axes[0].normalise();
		}
		
		
		
		//continue as normal for collision			
		if (axes != null)
			axes = shape.getAxes();

		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes.length; i++)
		{
			axis = axes[i];
			p1 = shape.project(axis);
			float min = axis.dot(point);
			p2 = new Projection(min, min);
			
			if (!p1.contains(p2))
				return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	

	
	
	/**
	 * Given two bounds, where the first is a circle. Return the closest vertex from
	 * the second bound.
	 */
	private static Vector2D getClosest(Bounding circle, Bounding bound)
	{
		Vector2D centre = circle.getPosition();
		Vector2D closest = bound.vertices[0];
		float mag = centre.squaredMagnitude(bound.vertices[0]);
		float tempMag = 0;
		
		for (int i = 1; i < bound.vertices.length; i++)
		{
			tempMag = centre.squaredMagnitude(bound.vertices[i]);
			
			if (tempMag < mag) {
				mag = tempMag;
				closest = bound.vertices[i];
			}
		}
		
		return closest;
	}
	
	
	/**
	 * Given two shapes, where the first is a circle. Return the closest vertex from
	 * the second shapes.
	 */
	private static Vector2D getClosest(Shape circle, Shape shape)
	{
		Vector2D centre = circle.getPosition();
		Vector2D closest = shape.vertices[0];
		float mag = centre.squaredMagnitude(shape.vertices[0]);
		float tempMag = 0;
		
		for (int i = 1; i < shape.vertices.length; i++)
		{
			tempMag = centre.squaredMagnitude(shape.vertices[i]);
			
			if (tempMag < mag) {
				mag = tempMag;
				closest = shape.vertices[i];
			}
		}
		
		return closest;
	}
	

}
