package sky.engine.graphics.paints.styles;

import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public abstract class PaintStyles
{
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati)
	 *
	 */
	public static class WhiteBlue implements Styles
	{
		public Paints normal = null;		
		public Paints focused = null;
		
		
		public WhiteBlue()
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.WHITE),
									new Outline(Colour.BLACK),
									new Blur(Colour.GRAY));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.DODGER_BLUE),
									 new Outline(Colour.BLACK),
									 new Blur(Colour.CORNFLOWER_BLUE));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
	}
	
}
