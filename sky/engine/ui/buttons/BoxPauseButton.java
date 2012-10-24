package sky.engine.ui.buttons;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.paints.Paints;
import sky.engine.graphics.shapes.DrawableBox;
import sky.engine.physics.bounding.BoundingAABB;
import sky.engine.threads.GameThread;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class BoxPauseButton extends PauseButton
{	
	
	/**
	 * 
	 */
	public BoxPauseButton(GameThread thread, float width, float height, float textsize,
			int tcolour, Vector2d position, Paints p_initial, Paints p_pause)
	{
		super(thread, textsize, tcolour, position, p_initial, p_pause);
		
		pauseBound = new BoundingAABB(position, width + 25, height + 20);
		pauseBtn = new DrawableBox(position, width, height, initfill, initoutline, initblur);
	}
	
}
