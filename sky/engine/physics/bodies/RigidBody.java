package sky.engine.physics.bodies;

import sky.engine.geometry.vectors.Vector2d;

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
	protected Vector2d Position = null;
	
	
	/**
	 * velocity of the body
	 */
	public Vector2d Velocity = null;
	
	
	/**
	 * terminal velocity of the body
	 */
	public Vector2d TerminalVelocity = null;
	
	
	/**
	 * co-efficient of restitution of the body
	 */
	public float Restitution = 0;
	
	
	/**
	 * friction of the body
	 */
	public float Friction = 0;
	
	
	/**
	 * acceleration of the body
	 */
	public float Acceleration = 0;
	
	
	/**
	 * mass of the body
	 */
	protected float Mass = INFINITE_MASS;
	
	
	/**
	 * Inverse mass of this body
	 */
	protected float InverseMass = 0;
	
	
	
	

	
	
	/**
	 * Create instance of new RigidBody object.
	 * 
	 * @param position - Position of the body.
	 * @param velocity - Velocity of the body.
	 * @param mass - Current mass of the body (cannot be negative).
	 */
	public RigidBody(Vector2d position, Vector2d velocity, float mass)
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
	public RigidBody(Vector2d position)
	{
		Position = position.clone();
		Velocity = Vector2d.zeros();
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
	public void integrate(float x, float y, float dt)
	{
		Position.integrate(x * dt, y * dt);
	}
	
	
	/**
	 * Integrate the body in the direction of the given velocity
	 */
	public void integrate(Vector2d velocity, float dt)
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
	public Vector2d getPosition()
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
	public void setPosition(Vector2d position)
	{
		Position.X = position.X;
		Position.Y = position.Y;
	}

	
	/**
	 * Set the position of this body
	 */
	public void setPosition(float x, float y)
	{
		Position.X = x;
		Position.Y = y;
	}
	
	
	
	
	
	
	
	/**
	 * Set mass of body
	 */
	public void setMass(float mass)
	{
		if (mass == INFINITE_MASS) {
			Mass = INFINITE_MASS;
			InverseMass = 0f;
		}
		
		Mass = mass;
		InverseMass = 1.0f / mass;
	}
	
	
	
	/**
	 * Get mass of body
	 */
	public float mass()
	{
		return Mass;
	}

	
	
	
	
	
	/**
	 * Set inverse mass of body
	 */
	public void setInverseMass(float imass)
	{
		if (imass == 0) {
			Mass = INFINITE_MASS;
			InverseMass = 0f;
		}
		
		InverseMass = imass;
		Mass = 1.0f / imass;
	}
	
	
	/**
	 * Get inverse mass of body
	 */
	public float inverseMass()
	{
		return InverseMass;
	}
	
	
	

}
