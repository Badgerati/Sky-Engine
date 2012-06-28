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
	public Vector2D asVector2D()
	{
		return new Vector2D(Width, Height);
	}
	
	
	/**
	 * Returns this size as a 3D vector
	 */
	public Vector3D asVector3D()
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
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * Multiply this Size's components by a scalar value.
	 */
	public Size mulScalar(float value)
	{
		return new Size(Width * value, Height * value, Depth * value);
	}
	
	
	/**
	 * Multiply this Size's components by a scalar value.
	 */
	public Size mulScalar(float w_scalar, float h_scalar)
	{
		return new Size(Width * w_scalar, Height * h_scalar, Depth);
	}
	
	
	/**
	 * Multiply this Size's components by a scalar value.
	 */
	public Size mulScalar(float w_scalar, float h_scalar, float d_scalar)
	{
		return new Size(Width * w_scalar, Height * h_scalar, Depth * d_scalar);
	}
	

	
	
	/**
	 * Divide this Size's components by a scalar value.
	 */
	public Size divScalar(float value)
	{
		return new Size(Width / value, Height / value, Depth / value);
	}
	
	
	/**
	 * Divide this Size's components by a scalar value.
	 */
	public Size divScalar(float w_scalar, float h_scalar)
	{
		return new Size(Width / w_scalar, Height / h_scalar, Depth);
	}
	
	
	/**
	 * Divide this Size's components by a scalar value.
	 */
	public Size divScalar(float w_scalar, float h_scalar, float d_scalar)
	{
		return new Size(Width / w_scalar, Height / h_scalar, Depth / d_scalar);
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns string representation of this size
	 */
	public String toString()
	{
		return "(Width = " + Float.toString(Width) + ", Height = " + Float.toString(Height) + ", Depth = " + Float.toString(Depth) + ")";
	}
	
	
	
	
	
	

}
