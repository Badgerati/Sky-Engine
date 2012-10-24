package sky.engine.graphics.textures;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2d;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public interface ITexture
{
	
	/**
	 * Returns the Bitmap of this Texture
	 */
	public Bitmap bitmap();
	
	
	/**
	 * Returns the height of this Texture
	 */
	public float height();
	
	
	/**
	 * Returns the Width of this Texture
	 */
	public float width();
	
	
	/**
	 * Clones this texture
	 */
	public Texture clone();

	
	/**
	 * Sets the Texture's position
	 */
	public void setPosition(Vector2d position);
	
	
	/**
	 * Sets the Texture's position with central offset
	 */
	public void setPositionWithOffset(Vector2d position);
	
	
	/**
	 * Set the paint to use (can be null)
	 */
	public void setPaint(Paint paint);
	
	
	/**
	 * Scales the Bitmap of this Texture to the given size
	 */
	public void scale(float width, float height);
	
	
	/**
	 * Scales the Bitmap of this Texture to the given size
	 */
	public void scale(Size scalesize);
	
	
	/**
	 * Draws the Bitmap of this Texture
	 */
	public void draw(Canvas canvas);
	
}
