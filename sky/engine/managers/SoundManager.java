package sky.engine.managers;

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
public class SoundManager
{
	/**
	 * Constant for audio stream of music playback
	 */
	public static final int STREAM_MUSIC = 0x00000003;
	
	
	/**
	 * Constant for audio stream of notifications
	 */
	public static final int STREAM_NOTIFICATIONS = 0x00000005;
	
	
	/**
	 * Constant for audio stream for the phone ring
	 */
	public static final int STREAM_RING = 0x00000002;
	
	
	/**
	 * Constant for audio stream of system sounds
	 */
	public static final int STREAM_SYSTEM = 0x00000001;
	
	
	/**
	 * Constant for audio stream for alarms
	 */
	public static final int STREAM_ALARM = 0x00000004;
	
	
	/**
	 * The sound pool to load sounds and play them
	 */
	private SoundPool soundpool = null;
	
	
	/**
	 * Audio Manager to deal with volume	
	 */
	private AudioManager audiomanager = null;
	
	
	/**
	 * Sound pool map for the sounds loaded into this sound manager
	 */
	private HashMap<Integer, Integer> soundpoolMap = null;
	
	
	/**
	 * Context to help load sounds
	 */
	private Context context = null;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create a new SoundManager object
	 */
	public SoundManager(Context context, int maxStreams, int soundQuality, int streamType)
	{
		this.context = context;
		
		soundpool = new SoundPool(maxStreams, streamType, soundQuality);
		audiomanager = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
		
		soundpoolMap = new HashMap<Integer, Integer>();
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Load sound into soundpool
	 */
	public void loadSound(int soundID, int soundResID, int priority)
	{
		soundpoolMap.put(soundID, soundpool.load(context, soundResID, priority));
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Returns current Set of Sound IDs used. Null is returned if SoundPool does
	 * not exist.
	 */
	public Set<Integer> getSoundIDs()
	{
		if (soundpoolMap != null) {
			return soundpoolMap.keySet();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Play sound from soundpool with given ID at volume level
	 */
	public void playSound(int soundID, float volumelevel)
	{
		float streamVolumeCurrent = audiomanager.getStreamVolume(AudioManager.STREAM_MUSIC);
		float streamVolumeMax = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);    
		float volume = (streamVolumeCurrent / streamVolumeMax) * volumelevel;
		
		//Play the sound with the correct volume
		if (soundpool != null && soundpoolMap != null) {
			soundpool.play(soundpoolMap.get(soundID), volume, volume, 1, 0, 1f);
		}
	}
	
	
	
	
	
	
	
	

}
