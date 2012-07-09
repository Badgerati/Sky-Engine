package sky.engine.graphics.drawable.shapes;

import android.graphics.Canvas;
import sky.engine.geometry.shapes.Circle;
import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableCircle extends Circle implements DrawableShape
{
	/**
	 * Graphical Paint to paint this Graphical Circle
	 */
	public ShapePaint Paint = null;
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a default Graphical Circle
	 */
	public DrawableCircle(Vector2D position, float radius)
	{
		super(position, radius);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}

	
	/**
	 * Create new instance of a default Graphical Circle
	 */
	public DrawableCircle(Vector2D position, float radius, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public DrawableCircle(Vector2D position, float radius, int fill, int outline)
	{
		super(position, radius);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public DrawableCircle(Vector2D position, float radius, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public DrawableCircle(Vector2D position, float radius, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
	}
	
	
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public DrawableCircle(DrawableCircle circle)
	{
		super(circle.Position, circle.Radius, circle.Velocity, circle.Mass);
		Paint = new ShapePaint(circle.Paint);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Graphical Circle
	 */
	public DrawableCircle clone()
	{
		return new DrawableCircle(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Circle to a given canvas
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawCircle(Position.X, Position.Y, Radius, Paint.OutlinePaint);
		
		canvas.drawCircle(Position.X, Position.Y, Radius, Paint.FillPaint);
	}

	
	
	
	
}
