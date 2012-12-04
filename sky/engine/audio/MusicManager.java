package sky.engine.audio;

import java.util.HashMap;
import java.util.Set;

import android.content.Context;
import android.media.MediaPlayer;

public abstract class MusicManager
{
	
	/**
	 * Map for storing MediaPlayers and IDs
	 */
	protected static HashMap<Integer, MediaPlayer> musics = null;
	
	
	/**
	 * Context to help create MediaPlayers
	 */
	protected static Context context = null;
	
	
	/**
	 * Is the music muted?
	 */
	protected static boolean Muted = false;
	
	
	
	
	
	/**
	 * Initialises the Music Manager
	 */
	public static void initialise(Context context)
	{
		MusicManager.context = context;
		musics = new HashMap<Integer, MediaPlayer>();
	}
	
	
	
	
	/**
	 * Load a music file
	 */
	public static void load(int resourceID, int musicID, boolean loopFlag)
	{
		MediaPlayer player = MediaPlayer.create(context, resourceID);	
		player.setLooping(loopFlag);
		musics.put(musicID, player);
	}
	
	
	
	
	
	
	
	/**
	 * Returns current Set of Music IDs used. Null is returned if map does
	 * not exist.
	 */
	public static Set<Integer> getMusicIDs()
	{
		if (musics != null) {
			return musics.keySet();
		}
		
		return null;
	}
	
	
	
	
	
	
	/**
	 * Play a music file with given ID
	 */
	public static void play(int musicID, float volume)
	{
		if (Muted) volume = 0f;
		
		if (musics != null)
		{
			MediaPlayer temp = musics.get(musicID);
			temp.setVolume(volume, volume);
			temp.start();
		}
	}
	
	
	
	
	
	
	/**
	 * Pause a music file with given ID
	 */
	public static void pause(int musicID)
	{
		if (musics != null)
		{
			musics.get(musicID).pause();
		}
	}
	
	
	
	
	
	
	/**
	 * Loop a music file with given ID
	 */
	public static void loop(int musicID, boolean loopFlag)
	{		
		if (musics != null)
		{
			musics.get(musicID).setLooping(loopFlag);
		}
	}
	
	
	
	
	
	
	/**
	 * Stop a music file with given ID
	 */
	public static void stop(int musicID)
	{
		if (musics != null)
		{
			musics.get(musicID).stop();
		}
	}
	
	
	
	
	
	
	/**
	 * Stop all music files
	 */
	public static void stopAll()
	{
		if (musics != null)
		{
			for (int key : musics.keySet())
			{
				musics.get(key).stop();
			}
		}
	}
	
	
	
	
	
	/**
	 * Set music to be muted
	 */
	public static void setMuted(boolean flag)
	{
		Muted = flag;
		float volume = flag ? 0 : 1;

		if (musics != null)
		{
			for (int key : musics.keySet())
			{
				musics.get(key).setVolume(volume, volume);
			}
		}
	}
	
	
	
	
	
	/**
	 * Returns if the music is currently being muted
	 */
	public static boolean isMuted()
	{
		return Muted;
	}
	
	
	
	
	
	
	/**
	 * Sets the volume of a music file with given ID
	 */
	public static void setVolume(int musicID, float volume)
	{
		if (Muted) volume = 0f;
		
		if (musics != null)
		{
			musics.get(musicID).setVolume(volume, volume);
		}
	}
	
	
	
	
	
	
	
	/**
	 * Remove a music file with given ID
	 */
	public static void remove(int musicID)
	{
		if (musics != null)
		{
			musics.get(musicID).release();
			musics.remove(musicID);
		}
	}
	
	
	
	
	
	
	/**
	 * Remove all music files
	 */
	public static void clear()
	{
		if (musics != null)
		{
			for (int key : musics.keySet())
			{
				musics.get(key).release();
			}
			
			musics.clear();
		}
	}
	
	
	
	
	
	/**
	 * Returns the number of music files currently loaded
	 */
	public static int size()
	{
		if (musics != null)
			return musics.size();
		
		return 0;
	}
	
	
}
