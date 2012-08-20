package sky.engine.geometry.vectors;

import java.util.Comparator;

import sky.engine.math.Angle;


/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Vector2 implements Comparable<Vector2>
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
	 * Comparator object for a Vector2D.	
	 */
	public static final Comparator<Vector2> VECTOR2_COMPARATOR = new Comparator<Vector2>() {
		public int compare(Vector2 v1, Vector2 v2) {
			return v1.compareTo(v2);
		}
	};
	
	
	
	
	


	
	/**
	 * Create a new 2D Vector object
	 */
	public Vector2()
	{
		X = 0;
		Y = 0;
	}

	
	/**
	 * Create a new 2D Vector object
	 */
	public Vector2(float x, float y)
	{
		X = x;
		Y = y;
	}

	
	/**
	 * Create a new 2D Vector object
	 */
	public Vector2(Vector2 vector)
	{
		X = vector.X;
		Y = vector.Y;
	}
	
	
	
	
	
	
	/**
	 * Set X and Y components
	 */
	public void set(float x, float y)
	{
		X = x;
		Y = y;
	}
	
	
	
	
	
	/**
	 * Set X and Y components
	 */
	public void set(Vector2 vector)
	{
		X = vector.X;
		Y = vector.Y;
	}
	
	
	
	
	
	/**
	 * Clone this vector
	 */
	public Vector2 clone()
	{
		return new Vector2(this.X, this.Y);
	}
	
	
	
	
	
	/**
	 * Clones the given vector array
	 */
	public static Vector2[] clone(Vector2[] vectors)
	{
		Vector2[] v = new Vector2[vectors.length];
		
		for (int i = 0; i < vectors.length; i++)
		{
			v[i] = vectors[i].clone();
		}
		
		return v;
	}
	
	
	
	

	
	/**
	 * Does the passed vector equal this one?
	 */
	public boolean equals(Vector2 v2)
	{		
		return (X == v2.X && Y == v2.Y);
	}
	

	
	
	
	
	/**
	 * Does the passed components equal this vector's components?
	 */
	public boolean equals(float x, float y)
	{		
		return (X == x && Y == y);
	}
	
	
	
	
	
	
	/**
	 * Does the passed object equal this vector?
	 */
	@Override
	public boolean equals(Object o)
	{
		try
		{
			Vector2 v2 = (Vector2)o;
			return (X == v2.X && Y == v2.Y);
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
	public int compareTo(Vector2 v2)
	{
		//greater than given
		if  (X > v2.X || (Y > v2.Y && X == v2.X))
			return 1;
		
		//less than given
		else if (X < v2.X || (Y < v2.Y && X == v2.X))
			return -1;
		
		//else, equal
		return 0;
	}
	
	
	
	
	
	/**
	 * Compare the X value to the given vector's X values. Returns 0 if equal, 1 if
	 * this is greater than given, -1 otherwise
	 */
	public int compareX(Vector2 v2)
	{
		if (X > v2.X)
			return 1;
		
		else if (X < v2.X)
			return -1;
		
		return 0;
	}
	
	
	
	
	
	/**
	 * Compare the Y value to the given vector's Y values. Returns 0 if equal, 1 if
	 * this is greater than given, -1 otherwise
	 */
	public int compareY(Vector2 v2)
	{
		if (Y > v2.Y)
			return 1;
		
		else if (Y < v2.Y)
			return -1;
		
		return 0;
	}

	
	
	
	
	
	/**
	 * Generate a hash code for this vector
	 */
	@Override
	public int hashCode()
	{
		return (int)((X * Y) + (X + Y));
	}


	
	
	
	/**
	 * Absolute this vector, making both components positive
	 */
	public void absolute()
	{
		if (X < 0) X *= -1;
		if (Y < 0) Y *= -1;
	}
	
	
	
	
	
	
	/**
	 * Negates this vector's components
	 */
	public void negate()
	{
		X = -X;
		Y = -Y;
	}
	
	
	
	
	
	/**
	 * Returns a vector of zeros
	 */
	public static Vector2 zeros()
	{
		return new Vector2(0, 0);
	}
	
	
	
	
	
	
	/**
	 * Returns the magnitude of this vector (basically just the length from (0,0)).
	 */
	public float magnitude()
	{
		return android.util.FloatMath.sqrt((X * X) + (Y * Y));
	}
	
	
	
	
	
	/**
	 * Returns the magnitude of the distance between this vector and another.
	 */
	public float magnitude(Vector2 v2)
	{
		float x = X - v2.X;
		float y = Y - v2.Y;
		
		return android.util.FloatMath.sqrt((x * x) + (y * y));
	}
	
	
	
	
	
	/**
	 * Returns the squared magnitude of this vector.
	 */
	public float squaredMagnitude()
	{		
		return ((X * X) + (Y * Y));
	}
	
	
	
	
	
	/**
	 * Returns the squared magnitude of this vector to another.
	 */
	public float squaredMagnitude(Vector2 v2)
	{
		float x = X - v2.X;
		float y = Y - v2.Y;
		
		return ((x * x) + (y * y));
	}
	
	
	
	
	
	
	/**
	 * Normalise this vector
	 */
	public void normalise()
	{
		float mag = this.magnitude();
		X = X / mag;
		Y = Y / mag;
	}
	
	
	
	
	
	/**
	 * Returns the midpoint of this vector to another vector
	 */
	public Vector2 midpoint(Vector2 v2)
	{
		return new Vector2( (X + v2.X) * 0.5f, (Y + v2.Y) * 0.5f ); 
	}
	
	
	
	
	
	
	/**
	 * Static method. Given an array of vectors, returns the centre of them all.
	 * For example, the 4 vertices of a square will return the centre point of
	 * the square.
	 */
	public static Vector2 getCentre(Vector2[] vectors)
	{
		Vector2 centre = new Vector2();
		
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
	public float angle()
	{
		return Angle.arctan(X, -Y);
	}
	
	
	
	
		
	/**
	 * Rotates this vector about the given origin by the given degree.
	 */
	public void rotate(float degree, float x, float y)
	{
		float sinA = Angle.sin(degree);
		float cosA = Angle.cos(degree);

		float Xoffset = X - x;
		float Yoffset = Y - y;

		float newX = (Xoffset * cosA) - (Yoffset * sinA);
		float newY = (Xoffset * sinA) + (Yoffset * cosA);

		X = newX + x;
		Y = newY + y;
	}
	
	
	
	
	
	/**
	 * Rotates this vector about the given origin by the given degree.
	 */
	public void rotate(float degree, Vector2 origin)
	{
		float sinA = Angle.sin(degree);
		float cosA = Angle.cos(degree);

		float Xoffset = X - origin.X;
		float Yoffset = Y - origin.Y;

		float newX = (Xoffset * cosA) - (Yoffset * sinA);
		float newY = (Xoffset * sinA) + (Yoffset * cosA);

		X = newX + origin.X;
		Y = newY + origin.Y;
	}
	
	
	
	
	
	
	/**
	 * Rotate this vector on a given origin by a given vector
	 */
	public void rotate(Vector2 vector, float x, float y)
	{
		float Xoffset = X - x;
		float Yoffset = Y - y;
		
		float newX = (Xoffset * vector.Y) - (Yoffset * vector.X);
		float newY = (Xoffset * vector.X) + (Yoffset * vector.Y);
		
		X = newX + x;
		Y = newY + y;
	}
	
	
	
	
	
	/**
	 * Rotate this vector on a given origin by a given vector
	 */
	public void rotate(Vector2 vector, Vector2 origin)
	{
		float Xoffset = X - origin.X;
		float Yoffset = Y - origin.Y;
		
		float newX = (Xoffset * vector.Y) - (Yoffset * vector.X);
		float newY = (Xoffset * vector.X) + (Yoffset * vector.Y);
		
		X = newX + origin.X;
		Y = newY + origin.Y;
	}
	
	

	
	
	/**
	 * Integrate this vector by given velocity
	 */
	public void integrate(float x, float y)
	{
		X += x;
		Y += y;
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
	 * Returns this vector's left-winding perpendicular
	 */
	public Vector2 leftPerp()
	{
		return new Vector2(-this.Y, this.X);
	}
	
	
	
	
	
	/**
	 * Returns this vector's right-winding perpendicular
	 */
	public Vector2 rightPerp()
	{
		return new Vector2(this.Y, -this.X);
	}
	
	
	
	
	
	
	/*******************************************
	 *               OPERATORS
	 *******************************************/
	
	/**
	 * add by another vector
	 */
	public Vector2 add(Vector2 vector)
	{
		return new Vector2(X + vector.X, Y + vector.Y);
	}
	

	/**
	 * subtract by another vector
	 */
	public Vector2 sub(Vector2 vector)
	{
		return new Vector2(X - vector.X, Y - vector.Y);
	}
	

	/**
	 * multiply by another vector
	 */
	public Vector2 mul(Vector2 vector)
	{
		return new Vector2(X * vector.X, Y * vector.Y);
	}
	

	/**
	 * divide by another vector
	 */
	public Vector2 div(Vector2 vector)
	{
		return new Vector2(X / vector.X, Y / vector.Y);
	}
	
	
	
	
	
	/**
	 * multiply by scalar
	 */
	public Vector2 mulScalar(float value)
	{
		return new Vector2(X * value, Y * value);
	}
	
	
	/**
	 * multiply by scalar
	 */
	public Vector2 mul(float x, float y)
	{
		return new Vector2(X * x, Y * y);
	}
	

	
	
	/**
	 * divide by scalar
	 */
	public Vector2 divScalar(float value)
	{
		return new Vector2(X / value, Y / value);
	}
	
	
	/**
	 * divide by scalar
	 */
	public Vector2 div(float x, float y)
	{
		return new Vector2(X / x, Y / y);
	}
	

	
	
	/**
	 * add by scalar
	 */
	public Vector2 addScalar(float value)
	{
		return new Vector2(X + value, Y + value);
	}
	
	
	/**
	 * add by scalar
	 */
	public Vector2 add(float x, float y)
	{
		return new Vector2(X + x, Y + y);
	}
	

	
	
	/**
	 * sub by scalar
	 */
	public Vector2 subScalar(float value)
	{
		return new Vector2(X - value, Y - value);
	}
	
	
	/**
	 * sub by scalar
	 */
	public Vector2 sub(float x, float y)
	{
		return new Vector2(X - x, Y - y);
	}
	
	
	

	
	
	/**
	 * dot product
	 */
	public float dot(Vector2 vector)
	{
		return (X * vector.X) + (Y * vector.Y);
	}
	
	
	
	/**
	 * dot product
	 */
	public float dot(float x, float y)
	{
		return (X * x) + (Y * y);
	}
	
	
	
	/**
	 * cross product
	 */
	public float cross(Vector2 vector)
	{
		return ((X * vector.Y) - (Y * vector.X));
	}
	
	
	
	/**
	 * cross product
	 */
	public float cross(float x, float y)
	{
		return ((X * y) - (Y * x));
	}
	
	
	
	
	/**
	 * Square the vector's components
	 */
	public Vector2 square()
	{
		return new Vector2(X * X, Y * Y);
	}
	
	
	
	/**
	 * Inverse the vector's components
	 */
	public Vector2 inverse()
	{
		return new Vector2(1.0f / X, 1.0f / Y);
	}
	
	
	
	/**
	 * Raise the vector's components to a given power
	 */
	public Vector2 toPowerOf(int power)
	{
		float x = 1, y = 1;
		
		//base case
		if (power == 0)
			return new Vector2(x, y);
		
		//is power less than 0?
		if (power < 0)
		{			
			for (int i = 0; i > power; i--)
			{
				x /= X;
				y /= Y;
			}
		}
		
		//else, it's greater than
		else
		{
			for (int i = 0; i < power; i++)
			{
				x *= X;
				y *= Y;
			}
		}
		
		//return
		return new Vector2(x, y);
	}
	
	
	
	
	
	/**
	 * Returns string representation of this vector
	 */
	public String toString()
	{
		return "(X = " + Float.toString(X) + ", Y = " + Float.toString(Y) + ")";
	}
	
	

}
