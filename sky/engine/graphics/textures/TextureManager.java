package sky.engine.graphics.textures;

import java.util.HashMap;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class TextureManager
{
	/**
	 * HashMap of all loaded textures.
	 */
	private static HashMap<Integer, Texture> loadedTextures = null;
	
	
	/**
	 * HashMap to map user given IDs to actual Texture IDs.
	 */
	private static HashMap<Integer, Integer> textureIDs = null;
	
	
	/**
	 * Resource manager to help load Bitmaps.
	 */
	private static Resources resources = null;
	
	
	
	
	
	
	
	
	
	/**
	 * Load and add a Texture to the set of all Textures, from given resources.
	 */
	public static boolean load(Resources res, int resourceID, int textureID)
	{
		if (loadedTextures.containsKey(resourceID) || textureIDs.containsKey(textureID))
		{
			return false;
		}
		
		textureIDs.put(textureID, resourceID);
		
		Texture texture = new Texture(BitmapFactory.decodeStream(res.openRawResource(resourceID)));
		loadedTextures.put(resourceID, texture);
		
		return true;
	}
	
	
	/**
	 * Load and add a Texture to the set of all Textures, from global resources.
	 */
	public static boolean load(int resourceID, int textureID)
	{
		if (loadedTextures.containsKey(resourceID) || textureIDs.containsKey(textureID))
		{
			return false;
		}
		
		textureIDs.put(textureID, resourceID);
		
		Texture texture = new Texture(BitmapFactory.decodeStream(resources.openRawResource(resourceID)));
		loadedTextures.put(resourceID, texture);
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the TextureManager. This method is normally called by the
	 * engine itself.
	 */
	public static void initialise(Resources res)
	{
		loadedTextures = new HashMap<Integer, Texture>();
		textureIDs = new HashMap<Integer, Integer>();
		resources = res;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a Texture given the resourceID.
	 */
	public static Texture getTextureByResourceID(int resourceID)
	{
		return loadedTextures.get(resourceID);
	}
	
	
	/**
	 * Returns a Texture given the user generated textureID.
	 */
	public static Texture getTextureByTextureID(int textureID)
	{
		return loadedTextures.get(textureIDs.get(textureID));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Deletes a Texture with the given textureID
	 */
	public static boolean deleteTexture(int textureID)
	{
		if (!textureIDs.containsKey(textureID))
		{
			return false;
		}
		
		int resID = textureIDs.get(textureID);
		textureIDs.remove(textureID);
		loadedTextures.remove(resID);
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
