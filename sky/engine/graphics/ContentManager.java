package sky.engine.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Shader;
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
	 * Load and return a BitmapShader
	 */
	public static BitmapShader loadShader(int resID, Shader.TileMode tileMode)
	{
		return new BitmapShader(ContentManager.loadBitmap(resID), tileMode, tileMode);
	}
	
	
	
	
	/**
	 * Load and return a font (Typeface) with given location
	 */
	public static Typeface loadFont(String location)
	{
		return Typeface.createFromAsset(resources.getAssets(), location);
	}
	
	
	
	
	/**
	 * Return a string with given resource ID
	 */
	public static String loadString(int resID)
	{
		return resources.getString(resID);
	}
	
}
