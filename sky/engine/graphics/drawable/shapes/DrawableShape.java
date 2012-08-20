package sky.engine.graphics.drawable.shapes;

import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public interface DrawableShape
{
	/**
	 * Draw the drawable shape.
	 */
	public void draw(Canvas canvas);

	
	/**
	 * Returns the paint used to fill this shape
	 */
	public Fill fill();
	
	
	/**
	 * Returns the paint used for the outline of this shape
	 */
	public Outline outline();
	
	
	/**
	 * Returns the paint used for the blurring effect of this shape
	 */
	public Blur blur();
	
	
	/**
	 * Sets the shape to be hidden
	 */
	public void hide();
	
	
	/**
	 * Sets the shape to be shown
	 */
	public void show();
	
}
