package sky.engine.threads;

import sky.engine.components.time.GameTime;
import sky.engine.game.IGame;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.SurfaceHolder;

/**
 * The main thread that is used to run the game. In general, the thread's handler
 * for messages is empty; therefore, this class must be extended to override the
 * appropriate methods (such as setState()). You will also need to use setHandler()
 * so the thread can use one.
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class GameThread extends Thread
{
	/**
	 * States of the thread
	 */
    public static final int STATE_START = 0;
    public static final int STATE_PLAY = 1;
    public static final int STATE_LOSE = 2;
    public static final int STATE_PAUSE = 3;
    public static final int STATE_RUN = 4;
    public static final int STATE_RESUME = 5;
    public static final int STATE_STOP = 6;
	
    
	/**
	 * FPS constants
	 */
	public static final int MAX_FPS = 60;
	protected static final int MAX_FRAME_SKIPS = 5;
	protected static final int FRAME_PERIOD = 1000 / MAX_FPS;
	
	
	/**
	 * Flag to say whether the game is running or not
	 */
	private boolean running = false;
	
	
	/**
	 * Handle to the surface manager object we interact with
	 */
	private SurfaceHolder surfaceHolder;
	
	
	/**
	 * Handler for game-over dialog
	 */
	private Handler handler = null;
	
	
	/**
	 * Current state of this thread
	 */
	private int currentState = STATE_START;
	
	
	/**
	 * Has this thread been started?
	 */
	private boolean alreadyStarted = false;
	
	
	/**
	 * Handle to the game panel
	 */
	private IGame gamesurface = null;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a GameThread
	 */
	public GameThread(SurfaceHolder holder, IGame panel, Handler handler)
	{
		super();
		surfaceHolder = holder;
		gamesurface = panel;
		this.handler = handler;
	}
	
	
	
	
	

	
	
	/**
	 * Get the handle of this thread
	 */
	public Handler getHandler()
	{
		return handler;
	}
	
	
	/**
	 * Set the thread's handler
	 */
	public void setHandler(Handler handler)
	{
		this.handler = handler;
	}
	
	
	
	
	
	
	
	
	/**
	 * Get the current game
	 */
	public IGame getGame()
	{
		return gamesurface;
	}
	
	
	
	
	
	
	
	
	/**
	 * Get the current surface
	 */
	public SurfaceHolder getSurfaceHolder()
	{
		return surfaceHolder;
	}
	
	
	
	

	
	
	
	/**
	 * Has this thread already been started?
	 */
	public boolean hasStarted()
	{
		return alreadyStarted;
	}
	
	
	
	/**
	 * Set that this thread has started
	 */
	public void setHasStarted(boolean started)
	{
		alreadyStarted = started;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set the game to running
	 */
	public void setRunning()
	{
		if (currentState != STATE_LOSE)
			setState(STATE_RUN);
	}
	
	
	
	
	
	
	/**
	 * Stop the thread completely
	 */
	public void setStop()
	{
		setState(STATE_STOP);
	}
	
	
	
	
	
	
	
	

	/**
	 * Is the thread running?
	 */
	public boolean isRunning()
	{
		return running;
	}
	
	
	
	
	
	
	/**
	 * Returns if the thread is currently paused
	 */
	public boolean isPaused()
	{
		return currentState == STATE_PAUSE;
	}
	
	
	
	
	
	
	
	
	/**
	 * Set thread as lost, for game over message
	 */
	public void setLose()
	{
		if (currentState == STATE_RUN)
			setState(STATE_LOSE);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Pause the thread
	 */
	public void pause()
	{
		if (currentState == STATE_RUN)
			setState(STATE_PAUSE);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Unpause the thread
	 */
	public void unpause()
	{
		if (currentState == STATE_PAUSE)
			setState(STATE_RESUME);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Set the state
	 */
	protected void setState(int state)
	{
		//Set the state
		currentState = state;
		
		//Message and Bundle for possible Handle
		Message msg = null;
		Bundle b= null;
		
		
		//take the appropriate action
		switch (currentState)
		{
			case STATE_RUN:
				running = true;
				msg = handler.obtainMessage();
				b = new Bundle();
				b.putInt("viz", 0);
				msg.setData(b);
				handler.sendMessage(msg);
				break;
				
			case STATE_LOSE:
				running = false;
				msg = handler.obtainMessage();
				b = new Bundle();
				b.putInt("viz", 1);
				msg.setData(b);
				handler.sendMessage(msg);
				break;
				
			case STATE_PAUSE:
				break;
				
			case STATE_RESUME:
				setState(STATE_RUN);
				break;
				
			case STATE_STOP:
				running = false;
				break;
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Get the state
	 */
	public int getGameState()
	{
		return currentState;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Actual game loop
	 */
	@Override
	public void run()
	{
		//continue looping here until the surface actually exists
		while (!gamesurface.surfaceExists()) { }
		
		//the canvas
		Canvas c;
		
		//load everything before running
		gamesurface.load();
		
		//timings for framerate
		long beginTime = 0;		//time when the cycle began
		long timeDiff = 0;		//time for a cycle to execute
		int sleepTime = 0;		//ms to sleep (<0 if we're behind)
		int framesSkipped = 0;	//number of frames skipped
		
		//timings for last updates
		long timeSinceLastUpdate = 0;
		long beginTimeOfUpdate = System.currentTimeMillis();
		
		//actual GameTime object
		GameTime gametime = new GameTime(MAX_FPS);
		
		//main loop
		while (running)
		{
			//reset the canvas
			c = null;
			
			//is the game running?
			if (currentState == STATE_RUN)
			{
				//try locking the canvas for pixel editing
				try
				{
					c = surfaceHolder.lockCanvas();
			
					synchronized (surfaceHolder)
					{
						//start time of cycle
						beginTime = System.currentTimeMillis();
						framesSkipped = 0;
						
						//update timers
						timeSinceLastUpdate = System.currentTimeMillis() - beginTimeOfUpdate;
						beginTimeOfUpdate = System.currentTimeMillis();
						gametime.update(timeSinceLastUpdate);
						
						//update and draw
						gamesurface.update(gametime);
						if (c != null) gamesurface.draw(c);
						
						//how long the cycle ran for
						timeDiff = System.currentTimeMillis() - beginTime;
						sleepTime = (int)(FRAME_PERIOD - timeDiff);
						
						//we're ahead of ourselves, slow down!
						if (sleepTime > 0)
						{
							try { Thread.sleep(sleepTime); }
							catch (InterruptedException e) { }
							gametime.IsRunningSlowly = false;
						}
						
						//we're running slowly
						else
						{
							gametime.IsRunningSlowly = true;
						}
						
						//we're running a little late, time to catch up!
						while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS)
						{
							timeSinceLastUpdate = System.currentTimeMillis() - beginTimeOfUpdate;
							gametime.update(timeSinceLastUpdate);
							beginTimeOfUpdate = System.currentTimeMillis();
							
							gamesurface.update(gametime);
							sleepTime += FRAME_PERIOD;
							framesSkipped++;
						}
					}
				}
				finally
				{
					if (c != null)
					{
						surfaceHolder.unlockCanvasAndPost(c);
					}
				}
				
			}
			
			
			//Else we're paused
			else if (currentState == STATE_PAUSE)
			{
				try { Thread.sleep(700); }
				catch (InterruptedException e) { }
			}
			
			
		}
	}

	
	
	
}
