package sky.engine.graphics.text;

import sky.engine.components.time.GameTime;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.threads.GameThread;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class FadingText extends CustomText
{
	/**
	 * Stages
	 */
	public static final int TEXT_ON = 1;
	public static final int TEXT_OFF = 2;
	public static final int TEXT_IN = 3;
	public static final int TEXT_OUT = 4;
	protected int currentstage = TEXT_ON;
	
	
	/**
	 * Amount of time text is shown
	 */
	protected long onTime = 0;
	
	
	/**
	 * Amount of time text is hidden
	 */
	protected long offTime = 0;
	
	
	/**
	 * Amount of time text is fading in
	 */
	protected long inTime = 0;
	
	
	/**
	 * Amount of time text is fading out
	 */
	protected long outTime = 0;
	
	
	/**
	 * Fading coeff for fading in
	 */
	protected float inFade = 0;
	
	
	/**
	 * Fading coeff for fading out
	 */
	protected float outFade = 0;
	
	
	/**
	 * Global timer
	 */
	protected long timer = 0;
	
	
	/**
	 * Current temporary alpha value
	 */
	protected float alphavalue = 255.0f;
	
	
	/**
	 * Minimum alpha
	 */
	protected float minAlpha = 0.0f;
	
	
	/**
	 * Minimum alpha
	 */
	protected float maxAlpha = 255.0f;
	
	
	
	

	
	
	/**
	 * Create new instance of fading text
	 */
	public FadingText(String text, Vector2d position, int colour, float size, long on, long off, long in, long out)
	{
		super(text, position, colour, size);
		initialise(on, off, in, out);
	}
	
	
	/**
	 * Create new instance of fading text
	 */
	public FadingText(String text, Vector2d position, Paint paint, long on, long off, long in, long out)
	{
		super(text, position, paint);
		initialise(on, off, in, out);
	}
	
	
	
	
	/**
	 * Initialises the fading timers
	 */
	private void initialise(long on, long off, long in, long out)
	{
		//timers
		timer = 0;
		onTime = on;
		offTime = off;
		inTime = in;
		outTime = out;
		
		//stage
		currentstage = TEXT_ON;
		
		//alpha
		alphavalue = 255.0f;
		
		//fading co-efficients
		inFade = (maxAlpha - minAlpha) / (in / 1000.0f) / GameThread.MAX_FPS;
		outFade = (maxAlpha - minAlpha) / (out / 1000.0f) / GameThread.MAX_FPS;
	}
	
	
	
	
	
	
	/**
	 * Set the minimum alpha value
	 */
	public void setMinimumAlpha(float min)
	{
		if (min < 0.0f) min = 0.0f;
		if (min > maxAlpha || min > 255.0f) min = maxAlpha;
		
		minAlpha = min;
		outFade = (maxAlpha - minAlpha) / (outTime / 1000.0f) / GameThread.MAX_FPS;
	}
	
	
	
	
	
	
	/**
	 * Set the maximum alpha value
	 */
	public void setMaximumAlpha(float max)
	{
		if (max > 255.0f) max = 255.0f;
		if (max < minAlpha || max < 0.0f) max = minAlpha;
		
		maxAlpha = max;
		inFade = (maxAlpha - minAlpha) / (inTime / 1000.0f) / GameThread.MAX_FPS;
	}
	
	
	
	
	
	
	/**
	 * Update the fading text
	 */
	@Override
	public void update(GameTime gameTime)
	{
		timer += gameTime.ElapsedGameTime;
		
		switch (currentstage)
		{
			default: case TEXT_ON:
				if (timer >= onTime)
				{
					currentstage = TEXT_OUT;
					timer = 0;
				}
				break;
				
			case TEXT_OUT:
				if (timer < outTime)
				{
					alphavalue -= outFade;
					if (alphavalue < minAlpha) alphavalue = minAlpha;
					this.setAlpha((int)alphavalue);
				}
				else
				{
					this.setAlpha((int)minAlpha);
					alphavalue = minAlpha;
					currentstage = TEXT_OFF;
					timer = 0;
				}
				break;
				
			case TEXT_OFF:
				if (timer >= offTime)
				{
					currentstage = TEXT_IN;
					timer = 0;
				}
				break;
				
			case TEXT_IN:
				if (timer < inTime)
				{
					alphavalue += inFade;
					if (alphavalue > maxAlpha) alphavalue = maxAlpha;
					this.setAlpha((int)alphavalue);
				}
				else
				{
					this.setAlpha((int)maxAlpha);
					alphavalue = maxAlpha;
					currentstage = TEXT_ON;
					timer = 0;
				}
				break;
		}
	}
	
	
	
	
	/**
	 * Draw the fading text
	 */
	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
	}
	
}
