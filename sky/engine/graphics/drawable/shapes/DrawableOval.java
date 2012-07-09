package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Oval;
import sky.engine.geometry.vectors.Vector2D;
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
public class DrawableOval extends Oval implements DrawableShape
{
	/**
	 * Paint to paint this Drawable Oval
	 */
	public ShapePaint Paint = null;
	
	
	/**
	 * Rectangular bounds to help draw the oval
	 */
	protected RectF rect = null;
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a default Drawable Oval
	 */
	public DrawableOval(Vector2D position, float xradius, float yradius)
	{
		super(position, xradius, yradius);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		setRect();
	}

	
	/**
	 * Create new instance of a default Drawable Oval
	 */
	public DrawableOval(Vector2D position, float xradius, float yradius, Vector2D velocity, float mass)
	{
		super(position, xradius, yradius, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		setRect();
	}
	
	
	/**
	 * Create new instance of a Drawable Oval
	 */
	public DrawableOval(Vector2D position, float xradius, float yradius, int fill, int outline)
	{
		super(position, xradius, yradius);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		setRect();
	}
	
	
	/**
	 * Create new instance of a Drawable Oval
	 */
	public DrawableOval(Vector2D position, float xradius, float yradius, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, xradius, yradius, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		setRect();
	}
	
	
	/**
	 * Create new instance of a Drawable Oval
	 */
	public DrawableOval(Vector2D position, float xradius, float yradius, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, xradius, yradius, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		setRect();
	}
	
	
	
	
	/**
	 * Create new instance of a Drawable Oval
	 */
	public DrawableOval(DrawableOval oval)
	{
		super(oval.Position, oval.xRadius, oval.yRadius, oval.Velocity, oval.Mass);
		Paint = new ShapePaint(oval.Paint);
		setRect();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 */
	private void setRect()
	{
		rect = new RectF();
		rect.set(Position.X - xRadius, Position.Y - yRadius, Position.X + xRadius, Position.Y + yRadius);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Drawable Oval
	 */
	public DrawableOval clone()
	{
		return new DrawableOval(this);
	}
	

	
	
	
	
	
	
	/**
	 * Set the x-radius.
	 */
	@Override
	public void setXRadius(float xradius)
	{
		xRadius = xradius;
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Set the y-radius.
	 */
	@Override
	public void setYRadius(float yradius)
	{
		yRadius = yradius;
		setRect();
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
	 * Draw this Drawable Oval to a given canvas
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawOval(rect, Paint.OutlinePaint);
		
		canvas.drawOval(rect, Paint.FillPaint);
	}
	
	
	
	
	
	
	
	
	
	
}
