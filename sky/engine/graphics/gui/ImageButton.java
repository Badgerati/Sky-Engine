package sky.engine.graphics.gui;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.physics.bounding.BoundingAABB;
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
	protected Bitmap normal_btn = null;
	
	
	/**
	 * Bitmap for the ImageButton
	 */
	protected Bitmap focused_btn = null;
	
	
	/**
	 * Bitmap for the ImageButton
	 */
	protected Bitmap current_btn = null;
	
	
	

	
	
	/**
	 * Create a new ImageButton
	 */
	public ImageButton(Vector2d position, String text, Bitmap normal, Bitmap focused)
	{
		super(position, text);

		this.normal_btn = normal;
		this.focused_btn = focused;
		current_btn = normal_btn;
		this.height = normal.getHeight();
		this.width = normal.getWidth();
		
		buttonBound = new BoundingAABB(position, width, height);
	}
	
	
	/**
	 * Create a new ImageButton
	 */
	public ImageButton(Vector2d position, String text, Bitmap normal)
	{
		super(position, text);

		this.normal_btn = normal;
		this.focused_btn = normal;
		current_btn = normal_btn;
		this.height = normal.getHeight();
		this.width = normal.getWidth();
		
		buttonBound = new BoundingAABB(position, width, height);
	}
	
	
	
	
	
	/**
	 * Set the Image to use for normal appearance
	 */
	public void setNormalImage(Bitmap bitmap)
	{
		this.normal_btn = bitmap;
		current_btn = normal_btn;
	}
	
	
	
	
	
	/**
	 * Set the Image to use for focused appearance
	 */
	public void setFocusedImage(Bitmap bitmap)
	{
		this.focused_btn = bitmap;
	}
	
	
	
	
	
	
	/**
	 * Draw the Button
	 */
	@Override
	public void draw(Canvas canvas)
	{
		if (Focusable && previousState != currentState)
		{
			previousState = currentState;
			
			switch (currentState)
			{
				case STATE_NORMAL:
				case STATE_CLICKED:
					current_btn = normal_btn;
					break;
					
				case STATE_FOCUSED:
					current_btn = focused_btn;
					break;
			}
		}

		canvas.drawBitmap(current_btn, Position.X - (width * 0.5f), Position.Y - (height * 0.5f), null);
		text.draw(canvas);		
	}
	
	
	
	
}
