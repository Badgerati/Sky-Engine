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
import android.graphics.Shader;

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
	public DrawableQuad(DrawableQuad quad)
	{
		super(quad);
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
		Shader shader = fillpaint == null ? null : fillpaint.getShader();
		
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
