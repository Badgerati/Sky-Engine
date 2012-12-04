package sky.engine.graphics.gui;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.Colour;
import sky.engine.graphics.DrawableComponent;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.styles.PaintStyles;
import sky.engine.graphics.paints.styles.Styles;
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
public class Button extends DrawableComponent
{
	
	/**
	 * Click listener interface
	 */
	public interface OnClickListener
	{
		/**
		 * onClick event
		 */
		public void onClick(Button src);
	}
	
	
	
	
	/**
	 * Focus listener interface
	 */
	public interface OnFocusListener
	{
		/**
		 * onFocus event
		 */
		public void onFocus(Button src);
	}
	
	
	
	
	
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
	 * Button paint style
	 */
	protected Styles buttonStyle = null;
	
	
	/**
	 * Current alpha of the button
	 */
	private int alpha = 255;
	
	
	/**
	 * Click listener event handler
	 */
	private OnClickListener clickListener = null;
	
	
	/**
	 * Focus listener event handler
	 */
	private OnFocusListener focusListener = null;
	
	
	
	
	
	
	/**
	 * Create a new Button privately
	 */
	protected Button(Vector2d position, String text)
	{
		Position = position.clone();
		this.text = new CustomText(text, position, Colour.BLACK, 20f);
	}
	
	
	/**
	 * Create a new Button
	 */
	public Button(Vector2d position, String text, float width, float height)
	{
		button = new DrawableRoundBox(position, width, height, 5, 5);
		this.initialise(position, width, height, text);
	}
	
	
	
	
	
	/**
	 * Initialise the Button
	 */
	private void initialise(Vector2d position, float width, float height, String text)
	{
		Position = position.clone();
		this.width = width;
		this.height = height;
		
		this.text = new CustomText(text, position, Colour.BLACK, 20f);
		
		Styles style = new PaintStyles.WhiteBlue(Outline.DEFAULT_OUTLINE_WIDTH, Blur.DEFAULT_BLUR_RADIUS);
		setStyle(style);
		
		buttonBound = new BoundingAABB(position, width, height);
	}
	
	
	
	
	
	/**
	 * Returns a clone of this Button
	 */
	public Button clone()
	{
		Button btn = new Button(Position, text.Text, width, height);
		btn.setStyle(buttonStyle);
		btn.setAlpha(alpha);
		btn.setTextSize(text.getTextSize());
		btn.setTextColour(text.getColour());
		btn.setOnClickListener(clickListener);
		btn.setOnFocusListener(focusListener);
		
		return btn;
	}
	
	
	
	
	
	
	/**
	 * Set position of the Button
	 */
	@Override
	public void setPosition(Vector2d position)
	{
		super.setPosition(position);
		text.Position = position.clone();
		button.setPosition(position);
		buttonBound.setPosition(position);
	}
	
	
	
	
	
	/**
	 * Set the style to use for the appearance
	 */
	public void setStyle(Styles style)
	{
		buttonStyle = style.clone();
		button.setPaints(buttonStyle.normal());
	}
	
	
	
	
	/**
	 * Set the alpha of the button
	 */
	public void setAlpha(int alpha)
	{
		if (alpha < 0) alpha = 0;
		if (alpha > 255) alpha = 255;
		
		this.alpha = alpha;
		buttonStyle.normal().setAlpha(alpha);
		buttonStyle.focused().setAlpha(alpha);
	}
	
	
	
	
	
	/**
	 * Returns the alpha of the button
	 */
	public int getAlpha()
	{
		return alpha;
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
	 * Returns the height of the button
	 */
	public float getHeight()
	{
		return height;
	}
	
	
	
	
	
	/**
	 * Returns the width of the button
	 */
	public float getWidth()
	{
		return width;
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
					if (clickListener != null) clickListener.onClick(this);
					break;
					
				default:
					if (Focusable)
					{
						currentState = STATE_FOCUSED;
						if (focusListener != null) focusListener.onFocus(this);
					}
					break;
			}
			
			return true;
		}
		
		currentState = STATE_NORMAL;
		return true;
	}
	
	
	
	
	
	/**
	 * Set the click listener event for the Button
	 */
	public void setOnClickListener(OnClickListener listener)
	{
		clickListener = listener;
	}
	
	
	
	
	
	/**
	 * Set the focus listener event for the Button
	 */
	public void setOnFocusListener(OnFocusListener listener)
	{
		focusListener = listener;
	}
	
	
	
	
	
	
	/**
	 * Draw the Button
	 */
	@Override
	public void draw(Canvas canvas)
	{
		if (Focusable && previousState != currentState)
		{
			previousState = currentState;
			
			switch (currentState)
			{
				case STATE_NORMAL:
				case STATE_CLICKED:
					button.setPaints(buttonStyle.normal().clone());
					break;
					
				case STATE_FOCUSED:
					button.setPaints(buttonStyle.focused().clone());
					break;
			}
		}
		
		button.draw(canvas);
		text.draw(canvas);
	}
	
}
