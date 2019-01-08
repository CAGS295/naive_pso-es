package com.cags.EC.PSO;
import java.util.ArrayList;
import java.util.MissingResourceException;

/**
 * Implementation of PSO for Double.
 * 
 */
public class DoublePSO extends PSO<Double> {	
	
	/**
	 * 
	*@param epochs	number for iterations. This is the only stopping criterion. 
	* @param particles number of particles of the swarm.
	*/
	
	public DoublePSO(int epochs,int particles) {
		super(epochs,particles);	
	}
	
	public DoublePSO(goal o,int epochs,int particles) {
		super(epochs, particles,o);		
	}
	
	/**
	 * Primes an initial swarm using particleFactory.
	 */	
	private void initPopulation() {
		super.population = new ArrayList<>(super.individuals);
		for(int i=0 ; i < super.individuals ; i++) {
			Particle<Double> np = super.particleFactory.create();
			super.population.add(np);	
		}
	}
	
	private void runEpochs() {		
		int epoch=0;
		super.bestglobal=super.population.get(0);
		if(super.g == PSO.goal.MAXIMIZE) 	super.bestglobal.setFitness(Double.MIN_VALUE);
		else super.bestglobal.setFitness(Double.MAX_VALUE);
		
		while(epoch++ < super.epochs) {
			this.velocityFunction.setW(this.velocityFunction.getW() - 1/this.epochs);
			for(Particle<Double> particle : super.population) {
				updateFitness(particle);
				updateVelocity(particle);
				updatePosition(particle);
				
				}
			super.firstepoch=false;
			}
		}			

	private void updateFitness(Particle<Double> p) {
		
		double result = super.objectiveFunction.f(p.getPhenotype());		
		p.setFitness(result);
		if(super.firstepoch) p.bestlocal.setFitness(result);

		if( super.g == PSO.goal.MAXIMIZE && p.bestlocal.getFitness() < p.getFitness()) {

			p.bestlocal = p.clone();

			if( super.bestglobal.getFitness() < p.getFitness() ) {
				super.bestglobal = p.clone();
			}
		}
		if( super.g == PSO.goal.MINIMIZE && p.bestlocal.getFitness() > p.getFitness()) {
			p.bestlocal = p.clone();
			if( super.bestglobal.getFitness() > p.getFitness() ) {
				super.bestglobal = p.clone();
			}
		}
	}
	
	private void updateVelocity(Particle<Double> p) {		
		for(int i = 0 ; i < p.velocity.size() ; i++) {
			
			double nextVel = super.velocityFunction.f( p.velocity.get(i),  p.getPhenotype().get(i), p.bestlocal.getPhenotype().get(i),
					super.bestglobal.getPhenotype().get(i));
			p.velocity.set(i, nextVel);
		}		
	}
	
	private void updatePosition(Particle<Double> particle) {
		for(int i = 0 ; i < particle.velocity.size() ; i++) {
			Double newpos =  particle.velocity.get(i) + particle.getPhenotype().get(i);
			particle.getPhenotype().set(i, newpos); 
		}		
	}
	
	/**
	 * Runs the PSO until it reaches @epochs.
	 */
	public void run() {
		if(super.particleFactory == null)  throw new MissingResourceException("Missing","IndividualFactory<P>", "individualFactory");
		if(super.objectiveFunction == null) throw new MissingResourceException("Missing","ObjectiveFunction<P>", "objectiveFunction");
		if(super.velocityFunction == null) throw new MissingResourceException("Missing","VelocityFunction", "velocityFunction");
		initPopulation();
		runEpochs();
		System.out.println(super.bestglobal);
		}

	/**
	 * Get the Best Particle.
	 */
	@Override
	public Particle<Double> getBest() {

		return super.bestglobal;
	}	

}
