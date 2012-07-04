package sky.engine.physics.constraints;

import sky.engine.geometry.vectors.Vector2D;
import sky.engine.physics.bodies.RigidBody;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati).
 *
 */
public class DistanceConstraint extends Constraint
{
	/**
	 * Distance to constrain the bodies to
	 */
	public float Distance;
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create new instance of a Distance Constraint
	 */
	public DistanceConstraint(RigidBody bodyA, RigidBody bodyB, float distance)
	{
		super(bodyA, bodyB);
		Distance = distance;
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Solve the distance constraint
	 */
	@Override
	public void solve(float dt)
	{
		//required info
		Vector2D axis = bodyB.getPosition().sub(bodyA.getPosition());
		float currentDistance = axis.magnitude();
		Vector2D unitAxis = axis.mulScalar(1 / currentDistance);
		
		//calc relative velocity in axis, we want to remove this
		float relVelocity = bodyB.Velocity.sub(bodyA.Velocity).dot(unitAxis);
		float relDistance = currentDistance - Distance;
		
		//calc impulse to solve
		float remove = (relVelocity + relDistance);
		float impulse = remove / (bodyA.getInverseMass() + bodyB.getInverseMass());
		
		//impulse vector
		Vector2D impulseVec = unitAxis.mulScalar(impulse);
		
		//apply
		this.applyImpulse(impulseVec);
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Solve the distance constraint
	 */
	public static void solve(RigidBody bodyA, RigidBody bodyB, float distance, float dt)
	{
		//required info
		Vector2D axis = bodyB.getPosition().sub(bodyA.getPosition());
		float currentDistance = axis.magnitude();
		Vector2D unitAxis = axis.mulScalar(1 / currentDistance);
		
		//calc relative velocity in axis, we want to remove this
		float relVelocity = bodyB.Velocity.sub(bodyA.Velocity).dot(unitAxis);
		float relDistance = currentDistance - distance;
		
		//calc impulse to solve
		float remove = (relVelocity + relDistance);
		float impulse = remove / (bodyA.getInverseMass() + bodyB.getInverseMass());
		
		//impulse vector
		Vector2D impulseVec = unitAxis.mulScalar(impulse);
		
		//apply
		applyImpulse(bodyA, bodyB, impulseVec);
	}
	
	
	
	
	
	
	
	
	
	

}
