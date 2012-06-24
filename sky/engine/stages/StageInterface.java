package sky.engine.stages;

import sky.engine.components.Size;
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
public interface StageInterface
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
	public void update(long gameTime);
	
	
	/**
	 * Draw everything
	 */
	public void draw(Canvas canvas);

}
