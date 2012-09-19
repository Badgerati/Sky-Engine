package sky.engine.ui.buttons;

import android.graphics.Canvas;
import android.graphics.Paint;
import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.bounds.Bounding;
import sky.engine.graphics.drawable.shapes.DrawableShape;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import sky.engine.surfaces.GameSurface;
import sky.engine.text.Text;
import sky.engine.threads.GameThread;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class PauseButton
{
	
	/**
	 * 
	 */
	public static final String PAUSED_BTN_TEXT = "||";
	
	
	/**
	 * 
	 */
	public static final String RESUME_BTN_TEXT = ">";
	
	
	/**
	 * 
	 */
	protected GameThread thread = null;
	
	
	/**
	 * 
	 */
	protected Vector2 position = null;
	
	
	/**
	 * 
	 */
	protected DrawableShape pauseBtn = null;
	
	
	/**
	 * 
	 */
	public Bounding pauseBound = null;
	
	
	/**
	 * 
	 */
	protected BasicButton paused_dialog = null;
	
	
	/**
	 * 
	 */
	protected Fill initfill = null;
	protected Outline initoutline = null;
	protected Blur initblur = null;
	
	
	/**
	 * 
	 */
	protected Fill pausefill = null;
	protected Outline pauseoutline = null;
	protected Blur pauseblur = null;
	
	
	/**
	 * 
	 */
	public Paint textpaint = null;
	
	
	/**
	 * 
	 */
	protected boolean paused = false;
	
	
	/**
	 * 
	 */
	private float textsize = 0;
	
	
	/**
	 * 
	 */
	
	
	
	
	
	
	/**
	 * 
	 */
	public PauseButton(GameThread thread, float textsize, int tcolour, Vector2 position,
			Paints p_initial, Paints p_pause)
	{
		this.thread = thread;
		this.position = position.clone();
		
		this.textsize = textsize;
		textpaint = new Paint();
		textpaint.setColor(tcolour);
		textpaint.setAntiAlias(true);
		textpaint.setTextSize(textsize);
		
		initfill = p_initial.fill();
		initoutline = p_initial.outline();
		initblur = p_initial.blur();
		
		pausefill = p_pause.fill();
		pauseoutline = p_pause.outline();
		pauseblur = p_pause.blur();
		
		Size s = GameSurface.ScreenCentre;
		paused_dialog = new BasicButton(s.asVector2D(), 230, 80, 5, 5);
		paused_dialog.setText("PAUSED", 60, pauseoutline.getColor());
		paused_dialog.setNormalStyle(pausefill, pauseoutline, pauseblur);
		paused_dialog.Focusable = false;
	}
	
	
	
	
	
	
	
	/**
	 * Touch Event
	 */
	public boolean onTouch(float x, float y)
	{
		if (pauseBound.contains(x, y))
		{
			if (thread.getGameState() == GameThread.STATE_RUN)
				pause();
			else if (thread.getGameState() == GameThread.STATE_PAUSE)
				unpause();
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	/**
	 * Is the game paused?
	 */
	public boolean isPaused()
	{
		return paused;
	}
	
	
	
	
	
	/**
	 * Pause game
	 */
	public void pause()
	{
		if (pauseBtn.fill() != null) pauseBtn.fill().set(pausefill);
		if (pauseBtn.outline() != null) pauseBtn.outline().set(pauseoutline);
		if (pauseBtn.blur() != null) pauseBtn.blur().set(pauseblur);
		paused = true;
		
		textpaint.setColor(pauseoutline.getColor());
		textpaint.setTextSize(textsize + 5f);
	}
	
	
	
	
	
	/**
	 * Resume the game
	 */
	public void unpause()
	{
		if (pauseBtn.fill() != null) pauseBtn.fill().set(initfill);
		if (pauseBtn.outline() != null) pauseBtn.outline().set(initoutline);
		if (pauseBtn.blur() != null) pauseBtn.blur().set(initblur);
		paused = false;
		thread.unpause();

		textpaint.setColor(initoutline.getColor());
		textpaint.setTextSize(textsize);
	}
	
	
	
	
	
	/**
	 * Drawing
	 */
	public void draw(Canvas canvas)
	{
		pauseBtn.draw(canvas);

		if (paused)
		{
			Text.drawText(canvas, RESUME_BTN_TEXT, position.X, position.Y - 6,
					textpaint, true);
			
			paused_dialog.draw(canvas);			
			thread.pause();
		}
		else
		{
			Text.drawText(canvas, PAUSED_BTN_TEXT, position.X, position.Y - 7,
					textpaint, true);
		}
	}
	
}
