package sky.engine.graphics.drawable.shapes;

import sky.engine.geometry.vectors.Vector2D;
import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.ShapePaint;
import android.graphics.Canvas;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public class DrawableRoundBox2 extends DrawableBox
{
	/**
	 * Radius of top-left corner
	 */
	protected float radius1 = 0;
	
	
	/**
	 * Radius of top-right corner
	 */
	protected float radius2 = 0;
	
	
	/**
	 * Radius of bottom-right corner
	 */
	protected float radius3 = 0;
	
	
	/**
	 * Radius of bottom-left corner
	 */
	protected float radius4 = 0;
	
	
	/**
	 * Array of arcs for the corners
	 */
	protected DrawableArc[] arcs = new DrawableArc[4];
	
	
	/**
	 * Array of lines for the sides
	 */
	protected DrawableLine[] lines = new DrawableLine[4];
	
	
	/**
	 * Two boxes to help with filling
	 */
	protected DrawableBox[] filling = new DrawableBox[2];
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create instance of a Drawable Round Box
	 */
	public DrawableRoundBox2(DrawableBox box, float r1, float r2, float r3, float r4)
	{
		super(box);
		initialise(r1, r2, r3, r4, box.Velocity, box.getMass());
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialises the arcs and lines
	 */
	private void initialise(float r1, float r2, float r3, float r4, Vector2D velocity, float mass)
	{
		//fix the radii
		r1 = r1 < 0 ? 0 : r1;
		r2 = r2 < 0 ? 0 : r2;
		r3 = r3 < 0 ? 0 : r3;
		r4 = r4 < 0 ? 0 : r4;
		
		
		//radii
		radius1 = r1;
		radius2 = r2;
		radius3 = r3;
		radius4 = r4;
		
		
		//temp radii
		float tmpr1 = r1 * 0.5f;
		float tmpr2 = r2 * 0.5f;
		float tmpr3 = r3 * 0.5f;
		float tmpr4 = r4 * 0.5f;
		
		
		//arcs
		float quaterX = Width * 0.5f;
		float quaterY = Height * 0.5f;

		Vector2D arcpos1 = new Vector2D(Position.X - quaterX, Position.Y - quaterY);
		Vector2D arcpos2 = new Vector2D(Position.X + quaterX, Position.Y - quaterY);
		Vector2D arcpos3 = new Vector2D(Position.X + quaterX, Position.Y + quaterY);
		Vector2D arcpos4 = new Vector2D(Position.X - quaterX, Position.Y + quaterY);
		
		if (r1 > 0) {
			arcs[0] = new DrawableArc(arcpos1.addScalar(tmpr1, tmpr1), r1, 180, 90, velocity, mass);
			arcs[0].Paint = this.Paint;
			arcs[0].UseCenterLines = false;
		}
		
		if (r2 > 0) {
			arcs[1] = new DrawableArc(arcpos2.addScalar(-tmpr2, tmpr2), r2, 270, 90, velocity, mass);
			arcs[1].Paint = this.Paint;
			arcs[1].UseCenterLines = false;
		}
		
		if (r3 > 0) {
			arcs[2] = new DrawableArc(arcpos3.addScalar(-tmpr3, -tmpr3), r3, 0, 90, velocity, mass);
			arcs[2].Paint = this.Paint;
			arcs[2].UseCenterLines = false;
		}
		
		if (r4 > 0) {
			arcs[3] = new DrawableArc(arcpos4.addScalar(tmpr4, -tmpr4), r4, 90, 90, velocity, mass);
			arcs[3].Paint = this.Paint;
			arcs[3].UseCenterLines = false;
		}
		
		
		//lines
		ShapePaint linepaint = new ShapePaint(this.Paint);
		linepaint.setFillColour(Colour.TRANSPARENT);
		
		lines[0] = new DrawableLine(arcpos1.addScalar(tmpr1, 0), arcpos2.subScalar(tmpr2, 0), velocity, mass);
		lines[0].Paint = linepaint;
		
		lines[1] = new DrawableLine(arcpos2.addScalar(0, tmpr2), arcpos3.subScalar(0, tmpr3), velocity, mass);
		lines[1].Paint = linepaint;
		
		lines[2] = new DrawableLine(arcpos3.subScalar(tmpr3, 0), arcpos4.addScalar(tmpr4, 0), velocity, mass);
		lines[2].Paint = linepaint;
		
		lines[3] = new DrawableLine(arcpos4.subScalar(0, tmpr4), arcpos1.addScalar(0, tmpr1), velocity, mass);
		lines[3].Paint = linepaint;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Draw this Drawable Round Box
	 */
	@Override
	public void draw(Canvas canvas)
	{
		//arcs
		for (int i = 0; i < arcs.length; i++)
		{
			if (arcs[i] != null)
				arcs[i].draw(canvas);
		}

		//lines
		for (int i = 0; i < lines.length; i++)
		{
			if (lines[i] != null)
				lines[i].draw(canvas);
		}
	}
	
	
	
	
	
	
	
	
}
