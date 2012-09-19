package sky.engine.util.primitives;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class SEArrayList<E> extends ArrayList<E>
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4735024974725356646L;
	
	
	/**
	 * 
	 */
	protected Random rand = new Random();





	/**
	 * 
	 */
	public SEArrayList()
	{
		super();
	}
	
	
	/**
	 * 
	 */
	public SEArrayList(Collection<? extends E> c)
	{
		super(c);
	}
	
	
	/**
	 * 
	 */
	public SEArrayList(int initialCapacity)
	{
		super(initialCapacity);
	}
	
	
	
	
	
	/**
	 * Randomises the order of the elements within the ArrayList
	 */
	public void randomise()
	{
		int size = this.size();
		
		for (int i = 0; i < this.size(); i++)
		{
			int s = rand.nextInt(size);
			int e = rand.nextInt(size);
			E temp = this.get(s);
			this.set(s, this.get(e));
			this.set(e, temp);
		}
	}
	
	
	
	
	
	/**
	 * Returns a new ArrayList, containing a number of random elements
	 * contained within this ArrayList.
	 * 
	 * @param amount - Number of random elements to return.
	 */
	public ArrayList<E> getRandom(int amount)
	{
		int size = this.size();
		int r;
		
		ArrayList<E> elements = new ArrayList<E>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		for (int i = 0; i < amount; i++)
		{
			r = rand.nextInt(size);
			
			while (indices.contains(r)) {
				r = rand.nextInt(size);
			}
			
			indices.add(r);
			elements.add(this.get(r));
		}
		
		return elements;
	}
	
	
}
