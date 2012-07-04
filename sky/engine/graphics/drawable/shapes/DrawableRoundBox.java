package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.paints.ShapePaint;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableRoundBox extends DrawableBox
{
	/**
	 * Rect bounds for this Rounded Box
	 */
	protected RectF rect = null;
	
	
	/**
	 * The x-radius of the oval used to round the corners
	 */
	public float xRadius = 0;
	
	
	/**
	 * The y-radius of the oval used to round the corners
	 */
	public float yRadius = 0;
	
	
	
	
	

	
	
	
	
	
	/**
	 * Create new instance of a default Drawable Round Box
	 */
	public DrawableRoundBox(DrawableBox box, float rx, float ry)
	{
		super(box);
		intialise(rx, ry);
	}
	
	
	

	

	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, float width, float height, float rx, float ry)
	{
		super(position, width, height);
		intialise(rx, ry);
	}

	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, float width, float height, float rx, float ry, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, float width, float height, float rx, float ry, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, width, height, fill, outline, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, float width, float height, float rx, float ry, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, width, height, fill, outline, outlinewidth, antialias, velocity, mass);
		intialise(rx, ry);
	}

	
	


	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry)
	{
		super(position, v1, v2, v3, v4);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, fill, outline, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, fill, outline, outlinewidth, antialias, velocity, mass);
		intialise(rx, ry);
	}

	
	


	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableRoundBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a default Graphical Box
	 */
	public DrawableRoundBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4,  float rx, float ry)
	{
		super(v1, v2, v3, v4);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, fill, outline, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, float rx, float ry, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, fill, outline, outlinewidth, antialias, velocity, mass);
		intialise(rx, ry);
	}
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Box
	 */
	public DrawableRoundBox(DrawableRoundBox rbox)
	{
		super(rbox.Position, rbox.vertices[0], rbox.vertices[1], rbox.vertices[2], rbox.vertices[3], rbox.Velocity, rbox.Mass);
		Paint = new ShapePaint(rbox.Paint);
		intialise(rbox.xRadius, rbox.yRadius);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the rect bounds for this rounded box.
	 */
	private void intialise(float rx, float ry)
	{
		//radii
		xRadius = rx;
		yRadius = ry;
		
		setRect();
	}
	
	
	
	
	/**
	 * Set the rectangular bounds
	 */
	private void setRect()
	{
		rect = new RectF();
		rect.set((int)vertices[0].X, (int)vertices[0].Y, (int)vertices[2].X, (int)vertices[2].Y);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Drawable Round Box
	 */
	public DrawableRoundBox clone()
	{
		return new DrawableRoundBox(this);
	}
	
	
	
	
	
	
	
	
	/**
	 * Integrate the position of this shape
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		setRect();
	}

	
	/**
	 * Integrate the position of this shape
	 */
	@Override
	public void integrate(Vector2D velocity, float dt)
	{
		super.integrate(velocity, dt);
		setRect();
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Drawable Round Box
	 */
	@Override
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawRoundRect(rect, xRadius, yRadius, Paint.OutlinePaint);
		
		canvas.drawRoundRect(rect, xRadius, yRadius, Paint.FillPaint);
	}
	
	
	
	
	
	
	
	
	
	
}
