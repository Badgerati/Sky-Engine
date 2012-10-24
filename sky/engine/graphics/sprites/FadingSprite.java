package sky.engine.graphics.sprites;

import sky.engine.components.time.GameTime;
import sky.engine.components.time.TimeSpan;
import sky.engine.geometry.vectors.Vector2d;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class FadingSprite extends Sprite
{
	
	/**
	 * Current state of the Fading Sprite
	 */
	protected int currentState = 0;
	public static final int FADING = 0;
	public static final int FADED = 1;
	
	
	
	/**
	 * Direction for the fading to occur
	 */
	protected int direction = 0;
	public static final int DIRECTION_IN = 1;
	public static final int DIRECTION_OUT = -1;
	
	
	/**
	 * Time for the fading to take space over
	 */
	protected long lengthOfTime = 0;
	
	
	/**
	 * Current time we're running at
	 */
	protected long fadeTimer = 0;
	
	
	/**
	 * Current alpha
	 */
	protected float currentAlpha = 255.0f;
	
	
	/**
	 * Transition alpha
	 */
	protected float transitionAlpha = 0.0f;
	
	
	/**
	 * Alpha fade speed
	 */
	protected float alphaFadeSpeed = 0.0f;
	
	
	
	

	
	
	/**
	 * Create a new Fading Sprite
	 */
	public FadingSprite(Bitmap bitmap, Vector2d position, float scale, int direction, TimeSpan time)
	{
		super(bitmap, position, scale);
		this.direction = direction;
		lengthOfTime = time.TotalMilliseconds();
		
		currentAlpha = direction <= 0 ? 255.0f : 0.0f;
		alphaFadeSpeed = 255.0f / lengthOfTime;
		
		currentState = FADING;
	}
	
	
	/**
	 * Create a new Fading Sprite
	 */
	public FadingSprite(Bitmap bitmap, Vector2d position, float scale, int direction, TimeSpan time, Vector2d velocity, float mass)
	{
		super(bitmap, position, scale, velocity, mass);
		this.direction = direction;
		lengthOfTime = time.TotalMilliseconds();
		
		currentAlpha = direction <= 0 ? 255.0f : 0.0f;
		alphaFadeSpeed = 255.0f / lengthOfTime;
		
		currentState = FADING;
	}
	
	
	
	
	
	/**
	 * Is the Fading Sprite currently still fading in or out
	 */
	public boolean isFading()
	{
		return currentState == FADING;
	}
	
	
	
	
	
	
	/**
	 * Update the Fading Sprite
	 */
	@Override
	public void update(GameTime gameTime)
	{
		super.update(gameTime);
		
		fadeTimer += gameTime.ElapsedGameTime;
		if (fadeTimer < lengthOfTime)
		{
			currentAlpha += (alphaFadeSpeed * direction);
			
			if (currentAlpha < 0.0f) currentAlpha = 0.0f;
			else if (currentAlpha > 255.0f) currentAlpha = 255.0f;
			
			this.setOpacity((int)currentAlpha);
		}
		else
		{
			currentState = FADED;
		}
	}
	
	
	
	
	
	/**
	 * Draw the Fading Sprite
	 */
	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
	}
	
	
}
