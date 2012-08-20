package sky.engine.graphics.paints;


/**
 * TODO: Redo so it fits nicely with the three new paints
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Paints
{
	/**
	 * Fill paint
	 */
	protected Fill Fillpaint = null;
	
	
	/**
	 * Outline paint
	 */
	protected Outline Outlinepaint = null;
	
	
	/**
	 * Blur paint
	 */
	protected Blur Blurpaint = null;
	
	
	
	
	
	
	/**
	 * Create a new Paints object
	 */
	public Paints(Fill fill, Outline outline, Blur blur)
	{
		Fillpaint = fill == null ? null : new Fill(fill);
		Outlinepaint = outline == null ? null : new Outline(outline);
		Blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	

	
	
	/**
	 * Returns the fill paint
	 */
	public Fill fill()
	{
		return Fillpaint == null ? null : new Fill(Fillpaint);
	}
	
	
	/**
	 * Returns the outline paint
	 */
	public Outline outline()
	{
		return Outlinepaint == null ? null : new Outline(Outlinepaint);
	}
	
	
	/**
	 * Returns the blur paint
	 */
	public Blur blur()
	{
		return Blurpaint == null ? null : new Blur(Blurpaint);
	}
	

	
	
	

}
