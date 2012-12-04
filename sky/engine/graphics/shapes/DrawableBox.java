package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Box;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;

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
	public DrawableBox(DrawableBox box)
	{
		super(box);
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
	public void setPaints(Paints paint)
	{
		fillpaint = paint.fill();
		outlinepaint = paint.outline();
		blurpaint = paint.blur();
	}
	
	
	
	
	
	/**
	 * Rotate
	 */
	@Override
	public void rotate(float degrees)
	{
		super.rotate(degrees);
		Shader shader = fillpaint.getShader();
		
		if (shader != null)
		{
			Matrix mat = new Matrix();
			mat.postTranslate(-Position.X, -Position.Y);
			mat.postRotate(this.degreesOfRotation);
			mat.postTranslate(Position.X, Position.Y);
			shader.setLocalMatrix(mat);
		}
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
