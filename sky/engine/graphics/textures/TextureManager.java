package sky.engine.graphics.textures;

import java.util.HashMap;
import java.util.Set;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class TextureManager
{
	/**
	 * HashMap of all loaded textures.
	 */
	private HashMap<Integer, Texture> loadedTextures = null;
	
	
	/**
	 * HashMap to map user given IDs to actual Texture IDs.
	 */
	private HashMap<Integer, Integer> textureIDs = null;
	
	
	/**
	 * Resource manager to help load Bitmaps.
	 */
	private Resources globalResource = null;
	
	
	
	
	
	
	

	
	
	/**
	 * Create a new TextureManager object
	 */
	public TextureManager()
	{
		loadedTextures = new HashMap<Integer, Texture>();
		textureIDs = new HashMap<Integer, Integer>();
	}
	
	
	/**
	 * Create a new TextureManager object
	 */
	public TextureManager(Resources globalres)
	{
		loadedTextures = new HashMap<Integer, Texture>();
		textureIDs = new HashMap<Integer, Integer>();
		globalResource = globalres;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Load and add a Texture to the set of all Textures, from a given Resource.
	 */
	public Texture load(Resources res, int resourceID, int textureID)
	{
		if (loadedTextures.containsKey(resourceID))
			return getTextureByResourceID(resourceID);
		
		if (textureIDs.containsKey(textureID))
			return getTextureByTextureID(textureID);
		
		textureIDs.put(textureID, resourceID);
		
		Texture texture = new Texture(BitmapFactory.decodeStream(res.openRawResource(resourceID)));
		loadedTextures.put(resourceID, texture);
		
		return texture;
	}
	
	
	/**
	 * Load and add a Texture to the set of all Textures, from the global Resource.
	 */
	public Texture load(int resourceID, int textureID)
	{
		if (globalResource == null)
			throw new Error("No global resource set for TextureManager.");
		
		if (loadedTextures.containsKey(resourceID))
			return getTextureByResourceID(resourceID);
		
		if (textureIDs.containsKey(textureID))
			return getTextureByTextureID(textureID);
		
		textureIDs.put(textureID, resourceID);
		
		Texture texture = new Texture(BitmapFactory.decodeStream(globalResource.openRawResource(resourceID)));
		loadedTextures.put(resourceID, texture);
		
		return texture;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Sets the global Resource to use when loading textures.
	 */
	public void setGlobalResource(Resources globalres)
	{
		globalResource = globalres;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clears the currently loaded textures, keeping the global Resource.
	 */
	public void clear()
	{
		loadedTextures = new HashMap<Integer, Texture>();
		textureIDs = new HashMap<Integer, Integer>();
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the number of loaded textures
	 */
	public int size()
	{
		return loadedTextures.size();
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a Texture given the resourceID.
	 */
	public Texture getTextureByResourceID(int resourceID)
	{
		return loadedTextures.get(resourceID);
	}
	
	
	/**
	 * Returns a Texture given the user generated textureID.
	 */
	public Texture getTextureByTextureID(int textureID)
	{
		return loadedTextures.get(textureIDs.get(textureID));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Deletes a Texture with the given textureID. Returns the removed Texture, or
	 * null if no mapping was found.
	 */
	public Texture removeTexture(int textureID)
	{
		if (!textureIDs.containsKey(textureID))
		{
			return null;
		}
		
		int resID = textureIDs.get(textureID);
		textureIDs.remove(textureID);
		return loadedTextures.remove(resID);
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * Returns a Set of all current textureIDs.
	 */
	public Set<Integer> getTextureIDs()
	{
		if (textureIDs != null) {
			return textureIDs.keySet();
		}
		
		return null;
	}
	
	
	/**
	 * Returns a Set of all current resourceIDs.
	 */
	public Set<Integer> getResourceIDs()
	{
		if (loadedTextures != null) {
			return loadedTextures.keySet();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the current global Resource.
	 */
	public final Resources getGlobalResource()
	{
		return globalResource;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
