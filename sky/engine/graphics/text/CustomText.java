package sky.engine.graphics.text;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.DrawableComponent;
import sky.engine.util.primitives.SEString;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class CustomText extends DrawableComponent
{
	/**
	 * Text to display
	 */
	public String Text = "";
	
	
	/**
	 * Position of the text
	 */
	public Vector2d Position = null;
	
	
	/**
	 * Should the text be centred?
	 */
	public boolean CentreText = true;
	
	
	/**
	 * Paint object to use
	 */
	protected Paint textpaint = null;
	
	
	
	

	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2d position, int colour, float size)
	{
		textpaint = new Paint();
		textpaint.setColor(colour);
		textpaint.setTextSize(size);
		textpaint.setAntiAlias(true);
		Position = position.clone();
		this.Text = text;
	}
	
	
	/**
	 * Create new instance of some Custom Text
	 */
	public CustomText(String text, Vector2d position, Paint paint)
	{
		this.textpaint = new Paint(paint);
		Position = position.clone();
		this.Text = text;
	}
	
	
	
	
	
	/**
	 * Set Text's position
	 */
	@Override
	public void setPosition(Vector2d position)
	{
		Position.X = position.X;
		Position.Y = position.Y;
	}
	
	
	
	
	
	/**
	 * Get Text's position
	 */
	@Override
	public Vector2d getPosition()
	{
		return Position;
	}
	
	
	
	
	
	/**
	 * Set the anti-aliasing
	 */
	public void setAntiAlias(boolean flag)
	{
		textpaint.setAntiAlias(flag);
	}
	
	
	
	
	
	
	/**
	 * Set the text size
	 */
	public void setTextSize(float textsize)
	{
		textpaint.setTextSize(textsize);
	}
	
	
	
	
	
	
	/**
	 * Returns the text size
	 */
	public float getTextSize()
	{
		return textpaint.getTextSize();
	}
	
	
	
	
	
	/**
	 * Set the font to use
	 */
	public void setFont(Typeface font)
	{
		textpaint.setTypeface(font);
	}
	
	
	
	
	
	/**
	 * Returns the font used
	 */
	public Typeface getFont()
	{
		return textpaint.getTypeface();
	}
	
	
	
	
	
	/**
	 * Set colour of the text
	 */
	public void setColour(int colour)
	{
		textpaint.setColor(colour);
	}
	
	
	
	
	
	/**
	 * Returns the colour of the text
	 */
	public int getColour()
	{
		return textpaint.getColor();
	}
	
	
	
	
	/**
	 * Set alpha of the text
	 */
	public void setAlpha(int alpha)
	{
		textpaint.setAlpha(alpha);
	}
	
	
	
	
	/**
	 * Returns the alpha of the text
	 */
	public int getAlpha()
	{
		return textpaint.getAlpha();
	}
	
	
	
	
	
	
	/**
	 * Set a shadow for the text
	 */
	public void setShadow(float radius, float offsetx, float offsety, int colour)
	{
		textpaint.setShadowLayer(radius, offsetx, offsety, colour);
	}
	
	
	
	
	
	/**
	 * Returns height of the text
	 */
	public float getHeight()
	{
		return SEString.getHeight(textpaint);
	}
	
	
	
	
	
	/**
	 * Returns the true height of the text, including newlines with optional
	 * separation distance
	 */
	public float getHeight(float sep_dist)
	{
		return SEString.getHeight(Text, textpaint, sep_dist);
	}
	
	
	
	
	
	
	/**
	 * Returns the width of the text
	 */
	public float getWidth()
	{
		return SEString.getWidth(Text, textpaint);
	}
	
	
	
	
	
	/**
	 * Returns the true width of the text, including newlines with optional
	 * separation distance
	 */
	public float[] getWidths()
	{
		return SEString.getWidths(Text, textpaint);
	}
	
	
	
	

	
	
	/**
	 * Draw the text
	 */
	@Override
	public void draw(Canvas canvas)
	{
		Paint.FontMetrics fm = textpaint.getFontMetrics();
		float height = (fm.bottom - fm.top);
		float x_offset = Position.X;
		float y_offset = Position.Y;
		
		String[] lines = null;
		if (Text.contains("\n"))
			lines = Text.split("\n");
		else
			lines = Text.split("##");
		
		if (CentreText)
		{
			y_offset = y_offset - (height * (lines.length - 1) * 0.5f);// * 0.68f);
		}
		
		for (String line : lines)
		{
			if (CentreText)
			{
				x_offset = Position.X - (textpaint.measureText(line) * 0.5f);
				y_offset += (height * 0.26f);// 0.36f);
			}
			
			canvas.drawText(line, x_offset, y_offset, textpaint);
			y_offset = y_offset + (height * 0.8f);
		}
	}
	
	
	
	
}
