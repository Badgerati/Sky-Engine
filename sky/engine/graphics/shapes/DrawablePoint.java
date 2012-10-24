package sky.engine.graphics.shapes;

import android.graphics.Canvas;
import sky.engine.geometry.shapes.Shape;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawablePoint extends Shape implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the point
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the point
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the point
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	
	
	
	
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(Vector2d position)
	{
		super(position);
		outlinepaint = new Outline();
		initialise(position);
	}
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(Vector2d position, Vector2d velocity, float mass)
	{
		super(position, velocity, mass);
		outlinepaint = new Outline();
		initialise(position);
	}
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(Vector2d position, Fill fill, Outline outline, Blur blur)
	{
		super(position);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise(position);
	}
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(Vector2d position, Fill fill, Outline outline, Blur blur, Vector2d velocity, float mass)
	{
		super(position, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise(position);
	}
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(Vector2d position, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise(position);
	}
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(Vector2d position, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2d velocity, float mass)
	{
		super(position, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise(position);
	}
	
	
	/**
	 * Create instance of a new point
	 */
	public DrawablePoint(DrawablePoint point)
	{
		super(point.Position, point.Velocity, point.Mass);
		fillpaint = new Fill(point.fillpaint);
		outlinepaint = new Outline(point.outlinepaint);
		blurpaint = new Blur(point.blurpaint);
		initialise(point.Position);
	}
	
	
	
	
	
	
	
	/**
	 * Initialise the point
	 */
	private void initialise(Vector2d position)
	{
		vertices = new Vector2d[1];
		vertices[0] = position.clone();
	}
	
	
	
	
	
	
	
	/**
	 * Clone this point
	 */
	public DrawablePoint clone()
	{
		return new DrawablePoint(this);
	}
	
	
	
	

	
	
	/**
	 * Returns the paint used to fill this point
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this point
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this point
	 */
	public Blur blur()
	{
		return blurpaint;
	}
	
	
	/**
	 * Set the paint for the shape
	 */
	public void setPaint(Paints paint)
	{
		fillpaint = paint.fill();
		outlinepaint = paint.outline();
		blurpaint = paint.blur();
	}
	
	
	
	
	
	
	
	/**
	 * Hides the shape
	 */
	public void hide()
	{
		hidden = true;
	}
	
	
	
	/**
	 * Shows the shape
	 */
	public void show()
	{
		hidden = false;
	}
	
	
	
	
	
	
	/**
	 * Draw this point
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawPoint(Position.X, Position.Y, blurpaint);
			}
			
			if (outlinepaint != null)
			{
				canvas.drawPoint(Position.X, Position.Y, outlinepaint);
			}
			
			if (fillpaint != null)
			{
				canvas.drawPoint(Position.X, Position.Y, fillpaint);
			}
		}
	}
	
	
	
	
	
	
	
}
