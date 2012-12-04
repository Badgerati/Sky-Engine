package sky.engine.graphics.paints;

import sky.engine.graphics.Colour;
import android.graphics.BitmapShader;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class Fill extends Paint
{
	
	/**
	 * Create new instance of a Fill
	 */
	public Fill()
	{
		initialise(Colour.WHITE, true);
	}
	
	
	/**
	 * Create new instance of a Fill
	 */
	public Fill(int colour)
	{
		initialise(colour, true);
	}
	
	
	/**
	 * Create new instance of a Fill
	 */
	public Fill(int colour, boolean antialias)
	{
		initialise(colour, antialias);
	}
	
	
	/**
	 * Create new instance of a Fill
	 */
	public Fill(Fill paint)
	{
		initialise(paint.getColor(), paint.isAntiAlias());
		this.setShader(paint.getShader());
	}
	
	/**
	 * Create new instance of Fill
	 */
	public Fill(BitmapShader shader)
	{
		initialise(Colour.WHITE, true);
		this.setShader(shader);
	}
	
	
	
	
	
	/**
	 * 
	 */
	public Fill clone()
	{
		return new Fill(this);
	}
	
	
	
	
	
	
	/**
	 * Sets the fill
	 */
	public void set(Fill paint)
	{
		if (paint == null) return;
		initialise(paint.getColor(), paint.isAntiAlias());
		this.setShader(paint.getShader());
	}
	
	
	
	
	
	
	
	
	/**
	 * Initialise the fill paint
	 */
	private void initialise(int colour, boolean antialias)
	{
		this.setStyle(Paint.Style.FILL);
		this.setColor(colour);
		this.setAntiAlias(antialias);
	}
	
	
}
