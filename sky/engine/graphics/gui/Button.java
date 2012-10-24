package sky.engine.graphics.gui;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.Colour;
import sky.engine.graphics.IDrawableComponent;
import sky.engine.graphics.paints.Paints;
import sky.engine.graphics.shapes.DrawableCircle;
import sky.engine.graphics.shapes.DrawableRoundBox;
import sky.engine.graphics.shapes.IDrawableShape;
import sky.engine.graphics.text.CustomText;
import sky.engine.physics.bounding.BoundingAABB;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class Button implements IDrawableComponent
{
	
	/**
	 * States
	 */
	protected final static int STATE_NORMAL = 1;
	protected final static int STATE_FOCUSED = 2;
	protected final static int STATE_CLICKED = 3;
	
	
	/**
	 * Current state of the button
	 */
	protected int currentState = STATE_NORMAL;
	
	
	/**
	 * Previous state of the button
	 */
	protected int previousState = 0;
	
	
	/**
	 * Is the button focusable
	 */
	public boolean Focusable = true;
	
	
	/**
	 * Position of the Button
	 */
	protected Vector2d position = Vector2d.zeros();
	
	
	/**
	 * Text to be displayed
	 */
	protected CustomText text = null;
	
	
	/**
	 * Height of the Button
	 */
	protected float height = 0;
	
	
	/**
	 * Width of the Button
	 */
	protected float width = 0;
	
	
	/**
	 * Bounding volume for the button
	 */
	protected BoundingAABB buttonBound = null;
	
	
	/**
	 * Shape for the Button
	 */
	protected IDrawableShape button = null;
	
	
	/**
	 * Normal paint
	 */
	protected Paints normalpaint = null;
	
	
	/**
	 * Focused paint
	 */
	protected Paints focusedpaint = null;
	
	
	
	
	
	
	/**
	 * Create a new Button privately
	 */
	protected Button() { }
	
	
	/**
	 * Create a new Button
	 */
	public Button(Vector2d position, float width, float height, String text)
	{
		button = new DrawableRoundBox(position, width, height, 5, 5);
		this.initialise(position, width, height, text);
	}
	
	
	/**
	 * Create a new Button
	 */
	public Button(Vector2d position, float radius, String text)
	{
		button = new DrawableCircle(position, radius);
		this.initialise(position, radius, radius, text);
	}
	
	
	
	
	
	/**
	 * Private method to initialise the Button
	 */
	protected void initialise(Vector2d position, float width, float height, String text)
	{
		this.position = position.clone();
		this.width = width;
		this.height = height;
		
		this.text = new CustomText(text, position, Colour.BLACK, 20f);
		
		buttonBound = new BoundingAABB(position, width, height);
	}
	
	
	
	
	
	/**
	 * Set the paint to use for normal appearance
	 */
	public void setNormalPaint(Paints paint)
	{
		normalpaint = new Paints(paint);
		button.setPaint(paint);
	}
	
	
	
	
	
	/**
	 * Set the paint to use for focused appearance
	 */
	public void setFocusedPaint(Paints paint)
	{
		focusedpaint = new Paints(paint);
	}
	
	
	
	
	
	/**
	 * Set the Text to be displayed
	 */
	public void setText(String text)
	{
		this.text.Text = text;
	}
	
	
	
	
	
	/**
	 * Returns the current Text
	 */
	public String getText()
	{
		return this.text.Text;
	}
	
	
	
	
	/**
	 * Sets the size of the Text
	 */
	public void setTextSize(float size)
	{
		this.text.setTextSize(size);
	}
	
	
	
	
	
	/**
	 * Sets the colour of the Text
	 */
	public void setTextColour(int colour)
	{
		this.text.setColour(colour);
	}
	
	
	
	
	
	/**
	 * Touch event to be handled manually
	 */
	public boolean onTouch(int code, float x, float y)
	{
		if (buttonBound.contains(x, y))
		{
			switch (code)
			{
				case MotionEvent.ACTION_UP:
					currentState = STATE_CLICKED;
					onClick();
					break;
					
				default:
					if (Focusable)
					{
						currentState = STATE_FOCUSED;
						onFocus();
					}
					break;
			}
			
			return true;
		}
		
		currentState = STATE_NORMAL;
		return true;
	}
	
	
	
	
	
	/**
	 * On Click event for the Button
	 */
	public void onClick()
	{
		return;
	}
	
	
	
	
	
	/**
	 * On Focus event for the Button
	 */
	public void onFocus()
	{
		return;
	}
	
	
	
	
	
	
	/**
	 * Draw the Button
	 */
	public void draw(Canvas canvas)
	{
		if (Focusable && previousState != currentState)
		{
			previousState = currentState;
			
			switch (currentState)
			{
				case STATE_NORMAL:
				case STATE_CLICKED:
					button.setPaint(normalpaint);
					break;
					
				case STATE_FOCUSED:
					button.setPaint(focusedpaint);
					break;
			}
		}
		
		button.draw(canvas);
		text.draw(canvas);
	}
	
}
