package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Polygon;
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
public class DrawablePolygon extends Polygon implements DrawableShape
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
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2[] vertices)
	{
		super(vertices);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2[] vertices, Vector2 velocity, float mass)
	{
		super(vertices, velocity, mass);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2[] vertices, Fill fill, Outline outline, Blur blur)
	{
		super(vertices);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2[] vertices, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(vertices, velocity, mass);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2[] vertices, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(vertices);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2[] vertices, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(vertices, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	


	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float size)
	{
		super(position, noOfVertices, size);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float size, Vector2 velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float size, Fill fill, Outline outline, Blur blur)
	{
		super(position, noOfVertices, size);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float size, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float size, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, noOfVertices, size);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float size, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	


	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float minSize, float maxSize)
	{
		super(position, noOfVertices, minSize, maxSize);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a default polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float minSize, float maxSize, Vector2 velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		outlinepaint = new Outline();
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float minSize, float maxSize, Fill fill, Outline outline, Blur blur)
	{
		super(position, noOfVertices, minSize, maxSize);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float minSize, float maxSize, Fill fill, Outline outline, Blur blur, Vector2 velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		fillpaint = fill;
		outlinepaint = outline;
		blurpaint = blur;
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float minSize, float maxSize, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		super(position, noOfVertices, minSize, maxSize);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(Vector2 position, int noOfVertices, float minSize, float maxSize, int fill, int outline, int blur, float outlinewidth, float blurwidth, float blurradius, boolean antialias, Vector2 velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		fillpaint = new Fill(fill, antialias);
		outlinepaint = new Outline(outline, outlinewidth, antialias);
		blurpaint = new Blur(blur, blurwidth, blurradius);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a polygon
	 */
	public DrawablePolygon(DrawablePolygon poly)
	{
		super(poly.Position, poly.vertices, poly.Velocity, poly.Mass);
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
	 * Draw this polygon
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
