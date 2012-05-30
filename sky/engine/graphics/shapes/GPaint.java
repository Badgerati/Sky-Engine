package sky.engine.graphics.shapes;

import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GPaint
{
	/**
	 * Default outline width
	 */
	public static final float DEFAULT_OUTLINE_WIDTH = 1.0f;
	
	
	/**
	 * Fill paint of the Graphical Paint
	 */
	public Paint FillPaint = new Paint();
	
	
	/**
	 * Outline paint of the Graphical Paint
	 */
	public Paint OutlinePaint = new Paint();
	
	
	/**
	 * Width of the outline
	 */
	private float OutlineWidth;
	
	
	/**
	 * Does this Graphical Paint have an outline?
	 */
	public boolean Outline = false;
	
	
	/**
	 * Is this Graphical Paint being anti-aliased?
	 */
	private boolean AntiAliasing;
	
	
	
	
	
	
	
	

	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public GPaint(int fillcolour, int outlinecolour, boolean showoutline, float outlinewidth, boolean antialias)
	{
		//fill
		FillPaint.setStyle(Paint.Style.FILL);
		FillPaint.setColor(fillcolour);
		
		//outline
		OutlinePaint.setStyle(Paint.Style.STROKE);
		OutlinePaint.setColor(outlinecolour);
		OutlineWidth = outlinewidth;
		OutlinePaint.setStrokeWidth(OutlineWidth);
		Outline = showoutline;
		
		//anti-aliasing
		AntiAliasing = antialias;
	}
	
	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public GPaint(GPaint gpaint)
	{
		//fill
		FillPaint.setStyle(gpaint.FillPaint.getStyle());
		FillPaint.setColor(gpaint.FillPaint.getColor());
		
		//outline
		OutlinePaint.setStyle(gpaint.OutlinePaint.getStyle());
		OutlinePaint.setColor(gpaint.OutlinePaint.getColor());
		OutlineWidth = gpaint.OutlineWidth;
		OutlinePaint.setStrokeWidth(OutlineWidth);
		Outline = gpaint.Outline;
		
		//anti-aliasing
		AntiAliasing = gpaint.AntiAliasing;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set width of outline
	 */
	public void setOutlineWidth(float width)
	{
		OutlineWidth = width;
		OutlinePaint.setStrokeWidth(width);
	}
	
	
	/**
	 * Returns the outline width
	 */
	public float getOutlineWidth()
	{
		return OutlineWidth;
	}
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * Set the Graphical Paint to be anti-aliased
	 */
	public void setAntiAliasing(boolean flag)
	{
		AntiAliasing = flag;
		FillPaint.setAntiAlias(flag);
		OutlinePaint.setAntiAlias(flag);
	}
	
	
	/**
	 * Is the Graphical Paint being anti-aliased?
	 */
	public boolean isAntiAliasing()
	{
		return AntiAliasing;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set fill colour of the Graphical Paint
	 */
	public void setFillColour(int colour)
	{
		FillPaint.setColor(colour);
	}
	
	
	/**
	 * Set outline colour of the Graphical Paint
	 */
	public void setOutlineColour(int colour)
	{
		OutlinePaint.setColor(colour);
		
	}
	
	
	/**
	 * Set colour of the Graphical Paint
	 */
	public void setColour(int fillColour, int outlineColour)
	{
		FillPaint.setColor(outlineColour);
		OutlinePaint.setColor(fillColour);
	}
	
	
	
	/**
	 * Returns fill colour of the Graphical Paint
	 */
	public int getFillColour()
	{
		return FillPaint.getColor();
	}
	
	
	/**
	 * Returns outline colour of the Graphical Paint
	 */
	public int getOutlineColour()
	{
		return OutlinePaint.getColor();
	}
	
	
	
	
	
	
	

	
	
	
	/**
	 * Set the fill alpha value
	 */
	public void setFillAlpha(int alpha)
	{
		FillPaint.setAlpha(alpha);
	}
	
	
	/**
	 * Set the outline alpha value
	 */
	public void setOutlineAlpha(int alpha)
	{
		OutlinePaint.setAlpha(alpha);
	}
	
	
	/**
	 * Set the alpha value
	 */
	public void setAlpha(int fillalpha, int outlinealpha)
	{
		FillPaint.setAlpha(fillalpha);
		OutlinePaint.setAlpha(outlinealpha);
	}

	
	
	/**
	 * Returns the fill alpha value
	 */
	public int getFillAlpha()
	{
		return FillPaint.getAlpha();
	}
	
	
	/**
	 * Returns the outline alpha value
	 */
	public int getOutlineAlpha()
	{
		return OutlinePaint.getAlpha();
	}
	
	
	

}
