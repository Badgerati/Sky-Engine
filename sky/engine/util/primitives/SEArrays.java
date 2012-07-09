package sky.engine.util.primitives;

/**
 * SEArrays holds more methods than can be applied to array variables. Much like the way
 * the Arrays class works.
 * 
 * @author Matthew Kelly (Badgerati)
 *
 */
public abstract class SEArrays extends Arrays
{
	
	/**
	 * Merge the given two arrays together.
	 * 
	 * @param first - First array.
	 * @param second - Second array to merge with the first.
	 * @return The merging of the two arrays.
	 */
	public static <T> T[] merge(T[] first, T[] second)
	{
		if (first == null)
		{
			if (second == null)
				return null;
			else
				return first;
		}
		
		if (second == null)
		{
			return first;
		}
		
		T[] result = copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	
	
	
	
	
	
	/**
	 * Merge the given arrays together.
	 * 
	 * @param first - First array.
	 * @param rest - A number of other arrays to merge with the first.
	 * @return The merging of all the arrays.
	 */
	public static <T> T[] mergeAll(T[] first, T[]... rest)
	{
		int totalLength = first.length;
		for (T[] array : rest)
			totalLength += array.length;
		
		T[] result = copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest)
		{
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * Reverses the elements of the given array.
	 * 
	 * @param array - Array to reverse.
	 */
	public static <T> void reverse(T[] array)
	{
		for (int i = 0; i < (array.length * 0.5f); i++)
		{
			SEArrays.swap(array, i, array.length - i - 1);
		}
	}
	
	
	
	
	
	
	
	
	/**
	 * Swaps two elements within the given array. The elements to swap are specified
	 * by their given indexes.
	 * 
	 * @param array - Array to swap elements of.
	 * @param index1 - Index of first element.
	 * @param index2 - Index of second element.
	 * @throws IndexOutOfBoundsException.
	 */
	public static <T> void swap(T[] array, int index1, int index2)
	{
		if (index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length)
			throw new IndexOutOfBoundsException();
		
		T temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	
	

}
