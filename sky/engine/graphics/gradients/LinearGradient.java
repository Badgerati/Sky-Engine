package sky.engine.graphics.gradients;

import sky.engine.geometry.vectors.Vector2;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class LinearGradient
{
	
	/**
	 * Paint for ther gradient
	 */
	protected Paint linear_paint = null;
	
	
	/**
	 * Rectangle to draw the gradient
	 */
	protected RectF linear_rect = null;
	
	
	
	
	
	
	
	/**
	 * Create new Linear Gradient
	 */
	public LinearGradient(Vector2 startp, Vector2 endp, int[] colours, Shader.TileMode tiles)
	{
		Shader shader = new android.graphics.LinearGradient(startp.X, startp.Y,
				endp.X, endp.Y, colours, null, tiles);
		
		linear_paint = new Paint();
		linear_paint.setShader(shader);
	}
	
	
	
	
	/**
	 * Set gradient size
	 */
	public void setSize(Vector2 startp, Vector2 endp)
	{
		linear_rect = new RectF(startp.X, startp.Y, endp.X, endp.Y);
	}
	
	
	
	
	
	/**
	 * Draw gradient
	 */
	public void draw(Canvas canvas)
	{
		canvas.drawRect(linear_rect, linear_paint);
	}
	
	
}
