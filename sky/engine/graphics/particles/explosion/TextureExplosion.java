package sky.engine.graphics.particles.explosion;

import java.util.ArrayList;

import android.graphics.Canvas;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.particles.TextureParticle;
import sky.engine.graphics.textures.Texture;
import sky.engine.math.Angle;
import sky.engine.math.SERandom;
import sky.engine.util.primitives.SEArrayList;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class TextureExplosion extends Explosion
{
	
	/**
	 * textures of the particles
	 */
	private SEArrayList<Texture> textures = new SEArrayList<Texture>();
	
	

	
	
	/**
	 * Create new instance of a Trail object
	 */
	public TextureExplosion(Vector2d position, int lifetime, int size, float speed, Texture texture)
	{
		super(position, lifetime, size, speed);
		textures.add(texture);
		addParticles(size);
	}
	
	
	/**
	 * Create new instance of a Trail object
	 */
	public TextureExplosion(Vector2d position, int lifetime, int size, float speed, ArrayList<Texture> textures)
	{
		super(position, lifetime, size, speed);
		this.textures.addAll(textures);
		addParticles(size);
	}
	
	
	
	
	
	
	/**
	 * generate a new particle
	 */
	@Override
	protected TextureParticle generateNewParticle()
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
		Texture texture = null;
		if (textures.size() == 1)
			texture = textures.get(0);
		else
			texture = textures.getRandom();
		
		//create
		return new TextureParticle(texture, position, velocity, angle, angular, ttl);
	}
	
	
	
	

	
	/**
	 * Draw
	 */
	@Override
	public void draw(Canvas canvas)
	{
		for (int i = particles.size() - 1; i >= 0; i--)
			particles.get(i).draw(canvas);
	}
	
}
