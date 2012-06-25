package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Arc;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableArc extends Arc implements DrawableShape
{
	/**
	 * Paint to paint this Drawable Arc
	 */
	public ShapePaint Paint = null;
	
	
	/**
	 * Rectangular bounds to help draw the arc
	 */
	protected RectF rect = null;
	
	
	/**
	 * Draw the lines going towards the center of the arc?
	 */
	public boolean UseCenterLines = true;
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a default Drawable Arc
	 */
	public DrawableArc(Vector2D position, float radius, float startangle, float sweepangle)
	{
		super(position, radius, startangle, sweepangle);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}

	
	/**
	 * Create new instance of a default Drawable Arc
	 */
	public DrawableArc(Vector2D position, float radius, float startangle, float sweepangle, Vector2D velocity, float mass)
	{
		super(position, radius, startangle, sweepangle, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Drawable Arc
	 */
	public DrawableArc(Vector2D position, float radius, float startangle, float sweepangle, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, radius, startangle, sweepangle, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Drawable Arc
	 */
	public DrawableArc(Vector2D position, float radius, float startangle, float sweepangle, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, radius, startangle, sweepangle, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	
	
	
	/**
	 * Create new instance of a Drawable Arc
	 */
	public DrawableArc(DrawableArc arc)
	{
		super(arc.Position, arc.Radius, arc.StartAngle, arc.SweepAngle, arc.Velocity, arc.Mass);
		Paint = new ShapePaint(arc.Paint);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private void initialise()
	{
		float temp = Radius * 0.5f;
		rect = new RectF();
		rect.set(Position.X - temp, Position.Y - temp, Position.X + temp, Position.Y + temp);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Drawable Arc
	 */
	public DrawableArc clone()
	{
		return new DrawableArc(this);
	}
	
	
	
	
	
	
	
	
	/**
	 * Set the radius.
	 */
	@Override
	public void setRadius(float radius)
	{
		Radius = radius;
		initialise();
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Drawable Arc to a given canvas
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawArc(rect, StartAngle, SweepAngle, UseCenterLines, Paint.OutlinePaint);
		
		canvas.drawArc(rect, StartAngle, SweepAngle, UseCenterLines, Paint.FillPaint);
	}
	
	
	
	
	
}
