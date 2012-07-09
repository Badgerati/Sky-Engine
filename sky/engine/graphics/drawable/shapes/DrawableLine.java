package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Line;
import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableLine extends Line implements DrawableShape
{
	/**
	 * Graphical Paint to paint this Graphical Line
	 */
	public ShapePaint Paint = null;
	
	
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a default Graphical Line
	 */
	public DrawableLine(Vector2D position, Vector2D v1, Vector2D v2)
	{
		super(position, v1, v2);
		Paint = new ShapePaint(Colour.WHITE, 0, false, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}

	
	/**
	 * Create new instance of a default Graphical Line
	 */
	public DrawableLine(Vector2D position, Vector2D v1, Vector2D v2, Vector2D velocity, float mass)
	{
		super(position, v1, v2, velocity, mass);
		Paint = new ShapePaint(Colour.WHITE, 0, false, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(Vector2D position, Vector2D v1, Vector2D v2, int fill, int outline)
	{
		super(position, v1, v2);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(Vector2D position, Vector2D v1, Vector2D v2, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(Vector2D position, Vector2D v1, Vector2D v2, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
	}
	
	
	

	
	
	/**
	 * Create new instance of a default Graphical Line
	 */
	public DrawableLine(Vector2D v1, Vector2D v2)
	{
		super(v1, v2);
		Paint = new ShapePaint(Colour.WHITE, 0, false, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a default Graphical Line
	 */
	public DrawableLine(Vector2D v1, Vector2D v2, Vector2D velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		Paint = new ShapePaint(Colour.WHITE, 0, false, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(Vector2D v1, Vector2D v2, int fill, int outline)
	{
		super(v1, v2);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(Vector2D v1, Vector2D v2, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(Vector2D v1, Vector2D v2, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
	}

	
	
	
	
	

	/**
	 * Create new instance of a Graphical Line
	 */
	public DrawableLine(DrawableLine gline)
	{
		super(gline.Position, gline.vertices[0], gline.vertices[1], gline.Velocity, gline.Mass);
		Paint = new ShapePaint(gline.Paint);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Graphical Line
	 */
	public DrawableLine clone()
	{
		return new DrawableLine(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this line to a given canvas
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, Paint.OutlinePaint);
		
		canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, Paint.FillPaint);
	}
	
	
	
	
	

}
