package sky.engine.audio;

import java.util.HashMap;
import java.util.Set;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class SoundManager
{
	
	/**
	 * Constant for audio stream of system sounds
	 */
	public static final int STREAM_SYSTEM = 0x00000001;
	
	
	/**
	 * Constant for audio stream for the phone ring
	 */
	public static final int STREAM_RING = 0x00000002;
	
	
	/**
	 * Constant for audio stream of music playback
	 */
	public static final int STREAM_MUSIC = 0x00000003;
	
	
	/**
	 * Constant for audio stream for alarms
	 */
	public static final int STREAM_ALARM = 0x00000004;
	
	
	/**
	 * Constant for audio stream of notifications
	 */
	public static final int STREAM_NOTIFICATIONS = 0x00000005;
	
	
	/**
	 * The sound pool to load sounds and play them
	 */
	protected static SoundPool soundpool = null;
	
	
	/**
	 * Audio Manager to deal with volume	
	 */
	protected static AudioManager audiomanager = null;
	
	
	/**
	 * Sound pool map for the sounds loaded into this sound manager
	 */
	protected static HashMap<Integer, Integer> sounds = null;
	
	
	/**
	 * Context to help load sounds
	 */
	protected static Context context = null;
	
	
	
	
	
	
	
	
	/**
	 * Initialises the Sound Manager
	 */
	public static void initialise(Context context, int maxstreams, int streamType, int streamQuality)
	{
		SoundManager.context = context;
		soundpool = new SoundPool(maxstreams, streamType, streamQuality);
		audiomanager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		sounds = new HashMap<Integer, Integer>();
	}
	
	
	
	
	
	
	
	
	/**
	 * Load sound into soundpool
	 */
	public static void load(int resourceID, int soundID, int priority)
	{
		sounds.put(soundID, soundpool.load(context, resourceID, priority));
	}
	
	
	
	
	
	
	
	/**
	 * Returns current Set of Sound IDs used. Null is returned if SoundPool does
	 * not exist.
	 */
	public static Set<Integer> getSoundIDs()
	{
		if (sounds != null) {
			return sounds.keySet();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	/**
	 * Play sound from soundpool with given ID at volume level
	 */
	public static void play(int soundID, float volumelevel)
	{
		float streamVolumeCurrent = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
		float streamVolumeMax = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);    
		float volume = (streamVolumeCurrent / streamVolumeMax) * volumelevel;
		
		//Play the sound with the correct volume
		if (soundpool != null && sounds != null)
		{
			try {
				soundpool.play(sounds.get(soundID), volume, volume, 1, 0, 1f);
			}
			catch (Exception e) { }
		}
	}
	
	
	

}
