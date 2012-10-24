package sky.engine.graphics.gui;

import sky.engine.geometry.vectors.Vector2d;
import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class ImageButton extends Button
{
	
	/**
	 * Bitmap for the ImageButton
	 */
	protected Bitmap bitmap = null;
	
	
	
	
	
	
	/**
	 * Create a new ImageButton
	 */
	public ImageButton(Vector2d position, float width, float height, String text, Bitmap bitmap)
	{
		super();
		initialise(position, width, height, text);
		this.bitmap = bitmap;
	}
	
	
	
	
	
	
	/**
	 * Draw the Button
	 */
	@Override
	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(bitmap, position.X - (width * 0.5f), position.Y - (height * 0.5f), null);
	}
	
	
	
	
}
