package sky.engine.util.primitives;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sky.engine.math.MathHelper;

import android.graphics.Paint;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class SEString
{
	
	/**
	 * Constants value for alphanumerics
	 */
	public static final String ALPHANUMERICS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final String ALPHANUMERICS_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final String ALPHANUMERICS_LOWER = "abcdefghijklmnopqrstuvwxyz0123456789";
	
	
	/**
	 * Constants for numerics
	 */
	public static final String NUMERICS = "0123456789";
	
	
	/**
	 * Constants value for alpha
	 */
	public static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	
	
	
	
	
	
	
	
	/**
	 * Returns the height of a String, excluding newlines
	 */
	public static float getHeight(Paint paint)
	{
		Paint.FontMetrics fm = paint.getFontMetrics();
		return (fm.bottom - fm.top);
	}
	
	
	
	
	/**
	 * Returns the true height of a String, including newlines with a possible separation
	 * distance between each line
	 */
	public static float getHeight(String str, Paint paint, float sep_dist)
	{
		Paint.FontMetrics fm = paint.getFontMetrics();
		int lines = str.split("\n").length;
		return ((fm.bottom - fm.top) * lines) + (sep_dist * (lines - 1));
	}
	
	
	
	
	
	/**
	 * Returns the width of a String, excluding newlines
	 */
	public static float getWidth(String str, Paint paint)
	{
		return paint.measureText(str);
	}
	
	
	
	
	
	/**
	 * Returns an array of true widths for a String, including newlines
	 */
	public static float[] getWidths(String str, Paint paint)
	{
		String[] lines = str.split("\n");
		int amount = lines.length;
		float[] widths = new float[amount];
		
		for (int i = 0; i < amount; i++)
		{
			widths[i] = paint.measureText(lines[i]);
		}
		
		return widths;
	}
	
	
	
	
	
	/**
	 * Returns if a String only contains Alphanumerical values
	 */
	public static boolean isAlphanumeric(String str)
	{
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	
	
	
	
	/**
	 * Returns if a String only contains Numerical values
	 */
	public static boolean isNumeric(String str)
	{
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	
	
	
	
	/**
	 * Returns if a String only contains Alpha values (upper and lower)
	 */
	public static boolean isAlpha(String str)
	{
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	
	
	
	
	/**
	 * Returns if a String only contains Lower Case Alpha values
	 */
	public static boolean isLowerCase(String str)
	{
		Pattern pattern = Pattern.compile("^[a-z]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	
	
	
	
	/**
	 * Returns if a String only contains Upper Case Alpha values
	 */
	public static boolean isUpperCase(String str)
	{
		Pattern pattern = Pattern.compile("^[A-Z]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.find();
	}
	
	
	
	
	/**
	 * Returns the Levenshtein distance between two given Strings
	 */
	public static int levenshtein(String str1, String str2)
	{
		//convert to char arrays
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		
		//get base stats
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] matrix = new int[length1 + 1][length2 + 1];
		int cost = 0;
		
		
		//quick cut-offs
		if (length1 == 0) return length2;
		else if (length2 == 0) return length1;
		else if (str1.equals(str2)) return 0;
		
		//initialise matrix values
		for (int i = 0; i < length1; i++)
			matrix[i][0] = i;
		
		for (int j = 0; j < length2; j++)
			matrix[0][j] = j;
		
		//main algorithm		
		for (int i = 1; i < length1; i++)
		{
			for (int j = 1; j < length2; j++)
			{
				if (chars1[i] == chars2[j]) cost = 0;
				else cost = 1;
				
				matrix[i][j] = (int)MathHelper.min(matrix[i-1][j] + 1, matrix[i][j-1] + 1, matrix[i-1][j-1] + cost);
			}
		}
		
		return matrix[length1-1][length2-1];
	}
	
}
