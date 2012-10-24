package sky.engine.screens;

import sky.engine.components.time.GameTime;
import sky.engine.game.GameScreenActivity;
import android.graphics.Canvas;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public interface IScreen
{
	/**
	 * Loading content
	 */
	public void load(GameScreenActivity activity);
	
	
	/**
	 * Handling touch input
	 */
	public boolean handleTouchInput(MotionEvent event);
	
	
	/**
	 * Handling accelerometer input
	 */
	public void handleAccelInput(SensorEvent event);
	
	
	/**
	 * Update the game
	 */
	public void update(GameTime gameTime, boolean otherScreenHasFocus, boolean coveredByOtherScreen);
	
	
	/**
	 * Draw everything graphical
	 */
	public void draw(Canvas canvas);
	
	
	/**
	 * Draw everything for the UI
	 */
	public void drawUI(Canvas canvas);
	
	
	/**
	 * Pause all possible timers, and other things
	 */
	public void pause();
	
	
	/**
	 * Resumes all possible timers, and other things
	 */
	public void resume();
	
	
	/**
	 * Handler for when the back key is pressed
	 */
	public void onBackKey();

}
