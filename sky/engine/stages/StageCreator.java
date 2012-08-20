package sky.engine.stages;

import sky.engine.audio.SoundManager;
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
 * @author Matthew Kelly (Badgerati)
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
	public static PauseButton pausebutton = null;
	
	
	/**
	 * Size of the screen
	 */
	public Size screensize = null;
	
	
	
	
	
	
	
	
	
	
	
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
		
		this.accelerometer = new Vector3();
	}
	
	
	
	
	
	
	
}
