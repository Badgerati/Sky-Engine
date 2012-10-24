package sky.engine.graphics.text;

import java.util.HashMap;
import java.util.Set;

import sky.engine.graphics.ContentManager;
import android.graphics.Typeface;

public abstract class FontManager
{
	/**
	 * HashMap for all loaded fonts
	 */
	protected static HashMap<Integer, Typeface> fonts = new HashMap<Integer, Typeface>();
	

	
	
	
	/**
	 * Initialise the font manager
	 */
	public static void initialise()
	{
		fonts = new HashMap<Integer, Typeface>();
	}
	
	
	
	
	/**
	 * Add font
	 */
	public static Typeface add(int fontID, Typeface font)
	{
		fonts.put(fontID, font);
		return font;
	}
	
	
	
	
	/**
	 * Add font
	 */
	public static Typeface add(int fontID, String location)
	{
		Typeface font = ContentManager.loadFont(location);
		fonts.put(fontID, font);
		return font;
	}
	
	
	
	
	/**
	 * Get a font with given font ID
	 */
	public static Typeface get(int fontID)
	{
		return fonts.get(fontID);
	}
	
	
	
	
	/**
	 * Removes a font
	 */
	public static Typeface remove(int fontID)
	{
		Typeface font = fonts.get(fontID);
		fonts.remove(fontID);
		return font;
	}
	
	
	
	
	
	/**
	 * Returns a set of all font IDs
	 */
	public static Set<Integer> getFontIDs()
	{
		if (fonts != null) {
			return fonts.keySet();
		}
		
		return null;
	}
	
	
	
	
	
	/**
	 * Clear all fonts
	 */
	public static void clear()
	{
		fonts.clear();
	}
	
	
	
	
	/**
	 * Returns the number of fonts
	 */
	public static int size()
	{
		return fonts.size();
	}

}
