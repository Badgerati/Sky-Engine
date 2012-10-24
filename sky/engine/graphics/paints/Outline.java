package sky.engine.graphics.paints;

import sky.engine.graphics.Colour;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Outline extends Paint
{

	/**
	 * Default outline width
	 */
	public static final float DEFAULT_OUTLINE_WIDTH = 5.0f;
	
	
	
	
	

	
	
	/**
	 * Create a new instance of an OutlinePaint
	 */
	public Outline()
	{
		initialise(Colour.WHITE, DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create a new instance of an OutlinePaint
	 */
	public Outline(int colour)
	{
		initialise(colour, DEFAULT_OUTLINE_WIDTH, true);
	}
	
	
	/**
	 * Create a new instance of an OutlinePaint
	 */
	public Outline(int colour, float width)
	{
		initialise(colour, width, true);
	}
	
	
	/**
	 * Create a new instance of an OutlinePaint
	 */
	public Outline(int colour, boolean antialias)
	{
		initialise(colour, DEFAULT_OUTLINE_WIDTH, antialias);
	}
	
	
	/**
	 * Create a new instance of an OutlinePaint
	 */
	public Outline(int colour, float width, boolean antialias)
	{
		initialise(colour, width, antialias);
	}
	
	
	/**
	 * Create a new instance of an OutlinePaint
	 */
	public Outline(Outline paint)
	{
		initialise(paint.getColor(), paint.getStrokeWidth(), paint.isAntiAlias());
	}
	
	
	
	
	
	
	/**
	 * Sets the outline
	 */
	public void set(Outline paint)
	{
		if (paint == null) return;
		
		initialise(paint.getColor(), paint.getStrokeWidth(), paint.isAntiAlias());
	}
	
	
	
	
	
	
	
	
	/**
	 * Initialise the outline paint
	 */
	private void initialise(int colour, float width, boolean antialias)
	{
		this.setStyle(Paint.Style.STROKE);
		this.setStrokeJoin(Paint.Join.ROUND);
		this.setStrokeCap(Paint.Cap.ROUND);
		
		this.setColor(colour);
		this.setStrokeWidth(width);
		this.setAntiAlias(antialias);
	}
	
	
	
	
	
	
}
