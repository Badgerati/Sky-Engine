package sky.engine.graphics.shapes;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import sky.engine.geometry.Vector2D;
import sky.engine.geometry.shapes.Triangle;
import sky.engine.graphics.Colour;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GTriangle extends Triangle
{
	/**
	 * Graphical Paint to paint this Graphical Triangle
	 */
	public GPaint Paint = null;
	
	
	
	



	
	

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public GTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}


	
	
	

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public GTriangle(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}


	
	
	
	

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public GTriangle(Vector2D position, float sidex, float sidey, float sidez, Vector2D velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		Paint = new GPaint(Colour.TRANSPARENT, Colour.WHITE, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(Vector2D position, float sidex, float sidey, float sidez, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		Paint = new GPaint(fill, outline, true, GPaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(Vector2D position, float sidex, float sidey, float sidez, int fill, int outline, boolean showoutline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		Paint = new GPaint(fill, outline, showoutline, outlinewidth, antialias);
		initialise();
	}
	
	
	
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public GTriangle(GTriangle gtri)
	{
		super(gtri.Position, gtri.vertices[0], gtri.vertices[1], gtri.vertices[2], gtri.Velocity, gtri.Mass);
		Paint = new GPaint(gtri.Paint);
		initialise();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the path of this Graphical Triangle via the vertices
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
	 * Clone this Graphical Triangle
	 */
	public GTriangle clone()
	{
		return new GTriangle(this);
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Triangle
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.Outline)
			canvas.drawPath(polygon, Paint.OutlinePaint);
		
		canvas.drawPath(polygon, Paint.FillPaint);
	}
	
	
	
	
	
	
	
	
	

}
