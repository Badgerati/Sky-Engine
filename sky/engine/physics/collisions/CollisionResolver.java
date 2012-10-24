package sky.engine.physics.collisions;

import sky.engine.geometry.vectors.Vector2d;
import sky.engine.physics.bodies.RigidBody;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public abstract class CollisionResolver
{
	
	/**
	 * Resolves the collision of two RigidBodies. The bodies should be given
	 * in the same order that they were given for the CollisionDetector
	 */
	public static void resolve(Contact mtv, RigidBody body1, RigidBody body2)
	{
		//direction
		Vector2d dir = CollisionResolver.direction(body1, body2);
		//Vector2 dir = new Vector2(1, 1);
		
		//mass ratios
		float total_mass = body1.inverseMass() + body2.inverseMass();
		float ratio1 = 0, ratio2 = 0;
		
		if (body2.inverseMass() == 0)
		{
			ratio1 = 1;
			ratio2 = 0;
		}
		else if (body1.inverseMass() == 0)
		{
			ratio1 = 0;
			ratio2 = 1;
		}
		else
		{
			ratio1 = body2.inverseMass() / total_mass;
			ratio2 = body1.inverseMass() / total_mass;
		}
		
		
		//body1
		float bx1 = body1.getXPosition() + ((mtv.getOverlap() * mtv.getAxis().X * ratio1) * dir.X);
		float by1 = body1.getYPosition() + ((mtv.getOverlap() * mtv.getAxis().Y * ratio1) * dir.Y);
		body1.setPosition(bx1, by1);
		
		//body2
		float bx2 = body2.getXPosition() + ((mtv.getOverlap() * mtv.getAxis().X * ratio2) * -dir.X);
		float by2 = body2.getYPosition() + ((mtv.getOverlap() * mtv.getAxis().Y * ratio2) * -dir.Y);
		body2.setPosition(bx2, by2);
	}
	
	
	
	
	/**
	 * Returns a vector specifying the direction body1 needs to be moved in
	 */
	public static Vector2d direction(RigidBody body1, RigidBody body2)
	{
		Vector2d dv = body2.Velocity.sub(body1.Velocity);
		return new Vector2d(dv.X > 0 ? 1 : -1, dv.Y > 0 ? 1 : -1);
	}
	
	
	
	
	
	/**
	 * Reflects the body according to the normal axis
	 */
	public static void reflect(RigidBody body, Vector2d axis_normal)
	{		
		float dot = body.Velocity.dot(axis_normal);
		body.Velocity.X = body.Velocity.X - (1f + body.Friction) * axis_normal.X * dot;
		body.Velocity.Y = body.Velocity.Y - (1f + body.Restitution) * axis_normal.Y * dot;
	}
	
	
	
	
	
	/**
	 * Reflects the body after colliding with another body
	 */
	public static void reflect(RigidBody body1, RigidBody body2, Vector2d axis_normal)
	{
		Vector2d vrel = body1.Velocity.sub(body2.Velocity);
		float e1 = body1.Restitution;
		float e2 = body2.Restitution;
		float im = body1.inverseMass() + body2.inverseMass();

		float impulsex1 = (1f + e1) * axis_normal.X * (vrel.dot(axis_normal)) /  im;
		float impulsey1 = (1f + e1) * axis_normal.Y * (vrel.dot(axis_normal)) /  im;
		Vector2d impulse1 = new Vector2d(impulsex1, impulsey1);

		float impulsex2 = (1f + e2) * axis_normal.X * (vrel.dot(axis_normal)) /  im;
		float impulsey2 = (1f + e2) * axis_normal.Y * (vrel.dot(axis_normal)) /  im;
		Vector2d impulse2 = new Vector2d(impulsex2, impulsey2);

		body1.Velocity = body1.Velocity.sub(impulse1.mulScalar(body1.inverseMass()));
		body2.Velocity = body2.Velocity.add(impulse2.mulScalar(body2.inverseMass()));
	}
	
}
