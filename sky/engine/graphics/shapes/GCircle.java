package sky.engine.graphics.shapes;

import android.graphics.Canvas;
import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Circle;
import sky.engine.graphics.Colour;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GCircle extends Circle
{
	/**
	 * Graphical Paint to paint this Graphical Circle
	 */
	public GPaint Paint = null;
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a default Graphical Circle
	 */
	public GCircle(Vector2D position, float radius, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public GCircle(Vector2D position, float radius, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public GCircle(Vector2D position, float radius, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, radius, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
	}
	
	
	
	
	/**
	 * Create new instance of a Graphical Circle
	 */
	public GCircle(GCircle gcircle)
	{
		super(gcircle.Position, gcircle.Radius, gcircle.Velocity, gcircle.Mass);
		Paint = new GPaint(gcircle.Paint);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Graphical Circle
	 */
	public GCircle clone()
	{
		return new GCircle(this);
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
