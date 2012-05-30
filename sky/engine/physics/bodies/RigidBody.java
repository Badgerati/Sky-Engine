package sky.engine.physics.bodies;

import sky.engine.geometry.Vector2D;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class RigidBody
{
	/**
	 * Constant for infinite mass
	 */
	public static final float INFINITE_MASS = 0xFFFFFF;
	
	
	/**
	 * position of the body
	 */
	protected Vector2D Position = null;
	
	
	/**
	 * velocity of the body
	 */
	public Vector2D Velocity = null;
	
	
	/**
	 * mass of the body
	 */
	protected float Mass;
	
	
	/**
	 * Inverse mass of this body
	 */
	protected float InverseMass;
	
	
	
	
	
	
	
	
	

	
	
	/**
	 * Create instance of new RigidBody
	 */
	public RigidBody(Vector2D position, Vector2D velocity, float mass)
	{
		if (mass < 0)
			throw new Error("Mass cannot be negative");
		
		Position = position.clone();
		Velocity = velocity.clone();
		Mass = mass;
		
		if (mass == 0)
			InverseMass = INFINITE_MASS;
		else if (mass == INFINITE_MASS)
			InverseMass = 0;
		else
			InverseMass = 1.0f / mass;
	}
	
	
	
	
	
	
	

	
	
	/**
	 * Integrate the body in the direction of its velocity
	 */
	public void integrate(float dt)
	{
		Position.integrate(Velocity.mulScalar(dt));
	}
	
	
	/**
	 * Integrate the body in the direction of the given velocity
	 */
	public void integrate(Vector2D velocity, float dt)
	{
		Position.integrate(velocity.mulScalar(dt));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Returns the X position of the body
	 */
	public float getXPosition()
	{
		return Position.X;
	}

	
	/**
	 * Returns the Y position of the body
	 */
	public float getYPosition()
	{
		return Position.Y;
	}

	
	/**
	 * Returns the position of the body
	 */
	public Vector2D getPosition()
	{
		return Position.clone();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Set the X position of this body
	 */
	public void setXPosition(float value)
	{
		Position.X = value;
	}

	
	/**
	 * Set the Y position of this body
	 */
	public void setYPosition(float value)
	{
		Position.Y = value;
	}

	
	/**
	 * Set the position of this body
	 */
	public void setPosition(Vector2D position)
	{
		Position.X = position.X;
		Position.Y = position.Y;
	}
	
	
	
	
	
	
	

	
	
	
	/**
	 * Set mass of body
	 */
	public void setMass(float mass)
	{
		Mass = mass;
		InverseMass = 1.0f / mass;
	}
	
	
	
	/**
	 * Get mass of body
	 */
	public float getMass()
	{
		return Mass;
	}

	
	
	
	/**
	 * Set inverse mass of body
	 */
	public void setInverseMass(float imass)
	{
		InverseMass = imass;
		Mass = 1.0f / imass;
	}
	
	
	/**
	 * Get inverse mass of body
	 */
	public float getInverseMass()
	{
		return InverseMass;
	}
	
	
	
	
	
	
	
	
	

}
