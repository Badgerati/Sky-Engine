package sky.engine.stages;

import sky.engine.components.Size;
import sky.engine.components.time.GameTime;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.hardware.SensorEvent;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public interface IStage
{
	/**
	 * Loading content
	 */
	public void load(Resources res, Size screensize);
	
	
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
	public void update(GameTime gameTime);
	
	
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

}
