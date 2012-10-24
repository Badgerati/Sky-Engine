package sky.engine.ui.buttons;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.paints.Paints;
import sky.engine.graphics.shapes.DrawableCircle;
import sky.engine.physics.bounding.BoundingCircle;
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
			int tcolour, Vector2d position, Paints p_initial, Paints p_pause)
	{
		super(thread, textsize, tcolour, position, p_initial, p_pause);
		
		pauseBound = new BoundingCircle(position, radius + 25);
		pauseBtn = new DrawableCircle(position, radius, initfill, initoutline, initblur);
	}
	
}
