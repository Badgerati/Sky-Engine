package sky.engine.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public abstract class Text
{
	/**
	 * Basic paint object to paint text with, when paint is not supplied
	 */
	protected static Paint paint = new Paint();
	protected static Paint spaint = new Paint();
	protected static Paint opaint = new Paint();
	protected static Paint ospaint = new Paint();
	
	
	
	
	
	
	/**
	 * Set the font
	 */
	public static void setFont(Typeface font)
	{
		paint.setTypeface(font);
		spaint.setTypeface(font);
		opaint.setTypeface(font);
		ospaint.setTypeface(font);
	}
	
	
	
	
	
	/**
	 * Set textsize
	 */
	public static void setTextSize(float size)
	{
		paint.setTextSize(size);
		spaint.setTextSize(size);
		opaint.setTextSize(size);
		ospaint.setTextSize(size);
	}
	
	
	
	
	
	
	/**
	 * Set colour
	 */
	public static void setColour(int colour)
	{
		paint.setColor(colour);
		spaint.setColor(colour);
		opaint.setColor(colour);
		ospaint.setColor(colour);
	}
	
	
	
	
	/**
	 * Set antialiasing
	 */
	public static void setAntiAlias(boolean flag)
	{
		paint.setAntiAlias(flag);
		spaint.setAntiAlias(flag);
		opaint.setAntiAlias(flag);
		ospaint.setAntiAlias(flag);
	}
	
	
	
	
	
	/**
	 * Set shadow
	 */
	public static void setShadow(float radius, float offsetx, float offsety, int colour)
	{
		spaint.setShadowLayer(radius, offsetx, offsety, colour);
		ospaint.setShadowLayer(radius, offsetx, offsety, colour);
	}
	
	
	
	
	
	
	
	/**
	 * Draws basic text
	 */
	public static void drawText(Canvas canvas, String text, float x, float y, boolean centre)
	{
		if (centre) {
			x = x - (paint.measureText(text) * 0.5f);
			Paint.FontMetrics fm = paint.getFontMetrics();
			y = y + ((fm.bottom - fm.top) * 0.36f);
		}
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draws basic text
	 */
	public static void drawText(Canvas canvas, String text, float x, float y, Paint paint, boolean centre)
	{
		if (centre) {
			x = x - (paint.measureText(text) * 0.5f);
			Paint.FontMetrics fm = paint.getFontMetrics();
			y = y + ((fm.bottom - fm.top) * 0.36f);
		}
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draws basic text
	 */
	public static void drawText(Canvas canvas, String text, float x, float y, int colour, float textsize, boolean centre)
	{
		opaint.setColor(colour);
		opaint.setTextSize(textsize);
		Paint.FontMetrics fm = opaint.getFontMetrics();
		
		float ox = x;
		
		String[] lines = text.split("\n");

		for (String line : lines)
		{
			if (centre)
			{
				ox = x - (opaint.measureText(line) * 0.5f);
				y = y + ((fm.bottom - fm.top) * 0.36f);
			}
			canvas.drawText(line, ox, y, opaint);
			y = y + textsize;
		}
	}
	
	
	
	
	
	/**
	 * Draws text with a shadow
	 */
	public static void drawShadowText(Canvas canvas, String text, float x, float y, boolean centre)
	{
		if (centre) {
			x = x - (spaint.measureText(text) * 0.5f);
			Paint.FontMetrics fm = spaint.getFontMetrics();
			y = y + ((fm.bottom - fm.top) * 0.36f);
		}
		canvas.drawText(text, x, y, spaint);
	}
	
	
	/**
	 * Draws text with a shadow
	 */
	public static void drawShadowText(Canvas canvas, String text, float x, float y, int colour, float textsize, boolean centre)
	{
		ospaint.setColor(colour);
		ospaint.setTextSize(textsize);

		if (centre) {
			x = x - (ospaint.measureText(text) * 0.5f);
			Paint.FontMetrics fm = ospaint.getFontMetrics();
			y = y + ((fm.bottom - fm.top) * 0.36f);
		}
		canvas.drawText(text, x, y, ospaint);
	}

}
