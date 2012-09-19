package sky.engine.text;

import sky.engine.geometry.vectors.Vector2;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
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
	 * Should the text be centred?
	 */
	public boolean centreText = true;
	
	
	/**
	 * Paint object to use
	 */
	public Paint textpaint = null;
	
	
	
	

	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2 position, int colour, float size)
	{
		textpaint = new Paint();
		textpaint.setColor(colour);
		textpaint.setTextSize(size);
		Position = position.clone();
		this.text = text;
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2 position, Paint paint)
	{
		this.textpaint = new Paint(paint);
		Position = position.clone();
		this.text = text;
	}
	
	
	
	
	
	
	/**
	 * Set the text size
	 */
	public void setTextSize(int textsize)
	{
		textpaint.setTextSize(textsize);
	}
	
	
	
	
	
	/**
	 * Set colour of the text
	 */
	public void setColour(int colour)
	{
		textpaint.setColor(colour);
	}
	
	
	
	
	/**
	 * Set alpha of the text
	 */
	public void setAlpha(int alpha)
	{
		textpaint.setAlpha(alpha);
	}
	
	
	
	
	
	
	/**
	 * Set a shadow for the text
	 */
	public void setShadow(float radius, float offsetx, float offsety, int colour)
	{
		textpaint.setShadowLayer(radius, offsetx, offsety, colour);
	}
	
	
	
	

	
	
	/**
	 * Draw the text
	 */
	public void draw(Canvas canvas)
	{
		Paint.FontMetrics fm = textpaint.getFontMetrics();
		float height = (fm.bottom - fm.top);
		float x_offset = Position.X;
		float y_offset = Position.Y;
		
		String[] lines = null;
		if (text.contains("\n"))
			lines = text.split("\n");
		else
			lines = text.split("##");
		
		if (centreText)
		{
			y_offset = y_offset - (height * (lines.length - 1) * 0.5f);// * 0.68f);
		}
		
		for (String line : lines)
		{
			if (centreText)
			{
				x_offset = Position.X - (textpaint.measureText(line) * 0.5f);
				y_offset += (height * 0.26f);// 0.36f);
			}
			
			canvas.drawText(line, x_offset, y_offset, textpaint);
			y_offset = y_offset + (height * 0.8f);
		}
	}
	
	
	
	
}
