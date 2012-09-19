package sky.engine.text;

import sky.engine.geometry.vectors.Vector2;
import sky.engine.math.Angle;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class SpinningText extends CustomText
{
	
	/**
	 * Offset from centre position of rotation
	 */
	protected Vector2 offset = null;
	
	
	/**
	 * Speed of rotation
	 */
	public int rotateSpeed = 0;
	
	
	/**
	 * Current amount of rotation
	 */
	public int currentRotation = 0;
	
	
	
	
	
	/**
	 * Create new instance of spinning text
	 */
	public SpinningText(String text, Vector2 position, Vector2 offset, int colour, float size, int rotation, int speed)
	{
		super(text, position, colour, size);
		initialise(offset, rotation, speed);
	}
	
	
	/**
	 * Create new instance of spinning text
	 */
	public SpinningText(String text, Vector2 position, Vector2 offset, Paint paint, int rotation, int speed)
	{
		super(text, position, paint);
		initialise(offset, rotation, speed);
	}
	
	
	
	
	/**
	 * Initialises the rotations
	 */
	private void initialise(Vector2 offset, int rotation, int speed)
	{
		this.offset = offset.clone();
		currentRotation = rotation;
		rotateSpeed = speed;
	}
	
	
	
	
	
	/**
	 * Update the spinning text
	 */
	public void update()
	{
		currentRotation += rotateSpeed;
		currentRotation = Angle.confineDegree(currentRotation);
	}
	
	
	
	
	
	/**
	 * Draw the spinning text
	 */
	@Override
	public void draw(Canvas canvas)
	{
		canvas.save();
		canvas.rotate(currentRotation, Position.X + offset.X, Position.Y + offset.Y);
		super.draw(canvas);
		canvas.restore();
	}
	
	
	
	
}
