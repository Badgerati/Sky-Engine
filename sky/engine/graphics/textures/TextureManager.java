package sky.engine.graphics.textures;

import java.util.HashMap;
import java.util.Set;

import android.content.res.Resources;
import android.graphics.Bitmap;
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
	protected static HashMap<Integer, Texture> textures = null;
	
	
	/**
	 * Resource manager to help load Bitmaps.
	 */
	protected static Resources globalResource = null;
	
	
	
	
	

	
	
	/**
	 * 
	 */
	public static void initialise()
	{
		textures = new HashMap<Integer, Texture>();
	}
	
	
	/**
	 * 
	 */
	public static void initialise(Resources globalres)
	{
		textures = new HashMap<Integer, Texture>();
		globalResource = globalres;
	}
	

	

	
	
	/**
	 * Load and add a Texture to the set of all Textures, from the global Resource.
	 */
	public static Texture load(int resourceID, int textureID)
	{
		//no global resource
		if (globalResource == null) {
			throw new Error("No global resource set for TextureManager, please initialise(global)" +
								"the TextureManager or call setGlobalResource(global).");
		}
		
		//load texture
		Texture texture = new Texture(BitmapFactory.decodeStream(globalResource.openRawResource(resourceID)));
		textures.put(textureID, texture);
		return texture;
	}
	
	
	/**
	 * Load a Texture from the global Resource.
	 */
	public static Texture load(int resourceID)
	{
		//no global resource
		if (globalResource == null) {
			throw new Error("No global resource set for TextureManager, please initialise(global)" +
								"the TextureManager or call setGlobalResource(global).");
		}
		
		//load texture
		Texture texture = new Texture(BitmapFactory.decodeStream(globalResource.openRawResource(resourceID)));
		return texture;
	}
	
	
	/**
	 * Load and add a Texture to the set of all Textures, from a given Resource.
	 */
	public static Texture load(Resources res, int resourceID, int textureID)
	{
		Texture texture = new Texture(BitmapFactory.decodeStream(res.openRawResource(resourceID)));
		textures.put(textureID, texture);
		return texture;
	}
	
	
	/**
	 * Load a Texture from a given Resource.
	 */
	public static Texture load(Resources res, int resourceID)
	{
		Texture texture = new Texture(BitmapFactory.decodeStream(res.openRawResource(resourceID)));
		return texture;
	}
	
	
	
	
	
	
	
	
	/**
	 * Sets the global Resource to use when loading textures.
	 */
	public static void setGlobalResource(Resources globalres)
	{
		globalResource = globalres;
	}
	
	
	
	
	
	
	
	/**
	 * Clears the currently loaded textures, keeping the global Resource.
	 */
	public static void clear()
	{
		textures.clear();
	}
	
	
	
	
	
	
	/**
	 * Returns the number of loaded textures
	 */
	public static int size()
	{
		return textures.size();
	}
	
	
	
	
	
	
	/**
	 * Returns a Texture given the textureID.
	 */
	public static Texture get(int textureID)
	{
		return textures.get(textureID);
	}
	
	
	
	
	
	
	/**
	 * Returns a Texture given the textureID.
	 */
	public static Bitmap getBitmap(int textureID)
	{
		return textures.get(textureID).getBitmap();
	}
	
	

	
	
	/**
	 * Deletes a Texture with the given textureID. Returns the removed Texture, or
	 * null if no mapping was found.
	 */
	public static Texture removeTexture(int textureID)
	{
		return textures.remove(textureID);
	}
	
	
	
	
	
	
	/**
	 * Returns a Set of all current textureIDs.
	 */
	public static Set<Integer> getTextureIDs()
	{
		if (textures != null) {
			return textures.keySet();
		}
		
		return null;
	}
	
	
	
	
	
	
	/**
	 * Returns the current global Resource.
	 */
	public static final Resources getGlobalResource()
	{
		return globalResource;
	}
	
	
	
	

}
