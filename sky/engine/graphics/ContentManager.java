package sky.engine.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class ContentManager
{
	/**
	 * Global Resource
	 */
	protected static Resources resources = null;
	
	
	
	
	/**
	 * Initialise the ContentManager with a Resource
	 */
	public static void initialise(Resources resources)
	{
		ContentManager.resources = resources;
	}
	
	
	
	
	/**
	 * Load and return a Bitmap
	 */
	public static Bitmap loadBitmap(int resID)
	{		
		return BitmapFactory.decodeStream(resources.openRawResource(resID));
	}
	
	
	
	
	/**
	 * Load and return a font (Typeface) with given location
	 */
	public static Typeface loadFont(String location)
	{
		return Typeface.createFromAsset(resources.getAssets(), location);
	}
	
}
