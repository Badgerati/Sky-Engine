package sky.engine.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.content.Context;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class FileManager
{
	/**
	 * constant value for writing to a file, overwriting if it exists and creating if it doesn't
	 */
	public static final int MODE_OVERWRITE = 0x00000000;
	
	
	/**
	 * constant value writing to a file, appending data to its end
	 */
	public static final int MODE_APPEND = 0x00008000;
	
	
	/**
	 * name of the file this manager is associated with
	 */
	protected String filename;
	
	
	/**
	 * context to help read/write files
	 */
	protected Context context = null;
	
	
	
	
	
	
	
	/**
	 * Create a new instance of a FileManager
	 * 
	 * @param context A Context object to associate this file manager with.
	 * @param filename Name of the file you want to associate this file manager with.
	 */
	public FileManager(Context context, String filename)
	{
		this.filename = filename;
		this.context = context;
	}
	
	
	
	
	
	
	/**
	 * Read in the lines of the file, returning the lines
	 * 
	 * @return List of lines read from the file.
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> read()
	{
		//create lines
		ArrayList<String> lines = null;
		
		
		//try to read lines in
		try
		{
			//open file
			FileInputStream fis = context.openFileInput(filename);
			InputStreamReader in = new InputStreamReader(fis);
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
			fis.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		
		
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
	public void write(byte[] bytesToWrite, int mode)
	{
		//try to write bytes
		try
		{
			//open file
			FileOutputStream fos = context.openFileOutput(filename, mode);
			
			//write bytes
			fos.write(bytesToWrite);
	
			//close file
			fos.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Write a string to the file
	 * 
	 * @param stringToWrite A string you wish to write to the file
	 * @param mode Mode you wish to write with. Either MODE_APPEND or MODE_OVERWRITE
	 * @throws FileNotFoundException
	 */
	public void write(String stringToWrite, int mode)
	{
		write(stringToWrite.getBytes(), mode);
	}
	
	
	
	
	
	
	
	/**
	 * Clear the file
	 * 
	 * @throws FileNotFoundException
	 */
	public void clear()
	{
		try
		{
			String blank = "";
			FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
			fos.write(blank.getBytes());
			fos.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	
	

	
	
	/**
	 * Delete this file from internal storage
	 * 
	 * @return Returns whether the file was deleted successfully or not
	 */
	public boolean delete()
	{
		return context.deleteFile(filename);
	}
	
	

}
