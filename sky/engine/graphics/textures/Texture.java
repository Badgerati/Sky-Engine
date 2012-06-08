package sky.engine.graphics.textures;

import android.graphics.Bitmap;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Texture
{
	/**
	 * Bitmap for this texture.
	 */
	private final Bitmap bitmap;
	
	
	
	
	
	
	
	
	
	/**
	 * Create a new Texture object from Bitmap.
	 */
	public Texture(Bitmap bitmap)
	{
		this.bitmap = bitmap;
	}
	
	
	
	
	
	
	
	

	
	/**
	 * Does this Texture equal another?
	 */
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Texture t = (Texture)o;
			return this.bitmap.equals(t.getTexture());
		}
		catch (Exception e)
		{
			return super.equals(o);
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Generates a hash code for this Texture.
	 */
	@Override
	public int hashCode()
	{
		return this.bitmap.hashCode();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the Bitmap associated with this Texture.
	 */
	public final Bitmap getTexture()
	{
		return this.bitmap;
	}
	
	
	
	
	
	

	
	/**
	 * Returns the height of this Texture.
	 */
	public float getHeight()
	{
		return bitmap.getHeight();
	}
	
	
	/**
	 * Returns the width of this Texture.
	 */
	public float getWidth()
	{
		return bitmap.getWidth();
	}
	

}
