package sky.engine.threads;

import sky.engine.screens.GameScreen;
import sky.engine.screens.ScreenManager;
import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class LoadTask<T, V> extends AsyncTask<T, Integer, V>
{
	
	/**
	 * The GameScreen that made the call to this loading task
	 */
	protected GameScreen calling_screen = null;
	
	
	/**
	 * The GameScreen to load on completion
	 */
	protected GameScreen[] completion_screen = null;
	
	
	/**
	 * Progress bar to update
	 */
	protected ProgressBar progressbar = null;
	
	
	
	
	
	
	
	/**
	 * Create new LoadTask
	 */
	public LoadTask(GameScreen screen, ProgressBar pbar, GameScreen... screen_on_complete)
	{
		calling_screen = screen;
		completion_screen = screen_on_complete;
		progressbar = pbar;
	}
	
	
	
	
	/**
	 * Content to load (should be overriden)
	 */
	@Override
	protected V doInBackground(T... params)
	{
		return null;
	}
	
	
	
	
	
	/**
	 * Close and load next screen, unless overriden for other purposes.
	 */
	@Override
	protected void onPostExecute(V result)
	{
		super.onPostExecute(result);
		
		for (int i = 0; i < completion_screen.length; i++)
			ScreenManager.add(completion_screen[i]);
		
		calling_screen.exitScreen();
	}
	
	
	
	
	
	/**
	 * Stuff to do before hand
	 */
	@Override
	protected void onPreExecute()
	{
		super.onPreExecute();
	}
	
	
	
	
	
	/**
	 * Update a progress bar, or progress circle (should be overriden)
	 */
	@Override
	protected void onProgressUpdate(Integer... progress)
	{
		progressbar.incrementProgressBy(progress[0]);
	}
	
}
