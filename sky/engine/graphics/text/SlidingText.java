package sky.engine.graphics.text;

import sky.engine.components.time.GameTime;
import sky.engine.components.time.Timer;
import sky.engine.geometry.vectors.Vector2d;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class SlidingText extends CustomText
{
	/**
	 * Time to wait before sliding
	 */
	protected float timeToWait = 1.0f;
	
	
	/**
	 * Length of sliding window
	 */
	protected int windowlength = 0;
	
	
	/**
	 * Starting index
	 */
	protected int startindex = 0;
	
	
	/**
	 * Last index
	 */
	protected int lastindex = 0;
	
	
	/**
	 * Actual string
	 */
	protected String actualtext = "";
	
	
	/**
	 * Timer to set sliding speed
	 */
	protected Timer timer = null;
	
	
	
	
	
	
	
	/**
	 * Create new instance of sliding text
	 */
	public SlidingText(String text, Vector2d position, int colour, float size, int length, float speed)
	{
		super(text, position, colour, size);
		initialise(length, speed);
	}
	
	
	/**
	 * Create new instance of sliding text
	 */
	public SlidingText(String text, Vector2d position, Paint paint, int length, float speed)
	{
		super(text, position, paint);
		initialise(length, speed);
	}
	
	
	
	
	/**
	 * Initialises length of the sliding text
	 */
	private void initialise(int length, float speed)
	{
		if (Text.length() < length)
			length = Text.length();
		
		windowlength = length;
		lastindex = length - 1;
		
		actualtext = Text;
		Text = actualtext.substring(startindex, lastindex + 1);
		
		timeToWait /= speed;
		timer = new Timer();
		timer.start();
	}
	
	
	
	
	
	/**
	 * Update the sliding text
	 */
	@Override
	public void update(GameTime gameTime)
	{
		if (timer.getTime() >= timeToWait)
		{
			//update indices
			startindex++;
			if (startindex >= actualtext.length())
				startindex = 0;
			
			lastindex++;
			if (lastindex >= actualtext.length())
				lastindex = 0;
			
			//set text
			if (startindex < lastindex)
			{
				Text = actualtext.substring(startindex, lastindex + 1);
			}
			else
			{
				Text = actualtext.substring(startindex, actualtext.length());
				Text += actualtext.substring(0, lastindex + 1);
			}
			
			//reset
			timer.reset();
		}
	}
	
	
	
	
	/**
	 * Draw the sliding text
	 */
	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
	}

}
