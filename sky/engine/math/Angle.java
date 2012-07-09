package sky.engine.math;

/**
 * This class is abstract and helps make accessing angles faster. To do this, we store,
 * say, 360 angle values of Sin, Cos and Tan into an indexable array.
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Angle
{
	/**
	 * Convert degrees to Radians.
	 */
	public static final float TO_RADIANS = 0.0174532925f;
	
	
	/**
	 * Convert Radians to Degrees.
	 */
	public static final float TO_DEGREES = 57.2957795f;
	
	
	/**
	 * 360 degrees of SINE
	 */
	private static float[] SINE = null;
	
	
	/**
	 * 360 degrees of COSINE
	 */
	private static float[] COSINE = null;
	
	
	/**
	 * 360 degrees of TAN
	 */
	private static float[] TANGENT = null;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialise the SINE, COSINE and TANGENT arrays
	 */
	private static void initialise()
	{
		//initialise arrays
		SINE = new float[360];
		COSINE = new float[360];
		TANGENT = new float[360];
		
		
		//fill them
		for (int i = 0; i < 360; i++)
		{
			SINE[i] = android.util.FloatMath.sin(i * TO_RADIANS);
			COSINE[i] = android.util.FloatMath.cos(i * TO_RADIANS);
			TANGENT[i] = (float)Math.tan(i * TO_RADIANS);
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Refine a given degree to between 0-359
	 */
	public static int confineDegree(int degree)
	{
		while (degree < 0 || degree >= 360)
		{
			if (degree < 0)
				degree = 360 + degree;
			if (degree >= 360)
				degree = degree - 360;
		}
		
		return degree;
	}
	
	
	
	
	
	
	
	/**
	 * Return the value of sin(degree)
	 */
	public static float sin(float degree)
	{
		//do we need to initialise the arrays?
		if (SINE == null)
			initialise();
		
		//get the sine value wanted
		int deg = (int)degree;
		deg = confineDegree(deg);
		return SINE[deg];
	}
	
	
	
	
	
	
	
	/**
	 * Return the value of sin(radians)
	 */
	public static float sinr(float radians)
	{
		//do we need to initialise the arrays?
		if (SINE == null)
			initialise();
		
		//get the sine value wanted
		int deg = (int)(radians * TO_DEGREES);
		deg = confineDegree(deg);
		return SINE[deg];
	}
	
	
	
	
	
	
	
	/**
	 * Return the value of cos(degree)
	 */
	public static float cos(float degree)
	{
		//do we need to initialise the arrays?
		if (COSINE == null)
			initialise();
		
		//get the cosine value wanted
		int deg = (int)degree;
		deg = confineDegree(deg);
		return COSINE[deg];
	}
	
	
	
	
	
	
	
	/**
	 * Return the value of cos(radians)
	 */
	public static float cosr(float radians)
	{
		//do we need to initialise the arrays?
		if (COSINE == null)
			initialise();
		
		//get the cosine value wanted
		int deg = (int)(radians * TO_DEGREES);
		deg = confineDegree(deg);
		return COSINE[deg];
	}
	
	
	
	
	
	
	
	/**
	 * Return the value of tan(degree)
	 */
	public static float tan(float degree)
	{
		//do we need to initialise the arrays?
		if (TANGENT == null)
			initialise();
		
		//get the tangent value wanted
		int deg = (int)degree;
		deg = confineDegree(deg);
		return TANGENT[deg];
	}
	
	
	
	
	
	
	
	/**
	 * Return the value of tan(radians)
	 */
	public static float tanr(float radians)
	{
		//do we need to initialise the arrays?
		if (TANGENT == null)
			initialise();
		
		//get the tangent value wanted
		int deg = (int)(radians * TO_DEGREES);
		deg = confineDegree(deg);
		return TANGENT[deg];
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Get the desired angle of ARCTAN from the given opp and adj
	 */
	public static float arctan(float opp, float adj)
	{
		if (adj < 0.0)
			return -(float)(Math.atan(opp/adj) * TO_DEGREES);
		else
			return -(float)(Math.atan(opp/adj) * TO_DEGREES) + 180;
	}
	
	
	/**
	 * 
	 */
	public static float arctan(float value)
	{
		return -(float)(Math.atan(value) * TO_DEGREES) + 180;
	}
	
	
	
	
	

}
