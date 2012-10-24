package sky.engine.graphics.textures;

import java.util.HashMap;
import java.util.Set;

import android.graphics.Bitmap;
import android.graphics.Canvas;

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
	 * 
	 */
	public static void initialise()
	{
		textures = new HashMap<Integer, Texture>();
	}
	
	
	
	
	
	/**
	 * Add a Bitmap to the Texture Manager, creating a Texture object from it
	 */
	public static Texture add(Bitmap bitmap, int textureID)
	{
		if (textures.containsKey(textureID))
			return textures.get(textureID);
		
		Texture texture = new Texture(bitmap);
		textures.put(textureID, texture);
		return texture;
	}
	
	
	
	
	
	
	/**
	 * Add a given Texture to the set of textures in the Texture Manager
	 */
	public static void add(Texture texture, int textureID)
	{
		if (textures.containsKey(textureID))
			return;
		
		textures.put(textureID, texture);
	}
	

	

	
	
	/**
	 * Adds a Textures to the set of textures from the given resource ID.
	 */
	public static Texture add(int resourceID, int textureID)
	{
		if (textures.containsKey(textureID))
			return textures.get(textureID);
		
		textures.put(textureID, new Texture(resourceID));
		return textures.get(textureID);
	}
	
	
	/**
	 * Load a Texture with given resource ID.
	 */
	public static Texture load(int resourceID)
	{
		return new Texture(resourceID);
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
	 * Returns a Texture's Bitmap given the textureID.
	 */
	public static Bitmap getBitmap(int textureID)
	{
		return textures.get(textureID).bitmap();
	}
	
	
	
	
	
	/**
	 * Changes the textureID of some Texture, to the newly given one. Returns false
	 * if the old textureID doesn't exist, or the newID already exists.
	 */
	public static boolean move(int textureID, int newID)
	{
		if (!textures.containsKey(textureID) || textures.containsKey(newID))
			return false;
		
		Texture texture = textures.get(textureID).clone();
		textures.remove(textureID);
		textures.put(newID, texture);
		return true;
	}
	
	
	

	
	
	/**
	 * Deletes a Texture with the given textureID. Returns the removed Texture, or
	 * null if no mapping was found.
	 */
	public static Texture remove(int textureID)
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
	 * Returns whether the Texture Manager contain the given textureID
	 */
	public static boolean contains(int textureID)
	{
		return textures.containsKey(textureID);
	}	
	

	
	
	/**
	 * Draw the Texture at given textureID
	 */
	public static void draw(Canvas canvas, int textureID)
	{
		textures.get(textureID).draw(canvas);
	}
	
	
	
	

}
