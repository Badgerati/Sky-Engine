package sky.engine.game;

import sky.engine.sensors.Accelerometer;
import sky.engine.stages.StageCreator;
import sky.engine.stages.StageLoop;
import sky.engine.surfaces.GameSurface;
import sky.engine.threads.GameThread;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class GameActivity extends Activity
{
	/**
	 * Main game loop
	 */
	protected GameSurface gamesurface = null;
	
	
	/**
	 * Main Frame Layout for UI overlaying
	 */
	protected FrameLayout framelayout = null;
	
	
	/**
	 * Main game thread
	 */
	protected GameThread thread = null;
	
	
	/**
	 * Pausing dialogue
	 */
	protected AlertDialog pausedDialog = null;
	
	
	
	
	
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
    	//call super
        super.onCreate(savedInstanceState);
        
        
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    
    
    
    
    
    /**
     * 
     */
    protected void createAccelerometer()
    {
        Accelerometer accel = new Accelerometer(this);
        gamesurface.setAccelerometer(accel);
        gamesurface.registerAccelListener();
    }
    
    
    
    
    /**
     * 
     */
    protected void createThread()
    {
        gamesurface.createThread();
    }
    
    
    
    
    /**
     * 
     */
    protected void startThread()
    {
        gamesurface.startThread();
        thread = gamesurface.getThread();
    }
    
    
    
    
    /**
     * Set the thread to run
     */
    protected void runThread()
    {
    	thread.setRunning();
    }
    
    
    
    
    /**
     * 
     */
    protected void setStage(StageLoop stage)
    {
        gamesurface.setStage(stage);
    }
	
	
	
	
	/**
	 * Stop this activity from restarting
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
	}
	
	
	
	
	/**
	 * Pause the game
	 */
	@Override
	protected void onPause()
	{
		if (thread.getGameState() != GameThread.STATE_LOSE && thread.isRunning())
		{
	        AlertDialog.Builder builder = new AlertDialog.Builder(gamesurface.getContext());
	        builder.setMessage("Paused")
	        	   .setCancelable(false)
	        	   .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
	        		   public void onClick(DialogInterface dialog, int which) {
	        			   dialog.cancel();
	        			   resume();
	        		   }
	        	   })
	        	   .setNeutralButton("Retry", new DialogInterface.OnClickListener() {
					   public void onClick(DialogInterface dialog, int which) {
						   dialog.cancel();
						   restart();
					   }
				   })
			 	   .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
					   public void onClick(DialogInterface dialog, int which) {
						   dialog.cancel();
						   quit();
					   }
				   });
	        pausedDialog = builder.create();
			pausedDialog.show();
			pause();
		}
		
		super.onPause();
		gamesurface.unregisterAccelListener();
	}
	
	
	
	
	/**
	 * Pause the activity
	 */
	public void pause()
	{
		if (StageCreator.pausebutton != null)
			StageCreator.pausebutton.pause();
		else
			thread.pause();
	}
	
	
	
	
	
	/**
	 * Resume the activity
	 */
	public void resume()
	{
	   onResume();
	   if (StageCreator.pausebutton != null)
		   StageCreator.pausebutton.unpause();
	   else
		   thread.unpause();
	}
	
	
	
	
	
	/**
	 * Quit the activity
	 */
	public void quit()
	{
	   gamesurface.destroyThread();
	   setResult(RESULT_OK);
	   finish();
	}
	
	
	
	
	/**
	 * Retry the activity (restart)
	 */
	public void restart()
	{
		gamesurface.destroyThread();
		createThread();
		startThread();
		runThread();
	}
	
	
	
	
	
	
	/**
	 * Resume the game
	 */
	@Override
	protected void onResume()
	{
		super.onResume();
		gamesurface.registerAccelListener();
	}
	
	
	
	
	/**
	 * Override back button to pause on press
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
		{
			onPause();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	
	
}
