package sky.engine.util.primitives;

import sky.engine.components.Size;
import sky.engine.graphics.ContentManager;
import android.graphics.Bitmap;


/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class SEBitmap
{
	/**
	 * Bitmap
	 */
	protected Bitmap bitmap = null;
	
	
	
	
	
	
	/**
	 * Create new SEBitmap
	 */
	public SEBitmap(int resID)
	{
		this.bitmap = ContentManager.loadBitmap(resID);
	}
	
	
	/**
	 * Create new SEBitmap
	 */
	public SEBitmap(Bitmap bitmap)
	{
		this.bitmap = Bitmap.createBitmap(bitmap);
	}
	
	
	/**
	 * Create new SEBitmap
	 */
	public SEBitmap(SEBitmap sebitmap)
	{
		this.bitmap = Bitmap.createBitmap(sebitmap.bitmap);
	}
	
	
	
	

	
	
	/**
	 * Clone the SEBitmap
	 */
	public SEBitmap clone()
	{
		return new SEBitmap(bitmap);
	}
	
	
	/**
	 * Clone the Bitmap
	 */
	public Bitmap cloneBitmap()
	{
		return Bitmap.createBitmap(bitmap);
	}
	
	
	
	
	/**
	 * Returns the internal Bitmap. Any changes performed are also reflected in
	 * this SEBitmap.
	 */
	public Bitmap getBitmap()
	{
		return bitmap;
	}
	
	
	
	
	
	/**
	 * Returns the height of the Bitmap
	 */
	public int getHeight()
	{
		return bitmap.getHeight();
	}
	
	
	
	
	
	/**
	 * Returns the width of the Bitmap
	 */
	public int getWidth()
	{
		return bitmap.getWidth();
	}
	
	
	
	
	
	/**
	 * Recycles the Bitmap
	 */
	public void recycle()
	{
		bitmap.recycle();
	}
	
	
	
	
	
	/**
	 * Create and returns a new scaled Bitmap
	 */
	public static Bitmap createScaledBitmap(Bitmap bitmap, float width_factor, float height_factor)
	{		
		return Bitmap.createScaledBitmap(bitmap,
				(int)(bitmap.getWidth() * width_factor),
				(int)(bitmap.getHeight() * height_factor),
				true);
	}
	
	
	
	
	
	/**
	 * Create and returns a new scaled Bitmap
	 */
	public static Bitmap createScaledBitmap(Bitmap bitmap, Size size)
	{		
		return Bitmap.createScaledBitmap(bitmap,
				(int)size.Width, (int)size.Height, true);
	}
	
	
	
	
	
	/**
	 * scales the Bitmap
	 */
	public void scale(float width_factor, float height_factor)
	{		
		bitmap = Bitmap.createScaledBitmap(bitmap,
					(int)(bitmap.getWidth() * width_factor),
					(int)(bitmap.getHeight() * height_factor),
					true);
	}
	
	
	
	
	
	/**
	 * scales the Bitmap
	 */
	public void scale(Size size)
	{
		bitmap = Bitmap.createScaledBitmap(bitmap,
					(int)size.Width, (int)size.Height, true);
	}
	
}
