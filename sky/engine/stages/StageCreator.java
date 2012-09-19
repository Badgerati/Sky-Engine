package sky.engine.stages;

import sky.engine.audio.SoundManager;
import sky.engine.components.Randomiser;
import sky.engine.components.Size;
import sky.engine.game.GameActivity;
import sky.engine.geometry.vectors.Vector3;
import sky.engine.graphics.textures.TextureManager;
import sky.engine.surfaces.GameSurface;
import sky.engine.threads.GameThread;
import sky.engine.ui.buttons.PauseButton;
import android.content.Context;

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
	protected Vector3 accelerometer = null;
	
	
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
	public Size screencentre = null;
	
	
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
		
		TextureManager.initialise(context.getResources());
		SoundManager.initialise(context, 10, SoundManager.STREAM_MUSIC, 100);
		Randomiser.initialise();
		
		this.accelerometer = new Vector3();
	}
	
	
	
	
	
	/**
	 * Load any content across all stages
	 */
	public void load(Size screensize)
	{
		this.screensize = screensize;
		this.screencentre = screensize.mulScalar(0.5f);
		this.screenscale = screensize.div(DEFAULT_SIZE);
	}
	
	
	
	
	
	/**
	 * Pause the game
	 */
	public void pause()
	{
		if (pausebutton != null)
			pausebutton.pause();
		else
			thread.pause();
	}
	
	
	
	
	
	/**
	 * Resume the game
	 */
	public void resume()
	{
		if (pausebutton != null)
			pausebutton.unpause();
		else
			thread.unpause();
	}
	
	
	
	
	
	
	
}
