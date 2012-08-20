package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Arc;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableArc extends Arc implements DrawableShape
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
	public DrawableArc(Vector2 position, float radius, float startangle, float sweepangle)
	{
		super(position, radius, startangle, sweepangle);
		outlinepaint = new Outline();
		setRect();
	}

	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(Vector2 position, float radius, float startangle, float sweepangle, Vector2 velocity, float mass)
	{
		super(position, radius, startangle, sweepangle, velocity, mass);
		outlinepaint = new Outline();
		setRect();
	}
	
	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(Vector2 position, float radius, float startangle, float sweepangle, Fill fill, Outline outline, Blur blur)
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
	public DrawableArc(Vector2 position, float radius, float startangle, float sweepangle, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, radius, startangle, sweepangle, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		setRect();
	}
	
	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(Vector2 position, float radius, float startangle, float sweepangle, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, radius, startangle, sweepangle);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		setRect();
	}
	
	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(Vector2 position, float radius, float startangle, float sweepangle, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(position, radius, startangle, sweepangle, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		setRect();
	}
	
	
	
	
	/**
	 * Create new instance of a arc
	 */
	public DrawableArc(DrawableArc arc)
	{
		super(arc.Position, arc.Radius, arc.StartAngle, arc.SweepAngle, arc.Velocity, arc.Mass);
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
	public void setPosition(Vector2 position)
	{
		super.setPosition(position);
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
	public void integrate(Vector2 velocity, float dt)
	{
		super.integrate(velocity, dt);
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
