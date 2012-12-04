package sky.engine.screens.dialogs;

import sky.engine.components.time.GameTime;
import sky.engine.graphics.Colour;
import sky.engine.graphics.gui.Button;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.styles.Styles;
import sky.engine.graphics.shapes.DrawableRoundBox;
import sky.engine.graphics.text.CustomText;
import sky.engine.screens.GameScreen;
import sky.engine.screens.ScreenManager;
import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class MessageDialog extends GameScreen
{
	
	/**
	 * Box to wrap message in
	 */
	private DrawableRoundBox messagebox = null;
	
	
	/**
	 * Text to display
	 */
	CustomText message = null;
	
	
	/**
	 * Buttons
	 */
	private Button positive = null, negative = null, neutral = null;
	
	
	/**
	 * Style to use for the buttons
	 */
	private Styles buttonStyle = null;
	
	
	
	
	
	/**
	 * 
	 */
	public MessageDialog(int fill, int outline)
	{
		super();
		this.isPopup = true;
		
		//background
		messagebox = new DrawableRoundBox(ScreenManager.screencentre, 630f, 200f, 7f, 7f,
				new Fill(fill), new Outline(outline), new Blur(Colour.BLACK));
		messagebox.setAlpha(238);
		
		//message
		message = new CustomText("", ScreenManager.screencentre.sub(0, 35f), Colour.WHITE, 23f);
		message.setShadow(5, 0, 0, Colour.BLACK);
		
		//add drawables
		this.addDrawable(messagebox);
		this.addDrawable(message);
	}

	
	
	
	
	/**
	 * 
	 */
	@Override
	public void load()
	{
		
	}
	
	
	
	
	
	/**
	 * Unload content
	 */
	@Override
	public void unload()
	{
		super.unload();
	}
	
	
	
	
	
	/**
	 * Set the positive button
	 */
	public void setPositiveButton(String text, Button.OnClickListener listener)
	{
		positive = new Button(ScreenManager.screencentre.add(-80f, 50f), text, 140f, 40f);
		positive.setTextSize(20f);
		positive.setTextColour(Colour.BLACK);
		positive.setOnClickListener(listener);
		
		if (buttonStyle != null)
		{
			positive.setStyle(buttonStyle);
		}
		
		this.addDrawable(positive);
	}
	
	
	
	
	
	/**
	 * Set the neutral button
	 */
	public void setNeutralButton(String text, Button.OnClickListener listener)
	{
		neutral = new Button(ScreenManager.screencentre.add(0, 50f), text, 140f, 40f);
		neutral.setTextSize(20f);
		neutral.setTextColour(Colour.BLACK);
		neutral.setOnClickListener(listener);
		
		if (buttonStyle != null)
		{
			neutral.setStyle(buttonStyle);
		}
		
		this.addDrawable(neutral);
	}
	
	
	
	
	
	/**
	 * Set the negative button
	 */
	public void setNegativeButton(String text, Button.OnClickListener listener)
	{
		negative = new Button(ScreenManager.screencentre.add(80f, 50f), text, 140f, 40f);
		negative.setTextSize(20f);
		negative.setTextColour(Colour.BLACK);
		negative.setOnClickListener(listener);
		
		if (buttonStyle != null)
		{
			negative.setStyle(buttonStyle);
		}
		
		this.addDrawable(negative);
	}
	
	
	
	
	
	/**
	 * Set the style for the buttons, if they exist
	 */
	public void setButtonStyle(Styles style)
	{
		buttonStyle = style;
		
		if (positive != null) positive.setStyle(style);
		if (negative != null) negative.setStyle(style);
		if (neutral != null) neutral.setStyle(style);
	}
	
	
	
	
	
	/**
	 * Set text to be displayed
	 */
	public void setText(String text)
	{
		message.Text = text;
	}
	
	
	
	
	
	/**
	 * Set colour of text
	 */
	public void setTextColour(int colour)
	{
		message.setColour(colour);
	}
	
	
	
	
	

	/**
	 * Handling touch input
	 */
	@Override
	public boolean handleTouchInput(MotionEvent event)
	{
		int code = event.getAction();
		float x = event.getX();
		float y = event.getY();

		if (positive != null) positive.onTouch(code, x, y);
		if (negative != null) negative.onTouch(code, x, y);
		if (neutral != null) neutral.onTouch(code, x, y);
		
		return true;
	}
	
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void update(GameTime gameTime, boolean otherScreenHasFocus, boolean coveredByOtherScreen)
	{
		super.update(gameTime, otherScreenHasFocus, coveredByOtherScreen);
	}
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
	}
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void drawUI(Canvas canvas)
	{
		super.drawUI(canvas);
	}
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void onBackKey()
	{
		this.exitScreen();
	}
}
