package sky.engine.geometry;

import java.util.Comparator;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Vector implements Comparable<Vector>
{
	/**
	 * Vector 2D type
	 */
	public static final int VECTOR_2D = 0;
	
	
	/**
	 * Vector 3D type
	 */
	public static final int VECTOR_3D = 1;
	
	
	/**
	 * Type of this Vector
	 */
	protected int vector_type;
	
	
	/**
	 * Comparator object for a Vector.	
	 */
	public static final Comparator<Vector> VECTOR_COMPARATOR = new Comparator<Vector>() {
		public int compare(Vector v1, Vector v2) {
			return v1.compareTo(v2);
		}
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Compare this Vector to the given one. Returns 0 if equal, positive if this is greater, or 
	 * negative if this is less than the given.
	 */
	public int compareTo(Vector v2)
	{
		if (this.vector_type == VECTOR_2D && v2.vector_type == VECTOR_2D)
		{
			return ((Vector2D)this).compareTo((Vector2D)v2);
		}
		
		else if (this.vector_type == VECTOR_3D && v2.vector_type == VECTOR_3D)
		{
			return ((Vector3D)this).compareTo((Vector3D)v2);
		}
		
		else if (this.vector_type == VECTOR_2D && v2.vector_type == VECTOR_3D)
		{
			return this.compare((Vector2D)this, (Vector3D)v2);
		}
		
		else if (this.vector_type == VECTOR_3D && v2.vector_type == VECTOR_2D)
		{
			return this.compare((Vector2D)v2, (Vector3D)this);
		}
		
		return -1;
	}
		
	
	
	/**
	 * Compare a Vector2D to a vector3D.
	 */
	protected int compare(Vector2D v1, Vector3D v2)
	{
		//greater than given
		if  (v1.X > v2.X || v1.Y > v2.Y || 0 > v2.Z)
			return 1;
		
		//less than given
		else if (v1.X < v2.X || v1.Y < v2.Y || 0 < v2.Z)
			return -1;
		
		//else, equal
		return 0;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Return the type of this vector.
	 */
	public int getType()
	{
		return vector_type;
	}
	
	
	
}
