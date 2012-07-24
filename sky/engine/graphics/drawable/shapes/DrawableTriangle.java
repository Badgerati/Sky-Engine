package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Triangle;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableTriangle extends Triangle implements DrawableShape
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
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 v1, Vector2 v2, Vector2 v3)
	{
		super(v1, v2, v3);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Vector2 velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Fill fill, Outline outline, Blur blur)
	{
		super(v1, v2, v3);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 v1, Vector2 v2, Vector2 v3, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
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
	public DrawableTriangle(Vector2 v1, Vector2 v2, Vector2 v3, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
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
	public DrawableTriangle(Vector2 position, float sidex, float sidey, float sidez)
	{
		super(position, sidex, sidey, sidez);
		outlinepaint = new Outline();
		initialise();
	}

	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 position, float sidex, float sidey, float sidez, Vector2 velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 position, float sidex, float sidey, float sidez, Fill fill, Outline outline, Blur blur)
	{
		super(position, sidex, sidey, sidez);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 position, float sidex, float sidey, float sidez, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a triangle
	 */
	public DrawableTriangle(Vector2 position, float sidex, float sidey, float sidez, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
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
	public DrawableTriangle(Vector2 position, float sidex, float sidey, float sidez, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
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
	 * Draw this triangle
	 */
	public void draw(Canvas canvas)
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
