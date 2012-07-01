package sky.engine.geometry;

import sky.engine.math.Angle;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Vector3D extends Vector
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
	 * Create a new 3D Vector object
	 */
	public Vector3D()
	{
		X = 0;
		Y = 0;
		Z = 0;
		vector_type = Vector.VECTOR_3D;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3D(float x, float y, float z)
	{
		X = x;
		Y = y;
		Z = z;
		vector_type = Vector.VECTOR_3D;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3D(Vector2D vector)
	{
		X = vector.X;
		Y = vector.Y;
		Z = 0;
		vector_type = Vector.VECTOR_3D;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3D(Vector2D vector, float z)
	{
		X = vector.X;
		Y = vector.Y;
		Z = z;
		vector_type = Vector.VECTOR_3D;
	}

	
	/**
	 * Create a new 3D Vector object
	 */
	public Vector3D(Vector3D vector)
	{
		X = vector.X;
		Y = vector.Y;
		Z = vector.Z;
		vector_type = Vector.VECTOR_3D;
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
	public void set(Vector2D vector, float z)
	{
		X = vector.X;
		Y = vector.Y;
		Z = z;
	}
	
	
	/**
	 * Set X, Y and Z components
	 */
	public void set(Vector3D vector)
	{
		X = vector.X;
		Y = vector.Y;
		Z = vector.Z;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this vector
	 */
	public Vector3D clone()
	{
		return new Vector3D(this.X, this.Y, this.Z);
	}
	
	
	/**
	 * Clones the given vector array
	 */
	public static Vector3D[] clone(Vector3D[] vectors)
	{
		Vector3D[] v = new Vector3D[vectors.length];
		
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
			Vector3D v2 = (Vector3D)o;
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
	public int compareTo(Vector3D v2)
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
	public static Vector3D zeros()
	{
		return new Vector3D(0, 0, 0);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * the magnitude of this vector.
	 */
	public float magnitude()
	{
		return (float)Math.sqrt((X * X) + (Y * Y) + (Z * Z));
	}
	
	
	/**
	 * Returns the magnitude of the distance between this vector and another.
	 */
	public float magnitude(Vector3D v2)
	{
		float x = X - v2.X;
		float y = Y - v2.Y;
		float z = Z - v2.Z;
		
		return (float)Math.sqrt((x * x) + (y * y) + (z * z));
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
	public float squaredMagnitude(Vector3D v2)
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
	public Vector3D midpoint(Vector3D v2)
	{
		return new Vector3D( (X + v2.X) * 0.5f, (Y + v2.Y) * 0.5f, (Z + v2.Z) * 0.5f  ); 
	}
	
	
	
	
	
	
	
	/**
	 * Static method. Given an array of vectors, returns the centre of them all.
	 * For example, the 8 vertices of a cube will return the centre point of
	 * the cube.
	 */
	public static Vector3D getCentre(Vector3D[] vectors)
	{
		Vector3D centre = new Vector3D();
		
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
	public void integrate(Vector2D velocity)
	{
		X += velocity.X;
		Y += velocity.Y;
	}
	
	
	/**
	 * Integrate this vector by given velocity
	 */
	public void integrate(Vector3D velocity)
	{
		X += velocity.X;
		Y += velocity.Y;
		Z += velocity.Z;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*******************************************
	 *               OPERATORS
	 *******************************************/
	
	/** Add a vector to this vector */
	public Vector3D add(Vector3D vector)
	{
		return new Vector3D(X + vector.X, Y + vector.Y, Z + vector.Z);
	}

	
	/** Subtract the given vector from this vector */
	public Vector3D sub(Vector3D vector)
	{
		return new Vector3D(X - vector.X, Y - vector.Y, Z - vector.Z);
	}

	
	/** Multiply a vector to this vector */
	public Vector3D mul(Vector3D vector)
	{
		return new Vector3D(X * vector.X, Y * vector.Y, Z * vector.Z);
	}

	
	/** Divide this vector by the given vector */
	public Vector3D div(Vector3D vector)
	{
		return new Vector3D(X / vector.X, Y / vector.Y, Z / vector.Z);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/** Add a vector to this vector */
	public Vector3D add(Vector2D vector)
	{
		return new Vector3D(X + vector.X, Y + vector.Y, Z);
	}

	
	/** Subtract the given vector from this vector */
	public Vector3D sub(Vector2D vector)
	{
		return new Vector3D(X - vector.X, Y - vector.Y, Z);
	}

	
	/** Multiply a vector to this vector */
	public Vector3D mul(Vector2D vector)
	{
		return new Vector3D(X * vector.X, Y * vector.Y, Z);
	}

	
	/** Divide this vector by the given vector */
	public Vector3D div(Vector2D vector)
	{
		return new Vector3D(X / vector.X, Y / vector.Y, Z);
	}
	
	
	
	
	
	

	
	
	/** multiply by scalar */
	public Vector3D mulScalar(float value)
	{
		return new Vector3D(X * value, Y * value, Z * value);
	}
	
	
	/** multiply by scalar */
	public Vector3D mulScalar(float x, float y, float z)
	{
		return new Vector3D(X * x, Y * y, Z * z);
	}
	
	
	
	
	/** divide by scalar */
	public Vector3D divScalar(float value)
	{
		return new Vector3D(X / value, Y / value, Z / value);
	}
	
	
	/** divide by scalar */
	public Vector3D divScalar(float x, float y, float z)
	{
		return new Vector3D(X / x, Y / y, Z / z);
	}
	
	
	
	
	

	
	
	
	/**
	 * dot product
	 */
	public float dot(Vector3D vector)
	{
		return (X * vector.X) + (Y * vector.Y) + (Z * vector.Z);
	}
	
	
	
	/**
	 * cross product
	 */
	public Vector3D cross(Vector3D vector)
	{
		float Cx = (Y * vector.Z) - (Z * vector.Y);
		float Cy = (Z * vector.X) - (X * vector.Z);
		float Cz = (X * vector.Y) - (Y * vector.X);
		return new Vector3D(Cx, Cy, Cz);
	}
	
	
	
	
	

	
	
	
	/** Square the vector's components */
	public Vector3D square()
	{
		return new Vector3D(X * X, Y * Y, Z * Z);
	}
	
	
	
	/** Inverse the vector's components */
	public Vector3D inverse()
	{
		return new Vector3D(1.0f / X, 1.0f / Y, 1.0f / Z);
	}
	
	
	
	/** Raise the vector's components to a given power */
	public Vector3D toPowerOf(int power)
	{
		float x = 1, y = 1, z = 1;
		
		//base case
		if (power == 0)
			return new Vector3D(x, y, z);
		
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
		return new Vector3D(x, y, z);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns string representation of this vector
	 */
	public String toString()
	{
		return "(X = " + Float.toString(X) + ", Y = " + Float.toString(Y) + ", Z = " + Float.toString(Z) + ")";
	}
	
	
	
	
	
	

}
