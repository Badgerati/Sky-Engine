package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Box;
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
public class DrawableBox extends Box implements DrawableShape
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
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2 position, float width, float height)
	{
		super(position, width, height);
		outlinepaint = new Outline();
	}

	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2 position, float width, float height, Vector2 velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		outlinepaint = new Outline();
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2 position, float width, float height, Fill fill, Outline outline, Blur blur)
	{
		super(position, width, height);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2 position, float width, float height, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2 position, float width, float height, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, width, height);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}
	
	
	/**
	 * Create new instance of a box
	 */
	public DrawableBox(Vector2 position, float width, float height, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
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
	 * Draw this box
	 */
	public void draw(Canvas canvas)
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
