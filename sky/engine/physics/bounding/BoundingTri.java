package sky.engine.physics.bounding;

import sky.engine.geometry.vectors.Vector2d;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class BoundingTri extends BoundingPoly
{

	
	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2d v1, Vector2d v2, Vector2d v3)
	{
		super(new Vector2d[] { v1.clone(), v2.clone(), v3.clone() });
	}
	

	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2d position, Vector2d v1, Vector2d v2, Vector2d v3)
	{
		super(position, new Vector2d[] { v1.clone(), v2.clone(), v3.clone() });
	}
	
	
	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2d[] vertices)
	{
		super(vertices);
		
		if (vertices.length != 3)
			throw new Error("You must supply exactly 3 vertices for a BoundingTri.");
	}
	

	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2d position, Vector2d[] vertices)
	{
		super(position, vertices);
		
		if (vertices.length != 3)
			throw new Error("You must supply exactly 3 vertices for a BoundingTri.");
	}

	
	/**
	 * Create new instance of a bounding triangle on lengths of 3 sides
	 */
	public BoundingTri(Vector2d position, float sidex, float sidey, float sidez)
	{
		super(position);
		build(sidex, sidey, sidez);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Build the triangle from 3 side lengths
	 */
	private void build(float sidex, float sidey, float sidez)
	{
		//error handling
		if (sidex + sidey < sidez)
			throw new Error("The lengths of sides X and Y, when added, should be greater than the length of side Z.");
		if (sidex + sidez < sidey)
			throw new Error("The lengths of sides X and Z, when added, should be greater than the length of side Y.");
		if (sidey + sidez < sidex)
			throw new Error("The lengths of sides Y and Z, when added, should be greater than the length of side X.");
		
		//angles of the triangle
		float tempx = (sidex * sidex);
		float tempy = (sidey * sidey);
		float tempz = (sidez * sidez);
		
		float AngleA = (float)Math.acos((tempx + tempz - tempy) / (2 * sidex * sidez));
		float AngleB = (float)Math.acos((tempy + tempz - tempx) / (2 * sidey * sidez));
		//float AngleC = (float)Math.acos((tempy + tempx - tempz) / (2 * sidex * sidey));
		
		//height of triangle
		float height = sidex * (float)Math.sin(AngleA);
		
		//vertices
		vertices = new Vector2d[3];
		vertices[0] = new Vector2d(0, height * -0.5f);
		vertices[1] = new Vector2d((float)Math.cos(AngleB) * sidey, height * 0.5f);
		vertices[2] = new Vector2d(-(float)Math.cos(AngleA) * sidex, height * 0.5f);

		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	
	

}
