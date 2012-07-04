package sky.engine.physics.collisions;

import sky.engine.geometry.shapes.GeometricShape;
import sky.engine.geometry.vectors.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class SATCollision
{	
	
	/**
	 * Check for a collision/intersection between two shapes
	 */
	public static boolean intersect(GeometricShape shape1, GeometricShape shape2)
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
	 * Returns the amount the shapes are intersecting by. Values returned are the
	 * distance and direction to move shapes to stop intersection
	 */
	public static MTV getIntersection(GeometricShape shape1, GeometricShape shape2)
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
	 * Check to see if the shape contains the point
	 */
	public static boolean contains(GeometricShape shape, Vector2D point)
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
	 * Given two shapes, where the first is a circle. Return the closest vertex from
	 * the second shapes.
	 */
	private static Vector2D getClosest(GeometricShape circle, GeometricShape shape)
	{
		Vector2D centre = circle.getPosition();
		Vector2D[] shapeverts = shape.vertices();
		Vector2D closest = shapeverts[0];
		
		float mag = centre.squaredMagnitude(shapeverts[0]);
		float tempMag = 0;
		
		for (int i = 1; i < shapeverts.length; i++)
		{
			tempMag = centre.squaredMagnitude(shapeverts[i]);
			
			if (tempMag < mag) {
				mag = tempMag;
				closest = shapeverts[i];
			}
		}
		
		return closest;
	}
	

}
