package sky.engine.graphics.particles;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.math.SERandom;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Particle implements IDrawableComponent
{	
	/**
	 * Alive and dead constants
	 */
	public static final int STATE_ALIVE = 0;
	public static final int STATE_DEAD = 1;
	
	
	/**
	 * Current state of this particle
	 */
	protected int particleState = 0;
	
	
	/**
	 * Maximum height/width of the particle
	 */
	protected static final int MAX_DIMENSION = 6;
	
	
	/**
	 * Height and width of the particle
	 */
	protected float particleSize = 0;
	
	
	/**
	 * Position of the particle
	 */
	protected Vector2d Position = null;
	
	
	/**
	 * Speed of the particle
	 */
	protected Vector2d Velocity = null;
	
	
	/**
	 * angular velocity
	 */
	protected float AngularVelocity = 0;
	
	
	/**
	 * Current age of the particle
	 */
	public int TTL = 0;
	
	
	/**
	 * Colour of the particle
	 */
	protected Paint paint = null;
	
	
	/**
	 * Fade speed of Particle
	 */
	protected int fadeSpeed = 0;
	
	
	
	
	


	
	

	
	
	/**
	 * Create new instance of a particle object
	 */
	public Particle(int colour, Vector2d position, Vector2d velocity, float angle, float angularvel, int ttl)
	{
		particleState = STATE_ALIVE;
		
		Position = position.clone();
		Velocity = velocity.clone();
		AngularVelocity = angularvel;
		TTL = ttl;
		
		paint = new Paint();
		paint.setColor(colour);
		fadeSpeed = 255 / ttl;
		
		particleSize = SERandom.getInt(MAX_DIMENSION);
	}
	
	
	/**
	 * Create new instance of a particle object
	 */
	public Particle(Vector2d position, Vector2d velocity, float angle, float angularvel, int ttl)
	{
		particleState = STATE_ALIVE;

		Position = position.clone();
		Velocity = velocity.clone();
		AngularVelocity = angularvel;
		TTL = ttl;

		paint = new Paint();
		fadeSpeed = 255 / ttl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Is the particle alive?
	 */
	public boolean isAlive()
	{
		return particleState == STATE_ALIVE ? true : false;
	}
	
	
	/**
	 * Is the particle dead?
	 */
	public boolean isDead()
	{
		return particleState == STATE_DEAD ? true : false;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Update the particle
	 */	
	public void update()
	{
		if (particleState == STATE_ALIVE)
		{
			TTL--;
			Position.X += Velocity.X;
			Position.Y += Velocity.Y;
		}

		paint.setAlpha(paint.getAlpha() - fadeSpeed);		
	}
	
	
	
	
	
	
	
	
	/**
	 * Draw the particle
	 */
	public void draw(Canvas canvas)
	{
		canvas.drawRect(Position.X, Position.Y, (Position.X + particleSize), (Position.Y + particleSize), paint);		
	} 
	
	
	
	
	
	
	
	

}
