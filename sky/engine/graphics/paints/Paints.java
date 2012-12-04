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
	protected Fill fillpaint = null;
	
	
	/**
	 * Outline paint
	 */
	protected Outline outlinepaint = null;
	
	
	/**
	 * Blur paint
	 */
	protected Blur blurpaint = null;
	
	
	
	
	
	
	/**
	 * Create a new Paints object
	 */
	public Paints(Fill fill, Outline outline, Blur blur)
	{
		fillpaint = fill == null ? null : new Fill(fill);
		outlinepaint = outline == null ? null : new Outline(outline);
		blurpaint = blur == null ? null : new Blur(blur);
	}
	
	
	
	
	
	
	/**
	 * Create a new Paints object
	 */
	public Paints(int fill, int outline, int blur)
	{
		fillpaint = new Fill(fill);
		outlinepaint = new Outline(outline);
		blurpaint = new Blur(blur);
	}
	
	
	
	
	
	
	/**
	 * Create a new Paints object
	 */
	public Paints(Paints paints)
	{
		fillpaint = paints.fill().clone();
		outlinepaint = paints.outline().clone();
		blurpaint = paints.blur().clone();
	}
	
	
	
	
	
	/**
	 * 
	 */
	public Paints clone()
	{
		return new Paints(this);
	}
	
	
	
	
	
	/**
	 * Set alpha of the paints
	 */
	public void setAlpha(int alpha)
	{
		fillpaint.setAlpha(alpha);
		outlinepaint.setAlpha(alpha);
		blurpaint.setAlpha(alpha);
	}
	
	
	

	
	
	/**
	 * 
	 */
	public void setFillColour(int fill)
	{
		fillpaint.setColor(fill);
	}
	
	
	/**
	 * 
	 */
	public void setOutlineColour(int fill)
	{
		outlinepaint.setColor(fill);
	}
	
	
	/**
	 * 
	 */
	public void setBlurColour(int fill)
	{
		blurpaint.setColor(fill);
	}
	
	
	

	
	
	/**
	 * Returns the fill paint
	 */
	public Fill fill()
	{
		return fillpaint == null ? null : fillpaint;
	}
	
	
	/**
	 * Returns the outline paint
	 */
	public Outline outline()
	{
		return outlinepaint == null ? null : outlinepaint;
	}
	
	
	/**
	 * Returns the blur paint
	 */
	public Blur blur()
	{
		return blurpaint == null ? null : blurpaint;
	}
	

	
	
	

}
