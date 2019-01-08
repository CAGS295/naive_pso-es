package com.cags.EC.ES;

import java.security.InvalidParameterException;

import com.cags.EC.DoubleArrayPhenotype;
import com.cags.EC.DoubleIndividual;
import com.cags.EC.Individual;
import com.cags.EC.Phenotype;


public class DoubleIndividualFactory extends IndividualFactory<Double> {

	private int nComponents;
	private double minValue, maxValue;
	
	public DoubleIndividualFactory(int nComponents, double min, double max) {		
		this.setnComponents(nComponents);
		this.minValue    = min;
		this.maxValue    = max;
	}		
	/**
	 * Creates a new Individual with a random position within bounds set by the phenotype. Fitness defaults to 0.0.
	 */
	@Override
	public Individual<Double> create() {		
		Phenotype<Double>   phenotype  = new DoubleArrayPhenotype(this.nComponents, this.minValue, this.maxValue);
		phenotype.randomize();	
		Individual<Double> nindividual = new DoubleIndividual(phenotype);				
		return nindividual;
	}
	public void setnComponents(int nComponents) throws InvalidParameterException{
		if(nComponents<1) throw new InvalidParameterException("nComponents must be greater than 0");
		this.nComponents = nComponents;
	}

}
