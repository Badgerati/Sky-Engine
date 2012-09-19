package sky.engine.text;

import sky.engine.components.Timer;
import sky.engine.geometry.vectors.Vector2;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class FlashingText extends CustomText
{
	/**
	 * Stages
	 */
	public static final int TEXT_ON = 1;
	public static final int TEXT_OFF = 2;
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
	 * Global timer
	 */
	protected Timer timer = null;
	
	
	
	

	
	
	/**
	 * Create new instance of flashing text
	 */
	public FlashingText(String text, Vector2 position, int colour, float size, float on, float off)
	{
		super(text, position, colour, size);
		initialise(on, off);
	}
	
	
	/**
	 * Create new instance of flashing text
	 */
	public FlashingText(String text, Vector2 position, Paint paint, float on, float off)
	{
		super(text, position, paint);
		initialise(on, off);
	}
	
	
	
	
	/**
	 * Initialises the fading timers
	 */
	private void initialise(float on, float off)
	{
		//timers
		timer = new Timer();
		timer.start();
		onTime = on;
		offTime = off;
		
		//stage
		currentstage = TEXT_ON;
	}
	
	
	
	
	
	/**
	 * Update the flashing text
	 */
	public void update()
	{
		switch (currentstage)
		{
			default: case TEXT_ON:
				if (timer.getTime() >= onTime)
				{
					currentstage = TEXT_OFF;
					timer.reset();
				}
				break;
				
			case TEXT_OFF:
				if (timer.getTime() >= offTime)
				{
					currentstage = TEXT_ON;
					timer.reset();
				}
				break;
		}
	}
	
	
	
	
	/**
	 * Draw the flashing text
	 */
	@Override
	public void draw(Canvas canvas)
	{
		if (currentstage == TEXT_ON)
		{
			super.draw(canvas);
		}
	}
	
	
}
