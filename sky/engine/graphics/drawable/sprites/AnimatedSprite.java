package sky.engine.graphics.drawable.sprites;

import sky.engine.components.Size;
import sky.engine.geometry.vectors.Vector2;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class AnimatedSprite extends Sprite
{	
	/**
	 * fps of animation
	 */
	protected int fps;
	
	
	/**
	 * total number of frames of the animation.
	 */
	protected int frameCount;
	
	
	/**
	 * Number of rows in the animation
	 */
	protected int rows;
	
	
	/**
	 * Number of columns in the animation
	 */
	protected int columns;
	
	
	/**
	 * current frame the animation is on
	 */
	protected int currentFrame;
	
	
	/**
	 * current row the animation is in
	 */
	protected int currentRow;
	
	
	/**
	 * current column the animation is in
	 */
	protected int currentColumn;
	
	
	/**
	 * starting frame of the animation
	 */
	protected int startFrame;
	
	
	///**
	// * first frame of the animation
	// */
	//protected int firstFrame;
	
	
	/**
	 * last frame of the animation	
	 */
	protected int lastFrame;
	
	
	/**
	 * direction the animation plays out
	 */
	protected int direction;
	
	
	/**
	 * frame timer for use with fps
	 */
	protected long frameTimer;
	
	
	/**
	 * should we loop the animation?
	 */
	protected boolean looping, playing, stopped;
	
	
	
	
	
	
	
	
	/**
	 * Create a new instance of an AnimatedSprite
	 */
	public AnimatedSprite(Bitmap bitmap, Vector2 position, float scale, int rows, int columns, int fps)
	{
		super(bitmap, position, scale);
		initialise(rows, columns, fps);
	}
	
	
	/**
	 * Create a new instance of an AnimatedSprite with velocity and mass
	 */
	public AnimatedSprite(Bitmap bitmap, Vector2 position, float scale, int rows, int columns, int fps, Vector2 velocity, float mass)
	{
		super(bitmap, position, scale, velocity, mass);
		initialise(rows, columns, fps);
	}
	
	
	
	
	
	
	/**
	 * Set the Animated Sprite
	 */
	public void  set(Bitmap bitmap, float scale, int rows, int columns, int fps)
	{
		super.set(bitmap, scale, scale);
		initialise(rows, columns, fps);
	}
	
	
	
	
	
	
	/**
	 * Initialise the basics of an AnimatedSprite
	 */
	private void initialise(int rows, int columns, int fps)
	{
		this.rows = rows;
		this.columns = columns;
		frameCount = rows * columns;
		
		currentFrame = 0;
		startFrame = 0;
		//firstFrame = 0;
		lastFrame = frameCount;
		direction = 1;
		
		Width = Width / columns;
		Height = Height / rows;
		
		setSource();

		this.spriteBound.xRadius = Width * 0.5f * scaleWidth;
		this.spriteBound.yRadius = Height * 0.5f * scaleHeight;
		
		this.fps = 1000 / fps;
		frameTimer = 0;
		
		looping = true;
		playing = true;
		stopped = false;
	}
	
	
	
	
	
	
	/**
	 * Set width of a frame
	 */
	@Override
	public void setWidth(float width)
	{
		if (width > 0)
		{
			Width = width;
			this.spriteBound.xRadius = Width * 0.5f * scaleWidth;
			setSource();
		}
	}
	
	
	
	
	
	
	/**
	 * Set height of a frame
	 */
	@Override
	public void setHeight(float height)
	{
		if (height > 0)
		{
			Height = height;
			this.spriteBound.yRadius = Height * 0.5f * scaleHeight;
			setSource();
		}
	}
	
	
	
	
	
	
	/**
	 * Set size of a sprite
	 */
	@Override
	public void setSize(float width, float height)
	{
		setWidth(width);
		setHeight(height);
	}
	
	
	
	
	
	/**
	 * Set size of a sprite
	 */
	@Override
	public void setSize(Size size)
	{
		setWidth(size.Width);
		setHeight(size.Height);
	}
	
	
	
	
	
	
	
	/**
	 * Set FPS of animation
	 */
	public void setFPS(int fps)
	{
		if (fps >= 0)
			this.fps = fps;
	}
	
	
	
	
	
	
	/**
	 * Returns FPS
	 */
	public int getFPS()
	{
		return fps;
	}
	
	
	
	
	
	
	
	/**
	 * Set number of frames
	 */
	public void setFrameCount(int framecount, boolean isLast)
	{
		if (framecount >= startFrame)
			frameCount = framecount;
		
		if (isLast)
			lastFrame = frameCount;
	}
	
	
	
	
	
	
	/**
	 * Returns number of frames
	 */
	public int getFrameCount()
	{
		return frameCount;
	}
	
	
	
	
	
	
	
	/**
	 * set animation to be played
	 */
	public void playAnimation()
	{		
		playing = true;
		stopped = false;
	}
	
	
	
	
	
	
	/**
	 * pause the animation
	 */
	public void pauseAnimation()
	{
		playing = false;
		stopped = false;
	}
	
	
	
	
	
	
	/**
	 * stop the animation
	 */
	public void stopAnimation()
	{
		stopped = true;
		playing = false;
		currentFrame = startFrame;
	}
	
	
	
	
	
	
	/**
	 * loop the animation
	 */
	public void loopAnimation(boolean loop)
	{
		looping = loop;
	}
	
	
	
	
	
	
	/**
	 * Is the animation playing?
	 */
	public boolean isPlaying()
	{
		return playing;
	}
	
	
	
	
	
	
	/**
	 * Is the animation paused?
	 */
	public boolean isPaused()
	{
		if (!playing && !stopped)
			return true;
		else
			return false;
	}
	
	
	
	
	
	/**
	 * Is the animation stopped?
	 */
	public boolean isStopped()
	{
		if (!playing && stopped)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	/**
	 * Is the animation looping?
	 */
	public boolean isLooping()
	{
		return looping;
	}
	
	
	
	
	
	
	
	/**
	 * Set the current frame of animation
	 */
	public void setCurrentFrame(int frame)
	{
		//is the frame less than first frame?
		if (frame < startFrame)
			currentFrame = startFrame;
		
		//else, is it greater than last frame?
		else if (frame >= lastFrame)
			currentFrame = lastFrame - 1;
		
		//else, set frame
		else
			currentFrame = frame;
		
		
		//set new source rectangle
		setSource();
	}
	
	
	
	
	
	/**
	 * Returns the current frame of animation
	 */
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	
	
	
	
	
	
	
	/**
	 * Set the starting frame of the animation. Also sets the current frame, too
	 */
	public void setStartFrame(int frame)
	{
		//is the frame less than the first frame?
		if (frame < 0)
			startFrame = 0;
		
		//else, is it greater than last frame?
		else if (frame >= lastFrame)
			startFrame = lastFrame - 1;
		
		//else, set frame
		else
			startFrame = frame;
		
		setCurrentFrame(frame);
	}
	
	
	
	
	
	
	/**
	 * Returns the starting frame of animation
	 */
	public int getStartFrame()
	{
		return startFrame;
	}
	
	
	
	
	
	
	///**
	// * Set first frame of the animation. This is not where the animation starts,
	// * but the literal first frame of the animation as beginning extreme end
	// */
	//public void setFirstFrame(int frame)
	//{
	//	if (frame < 0)
	//		firstFrame = 0;
	//	
	//	else if (frame > lastFrame)
	//		firstFrame = lastFrame;
	//	
	//	else
	//		firstFrame = frame;
	//}
	//
	//
	//
	//
	//
	//
	///**
	// * returns first frame of animation
	// */
	//public int getFirstFrame()
	//{
	//	return firstFrame;
	//}
	
	
	
	
	
	
	
	/**
	 * Set last frame of the animation. This is where the animation ends
	 */
	public void setLastFrame(int frame)
	{
		if (frame < startFrame)
			lastFrame = startFrame;
		
		else if (frame > frameCount)
			lastFrame = frameCount;
		
		else
			lastFrame = frame;
	}
	
	
	
	
	
	
	/**
	 * returns last frame of animation
	 */
	public int getLastFrame()
	{
		return lastFrame;
	}
	
	
	
	
	
	
	
	/**
	 * Returns number of rows of animation
	 */
	public int getRows()
	{
		return rows;
	}
	
	
	
	
	
	
	/**
	 * Returns number of columns of animation
	 */
	public int getColumns()
	{
		return columns;
	}
	
	
	
	
	
	
	
	/**
	 * Set direction of animation
	 */
	public void setDirection(int direc)
	{
		if (direc > 1)
			direction = 1;
		else if (direc < -1)
			direction = -1;
		else
			direction = direc;
	}
	
	
	
	
	
	
	/**
	 * Returns direction of animation
	 */
	public int getDirection()
	{
		return direction;
	}
	
	
	
	
	
	
	
	/**
	 * Set the source rectangle
	 */
	private void setSource()
	{
		currentRow = (int)((float)currentFrame / (float)this.columns);
		currentColumn = currentFrame % this.columns;
		
		sourceRectangle.top = currentRow * (int)Height;
		sourceRectangle.bottom = sourceRectangle.top + (int)Height;
		sourceRectangle.left = currentColumn * (int)Width;
		sourceRectangle.right = sourceRectangle.left + (int)Width;
	}
	
	
	
	
	
	
	
	/**
	 * Update the sprite to move along a frame
	 */
	public void update(long gameTime)
	{
		//update main sprite
		super.update();
		
		//update frame
		if (playing && (gameTime > frameTimer + fps))
		{
			//integrate to next frame
			frameTimer = gameTime;
			currentFrame += direction;
			
			
			//wrap frames back to start frame if we reach either extreme end
			if (currentFrame >= lastFrame)
			{				
				//if we aren't looping and reach an extreme end, then pause
				if (!looping)
				{
					pauseAnimation();
				}
				
				//else continue, and loop back to start or end, depending on direction
				else
				{
					currentFrame = startFrame;
				}
			}
			
			
			//else, is the current equal to the start? check the direction for looping
			else if (currentFrame == startFrame)
			{
				//are we looping? if not, pause
				if (!looping)
				{
					pauseAnimation();
				}
				
				//else, check the direction to determine extreme end to loop to
				else
				{
					if (direction < 0)
						currentFrame = lastFrame - 1;
					else
						currentFrame = startFrame;
				}
			}
			
			
			//calculate new source if playing
			if (playing)
			{
				setSource();
			}
		}
		
	}
	
	
	
	

	
	
	/**
	 * Draw the current frame of the sprite to the canvas
	 */
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
	}
	
	
	
	

}
