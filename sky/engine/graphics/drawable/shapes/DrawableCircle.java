package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Circle;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableCircle extends Circle implements DrawableShape
{
	
	/**
	 * Fill paint used for the circle
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the circle
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the circle
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2 position, float radius)
	{
		super(position, radius);
		outlinepaint = new Outline();
	}

	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2 position, float radius, Vector2 velocity, float mass)
	{
		super(position, radius, velocity, mass);
		outlinepaint = new Outline();
	}
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2 position, float radius, Fill fill, Outline outline, Blur blur)
	{
		super(position, radius);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2 position, float radius, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, radius, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2 position, float radius, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, radius);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2 position, float radius, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(position, radius, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}
	
	
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(DrawableCircle circle)
	{
		super(circle.Position, circle.Radius, circle.Velocity, circle.Mass);
		fillpaint = new Fill(circle.fillpaint);
		outlinepaint = new Outline(circle.outlinepaint);
		blurpaint = new Blur(circle.blurpaint);
	}
	
	
	
	
	
	
	
	
	/**
	 * Clone this circle
	 */
	public DrawableCircle clone()
	{
		return new DrawableCircle(this);
	}
	
	
	
	

	
	
	/**
	 * Returns the paint used to fill this circle
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this circle
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this circle
	 */
	public Blur blur()
	{
		return blurpaint;
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
	 * Draw this circle
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawCircle(Position.X, Position.Y, Radius, blurpaint);
			}
			
			if (outlinepaint != null)
			{
				canvas.drawCircle(Position.X, Position.Y, Radius, outlinepaint);
			}
			
			if (fillpaint != null)
			{
				canvas.drawCircle(Position.X, Position.Y, Radius, fillpaint);
			}
		}
	}

	
	
	
	
}
