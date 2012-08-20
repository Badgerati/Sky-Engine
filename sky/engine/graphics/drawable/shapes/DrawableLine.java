package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Line;
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
public class DrawableLine extends Line implements DrawableShape
{
	
	/**
	 * Fill paint used for the line
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the line
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the line
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	


	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2 v1, Vector2 v2)
	{
		super(v1, v2);
		fillpaint = new Fill();
	}

	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2 v1, Vector2 v2, Vector2 velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		fillpaint = new Fill();
	}
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2 v1, Vector2 v2, Fill fill, Outline outline, Blur blur)
	{
		super(v1, v2);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2 v1, Vector2 v2, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2 v1, Vector2 v2, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(v1, v2);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2 v1, Vector2 v2, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(v1, v2, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
	}

	
	
	
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(DrawableLine line)
	{
		super(line.vertices[0], line.vertices[1], line.Velocity, line.Mass);
		Position = line.Position.clone();
		fillpaint = new Fill(line.fillpaint);
		outlinepaint = new Outline(line.outlinepaint);
		blurpaint = new Blur(line.blurpaint);
	}
	
	
	
	
	
	
	/**
	 * Clone this line
	 */
	public DrawableLine clone()
	{
		return new DrawableLine(this);
	}
	
	
	
	

	
	/**
	 * Returns the paint used to fill this line
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this line
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this line
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
	 * Draw this line
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, blurpaint);
			}
	
			if (outlinepaint != null)
			{
				canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, outlinepaint);
			}
	
			if (fillpaint != null)
			{
				canvas.drawLine(vertices[0].X, vertices[0].Y, vertices[1].X, vertices[1].Y, fillpaint);
			}
		}
	}
	
	

}
