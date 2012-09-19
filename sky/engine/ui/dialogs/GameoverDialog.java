package sky.engine.ui.dialogs;

import sky.engine.game.GameActivity;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.drawable.shapes.DrawableRoundBox;
import sky.engine.graphics.paints.styles.Styles;
import sky.engine.text.Text;
import sky.engine.ui.buttons.BasicButton;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class GameoverDialog extends DrawableRoundBox
{
	/**
	 * Title of the dialog
	 */
	protected String title = "";
	
	
	/**
	 * Paint for the title
	 */
	protected Paint titlepaint = new Paint();
	
	
	/**
	 * Text to display
	 */
	protected String text = "";
	
	
	/**
	 * Paint for the text
	 */
	protected Paint textpaint = new Paint();
	
	
	/**
	 * Thread to handle
	 */
	protected GameActivity activity = null;
	
	
	/**
	 * Retry button
	 */
	protected BasicButton retrybtn = null;
	
	
	/**
	 * Quit button
	 */
	protected BasicButton quitbtn = null;
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Gameover Dialog
	 */
	public GameoverDialog(GameActivity activity, Vector2 position, float width, float height, Styles style)
	{
		super(position, width, height, 5, 5, style.normal().fill(), style.normal().outline(), style.normal().blur());
		initialise(activity);
	}
	
	
	/**
	 * Create new instance of a Gameover Dialog
	 */
	public GameoverDialog(GameActivity activity, Vector2 position, float width, float height, Styles style, String title)
	{
		super(position, width, height, 5, 5, style.normal().fill(), style.normal().outline(), style.normal().blur());
		initialise(activity);
		this.title = title;
	}
	
	
	
	
	
	
	/**
	 * Set basic information
	 */
	private void initialise(GameActivity activity)
	{
		this.activity = activity;
	}
	
	
	
	
	
	
	
	/**
	 * Set title of dialog
	 */
	public void setTitle(String title, float size, int colour)
	{
		this.title = title;
		titlepaint.setTextSize(size);
		titlepaint.setColor(colour);
	}
	
	
	
	
	
	/**
	 * Set text of dialog
	 */
	public void setText(String text, float size, int colour)
	{
		this.text = text;
		textpaint.setTextSize(size);
		textpaint.setColor(colour);
	}

	
	
	
	
	
	/**
	 * Show the retry button
	 */
	public void showRetry(float height, String text, float tsize, int tcolour, Styles style)
	{		
		float x = Position.X - (Width * 0.25f);
		float y = Position.Y + (Height * 0.5f) - (height * 0.8f);
		Vector2 pos = new Vector2(x, y);
		
		retrybtn = new BasicButton(pos, Width * 0.45f, height, 5, 5);
		retrybtn.setText(text, tsize, tcolour);
		
		retrybtn.setNormalStyle(style.normal().fill(), style.normal().outline(), null);
		retrybtn.setFocusStyle(style.focused().fill(), style.focused().outline(), null);
	}
	
	
	
	
	
	/**
	 * Hide the retry button
	 */
	public void hideRetry()
	{
		retrybtn = null;
	}

	
	
	
	
	
	/**
	 * Show the quit button
	 */
	public void showQuit(float height, String text, float tsize, int tcolour, Styles style)
	{		
		float x = Position.X + (Width * 0.25f);
		float y = Position.Y + (Height * 0.5f) - (height * 0.8f);
		Vector2 pos = new Vector2(x, y);
		
		quitbtn = new BasicButton(pos, Width * 0.45f, height, 5, 5);
		quitbtn.setText(text, tsize, tcolour);
		
		quitbtn.setNormalStyle(style.normal().fill(), style.normal().outline(), null);
		quitbtn.setFocusStyle(style.focused().fill(), style.focused().outline(), null);
	}
	
	
	
	
	
	/**
	 * Hide the quit button
	 */
	public void hideQuit()
	{
		quitbtn = null;
	}
	
	
	
	
	
	
	/**
	 * Touch event handling for buttons
	 */
	public boolean onTouch(int code, float x, float y)
	{
		if (retrybtn != null)
		{
			if (retrybtn.onTouch(code, x, y) == BasicButton.STATE_CLICKED)
			{
				activity.restart();
			}
		}
		
		if (quitbtn != null)
		{
			if (quitbtn.onTouch(code, x, y) == BasicButton.STATE_CLICKED)
			{
				activity.quit();
			}
		}
		
		return true;
	}
	
	
	
	
	
	
	/**
	 * Draw the dialog
	 */
	public void draw(Canvas canvas)
	{
		//bg
		super.draw(canvas);
		
		//title
		Text.drawText(canvas,
					  title,
					  Position.X,
					  Position.Y - (Height * 0.5f) + titlepaint.getTextSize(),
					  titlepaint.getColor(),
					  titlepaint.getTextSize(),
					  true);
		
		//text
		Text.drawText(canvas,
					  text,
					  Position.X,
					  Position.Y/* - (Height * 0.20f) + textpaint.getTextSize()*/,
					  textpaint.getColor(),
					  textpaint.getTextSize(),
					  true);
		
		
		//buttons
		if (retrybtn != null) retrybtn.draw(canvas);
		if (quitbtn != null) quitbtn.draw(canvas);
	}
	
	
	
	
	
}
