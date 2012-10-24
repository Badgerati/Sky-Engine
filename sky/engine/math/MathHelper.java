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
	public static final float EXP = 2.71828182846f;
	
	
	/**
	 * Constant for the Golden Ratio
	 */
	public static final float GOLDEN_RATIO = 1.61803398875f;
	
	
	
	
	
	
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
	
	
}
