package sky.engine.physics;

import sky.engine.geometry.Angle;
import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Momentum
{
	/**
	 * constant mass
	 */
	private static float CONSTANT_MASS = 0.5f;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Given a velocity and mass, return momentum as vector
	 */
	public static Vector2D asVector(Vector2D velocity, float mass)
	{
		return new Vector2D(mass * velocity.X, mass * velocity.Y);
	}
	
	public static Vector2D asVector(Vector2D[] velocities, float[] masses)
	{
		if (velocities.length != masses.length)
			return null;
		
		Vector2D totalP = new Vector2D();
		
		for (int i = 0; i < velocities.length; i++)
		{
			totalP.X += (velocities[i].X * masses[i]);
			totalP.Y += (velocities[i].Y * masses[i]);
		}
		
		return totalP;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Given the velocity and mass, return momentum as magnitude
	 */
	public static float asMagnitude(Vector2D velocity, float mass)
	{
		float pX = mass * velocity.X;
		float pY = mass * velocity.Y;
		return (float)Math.sqrt( (pX*pX) + (pY*pY) );
	}
	
	public static float asMagnitude(Vector2D[] velocities, float[] masses)
	{
		Vector2D totalP = asVector(velocities, masses);
		if (totalP == null)
			return 0.0f;
		
		return (float)Math.sqrt( (totalP.X * totalP.X) + (totalP.Y*totalP.Y) );
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Given a momentum vector, return angle of direction of momentum
	 */
	public static float asAngle(Vector2D momentum)
	{
		return Angle.arctan(momentum.X, -momentum.Y);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Given 2 velocities and masses, calculate the velocities after an elastic collision
	 */	
	public static Vector2D[] elasticCollision(Vector2D vel1, float mass1, Vector2D vel2, float mass2)
	{		
		Vector2D initP = new Vector2D( (vel1.X * mass1) + (vel2.X * mass2),
							(vel1.Y * mass1) + (vel2.Y * mass2) );
		
		Vector2D initV = new Vector2D( -(vel2.X - vel1.X), -(vel2.Y - vel1.Y) );
		
		Vector2D finalVa = new Vector2D( (initP.X - (mass2 * initV.X)) / (mass1 + mass2), (initP.Y - (mass2 * initV.Y)) / (mass1 + mass2) );
		Vector2D finalVb = new Vector2D( (initP.X - (mass1 * finalVa.X)) / mass2, (initP.Y - (mass1 * finalVa.Y)) / mass2 );
		
		return new Vector2D[] { finalVa, finalVb };
	}
	
	
	
	
	
	
	
	
	/**
	 * Given 2 velocities, calculate the velocities after an elastic collision with constant mass
	 */
	public static Vector2D[] elasticCollision(Vector2D vel1, Vector2D vel2)
	{		
		Vector2D initP = new Vector2D( (vel1.X * CONSTANT_MASS) + (vel2.X * CONSTANT_MASS),
							(vel1.Y * CONSTANT_MASS) + (vel2.Y * CONSTANT_MASS) );
		
		Vector2D initV = new Vector2D( -(vel2.X - vel1.X), -(vel2.Y - vel1.Y) );
		
		Vector2D finalVa = new Vector2D( (initP.X - (CONSTANT_MASS * initV.X)), (initP.Y - (CONSTANT_MASS * initV.Y)) );
		Vector2D finalVb = new Vector2D( (initP.X - (CONSTANT_MASS * finalVa.X)) * 2.0f, (initP.Y - (CONSTANT_MASS * finalVa.Y)) * 2.0f );
		
		return new Vector2D[] { finalVa, finalVb };
		
	}
	
	
	
	
	

}