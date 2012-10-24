package sky.engine.ui.dialogs.views;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;
import sky.engine.graphics.paints.styles.Styles;
import sky.engine.graphics.shapes.DrawableRoundBox;
import sky.engine.graphics.text.Text;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class TextView extends DrawableRoundBox
{
	
	/**
	 * Text to display
	 */
	protected String text = "";
	
	
	/**
	 * Paint for the text
	 */
	protected Paint textpaint = new Paint();
	
	
	

	
	
	/**
	 * Create new instance of a Gameover Dialog
	 */
	public TextView(Vector2d position, float width, float height, Styles style)
	{
		super(position, width, height, 5, 5, style.normal().fill(), style.normal().outline(),
				style.normal().blur());
	}
	
	
	/**
	 * Create new instance of a Gameover Dialog
	 */
	public TextView(Vector2d position, float width, float height)
	{
		super(position, width, height, 5, 5, new Fill(), new Outline(), new Blur());
	}
	
	
	
	
	
	/**
	 * Set text of dialog
	 */
	public void setText(String text, float size, int colour)
	{
		this.text = text;
		textpaint.setTextSize(size);
		textpaint.setColor(colour);
	}
	
	
	
	
	
	/**
	 * Set the normal style of the button
	 */
	public void setStyle(Fill fill, Outline outline, Blur blur)
	{
		Paints t_style = new Paints(fill, outline, blur);
		this.fillpaint = t_style.fill();
		this.outlinepaint = t_style.outline();
		this.blurpaint = t_style.blur();
	}
	
	
	
	
	
	/**
	 * Set the normal style of the button
	 */
	public void setStyle(Paints style)
	{
		this.fillpaint = style.fill();
		this.outlinepaint = style.outline();
		this.blurpaint = style.blur();
	}
	
	
	
	
	
	
	/**
	 * Draw the dialog
	 */
	public void draw(Canvas canvas)
	{
		//bg
		super.draw(canvas);
		
		//text
		Text.drawText(canvas, text,
				Position.X,
				Position.Y,
				textpaint.getColor(),
				textpaint.getTextSize(),
				true);
	}
	
}
