package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Line;
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
public class DrawableLine extends Line implements IDrawableShape, IDrawableComponent
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
	public DrawableLine(Vector2d v1, Vector2d v2)
	{
		super(v1, v2);
		fillpaint = new Fill();
	}
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(Vector2d v1, Vector2d v2, Fill fill, Outline outline, Blur blur)
	{
		super(v1, v2);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}

	
	
	
	
	
	/**
	 * Create new instance of a line
	 */
	public DrawableLine(DrawableLine line)
	{
		super(line);
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
	 * Set the paint for the shape
	 */
	public void setPaints(Paints paint)
	{
		fillpaint = paint.fill();
		outlinepaint = paint.outline();
		blurpaint = paint.blur();
	}
	
	
	
	
	
	
	/**
	 * Set the alpha for the shape
	 */
	public void setAlpha(int alpha)
	{
		if (fillpaint != null) fillpaint.setAlpha(alpha);
		if (outlinepaint != null) outlinepaint.setAlpha(alpha);
		if (blurpaint != null) blurpaint.setAlpha(alpha);
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
