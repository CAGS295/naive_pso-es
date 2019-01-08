package com.cags.EC;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Implements a Double phenotype with an ArrayList as the underlying container. Each position acts as a dimension (variable). 
 */
public class DoubleArrayPhenotype extends DoublePhenotype {	
	private double minValue;
	private double maxValue;
	private List<Double> valuesList = null;
	
	public DoubleArrayPhenotype(int length, double min, double max) {		
		this.minValue   = min;
		this.maxValue   = max;
		this.valuesList = new ArrayList<Double>(length);
		
		for(int i = 0; i < length; i ++) {
			this.valuesList.add(0.0);
		}
	}
	/**
	 * randomizes the phenotype within bounds [minValue,maxValue).
	 */
	public void randomize() {
		
		Random r = new Random();
		for(int i = 0 ; i < this.valuesList.size() ; i++) {
			this.valuesList.set( i , this.minValue + r.nextDouble() * (this.maxValue - this.minValue ) ) ;
		}
	}
	
	/** set a specific value for a dimension(variable).
	 * 
	 */
	@Override
	public void setValue(int index, Double value) {		
		this.valuesList.set(index, value);
	}
	/**
	 * get the value for a specific dimension (variable) using and index.
	 */
	@Override
	public Double getValue(int index) {		
		return this.valuesList.get(index);
	}
	/**
	 * number of dimensions (variables) contained by the phenotype.
	 */
	@Override
	public int length() {		
		return this.valuesList.size();
	}
	/**
	 * get Lower bound.
	 */
	@Override
	public Double getMinValue() {		
		return this.minValue;
	}
	/**
	 * get Upper bound.
	 */
	@Override
	public Double getMaxValue() { 		
		return this.maxValue;
	}
	/**
	 * get the phenotype representation as a List.
	 */
	@Override
	public List<Double> asList() {		
		return this.valuesList;
	}
	/**
	 * Clone a phenotype.
	 */
	@Override
	public Phenotype<Double> clone() {
		
		DoubleArrayPhenotype clone = new DoubleArrayPhenotype(this.length(), this.minValue, this.maxValue);		
		clone.valuesList = new ArrayList<Double>(this.valuesList);
		return clone;
	}		
}
