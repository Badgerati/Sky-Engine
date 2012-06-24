package sky.engine.game;

import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public interface GameInterface
{
	/**
	 * Does the surface exist?
	 */
	public boolean surfaceExists();
	
	
	/**
	 * Loading content
	 */
	public void load();
	
	
	/**
	 * Update the game
	 */
	public void update(long gameTime);
	
	
	/**
	 * Draw everything
	 */
	public void draw(Canvas canvas);
	
	
	/**
	 * Draw everything, with a given cls colour
	 */
	public void draw(Canvas canvas, int cls);

}
