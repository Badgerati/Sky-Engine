package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Triangle;
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
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableTriangle extends Triangle implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the triangle
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the triangle
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the triangle
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	

	

	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d v1, Vector2d v2, Vector2d v3)
	{
		super(v1, v2, v3);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d v1, Vector2d v2, Vector2d v3, Fill fill, Outline outline, Blur blur)
	{
		super(v1, v2, v3);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}


	
	


	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d position, float sidex, float sidey, float sidez)
	{
		super(position, sidex, sidey, sidez);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d position, float sidex, float sidey, float sidez, Fill fill, Outline outline, Blur blur)
	{
		super(position, sidex, sidey, sidez);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(DrawableTriangle tri)
	{
		super(tri);
		fillpaint = new Fill(tri.fillpaint);
		outlinepaint = new Outline(tri.outlinepaint);
		blurpaint = new Blur(tri.blurpaint);
		initialise();
	}
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this triangle via the vertices
	 */
	private void initialise()
	{
		polygon = new Path();
		matrix = new Matrix();
		
		polygon.moveTo(vertices[0].X, vertices[0].Y);
		for (int i = 1; i < vertices.length; i++)
		{
			polygon.lineTo(vertices[i].X, vertices[i].Y);
		}
		polygon.close();
	}
	
	
	
	
	
	
	
	/**
	 * Clone this triangle
	 */
	public DrawableTriangle clone()
	{
		return new DrawableTriangle(this);
	}
	
	
	

	
	
	/**
	 * Returns the paint used to fill this triangle
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	
	
	
	/**
	 * Returns the paint used for the outline of this triangle
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	
	
	
	/**
	 * Returns the paint used for the blurring effect of this triangle
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
	 * Draw this triangle
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
