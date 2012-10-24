package sky.engine.surfaces;

import sky.engine.components.Size;
import sky.engine.components.time.GameTime;
import sky.engine.game.GameScreenActivity;
import sky.engine.game.IGame;
import sky.engine.screens.ScreenManager;
import sky.engine.sensors.Accelerometer;
import sky.engine.threads.GameThread;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class GameScreenSurface extends SurfaceView implements SurfaceHolder.Callback, IGame, SensorEventListener
{
	/**
	 * Holder to the main thread
	 */
	private GameThread thread = null;
	
	
	/**
	 * ScreenManager of the game
	 */
	private ScreenManager screenManager = null;
	
	
	/**
	 * Surface Holder
	 */
	private SurfaceHolder holder = null;
	
	
	/**
	 * context
	 */
	private Context context = null;
	
	
	/**
	 * Sensor manager
	 */
	private SensorManager sensorManager = null;
	
	
	/**
	 * Accelerometer handle
	 */
	private Sensor accelerometer = null;
	
	
	/**
	 * Has the ScreenManager been set?
	 */
	private boolean scrnMgrSet = false;
	
	
	/**
	 * Size of the screen
	 */
	public static Size ScreenSize = null;
	
	
	/**
	 * Centre point of the screen
	 */
	public static Size ScreenCentre = null;
	
	
	/**
	 * Has the surface been created?
	 */
	private boolean surfaceCreated = false;
	
	
	/**
	 * Has the content been loaded?
	 */
	private boolean contentLoaded = false;
	
	
	
	
	
	 
	
	/**
	 * Create a new instance for a game screen surface
	 */
	public GameScreenSurface(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		
		//show that we're interested in listening for call-backs
		holder = getHolder();
		holder.addCallback(this);

		//store the games context
		this.context = context;

		//focus on the view for touch events
		setFocusable(true);
	}
	
	
	
	
	
	
	
	/**
	 * Creates a new thread, with an empty Handler. If a Handler is required, then
	 * one can use the GameThread.setHandler() method. However, you will be also be
	 * required to extend the GameThread class, to make use of the Handler.
	 */
	public void createThread()
	{        
		thread = new GameThread(holder, this, new Handler() {
			@Override
			public void handleMessage(Message m) {
			}
		});
	}
	
	
	
	
	
	
	
	
	/**
	 * Creates a basic gameover Handler. When the thread is set to a state of LOSE,
	 * then this message will be displayed.
	 */
	public void createGameOverHandler(final Activity activity)
	{
		//alert message
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Game over, would like like to retry?")
        	   .setCancelable(false)
        	   .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
        		   public void onClick(DialogInterface dialog, int which) {
        			   destroyThread();
        			   createThread();
        			   startThread();
        			   thread = getThread();
        			   thread.setRunning();
        		   }
        	   })
        	   .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
        		   public void onClick(DialogInterface dialog, int which) {
        			   destroyThread();
        			   activity.setResult(Activity.RESULT_OK);
        			   activity.finish();
        		   }
        	   });
        final AlertDialog alert = builder.create();
        
        //handler
        Handler handler = new Handler() {
        	@Override
        	public void handleMessage(Message m) {
				if (m.getData().getInt("viz") == 1) {
					alert.show();
				} else {
					alert.hide();
				}
        		
        	}
        };
        
        //set it
        thread.setHandler(handler);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Update on surface change
	 */
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		
	}
	
	
	
	
	
	
	/**
	 * Window changed focus
	 */
	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus)
	{
		if (!hasWindowFocus)
			thread.pause();
		else
			thread.unpause();
	}
	
	
	


	
	
	
	/**
	 * Update when the surface is created
	 */
	public void surfaceCreated(SurfaceHolder holder)
	{
		ScreenSize = new Size(getWidth(), getHeight());
		ScreenCentre = ScreenSize.mulScalar(0.5f);
		surfaceCreated = true;
	}
	
	
	
	
	
	
	
	/**
	 * Store size of surface, including the centre point of the screen.
	 */
	public void getSize()
	{
		ScreenSize = new Size(getWidth(), getHeight());
		ScreenCentre = ScreenSize.mulScalar(0.5f);
	}
	
	
	
	
	
	
	
	/**
	 * Start the thread
	 */
	public void startThread()
	{
		thread.start();
	}
	
	
	
	
	
	
	
	
	/**
	 * Set the screen manager to use
	 */
	public void initialise(GameScreenActivity activity)
	{
		if (!scrnMgrSet)
		{
			screenManager = new ScreenManager(activity, context, this, thread);
			scrnMgrSet = true;
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Update on surface destroy
	 */
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		thread.pause();
	}
	
	
	
	
	
	
	
	
	/**
	 * Destroy the current thread
	 */
	public void destroyThread()
	{
		boolean retry = true;
		thread.setStop();
		
		while (retry)
		{
			try {
				thread.join();
				retry = false;
			}
			catch (InterruptedException e) {}
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * get the thread
	 */
	public GameThread getThread()
	{
		return thread;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * onTouchEvent for when the user touches the screen
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		if (scrnMgrSet && contentLoaded)
		{
			return screenManager.handleTouchInput(event);
		}
		
		return true;
	}
	
	
	
	
	
	
	
	
	/**
	 * Set accelerometer
	 */
	public void setAccelerometer(Accelerometer accel)
	{
		if (accel != null)
		{
			sensorManager = accel.getManager();
			accelerometer = accel.getAccelerometer();
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Register event listener for accelerometer
	 */
	public void registerAccelListener()
	{
		if (sensorManager != null)
		{
			sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Unregister event listener for accelerometer
	 */
	public void unregisterAccelListener()
	{
		if (sensorManager != null)
		{
			sensorManager.unregisterListener(this);
		}
	}
	
	
	
	
	
	
	/**
	 * Returns whether the Accelerometer is set
	 */
	public boolean accelerometerExists()
	{
		return (accelerometer != null);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * onSensorChanged to report x,y,z values
	 */
	public void onSensorChanged(SensorEvent event)
	{
		if (scrnMgrSet && contentLoaded && event != null) {
			screenManager.handleAccelInput(event);
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * onAccuracyChanged
	 */
	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		
	}
	
	
	
	
	
	
	
	/**
	 * Return if the surface exists or not
	 */
	public boolean surfaceExists()
	{
		return surfaceCreated;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Load content
	 */
	public void load()
	{
		if (scrnMgrSet && surfaceCreated && getResources() != null)
		{
			getSize();
			
			screenManager.load(getResources(), GameScreenSurface.ScreenSize);
			contentLoaded = true;
		}
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Update the canvas
	 */
	public void update(GameTime gametime)
	{
		if (scrnMgrSet && contentLoaded)
		{
			screenManager.update(gametime);
		}
	}
	
	
	
	
	
	

	
	
	/**
	 * Draw things to the canvas
	 */
	public void draw(Canvas canvas)
	{		
		if (scrnMgrSet && contentLoaded)
		{
			screenManager.draw(canvas);
		}
	}
	
	
	/**
	 * Draw things to the canvas
	 */
	public void draw(Canvas canvas, int cls)
	{
		canvas.drawColor(cls);
		
		if (scrnMgrSet && contentLoaded)
		{
			screenManager.draw(canvas);
		}
	}
	
}
