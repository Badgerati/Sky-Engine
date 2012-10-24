package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Box;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableBox extends Box implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the box
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the box
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the box
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	
	

	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2d position, float width, float height)
	{
		super(position, width, height);
		outlinepaint = new Outline();
	}

	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2d position, float width, float height, Vector2d velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		outlinepaint = new Outline();
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2d position, float width, float height, Fill fill, Outline outline, Blur blur)
	{
		super(position, width, height);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2d position, float width, float height, Fill fill, Outline outline, Blur blur, Vector2d velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2d position, float width, float height, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, width, height);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2d position, float width, float height, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2d velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}
	
	

	
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(DrawableBox box)
	{
		super(box.Position, box.Width, box.Height, box.Velocity, box.Mass);
		fillpaint = new Fill(box.fillpaint);
		outlinepaint = new Outline(box.outlinepaint);
		blurpaint = new Blur(box.blurpaint);
	}
	
	
	
	
	
	
	/**
	 * Clone this box
	 */
	public DrawableBox clone()
	{
		return new DrawableBox(this);
	}
	
	
	
	
	
	/**
	 * Returns the paint used to fill this box
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this box
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this box
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
	 * Draw this box
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawRect(vertices[0].X, vertices[0].Y, vertices[2].X, vertices[2].Y, blurpaint);
			}
	
			if (outlinepaint != null)
			{
				canvas.drawRect(vertices[0].X, vertices[0].Y, vertices[2].X, vertices[2].Y, outlinepaint);
			}
	
			if (fillpaint != null)
			{
				canvas.drawRect(vertices[0].X, vertices[0].Y, vertices[2].X, vertices[2].Y, fillpaint);
			}
		}
	}
	
	
	
	
}