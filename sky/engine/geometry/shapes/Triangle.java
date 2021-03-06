package sky.engine.geometry.shapes;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.math.AngleHelper;

public class Triangle extends Polygon
{
	/**
	 * Length of side X of the triangle
	 */
	private float SideX;
	
	
	/**
	 * Length of side Y of the triangle
	 */
	private float SideY;
	
	
	/**
	 * Length of side Z of the triangle
	 */
	private float SideZ;
	
	
	/**
	 * Angle A of the triangle
	 */
	private float AngleA;
	
	
	/**
	 * Angle B of the triangle
	 */
	private float AngleB;
	
	
	/**
	 * Angle C of the triangle
	 */
	private float AngleC;
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Triangle on vertices
	 */
	public Triangle(Vector2d v1, Vector2d v2, Vector2d v3)
	{
		super(new Vector2d[] { v1, v2, v3 });
		build(v1, v2, v3);
	}

	
	/**
	 * Create new instance of a Triangle on lengths of 3 sides
	 */
	public Triangle(Vector2d position, float sidex, float sidey, float sidez)
	{
		super(position);
		build(sidex, sidey, sidez);
	}

	
	/**
	 * Create new instance of a Triangle on vertices
	 */
	//protected Triangle(Vector2d position, Vector2d v1, Vector2d v2, Vector2d v3, Vector2d velocity, float mass)
	//{
	//	super(position, new Vector2d[] { v1, v2, v3 }, velocity, mass);
	//	build(v1, v2, v3);
	//}

	
	/**
	 * Create new instance of a Triangle on vertices
	 */
	//public Triangle(Vector2d v1, Vector2d v2, Vector2d v3, Vector2d velocity, float mass)
	//{
	//	super(new Vector2d[] { v1, v2, v3 }, velocity, mass);
	//	build(v1, v2, v3);
	//}

	
	/**
	 * Create new instance of a Triangle on lengths of 3 sides - scalene
	 */
	//public Triangle(Vector2d position, float sidex, float sidey, float sidez, Vector2d velocity, float mass)
	//{
	//	super(position, velocity, mass);
	//	build(sidex, sidey, sidez);
	//}
	
	
	/**
	 * Create new instance of a Triangle from another triangle
	 */
	public Triangle(Triangle triangle)
	{
		super(triangle);
		
		SideX = triangle.SideX;
		SideY = triangle.SideY;
		SideZ = triangle.SideZ;
		AngleA = triangle.AngleA;
		AngleB = triangle.AngleB;
		AngleC = triangle.AngleC;
	}
	
	
	
	
	
	
	
	
	/**
	 * Clone this triangle
	 */
	@Override
	public Triangle clone()
	{
		return new Triangle(this);
	}
	
	
	
	
	
	
	/**
	 * Build the triangle from 3 vertices
	 */
	private void build(Vector2d v1, Vector2d v2, Vector2d v3)
	{
		//lengths of the sides
		SideX = v1.magnitude(v2);
		SideY = v2.magnitude(v3);
		SideZ = v3.magnitude(v1);
		
		//angles of the triangle
		float tempx = (SideX * SideX);
		float tempy = (SideY * SideY);
		float tempz = (SideZ * SideZ);
		
		AngleA = (float)Math.acos((tempx + tempz - tempy) / (2 * SideX * SideZ));
		AngleB = (float)Math.acos((tempy + tempz - tempx) / (2 * SideY * SideZ));
		AngleC = (float)Math.acos((tempy + tempx - tempz) / (2 * SideX * SideY));
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
		
		//lengths of the sides
		SideX = sidex;
		SideY = sidey;
		SideZ = sidez;
		
		//angles of the triangle
		float tempx = (SideX * SideX);
		float tempy = (SideY * SideY);
		float tempz = (SideZ * SideZ);
		
		AngleA = (float)Math.acos((tempx + tempz - tempy) / (2 * SideX * SideZ));
		AngleB = (float)Math.acos((tempy + tempz - tempx) / (2 * SideY * SideZ));
		AngleC = (float)Math.acos((tempy + tempx - tempz) / (2 * SideX * SideY));
		
		//height of triangle
		float height = sidex * AngleHelper.sin(AngleA);
		
		//vertices
		vertices = new Vector2d[3];
		vertices[0] = new Vector2d(0, height * -0.5f);
		vertices[1] = new Vector2d(AngleHelper.cos(AngleB) * sidey, height * 0.5f);
		vertices[2] = new Vector2d(-AngleHelper.cos(AngleA) * sidex, height * 0.5f);

		for (int i = 0; i < vertices.length; i++)
			vertices[i].integrate(Position);
	}
	
	
	
	
	
	
	
	/**
	 * Returns the perimeter of the triangle
	 */
	@Override
	public float perimeter()
	{
		return (SideX + SideY + SideZ);
	}
	
	
	
	
	
	
	
	/**
	 * Returns the area of the triangle
	 */
	@Override
	public float area()
	{
		return 0.5f * SideX * SideY * AngleHelper.sin(AngleC);
	}
	
	
	
	
	

	
	
	/**
	 * Returns the length of side X
	 */
	public float getSideX()
	{
		return SideX;
	}
	
	
	/**
	 * Returns the length of side Y
	 */
	public float getSideY()
	{
		return SideY;
	}
	
	
	/**
	 * Returns the length of side Z
	 */
	public float getSideZ()
	{
		return SideZ;
	}
	
	
	
	
	
	
	
	
	/**
	 * Returns the angle A
	 */
	public float getAngleA()
	{
		return AngleA;
	}
	
	
	/**
	 * Returns the angle B
	 */
	public float getAngleB()
	{
		return AngleB;
	}
	
	
	/**
	 * Returns the angle C
	 */
	public float getAngleC()
	{
		return AngleC;
	}
	
	
	
	

}
