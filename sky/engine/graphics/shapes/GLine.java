package sky.engine.graphics.shapes;

import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Line;
import sky.engine.graphics.Colour;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GLine extends Line
{
	/**
	 * Graphical Paint to paint this Graphical Line
	 */
	public GPaint Paint = null;
	
	
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a default Graphical Line
	 */
	public GLine(Vector2D position, Vector2D v1, Vector2D v2, Vector2D velocity, float mass)
	{
		super(position, v1, v2, velocity, mass);
		Paint = new GPaint(Colour.WHITE, 0, false, GPaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public GLine(Vector2D position, Vector2D v1, Vector2D v2, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public GLine(Vector2D position, Vector2D v1, Vector2D v2, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
	}
	
	
	
	
	
	
	/**
	 * Create new instance of a default Graphical Line
	 */
	public GLine(Vector2D v1, Vector2D v2, Vector2D velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		Paint = new GPaint(Colour.WHITE, 0, false, GPaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public GLine(Vector2D v1, Vector2D v2, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create new instance of a Graphical Line
	 */
	public GLine(Vector2D v1, Vector2D v2, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
	}

	
	
	
	
	

	/**
	 * Create new instance of a Graphical Line
	 */
	public GLine(GLine gline)
	{
		super(gline.Position, gline.vertices[0], gline.vertices[1], gline.Velocity, gline.Mass);
		Paint = new GPaint(gline.Paint);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Graphical Line
	 */
	public GLine clone()
	{
		return new GLine(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this line to a given canvas
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.Outline)
			canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, Paint.OutlinePaint);
		
		canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, Paint.FillPaint);
	}
	
	
	
	
	

}
