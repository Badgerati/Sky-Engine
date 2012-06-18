package sky.engine.managers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import sky.engine.io.FileManager;

import android.content.Context;

/**
 * High Score tables are made up of a name and a score
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class HighscoreManager
{
	/**
	 * Hash key for name
	 */
	public static final String NAME = "Name";
	
	
	/**
	 * Hash key for score
	 */
	public static final String SCORE = "Score";
	
	
	/**
	 * Number of entries this table can hold
	 */
	private int numberOfEntries;
	
	
	/**
	 * List of records read in from the file
	 */
	private ArrayList<HashMap<String, String>> Records = null;
	
	
	/**
	 * File manager for the high scores
	 */
	private FileManager fileManager = null;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Construct a new instance of a High Score Manager
	 */
	public HighscoreManager(Context context, String filename, int numberOfEntries)
	{
		//number of entries we can hold
		this.numberOfEntries = numberOfEntries;
		
		//initialise the records
		Records = new ArrayList<HashMap<String, String>>();
		
		//create file manager
		fileManager = new FileManager(context, filename);
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Read the records from the file
	 */
	public void readRecords() throws FileNotFoundException
	{
		//get the lines from the file
		ArrayList<String> lines = null;
		
		try
		{
			lines = fileManager.readFromFile();
		}
		catch (IOException e) { }
		catch (Exception e) { }
		
		
		//loop through each line and store the records appropriately
		String name, score;
		HashMap<String, String> tempRecord = new HashMap<String, String>();
		
		for (int i = 0; i < lines.size(); i += 2)
		{
			tempRecord.clear();
			
			name = lines.get(i).trim().replace("Name=", "");
			score = lines.get(i+1).trim().replace("Score=", "");
			
			tempRecord.put(NAME, name);
			tempRecord.put(SCORE, score);
			
			Records.add(tempRecord);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Write the records to file, limited to the Number of Entries the High Score table
	 * is suppose to contain.
	 */
	public void writeRecords() throws FileNotFoundException
	{
		//create the string to write
		String stringToWrite = "";
		HashMap<String, String> tempRecord = null;
		
		for (int i = 0; i < numberOfEntries; i++)
		{
			tempRecord = Records.get(i);
			stringToWrite += "Name=" + tempRecord.get(NAME) + "\n"
							+ "Score=" + tempRecord.get(SCORE);
			
			if (i != numberOfEntries - 1)
				stringToWrite += "\n";
		}
		
		//write it
		try
		{
			fileManager.writeToFile(stringToWrite, FileManager.MODE_OVERWRITE);
		}
		catch (IOException e) { }
		catch (Exception e) { }
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Clear all records from the file
	 */
	public void clearRecords() throws FileNotFoundException
	{
		try
		{
			fileManager.clearFile();
		}
		catch (IOException e) { }
		catch (Exception e) { }
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Get the records of this table
	 */
	public ArrayList<HashMap<String, String>> getRecords()
	{
		return Records;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Can the given record's score be added to the current records?
	 */
	public boolean canRecordBeAdded(long score)
	{
		//if the score is 0 or less, return false
		if (score <= 0)
			return false;
		
		//else, if the number of records is less than total allowed, true
		if (Records.size() < numberOfEntries)
			return true;
		
		//else, is the score more than last record's score in table
		String tempscore = Records.get(Records.size()-1).get(SCORE);
		for (String r : new String[] { ",", ".", " " })
		{
			tempscore.replace(r, "");
		}
		
		long recscore = Long.parseLong(tempscore);
		
		if (score >= recscore)
			return true;
		
		//finally, if we even get here, return false
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Add the given score and name to the table
	 */
	public void addRecord(String name, long score)
	{
		//reformat name and score
		name = "XX.\t" + name;
		String _score = String.format("%,d", score);
		
		//create new record
		HashMap<String, String> newRecord = new HashMap<String, String>();
		newRecord.put(NAME, name);
		newRecord.put(SCORE, _score);
		
		
		//if the record list is empty, just write the new record in
		if (Records.size() == 0)
		{
			Records.add(newRecord);
		}
		
		//else, find the position to place it
		else
		{
			//temp records list for new positioning
			ArrayList<HashMap<String, String>> tempRecords = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> tempRecord = new HashMap<String, String>();
			
			//boolean to see if new record was added, so we can just dump store the rest
			boolean addedRecord = false;
			
			//loop through each record
			for (int i = 0; i < Records.size(); i++)
			{
				//record stored at i
				tempRecord = Records.get(i);
				
				//is new record greater than this one?
				if (score >= Long.parseLong(tempRecord.get(SCORE).replace(",", "")) && !addedRecord)
				{
					tempRecords.add(newRecord);
					tempRecords.add(tempRecord);
					addedRecord = true;
				}
				else
				{
					tempRecords.add(tempRecord);
				}
			}
			
			//if we reach the end and the record still isn't added, add it
			if (!addedRecord)
			{
				tempRecords.add(newRecord);
			}
			
			//store records
			Records = tempRecords;
		}
		
		
		//finally, update the positioning info
		updatePositioning();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Update the positioning info of the records
	 */
	private void updatePositioning()
	{
		for (int i = 0; i < Records.size(); i++)
		{
			String tempName = Records.get(i).get(NAME).replaceFirst("\t", "\n");
			String[] temp = tempName.split("\n");
			String trace = "";
			
			if ((i + 1) < 10)
				trace = "0";
			else
				trace = "";
				
			Records.get(i).put(NAME, trace + Integer.toString(i+1) + ".\t" + temp[temp.length-1]);
		}
		
		//overflow entries should be positioned as XX
		if (Records.size() > numberOfEntries)
		{
			String tempName = Records.get(numberOfEntries).get(NAME).replaceFirst("\t", "\n");
			String[] temp = tempName.split("\n");
			Records.get(numberOfEntries).put(NAME, "XX.\t" + temp[temp.length-1]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
