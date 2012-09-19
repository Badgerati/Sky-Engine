package sky.engine.graphics.drawable.sprites;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2;
import sky.engine.graphics.bounds.BoundingOval;
import sky.engine.math.Angle;
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
	 * Should this sprite be drawn?
	 */
	protected boolean hidden = false;
	
	
	/**
	 * Paint object for the sprite
	 */
	protected Paint paint = null;
	
	
	/**
	 * Bounding Volume generated automatically for the whole sprite
	 */
	protected BoundingOval spriteBound = null;
	
	
	
	
	
	

	
	
	/**
	 * Create an instance of a Sprite
	 */
	public Sprite(Bitmap bitmap, Vector2 position, float scale)
	{
		super(position, Vector2.zeros(), 0);
		initialise(bitmap, scale, scale);
	}
	
	
	/**
	 * Create an instance of a Sprite with velocity and mass
	 */
	public Sprite(Bitmap bitmap, Vector2 position, float scale, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(bitmap, scale, scale);
	}
	
	
	/**
	 * Create an instance of a Sprite
	 */
	public Sprite(Bitmap bitmap, Vector2 position, float scalewidth, float scaleheight)
	{
		super(position, Vector2.zeros(), 0);
		initialise(bitmap, scalewidth, scaleheight);
	}
	
	
	/**
	 * Create an instance of a Sprite with velocity and mass
	 */
	public Sprite(Bitmap bitmap, Vector2 position, float scalewidth, float scaleheight, Vector2 velocity, float mass)
	{
		super(position, velocity, mass);
		initialise(bitmap, scalewidth, scaleheight);
	}
	
	
	
	
	
	
	
	/**
	 * Set the Sprite
	 */
	public void set(Bitmap bitmap, float scalewidth, float scaleheight)
	{
		initialise(bitmap, scalewidth, scaleheight);
	}
	
	
	
	
	
	
	
	/**
	 * Initialise the sprite
	 */
	private void initialise(Bitmap bitmap, float scalewidth, float scaleheight)
	{
		sprite = bitmap;
		
		Width = bitmap.getWidth();
		Height = bitmap.getHeight();

		this.scaleWidth = scalewidth;
		this.scaleHeight = scaleheight;
		
		sourceRectangle = new Rect(0, 0, (int)Width, (int)Height);
		destination = new RectF(0, 0, 0, 0);
		
		this.spriteBound = new BoundingOval(Position, Width * 0.5f * scaleWidth, Height * 0.5f * scaleHeight);
		
		paint = new Paint();
	}
	
	
	
	
	
	
	/**
	 * Hide the sprite.
	 */
	public void hide()
	{
		hidden = true;
	}
	
	
	
	
	
	
	/**
	 * Show the sprite.
	 */
	public void show()
	{
		hidden = false;
	}
	
	
	
	
	
	
	
	/**
	 * Set height of a sprite
	 */
	public void setHeight(float height)
	{
		if (height > 0)
		{
			Height = height;
			spriteBound.yRadius = Height * 0.5f * scaleHeight;
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
			spriteBound.xRadius = Width * 0.5f * scaleWidth;
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
	 * Returns the original height of a sprite
	 */
	public float getHeight()
	{
		return Height;
	}
	
	
	
	
	
	/**
	 * Returns the scaled height of a sprite
	 */
	public float getScaledHeight()
	{
		return Height * scaleHeight;
	}

	
	
	
	
	
	/**
	 * Returns the original width of a sprite
	 */
	public float getWidth()
	{
		return Width;
	}
	
	
	
	
	
	/**
	 * Returns the scaled width of a sprite
	 */
	public float getScaledWidth()
	{
		return Width * scaleWidth;
	}

	
	
	
	
	
	/**
	 * Returns the original size of a sprite
	 */
	public Size getSize()
	{
		return new Size(Width, Height);
	}
	
	
	
	
	
	/**
	 * Returns the scaled size of a sprite
	 */
	public Size getScaledSize()
	{
		return new Size(Width * scaleWidth, Height * scaleHeight);
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
	 * 
	 */
	@Override
	public void integrate(float dt)
	{
		super.integrate(dt);
		spriteBound.setPosition(Position);
	}

	
	
	

	/**
	 * 
	 */
	@Override
	public void integrate(Vector2 velocity, float dt)
	{
		super.integrate(velocity, dt);
		spriteBound.setPosition(Position);
	}

	
	
	

	/**
	 * 
	 */
	@Override
	public void setXPosition(float value)
	{
		super.setXPosition(value);
		spriteBound.setPosition(Position);
	}

	
	
	

	/**
	 * 
	 */
	@Override
	public void setYPosition(float value)
	{
		super.setYPosition(value);
		spriteBound.setPosition(Position);
	}

	
	
	

	/**
	 * 
	 */
	@Override
	public void setPosition(Vector2 position)
	{
		super.setPosition(position);
		spriteBound.setPosition(Position);
	}
	
	
	
	
	
	
	/**
	 * Returns the bounding volume of the Sprite
	 */
	public BoundingOval spritebound()
	{
		return spriteBound;
	}
	


	
	
	
	
	/**
	 * Update the sprite - mainly for velocity usage
	 */
	public void update()
	{
		this.integrate(1);
		spriteBound.setPosition(Position);
	}
	
	
	
	
	
	
	
	/**
	 * Draw the sprite to the canvas
	 */
	public void draw(Canvas canvas)
	{
		if (!hidden)
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
	
	
	
	
	

}
