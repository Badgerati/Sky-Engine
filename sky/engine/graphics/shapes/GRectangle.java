package sky.engine.graphics.shapes;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Rectangle;
import sky.engine.graphics.Colour;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GRectangle extends Rectangle
{
	/**
	 * Graphical Paint to paint this Graphical Rectangle
	 */
	public GPaint Paint = null;
	
	
	
	
	


	
	

	
	/**
	 * Create new instance of a default Graphical Rectangle
	 */
	public GRectangle(Vector2D position, float width, float height, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(Vector2D position, float width, float height, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(Vector2D position, float width, float height, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, width, height, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}

	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Rectangle
	 */
	public GRectangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, v4, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}

	
	

	
	
	
	/**
	 * Create new instance of a default Graphical Rectangle
	 */
	public GRectangle(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D v4, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, v4, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Rectangle
	 */
	public GRectangle(GRectangle grect)
	{
		super(grect.Position, grect.vertices[0], grect.vertices[1], grect.vertices[2], grect.vertices[3], grect.Velocity, grect.Mass);
		Paint = new GPaint(grect.Paint);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this Graphical Rectangle via the vertices
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
	 * Clone this Graphical Rectangle
	 */
	public GRectangle clone()
	{
		return new GRectangle(this);
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Rectangle
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.Outline)
			canvas.drawPath(polygon, Paint.OutlinePaint);
		
		canvas.drawPath(polygon, Paint.FillPaint);
	}
	
	
	
	
}
