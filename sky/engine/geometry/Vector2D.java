package sky.engine.geometry;

import sky.engine.math.Angle;


/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Vector2D extends Vector
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
	 * A vector of zeros
	 */
	public static final Vector2D Zeros = new Vector2D(0, 0);
	
	
	
	
	
	
	
	
	
	
	


	
	/**
	 * Create a new 2D Vector object
	 */
	public Vector2D()
	{
		X = 0;
		Y = 0;
		vector_type = Vector.VECTOR_2D;
	}

	
	/**
	 * Create a new 2D Vector object
	 */
	public Vector2D(float x, float y)
	{
		X = x;
		Y = y;
		vector_type = Vector.VECTOR_2D;
	}

	
	/**
	 * Create a new 2D Vector object
	 */
	public Vector2D(Vector2D vector)
	{
		X = vector.X;
		Y = vector.Y;
		vector_type = Vector.VECTOR_2D;
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
	public void set(Vector2D vector)
	{
		X = vector.X;
		Y = vector.Y;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Clone this vector
	 */
	public Vector2D clone()
	{
		return new Vector2D(this.X, this.Y);
	}
	
	
	/**
	 * Clones the given vector array
	 */
	public static Vector2D[] clone(Vector2D[] vectors)
	{
		Vector2D[] v = new Vector2D[vectors.length];
		
		for (int i = 0; i < vectors.length; i++)
		{
			v[i].X = vectors[i].X;
			v[i].Y = vectors[i].Y;
		}
		
		return v;
	}
	
	
	
	

	

	
	
	
	
	/**
	 * Does the passed vector equal this one?
	 */
	public boolean equals(Vector2D v2)
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
			Vector2D v2 = (Vector2D)o;
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
	public int compareTo(Vector2D v2)
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
	 * Returns the magnitude of this vector (basically just the length from (0,0)).
	 */
	public float magnitude()
	{
		return (float)Math.sqrt((X * X) + (Y * Y));
	}
	
	
	/**
	 * Returns the magnitude of the distance between this vector and another.
	 */
	public float magnitude(Vector2D v2)
	{
		float x = X - v2.X;
		float y = Y - v2.Y;
		
		return (float)Math.sqrt((x * x) + (y * y));
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
	public float squaredMagnitude(Vector2D v2)
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
	public Vector2D midpoint(Vector2D v2)
	{
		return new Vector2D( (X + v2.X) * 0.5f, (Y + v2.Y) * 0.5f ); 
	}
	
	
	
	
	
	
	
	/**
	 * Static method. Given an array of vectors, returns the centre of them all.
	 * For example, the 4 vertices of a square will return the centre point of
	 * the square.
	 */
	public static Vector2D getCentre(Vector2D[] vectors)
	{
		Vector2D centre = new Vector2D();
		
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
	public void rotate(float degree, Vector2D origin)
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
	public void rotate(Vector2D vector, float x, float y)
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
	public void rotate(Vector2D vector, Vector2D origin)
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
	public void integrate(Vector2D velocity)
	{
		X += velocity.X;
		Y += velocity.Y;
	}
	
	
	
	
	
	
	
	

	
	/**
	 * Returns this vector's left-winding perpendicular
	 */
	public Vector2D leftPerp()
	{
		return new Vector2D(-this.Y, this.X);
	}
	
	
	/**
	 * Returns this vector's right-winding perpendicular
	 */
	public Vector2D rightPerp()
	{
		return new Vector2D(this.Y, -this.X);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*******************************************
	 *               OPERATORS
	 *******************************************/
	
	/**
	 * add by another vector
	 */
	public Vector2D add(Vector2D vector)
	{
		return new Vector2D(X + vector.X, Y + vector.Y);
	}
	

	/**
	 * subtract by another vector
	 */
	public Vector2D sub(Vector2D vector)
	{
		return new Vector2D(X - vector.X, Y - vector.Y);
	}
	

	/**
	 * multiply by another vector
	 */
	public Vector2D mul(Vector2D vector)
	{
		return new Vector2D(X * vector.X, Y * vector.Y);
	}
	

	/**
	 * divide by another vector
	 */
	public Vector2D div(Vector2D vector)
	{
		return new Vector2D(X / vector.X, Y / vector.Y);
	}
	
	
	
	
	
	

	
	
	/**
	 * multiply by scalar
	 */
	public Vector2D mulScalar(float value)
	{
		return new Vector2D(X * value, Y * value);
	}
	
	
	/**
	 * multiply by scalar
	 */
	public Vector2D mulScalar(float x, float y)
	{
		return new Vector2D(X * x, Y * y);
	}
	

	
	
	/**
	 * divide by scalar
	 */
	public Vector2D divScalar(float value)
	{
		return new Vector2D(X / value, Y / value);
	}
	
	
	/**
	 * divide by scalar
	 */
	public Vector2D divScalar(float x, float y)
	{
		return new Vector2D(X / x, Y / y);
	}
	

	
	
	/**
	 * add by scalar
	 */
	public Vector2D addScalar(float value)
	{
		return new Vector2D(X + value, Y + value);
	}
	
	
	/**
	 * add by scalar
	 */
	public Vector2D addScalar(float x, float y)
	{
		return new Vector2D(X + x, Y + y);
	}
	

	
	
	/**
	 * sub by scalar
	 */
	public Vector2D subScalar(float value)
	{
		return new Vector2D(X - value, Y - value);
	}
	
	
	/**
	 * sub by scalar
	 */
	public Vector2D subScalar(float x, float y)
	{
		return new Vector2D(X - x, Y - y);
	}
	
	
	
	
	

	
	
	
	/**
	 * dot product
	 */
	public float dot(Vector2D vector)
	{
		return (X * vector.X) + (Y * vector.Y);
	}
	
	
	
	/**
	 * cross product
	 */
	public float cross(Vector2D vector)
	{
		return ((X * vector.Y) - (Y * vector.X));
	}
	
	
	
	
	

	
	
	
	/**
	 * Square the vector's components
	 */
	public Vector2D square()
	{
		return new Vector2D(X * X, Y * Y);
	}
	
	
	
	/**
	 * Inverse the vector's components
	 */
	public Vector2D inverse()
	{
		return new Vector2D(1.0f / X, 1.0f / Y);
	}
	
	
	
	/**
	 * Raise the vector's components to a given power
	 */
	public Vector2D toPowerOf(int power)
	{
		float x = 1, y = 1;
		
		//base case
		if (power == 0)
			return new Vector2D(x, y);
		
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
		return new Vector2D(x, y);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns string representation of this vector
	 */
	public String toString()
	{
		return "(X = " + Float.toString(X) + ", Y = " + Float.toString(Y) + ")";
	}
	
	
	
	
	
	

}
