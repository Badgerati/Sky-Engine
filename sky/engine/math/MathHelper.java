package sky.engine.math;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class MathHelper
{
	
	/**
	 * Constant for PI
	 */
	public static final float PI = 3.141592653589793f;
	
	
	/**
	 * Constant for the Exponential function
	 */
	public static final float E = 2.718281828459045f;
	
	
	/**
	 * Constant for the Golden Ratio
	 */
	public static final float GOLDEN_RATIO = 1.61803398875f;
	
	
	/**
	 * Constant for an array of the first twenty prime numbers, starting from 2
	 */
	public static final int[] FIRST_TWENTY_PRIMES = new int[] { 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71 };
	
	
	
	
	
	
	
	/**
	 * Clamps the given value between the min and max
	 */
	public static float clamp(float value, float min, float max)
	{
		if (value > max) return max;
		if (value < min) return min;
		return value;
	}
	
	
	
	
	/**
	 * Returns the circumference of a circle
	 */
	public static float circumference(float radius)
	{
		return PI * radius * 2.0f;
	}
	
	
	
	
	
	/**
	 * Returns the minimum of the three given values
	 */
	public static float min(float val1, float val2, float val3)
	{
		float val = val1;
		
		if (val2 < val) val = val2;
		if (val3 < val) val = val3;
		
		return val;
	}
	
	
	
	
	
	/**
	 * Returns the minimum of an array of values
	 */
	public static float min(float[] values)
	{
		if (values == null)
			throw new NullPointerException();
		
		float val = values[0];
		
		for (int i = 1; i < values.length; i++)
			if (values[i] < val) val = values[i];
		
		return val;
	}
	
	
	
	
	
	/**
	 * Returns the maximum of the three given values
	 */
	public static float max(float val1, float val2, float val3)
	{
		float val = val1;
		
		if (val2 > val) val = val2;
		if (val3 > val) val = val3;
		
		return val;
	}
	
	
	
	
	
	/**
	 * Returns the maximum of an array of values
	 */
	public static float max(float[] values)
	{
		if (values == null)
			throw new NullPointerException();
		
		float val = values[0];
		
		for (int i = 1; i < values.length; i++)
			if (values[i] > val) val = values[i];
		
		return val;
	}
	
	
}
