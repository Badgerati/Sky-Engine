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
	public DrawableTriangle(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
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
	public DrawableTriangle(Vector2d v1, Vector2d v2, Vector2d v3, Fill fill, Outline outline, Blur blur, Vector2d velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d v1, Vector2d v2, Vector2d v3, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(v1, v2, v3);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d v1, Vector2d v2, Vector2d v3, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2d velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
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
	public DrawableTriangle(Vector2d position, float sidex, float sidey, float sidez, Vector2d velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
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
	public DrawableTriangle(Vector2d position, float sidex, float sidey, float sidez, Fill fill, Outline outline, Blur blur, Vector2d velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d position, float sidex, float sidey, float sidez, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, sidex, sidey, sidez);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2d position, float sidex, float sidey, float sidez, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2d velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(DrawableTriangle tri)
	{
		super(tri.Position, tri.vertices[0], tri.vertices[1], tri.vertices[2], tri.Velocity, tri.Mass);
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
