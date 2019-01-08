package com.cags.EC;

import java.util.List;


public class DoubleIndividual extends Individual<Double> {

	public DoubleIndividual(Phenotype<Double> dblphenotype) {
		super(dblphenotype);		
	}
	
	/**
	 * Uses StringBuilder() to build a string representation of the particle's phenotype and its fitness;
	 */
	public String toString() {
		

		StringBuilder sb = new StringBuilder();		
		sb.append('<');
		for(int v = 0; v < phenotype.length(); v ++) {
			sb.append(String.format(" %.8f", phenotype.getValue(v)));
			if(v < phenotype.length() - 1) sb.append(", ");
		}
		sb.append(String.format(">; Fitness:  %.6f \n", super.fitness));
		return sb.toString();
	}
	
	/**
	 * Clone method for a Double Individual.
	 */
	@Override
	public Individual<Double> clone() {		
		Individual<Double> clone = new DoubleIndividual(super.phenotype.clone()); 
		clone.setFitness(this.fitness);		
		return clone;
	}
	
	/**
	 * Outputs the Individual's phenotype as a Double List . 
	 */
	public List<Double> getPhenotype() {		
		return this.phenotype.asList();
	}
}
