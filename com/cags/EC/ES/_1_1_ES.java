/**
 * 
 */
package com.cags.EC.ES;

import java.util.ArrayList;
import java.util.List;
import com.cags.EC.Evolutionary_Computation;
import com.cags.EC.Individual;
import com.cags.EC.Mutation;

/**
 * 
 * -Real Representation.
 * -Auto Adaptation : standard deviation.
 * -Mutation : Gaussian.
 * -Selection : extinctive
 * (miu, lambda)-ES

 * @author Carlos Alejandro Gutiérrez Sandoval
 *
 */
public abstract class _1_1_ES<P> extends Evolutionary_Computation<P>{	

	protected double c=.85,p=0;
	protected Individual<Double> bestfitted;
	List<Individual<P>> population = new ArrayList<>();
	/**
	 * Requires by association, an Individual factory.
	 */
	protected IndividualFactory<P> IndividualFactory = null;
	/**
	 * Requires by association, a mutation method that returns a 1 if the offspring took place of the parent, 0 otherwise.
	 */	
	protected Mutation<P> mutator = null;
	
	protected _1_1_ES(int epochs, int individuals) {
		super(epochs,individuals);
	}
	
	protected _1_1_ES(int epochs, int individuals, Evolutionary_Computation.goal o) {
		super(epochs,individuals, o);		
	}
	
	public abstract Individual<P> getBest();

	public Mutation<P> getMutator() {
		return mutator;
	}

	public void setMutator(Mutation<P> mutator) {
		this.mutator = mutator;
	}

	public IndividualFactory<P> getIndividualFactory() {
		return IndividualFactory;
	}

	public void setIndividualFactory(IndividualFactory<P> individualFactory) {
		IndividualFactory = individualFactory;
	}
}
