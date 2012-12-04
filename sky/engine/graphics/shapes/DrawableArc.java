package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Arc;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Shader;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableArc extends Arc implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the arc
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the arc
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the arc
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	/**
	 * Rectangular bounds to help draw the arc
	 */
	protected RectF rect = null;
	
	
	/**
	 * Draw the lines going towards the centre of the arc?
	 */
	public boolean UseCenterLines = true;
	
	
	
	
	
	

	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(Vector2d position, float radius, float startangle, float sweepangle)
	{
		super(position, radius, startangle, sweepangle);
		outlinepaint = new Outline();
		setRect();
	}
	
	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(Vector2d position, float radius, float startangle, float sweepangle, Fill fill, Outline outline, Blur blur)
	{
		super(position, radius, startangle, sweepangle);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		setRect();
	}
	
	
	
	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(DrawableArc arc)
	{
		super(arc);
		fillpaint = new Fill(arc.fillpaint);
		outlinepaint = new Outline(arc.outlinepaint);
		blurpaint = new Blur(arc.blurpaint);
		setRect();
	}
	
	
	
	
	
	
	/**
	 * 
	 */
	private void setRect()
	{
		float temp = Radius * 0.5f;
		rect = new RectF();
		rect.set(Position.X - temp, Position.Y - temp, Position.X + temp, Position.Y + temp);
	}
	
	
	
	
	
	
	
	/**
	 * Clone this arc
	 */
	public DrawableArc clone()
	{
		return new DrawableArc(this);
	}
	
	
	

	
	
	/**
	 * Returns the paint used to fill this arc
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this arc
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this arc
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
	 * Set the radius.
	 */
	@Override
	public void setRadius(float radius)
	{
		Radius = radius;
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Set the X position of the arc
	 */
	@Override
	public void setXPosition(float value)
	{
		super.setXPosition(value);
		setRect();
	}

	
	
	

	/**
	 * Set the Y position of the arc
	 */
	@Override
	public void setYPosition(float value)
	{
		super.setYPosition(value);
		setRect();
	}

	
	
	

	/**
	 * Set the position of the arc
	 */
	@Override
	public void setPosition(Vector2d position)
	{
		super.setPosition(position);
		setRect();
	}

	
	
	

	/**
	 * Set the position of the arc
	 */
	@Override
	public void setPosition(float x, float y)
	{
		super.setPosition(x, y);
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Integrate the position of this arc
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		setRect();
	}

	
	
	
	
	/**
	 * Integrate the position of this arc
	 */
	@Override
	public void integrate(Vector2d velocity, float dt)
	{
		super.integrate(velocity, dt);
		setRect();
	}

	
	
	
	
	/**
	 * Integrate the position of this arc
	 */
	@Override
	public void integrate(float x, float y, float dt)
	{
		super.integrate(x, y, dt);
		setRect();
	}


	
	
	
	
	
	/**
	 * Draw this arc
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawArc(rect, StartAngle, SweepAngle, UseCenterLines, blurpaint);
			}
	
			if (outlinepaint != null)
			{
				canvas.drawArc(rect, StartAngle, SweepAngle, UseCenterLines, outlinepaint);
			}
	
			if (fillpaint != null)
			{
				canvas.drawArc(rect, StartAngle, SweepAngle, UseCenterLines, fillpaint);
			}
		}
	}
	
	
	
	
	
}
