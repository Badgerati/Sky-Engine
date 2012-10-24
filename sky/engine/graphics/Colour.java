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
	public static final int SPRING_GREEN_3 = 0xff008b45;
	public static final int EMERALD_GREEN = 0xff00c957;
	public static final int COBALT_GREEN = 0xff3d9240;
	public static final int DARK_GREEN = 0xff006400;
	public static final int DARK_OLIVE_GREEN = 0xff556b2f;
	public static final int DARK_OLIVE_GREEN_4 = 0xff6e8b3d;
	public static final int DARK_OLIVE_GREEN_5 = 0xff133011;
	public static final int DARK_OLIVE_GREEN_6 = 0xff22380c;
	public static final int DARK_OLIVE_GREEN_7 = 0xff132911;
	public static final int DARK_OLIVE_GREEN_8 = 0xff22490c;
	public static final int OLIVE_DRAB = 0xff698b22;
	
	
	
	//Blues
	public static final int DODGER_BLUE = 0xff1e90ff;
	public static final int CORNFLOWER_BLUE = 0xff6495ed;
	public static final int STEEL_BLUE = 0xff4682B4;
	public static final int DARK_STEEL_BLUE = 0xff36648B;
	public static final int CADET_BLUE = 0xff5F9EA0;
	public static final int MIDNIGHT_BLUE = 0xff191970;
	public static final int SKY_BLUE = 0xff87ceff;
	
	
	
	//Purples
	public static final int PURPLE = 0xff9b30ff;
	public static final int PURPLE_2 = 0xffbb36c7;
	public static final int FUCHSIA = 0xffff00ff;
	public static final int BEET = 0xff8e388e;
	public static final int BLUE_VIOLET = 0xff8a2eb2;
	public static final int LILAC = 0xffb666d2;
	
	
	
	//Reds
	public static final int RED_3 = 0xffcd0000;
	public static final int DARK_RED = 0xff8b0000;
	public static final int FIREBRICK = 0xffb22222;
	public static final int FIREBRICK_2 = 0xffff3030;
	public static final int ORANGE = 0xffffa500;
	public static final int DEEP_PINK = 0xffff1493; 
	public static final int DARK_ORANGE = 0xffcd6600;
	public static final int INDIAN_RED = 0xffb0171f;
	public static final int MAROON = 0xff800000;
	
	
	
	//Pinks
	public static final int PINK = 0xffff1493;
	public static final int HOT_PINK = 0xff69b4;
	public static final int SPICY_PINK = 0xffff1cae;
	
	
	
	//Yellows
	public static final int GOLD = 0xffffd700;
	
	
	
	//Grays
	public static final int DIMGRAY = 0xff696969;
	public static final int LIGHT_GRAY = 0xff969696;
	public static final int VERY_LIGHT_GRAY = 0xffCFCFCF;
	
	
	
	//Browns
	public static final int CHOCOLATE = 0xffd2691e;
	public static final int SADDLE_BROWN = 0xff8b4513;
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns a random colour with full alpha
	 */
	public static int random()
	{
		Random rand = new Random();		
		return Colour.argb(255, rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	
	
	
	

}
