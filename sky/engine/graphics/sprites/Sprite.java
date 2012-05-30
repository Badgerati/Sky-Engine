package sky.engine.graphics.sprites;

import sky.engine.components.Size;
import sky.engine.geometry.Angle;
import sky.engine.geometry.Vector2D;
import sky.engine.physics.bodies.RigidBody;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class Sprite extends RigidBody
{
	/**
	 * the sprite itself
	 */
	protected Bitmap sprite = null;
	
	
	/**
	 * source rectangle
	 */
	protected Rect sourceRectangle = null;
	
	
	/**
	 * destination of the sprite
	 */
	protected RectF destination = null;
	
	
	/**
	 * current rotation of the sprite
	 */
	protected int rotation;
	
	
	/**
	 * scale of the sprite across its width
	 */
	protected float scaleWidth;
	
	
	/**
	 * scale of the sprite across its height
	 */
	protected float scaleHeight;
	
	
	/**
	 * sprite's width
	 */
	protected float Width;
	
	
	/**
	 * sprite's height;
	 */
	protected float Height;
	
	
	/**
	 * Paint object for the sprite
	 */
	protected Paint paint = null;
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * Create an instance of a Sprite
	 */
	public Sprite(Bitmap bitmap, Vector2D position, float scale)
	{
		super(position, Vector2D.Zeros, 0);
		initialise(bitmap, position, scale, scale);
	}
	
	
	/**
	 * Create an instance of a Sprite with velocity and mass
	 */
	public Sprite(Bitmap bitmap, Vector2D position, float scale, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(bitmap, position, scale, scale);
	}
	
	
	/**
	 * Create an instance of a Sprite
	 */
	public Sprite(Bitmap bitmap, Vector2D position, float scalewidth, float scaleheight)
	{
		super(position, Vector2D.Zeros, 0);
		initialise(bitmap, position, scalewidth, scaleheight);
	}
	
	
	/**
	 * Create an instance of a Sprite with velocity and mass
	 */
	public Sprite(Bitmap bitmap, Vector2D position, float scalewidth, float scaleheight, Vector2D velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(bitmap, position, scalewidth, scaleheight);
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialise the sprite
	 */
	private void initialise(Bitmap bitmap, Vector2D position, float scalewidth, float scaleheight)
	{
		
		sprite = bitmap;
		
		Width = bitmap.getWidth();
		Height = bitmap.getHeight();

		this.scaleWidth = scalewidth;
		this.scaleHeight = scaleheight;
		
		sourceRectangle = new Rect(0, 0, (int)Width, (int)Height);
		destination = new RectF(0, 0, 0, 0);
		
		paint = new Paint();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set height of a sprite
	 */
	public void setHeight(float height)
	{
		if (height > 0)
		{
			Height = height;
			sourceRectangle.bottom = (int)height;
		}
	}
	
	
	/**
	 * Set width of a sprite
	 */
	public void setWidth(float width)
	{
		if (width > 0)
		{
			Width = width;
			sourceRectangle.right = (int)width;
		}
	}
	
	
	/**
	 * Set size of a sprite
	 */
	public void setSize(float width, float height)
	{
		setWidth(width);
		setHeight(height);
	}
	
	
	/**
	 * Set size of a sprite
	 */
	public void setSize(Size size)
	{
		setWidth(size.Width);
		setHeight(size.Height);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns height of a sprite
	 */
	public float getHeight()
	{
		return Height;
	}
	
	
	/**
	 * Returns width of a sprite
	 */
	public float getWidth()
	{
		return Width;
	}
	
	
	/**
	 * Returns size of a sprite
	 */
	public Size getSize()
	{
		return new Size(Width, Height);
	}
	
	
	
	
	
	
	
	
	
	

	
	/**
	 * Set scale of sprite	
	 */
	public void setScale(float scale)
	{
		this.scaleWidth = scale;
		this.scaleHeight = scale;
	}
	
	
	/**
	 * Set scale of sprite across its width
	 */
	public void setScaleWidth(float scalewidth)
	{
		this.scaleWidth = scalewidth;
	}
	
	
	/**
	 * Set scale of sprite across its height
	 */
	public void setScaleHeight(float scaleheight)
	{
		this.scaleHeight = scaleheight;
	}
	
	
	/**
	 * Set scale of sprite from a known final width and height
	 */
	public void setScale(float width, float height)
	{
		this.scaleWidth = width / this.Width;
		this.scaleHeight = height / this.Height;
	}
	
	
	
	/**
	 * Returns scale of sprite across its width
	 */
	public float getScaleWidth()
	{
		return scaleWidth;
	}
	
	
	/**
	 * Returns scale of sprite across its height
	 */
	public float getScaleHeight()
	{
		return scaleHeight;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set sprite's bitmap
	 */
	public void setBitmap(Bitmap bitmap)
	{
		sprite = bitmap;
	}
	
	
	/**
	 * Returns sprite's bitmap
	 */
	public Bitmap getBitmap()
	{
		return sprite;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set sprite's opacity
	 */
	public void setOpacity(int opacity)
	{
		if (opacity < 0)
			opacity = 0;
		else if (opacity > 255)
			opacity = 255;
		
		paint.setAlpha(opacity);
	}
	
	
	/**
	 * Returns sprite's opacity
	 */
	public int getOpacity()
	{
		return paint.getAlpha();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Rotate the sprite by so many degrees
	 */
	public void setRotation(int degree)
	{
		rotation = Angle.confineDegree(degree);
	}
	
	
	
	/**
	 * Returns current rotation of sprite
	 */
	public int getRotation()
	{
		return rotation;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set the X position of this sprite, editing it to be central
	 */
	@Override
	public void setXPosition(float value)
	{
		Position.X = value - (Width * 0.5f);
	}

	
	/**
	 * Set the Y position of this sprite, editing it to be central
	 */
	@Override
	public void setYPosition(float value)
	{
		Position.Y = value - (Height * 0.5f);
	}

	
	/**
	 * Set the X and Y position of this sprite, editing it to be central
	 */
	@Override
	public void setPosition(Vector2D position)
	{
		Position.X = position.X - (Width * 0.5f);
		Position.Y = position.Y - (Height * 0.5f);
	}
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * Draw the sprite to the canvas
	 */
	public void draw(Canvas canvas)
	{
		destination.left = (int)(Position.X - ((Width * 0.5) * scaleWidth));
		destination.top = (int)(Position.Y - ((Height * 0.5) * scaleHeight));
		destination.right = (int)(Position.X + ((Width * 0.5) * scaleWidth));
		destination.bottom = (int)(Position.Y + ((Height * 0.5) * scaleHeight));		
		
		canvas.save();
		canvas.rotate(rotation, Position.X, Position.Y);
		canvas.drawBitmap(sprite, sourceRectangle, destination, paint);
		canvas.restore();
	}
	
	
	
	
	
	
	
	
	

}
