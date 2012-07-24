package sky.engine.graphics.paints;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class ShapePaint
{
	/**
	 * Default outline width
	 */
	public static final float DEFAULT_OUTLINE_WIDTH = 2.0f;
	
	
	/**
	 * Default blur width
	 */
	public static final float DEFAULT_BLUR_WIDTH = 15.0f;
	
	
	/**
	 * Default blur radius
	 */
	public static final float DEFAULT_BLUR_RADIUS = 15.0f;
	
	
	/**
	 * Fill paint
	 */
	public Paint FillPaint = new Paint();
	
	
	/**
	 * Outline paint
	 */
	public Paint OutlinePaint = new Paint();
	
	
	/**
	 * Blur paint
	 */
	public Paint BlurPaint = new Paint();
	
	
	/**
	 * Does this Paint have an outline?
	 */
	public boolean ShowOutline = false;
	
	
	/**
	 * Does this Paint have a blur?
	 */
	public boolean ShowBlur = false;
	
	
	/**
	 * Is this Graphical Paint being anti-aliased?
	 */
	protected boolean AntiAliasing = false;
	
	
	
	
	
	
	


	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public ShapePaint(int fillcolour, boolean antialias)
	{
		this.initialise(fillcolour, 0, 0, false, false, 0, 0, 1, antialias);
	}

	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public ShapePaint(int fillcolour, int outlinecolour, boolean antialias)
	{
		this.initialise(fillcolour, outlinecolour, 0, true, false, DEFAULT_OUTLINE_WIDTH, 0, 1, antialias);
	}

	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public ShapePaint(int fillcolour, int outlinecolour, int blurcolour, boolean antialias)
	{
		this.initialise(fillcolour, outlinecolour, blurcolour, true, true, DEFAULT_OUTLINE_WIDTH, DEFAULT_BLUR_WIDTH, DEFAULT_BLUR_RADIUS, antialias);
	}

	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public ShapePaint(int fillcolour, int outlinecolour, float outlinewidth, boolean antialias)
	{
		this.initialise(fillcolour, outlinecolour, 0, true, false, outlinewidth, 0, 1, antialias);
	}

	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public ShapePaint(int fillcolour, int outlinecolour, int blurcolour, float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		this.initialise(fillcolour, outlinecolour, blurcolour, true, true, outlinewidth, blurwidth, blurradius, antialias);
	}
	
	
	/**
	 * Create new instance of a Graphical Paint
	 */
	public ShapePaint(ShapePaint gpaint)
	{
		FillPaint.set(gpaint.FillPaint);
		OutlinePaint.set(gpaint.OutlinePaint);
		BlurPaint.set(gpaint.BlurPaint);
		
		this.setAntiAliasing(gpaint.AntiAliasing);
		this.ShowOutline = gpaint.ShowOutline;
		this.ShowBlur = gpaint.ShowBlur;
	}
	
	
	
	
	
	

	
	
	/**
	 * Initialise the paint
	 */
	private void initialise(int fillcolour, int outlinecolour, int blurcolour, boolean showoutline, boolean showblur,
			float outlinewidth, float blurwidth, float blurradius, boolean antialias)
	{
		//fill
		FillPaint.setStyle(Paint.Style.FILL);
		FillPaint.setColor(fillcolour);
		
		//outline
		OutlinePaint.setStyle(Paint.Style.STROKE);
		OutlinePaint.setColor(outlinecolour);
		OutlinePaint.setStrokeWidth(outlinewidth);
		ShowOutline = showoutline;
		
		//blur
		BlurPaint.setColor(blurcolour);
		BlurPaint.setStrokeWidth(blurwidth);
		BlurPaint.setMaskFilter(new BlurMaskFilter(blurradius, BlurMaskFilter.Blur.OUTER));
		ShowBlur = showblur;
		
		//anti-aliasing
		this.setAntiAliasing(antialias);
	}

	
	
	
	
	
	
	/**
	 * Set the radius of the blur
	 */
	public void setBlurRadius(float radius)
	{
		BlurPaint.setMaskFilter(new BlurMaskFilter(radius, BlurMaskFilter.Blur.NORMAL));
	}
	
	
	

	
	
	/**
	 * Set the stroke width of the blur
	 */
	public void setBlurWidth(float width)
	{
		BlurPaint.setStrokeWidth(width);
	}
	
	
	/**
	 * Returns the stroke width of the blur
	 */
	public float getBlurWidth()
	{
		return BlurPaint.getStrokeWidth();
	}
	
	
	
	
	
	
	
	
	/**
	 * Set width of outline
	 */
	public void setOutlineWidth(float width)
	{
		OutlinePaint.setStrokeWidth(width);
	}
	
	
	/**
	 * Returns the outline width
	 */
	public float getOutlineWidth()
	{
		return OutlinePaint.getStrokeWidth();
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
	 * Set fill colour of the Paint
	 */
	public void setFillColour(int colour)
	{
		FillPaint.setColor(colour);
	}
	
	
	/**
	 * Returns fill colour of the Paint
	 */
	public int getFillColour()
	{
		return FillPaint.getColor();
	}
	
	
	
	
	
	
	/**
	 * Set outline colour of the Paint
	 */
	public void setOutlineColour(int colour)
	{
		OutlinePaint.setColor(colour);
	}
	
	
	/**
	 * Returns outline colour of the Paint
	 */
	public int getOutlineColour()
	{
		return OutlinePaint.getColor();
	}
	
	
	
	
	
	
	/**
	 * Set Blur colour of the Paint
	 */
	public void setBlurColour(int colour)
	{
		BlurPaint.setColor(colour);
	}
	
	
	/**
	 * Returns Blur colour of the Paint
	 */
	public int getBlurColour()
	{
		return BlurPaint.getColor();
	}
	
	
	
	
	
	
	/**
	 * Set colour of the Paint
	 */
	public void setColour(int fillColour, int outlineColour, int blurcolour)
	{
		FillPaint.setColor(outlineColour);
		OutlinePaint.setColor(fillColour);
		BlurPaint.setColor(blurcolour);
	}
	
	
	
	
	
	
	
	/**
	 * Set the fill alpha value
	 */
	public void setFillAlpha(int alpha)
	{
		FillPaint.setAlpha(alpha);
	}
	
	
	/**
	 * Returns the fill alpha value
	 */
	public int getFillAlpha()
	{
		return FillPaint.getAlpha();
	}
	
	
	
	
	
	
	
	/**
	 * Set the outline alpha value
	 */
	public void setOutlineAlpha(int alpha)
	{
		OutlinePaint.setAlpha(alpha);
	}
	
	
	/**
	 * Returns the outline alpha value
	 */
	public int getOutlineAlpha()
	{
		return OutlinePaint.getAlpha();
	}
	
	
	
	
	
	
	
	/**
	 * Set the Blur alpha value
	 */
	public void setBlurAlpha(int alpha)
	{
		BlurPaint.setAlpha(alpha);
	}
	
	
	/**
	 * Returns the Blur alpha value
	 */
	public int getBlurAlpha()
	{
		return BlurPaint.getAlpha();
	}
	
	
	
	
	
	
	
	/**
	 * Set the alpha value
	 */
	public void setAlpha(int fillalpha, int outlinealpha, int bluralpha)
	{
		FillPaint.setAlpha(fillalpha);
		OutlinePaint.setAlpha(outlinealpha);
		BlurPaint.setAlpha(bluralpha);
	}

	
	
	

}
