package sky.engine.graphics.gui;

import java.util.ArrayList;

import sky.engine.components.time.GameTime;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.DrawableComponent;
import sky.engine.graphics.IDrawableComponent;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class Panel extends DrawableComponent
{
	
	/**
	 * Array of drawable components for this panel
	 */
	protected ArrayList<IDrawableComponent> components = null;
	
	
	/**
	 * Height of the Panel
	 */
	protected float height = 0;
	
	
	/**
	 * Width of the Panel
	 */
	protected float width = 0;
	
	
	
	
	
	
	/**
	 * Create a new Panel
	 */
	public Panel(float height, float width)
	{
		components = new ArrayList<IDrawableComponent>();
		this.height = height;
		this.width = width;
	}
	
	
	/**
	 * Create a new Panel
	 */
	public Panel(Vector2d position, float height, float width)
	{
		Position = position.clone();
		components = new ArrayList<IDrawableComponent>();
		this.height = height;
		this.width = width;
	}
	
	
	
	
	
	/**
	 * Set the Panel's position
	 */
	@Override
	public void setPosition(Vector2d position)
	{
		Vector2d delta = Position.sub(position);
		super.setPosition(position);

		for (int i = 0; i < components.size(); i++)
			components.get(i).setPosition(components.get(i).getPosition().add(delta));
	}
	
	
	
	
	
	
	/**
	 * Add a drawable component
	 */
	public void add(IDrawableComponent component)
	{
		components.add(component);
	}
	
	
	
	
	
	
	/**
	 * Add a drawable component and offset its position
	 */
	public void addAndOffset(IDrawableComponent component)
	{
		component.setPosition(component.getPosition().add(Position));
		components.add(component);
	}
	
	
	

	
	
	/**
	 * Remove a drawable component
	 */
	public void remove(IDrawableComponent component)
	{
		components.remove(component);
	}
	
	
	
	
	
	
	/**
	 * Remove a drawable component
	 */
	public void remove(int index)
	{
		if (index < 0 || index >= components.size())
			throw new IndexOutOfBoundsException();
		
		components.remove(index);
	}
	
	
	
	
	
	/**
	 * Returns the number of components
	 */
	public int size()
	{
		return components.size();
	}
	
	
	
	
	
	/**
	 * Update the Panel and components
	 */
	@Override
	public void update(GameTime gameTime)
	{
		for (int i = 0; i < components.size(); i++)
			components.get(i).update(gameTime);
	}
	
	
	
	
	
	/**
	 * Draw the Panel and components
	 */
	@Override
	public void draw(Canvas canvas)
	{
		for (int i = 0; i < components.size(); i++)
			components.get(i).draw(canvas);
	}
	
	
	
}
