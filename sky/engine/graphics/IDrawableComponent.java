package sky.engine.graphics;

import sky.engine.components.time.GameTime;
import sky.engine.geometry.vectors.Vector2d;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public interface IDrawableComponent
{	
	/**
	 * Set component's position
	 */
	public void setPosition(Vector2d position);
	
	
	/**
	 * Returns component's position
	 */
	public Vector2d getPosition();
	
	
	/**
	 * Update the component
	 */
	public void update(GameTime gameTime);
	
	
	/**
	 * draw component to the canvas
	 */
	public void draw(Canvas canvas);
	
}
