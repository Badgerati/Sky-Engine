package sky.engine.graphics.drawable.shapes;

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
public class DrawableRoundBox extends DrawableBox
{
	/**
	 * Rect bounds for this Rounded Box
	 */
	protected RectF rect = null;
	
	
	/**
	 * The x-radius of the oval used to round the corners
	 */
	public float xRadius = 0;
	
	
	/**
	 * The y-radius of the oval used to round the corners
	 */
	public float yRadius = 0;
	
	
	
	
	

	
	
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(DrawableBox box, float rx, float ry)
	{
		super(box);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(Vector2 position, float width, float height, float rx, float ry)
	{
		super(position, width, height);
		intialise(rx, ry);
	}

	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(Vector2 position, float width, float height, float rx, float ry, Vector2 velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(Vector2 position, float width, float height, float rx, float ry, Fill fill, Outline outline, Blur blur)
	{
		super(position, width, height, fill, outline, blur);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(Vector2 position, float width, float height, float rx, float ry, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, width, height, fill, outline, blur, velocity, mass);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(Vector2 position, float width, float height, float rx, float ry, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, width, height, fill, outline, blur, outlinewidth, blurwidth, blurradius, antialias);
		intialise(rx, ry);
	}
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(Vector2 position, float width, float height, float rx, float ry, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(position, width, height, fill, outline, blur, outlinewidth, blurwidth, blurradius, antialias, velocity, mass);
		intialise(rx, ry);
	}
	
	

	
	
	
	/**
	 * Create new instance of a Round Box
	 */
	public DrawableRoundBox(DrawableRoundBox rbox)
	{
		super(rbox.Position, rbox.Width, rbox.Height, rbox.Velocity, rbox.Mass);
		fillpaint = new Fill(rbox.fillpaint);
		outlinepaint = new Outline(rbox.outlinepaint);
		blurpaint = new Blur(rbox.blurpaint);
		intialise(rbox.xRadius, rbox.yRadius);
	}
	
	
	
	
	
	
	
	/**
	 * Initialises the rect bounds for this rounded box.
	 */
	private void intialise(float rx, float ry)
	{
		xRadius = rx;
		yRadius = ry;
		setRect();
	}
	
	
	
	
	
	
	/**
	 * Set the rectangular bounds
	 */
	private void setRect()
	{
		rect = new RectF();
		rect.set((int)vertices[0].X, (int)vertices[0].Y, (int)vertices[2].X, (int)vertices[2].Y);
	}
	
	
	
	
	
	
	/**
	 * Clone this Round Box
	 */
	public DrawableRoundBox clone()
	{
		return new DrawableRoundBox(this);
	}
	
	
	
	
	
	
	/**
	 * Set the X position of the shape
	 */
	@Override
	public void setXPosition(float value)
	{
		super.setXPosition(value);
		setRect();
	}

	
	
	
	

	/**
	 * Set the Y position of the shape
	 */
	@Override
	public void setYPosition(float value)
	{
		super.setYPosition(value);
		setRect();
	}

	
	
	
	

	/**
	 * Set the position of the shape
	 */
	@Override
	public void setPosition(Vector2 position)
	{
		super.setPosition(position);
		setRect();
	}

	
	
	
	
	
	/**
	 * Integrate the position of this shape
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		setRect();
	}

	
	
	
	
	
	/**
	 * Integrate the position of this shape
	 */
	@Override
	public void integrate(Vector2 velocity, float dt)
	{
		super.integrate(velocity, dt);
		setRect();
	}
	

	
	
	
	
	/**
	 * Draw this Round Box
	 */
	@Override
	public void draw(Canvas canvas)
	{
		if (blurpaint != null)
		{
			canvas.drawRoundRect(rect, xRadius, yRadius, blurpaint);
		}

		if (outlinepaint != null)
		{
			canvas.drawRoundRect(rect, xRadius, yRadius, outlinepaint);
		}

		if (fillpaint != null)
		{
			canvas.drawRoundRect(rect, xRadius, yRadius, fillpaint);
		}
	}
	
	
	
	
	
	
	
}
