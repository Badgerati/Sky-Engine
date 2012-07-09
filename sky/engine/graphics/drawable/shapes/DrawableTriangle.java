package sky.engine.graphics.drawable.shapes;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import sky.engine.geometry.shapes.Triangle;
import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DrawableTriangle extends Triangle implements DrawableShape
{
	/**
	 * Graphical Paint to paint this Graphical Triangle
	 */
	public ShapePaint Paint = null;
	
	
	
	



	

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3)
	{
		super(position, v1, v2, v3);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline)
	{
		super(position, v1, v2, v3);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, v1, v2, v3, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}


	
	
	

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public DrawableTriangle(Vector2D v1, Vector2D v2, Vector2D v3)
	{
		super(v1, v2, v3);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public DrawableTriangle(Vector2D v1, Vector2D v2, Vector2D v3, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline)
	{
		super(v1, v2, v3);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D v1, Vector2D v2, Vector2D v3, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(v1, v2, v3, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}


	
	
	


	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, float sidex, float sidey, float sidez)
	{
		super(position, sidex, sidey, sidez);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}

	
	/**
	 * Create new instance of a default Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, float sidex, float sidey, float sidez, Vector2D velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		Paint = new ShapePaint(Colour.TRANSPARENT, Colour.WHITE, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, float sidex, float sidey, float sidez, int fill, int outline)
	{
		super(position, sidex, sidey, sidez);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, float sidex, float sidey, float sidez, int fill, int outline, Vector2D velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, ShapePaint.DEFAULT_OUTLINE_WIDTH, true);
		initialise();
	}
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(Vector2D position, float sidex, float sidey, float sidez, int fill, int outline, float outlinewidth, boolean antialias, Vector2D velocity, float mass)
	{
		super(position, sidex, sidey, sidez, velocity, mass);
		Paint = new ShapePaint(fill, outline, true, outlinewidth, antialias);
		initialise();
	}
	
	
	
	
	

	
	
	
	/**
	 * Create new instance of a Graphical Triangle
	 */
	public DrawableTriangle(DrawableTriangle gtri)
	{
		super(gtri.Position, gtri.vertices[0], gtri.vertices[1], gtri.vertices[2], gtri.Velocity, gtri.Mass);
		Paint = new ShapePaint(gtri.Paint);
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
	public DrawableTriangle clone()
	{
		return new DrawableTriangle(this);
	}
	

	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Graphical Triangle
	 */
	public void draw(Canvas canvas)
	{
		if (Paint.ShowOutline)
			canvas.drawPath(polygon, Paint.OutlinePaint);
		
		canvas.drawPath(polygon, Paint.FillPaint);
	}
	
	
	
	
	
	
	
	
	

}
