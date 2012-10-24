package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Oval;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import android.graphics.Canvas;
import android.graphics.RectF;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableOval extends Oval implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the oval
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the oval
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the oval
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	/**
	 * Rectangular bounds to help draw the oval
	 */
	protected RectF rect = null;
	
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(Vector2d position, float xradius, float yradius)
	{
		super(position, xradius, yradius);
		outlinepaint = new Outline();
		setRect();
	}

	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(Vector2d position, float xradius, float yradius, Vector2d velocity, float mass)
	{
		super(position, xradius, yradius, velocity, mass);
		outlinepaint = new Outline();
		setRect();
	}
	
	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(Vector2d position, float xradius, float yradius, Fill fill, Outline outline, Blur blur)
	{
		super(position, xradius, yradius);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		setRect();
	}
	
	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(Vector2d position, float xradius, float yradius, Fill fill, Outline outline, Blur blur, Vector2d velocity, float mass)
	{
		super(position, xradius, yradius, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		setRect();
	}
	
	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(Vector2d position, float xradius, float yradius, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, xradius, yradius);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		setRect();
	}
	
	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(Vector2d position, float xradius, float yradius, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2d velocity, float mass)
	{
		super(position, xradius, yradius, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		setRect();
	}
	
	
	
	
	/**
	 * Create new instance of an oval
	 */
	public DrawableOval(DrawableOval oval)
	{
		super(oval.Position, oval.xRadius, oval.yRadius, oval.Velocity, oval.Mass);
		fillpaint = new Fill(oval.fillpaint);
		outlinepaint = new Outline(oval.outlinepaint);
		blurpaint = new Blur(oval.blurpaint);
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Set the rectangular bounds
	 */
	private void setRect()
	{
		rect = new RectF();
		rect.set(Position.X - xRadius, Position.Y - yRadius, Position.X + xRadius, Position.Y + yRadius);
	}
	
	
	
	
	
	
	/**
	 * Clone this oval
	 */
	public DrawableOval clone()
	{
		return new DrawableOval(this);
	}
	
	
	

	
	
	/**
	 * Returns the paint used to fill this oval
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this oval
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this oval
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
	 * Set the x-radius.
	 */
	@Override
	public void setXRadius(float xradius)
	{
		xRadius = xradius;
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Set the y-radius.
	 */
	@Override
	public void setYRadius(float yradius)
	{
		yRadius = yradius;
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Set the X position of the oval
	 */
	@Override
	public void setXPosition(float value)
	{
		super.setXPosition(value);
		setRect();
	}

	
	
	

	/**
	 * Set the Y position of the oval
	 */
	@Override
	public void setYPosition(float value)
	{
		super.setYPosition(value);
		setRect();
	}

	
	
	

	/**
	 * Set the position of the oval
	 */
	@Override
	public void setPosition(Vector2d position)
	{
		super.setPosition(position);
		setRect();
	}

	
	
	

	/**
	 * Set the position of the oval
	 */
	@Override
	public void setPosition(float x, float y)
	{
		super.setPosition(x, y);
		setRect();
	}
	
	
	
	


	/**
	 * Integrate the position of this oval
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		setRect();
	}

	
	
	
	
	/**
	 * Integrate the position of this oval
	 */
	@Override
	public void integrate(float x, float y, float dt)
	{
		super.integrate(x, y, dt);
		setRect();
	}

	
	
	
	
	/**
	 * Integrate the position of this oval
	 */
	@Override
	public void integrate(Vector2d velocity, float dt)
	{
		super.integrate(velocity, dt);
		setRect();
	}
	
	
	
	
	
	/**
	 * Draw this oval
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawOval(rect, blurpaint);
			}
			
			if (outlinepaint != null)
			{
				canvas.drawOval(rect, outlinepaint);
			}
			
			if (fillpaint != null)
			{
				canvas.drawOval(rect, fillpaint);
			}
		}
	}
	
	
	
	
	
	
}
