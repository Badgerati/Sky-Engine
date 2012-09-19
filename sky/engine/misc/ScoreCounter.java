package sky.engine.misc;

/**
 * Increments and decrements a score to it's maximum possible value
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class ScoreCounter
{
	/**
	 * Increments for the score
	 */
	protected static final int SCORE_LESS_10 = 1;
	protected static final int SCORE_LESS_50 = 3;
	protected static final int SCORE_LESS_100 = 5;
	protected static final int SCORE_LESS_1000 = 25;
	protected static final int SCORE_LESS_10000 = 200;
	protected static final int SCORE_LESS_100000 = 2000;
	protected static final int SCORE_LESS_1000000 = 25000;
	
	
	/**
	 * 
	 */
	protected int maxscore = 0;
	
	
	/**
	 * 
	 */
	protected int currentscore = 0;
	
	

	
	
	/**
	 * 
	 */
	public ScoreCounter()
	{
		currentscore = 0;
		maxscore = 0;
	}
	
	
	/**
	 * 
	 */
	public ScoreCounter(int max)
	{
		currentscore = 0;
		maxscore = max;
	}
	
	
	/**
	 * 
	 */
	public ScoreCounter(int current, int max)
	{
		currentscore = current;
		maxscore = max;
	}
	

	
	
	
	
	/**
	 * Add more value to max score
	 */
	public void add(int score)
	{
		maxscore += score;
	}
	
	
	
	
	/**
	 * Subtract a value from max score
	 */
	public void sub(int score)
	{
		maxscore -= score;
	}
	
	
	
	
	/**
	 * Returns the current score
	 */
	public int getScore()
	{
		return currentscore;
	}
	
	
	
	
	/**
	 * Returns the max score
	 */
	public int getMaxScore()
	{
		return maxscore;
	}
	
	
	
	
	/**
	 * Sets current score to max (mainly for game over, etc.)
	 */
	public void setScoreToMax()
	{
		currentscore = maxscore;
	}
	
	
	
	
	/**
	 * Returns whether the current score is equal to the max score
	 */
	public boolean isMaxxed()
	{
		return currentscore == maxscore;
	}
	
	
	
	
	
	/**
	 * Main incrementing update loop
	 */
	public void increment()
	{
		int diff = maxscore - currentscore;

		if (diff >= 0)
		{
			if (diff <= 10) currentscore += SCORE_LESS_10;
			else if (diff <= 50) currentscore += SCORE_LESS_50;
			else if (diff <= 100) currentscore += SCORE_LESS_100;
			else if (diff <= 1000) currentscore += SCORE_LESS_1000;
			else if (diff <= 10000) currentscore += SCORE_LESS_10000;
			else if (diff <= 100000) currentscore += SCORE_LESS_100000;
			else if (diff <= 1000000) currentscore += SCORE_LESS_1000000;
			
			if (currentscore >= maxscore)
				currentscore = maxscore;
		}
		
		else
		{
			if (diff >= -10) currentscore -= SCORE_LESS_10;
			else if (diff >= -50) currentscore -= SCORE_LESS_50;
			else if (diff >= -100) currentscore -= SCORE_LESS_100;
			else if (diff >= -1000) currentscore -= SCORE_LESS_1000;
			else if (diff >= -10000) currentscore -= SCORE_LESS_10000;
			else if (diff >= -100000) currentscore -= SCORE_LESS_100000;
			else if (diff >= -1000000) currentscore -= SCORE_LESS_1000000;
			
			if (currentscore >= maxscore)
				currentscore = maxscore;
		}
	}
	
	
	
	
	
	/**
	 * Returns current score as string
	 */
	@Override
	public String toString()
	{
		return Integer.toString(currentscore);
	}
	
}
