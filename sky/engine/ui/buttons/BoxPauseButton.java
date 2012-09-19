package sky.engine.ui.buttons;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.bounds.BoundingBox;
import sky.engine.graphics.drawable.shapes.DrawableBox;
import sky.engine.graphics.paints.Paints;
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
			int tcolour, Vector2 position, Paints p_initial, Paints p_pause)
	{
		super(thread, textsize, tcolour, position, p_initial, p_pause);
		
		pauseBound = new BoundingBox(position, width + 25, height + 20);
		pauseBtn = new DrawableBox(position, width, height, initfill, initoutline, initblur);
	}
	
}
