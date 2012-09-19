package sky.engine.graphics.drawable.particles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.math.Angle;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Trail
{	
	/**
	 * Random number generator
	 */
	private Random rand = new Random();
	
	
	/**
	 * point where trail is to happen
	 */
	private Vector2 mOrigin = null;
	
	
	/**
	 * number of particles to create on each iteration
	 */
	private int toCreate;
	
	
	/**
	 * the particles of the trail
	 */
	private List<Particle> mParticles = null;
	
	
	/**
	 * lifetime of the trail
	 */
	private int mLifetime;
	
	
	/**
	 * speed of trail
	 */
	private float mSpeed;
	
	
	/**
	 * colour of the particles
	 */
	private int mColour;
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Trail object
	 */
	public Trail(Vector2 position, int lifetime, int create, float speed, int colour)
	{		
		mOrigin = position;
		toCreate = create;
		mLifetime = lifetime;
		mSpeed = speed;
		mColour = colour;
		
		mParticles = new ArrayList<Particle>();
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * generate a new particle
	 */
	private Particle generateNewParticle()
	{
		//position
		Vector2 position = mOrigin;
		
		//angle of trajectory
		int tempangle = rand.nextInt(359);
		Vector2 velocity = new Vector2((float)(rand.nextDouble() * mSpeed) * Angle.sin(tempangle),
								      (float)(rand.nextDouble() * mSpeed) * Angle.cos(tempangle));
		float angle = (float)(tempangle * Angle.TO_RADIANS);
		
		//angluar
		float angular = 0.1f * (float)(rand.nextDouble() * 2 - 1);
		
		//time to live
		int ttl = mLifetime;
		
		//create
		return new Particle(position, velocity, angle, angular, mColour, ttl);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Update trail
	 */
	public void update()
	{
		for (int i = 0; i < toCreate; i++)
		{
			mParticles.add(generateNewParticle());
		}
		
		
		for (int particle = 0; particle < mParticles.size(); particle++)
		{
			mParticles.get(particle).update();
			if (mParticles.get(particle).TTL <= 0)
			{
				mParticles.remove(particle);
				particle--;
			}
		}	
	}
	
	
	
	
	
	/**
	 * Set trail position	
	 */
	public void setPosition(Vector2 position)
	{
		mOrigin = position.clone();
	}
	
	
	
	
	
	
	
	/**
	 * Draw
	 */
	public void draw(Canvas canvas)
	{
		for (int i = 0; i < mParticles.size(); i++)
			mParticles.get(i).draw(canvas);
		
	}
	
	
	
	
	

}
