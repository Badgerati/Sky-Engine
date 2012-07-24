package sky.engine.graphics.paints;

import sky.engine.graphics.Colour;
import android.graphics.BlurMaskFilter;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Blur extends Paint
{
	
	/**
	 * Default blur width
	 */
	public static final float DEFAULT_BLUR_WIDTH = 0.0f;
	
	
	/**
	 * Default blur radius
	 */
	public static final float DEFAULT_BLUR_RADIUS = 12.0f;
	
	
	/**
	 * Default blur style
	 */
	public static final BlurMaskFilter.Blur DEFAULT_BLUR_STYLE = BlurMaskFilter.Blur.OUTER;
	
	
	/**
	 * Current radius of the blur
	 */
	protected float blurRadius = DEFAULT_BLUR_RADIUS;
	
	
	/**
	 * Current blur style
	 */
	protected BlurMaskFilter.Blur blurStyle = BlurMaskFilter.Blur.OUTER;
	
	
	
	
	
	
	
	

	
	/**
	 * Create new instance of a BlurPaint
	 */
	public Blur()
	{
		initialise(Colour.WHITE, DEFAULT_BLUR_WIDTH, DEFAULT_BLUR_RADIUS, DEFAULT_BLUR_STYLE);
	}
	
	
	/**
	 * Create new instance of a BlurPaint
	 */
	public Blur(int colour)
	{
		initialise(colour, DEFAULT_BLUR_WIDTH, DEFAULT_BLUR_RADIUS, DEFAULT_BLUR_STYLE);
	}
	
	
	/**
	 * Create new instance of a BlurPaint
	 */
	public Blur(int colour, float width, float radius)
	{
		initialise(colour, width, radius, DEFAULT_BLUR_STYLE);
	}
	
	
	/**
	 * Create new instance of a BlurPaint
	 */
	public Blur(int colour, float width, float radius, BlurMaskFilter.Blur style)
	{
		initialise(colour, width, radius, style);
	}
	
	
	/**
	 * Create new instance of a BlurPaint
	 */
	public Blur(Blur paint)
	{
		initialise(paint.getColor(), paint.getStrokeWidth(), paint.getBlurRadius(), paint.getBlurStyle());
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialise the blur paint
	 */
	private void initialise(int colour, float width, float radius, BlurMaskFilter.Blur style)
	{
		this.setColor(colour);
		this.setStrokeWidth(width);
		this.setMaskFilter(new BlurMaskFilter(radius, style));
		
		this.setStyle(Paint.Style.STROKE);
		this.setStrokeJoin(Paint.Join.ROUND);
		this.setStrokeCap(Paint.Cap.ROUND);
		
		blurRadius = radius;
		blurStyle = style;
	}
	

	
	
	

	
	
	/**
	 * Set the radius of the blur
	 */
	public void setBlurRadius(float radius)
	{
		this.setMaskFilter(new BlurMaskFilter(radius, blurStyle));
		blurRadius = radius;
	}
	
	
	/**
	 * Returns the radius of the blur
	 */
	public float getBlurRadius()
	{
		return blurRadius;
	}
	

	
	
	

	
	
	/**
	 * Set the style of the blur
	 */
	public void setBlurStyle(BlurMaskFilter.Blur style)
	{
		this.setMaskFilter(new BlurMaskFilter(blurRadius, style));
		blurStyle = style;
	}
	
	
	/**
	 * Returns the style of the blur
	 */
	public BlurMaskFilter.Blur getBlurStyle()
	{
		return blurStyle;
	}
	
	
	
}
