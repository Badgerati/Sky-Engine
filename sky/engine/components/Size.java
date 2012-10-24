package sky.engine.components;

import java.util.Comparator;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.geometry.vectors.Vector3d;




/**
 * Stores the components of Width, Height and Depth.
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Size implements Comparable<Size>
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
	 * Comparator object for a Size component
	 */
	public static final Comparator<Size> SIZE_COMPARATOR = new Comparator<Size>() {
		public int compare(Size s1, Size s2) {
			return s1.compareTo(s2);
		}
	};
	
	
	
	
	
	
	
	
	
	
	
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
	public Vector2d asVector2D()
	{
		return new Vector2d(Width, Height);
	}
	
	
	/**
	 * Returns this size as a 3D vector
	 */
	public Vector3d asVector3D()
	{
		return new Vector3d(Width, Height, Depth);
	}
	
	
	
	
	
	
	
	
	
	
	 /**
	  * Compares this size component to the given size. Returns 0 if they're equal,
	  * 1 if this size is greater than given, or -1 if less then given.
	  */
	public int compareTo(Size size)
	{
		//greater
		if ((Height * Width * Depth) > (size.Height * size.Width * size.Depth))
			return 1;
		
		//less
		else if ((Height * Width * Depth) < (size.Height * size.Width * size.Depth))
			return -1;		
		
		//equal
		return 0;
	}


	
	
	
	
	
	/**
	 * Is this size equal to the given size?
	 */
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Size size = (Size)o;
			return (Height == size.Height && Width == size.Width && Depth == size.Depth);
		}
		catch (Exception e)
		{
			return super.equals(o);
		}
	}


	
	
	
	
	
	/**
	 * Returns the hash code for this size
	 */
	@Override
	public int hashCode()
	{
		return (int)(Height + Width + Depth);
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
	 * Divide the scalar values by this Size's components.
	 */
	public Size reverseDivScalar(float w_scalar, float h_scalar)
	{
		return new Size(w_scalar / Width, h_scalar / Height, Depth);
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns string representation of this size
	 */
	public String toString()
	{
		return "(Width = " + Float.toString(Width) + ", Height = " + Float.toString(Height) + ", Depth = " + Float.toString(Depth) + ")";
	}
	
	
	
	
	
	

}
