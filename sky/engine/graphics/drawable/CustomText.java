package sky.engine.graphics.drawable;

import sky.engine.geometry.vectors.Vector2;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class CustomText
{
	/**
	 * Text to display
	 */
	public String text = "";
	
	
	/**
	 * Position of the text
	 */
	public Vector2 Position = null;
	
	
	/**
	 * Paint object to use
	 */
	protected Paint paint = null;
	
	
	
	

	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(int colour, int textsize)
	{
		paint = new Paint();
		paint.setColor(colour);
		paint.setTextSize(textsize);
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2 position, int colour, int textsize)
	{
		paint = new Paint();
		paint.setColor(colour);
		paint.setTextSize(textsize);
		Position = position.clone();
		this.text = text;
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(Paint paint)
	{
		this.paint = new Paint(paint);
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2 position, Paint paint)
	{
		this.paint = new Paint(paint);
		Position = position.clone();
		this.text = text;
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(int colour, int textsize, float radius, float offsetx, float offsety, int scolour)
	{
		paint = new Paint();
		paint.setColor(colour);
		paint.setTextSize(textsize);
		paint.setShadowLayer(radius, offsetx, offsety, scolour);
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2 position, int colour, int textsize, int scolour, float radius, float offsetx, float offsety)
	{
		paint = new Paint();
		paint.setColor(colour);
		paint.setTextSize(textsize);
		paint.setShadowLayer(radius, offsetx, offsety, scolour);
		Position = position.clone();
		this.text = text;
	}
	
	
	
	
	
	
	
	/**
	 * Set the text size
	 */
	public void setTextSize(int textsize)
	{
		paint.setTextSize(textsize);
	}
	
	
	
	
	
	
	/**
	 * Set colour of the text
	 */
	public void setColour(int colour)
	{
		paint.setColor(colour);
	}
	
	
	
	
	
	
	
	/**
	 * Set a shadow for the text
	 */
	public void setShadow(int colour, float radius, float offsetx, float offsety)
	{
		paint.setShadowLayer(radius, offsetx, offsety, colour);
	}
	
	
	
	

	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas)
	{
		canvas.drawText(text, Position.X, Position.Y, paint);
	}
	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas, Vector2 position)
	{
		canvas.drawText(text, position.X, position.Y, paint);
	}
	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas, float x, float y)
	{
		canvas.drawText(text, x, y, paint);
	}
	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas, String text)
	{
		canvas.drawText(text, Position.X, Position.Y, paint);
	}
	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas, String text, Vector2 position)
	{
		canvas.drawText(text, position.X, position.Y, paint);
	}
	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas, String text, float x, float y)
	{
		canvas.drawText(text, x, y, paint);
	}
	
	
	
	
}
