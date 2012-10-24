package sky.engine.stages;

import java.util.ArrayList;

import sky.engine.audio.SoundManager;
import sky.engine.components.Size;
import sky.engine.components.time.Timer;
import sky.engine.game.GameActivity;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.geometry.vectors.Vector3d;
import sky.engine.graphics.Colour;
import sky.engine.graphics.ContentManager;
import sky.engine.graphics.textures.TextureManager;
import sky.engine.math.SERandom;
import sky.engine.surfaces.GameSurface;
import sky.engine.threads.GameThread;
import sky.engine.ui.buttons.PauseButton;
import android.content.Context;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class StageCreator
{
	/**
	 * Context of the game view.
	 */
	protected Context context = null;
	
	
	/**
	 * Surface of the whole game.
	 */
	protected GameSurface gamesurface = null;
	
	
	/**
	 * Activity the game is running under
	 */
	protected GameActivity activity = null;
	
	
	/**
	 * Game thread for ending the game.
	 */
	protected GameThread thread = null;
	
	
	/**
	 * Vector to store the values from the accelerometer.
	 */
	protected Vector3d accelerometer = null;
	
	
	/**
	 * Array of all Timers in the game, for easier dealing
	 */
	protected ArrayList<Timer> timers = null;
	
	
	/**
	 * Pause button
	 */	
	protected PauseButton pausebutton = null;
	
	
	/**
	 * Size of the screen
	 */
	public Size screensize = null;
	
	
	/**
	 * Centre point of the screen
	 */
	public Vector2d screencentre = null;
	
	
	/**
	 * Default screensize, for scaling purposes
	 */
	public static final Size DEFAULT_SIZE = new Size(854.0f, 480.0f, 0.0f);
	
	
	/**
	 * Scaling factor between two screen sizes
	 */
	public Size screenscale = null;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create a new stage instance
	 */
	public StageCreator(GameActivity activity, GameSurface surface, GameThread thread)
	{
		this.activity = activity;
		this.gamesurface = surface;
		this.context = surface.getContext();
		this.thread = thread;
		this.timers = new ArrayList<Timer>();
		
		ContentManager.initialise(context.getResources());
		TextureManager.initialise();
		SoundManager.initialise(context, 10, SoundManager.STREAM_MUSIC, 100);
		SERandom.initialise();
		
		this.accelerometer = new Vector3d();
	}
	
	
	
	
	
	/**
	 * Load any content across all stages
	 */
	public void load(Size screensize)
	{
		this.screensize = screensize;
		this.screencentre = screensize.mulScalar(0.5f).asVector2D();
		this.screenscale = screensize.div(DEFAULT_SIZE);
	}
	
	
	
	
	
	
	/**
	 * Updates any timers within the game
	 */
	public void update()
	{
		for (int i = 0; i < timers.size(); i++)
		{
			if (timers.get(i).isStarted())
				timers.get(i).update();
		}
	}
	
	
	
	
	
	
	/**
	 * Draw any graphics across all stages
	 * Screen is also defaulted CLS black
	 */
	public void draw(Canvas canvas)
	{
		canvas.drawColor(Colour.BLACK);
	}
	
	
	
	
	
	/**
	 * Draw any graphics across all stages
	 */
	public void draw(Canvas canvas, int cls_colour)
	{
		canvas.drawColor(cls_colour);
	}
	
	
	
	
	
	/**
	 * Pause the game
	 */
	public void pause()
	{
		//pause timers
		for (int i = 0; i < timers.size(); i++)
		{
			if (timers.get(i).isStarted())
				timers.get(i).pause();
		}
		
		//pause the game
		if (pausebutton != null)
		{
			pausebutton.pause();
		}
		else
		{
			thread.pause();
		}
	}
	
	
	
	
	
	/**
	 * Resume the game
	 */
	public void resume()
	{
		//resume timers
		for (int i = 0; i < timers.size(); i++)
		{
			if (timers.get(i).isPaused())
				timers.get(i).resume();
		}
		
		//resume the game
		if (pausebutton != null)
		{
			pausebutton.unpause();
		}
		else
		{
			thread.unpause();
		}
	}
	
	
	
	
	
	
	
}
