package sky.engine.graphics.shapes;

import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Polygon;
import sky.engine.graphics.Colour;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GPolygon extends Polygon
{
	/**
	 * Graphical Paint to paint this Graphical Polygon
	 */
	public GPaint Paint = null;
	
	
	
	
	
	

	
	

	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public GPolygon(Vector2D position, Vector2D[] vertices, Vector2D velocity, float mass)
	{
		super(position, vertices, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D position, Vector2D[] vertices, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, vertices, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D position, Vector2D[] vertices, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, vertices, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public GPolygon(Vector2D[] vertices, Vector2D velocity, float mass)
	{
		super(vertices, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D[] vertices, int fill, int outline, Vector2D velocity, float mass)
	{
		super(vertices, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D[] vertices, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(vertices, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public GPolygon(Vector2D position, int noOfVertices, float size, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D position, int noOfVertices, float size, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D position, int noOfVertices, float size, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public GPolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public GPolygon(GPolygon gpoly)
	{
		super(gpoly.Position, gpoly.vertices, gpoly.Velocity, gpoly.Mass);
		Paint = new GPaint(gpoly.Paint);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this Graphical Polygon via the vertices
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
	 * Clone this Graphical Polygon
	 */
	public GPolygon clone()
	{
		return new GPolygon(this);
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Polygon
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.Outline)
			canvas.drawPath(polygon, Paint.OutlinePaint);
		
		canvas.drawPath(polygon, Paint.FillPaint);
	}
	
	
	
	
	
	
	
}
