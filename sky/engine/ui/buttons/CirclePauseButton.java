package sky.engine.ui.buttons;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.bounds.BoundingCircle;
import sky.engine.graphics.drawable.shapes.DrawableCircle;
import sky.engine.graphics.paints.Paints;
import sky.engine.threads.GameThread;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class CirclePauseButton extends PauseButton
{	
	
	/**
	 * 
	 */
	public CirclePauseButton(GameThread thread, float radius, float textsize,
			int tcolour, Vector2 position, Paints p_initial, Paints p_pause)
	{
		super(thread, textsize, tcolour, position, p_initial, p_pause);
		
		pauseBound = new BoundingCircle(position, radius + 25);
		pauseBtn = new DrawableCircle(position, radius, initfill, initoutline, initblur);
	}
	
}
