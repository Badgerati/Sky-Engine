package sky.engine.graphics.shapes;

import android.graphics.Canvas;
import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Circle;
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
	public DrawableCircle(Vector2D position, float radius, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
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
	public DrawableCircle(Vector2D position, float radius, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new ShapePaint(fill, outline, showoutline, outlinewidth, antialias);
	}
	
	
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public DrawableCircle(DrawableCircle gcircle)
	{
		super(gcircle.Position, gcircle.Radius, gcircle.Velocity, gcircle.Mass);
		Paint = new ShapePaint(gcircle.Paint);
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
		if (Paint.Outline)
			canvas.drawCircle(Position.X, Position.Y, Radius, Paint.OutlinePaint);
		
		canvas.drawCircle(Position.X, Position.Y, Radius, Paint.FillPaint);
	}

	
	
	
	
}
