/**
 * 
 */
package com.cags.EC;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * @author Carlos Alejandro Gutiérrez Sandoval
 *
 */
public abstract class Evolutionary_Computation<P> {

	protected int epochs=0,individuals=0;
	protected boolean firstepoch=true;
	protected List<? extends Individual<P>> population;
	protected goal g=Evolutionary_Computation.goal.MINIMIZE;
	/**
	 * Enumeration that defines the optimization goal: Maximize or Minimize.
	 */
	public static enum goal{		
		MINIMIZE,MAXIMIZE}
	
	/**
	 * Requires, by association a objective function to optimize.
	 */
	protected ObjectiveFunction<P> objectiveFunction = null;

	
	/**
	 * 
	 */
	public Evolutionary_Computation() {
		// TODO Auto-generated constructor stub
	}
	protected Evolutionary_Computation(int epochs2, int particles) {
		this.epochs=epochs2;
		this.individuals=particles;
	}
	
	protected Evolutionary_Computation(int epochs2, int particles,Evolutionary_Computation.goal o) {
		this.epochs=epochs2;
		this.individuals=particles;
		this.g=o;
	}
	public int getEpochs() {
		return this.epochs;
	}
	
	public void setEpochs(int epochs) {
		if(epochs<1) throw new InvalidParameterException("Epochs must be greater than 1.");
		this.epochs = epochs;
	}	

	public int getIndividuals() {
		return this.individuals;
	}	

	public void setIndividuals(int particles) {
		if(particles<1) throw new InvalidParameterException("Particles must be greater than 1.");
		this.individuals = particles;
	}
	public abstract ObjectiveFunction<P> getObjectiveFunction();
	public abstract void setObjectiveFunction(ObjectiveFunction<P> objectiveFunction);

}
