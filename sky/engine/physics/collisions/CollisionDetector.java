package sky.engine.physics.collisions;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.physics.bodies.ICollidableBody;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class CollisionDetector
{	
	
	/**
	 * Check for a collision/intersection between two shapes
	 */
	public static boolean intersects(ICollidableBody body1, ICollidableBody body2)
	{
		//initialise the set of axes for both shapes
		Vector2d[] axes1 = null, axes2 = null;
		
		
		//Are both shapes circles?
		if (body1.isCircle() && body2.isCircle())
		{
			//generate axes
			axes1 = new Vector2d[1];
			axes1[0] = body1.getPosition().sub(body2.getPosition());
			axes1[0].normalise();
		}
		
		
		//else, one is circle, one isn't
		else if (body1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2d closest = getClosest(body1, body2);
			
			//get axes from circle and closest vertex
			axes1 = new Vector2d[1];
			axes1[0] = body1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (body2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2d closest = getClosest(body2, body1);
			
			//get axes from circle and closest vertex
			axes2 = new Vector2d[1];
			axes2[0] = body2.getPosition().sub(closest);
			axes2[0].normalise();
		}
		
		
		//continue as normal for collision		
		if (axes1 == null)
			axes1 = body1.axes();
		
		if (axes2 == null && !body2.isCircle())
			axes2 = body2.axes();
		else if (axes2 == null)
			axes2 = new Vector2d[0];

		//axis and projections
		Vector2d axis;
		Projection p1, p2;
		

		for (int i = 0; i < axes1.length; i++)
		{
			axis = axes1[i];
			p1 = body1.project(axis);
			p2 = body2.project(axis);
			
			if (!p1.overlap(p2))
				return false;
		}
		
		
		for (int i = 0; i < axes2.length; i++)
		{
			axis = axes2[i];
			p1 = body1.project(axis);
			p2 = body2.project(axis);
			
			if (!p1.overlap(p2)) 
				return false;
		}
		
		
		return true;
	}	
	
	
	
	
	
	/**
	 * Returns the amount the shapes are intersecting by. Values returned are the
	 * distance and direction to move shapes to stop intersection
	 */
	public static Contact intersection(ICollidableBody body1, ICollidableBody body2)
	{
		//initialise the set of axes for both bounds
		Vector2d[] axes1 = null, axes2 = null;
		
		
		//Are both shapes circles?
		if (body1.isCircle() && body2.isCircle())
		{
			//generate axes
			axes1 = new Vector2d[1];
			axes1[0] = body1.getPosition().sub(body2.getPosition());
			axes1[0].normalise();
		}
		
		
		//else, one is circle, one isn't
		else if (body1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2d closest = getClosest(body1, body2);
			
			//get axes from circle and closest vertex
			axes1 = new Vector2d[1];
			axes1[0] = body1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (body2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2d closest = getClosest(body2, body1);
			
			//get axes from circle and closest vertex
			axes2 = new Vector2d[1];
			axes2[0] = body2.getPosition().sub(closest);
			axes2[0].normalise();
		}


		//continue as normal for collision		
		if (axes1 == null)
			axes1 = body1.axes();
		
		if (axes2 == null && !body2.isCircle())
			axes2 = body2.axes();
		else
			axes2 = new Vector2d[0];
		
		//MTV values
		float overlap = 0xFFFFFF;
		Vector2d smallest = null;
		float o;
		
		//axis and projections
		Vector2d axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes1.length; i++)
		{
			axis = axes1[i];
			p1 = body1.project(axis);
			p2 = body2.project(axis);
			
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
			p1 = body1.project(axis);
			p2 = body2.project(axis);
			
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
		
		
		Contact mtv = new Contact(smallest, overlap);
		return mtv;
	}
	
	
	
	
	
	
	/**
	 * Check to see if the shape contains the point
	 */
	public static boolean contains(ICollidableBody body, Vector2d point)
	{
		return contains(body, point.X, point.Y);
	}
	
	
	
	
	
	
	/**
	 * Check to see if the shape contains the point
	 */
	public static boolean contains(ICollidableBody body, float x, float y)
	{
		//initialise the set of axes for the bound
		Vector2d[] axes = null;
		
		
		//Is the bound a circle?
		if (body.isCircle())
		{
			//generate axes
			axes = new Vector2d[1];
			axes[0] = body.getPosition().sub(x, y);
			axes[0].normalise();
		}
		
		
		//continue as normal for collision			
		if (axes == null)
			axes = body.axes();

		//axis and projections
		Vector2d axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes.length; i++)
		{
			axis = axes[i];
			p1 = body.project(axis);
			float min = axis.dot(x, y);
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
	private static Vector2d getClosest(ICollidableBody circ_body, ICollidableBody poly_body)
	{
		if (!circ_body.isCircle())
			return null;
		
		Vector2d centre = circ_body.getPosition();
		Vector2d[] polyverts = poly_body.vertices();
		Vector2d closest = polyverts[0];
		
		float mag = centre.squaredMagnitude(polyverts[0]);
		float tempMag = 0;
		
		for (int i = 1; i < polyverts.length; i++)
		{
			tempMag = centre.squaredMagnitude(polyverts[i]);
			
			if (tempMag < mag) {
				mag = tempMag;
				closest = polyverts[i];
			}
		}
		
		return closest;
	}
	

}
