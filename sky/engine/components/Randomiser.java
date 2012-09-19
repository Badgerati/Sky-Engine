package sky.engine.components;

import java.util.Random;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class Randomiser
{
	
	/**
	 * Random object to use
	 */
	private static Random rand = new Random();
	
	
	
	
	/**
	 * Initialise the Randomiser
	 */
	public static void initialise()
	{
		rand= new Random();
	}
	
	
	
	
	/**
	 * Re-seed the randomiser
	 */
	public static void reseed()
	{
		rand = new Random();
	}
	
	
	
	
	/**
	 * Returns a random boolean of either true or false
	 */
	public boolean getBool()
	{
		return rand.nextBoolean();
	}
	
	
	
	
	
	/**
	 * Returns some random integer value
	 */
	public static int getInt()
	{
		return rand.nextInt();
	}
	
	
	
	
	
	/**
	 * Returns a random integer from 0-max
	 */
	public static int getInt(int max)
	{
		return rand.nextInt(max);
	}
	
	
	
	
	
	/**
	 * Returns an integer value within the range min-max
	 */
	public static int getInt(int min, int max)
	{
		float ran = rand.nextFloat();
		int range = (max - min);
		
		return (min + (int)(ran * range));
	}
	
	
	
	
	
	/**
	 * Return a float value between 0-1
	 */
	public static float getFloat()
	{
		return rand.nextFloat();
	}
	
	
	
	
	
	/**
	 * Return a float value between 0-max
	 */
	public static float getFloat(float max)
	{
		return (rand.nextFloat() * max);
	}
	
	
	
	
	/**
	 * Return a float value between min-max
	 */
	public static float getFloat(float min, float max)
	{
		float ran = rand.nextFloat();
		float range = (max - min);
		
		return (min + (ran * range));
	}
	
	
	
	
	
	/**
	 * Return a double value between 0-1
	 */
	public static double getDouble()
	{
		return rand.nextDouble();
	}
	
	
	
	
	
	/**
	 * Return a double value between 0-max
	 */
	public static double getDouble(double max)
	{
		return (rand.nextDouble() * max);
	}
	
	
	
	
	/**
	 * Return a double value between min-max
	 */
	public static double getDouble(double min, double max)
	{
		double ran = rand.nextDouble();
		double range = (max - min);
		
		return (min + (ran * range));
	}
	
	
}
