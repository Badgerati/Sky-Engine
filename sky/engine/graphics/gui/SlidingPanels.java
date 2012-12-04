package sky.engine.graphics.gui;

import java.util.ArrayList;

import sky.engine.components.time.GameTime;
import sky.engine.graphics.DrawableComponent;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class SlidingPanels extends DrawableComponent
{
	
	/**
	 * Array of Panels
	 */
	protected ArrayList<Panel> panels = null;
	
	
	/**
	 * Index of current active Panel
	 */
	protected int currentActivePanel = 0;
	
	
	
	
	
	/**
	 * Create a new SlidingPanels
	 */
	public SlidingPanels()
	{
		panels = new ArrayList<Panel>();
	}
	
	
	
	
	/**
	 * Add a Panel
	 */
	public void add(Panel panel)
	{
		panels.add(panel);
	}
	
	
	
	
	
	/**
	 * Add a Panel and offset it
	 */
	public void addAndOffset(Panel panel)
	{
		return;
	}
	
	
	

	
	
	/**
	 * Remove a Panel
	 */
	public void remove(Panel panel)
	{
		panels.remove(panel);
	}
	
	
	
	
	
	
	/**
	 * Remove a Panel
	 */
	public void remove(int index)
	{
		if (index < 0 || index >= panels.size())
			throw new IndexOutOfBoundsException();
		
		panels.remove(index);
	}
	
	
	
	
	
	/**
	 * Returns the panels
	 */
	public int size()
	{
		return panels.size();
	}
	
	
	
	
	
	/**
	 * Returns the number of components for the Panel at the given index
	 */
	public int size(int index)
	{
		if (index < 0 || index >= panels.size())
			throw new IndexOutOfBoundsException();
		
		return panels.get(index).size();
	}
	
	
	
	
	
	/**
	 * Update the Panels
	 */
	@Override
	public void update(GameTime gameTime)
	{
		for (int i = 0; i < panels.size(); i++)
			if (i == currentActivePanel)
				panels.get(i).update(gameTime);
	}
	
	
	
	
	
	/**
	 * Draw the Panels
	 */
	@Override
	public void draw(Canvas canvas)
	{
		for (int i = 0; i < panels.size(); i++)
			if (i >= currentActivePanel - 1 && i <= currentActivePanel + 1)
				panels.get(i).draw(canvas);
	}
	
}
