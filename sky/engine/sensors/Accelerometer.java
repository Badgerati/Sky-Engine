package sky.engine.sensors;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Accelerometer
{
	/**
	 * Accelerometer delay types
	 */
	public static final int DELAY_FASTEST = SensorManager.SENSOR_DELAY_FASTEST;
	public static final int DELAY_GAME = SensorManager.SENSOR_DELAY_GAME;
	public static final int DELAY_NORMAL = SensorManager.SENSOR_DELAY_NORMAL;
	public static final int DELAY_UI = SensorManager.SENSOR_DELAY_UI;
	
	
	/**
	 * Sensor manager for the accelerometer
	 */
	private final SensorManager manager;
	
	
	/**
	 * Accelerometer itself
	 */
	private final Sensor accel;
	
	
	/**
	 * Delay type
	 */
	private int delay = DELAY_GAME;
	
	
	
	
	
	
	
	/**
	 * Create a new Accelerometer object
	 */
	public Accelerometer(Activity activity, int delay)
	{
		manager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
		accel = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		this.delay = delay;
	}
	
	
	/**
	 * Create a new Accelerometer object
	 */
	public Accelerometer(SensorManager manager, int delay)
	{
		this.manager = manager;
		accel = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		this.delay = delay;
	}
	
	
	
	
	
	
	
	/**
	 * Get the accelerometer
	 */
	public Sensor getAccelerometer()
	{
		return accel;
	}
	
	
	
	
	
	
	
	/**
	 * Get manager
	 */
	public SensorManager getManager()
	{
		return manager;
	}
	
	
	
	
	
	
	
	/**
	 * Get delay type
	 */
	public int getDelay()
	{
		return delay;
	}
	
	
	
	
	
	
	/**
	 * Set delay type
	 */
	public void setDelay(int delay)
	{
		this.delay = delay;
	}
	

}
