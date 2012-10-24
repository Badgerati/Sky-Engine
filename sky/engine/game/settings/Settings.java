package sky.engine.game.settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import sky.engine.io.FileManager;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Options class to automatically read in and store various options. Options should be
 * stored in the format "Name = Bob" or "Easy = true". With this, we simply use the
 * variable name as the Map key and the value as the key's value. Variables are case-
 * insensitive.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public abstract class Settings
{
	
	/**
	 * Hash Map to store the various options
	 */
	protected static HashMap<String, String> optionsmap = null;
	
	
	
	
	
	
	
	/**
	 * Initialises the options map
	 */
	public static void initialise()
	{
		optionsmap = new HashMap<String, String>();
	}
	
	
	
	
	
	
	
	/**
	 * Reads in the options from given file name, if file doesn't exist returns null
	 */
	public static boolean read(Context context, String filename)
	{
		optionsmap = new HashMap<String, String>();
		
		try
		{
			FileManager fm = new FileManager(context, filename);
			ArrayList<String> lines = fm.read();
			
			if (lines == null || lines.size() == 0) {
				return false;
			}
			
			parse(lines);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
		
	}
	
	
	
	
	
	
	/**
	 * Given an arraylist of strings, parse them and store options
	 */
	public static void parse(ArrayList<String> lines)
	{
		String line, variable, value;

		for (int i = 0; i < lines.size(); i++)
		{
			line = lines.get(i);
			variable = line.split("=")[0].trim();
			value = line.split("=")[1].trim();
			
			optionsmap.put(variable.toUpperCase(), value);
		}
	}
	
	
	
	
	
	/**
	 * Adds an array of items to the given Spinner
	 */
	public static void addItems(Context context, Spinner spinner, ArrayList<String> list)
	{
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	 
	
	
	
	
	
	/**
	 * Clears the options file
	 */
	public static void clear(Context context, String filename)
	{
		FileManager fm = new FileManager(context, filename);
		fm.clear();
	}
	
	
	
	
	
	
	/**
	 * Updates the given option, adding it if it doesn't already exist
	 */
	public static void set(String variable, String value)
	{
		if (optionsmap == null)
			optionsmap = new HashMap<String, String>(); 
		
		optionsmap.put(variable.toUpperCase(), value);
	}
	
	
	
	
	
	/**
	 * Returns the value of the given variable as a String
	 */
	public static String getString(String variable)
	{
		if (optionsmap == null)
			return "";
		
		return optionsmap.get(variable.toUpperCase());
	}
	
	
	
	
	
	/**
	 * Returns the value of the given variable as an Integer
	 */
	public static int getInt(String variable)
	{
		if (optionsmap == null)
			return 0;
		
		return Integer.parseInt(optionsmap.get(variable.toUpperCase()));
	}
	
	
	
	
	
	/**
	 * Returns the value of the given variable as an Boolean
	 */
	public static boolean getBool(String variable)
	{
		if (optionsmap == null)
			return false;
		
		return Boolean.parseBoolean(optionsmap.get(variable.toUpperCase()));
	}
	
	
	
	
	
	
	
	/**
	 * Saves the currently stored options to the given file - overwriting it
	 */
	public static void save(Context context, String filename)
	{
		String options = "";
		Set<String> keys = optionsmap.keySet();
		
		for (String key : keys)
		{
			options += (key + " = " + optionsmap.get(key) + "\n");
		}
		options = options.substring(0, options.length() - ("\n").length());
		
		FileManager fm = new FileManager(context, filename);
		fm.write(options, FileManager.MODE_OVERWRITE);
	}
	
}
