package sky.engine.physics.constraints;

import sky.engine.geometry.vectors.Vector2D;
import sky.engine.physics.bodies.RigidBody;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public abstract class Constraint
{
	/**
	 * First body associated with this constraint
	 */
	protected RigidBody bodyA = null;
	
	
	/**
	 * Second body associated with this constraint
	 */
	protected RigidBody bodyB = null;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Constraint object
	 */
	public Constraint(RigidBody bodyA, RigidBody bodyB)
	{
		if (bodyA.getInverseMass() == 0 && bodyB.getInverseMass() == 0)
			throw new Error("Constraint between two infinite mass bodies not allowed");
		
		this.bodyA = bodyA;
		this.bodyB = bodyB;
	}
	
	
	
	
	
	

	
	
	
	/**
	 * Apply impulse
	 */
	public void applyImpulse(Vector2D impulse)
	{
		bodyA.Velocity = bodyA.Velocity.add(impulse.mulScalar(bodyA.getInverseMass()));
		bodyB.Velocity = bodyB.Velocity.sub(impulse.mulScalar(bodyB.getInverseMass()));
	}
	
	
	/**
	 * Apply impulse
	 */
	public static void applyImpulse(RigidBody bodyA, RigidBody bodyB, Vector2D impulse)
	{
		bodyA.Velocity = bodyA.Velocity.add(impulse.mulScalar(bodyA.getInverseMass()));
		bodyB.Velocity = bodyB.Velocity.sub(impulse.mulScalar(bodyB.getInverseMass()));
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Solve a constraint between the bodies
	 */
	public void solve(float dt)
	{
		throw new Error("Base class does not implement the solve() method");
	}
	
	
	
	
	
	
	
	
	

}
