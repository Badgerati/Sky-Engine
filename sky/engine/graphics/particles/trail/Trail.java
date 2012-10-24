package sky.engine.graphics.particles.trail;

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
public class Trail implements IDrawableComponent
{	
	
	/**
	 * point where trail is to happen
	 */
	public Vector2d Position = null;
	
	
	/**
	 * number of particles to create on each iteration
	 */
	protected int toCreate;
	
	
	/**
	 * the particles of the trail
	 */
	protected List<Particle> particles = null;
	
	
	/**
	 * lifetime of the trail
	 */
	protected int lifetime;
	
	
	/**
	 * speed of trail
	 */
	protected float velocity;
	
	
	/**
	 * colours of the particles
	 */
	private SEArrayList<Integer> colours = new SEArrayList<Integer>();
	
	
	
	
	

	
	
	/**
	 * Create new instance of a Trail object
	 */
	public Trail(Vector2d position, int lifetime, int create, float speed, int colour)
	{		
		Position = position;
		toCreate = create;
		this.lifetime = lifetime;
		velocity = speed;
		
		colours.add(colour);
		
		particles = new ArrayList<Particle>();
	}
	
	
	/**
	 * Create new instance of a Trail object
	 */
	public Trail(Vector2d position, int lifetime, int create, float speed, ArrayList<Integer> colours)
	{		
		Position = position;
		toCreate = create;
		this.lifetime = lifetime;
		velocity = speed;
		
		this.colours.addAll(colours);
		
		particles = new ArrayList<Particle>();
	}
	
	
	/**
	 * Create new instance of a Trail object
	 */
	protected Trail(Vector2d position, int lifetime, int create, float speed)
	{		
		Position = position;
		toCreate = create;
		this.lifetime = lifetime;
		velocity = speed;
		
		particles = new ArrayList<Particle>();
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
		int ttl = lifetime;
		
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
	 * Update trail
	 */
	public void update()
	{
		for (int i = 0; i < toCreate; i++)
		{
			particles.add(generateNewParticle());
		}
		
		
		for (int particle = 0; particle < particles.size(); particle++)
		{
			particles.get(particle).update();
			if (particles.get(particle).TTL <= 0)
			{
				particles.remove(particle);
				particle--;
			}
		}	
	}
	
	
	
	
	
	
	
	/**
	 * Draw
	 */
	public void draw(Canvas canvas)
	{
		for (int i = 0; i < particles.size(); i++)
			particles.get(i).draw(canvas);
	}
	
	
	
	
	

}
