package sky.engine.graphics.drawable.particles;

import java.util.Random;

import sky.engine.geometry.Vector2D;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Particle
{	
	/**
	 * Alive and dead constants
	 */
	public static final int STATE_ALIVE = 0;
	public static final int STATE_DEAD = 1;
	
	
	/**
	 * Current state of this particle
	 */
	private int particleState;
	
	
	/**
	 * Maximum height/width of the particle
	 */
	private static final int MAX_DIMENSION = 5;
	
	
	/**
	 * Height and width of the particle
	 */
	private float mSize;
	
	
	/**
	 * Position of the particle
	 */
	private Vector2D mPosition = null;
	
	
	/**
	 * Speed of the particle
	 */
	private Vector2D mVelocity = null;
	
	
	/**
	 * angular velocity
	 */
	public float mAngularVelocity;
	
	
	/**
	 * Current age of the particle
	 */
	public int TTL;
	
	
	/**
	 * Colour of the particle
	 */
	private Paint mPaint = null;
	
	
	/**
	 * Random number generator
	 */
	private Random rand = new Random();
	
	
	
	
	


	
	
	
	
	
	/**
	 * Create new instance of a particle object
	 */
	public Particle(Vector2D position, Vector2D velocity, float angle, float angularvel, int colour, int ttl)
	{
		particleState = STATE_ALIVE;
		
		mPosition = new Vector2D(position.X, position.Y);
		mVelocity = new Vector2D(velocity.X, velocity.Y);
		mAngularVelocity = angularvel;
		mPaint = new Paint();
		mPaint.setColor(colour);
		mSize = rand.nextInt(MAX_DIMENSION);
		TTL = ttl;
		
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
			mPosition.X += mVelocity.X;
			mPosition.Y += mVelocity.Y;
		}
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Draw the particle
	 */
	public void draw(Canvas canvas)
	{
		canvas.drawRect(mPosition.X, mPosition.Y, (mPosition.X + mSize), (mPosition.Y + mSize), mPaint);		
	} 
	
	
	
	
	
	
	
	

}
