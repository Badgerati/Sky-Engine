package sky.engine.graphics;

import sky.engine.graphics.textures.Texture;
import android.graphics.Canvas;

public class Background extends DrawableComponent
{
	
	/**
	 * Colour to use as background
	 */
	private int colour = -1;
	private boolean colourset = false;
	
	
	/**
	 * Texture to use as background
	 */
	private Texture texture = null;
	
	
	
	
	
	/**
	 * Create Background
	 */
	public Background(int colour)
	{
		this.colour = colour;
		colourset = true;
	}
	
	
	/**
	 * Create Background
	 */
	public Background(Texture texture)
	{
		this.texture = texture;
	}
	
	
	
	
	
	/**
	 * Recycle the background texture, if it exists
	 */
	public void recycle()
	{
		if (texture != null)
			texture.recycle();
	}
	
	
	
	
	
	/**
	 * Draw Background
	 */
	public void draw(Canvas canvas)
	{
		if (colourset)
			canvas.drawColor(colour);
		
		else if (texture != null)
			texture.draw(canvas, Position.X, Position.Y, null);
	}
	
	
	
}
