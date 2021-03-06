package sky.engine.graphics.shapes;

import sky.engine.geometry.shapes.Polygon;
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
public class DrawablePolygon extends Polygon implements IDrawableShape, IDrawableComponent
{
	
	/**
	 * Fill paint used for the polygon
	 */
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint used for the polygon
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint used for the polygon
	 */
	protected Blur blurpaint = null;
	
	
	/**
	 * Is this shape to be hidden?
	 */
	protected boolean hidden = false;
	
	
	
	
	
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2d[] vertices)
	{
		super(vertices);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2d[] vertices, Fill fill, Outline outline, Blur blur)
	{
		super(vertices);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	


	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2d position, int noOfVertices, float size)
	{
		super(position, noOfVertices, size);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2d position, int noOfVertices, float size, Fill fill, Outline outline, Blur blur)
	{
		super(position, noOfVertices, size);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	


	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2d position, int noOfVertices, float minSize, float maxSize)
	{
		super(position, noOfVertices, minSize, maxSize);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2d position, int noOfVertices, float minSize, float maxSize, Fill fill, Outline outline, Blur blur)
	{
		super(position, noOfVertices, minSize, maxSize);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(DrawablePolygon poly)
	{
		super(poly);
		fillpaint = new Fill(poly.fillpaint);
		outlinepaint = new Outline(poly.outlinepaint);
		blurpaint = new Blur(poly.blurpaint);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this polygon via the vertices
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
	 * Clone this polygon
	 */
	public DrawablePolygon clone()
	{
		return new DrawablePolygon(this);
	}
	
	
	
	

	
	
	/**
	 * Returns the paint used to fill this polygon
	 */
	public Fill fill()
	{
		return fillpaint;
	}
	
	
	/**
	 * Returns the paint used for the outline of this polygon
	 */
	public Outline outline()
	{
		return outlinepaint;
	}
	
	
	/**
	 * Returns the paint used for the blurring effect of this polygon
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
			matrix.reset();
			matrix.postTranslate(-Position.X, -Position.Y);
			matrix.postRotate(this.degreesOfRotation);
			matrix.postTranslate(Position.X, Position.Y);
			shader.setLocalMatrix(matrix);
		}
	}
	
	
	
	
	
	/**
	 * Rotate
	 */
	@Override
	public void rotate(float degrees, Vector2d origin)
	{
		super.rotate(degrees, origin);
		Shader shader = fillpaint == null ? null : fillpaint.getShader();
		
		if (shader != null)
		{
			matrix.reset();
			matrix.postTranslate(-origin.X, -origin.Y);
			matrix.postRotate(this.degreesOfRotation);
			matrix.postTranslate(origin.X, origin.Y);
			shader.setLocalMatrix(matrix);
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
	 * Draw this polygon
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
