package com.cags.EC.PSO;
import com.cags.EC.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Particle Swarm Optimization. Supports multidemensional optimizatión; Maximization and Minimization.
 * The continuous optimization problem can be stated as follows:
 * 1. Create a ‘population’ of agents (called particles) uniformly distributed over X .
 * 2. Evaluate each particle’s position according to the objective function.
 * 3. If a particle’s current position is better than its previous best position, update it.
 * 4. Determine the best particle (according to the particle’s previous best positions).
 * 5. Update particles’ velocities.
 * 6. Move particles to their new positions according to velocity function.
 * 7. Go to step 2 until stopping criteria are satisfied.
*/

public abstract class PSO<P> extends Evolutionary_Computation<P> {	
	
	List<Particle<P>> population = new ArrayList<>();
	protected Particle<P> bestglobal;	
	
	
	 PSO(int epochs,int particles){
		 super(epochs,particles);
	 }
	
	 PSO(int epochs,int particles,goal o){
		 this(epochs,particles);
		 setGoal(o);
	 }
	
	/**
	 * Requires by association, a particle factory.
	 */
	protected ParticleFactory<P> particleFactory = null;
	/**
	 * Requires by association, a velocity function for the swarm.
	 */
	protected VelocityFunction velocityFunction = null;

	
	
	public goal getGoal() {
		return super.g;
	}
	
	public void setGoal(goal g) {
		super.g = g;
	}
	
	public ParticleFactory<P> getIndividualFactory() {
		return particleFactory;
	}
	
	public void setIndividualFactory(ParticleFactory<P> individualFactory) {
		this.particleFactory = individualFactory;
	}
	
	public ObjectiveFunction<P> getObjectiveFunction() {
		return objectiveFunction;
	}
	
	public void setObjectiveFunction(ObjectiveFunction<P> objectiveFunction) {
		this.objectiveFunction = objectiveFunction;
	}
	
	public VelocityFunction getVelocityFunction() {
		return velocityFunction;
	}
	
	public void setVelocityFunction(VelocityFunction velocityFunction) {
		this.velocityFunction = velocityFunction;
	}
	
	public abstract Particle<P> getBest();
	
	/**
	 * returns the current population.
	 */
	public List<Particle<P>> getSwarm() {
		
		return this.population;
	}
	
	/**
	 * Set a population.
	 */
	public void setSwarm(List<Particle<P>> swarm) {
		
		this.population = swarm;
	}	
}