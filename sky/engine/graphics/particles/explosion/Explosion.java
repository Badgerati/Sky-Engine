package sky.engine.graphics.particles.explosion;

import java.util.ArrayList;
import java.util.List;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.particles.Particle;
import sky.engine.math.Angle;
import sky.engine.math.SERandom;
import sky.engine.util.primitives.SEArrayList;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Explosion implements IDrawableComponent
{
	
	/**
	 * Alive and dead constants
	 */
	public static final int STATE_ALIVE = 0;
	public static final int STATE_DEAD = 1;

	
	/**
	 * Current state of the explosion
	 */
	protected int explosionState;
	
	
	/**
	 * point where explosion is to happen
	 */
	public Vector2d Position = null;
	
	
	/**
	 * the particles of the explosion
	 */
	protected List<Particle> particles = null;
	
	
	/**
	 * lifetime of the explosion
	 */
	protected int lifetime;
	
	
	/**
	 * speed of explosion
	 */
	protected float velocity;
	
	
	/**
	 * colours of particles
	 */
	private SEArrayList<Integer> colours = new SEArrayList<Integer>();
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of an explosion object
	 */
	public Explosion(Vector2d position, int lifetime, int size, float speed, int colour)
	{
		explosionState = STATE_ALIVE;
		
		Position = position;
		this.lifetime = lifetime;
		velocity = speed;
		
		colours.add(colour);
				
		particles = new ArrayList<Particle>();
		addParticles(size);
	}
	
	
	/**
	 * Create new instance of a explosion object
	 */
	public Explosion(Vector2d position, int lifetime, int size, float speed, ArrayList<Integer> colours)
	{
		explosionState = STATE_ALIVE;
		
		Position = position;
		this.lifetime = lifetime;
		velocity = speed;
		
		this.colours.addAll(colours);
				
		particles = new ArrayList<Particle>();
		addParticles(size);
	}
	
	
	/**
	 * Create new instance of a explosion object
	 */
	protected Explosion(Vector2d position, int lifetime, int size, float speed)
	{
		explosionState = STATE_ALIVE;
		
		Position = position;
		this.lifetime = lifetime;
		velocity = speed;
				
		particles = new ArrayList<Particle>();
	}
	
	
	
	
	
	
	/**
	 * Add Particles
	 */
	protected void addParticles(int size)
	{
		for (int i = 0; i < size; i++)
		{
			particles.add(generateNewParticle());
		}
	}
	
	
	
	
	
	/**
	 * generate a new particle
	 */
	protected Particle generateNewParticle()
	{
		//position
		Vector2d position = Position;
		
		//angle of trajectory
		int tempangle = SERandom.getInt(359);
		Vector2d velocity = new Vector2d((float)(SERandom.getDouble() * this.velocity) * Angle.sin(tempangle),
								      (float)(SERandom.getDouble() * this.velocity) * Angle.cos(tempangle));
		float angle = (float)(tempangle * Angle.TO_RADIANS);
		
		//angluar
		float angular = 0.1f * (float)(SERandom.getDouble() * 2 - 1);
		
		//time to live
		int ttl = lifetime + SERandom.getInt(40);
		
		//colour
		int colour = 0;
		if (colours.size() == 1)
			colour = colours.get(0);
		else
			colour = colours.getRandom();
		
		//create
		return new Particle(colour, position, velocity, angle, angular, ttl);
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
		for (int particle = 0; particle < particles.size(); particle++)
		{
			particles.get(particle).update();
			if (particles.get(particle).TTL <= 0)
			{
				particles.remove(particle);
				particle--;
			}
		}
		
		if (particles.size() <= 0)
			explosionState = STATE_DEAD;		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Draw the explosive particles
	 */
	public void draw(Canvas canvas)
	{
		for (int i = 0; i < particles.size(); i++)
			particles.get(i).draw(canvas);
	}
	
	
	

}
