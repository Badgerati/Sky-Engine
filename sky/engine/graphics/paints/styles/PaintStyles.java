package sky.engine.graphics.paints.styles;

import sky.engine.graphics.Colour;
import sky.engine.graphics.paints.Blur;
import sky.engine.graphics.paints.Fill;
import sky.engine.graphics.paints.Outline;
import sky.engine.graphics.paints.Paints;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class PaintStyles
{
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class CustomStyle implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public CustomStyle(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.WHITE),
									new Outline(Colour.BLACK, outlinewidth),
									new Blur(Colour.GRAY, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.DODGER_BLUE),
									 new Outline(Colour.BLACK, outlinewidth),
									 new Blur(Colour.CORNFLOWER_BLUE, blurradius));
			}
		}
		
		
		public void setNormalStyle(int fill, int outline, int blur)
		{
			normal.setFillColour(fill);
			normal.setOutlineColour(outline);
			normal.setBlurColour(blur);
		}
		
		
		public void setFocusedStyle(int fill, int outline, int blur)
		{
			focused.setFillColour(fill);
			focused.setOutlineColour(outline);
			focused.setBlurColour(blur);
		}		

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			CustomStyle temp = new CustomStyle(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
			temp.setNormalStyle(normal.fill().getColor(), normal.outline().getColor(), normal.blur().getColor());
			temp.setFocusedStyle(focused.fill().getColor(), focused.outline().getColor(), focused.blur().getColor());
			return temp;
		}
	}
	
	
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class WhiteBlue implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public WhiteBlue(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.WHITE),
									new Outline(Colour.BLACK, outlinewidth),
									new Blur(Colour.GRAY, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.DODGER_BLUE),
									 new Outline(Colour.BLACK, outlinewidth),
									 new Blur(Colour.CORNFLOWER_BLUE, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new WhiteBlue(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class BlackBlue implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public BlackBlue(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.BLACK),
									new Outline(Colour.WHITE, outlinewidth),
									new Blur(Colour.DODGER_BLUE, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.DODGER_BLUE),
									 new Outline(Colour.WHITE, outlinewidth),
									 new Blur(Colour.CORNFLOWER_BLUE, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new BlackBlue(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class BlackGray implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public BlackGray(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.BLACK),
									new Outline(Colour.LIGHT_GRAY, outlinewidth),
									new Blur(Colour.GRAY, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.CORNFLOWER_BLUE),
									 new Outline(Colour.WHITE, outlinewidth),
									 new Blur(Colour.CORNFLOWER_BLUE, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new BlackGray(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class DarkGreenGray implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public DarkGreenGray(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.DARK_OLIVE_GREEN_8),
									new Outline(Colour.DARK_OLIVE_GREEN, outlinewidth),
									new Blur(Colour.GRAY, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.CORNFLOWER_BLUE),
									 new Outline(Colour.WHITE, outlinewidth),
									 new Blur(Colour.CORNFLOWER_BLUE, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new DarkGreenGray(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class PurpleYellow implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public PurpleYellow(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.FUCHSIA),
									new Outline(Colour.YELLOW, outlinewidth),
									new Blur(Colour.PURPLE, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.CORNFLOWER_BLUE),
									 new Outline(Colour.WHITE, outlinewidth),
									 new Blur(Colour.CORNFLOWER_BLUE, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new PurpleYellow(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class DarkGrayOrange implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public DarkGrayOrange(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.GRAY),
									new Outline(Colour.BLACK, outlinewidth),
									new Blur(Colour.LIGHT_GRAY, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.ORANGE),
									 new Outline(Colour.BLACK, outlinewidth),
									 new Blur(Colour.LIGHT_GRAY, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new DarkGrayOrange(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
	
	
	
	/**
	 * 
	 * 
	 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
	 *
	 */
	public static class BlackGrayOrange implements Styles
	{
		protected Paints normal = null;		
		protected Paints focused = null;
		
		
		public BlackGrayOrange(float outlinewidth, float blurradius)
		{
			if (normal == null) {
				normal = new Paints(new Fill(Colour.BLACK),
									new Outline(Colour.LIGHT_GRAY, outlinewidth),
									new Blur(Colour.GRAY, blurradius));
			}
			
			if (focused == null) {
				focused = new Paints(new Fill(Colour.ORANGE),
									 new Outline(Colour.BLACK, outlinewidth),
									 new Blur(Colour.LIGHT_GRAY, blurradius));
			}
		}

		
		public Paints normal() { return normal; }
		public Paints focused() { return focused; }
		
		public Styles clone()
		{
			return new BlackGrayOrange(normal.outline().getStrokeWidth(), normal.blur().getBlurRadius());
		}
	}
	
}
