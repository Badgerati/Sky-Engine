package sky.engine.components.time;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class GameTime
{
	
	/**
	 * Amount of elapsed game time since last update
	 */
	public long ElapsedGameTime = 0;
	
	
	/**
	 * Amount of elapsed game time time we would like to have between updates
	 */
	public long TargetElapsedTime = 0;
	
	
	/**
	 * Amount of game time since the start of the game
	 */
	public long TotalGameTime = 0;
	
	
	/**
	 * Indicates if the game if currently running slowly
	 */
	public boolean IsRunningSlowly = false;
	
	
	/**
	 * The max possible FPS for the game
	 */
	protected int MAX_FPS = 0;
	
	
	/**
	 * Current FPS
	 */
	public int FPS = 0;
	
	
	
	
	
	/**
	 * Create new GameTime
	 */
	public GameTime(int max_fps)
	{
		MAX_FPS = max_fps;
		FPS = max_fps;
		
		TargetElapsedTime = (long)(1000.0/max_fps);
	}
	
	
	
	
	/**
	 * Update timers
	 */
	public void update(long timeSinceLastUpdate)
	{
		ElapsedGameTime = timeSinceLastUpdate;
		TotalGameTime += timeSinceLastUpdate;
		FPS = (int)(1000.0 / timeSinceLastUpdate);
	}
	
	
	
	
	/**
	 * Reset timers
	 */
	public void reset()
	{
		ElapsedGameTime = 0;
		TotalGameTime = 0;
		FPS = 0;
	}
	
	
	
	
	/**
	 * Returns a delta in time, which is the ElapsedGameTime divided by the
	 * TargetElapsedTime
	 */
	public float deltaTime()
	{
		return (float)ElapsedGameTime/(float)TargetElapsedTime;
	}
	
	
	
	
	
	/**
	 * Returns a String representation of the GameTime
	 */
	public String toString()
	{
		return "EGT  = " + ElapsedGameTime + "\n" +
			   "Tar  = " + TargetElapsedTime + "\n" +
			   "Del  = " + deltaTime() + "\n" +
			   "TGT  = " + TotalGameTime + "\n" +
			   "FPS  = " + FPS + "\n" +
			   "Slow = " + IsRunningSlowly;
	}
	
}
