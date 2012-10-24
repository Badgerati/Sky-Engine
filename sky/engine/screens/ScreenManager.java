package sky.engine.screens;

import java.util.ArrayList;

import sky.engine.audio.SoundManager;
import sky.engine.components.Size;
import sky.engine.components.time.GameTime;
import sky.engine.game.GameScreenActivity;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.Colour;
import sky.engine.graphics.ContentManager;
import sky.engine.graphics.textures.TextureManager;
import sky.engine.math.SERandom;
import sky.engine.surfaces.GameScreenSurface;
import sky.engine.threads.GameThread;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class ScreenManager
{
	
	/**
	 * List of all screens
	 */
	private static ArrayList<GameScreen> screens = null;
	private static ArrayList<GameScreen> screensToUpdate = null;
	
	
	/**
	 * Default Resources
	 */
	private static Resources resources = null;
	
	
	/**
	 * Default screen size
	 */
	public static Size screensize = null;
	
	
	/**
	 * Centre point of the screen
	 */
	public static Vector2d screencentre = null;
	
	
	/**
	 * Default screensize, for scaling purposes
	 */
	public static final Size DEFAULT_SIZE = new Size(854.0f, 480.0f, 0.0f);
	
	
	/**
	 * Default scaling factor between two screen sizes
	 */
	public static Size screenscale = null;
	
	
	/**
	 * Default Context
	 */
	private static Context context = null;
	
	
	/**
	 * Default Activity
	 */
	private static GameScreenActivity activity = null;
	
	
	/**
	 * Default Surface
	 */
	protected static GameScreenSurface surface = null;
	
	
	/**
	 * Default Thread
	 */
	private static GameThread thread = null;
	
	
	
	
	
	
	/**
	 * Create a new ScreenManager
	 */
	public ScreenManager(GameScreenActivity activity, Context context, GameScreenSurface surface, GameThread thread)
	{
		screens = new ArrayList<GameScreen>();
		screensToUpdate = new ArrayList<GameScreen>();	
		
		ScreenManager.activity = activity;
		ScreenManager.surface = surface;
		ScreenManager.context = context;//surface.getContext();
		ScreenManager.thread = thread;
	}
	
	
	
	
	/**
	 * Load all content for the screens
	 */
	public void load(Resources resources, Size screensize)
	{
		ScreenManager.resources = resources;
		ScreenManager.screensize = screensize;
		
		ScreenManager.screensize = screensize;
		ScreenManager.screencentre = screensize.mulScalar(0.5f).asVector2D();
		ScreenManager.screenscale = screensize.div(DEFAULT_SIZE);
		
		ContentManager.initialise(resources);
		TextureManager.initialise();
		SoundManager.initialise(context, 10, SoundManager.STREAM_MUSIC, 100);
		SERandom.initialise();
		
		for (int i = 0; i < screens.size(); i++)
		{
			screens.get(i).load(activity);
		}
	}
	
	
	
	
	/**
	 * Handle touch screen input
	 */
	public boolean handleTouchInput(MotionEvent event)
	{		
		for (int i = 0; i < screens.size(); i++)
		{
			if (screens.get(i).isActive())
				return screens.get(i).handleTouchInput(event);
		}
		
		return true;
	}
	
	
	
	
	
	/**
	 * Handle accelerometer
	 */
	public void handleAccelInput(SensorEvent event)
	{
		for (int i = 0; i < screens.size(); i++)
		{
			if (screens.get(i).isActive())
				screens.get(i).handleAccelInput(event);
		}
	}
	
	
	
	
	
	
	/**
	 * Update the screens
	 */
	public void update(GameTime gameTime)
	{
		//clear and copy screens
		screensToUpdate.clear();
		
		for (int i = 0; i < screens.size(); i++)
			screensToUpdate.add(screens.get(i));
		
		boolean otherScreenHasFocus = thread.isPaused();
		boolean coveredByOtherScreen = false;
		
		
		//loop as long as there are screens waiting to be updated
		while (screensToUpdate.size() > 0)
		{
			GameScreen screen = screensToUpdate.get(screensToUpdate.size() - 1);
			screensToUpdate.remove(screensToUpdate.size() - 1);
			
			//update screen
			screen.update(gameTime, otherScreenHasFocus, coveredByOtherScreen);
			
			if (!screen.isActive())
			{
				screen.pause();
			}
			else
			{
				screen.resume();
			}
			
			if (screen.screenState == ScreenState.TransitionOn || screen.screenState == ScreenState.Active)
			{
				if (!screen.isPopup) coveredByOtherScreen = true;
			}
		}
	}
	
	
	
	
	/**
	 * Draw the screens
	 */
	public void draw(Canvas canvas)
	{
		GameScreen screen = null;
		canvas.drawColor(Colour.BLACK);
		
		for (int i = 0; i < screens.size(); i++)
		{
			screen = screens.get(i);
			
			if (screen.screenState == ScreenState.Hidden)
				continue;
			screen.draw(canvas);
			screen.drawUI(canvas);
		}
	}
	
	
	
	
	
	/**
	 * Add a new screen
	 */
	public static void add(GameScreen screen)
	{
		screens.add(screen);
		
		if (ScreenManager.resources != null)
		{
			screen.load(activity);
		}
	}
	
	
	
	
	
	/**
	 * Remove a screen
	 */
	public static void remove(GameScreen screen)
	{
		screens.remove(screen);
		screensToUpdate.remove(screen);
	}
	
	
	
	
	
	/**
	 * Returns the number of screens
	 */
	public static int size()
	{
		return screens.size();
	}
	
	
	
	
	
	
	/**
	 * Pauses the screens
	 */
	public static void pause()
	{
		for (int i = 0; i < screens.size(); i++)
		{
			if (screens.get(i).isActive())
				screens.get(i).pause();
		}
		
		thread.pause();
	}
	
	
	
	
	
	/**
	 * Resumes the screens
	 */
	public static void resume()
	{
		for (int i = 0; i < screens.size(); i++)
		{
			if (screens.get(i).isActive())
				screens.get(i).resume();
		}
		
		thread.resume();
	}
	
	
	
	
	
	/**
	 * What to do when the back key is pressed
	 */
	public static void onBackKey()
	{
		if (screens.size() == 0)
		{
			quit();
		}
		
		for (int i = 0; i < screens.size(); i++)
		{
			if (screens.get(i).isActive())
				screens.get(i).onBackKey();
		}
	}
	
	
	
	
	
	/**
	 * Quit the current whole activity
	 */
	public static void quit()
	{
		activity.quit();
	}
	
	
	
	
	
	
	/**
	 * Fades a screen in/out, or for pop-ups
	 */
	public static void fadeToBlack(int alpha)
	{
		
	}
	
	
	
	
	
	/**
	 * Returns the screens
	 */
	public static GameScreen[] getScreens()
	{
		return (GameScreen[])screens.toArray();
	}
	
}
