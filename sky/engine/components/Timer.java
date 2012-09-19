package sky.engine.components;

import java.util.Calendar;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class Timer
{
	/**
	 * States of the timer
	 */
	public static final int TIMER_STOP = 1;
	public static final int TIMER_START = 2;
	public static final int TIMER_PAUSE = 3;
	public static final int TIMER_RESUME = 4;
	protected int currentstate = 0;
	
	
	
	/**
	 * Time the timer was started at
	 */
	protected Calendar starttime = null;
	
	
	/**
	 * Time the timer is currently at
	 */
	protected Calendar currenttime = null;
	
	
	/**
	 * Time the timer was paused at
	 */
	protected Calendar pausetime = null;
	
	
	/**
	 * Amount of time the timer has been paused for
	 */
	protected float amountOfPause = 0f;
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Timer
	 */
	public Timer()
	{
		currentstate = TIMER_STOP;
	}
	
	
	
	
	
	/**
	 * Starts the timer ticking
	 */
	public void start()
	{
		currentstate = TIMER_START;
		starttime = Calendar.getInstance();
		amountOfPause = 0f;
	}
	
	
	
	
	/**
	 * Resets the timer
	 */
	public void reset()
	{
		currentstate = TIMER_START;
		starttime = Calendar.getInstance();
		amountOfPause = 0f;
	}
	
	
	
	
	/**
	 * Returns the current time the timer has been running
	 */
	public float getTime()
	{
		currenttime = Calendar.getInstance();
		return ((currenttime.getTimeInMillis() - starttime.getTimeInMillis()) / 1000.0f) - amountOfPause;
	}
	
	
	
	
	/**
	 * Pause the timer
	 */
	public void pause()
	{
		currentstate = TIMER_PAUSE;
		pausetime = Calendar.getInstance();
	}
	
	
	
	
	/**
	 * Resume the timer
	 */
	public void resume()
	{
		currentstate = TIMER_START;
		Calendar resumetime = Calendar.getInstance();
		float amount =  (resumetime.getTimeInMillis() - pausetime.getTimeInMillis()) / 1000.0f;
		amountOfPause += amount;
	}
	
	
	
	
	
	/**
	 * Stop the timer
	 */
	public void stop()
	{
		currentstate = TIMER_STOP;
		amountOfPause = 0f;
	}
	
	
	
	
	/**
	 * Returns current state of timer
	 */
	public int getState()
	{
		return currentstate;
	}
	
	
	
	
	
	/**
	 * Is the timer stopped?
	 */
	public boolean isStopped()
	{
		return currentstate == TIMER_STOP;
	}
	
	
	
	
	
	/**
	 * Is the timer started?
	 */
	public boolean isStarted()
	{
		return currentstate == TIMER_START;
	}
	
	
	
	
	
	/**
	 * Is the timer paused?
	 */
	public boolean isPaused()
	{
		return currentstate == TIMER_PAUSE;
	}
	
	
	
	
	
	/**
	 * Returns the start time of the timer
	 */
	public float getStartTime()
	{
		if (starttime != null)
			return starttime.getTimeInMillis();
		
		return 0;
	}
	
	
	
	
	/**
	 * Returns the current time the timer was last logged at
	 */
	public float getCurrentTime()
	{
		currenttime = Calendar.getInstance();
		return currenttime.getTimeInMillis();
	}
}
