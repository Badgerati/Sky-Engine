package sky.engine.physics.bodies;

import sky.engine.geometry.vectors.Vector2;

/**
 * A RigidBody is an object that has a position, velocity and mass.
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
	protected Vector2 Position = null;
	
	
	/**
	 * velocity of the body
	 */
	public Vector2 Velocity = null;
	
	
	/**
	 * mass of the body
	 */
	protected float Mass;
	
	
	/**
	 * Inverse mass of this body
	 */
	protected float InverseMass;
	
	
	
	
	
	
	
	/**
	 * Create instance of new RigidBody object.
	 * 
	 * @param position - Position of the body.
	 * @param velocity - Velocity of the body.
	 * @param mass - Current mass of the body (cannot be negative).
	 */
	public RigidBody(Vector2 position, Vector2 velocity, float mass)
	{
		if (mass < 0)
			throw new Error("Mass cannot be negative.");
		
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
	 * Create new instance of a RigidBody object, defaulted with zero velocity and
	 * infinite mass.
	 * 
	 * @param position - Position of the body.
	 */
	public RigidBody(Vector2 position)
	{
		Position = position.clone();
		Velocity = Vector2.zeros();
		Mass = INFINITE_MASS;
		InverseMass = 0;
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
	public void integrate(Vector2 velocity, float dt)
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
	public Vector2 getPosition()
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
	public void setPosition(Vector2 position)
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
