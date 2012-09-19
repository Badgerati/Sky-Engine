package sky.engine.text;

import sky.engine.components.Timer;
import sky.engine.geometry.vectors.Vector2;
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
	protected float onTime = 0;
	
	
	/**
	 * Amount of time text is hidden
	 */
	protected float offTime = 0;
	
	
	/**
	 * Amount of time text is fading in
	 */
	protected float inTime = 0;
	
	
	/**
	 * Amount of time text is fading out
	 */
	protected float outTime = 0;
	
	
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
	protected Timer timer = null;
	
	
	/**
	 * Current temporary alpha value
	 */
	protected float alphavalue = 255.0f;
	
	
	
	

	
	
	/**
	 * Create new instance of fading text
	 */
	public FadingText(String text, Vector2 position, int colour, float size, float on, float off, float in, float out)
	{
		super(text, position, colour, size);
		initialise(on, off, in, out);
	}
	
	
	/**
	 * Create new instance of fading text
	 */
	public FadingText(String text, Vector2 position, Paint paint, float on, float off, float in, float out)
	{
		super(text, position, paint);
		initialise(on, off, in, out);
	}
	
	
	
	
	/**
	 * Initialises the fading timers
	 */
	private void initialise(float on, float off, float in, float out)
	{
		//timers
		timer = new Timer();
		timer.start();
		onTime = on;
		offTime = off;
		inTime = in;
		outTime = out;
		
		//stage
		currentstage = TEXT_ON;
		
		//alpha
		alphavalue = 255.0f;
		
		//fading co-efficients
		inFade = 255.0f / in / GameThread.MAX_FPS;
		outFade = 255.0f / out / GameThread.MAX_FPS;
	}
	
	
	
	
	
	/**
	 * Update the fading text
	 */
	public void update()
	{
		switch (currentstage)
		{
			default: case TEXT_ON:
				if (timer.getTime() >= onTime)
				{
					currentstage = TEXT_OUT;
					timer.reset();
				}
				break;
				
			case TEXT_OUT:
				if (timer.getTime() < outTime)
				{
					alphavalue -= outFade;
					if (alphavalue < 0.0f) alphavalue = 0.0f;
					this.setAlpha((int)alphavalue);
				}
				else
				{
					this.setAlpha(0);
					alphavalue = 0.0f;
					currentstage = TEXT_OFF;
					timer.reset();
				}
				break;
				
			case TEXT_OFF:
				if (timer.getTime() >= offTime)
				{
					currentstage = TEXT_IN;
					timer.reset();
				}
				break;
				
			case TEXT_IN:
				if (timer.getTime() < inTime)
				{
					alphavalue += inFade;
					if (alphavalue > 255.0f) alphavalue = 255.0f;
					this.setAlpha((int)alphavalue);
				}
				else
				{
					this.setAlpha(255);
					alphavalue = 255.0f;
					currentstage = TEXT_ON;
					timer.reset();
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
