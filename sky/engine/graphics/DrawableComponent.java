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
public abstract class DrawableComponent implements IDrawableComponent
{
	
	/**
	 * position of the component
	 */
	protected Vector2d Position = Vector2d.zeros();

	
	/**
	 * Set the position of this component
	 */
	public void setPosition(Vector2d position)
	{
		Position.X = position.X;
		Position.Y = position.Y;
	}

	
	/**
	 * Returns the position of the component
	 */
	public Vector2d getPosition()
	{
		return Position.clone();
	}
	
	
	/**
	 * Update the component
	 */
	public void update(GameTime gameTime)
	{
		return;
	}
	
	
	/**
	 * Draw the component
	 */
	public void draw(Canvas canvas)
	{
		return;
	}
	
	
	
}
