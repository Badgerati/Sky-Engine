package sky.engine.graphics;

import java.util.Random;

import android.graphics.Color;


/**
 * Extension of the Color class, to create more colours.
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Colour extends Color
{
	
	//Greens
	public static final int LIME_GREEN = 0xff32cd32;
	public static final int TURQUOISE = 0xff00f5ff;
	public static final int SPRING_GREEN = 0xff00ff7f;
	public static final int EMERALD_GREEN = 0xff00c957;
	
	
	
	//Blues
	public static final int DODGER_BLUE = 0xff1e90ff;
	public static final int CORNFLOWER_BLUE = 0xff6495ed;
	
	
	
	//Purples
	public static final int PURPLE = 0xff9b30ff;
	public static final int FUCHSIA = 0xffff00ff;
	
	
	
	//Reds
	public static final int ORANGE = 0xffffa500;
	public static final int DEEP_PINK = 0xffff1493; 
	public static final int DARK_ORANGE = 0xffcd6600;
	
	
	
	//Yellows
	public static final int GOLD = 0xffffd700;
	
	
	
	//Grays
	public static final int DIMGRAY = 0xff696969;
	public static final int LIGHT_GRAY = 0xff969696;
	public static final int VERY_LIGHT_GRAY = 0xffCFCFCF;
	
	
	
	//Browns
	public static final int CHOCOLATE = 0xffd2691e;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a random colour with full alpha
	 */
	public static int random()
	{
		Random rand = new Random();		
		return Colour.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	
	
	
	

}
