package sky.engine.graphics.drawable;

import sky.engine.graphics.Colour;
import android.graphics.Canvas;
import android.graphics.Paint;

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
	
	
	
	
	
	
	/**
	 * Draws basic text
	 */
	public static void drawText(Canvas canvas, String text, float x, float y)
	{
		paint.setColor(Colour.BLACK);
		paint.setTextSize(22);
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draws basic text
	 */
	public static void drawText(Canvas canvas, String text, float x, float y, Paint paint)
	{
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draws basic text
	 */
	public static void drawText(Canvas canvas, String text, float x, float y, int colour, int textsize)
	{
		paint.setColor(colour);
		paint.setTextSize(textsize);
		canvas.drawText(text, x, y, paint);
	}
	
	
	
	
	
	
	
	/**
	 * Draws text with a shadow
	 */
	public static void drawShadowText(Canvas canvas, String text, float x, float y)
	{
		paint.setColor(Colour.BLACK);
		paint.setTextSize(22);
		paint.setShadowLayer(2, 0, 0, Colour.GRAY);
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draws text with a shadow
	 */
	public static void drawShadowText(Canvas canvas, String text, float x, float y, Paint paint)
	{
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draws text with a shadow
	 */
	public static void drawShadowText(Canvas canvas, String text, float x, float y, int colour, int textsize, int scolour, float radius, float offsetx, float offsety)
	{
		paint.setColor(colour);
		paint.setTextSize(textsize);
		paint.setShadowLayer(radius, offsetx, offsety, scolour);
		canvas.drawText(text, x, y, paint);
	}

}
