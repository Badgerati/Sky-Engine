package sky.engine.graphics.particles;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.textures.Texture;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class TextureParticle extends Particle
{
	/**
	 * Texture to use for the Particle
	 */
	protected Texture texture = null;
	
	
	
	
	
	
	/**
	 * Create a new Texture Particle
	 */
	public TextureParticle(Texture texture, Vector2d position, Vector2d velocity, float angle, float angularvel, int ttl)
	{
		super(position, velocity, angle, angularvel, ttl);
		this.texture = texture;
	}
	
	
	
	
	
	/**
	 * Update the Particle
	 */
	@Override
	public void update()
	{
		super.update();
	}
	
	
	
	
	
	
	/**
	 * Draw the Particle
	 */
	@Override
	public void draw(Canvas canvas)
	{
		texture.draw(canvas, Position.X, Position.Y, paint);
	}
	
}
