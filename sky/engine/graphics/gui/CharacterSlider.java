package sky.engine.graphics.gui;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.DrawableComponent;
import sky.engine.graphics.text.CustomText;
import android.graphics.Canvas;
import android.graphics.Typeface;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class CharacterSlider extends DrawableComponent implements Button.OnClickListener, Button.OnFocusListener
{
	
	/**
	 * Array of all possible characters
	 */
	private char[] characters = null;
	
	
	/**
	 * Index of the current characters
	 */
	private int characterIndex = 0;
	
	
	/**
	 * Previous button
	 */
	protected Button PreviousButton = null;
	
	
	/**
	 * Next button
	 */
	protected Button NextButton = null;
	
	
	/**
	 * Custom text object to draw the characters
	 */
	private CustomText text = null;
	
	
	/**
	 * Button height
	 */
	protected float height = 0;
	
	
	/**
	 * Button width
	 */
	protected float width = 0;
	
	
	/**
	 * Focus incrementor
	 */
	private int focusIncrementor = 0;
	
	
	

	
	
	/**
	 * Create a CharacterSlider
	 */
	public CharacterSlider(Vector2d position, String chars, float char_size, int colour, float btnheight, float btnwidth)
	{
		initialise(position, chars, char_size, colour, null, btnheight, btnwidth);
	}
	
	
	/**
	 * Create a CharacterSlider
	 */
	public CharacterSlider(Vector2d position, String chars, float char_size, int colour, Typeface font, float btnheight, float btnwidth)
	{
		initialise(position, chars, char_size, colour, font, btnheight, btnwidth);
	}
	
	
	
	
	
	
	/**
	 * Initialise the CharacterSlider
	 */
	protected void initialise(Vector2d position, String chars, float char_size, int colour, Typeface font, float btnheight, float btnwidth)
	{		
		characters = chars.toCharArray();
		Position = position.clone();
		this.height = btnheight;
		this.width = btnwidth;
		
		text = new CustomText("" + characters[0], position, colour, char_size);
		if (font != null) text.setFont(font);
		
		float textheight = text.getHeight();

		PreviousButton = new Button(new Vector2d(position.X, position.Y - width - (textheight * 0.4f)), "/\\", height, width);
		PreviousButton.setOnClickListener(this);
		PreviousButton.setOnFocusListener(this);
		
		NextButton = new Button(new Vector2d(position.X, position.Y + width + (textheight * 0.4f)), "\\/", height, width);
		NextButton.setOnClickListener(this);
		NextButton.setOnFocusListener(this);
	}
	
	
	
	
	
	
	
	/**
	 * Touch event to be handled manually
	 */
	public boolean onTouch(int code, float x, float y)
	{
		PreviousButton.onTouch(code, x, y);
		NextButton.onTouch(code, x, y);
		return true;
	}
	
	
	
	
	
	
	/**
	 * On click event handler
	 */
	public void onClick(Button src)
	{
		if (PreviousButton.equals(src))
		{
			previous();
		}
		else if (NextButton.equals(src))
		{
			next();
		}
		
		focusIncrementor = 0;
	}
	
	
	
	
	
	
	/**
	 * On focus event handler
	 */
	public void onFocus(Button src)
	{
		if (focusIncrementor >= 50)
		{
			if (PreviousButton.equals(src))
			{
				previous();
			}
			else if (NextButton.equals(src))
			{
				next();
			}
		}
		
		else
		{
			focusIncrementor++;
		}
	}
	
	
	
	
	
	/**
	 * Move to the previous character
	 */
	public void previous()
	{
		characterIndex--;
		
		if (characterIndex < 0)
			characterIndex = characters.length - 1;

		set(characterIndex);
	}
	
	
	
	
	
	/**
	 * Move to the next character
	 */
	public void next()
	{
		characterIndex++;
		
		if (characterIndex >= characters.length)
			characterIndex = 0;

		set(characterIndex);
	}
	
	
	
	
	
	/**
	 * Set position of the CharacterSlider
	 */
	@Override
	public void setPosition(Vector2d position)
	{
		super.setPosition(position);
		text.setPosition(position);
		
		float textheight = text.getHeight();
		PreviousButton.setPosition(new Vector2d(position.X, position.Y - width - (textheight * 0.5f)));
		NextButton.setPosition(new Vector2d(position.X, position.Y + width + (textheight * 0.5f)));
	}
	
	
	
	
	
	/**
	 * Reset the CharacterSlider's index
	 */
	public void reset()
	{
		characterIndex = 0;
		set(0);
	}
	
	
	
	
	
	/**
	 * Set the CharacterSlider's index
	 */
	public void set(int index)
	{
		if (index < 0 || index >= characters.length)
			throw new IndexOutOfBoundsException();
		
		characterIndex = index;
		text.Text = "" + characters[characterIndex];
	}
	
	
	
	
	
	/**
	 * Set the characters, erasing any previously set ones
	 */
	public void setChars(String chars)
	{
		characters = chars.toCharArray();
		set(0);
	}
	
	
	
	
	
	/**
	 * Returns the current character
	 */
	public char getChar()
	{
		return characters[characterIndex];
	}
	
	
	
	
	
	/**
	 * Returns the current character as a String
	 */
	@Override
	public String toString()
	{
		return "" + characters[characterIndex];
	}
	
	
	
	
	
	
	/**
	 * Draw the CharacterSlider
	 */
	@Override
	public void draw(Canvas canvas)
	{
		text.draw(canvas);
		PreviousButton.draw(canvas);
		NextButton.draw(canvas);
	}
	
	
	
	
	
}
