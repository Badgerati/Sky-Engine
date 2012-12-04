package sky.engine.graphics.text;

import sky.engine.components.time.GameTime;
import sky.engine.geometry.vectors.Vector2d;
import sky.engine.math.AngleHelper;
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
	protected Vector2d offset = null;
	
	
	/**
	 * Speed of rotation
	 */
	public float rotateSpeed = 0;
	
	
	/**
	 * Current amount of rotation
	 */
	public float currentRotation = 0;
	
	
	
	
	
	/**
	 * Create new instance of spinning text
	 */
	public SpinningText(String text, Vector2d position, Vector2d offset, int colour, float size, float rotation, float speed)
	{
		super(text, position, colour, size);
		initialise(offset, rotation, speed);
	}
	
	
	/**
	 * Create new instance of spinning text
	 */
	public SpinningText(String text, Vector2d position, Vector2d offset, Paint paint, float rotation, float speed)
	{
		super(text, position, paint);
		initialise(offset, rotation, speed);
	}
	
	
	
	
	/**
	 * Initialises the rotations
	 */
	private void initialise(Vector2d offset, float rotation, float speed)
	{
		this.offset = offset.clone();
		currentRotation = rotation;
		rotateSpeed = speed;
	}
	
	
	
	
	
	/**
	 * Update the spinning text
	 */
	@Override
	public void update(GameTime gameTime)
	{
		currentRotation += rotateSpeed;
		currentRotation = AngleHelper.constrainAngle(currentRotation);
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
