package sky.engine.graphics.bounds;

import sky.engine.geometry.Vector2D;

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
	public BoundingTri(Vector2D v1, Vector2D v2, Vector2D v3)
	{
		super(new Vector2D[] { v1.clone(), v2.clone(), v3.clone() });
		//this.vertices = new Vector2D[3];
		
		//this.vertices[0] = v1.clone();
		//this.vertices[1] = v2.clone();
		//this.vertices[2] = v3.clone();
		
		//Position = Vector2D.getCentre(new Vector2D[] { v1, v2, v3 });
	}
	

	/**
	 * Create new instance of a bounding triangle
	 */
	public BoundingTri(Vector2D position, Vector2D v1, Vector2D v2, Vector2D v3)
	{
		super(position, new Vector2D[] { v1.clone(), v2.clone(), v3.clone() });
		//this.vertices = new Vector2D[3];
		
		//this.vertices[0] = v1.clone();
		//this.vertices[1] = v2.clone();
		//this.vertices[2] = v3.clone();
	}

	
	/**
	 * Create new instance of a bounding triangle on lengths of 3 sides
	 */
	public BoundingTri(Vector2D position, float sidex, float sidey, float sidez)
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
		vertices = new Vector2D[3];
		vertices[0] = new Vector2D(0, height * -0.5f);
		vertices[1] = new Vector2D((float)Math.cos(AngleB) * sidey, height * 0.5f);
		vertices[2] = new Vector2D(-(float)Math.cos(AngleA) * sidex, height * 0.5f);

		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	
	

}
