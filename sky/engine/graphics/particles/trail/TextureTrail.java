package sky.engine.graphics.particles.trail;

import java.util.ArrayList;

import android.graphics.Canvas;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.particles.TextureParticle;
import sky.engine.graphics.textures.Texture;
import sky.engine.math.AngleHelper;
import sky.engine.math.SERandom;
import sky.engine.util.primitives.SEArrayList;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class TextureTrail extends Trail
{
	
	/**
	 * textures of the particles
	 */
	private SEArrayList<Texture> textures = new SEArrayList<Texture>();
	
	

	
	
	/**
	 * Create new instance of a Trail object
	 */
	public TextureTrail(Vector2d position, int lifetime, int create, float speed, Texture texture)
	{
		super(position, lifetime, create, speed);
		textures.add(texture);
	}
	
	
	/**
	 * Create new instance of a Trail object
	 */
	public TextureTrail(Vector2d position, int lifetime, int create, float speed, ArrayList<Texture> textures)
	{
		super(position, lifetime, create, speed);
		this.textures.addAll(textures);
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
		Vector2d velocity = new Vector2d((float)(SERandom.getDouble() * this.velocity) * AngleHelper.sin(tempangle),
								      (float)(SERandom.getDouble() * this.velocity) * AngleHelper.cos(tempangle));
		float angle = (float)(tempangle * AngleHelper.TO_RADIANS);
		
		//angluar
		float angular = 0.1f * (float)(SERandom.getDouble() * 2 - 1);
		
		//time to live
		int ttl = lifetime;
		
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
