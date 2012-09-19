package sky.engine.ui.buttons;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.bounds.BoundingBox;
import sky.engine.graphics.drawable.shapes.DrawableRoundBox;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import sky.engine.text.Text;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class BasicButton extends DrawableRoundBox
{
	/**
	 * States
	 */
	public final static int STATE_NORMAL = 1;
	public final static int STATE_FOCUSED = 2;
	public final static int STATE_CLICKED = 3;
	
	
	/**
	 * Current state of the button
	 */
	protected int currentstate = STATE_NORMAL;
	
	
	/**
	 * Previous state of the button
	 */
	protected int previousstate = 0;
	
	
	/**
	 * Text to be displayed
	 */
	public String text = "";
	
	
	/**
	 * Paint for the text
	 */
	protected Paint textpaint = new Paint();
	
	
	/**
	 * Is the button focuseable?
	 */
	public boolean Focusable = true;
	
	
	/**
	 * Bounding volume for the button
	 */
	protected BoundingBox buttonBound = null;
	
	
	/**
	 * Normal style for button
	 */
	protected Paints normalstyle = null;
	
	
	/**
	 * Focused style for button
	 */
	protected Paints focusstyle = null;
	
	
	


	
	/**
	 * Create new instance of a Basic Button
	 */
	public BasicButton(Vector2 position, float width, float height)
	{
		super(position, width, height, 5, 5);
		initialise(position, width, height);
	}
	
	
	/**
	 * Create new instance of a Basic Button
	 */
	public BasicButton(Vector2 position, float width, float height, float rx, float ry)
	{
		super(position, width, height, rx, ry);
		initialise(position, width, height);
	}
	
	
	/**
	 * Create new instance of a Basic Button
	 */
	public BasicButton(Vector2 position, float width, float height, float rx, float ry, String text)
	{
		super(position, width, height, rx, ry);
		initialise(position, width, height);
		this.text = text;
	}
	
	
	
	
	
	/**
	 * Initialise basic button information
	 */
	private void initialise(Vector2 position, float width, float height)
	{
		buttonBound = new BoundingBox(position, width, height);
	}
	
	
	
	
	
	
	
	/**
	 * Set text details
	 */
	public void setText(String text, float size, int colour)
	{
		this.text = text;
		textpaint.setTextSize(size);
		textpaint.setColor(colour);
	}
	
	
	
	
	
	/**
	 * Set the normal style of the button
	 */
	public void setNormalStyle(Fill fill, Outline outline, Blur blur)
	{
		normalstyle = new Paints(fill, outline, blur);
		this.fillpaint = normalstyle.fill();
		this.outlinepaint = normalstyle.outline();
		this.blurpaint = normalstyle.blur();
	}
	
	
	
	
	
	/**
	 * Set the normal style of the button
	 */
	public void setNormalStyle(Paints style)
	{
		normalstyle = new Paints(style);
		this.fillpaint = normalstyle.fill();
		this.outlinepaint = normalstyle.outline();
		this.blurpaint = normalstyle.blur();
	}
	
	
	
	
	/**
	 * Set the focused style of the button
	 */
	public void setFocusStyle(Fill fill, Outline outline, Blur blur)
	{
		focusstyle = new Paints(fill, outline, blur);
	}
	
	
	
	
	/**
	 * Set the focused style of the button
	 */
	public void setFocusStyle(Paints style)
	{
		focusstyle = new Paints(style);
	}
	
	
	
	
	
	/**
	 * Set the focused state of the button
	 */
	public void focused(boolean flag)
	{
		if (flag)
			currentstate = STATE_FOCUSED;
		else
			currentstate = STATE_NORMAL;
	}
	
	
	
	
	
	/**
	 * Returns current state of the button
	 */
	public int getState()
	{
		return currentstate;
	}
	
	
	
	
	
	
	/**
	 * Touch event to handle
	 */
	public int onTouch(int code, float x, float y)
	{		
		if (buttonBound.contains(x, y))
		{
			switch (code)
			{
				case MotionEvent.ACTION_UP:
					currentstate = STATE_CLICKED;
					break;
					
				default:
					if (Focusable) currentstate = STATE_FOCUSED;
					break;
			}
			return currentstate;
		}

		currentstate = STATE_NORMAL;
		return currentstate;
	}
	
	
	
	
	
	/**
	 * Draw the button
	 */
	public void draw(Canvas canvas)
	{
		//style
		if (Focusable && previousstate != currentstate)
		{
			previousstate = currentstate;
			switch (currentstate) {
				case STATE_NORMAL:
				case STATE_CLICKED:
					this.fillpaint = normalstyle.fill();
					this.outlinepaint = normalstyle.outline();
					this.blurpaint = normalstyle.blur();
					break;
					
				case STATE_FOCUSED:
					this.fillpaint = focusstyle.fill();
					this.outlinepaint = focusstyle.outline();
					this.blurpaint = focusstyle.blur();
					break;
			}
		}
		
		//text and button
		super.draw(canvas);
		Text.drawText(canvas, text, this.Position.X, this.Position.Y, textpaint.getColor(),
				textpaint.getTextSize(), true);
	}
	
	
}
