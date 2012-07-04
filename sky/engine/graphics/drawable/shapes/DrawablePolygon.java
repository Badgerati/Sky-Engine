package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.shapes.Polygon;
import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;
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
	 * Graphical Paint to paint this Graphical Polygon
	 */
	public ShapePaint Paint = null;
	
	
	
	
	
	

	


	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, Vector2D[] vertices)
	{
		super(position, vertices);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}

	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, Vector2D[] vertices, Vector2D velocity, float mass)
	{
		super(position, vertices, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, Vector2D[] vertices, int fill, int outline)
	{
		super(position, vertices);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, Vector2D[] vertices, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, vertices, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, Vector2D[] vertices, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, vertices, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	


	
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public DrawablePolygon(Vector2D[] vertices)
	{
		super(vertices);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public DrawablePolygon(Vector2D[] vertices, Vector2D velocity, float mass)
	{
		super(vertices, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D[] vertices, int fill, int outline)
	{
		super(vertices);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D[] vertices, int fill, int outline, Vector2D velocity, float mass)
	{
		super(vertices, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D[] vertices, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(vertices, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float size, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float size, int fill, int outline)
	{
		super(position, noOfVertices, size);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float size, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float size, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, size, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, int fill, int outline)
	{
		super(position, noOfVertices, minSize, maxSize);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(Vector2D position, int noOfVertices, float minSize, float maxSize, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, noOfVertices, minSize, maxSize, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Polygon
	 */
	public DrawablePolygon(DrawablePolygon gpoly)
	{
		super(gpoly.Position, gpoly.vertices, gpoly.Velocity, gpoly.Mass);
		Paint = new ShapePaint(gpoly.Paint);
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
	public DrawablePolygon clone()
	{
		return new DrawablePolygon(this);
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Polygon
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawPath(polygon, Paint.OutlinePaint);
		
		canvas.drawPath(polygon, Paint.FillPaint);
	}
	
	
	
	
	
	
	
}
