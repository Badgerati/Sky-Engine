package sky.engine.graphics.drawable.particles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sky.engine.geometry.vectors.Vector2D;
import sky.engine.math.Angle;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Explosion
{
	
	/**
	 * Alive and dead constants
	 */
	public static final int STATE_ALIVE = 0;
	public static final int STATE_DEAD = 1;

	
	/**
	 * Current state of the explosion
	 */
	private int explosionState;
	
	
	/**
	 * Random number generator
	 */
	private Random rand = new Random();
	
	
	/**
	 * point where explosion is to happen
	 */
	private Vector2D mOrigin = null;
	
	
	/**
	 * the particles of the explosion
	 */
	private List<Particle> mParticles = null;
	
	
	/**
	 * lifetime of the explosion
	 */
	private int mLifetime;
	
	
	/**
	 * speed of explosion
	 */
	private float mSpeed;
	
	
	/**
	 * colour of particles
	 */
	private int mColour;
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of an explosion object
	 */
	public Explosion(Vector2D position, int lifetime, int size, float speed, int colour)
	{
		explosionState = STATE_ALIVE;
		
		mOrigin = position;
		mLifetime = lifetime;
		mSpeed = speed;
		mColour = colour;
				
		mParticles = new ArrayList<Particle>();
		
		for (int i = 0; i < size; i++)
		{
			mParticles.add(generateNewParticle());
		}
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * generate a new particle
	 */
	private Particle generateNewParticle()
	{
		//position
		Vector2D position = mOrigin;
		
		//angle of trajectory
		int tempangle = rand.nextInt(359);
		Vector2D velocity = new Vector2D((float)(rand.nextDouble() * mSpeed) * Angle.sin(tempangle),
								      (float)(rand.nextDouble() * mSpeed) * Angle.cos(tempangle));
		float angle = (float)(tempangle * Angle.TO_RADIANS);
		
		//angluar
		float angular = 0.1f * (float)(rand.nextDouble() * 2 - 1);
		
		//time to live
		int ttl = mLifetime + rand.nextInt(40);
		
		//create
		return new Particle(position, velocity, angle, angular, mColour, ttl);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Is the explosion alive?
	 */
	public boolean isAlive()
	{
		return explosionState == STATE_ALIVE ? true : false;
	}
	
	
	/**
	 * Is the explosion dead?
	 */
	public boolean isDead()
	{
		return explosionState == STATE_DEAD ? true : false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Update the explosive particles
	 */
	public void update()
	{
		for (int particle = 0; particle < mParticles.size(); particle++)
		{
			mParticles.get(particle).update();
			if (mParticles.get(particle).TTL <= 0)
			{
				mParticles.remove(particle);
				particle--;
			}
		}
		
		if (mParticles.size() <= 0)
			explosionState = STATE_DEAD;		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Draw the explosive particles
	 */
	public void draw(Canvas canvas)
	{
		for (int i = 0; i < mParticles.size(); i++)
			mParticles.get(i).draw(canvas);
		
	}
	
	
	

}
