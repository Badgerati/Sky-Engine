package sky.engine.components.time;

/**
 * A 'tick' is equal to 1 millisecond.
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class TimeSpan
{
	/**
	 * Time constants
	 */
	public static final int MILLIS_PER_DAY = 86400000;
	public static final int MILLIS_PER_HOUR = 3600000;
	public static final int MILLIS_PER_MINUTE = 60000;
	public static final int MILLIS_PER_SECOND = 1000;
	
	
	/**
	 * Number of days
	 */
	private int days = 0;
	
	
	/**
	 * Number of hours
	 */
	private int hours = 0;
	
	
	/**
	 * Number of minutes
	 */
	private int minutes = 0;
	
	
	/**
	 * Number of seconds
	 */
	private int seconds = 0;
	
	
	/**
	 * Number of milliseconds
	 */
	private int milliseconds = 0;
	
	
	/**
	 * Number of ticks (this TimeSpan as milliseconds)
	 */
	private long ticks = 0;
	
	
	


	
	/**
	 * Create a new TimeSpan
	 */
	public TimeSpan() { }
	
	
	/**
	 * Create a new TimeSpan
	 */
	public TimeSpan(long millis)
	{
		initialise(millis);
	}
	
	
	/**
	 * Create a new TimeSpan
	 */
	public TimeSpan(int hours, int mins, int secs)
	{
		long _millis = (hours * MILLIS_PER_HOUR);
		_millis += (mins * MILLIS_PER_MINUTE);
		_millis += (secs * MILLIS_PER_SECOND);
		
		initialise(_millis);
	}
	
	
	/**
	 * Create a new TimeSpan
	 */
	public TimeSpan(int days, int hours, int mins, int secs)
	{
		long _millis = (days * MILLIS_PER_DAY);
		_millis += (hours * MILLIS_PER_HOUR);
		_millis += (mins * MILLIS_PER_MINUTE);
		_millis += (secs * MILLIS_PER_SECOND);
		
		initialise(_millis);
	}
	
	
	/**
	 * Create a new TimeSpan
	 */
	public TimeSpan(int days, int hours, int mins, int secs, long millis)
	{
		long _millis = (days * MILLIS_PER_DAY);
		_millis += (hours * MILLIS_PER_HOUR);
		_millis += (mins * MILLIS_PER_MINUTE);
		_millis += (secs * MILLIS_PER_SECOND);
		_millis += millis;
		
		initialise(_millis);
	}
	
	
	
	
	
	/**
	 * Initialise
	 */
	private void initialise(long millis)
	{
		ticks = millis;
		
		days = (int)(millis / MILLIS_PER_DAY);
		millis = millis % MILLIS_PER_DAY;
		
		hours = (int)(millis / MILLIS_PER_HOUR);
		millis = millis % MILLIS_PER_HOUR;
		
		minutes = (int)(millis / MILLIS_PER_MINUTE);
		millis = millis % MILLIS_PER_MINUTE;
		
		seconds = (int)(millis / MILLIS_PER_SECOND);
		millis = millis % MILLIS_PER_SECOND;
		
		milliseconds = (int)millis;
	}
	
	

	
	
	/**
	 * Returns the number of days
	 */
	public int Days() { return days; }
	
	
	/**
	 * Returns the number of hours
	 */
	public int Hours() { return hours; }
	
	
	/**
	 * Returns the number of minutes
	 */
	public int Minutes() { return minutes; }
	
	
	/**
	 * Returns the number of seconds
	 */
	public int Seconds() { return seconds; }
	
	
	/**
	 * Returns the number of milliseconds
	 */
	public int Milliseconds() { return milliseconds; }
	
	
	/**
	 * Returns the total number of milliseconds
	 */
	public long TotalMilliseconds() { return ticks; }
	
	
	/**
	 * Returns the number of ticks (this TimeSpan as total milliseconds)
	 */
	public long Ticks() { return ticks; }
	
	
	
	
	
	/**
	 * Returns a zero TimeSpan
	 */
	public static TimeSpan zero()
	{
		return new TimeSpan();
	}
	
	
	
	
	
	/**
	 * Does this TimeSpan object equal the given one
	 */
	@Override
	public boolean equals(Object time)
	{
		if (ticks == ((TimeSpan)time).Ticks())
			return true;
		return false;
	}
	
	
	
}
