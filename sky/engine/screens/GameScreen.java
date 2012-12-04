package sky.engine.screens;

import java.util.ArrayList;

import sky.engine.components.time.GameTime;
import sky.engine.components.time.TimeSpan;
import sky.engine.components.time.Timer;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.math.MathHelper;
import android.graphics.Canvas;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class GameScreen implements IScreen
{
	/**
	 * Normally when one screen is brought up over the top of another,
     * the first screen will transition off to make room for the new
     * one. This property indicates whether the screen is only a small
     * pop-up, in which case screens underneath it do not need to bother
     * transitioning off
	 */
	public boolean isPopup = false;
	
	
	/**
	 * Indicates how long the screen takes to transition on when it is
	 * activated
	 */
	public TimeSpan transitionOnTime = TimeSpan.zero();
	
	
	/**
	 * Indicates how long the screen takes to transition off when it is
	 * activated
	 */
	public TimeSpan transitionOffTime = TimeSpan.zero();
	
	
	/**
	 * Indicates how far through the transition the screen is, 255 is fully
	 * active with no transparency, 0 is fully transitioned off
	 */
	public float transitionPosition = 255f;
	
	
	/**
	 * The current screen transition state
	 */
	public ScreenState screenState = ScreenState.TransitionOn;
	
	
	/**
	 * There are 2 reasons as to why a screen may transition off. It could be
	 * temporarily going away to make room for another that is on top of it, or
	 * it could be going away for good. This property indictes whether a screen
	 * is exiting for good, if set the screen will automatically remove itself
	 * once the transition off has finished
	 */
	public boolean isExiting = false;
	
	
	/**
	 * Indicates whether another screen has focus
	 */
	protected boolean otherScreenHasFocus = false;
	
	
	/**
	 * Indicates if all required content has been loaded
	 */
	protected boolean ContentLoaded = false;
	
	
	/**
	 * Array of all Timers in the screen, for easier dealing
	 */
	protected ArrayList<Timer> timers = new ArrayList<Timer>();
	
	
	/**
	 * List of Drawable Components
	 */
	private ArrayList<IDrawableComponent> drawableComponents = new ArrayList<IDrawableComponent>();
	
	
	/**
	 * List of Drawable UI Components
	 */
	private ArrayList<IDrawableComponent> drawableUIComponents = new ArrayList<IDrawableComponent>();
	
	
	
	
	
	
	
	/**
	 * GameScreen
	 */
	public GameScreen()
	{
		transitionOnTime = new TimeSpan();
		transitionOffTime = new TimeSpan();
	}
	
	
	
	
	
	
	
	/**
	 * Load the content of the screen
	 */
	public void load()
	{
		ContentLoaded = true;
	}
	
	
	
	
	
	/**
	 * Unload content
	 */
	public void unload()
	{
		drawableComponents.clear();
		drawableUIComponents.clear();
	}
	
	
	
	
	
	
	/**
	 * Handling touch input
	 */
	public boolean handleTouchInput(MotionEvent event) { return true; }
	
	
	
	
	
	
	/**
	 * Handling accelerometer input
	 */
	public void handleAccelInput(SensorEvent event) { }
	
	
	
	
	
	
	
	/**
	 * Updates the screen, such as updating the transition position. This
	 * method is always called, regardless of whether the screen is active,
	 * hidden, or in the middle of a transition
	 */
	public void update(GameTime gameTime, boolean otherScreenHasFocus, boolean coveredByOtherScreen)
	{
		//timers
		if (isActive())
		{
			for (int i = 0; i < timers.size(); i++)
			{
				if (timers.get(i).isStarted())
					timers.get(i).update();
			}
		}
		
		
		//transitions
		this.otherScreenHasFocus = otherScreenHasFocus;
		
		if (isExiting)
		{
			//if exiting, it should transition off
			screenState = ScreenState.TransitionOff;
			
			if (!updateTransition(gameTime, transitionOffTime, 1))
			{
				ScreenManager.remove(this);
				isExiting = false;
			}
		}
		
		else if (coveredByOtherScreen)
		{
			//if screen is covered by another, transition off
			if (updateTransition(gameTime, transitionOffTime, 1))
			{
				screenState = ScreenState.TransitionOff;
			}
			else
			{
				screenState = ScreenState.Hidden;
			}
		}
		
		else
		{
			//otherwise, screen should transition on and become active
			if (updateTransition(gameTime, transitionOnTime, -1))
			{
				screenState = ScreenState.TransitionOn;
			}
			else
			{
				screenState = ScreenState.Active;
			}
		}
		
	}
	
	
	
	
	/**
	 * Helper method for updating the screen transition position
	 */
	protected boolean updateTransition(GameTime gametime, TimeSpan time, int direction)
	{
		float transitionDelta = 0f;
		
		if (time.equals(TimeSpan.zero()))
			transitionDelta = 1f;
		else
			transitionDelta = (float)(gametime.ElapsedGameTime / time.TotalMilliseconds());
		
		transitionPosition += (transitionDelta * direction);
		
		if ((transitionPosition <= 0) || (transitionPosition >= 1))
		{
			transitionPosition = MathHelper.clamp(transitionPosition, 0, 1);
			return false;
		}
		
		return true;
	}
	
	
	
	
	
	/**
	 * Draw the screen
	 */
	public void draw(Canvas canvas)
	{		
		for (int i = 0; i < drawableComponents.size(); i++)
		{
			drawableComponents.get(i).draw(canvas);
		}		
	}
	
	
	
	
	
	/**
	 * Draw the screen's UI
	 */
	public void drawUI(Canvas canvas)
	{
		for (int i = 0; i < drawableUIComponents.size(); i++)
		{
			drawableUIComponents.get(i).draw(canvas);
		}
	}
	
	
	
	
	
	
	/**
	 * Tells the screen to go away
	 */
	public void exitScreen()
	{
		if (transitionOffTime.equals(TimeSpan.zero()))
		{
			unload();
			ScreenManager.remove(this);
		}
		else
		{
			isExiting = true;
		}
	}
	
	
	
	
	
	
	
	/**
	 * Returns if this screen is active
	 */
	public boolean isActive()
	{
		return !otherScreenHasFocus && (screenState == ScreenState.TransitionOn || screenState == ScreenState.Active);
	}
	
	
	
	
	
	/**
	 * Pause the screen
	 */
	public void pause()
	{
		//pause timers
		for (int i = 0; i < timers.size(); i++)
		{
			if (timers.get(i).isStarted())
				timers.get(i).pause();
		}
	}
	
	
	
	
	
	/**
	 * Resume the screen
	 */
	public void resume()
	{
		//resume timers
		for (int i = 0; i < timers.size(); i++)
		{
			if (timers.get(i).isPaused())
				timers.get(i).resume();
		}
	}
	
	
	
	
	
	/**
	 * Handler for when the back ket is pressed
	 */
	public void onBackKey()
	{
		return;
	}
	
	
	
	
	
	/**
	 * Add a Drawable Component
	 */
	public void addDrawable(IDrawableComponent component)
	{
		drawableComponents.add(component);
	}
	
	
	
	
	
	/**
	 * Remove a Drawable Component
	 */
	public void removeDrawable(IDrawableComponent component)
	{
		drawableComponents.remove(component);
	}
	
	
	
	
	
	/**
	 * Add a Drawable UI Component
	 */
	public void addDrawableUI(IDrawableComponent component)
	{
		drawableUIComponents.add(component);
	}
	
	
	
	
	
	/**
	 * Remove a Drawable UI Component
	 */
	public void removeDrawableUI(IDrawableComponent component)
	{
		drawableUIComponents.remove(component);
	}
	
	
}
