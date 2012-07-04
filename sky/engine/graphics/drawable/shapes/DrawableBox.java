package sky.engine.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import sky.engine.geometry.shapes.Box;
import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableBox extends Box implements DrawableShape
{
	/**
	 * Graphical Paint to paint this Graphical Box
	 */
	public ShapePaint Paint = null;
	
	
	
	
	


	


	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableBox(Vector2D position, float width, float height)
	{
		super(position, width, height);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}

	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableBox(Vector2D position, float width, float height, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D position, float width, float height, int fill, int outline)
	{
		super(position, width, height);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D position, float width, float height, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D position, float width, float height, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}

	
	


	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{
		super(position, v1, v2, v3, v4);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline)
	{
		super(position, v1, v2, v3, v4);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}

	
	


	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4)
	{
		super(v1, v2, v3, v4);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline)
	{
		super(v1, v2, v3, v4);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableBox(DrawableBox gbox)
	{
		super(gbox.Position, gbox.vertices[0], gbox.vertices[1], gbox.vertices[2], gbox.vertices[3], gbox.Velocity, gbox.Mass);
		Paint = new ShapePaint(gbox.Paint);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this Graphical Box via the vertices
	 */
	private void initialise()
	{
		if (polygon == null)
		{
			polygon = new Path();
			matrix = new Matrix();
		}
		
		polygon.reset();
		polygon.moveTo(vertices[0].X, vertices[0].Y);
		for (int i = 1; i < vertices.length; i++)
		{
			polygon.lineTo(vertices[i].X, vertices[i].Y);
		}
		polygon.close();
	}
	
	
	
	
	

	
	
	/**
	 * Set the box's height
	 */
	@Override
	public void setHeight(float height)
	{
		super.setHeight(height);
		initialise();
	}
	
	
	/**
	 * Set the box's width
	 */
	@Override
	public void setWidth(float width)
	{
		super.setWidth(width);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Graphical Box
	 */
	public DrawableBox clone()
	{
		return new DrawableBox(this);
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Box
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawPath(polygon, Paint.OutlinePaint);
		
		canvas.drawPath(polygon, Paint.FillPaint);
	}
	
	
	
	
}
