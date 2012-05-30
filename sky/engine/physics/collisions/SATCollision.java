package sky.engine.physics.collisions;

import java.util.ArrayList;

import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Shape;
import sky.engine.physics.bounding.Bounding;
import sky.engine.physics.bounding.BoundingCircle;

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
	 * 
	 * @deprecated Use Shape object for bounds instead, as well as the associated
	 * 				SAT Collision method of intersect(Shape, Shape).
	 */
	public static boolean intersect(Bounding bound1, Bounding bound2)
	{
		//initialise the set of axes for both bounds
		ArrayList<Vector2D> axes1 = new ArrayList<Vector2D>();
		ArrayList<Vector2D> axes2 = new ArrayList<Vector2D>();
		
		
		//Are both bounds circles?
		if (bound1.isCircle() && bound2.isCircle())
		{
			//generate axes
			Vector2D axis = bound1.getPosition().sub(bound2.getPosition());
			axis.normalise();
			axes1.add(axis);
		}
		
		
		//else, one is circle, one isn't
		else if (bound1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D centre = bound1.getPosition();
			Vector2D closest = bound2.vertices[0];
			float mag = centre.magnitude(bound2.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < bound2.vertices.length; i++)
			{
				tempMag = centre.magnitude(bound2.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = bound2.vertices[i];
				}
			}
			
			//get axes from circle and closest vertex
			Vector2D axis = bound1.getPosition().sub(closest);
			axis.normalise();
			axes1.add(axis);
		}
		
		
		//else, the other is a circle
		else if (bound2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D centre = bound2.getPosition();
			Vector2D closest = bound1.vertices[0];
			float mag = centre.magnitude(bound1.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < bound1.vertices.length; i++)
			{
				tempMag = centre.magnitude(bound1.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = bound1.vertices[i];
				}
			}
			
			//get axes from circle and closest vertex
			Vector2D axis = bound2.getPosition().sub(closest);
			axis.normalise();
			axes2.add(axis);
		}
		
		
		
		//continue as normal for collision		
		if (axes1.size() == 0)
			axes1 = getAxes(bound1);
		
		if (axes2.size() == 0 && !bound2.isCircle())
			axes2 = getAxes(bound2);

		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes1.size(); i++)
		{
			axis = axes1.get(i);
			p1 = project(bound1, axis);
			p2 = project(bound2, axis);
			
			if (!p1.overlap(p2))
				return false;
		}
		
		
		for (int i = 0; i < axes2.size(); i++)
		{
			axis = axes2.get(i);
			p1 = project(bound1, axis);
			p2 = project(bound2, axis);
			
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
			Vector2D centre = shape1.getPosition();
			Vector2D closest = shape2.vertices[0];
			float mag = centre.magnitude(shape2.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < shape2.vertices.length; i++)
			{
				tempMag = centre.magnitude(shape2.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = shape2.vertices[i];
				}
			}
			
			//get axes from circle and closest vertex
			axes1 = new Vector2D[1];
			axes1[0] = shape1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (shape2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D centre = shape2.getPosition();
			Vector2D closest = shape1.vertices[0];
			float mag = centre.magnitude(shape1.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < shape1.vertices.length; i++)
			{
				tempMag = centre.magnitude(shape1.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = shape1.vertices[i];
				}
			}
			
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
	 * 
	 * @deprecated Use Shape object for bounds instead, as well as the associated
	 * 				SAT Collision method of getIntersection(Shape, Shape).
	 */
	public static MTV getIntersection(Bounding bound1, Bounding bound2)
	{
		//initialise the set of axes for both bounds
		//Vector2D[] axes1 = null, axes2 = null;
		ArrayList<Vector2D> axes1 = new ArrayList<Vector2D>();
		ArrayList<Vector2D> axes2 = new ArrayList<Vector2D>();
		
		
		//Are both bounds circles?
		if (bound1.isCircle() && bound2.isCircle())
		{
			//generate axes
			//axes1 = axes2 = new Vector2D[1];
			//axes1[0] = axes2[0] = bound1.getPosition().sub(bound2.getPosition()).normalise();
			Vector2D axis = bound1.getPosition().sub(bound2.getPosition());
			axis.normalise();
			axes1.add(axis);
		}
		
		
		//else, one is circle, one isn't
		else if (bound1.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D centre = bound1.getPosition();
			Vector2D closest = bound2.vertices[0];
			float mag = centre.magnitude(bound2.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < bound2.vertices.length; i++)
			{
				tempMag = centre.magnitude(bound2.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = bound2.vertices[i];
				}
			}
			
			//get axes from circle and closest vertex
			//axes1 = new Vector2D[1];
			//axes1[0] = bound1.getPosition().sub(closest).normalise();
			Vector2D axis = bound1.getPosition().sub(closest);
			axis.normalise();
			axes1.add(axis);
		}
		
		
		//else, the other is a circle
		else if (bound2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D centre = bound2.getPosition();
			Vector2D closest = bound1.vertices[0];
			float mag = centre.magnitude(bound1.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < bound1.vertices.length; i++)
			{
				tempMag = centre.magnitude(bound1.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = bound1.vertices[i];
				}
			}
			
			//get axes from circle and closest vertex
			//axes2 = new Vector2D[0];
			//axes2[0] = bound2.getPosition().sub(closest).normalise();
			Vector2D axis = bound2.getPosition().sub(closest);
			axis.normalise();
			axes2.add(axis);
		}
		
		
		
		//continue as normal for collision		
		if (axes1.size() == 0)
			axes1 = getAxes(bound1);
		
		if (axes2.size() == 0 && !bound2.isCircle())
			axes2 = getAxes(bound2);
		
		//MTV values
		float overlap = 0xFFFFFF;
		Vector2D smallest = null;
		float o;
		
		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes1.size(); i++)
		{
			axis = axes1.get(i);
			p1 = project(bound1, axis);
			p2 = project(bound2, axis);
			
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
		
		
		for (int i = 0; i < axes2.size(); i++)
		{
			axis = axes2.get(i);
			p1 = project(bound1, axis);
			p2 = project(bound2, axis);
			
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
			Vector2D centre = shape1.getPosition();
			Vector2D closest = shape2.vertices[0];
			float mag = centre.magnitude(shape2.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < shape2.vertices.length; i++)
			{
				tempMag = centre.magnitude(shape2.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = shape2.vertices[i];
				}
			}
			
			//get axes from circle and closest vertex
			axes1 = new Vector2D[1];
			axes1[0] = shape1.getPosition().sub(closest);
			axes1[0].normalise();
		}
		
		
		//else, the other is a circle
		else if (shape2.isCircle())
		{
			//get vertex closest to centre of circle
			Vector2D centre = shape2.getPosition();
			Vector2D closest = shape1.vertices[0];
			float mag = centre.magnitude(shape1.vertices[0]);
			float tempMag = 0;
			
			for (int i = 1; i < shape1.vertices.length; i++)
			{
				tempMag = centre.magnitude(shape1.vertices[i]);
				
				if (tempMag < mag) {
					mag = tempMag;
					closest = shape1.vertices[i];
				}
			}
			
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
	 * Check to see if the bounding volume contains the point
	 * 
	 * @deprecated Use Shape object for bounds instead, as well as the associated
	 * 				SAT Collision method of contains(Shape, Point(Vector)).
	 */
	public static boolean contains(Bounding bound, Vector2D point)
	{
		//initialise the set of axes for the bound
		//Vector2D[] axes = null;
		ArrayList<Vector2D> axes = new ArrayList<Vector2D>();
		
		
		//Is the bound a circle?
		if (bound.isCircle())
		{
			//generate axes
			//axes = new Vector2D[1];
			//axes[0] = bound.getPosition().sub(point).normalise();
			Vector2D axis = bound.getPosition().sub(point);
			axis.normalise();
			axes.add(axis);
		}
		
		
		
		//continue as normal for collision			
		if (axes.size() == 0)
			axes = getAxes(bound);

		//axis and projections
		Vector2D axis;
		Projection p1, p2;
		
		
		for (int i = 0; i < axes.size(); i++)
		{
			axis = axes.get(i);
			p1 = project(bound, axis);
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
	 * Given a bound, get the axes of the bound from its vertices
	 * 
	 * @deprecated
	 */
	private static ArrayList<Vector2D> getAxes(Bounding bound)
	{
		int size = bound.vertices.length;
		ArrayList<Vector2D> axes = new ArrayList<Vector2D>();
		
		Vector2D v1, v2, edge, normal;
		
		for (int i = 0; i < size; i++)
		{
			v1 = bound.vertices[i];
			v2 = bound.vertices[i + 1 < size ? i + 1 : 0];
			edge = v1.sub(v2);
			normal = edge.rightPerp();
			normal.normalise();
			axes.add(normal);
		}
		
		return axes;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Projects the current bound's vertices onto the given axis
	 * 
	 * @deprecated
	 */
	private static Projection project(Bounding bound, Vector2D axis)
	{
		//is the bound a circle?
		if (bound.isCircle())
		{
			((BoundingCircle)bound).calcVertices(axis);
		}
		
		
		//continue normally
		float min = axis.dot(bound.vertices[0]);
		float max = min;
		
		for (int i = 0; i < bound.vertices.length; i++)
		{
			float p = axis.dot(bound.vertices[i]);
			
			if (p < min) min = p;
			else if (p > max) max = p;
		}
		
		return new Projection(min, max);
	}
	

}
