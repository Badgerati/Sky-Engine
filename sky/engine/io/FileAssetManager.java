package sky.engine.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetManager;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class FileAssetManager extends FileManager
{

	
	/**
	 * Create a new instance of a FileAssetManager
	 * 
	 * @param context A Context object to associate this file manager with.
	 * @param filename Name of the file you want to associate this file manager with.
	 */
	public FileAssetManager(Context context, String filename)
	{
		super(context, filename);
	}
	
	
	
	
	
	
	/**
	 * Read in the lines of the file, returning the lines
	 * 
	 * @return List of lines read from the file.
	 * @throws FileNotFoundException
	 */
	@Override
	public ArrayList<String> read()
	{
		//create lines
		ArrayList<String> lines = null;
		
		
		//try to read lines in
		try
		{
			//open file
			AssetManager am = context.getAssets();
			InputStream is = am.open(filename);
			InputStreamReader in = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(in);
			
			//create and clear lines
			lines = new ArrayList<String>();
			
			//read file in
			String line = "";
			while ((line = br.readLine()) != null)
			{
				lines.add(line);
			}
			
			//close file
			br.close();
			in.close();
			is.close();
		}
		catch (FileNotFoundException e) { }
		catch (IOException e) { }
		catch (Exception e) { }
		
		
		//return lines read, even if it's null
		return lines;		
	}
	
	
	
	
	
	
	/**
	 * Write an array of bytes to the file
	 * 
	 * @param bytesToWrite Array of bytes to write to the file
	 * @param mode Mode you wish to write with. Either MODE_APPEND or MODE_OVERWRITE
	 * @throws FileNotFoundException
	 */
	@Override
	public void write(byte[] bytesToWrite, int mode)
	{
		return;
	}
	
	
	
	
	
	
	
	
	/**
	 * Write a string to the file
	 * 
	 * @param stringToWrite A string you wish to write to the file
	 * @param mode Mode you wish to write with. Either MODE_APPEND or MODE_OVERWRITE
	 * @throws FileNotFoundException
	 */
	@Override
	public void write(String stringToWrite, int mode)
	{
		write(stringToWrite.getBytes(), mode);
	}
	
	
	
	
	
	
	
	/**
	 * Clear the file
	 * 
	 * @throws FileNotFoundException
	 */
	@Override
	public void clear()
	{
		return;
	}
	
	
	
	

	
	
	/**
	 * Delete this file from internal storage
	 * 
	 * @return Returns whether the file was deleted successfully or not
	 */
	@Override
	public boolean delete()
	{
		return false;
	}
	
}
