package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Quad;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableQuad extends Quad implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the quad
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the quad
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the quad
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	
	

	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4)
	{
		super(v1, v2, v3, v4);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, Vector2d velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, Fill fill, Outline outline, Blur blur)
	{
		super(v1, v2, v3, v4);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, Fill fill, Outline outline, Blur blur, Vector2d velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(v1, v2, v3, v4);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d v4, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2d velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a quad
	 */
	public DrawableQuad(DrawableQuad quad)
	{
		super(quad.Position, quad.vertices[0], quad.vertices[1], quad.vertices[2], quad.vertices[3], quad.Velocity, quad.Mass);
		fillpaint = new Fill(quad.fillpaint);
		outlinepaint = new Outline(quad.outlinepaint);
		blurpaint = new Blur(quad.blurpaint);
		initialise();
	}
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this quad via the vertices
	 */
	private void initialise()
	{
		if (polygon == null)
		{
			polygon = new Path();
			matrix = new Matrix();
		}
		
		polygon.reset();
		polygon.moveTo(vertices[0].X, vertices[0].Y);
		for (int i = 1; i < vertices.length; i++)
		{
			polygon.lineTo(vertices[i].X, vertices[i].Y);
		}
		polygon.close();
	}
	
	
	
	
	
	
	/**
	 * Clone this quad
	 */
	public DrawableQuad clone()
	{
		return new DrawableQuad(this);
	}
	
	
	
	
	
	/**
	 * Returns the paint used to fill this quad
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this quad
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this quad
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
	 * Draw this quad
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
		{
			if (blurpaint != null)
			{
				canvas.drawPath(polygon, blurpaint);
			}
	
			if (outlinepaint != null)
			{
				canvas.drawPath(polygon, outlinepaint);
			}
	
			if (fillpaint != null)
			{
				canvas.drawPath(polygon, fillpaint);
			}
		}
	}
	
	
	
}
