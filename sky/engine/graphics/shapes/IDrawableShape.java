package sky.engine.graphics.shapes;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public interface IDrawableShape
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
	 * Set the paints for the shape
	 */
	public void setPaints(Paints paint);
	
	
	/**
	 * Set the alpha for the shape
	 */
	public void setAlpha(int alpha);
	
	
	/**
	 * Set the shape's position
	 */
	public void setPosition(Vector2d position);
	
	
	/**
	 * Set the shape's position
	 */
	public void setPosition(float x, float y);
	
	
	/**
	 * Sets the shape to be hidden
	 */
	public void hide();
	
	
	/**
	 * Sets the shape to be shown
	 */
	public void show();
	
}
