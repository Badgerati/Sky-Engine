package sky.engine.geometry.vectors;

import java.util.Comparator;

import sky.engine.math.Angle;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Vector3 implements Comparable<Vector3>
{
	/**
	 * X component of this vector
	 */
	public float X;
	
	
	/**
	 * Y component of this vector
	 */
	public float Y;
	
	
	/**
	 * Z component of this vector
	 */
	public float Z;
	
	
	/**
	 * Comparator object for a Vector.	
	 */
	public static final Comparator<Vector3> VECTOR3D_COMPARATOR = new Comparator<Vector3>() {
		public int compare(Vector3 v1, Vector3 v2) {
			return v1.compareTo(v2);
		}
	};
	
	
	
	
	
	
	
	
	


	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3()
	{
		X = 0;
		Y = 0;
		Z = 0;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3(Vector2 vector)
	{
		X = vector.X;
		Y = vector.Y;
		Z = 0;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3(Vector2 vector, float z)
	{
		X = vector.X;
		Y = vector.Y;
		Z = z;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3(Vector3 vector)
	{
		X = vector.X;
		Y = vector.Y;
		Z = vector.Z;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set X, Y and Z components
	 */
	public void set(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
	}
	
	
	/**
	 * Set X, Y and Z components
	 */
	public void set(Vector2 vector, float z)
	{
		X = vector.X;
		Y = vector.Y;
		Z = z;
	}
	
	
	/**
	 * Set X, Y and Z components
	 */
	public void set(Vector3 vector)
	{
		X = vector.X;
		Y = vector.Y;
		Z = vector.Z;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this vector
	 */
	public Vector3 clone()
	{
		return new Vector3(this.X, this.Y, this.Z);
	}
	
	
	/**
	 * Clones the given vector array
	 */
	public static Vector3[] clone(Vector3[] vectors)
	{
		Vector3[] v = new Vector3[vectors.length];
		
		for (int i = 0; i < vectors.length; i++)
		{
			v[i].X = vectors[i].X;
			v[i].Y = vectors[i].Y;
			v[i].Z = vectors[i].Z;
		}
		
		return v;
	}
	

	
	
	
	
	
	
	
	
	
	/**
	 * Does the passed components equal this vector's components?
	 */
	public boolean equals(float x, float y, float z)
	{		
		return (X == x && Y == y && Z == z);
	}
	
	
	
	
	
	
	/**
	 * Does the passed object equal this vector?
	 */
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Vector3 v2 = (Vector3)o;
			return (X == v2.X && Y == v2.Y && Z == v2.Z);
		}
		catch (Exception e)
		{
			return super.equals(o);
		}
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Compares this Vector to another given Vector. Returns 0 if they are equal, -1 if this
	 * Vector is less than the given vector, and 1 if this Vector is greater than it.
	 */
	public int compareTo(Vector3 v2)
	{
		//greater than given
		if  (X > v2.X || Y > v2.Y || Z > v2.Z)
			return 1;
		
		//less than given
		else if (X < v2.X || Y < v2.Y || Z < v2.Z)
			return -1;
		
		//else, equal
		return 0;
	}

	
	
	
	
	
	
	
	
	
	/**
	 * Generate a hash code for this vector
	 */
	@Override
	public int hashCode()
	{
		return (int)((X * Y) + (X + Y) + (X - Z));
	}


	
	
	
	
	
	
	
	
	/**
	 * Absolute this vector, making both components positive
	 */
	public void absolute()
	{
		if (X < 0) X *= -1;
		if (Y < 0) Y *= -1;
		if (Z < 0) Z *= -1;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Negates this vector's components
	 */
	public void negate()
	{
		X = -X;
		Y = -Y;
		Z = -Z;
	}
	
	
	
	
	
	
	
	
	/**
	 * returns a vector of zeros
	 */
	public static Vector3 zeros()
	{
		return new Vector3(0, 0, 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * the magnitude of this vector.
	 */
	public float magnitude()
	{
		return android.util.FloatMath.sqrt((X * X) + (Y * Y) + (Z * Z));
	}
	
	
	/**
	 * Returns the magnitude of the distance between this vector and another.
	 */
	public float magnitude(Vector3 v2)
	{
		float x = X - v2.X;
		float y = Y - v2.Y;
		float z = Z - v2.Z;
		
		return android.util.FloatMath.sqrt((x * x) + (y * y) + (z * z));
	}
	
	
	/**
	 * Returns the squared magnitude of this vector.
	 */
	public float squaredMagnitude()
	{		
		return ((X * X) + (Y * Y) + (Z * Z));
	}
	
	
	/**
	 * Returns the squared magnitude of this vector to another.
	 */
	public float squaredMagnitude(Vector3 v2)
	{
		float x = X - v2.X;
		float y = Y - v2.Y;
		float z = Z - v2.Z;
		
		return ((x * x) + (y * y) + (z * z));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Normalise this vector
	 */
	public void normalise()
	{
		float mag = this.magnitude();
		X = X / mag;
		Y = Y / mag;
		Z = Z / mag;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the midpoint of this vector to another vector
	 */
	public Vector3 midpoint(Vector3 v2)
	{
		return new Vector3( (X + v2.X) * 0.5f, (Y + v2.Y) * 0.5f, (Z + v2.Z) * 0.5f  ); 
	}
	
	
	
	
	
	
	
	/**
	 * Static method. Given an array of vectors, returns the centre of them all.
	 * For example, the 8 vertices of a cube will return the centre point of
	 * the cube.
	 */
	public static Vector3 getCentre(Vector3[] vectors)
	{
		Vector3 centre = new Vector3();
		
		for (int i = 0; i < vectors.length; i++)
		{
			centre = centre.add(vectors[i]);
		}
		
		centre = centre.divScalar(vectors.length);
		
		return centre;
	}
	
	
	
	
	
	
	

	
	
	/**
	 * angle of direction of the vector on XY plane
	 */
	public float angleXY()
	{
		return Angle.arctan(X, -Y);
	}
	
	
	/**
	 * angle of direction of the vector on YZ plane
	 */
	public float angleYZ()
	{
		return Angle.arctan(Y, -Z);
	}
	
	
	/**
	 * angle of direction of the vector on XZ plane
	 */
	public float angleXZ()
	{
		return Angle.arctan(X, -Z);
	}
	
	
	
	
	
	
	
	

	
	
	/**
	 * Integrate this vector by given velocity
	 */
	public void integrate(float x, float y, float z)
	{
		X += x;
		Y += y;
		Z += z;
	}
	
	
	/**
	 * Integrate this vector by given velocity
	 */
	public void integrate(Vector2 velocity)
	{
		X += velocity.X;
		Y += velocity.Y;
	}
	
	
	/**
	 * Integrate this vector by given velocity
	 */
	public void integrate(Vector3 velocity)
	{
		X += velocity.X;
		Y += velocity.Y;
		Z += velocity.Z;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*******************************************
	 *               OPERATORS
	 *******************************************/
	
	/** Add a vector to this vector */
	public Vector3 add(Vector3 vector)
	{
		return new Vector3(X + vector.X, Y + vector.Y, Z + vector.Z);
	}

	
	/** Subtract the given vector from this vector */
	public Vector3 sub(Vector3 vector)
	{
		return new Vector3(X - vector.X, Y - vector.Y, Z - vector.Z);
	}

	
	/** Multiply a vector to this vector */
	public Vector3 mul(Vector3 vector)
	{
		return new Vector3(X * vector.X, Y * vector.Y, Z * vector.Z);
	}

	
	/** Divide this vector by the given vector */
	public Vector3 div(Vector3 vector)
	{
		return new Vector3(X / vector.X, Y / vector.Y, Z / vector.Z);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/** Add a vector to this vector */
	public Vector3 add(Vector2 vector)
	{
		return new Vector3(X + vector.X, Y + vector.Y, Z);
	}

	
	/** Subtract the given vector from this vector */
	public Vector3 sub(Vector2 vector)
	{
		return new Vector3(X - vector.X, Y - vector.Y, Z);
	}

	
	/** Multiply a vector to this vector */
	public Vector3 mul(Vector2 vector)
	{
		return new Vector3(X * vector.X, Y * vector.Y, Z);
	}

	
	/** Divide this vector by the given vector */
	public Vector3 div(Vector2 vector)
	{
		return new Vector3(X / vector.X, Y / vector.Y, Z);
	}
	
	
	
	
	
	

	
	
	/** multiply by scalar */
	public Vector3 mulScalar(float value)
	{
		return new Vector3(X * value, Y * value, Z * value);
	}
	
	
	/** multiply by scalar */
	public Vector3 mulScalar(float x, float y, float z)
	{
		return new Vector3(X * x, Y * y, Z * z);
	}
	
	
	
	
	/** divide by scalar */
	public Vector3 divScalar(float value)
	{
		return new Vector3(X / value, Y / value, Z / value);
	}
	
	
	/** divide by scalar */
	public Vector3 divScalar(float x, float y, float z)
	{
		return new Vector3(X / x, Y / y, Z / z);
	}
	
	
	
	
	

	
	
	
	/**
	 * dot product
	 */
	public float dot(Vector3 vector)
	{
		return (X * vector.X) + (Y * vector.Y) + (Z * vector.Z);
	}
	
	
	
	/**
	 * cross product
	 */
	public Vector3 cross(Vector3 vector)
	{
		float Cx = (Y * vector.Z) - (Z * vector.Y);
		float Cy = (Z * vector.X) - (X * vector.Z);
		float Cz = (X * vector.Y) - (Y * vector.X);
		return new Vector3(Cx, Cy, Cz);
	}
	
	
	
	
	

	
	
	
	/** Square the vector's components */
	public Vector3 square()
	{
		return new Vector3(X * X, Y * Y, Z * Z);
	}
	
	
	
	/** Inverse the vector's components */
	public Vector3 inverse()
	{
		return new Vector3(1.0f / X, 1.0f / Y, 1.0f / Z);
	}
	
	
	
	/** Raise the vector's components to a given power */
	public Vector3 toPowerOf(int power)
	{
		float x = 1, y = 1, z = 1;
		
		//base case
		if (power == 0)
			return new Vector3(x, y, z);
		
		//is power less than 0?
		if (power < 0)
		{			
			for (int i = 0; i > power; i--)
			{
				x /= X;
				y /= Y;
				z /= Z;
			}
		}
		
		//else, it's greater than
		else
		{
			for (int i = 0; i < power; i++)
			{
				x *= X;
				y *= Y;
				z *= Z;
			}
		}
		
		//return
		return new Vector3(x, y, z);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns string representation of this vector
	 */
	public String toString()
	{
		return "(X = " + Float.toString(X) + ", Y = " + Float.toString(Y) + ", Z = " + Float.toString(Z) + ")";
	}
	
	
	
	
	
	

}
