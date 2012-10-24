package sky.engine.graphics.textures;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.ContentManager;
import sky.engine.graphics.IDrawableComponent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Texture implements ITexture, IDrawableComponent
{
	/**
	 * Bitmap for this texture.
	 */
	protected Bitmap bitmap = null;
	
	
	/**
	 * Position of Texture if it is to be drawn
	 */
	protected Vector2d position = null;
	
	
	/**
	 * Paint object for the Texture when drawing
	 */
	protected Paint paint = null;
	
	

	
	
	
	/**
	 * Create a new Texture object from Bitmap.
	 */
	public Texture(Bitmap bitmap)
	{
		this.bitmap = bitmap;
		position = Vector2d.zeros();
	}
	
	
	/**
	 * Create a new Texture object from a resource ID.
	 */
	public Texture(int resID)
	{
		this.bitmap = ContentManager.loadBitmap(resID);
		position = Vector2d.zeros();
	}
	
	
	
	
	
	/**
	 * Create and returns a new scaled Texture
	 */
	public static Texture createScaledTexture(int resID, float width_factor, float height_factor)
	{
		Bitmap bitmap = ContentManager.loadBitmap(resID);
		
		Texture texture = new Texture(Bitmap.createScaledBitmap(bitmap,
				(int)(bitmap.getWidth() * width_factor),
				(int)(bitmap.getHeight() * height_factor),
				true));
		
		bitmap.recycle();
		return texture;
	}
	
	
	
	
	
	/**
	 * Create and returns a new scaled Texture
	 */
	public static Texture createScaledTexture(Bitmap bitmap, float width_factor, float height_factor)
	{		
		return new Texture(Bitmap.createScaledBitmap(bitmap,
				(int)(bitmap.getWidth() * width_factor),
				(int)(bitmap.getHeight() * height_factor),
				true));
	}
	
	
	
	
	
	/**
	 * Create and returns a new scaled Texture
	 */
	public static Texture createScaledTexture(int resID, Size size)
	{
		Bitmap bitmap = ContentManager.loadBitmap(resID);
		
		Texture texture = new Texture(Bitmap.createScaledBitmap(bitmap,
				(int)size.Width, (int)size.Height, true));
		
		bitmap.recycle();
		return texture;
	}
	
	
	
	
	
	/**
	 * Create and returns a new scaled Texture
	 */
	public static Texture createScaledTexture(Bitmap bitmap, Size size)
	{		
		return new Texture(Bitmap.createScaledBitmap(bitmap,
				(int)size.Width, (int)size.Height, true));
	}
	
	
	
	
	
	
	/**
	 * Clones this texture
	 */
	public Texture clone()
	{
		return new Texture(bitmap);
	}
	
	
	
	
	
	/**
	 * Sets the Texture's position
	 */
	public void setPosition(Vector2d position)
	{
		this.position = position.clone();
	}
	
	
	
	
	
	/**
	 * Sets the Texture's position with central offset
	 */
	public void setPositionWithOffset(Vector2d position)
	{
		this.position.X = position.X - (bitmap.getWidth() * 0.5f);
		this.position.Y = position.Y - (bitmap.getHeight() * 0.5f);
	}
	
	
	
	
	
	/**
	 * Set the paint to use (can be null)
	 */
	public void setPaint(Paint paint)
	{
		if (this.paint == null) this.paint = new Paint();
		if (paint == null) this.paint = null;
		
		this.paint.set(paint);
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
			return this.bitmap.equals(t.bitmap());
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
	public Bitmap bitmap()
	{
		return this.bitmap;
	}
	
	
	
	
	
	/**
	 * Returns the height of this Texture.
	 */
	public float height()
	{
		return bitmap.getHeight();
	}
	
	
	
	
	/**
	 * Returns the width of this Texture.
	 */
	public float width()
	{
		return bitmap.getWidth();
	}
	
	
	
	
	/**
	 * Scale this Texture
	 */
	public void scale(float width_factor, float height_factor)
	{
		bitmap = Bitmap.createScaledBitmap(bitmap,
				(int)(bitmap.getWidth() * width_factor),
				(int)(bitmap.getHeight() * height_factor),
				true);
	}
	
	
	
	
	
	/**
	 * Scale this Texture
	 */
	public void scale(Size size)
	{
		bitmap = Bitmap.createScaledBitmap(bitmap, (int)size.Width, (int)size.Height, true);
	}
	
	
	
	
	
	/**
	 * Draw the Texture
	 */
	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(bitmap, position.X, position.Y, paint);
	}
	
	
	
	
	
	/**
	 * Draw the Texture
	 */
	public void draw(Canvas canvas, float left, float top, Paint paint)
	{
		canvas.drawBitmap(bitmap, left, top, paint);
	}
	

}
