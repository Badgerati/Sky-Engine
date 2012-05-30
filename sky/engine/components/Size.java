package sky.engine.components;

import sky.engine.geometry.Vector2D;
import sky.engine.geometry.Vector3D;




/**
 * Stores the components of Width, Height and Depth.
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Size
{
	/**
	 * Width component
	 */
	public float Width;
	
	
	/**
	 * Height component
	 */
	public float Height;
	
	
	/**
	 * Depth component
	 */
	public float Depth;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create a new Size object
	 */
	public Size()
	{
		Width = 0;
		Height = 0;
		Depth = 0;
	}

	
	/**
	 * Create a new Size object
	 */
	public Size(float width, float height)
	{
		Width = width;
		Height = height;
		Depth = 0;
	}

	
	/**
	 * Create a new Size object
	 */
	public Size(float width, float height, float depth)
	{
		Width = width;
		Height = height;
		Depth = depth;
	}

	
	/**
	 * Create a new Size object
	 */
	public Size(Size size)
	{
		Width = size.Width;
		Height = size.Height;
		Depth = size.Depth;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this Size
	 */
	public Size clone()
	{
		return new Size(this.Width, this.Height, this.Depth);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Set the height and width of this size
	 */
	public void set(float width, float height)
	{
		Width = width;
		Height = height;
		Depth = 0;
	}
	
	
	/**
	 * Set the height, width and depth of this size
	 */
	public void set(float width, float height, float depth)
	{
		Width = width;
		Height = height;
		Depth = depth;
	}
	
	
	/**
	 * Set the height, width and depth of this size from another Size object
	 */
	public void set(Size size)
	{
		Width = size.Width;
		Height = size.Height;
		Depth = size.Depth;
	}
	
	
	
	
	
	
	
	
	/**
	 * scale the size by the given scaling value
	 */
	public void scale(float scale)
	{
		Width *= scale;
		Height *= scale;
		Depth *= scale;
	}
	
	
	/**
	 * scale the size by the given width and height scaling values
	 */
	public void scale(float widthScale, float heightScale)
	{
		Width *= widthScale;
		Height *= heightScale;
	}
	
	
	/**
	 * scale the size by the given width, height and depth scaling values
	 */
	public void scale(float widthScale, float heightScale, float depthScale)
	{
		Width *= widthScale;
		Height *= heightScale;
		Depth *= depthScale;
	}
	
	
	
	
	
	
	

	
	
	/**
	 * Returns this size as a 2D vector
	 */
	public Vector2D asVector2()
	{
		return new Vector2D(Width, Height);
	}
	
	
	/**
	 * Returns this size as a 3D vector
	 */
	public Vector3D asVector3()
	{
		return new Vector3D(Width, Height, Depth);
	}
	
	
	
	
	
	
	
	
	
	
	
	/*******************************************
	 *               OPERATORS
	 *******************************************/
	
	/** by another size */
	public Size add(Size size)
	{
		return new Size(Width + size.Width, Height + size.Height, Depth + size.Depth);
	}
	
	
	public Size sub(Size size)
	{
		return new Size(Width - size.Width, Height - size.Height, Depth - size.Depth);
	}
	
	
	public Size mul(Size size)
	{
		return new Size(Width * size.Width, Height * size.Height, Depth * size.Depth);
	}
	
	
	public Size div(Size size)
	{
		return new Size(Width / size.Width, Height / size.Height, Depth / size.Depth);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/** by a scalar */
	public Size mulScalar(float value)
	{
		return new Size(Width * value, Height * value, Depth * value);
	}
	
	
	public Size divScalar(float value)
	{
		return new Size(Width / value, Height / value, Depth / value);
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns string representation of this size
	 */
	public String toString()
	{
		return "(Width = " + Float.toString(Width) + ", Height = " + Float.toString(Height) + ", Depth = " + Float.toString(Depth) + ")";
	}
	
	
	
	
	
	

}
