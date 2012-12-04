package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Circle;
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
public class DrawableCircle extends Circle implements IDrawableShape, IDrawableComponent
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
	public DrawableCircle(Vector2d position, float radius)
	{
		super(position, radius);
		outlinepaint = new Outline();
	}
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(Vector2d position, float radius, Fill fill, Outline outline, Blur blur)
	{
		super(position, radius);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	
	
	/**
	 * Create new instance of a circle
	 */
	public DrawableCircle(DrawableCircle circle)
	{
		super(circle);
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
	 * Set the paints for the shape
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
