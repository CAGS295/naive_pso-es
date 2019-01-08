package com.cags.EC.ES;

import java.util.ArrayList;
import java.util.MissingResourceException;

import com.cags.EC.Evolutionary_Computation;
import com.cags.EC.Individual;
import com.cags.EC.ObjectiveFunction;


public class Double_1_1_ES extends _1_1_ES<Double> {

	protected Double_1_1_ES(int epochs, int individuals) {
		super(epochs, individuals);		
	}
	
	protected Double_1_1_ES(int epochs, int individuals, Evolutionary_Computation.goal o) {
		super(epochs, individuals, o);		
	}
	
	private void initPopulation() {
		super.population = new ArrayList<>(super.individuals);
		for(int i=0 ; i < super.individuals ; i++) {
			Individual<Double> np = super.IndividualFactory.create();
			super.population.add(np);	
		}
	}
	
	private void runEpochs() {
		int epoch = 0,counter=0,total=0;
		double probability=1./5, sigma=mutator.getSd();
		while(epoch++ < super.epochs) {			
			for(Individual<Double> dude:super.population) {
				total++;				
				if(epoch == 1) updateFitness(dude);
				counter+=mutator.mutate(dude, objectiveFunction);		
			}
			if(epoch % objectiveFunction.length() == 0) sigma=mutator.getSd(); 
			if( epoch % 10 * objectiveFunction.length() == 0 )  probability = counter/total;
			if(probability > 1./5) mutator.setSd(sigma/super.c);
			if(probability < 1./5) mutator.setSd(sigma*super.c);
			if(probability == 1./5) mutator.setSd(sigma);
		}
	}
	
	
	
	private void updateFitness(Individual<Double> p) {		
		double result = super.objectiveFunction.f(p.getPhenotype());		
		p.setFitness(result);		
	}
	
	/**
	 * Runs the ES until it reaches @epochs and save the fittest individual.
	 */
	public void run() {
		if(super.IndividualFactory == null)  throw new MissingResourceException("Missing","IndividualFactory<P>", "individualFactory");
		if(super.objectiveFunction == null) throw new MissingResourceException("Missing","ObjectiveFunction<P>", "objectiveFunction");
		if(super.mutator == null) throw new MissingResourceException("Missing","ObjectiveFunction<P>", "mutator");
		initPopulation();
		runEpochs();
		seekbest();
		}

	private void seekbest() {
		super.bestfitted=super.population.get(0);
		int i=0;
		if(this.g==Evolutionary_Computation.goal.MAXIMIZE) {
			for(i=0 ; i < super.population.size() ; i++) {
				if(bestfitted.getFitness() < super.population.get(i).getFitness()) bestfitted=super.population.get(i);
			}
		}
		else {
			for(i=0 ; i < super.population.size() ; i++) {
				if(bestfitted.getFitness() > super.population.get(i).getFitness()) bestfitted=super.population.get(i);
			}			
		}
	}	
	/**
	 * Get the Best Fitted Individual.
	 */
	public Individual<Double> getBest() {
		return super.bestfitted;
	}

	@Override
	public ObjectiveFunction<Double> getObjectiveFunction() {
		return super.objectiveFunction;
	}

	@Override
	public void setObjectiveFunction(ObjectiveFunction<Double> objectiveFunction) {
		super.objectiveFunction=objectiveFunction;
		
	}	

	
	

}
