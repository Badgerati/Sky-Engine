package sky.engine.components.time;

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
	protected long amountOfPause = 0;
	
	
	/**
	 * Running time of the Timer
	 */
	protected long runningTime = 0;
	
	
	/**
	 * Amount of tick period time
	 */
	protected long tickPeriod = 0;
	
	
	/**
	 * Number of passed ticks
	 */
	protected long passedTicks = 0;
	
	
	/**
	 * Last running time checked, used for the tick period event
	 */
	protected long lastRunningTime = 0;
	
	
	
	
	
	

	
	
	/**
	 * Create new instance of a Timer
	 */
	public Timer()
	{
		currentstate = TIMER_STOP;
	}
	
	
	/**
	 * Create new instance of a Timer, where 1000 ticks = 1 second
	 */
	public Timer(long tickperiod)
	{
		currentstate = TIMER_STOP;
		tickPeriod = tickperiod;
	}
	
	
	/**
	 * Create new instance of a Timer
	 */
	public Timer(TimeSpan tickperiod)
	{
		currentstate = TIMER_STOP;
		tickPeriod = tickperiod.Ticks();
	}
	
	
	
	
	
	/**
	 * Starts the timer ticking
	 */
	public void start()
	{
		currentstate = TIMER_START;
		starttime = Calendar.getInstance();
		amountOfPause = 0;
		runningTime = 0;
		lastRunningTime = 0;
		passedTicks = 0;
	}
	
	
	
	
	/**
	 * Resets the timer
	 */
	public void reset()
	{
		currentstate = TIMER_START;
		starttime = Calendar.getInstance();
		amountOfPause = 0;
		runningTime = 0;
		lastRunningTime = 0;
		passedTicks = 0;
	}

	
	
	
	/**
	 * Set the tick period for this Timer onTick method calling
	 */
	public void setTickPeriod(long tickperiod)
	{
		tickPeriod = tickperiod;
	}
	
	
	
	
	/**
	 * Set the tick period for this Timer onTick method calling
	 */
	public void setTickPeriod(TimeSpan tickperiod)
	{
		tickPeriod = tickperiod.Ticks();
	}
	
	
	
	
	
	/**
	 * Returns the current time the timer has been running
	 */
	public float getTime()
	{
		return runningTime;
	}
	
	
	
	
	/**
	 * Updates the current amount time the timer has been running
	 */
	public void update()
	{
		currenttime = Calendar.getInstance();
		runningTime = (currenttime.getTimeInMillis() - starttime.getTimeInMillis()) - amountOfPause;
		
		if (tickPeriod != 0)
		{
			if (runningTime - lastRunningTime >= tickPeriod)
			{
				passedTicks++;
				lastRunningTime = passedTicks * tickPeriod;
				onTick();
			}
		}
	}
	
	
	
	
	/**
	 * Event to be run on every certain tick period
	 */
	public void onTick()
	{
		return;
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
		float amount =  resumetime.getTimeInMillis() - pausetime.getTimeInMillis();
		amountOfPause += amount;
	}
	
	
	
	
	
	/**
	 * Stop the timer
	 */
	public void stop()
	{
		currentstate = TIMER_STOP;
		amountOfPause = 0;
		runningTime = 0;
		lastRunningTime = 0;
		passedTicks = 0;
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
	 * Returns the current time of the timer
	 */
	public float getCurrentTime()
	{
		currenttime = Calendar.getInstance();
		return currenttime.getTimeInMillis();
	}
	
	
}
