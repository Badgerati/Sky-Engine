package sky.engine.ui.buttons;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.Colour;
import sky.engine.graphics.bounds.BoundingCircle;
import sky.engine.graphics.drawable.shapes.DrawableCircle;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.surfaces.GameSurface;
import sky.engine.text.Text;
import sky.engine.threads.GameThread;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class PauseButton
{
	
	/**
	 * 
	 */
	protected static final String PAUSED_BTN_TEXT = "||";
	
	
	/**
	 * 
	 */
	protected static final String RESUME_BTN_TEXT = ">";
	
	
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
	protected DrawableCircle pauseBtn = null;
	
	
	/**
	 * 
	 */
	public BoundingCircle pauseBound = null;
	
	
	/**
	 * 
	 */
	protected BasicButton test = null;
	
	
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
	protected Paint textpaint = null;
	
	
	/**
	 * 
	 */
	protected boolean paused = false;
	
	
	
	

	
	
	/**
	 * 
	 */
	public PauseButton(GameThread thread, Vector2 position)
	{
		initialise(thread, 25, 31, position, Colour.WHITE, Colour.BLACK, 0, Colour.DODGER_BLUE,
				Colour.BLACK, Colour.CORNFLOWER_BLUE, Colour.BLACK);		
	}
	
	
	/**
	 * 
	 */
	public PauseButton(GameThread thread, float radius, float textsize, Vector2 position)
	{
		initialise(thread, radius, textsize, position, Colour.WHITE, Colour.BLACK, 0, Colour.DODGER_BLUE,
				Colour.BLACK, Colour.CORNFLOWER_BLUE, Colour.BLACK);
	}
	
	
	/**
	 * 
	 */
	public PauseButton(GameThread thread, float radius, float textsize, Vector2 position, int ifill,
			int ioutline, int iblur, int pfill, int poutline, int pblur, int tcolour)
	{
		initialise(thread, radius, textsize, position, ifill, ioutline, iblur, pfill, poutline, pblur, tcolour);
	}
	
	
	
	
	
	/**
	 * 
	 */
	private void initialise(GameThread thread, float radius, float textsize, Vector2 position, int ifill,
			int ioutline, int iblur, int pfill, int poutline, int pblur, int tcolour)
	{
		this.thread = thread;
		this.position = position.clone();
		
		pauseBound = new BoundingCircle(position, radius + 25);
		
		textpaint = new Paint();
		textpaint.setColor(tcolour);
		textpaint.setAntiAlias(true);
		textpaint.setTextSize(textsize);
		
		initfill = new Fill(ifill);
		initoutline = new Outline(ioutline);
		initblur = new Blur(iblur);
		
		pausefill = new Fill(pfill);
		pauseoutline = new Outline(poutline, 4);
		pauseblur = new Blur(pblur);	

		pauseBtn = new DrawableCircle(position, radius, initfill, initoutline, initblur);
		
		Size s = GameSurface.ScreenCentre;
		test = new BasicButton(s.asVector2D(), 230, 80, 5, 5);
		test.setTitle("PAUSED", 60, Colour.BLACK);
		test.setNormalStyle(pausefill, pauseoutline, pauseblur);
		test.Focusable = false;
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
		pauseBtn.fill().set(pausefill);
		pauseBtn.outline().set(pauseoutline);
		pauseBtn.blur().set(pauseblur);
		paused = true;
	}
	
	
	
	
	
	/**
	 * Resume the game
	 */
	public void unpause()
	{
		pauseBtn.fill().set(initfill);
		pauseBtn.outline().set(initoutline);
		pauseBtn.blur().set(initblur);
		paused = false;
		thread.unpause();		
	}
	
	
	
	
	
	/**
	 * Drawing
	 */
	public void draw(Canvas canvas)
	{
		pauseBtn.draw(canvas);

		if (paused)
		{
			Text.drawText(canvas, RESUME_BTN_TEXT, position.X + 2, position.Y - 2,
					Colour.BLACK, 45, true);
			
			test.draw(canvas);			
			thread.pause();
		}
		else
		{
			Text.drawText(canvas, PAUSED_BTN_TEXT, position.X, position.Y,
					Colour.BLACK, 31, true);
		}
	}
	
}
