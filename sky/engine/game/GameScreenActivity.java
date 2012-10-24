package sky.engine.game;

import sky.engine.screens.ScreenManager;
import sky.engine.sensors.Accelerometer;
import sky.engine.surfaces.GameScreenSurface;
import sky.engine.threads.GameThread;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * This class is different from GameActivity, as it allows for the creation and
 * usage of a ScreenManager for more graphically intensive games.
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class GameScreenActivity extends Activity
{
	/**
	 * Main game loop
	 */
	protected GameScreenSurface gamescrnsurface = null;
	
	
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
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        
        //framelayout
        framelayout = new FrameLayout(this);
        framelayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT)); 
    
        //game surface
        gamescrnsurface = new GameScreenSurface(this, null);
        gamescrnsurface.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        framelayout.addView(gamescrnsurface);
        
    	setContentView(framelayout);
    	
    	createThread();
    	startThread();
    	initialiseScreenManager();
    }
    
    
    
    
    /**
     * Add view to framelayout
     */
    public void addView(View view)
    {
    	framelayout.addView(view);
    }
    
    
    
    
    /**
     * Add view to framelayout from outside of this UI thread
     */
    public void addViewOnUIThread(final View view)
    {
    	this.runOnUiThread(new Runnable() {
    		public void run() {
    			framelayout.addView(view);
    		}
    	});
    }
    
    
    
    
    /**
     * Remove view from framelayout
     */
    public void removeView(View view)
    {
    	framelayout.removeView(view);
    }
    
    
    
    
    
    /**
     * Set content view for activity
     */
    protected void setContentView()
    {
    	setContentView(framelayout);
    }
    
    
    
    
    
    /**
     * 
     */
    protected void createAccelerometer()
    {
        Accelerometer accel = new Accelerometer(this);
        gamescrnsurface.setAccelerometer(accel);
        gamescrnsurface.registerAccelListener();
    }
    
    
    
    
    /**
     * 
     */
    protected void createThread()
    {
    	gamescrnsurface.createThread();
    }
    
    
    
    
    /**
     * 
     */
    protected void startThread()
    {
    	gamescrnsurface.startThread();
        thread = gamescrnsurface.getThread();
    }
    
    
    
    
    /**
     * 
     */
    protected void initialiseScreenManager()
    {
    	gamescrnsurface.initialise(this);
    }
    
    
    
    
    /**
     * Set the thread to run
     */
    protected void runThread()
    {
    	thread.setRunning();
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
	        AlertDialog.Builder builder = new AlertDialog.Builder(gamescrnsurface.getContext());
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
		gamescrnsurface.unregisterAccelListener();
	}
	
	
	
	
	/**
	 * Pause the activity
	 */
	public void pause()
	{
		ScreenManager.pause();
	}
	
	
	
	
	
	/**
	 * Resume the activity
	 */
	public void resume()
	{
	   onResume();
	   ScreenManager.resume();
	}
	
	
	
	
	
	/**
	 * Quit the activity
	 */
	public void quit()
	{
		gamescrnsurface.destroyThread();
		setResult(RESULT_OK);
		finish();
	}
	
	
	
	
	/**
	 * Retry the activity (restart)
	 */
	public void restart()
	{
		boolean acc = gamescrnsurface.accelerometerExists();
		
		gamescrnsurface.destroyThread();
		createThread();
		startThread();
		if (acc) createAccelerometer();
		runThread();
	}
	
	
	
	
	
	
	/**
	 * Resume the game
	 */
	@Override
	protected void onResume()
	{
		super.onResume();
		gamescrnsurface.registerAccelListener();
	}
	
	
	
	
	/**
	 * Override back button to pause on press
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
		{
			ScreenManager.onBackKey();
			//onPause();
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	
	
	
	
}
