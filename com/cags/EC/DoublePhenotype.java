package com.cags.EC;

/**
 * Degeneralizes Phenotype to Double.
 */
public abstract class DoublePhenotype extends Phenotype<Double> {
	
	
	@Override
	public abstract void setValue(int index, Double value);	
	@Override
	public abstract Double getValue(int index);	
}
