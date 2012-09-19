package sky.engine.graphics.paints;

import sky.engine.graphics.Colour;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class Fill extends Paint
{
	
	/**
	 * Create new instance of a FillPaint
	 */
	public Fill()
	{
		initialise(Colour.WHITE, true);
	}
	
	
	/**
	 * Create new instance of a FillPaint
	 */
	public Fill(int colour)
	{
		initialise(colour, true);
	}
	
	
	/**
	 * Create new instance of a FillPaint
	 */
	public Fill(int colour, boolean antialias)
	{
		initialise(colour, antialias);
	}
	
	
	/**
	 * Create new instance of a FillPaint
	 */
	public Fill(Fill paint)
	{
		initialise(paint.getColor(), paint.isAntiAlias());
	}
	
	
	
	
	
	
	/**
	 * Sets the fill
	 */
	public void set(Fill paint)
	{
		if (paint == null) return;
		
		initialise(paint.getColor(), paint.isAntiAlias());
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
