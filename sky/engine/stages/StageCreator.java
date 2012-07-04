package sky.engine.stages;

import sky.engine.audio.SoundManager;
import sky.engine.geometry.vectors.Vector3D;
import sky.engine.graphics.textures.TextureManager;
import sky.engine.threads.GameThread;
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
	 * Game thread for ending the game.
	 */
	protected GameThread thread = null;
	
	
	/**
	 * Texture Manager.
	 */
	protected TextureManager texturemanager = null;
	
	
	/**
	 * Sound Manager.
	 */
	protected SoundManager soundmanager = null;
	
	
	/**
	 * Vector to store the values from the accelerometer.
	 */
	protected Vector3D accelerometer = null;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create a new stage instance
	 */
	public StageCreator(Context context, GameThread thread)
	{
		this.context = context;
		this.thread = thread;
		this.texturemanager = new TextureManager(context.getResources());
		this.soundmanager = new SoundManager(context, 10, 100, SoundManager.STREAM_MUSIC);
		this.accelerometer = new Vector3D();
	}
	
	
	
	
	
	
	
}
